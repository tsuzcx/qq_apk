package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qw.fa;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qy.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "response", "call"}, k=3, mv={1, 1, 16})
final class c$a<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  c$a(fa paramfa) {}
  
  public final fb a(fb paramfb)
  {
    a locala = a.a;
    fa localfa = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramfb, "response");
    locala.a((com.tencent.luggage.wxa.qy.b)new h(localfa, paramfb));
    return paramfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.c.a
 * JD-Core Version:    0.7.0.1
 */