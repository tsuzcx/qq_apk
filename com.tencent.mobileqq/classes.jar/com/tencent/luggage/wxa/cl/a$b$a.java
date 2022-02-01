package com.tencent.luggage.wxa.cl;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "config", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class a$b$a<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  a$b$a(a.b paramb, com.tencent.luggage.wxa.nn.a parama) {}
  
  @Nullable
  public final c a(c paramc)
  {
    if (paramc != null)
    {
      if (2 == this.b.d)
      {
        d locald = h.a(paramc);
        String str = this.b.b;
        Intrinsics.checkExpressionValueIsNotNull(str, "params.appId");
        h.a((e)locald.b((com.tencent.luggage.wxa.rl.b)new com.tencent.luggage.wxa.cx.a(str)));
      }
      return paramc;
    }
    paramc = this.a;
    h.b().a(null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cl.a.b.a
 * JD-Core Version:    0.7.0.1
 */