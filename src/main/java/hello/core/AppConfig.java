package hello.core;

import hello.core.discount.*;
import hello.core.member.*;
import hello.core.order.*;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  private static MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public static DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }
}
