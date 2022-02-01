package com.tencent.luggage.wxa.cs;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.y;
import com.tencent.luggage.wxa.nl.a.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "newConfig", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "", "onResult", "com/tencent/luggage/jsapi/version/JsApiUpdateApp$invoke$1$3"}, k=3, mv={1, 1, 16})
final class a$d<T extends c>
  implements a.a<c>
{
  a$d(com.tencent.luggage.wxa.iu.d paramd, c paramc, a parama, b paramb, int paramInt) {}
  
  public final void a(@Nullable c paramc, com.tencent.luggage.wxa.ou.d paramd, int paramInt)
  {
    if (paramc != null)
    {
      this.b.E = paramc.E;
      this.b.F = paramc.F;
      this.b.n = paramc.n;
      this.b.p = paramc.p;
      this.b.H = paramc.H;
      this.b.k = paramc.k;
      this.b.u = com.tencent.luggage.wxa.dw.d.a;
      y.a(this.a, this.b);
      return;
    }
    ((Function0)new a.d.1(this)).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cs.a.d
 * JD-Core Version:    0.7.0.1
 */