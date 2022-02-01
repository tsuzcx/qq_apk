package com.tencent.luggage.wxa.cl;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "it", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class a$b$b<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  a$b$b(com.tencent.luggage.wxa.nn.a parama, com.tencent.luggage.wxa.iu.b paramb) {}
  
  @NotNull
  public final c a(c paramc)
  {
    com.tencent.luggage.wxa.eo.a locala = new com.tencent.luggage.wxa.eo.a(paramc.p());
    paramc = this.a;
    c localc = (c)locala;
    paramc.a(localc);
    paramc = this.b.q();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "component.runtime");
    h localh = paramc.B();
    paramc = localh;
    if (!(localh instanceof com.tencent.luggage.wxa.eo.a)) {
      paramc = null;
    }
    paramc = (com.tencent.luggage.wxa.eo.a)paramc;
    if (paramc != null) {
      paramc = paramc.w;
    } else {
      paramc = null;
    }
    locala.w = paramc;
    paramc = this.b.q();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "component.runtime");
    localh = paramc.B();
    paramc = localh;
    if (!(localh instanceof c)) {
      paramc = null;
    }
    paramc = (c)paramc;
    if ((paramc != null) && (paramc.s == true)) {
      locala.s = true;
    }
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cl.a.b.b
 * JD-Core Version:    0.7.0.1
 */