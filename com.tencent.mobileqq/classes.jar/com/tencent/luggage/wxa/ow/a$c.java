package com.tencent.luggage.wxa.ow;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.au;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckShortLinkResp;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class a$c<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  a$c(Function2 paramFunction2) {}
  
  public final void a(au paramau)
  {
    if (paramau.z.a != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAsync cig fail. Ret[");
      ((StringBuilder)localObject).append(paramau.z.a);
      ((StringBuilder)localObject).append("]  ErrMsg[");
      ((StringBuilder)localObject).append(paramau.z.b);
      ((StringBuilder)localObject).append(']');
      o.b("MicroMsg.CgiCheckWxaShortLink", ((StringBuilder)localObject).toString());
      this.a.invoke(Boolean.valueOf(false), null);
      return;
    }
    o.d("MicroMsg.CgiCheckWxaShortLink", "checkAsync cig success.");
    Object localObject = this.a;
    b.a locala = b.a;
    Intrinsics.checkExpressionValueIsNotNull(paramau, "resp");
    ((Function2)localObject).invoke(Boolean.valueOf(true), locala.a(paramau));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ow.a.c
 * JD-Core Version:    0.7.0.1
 */