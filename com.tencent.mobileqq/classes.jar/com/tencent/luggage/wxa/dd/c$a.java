package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "res", "Lcom/tencent/luggage/login/account/SessionInfo;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class c$a<T>
  implements e.c<g>
{
  c$a(b.c paramc) {}
  
  public final void a(g paramg)
  {
    o.e(c.a(c.a), "authorized succedeed, oauthCode=%s", new Object[] { paramg.d() });
    b.c localc = this.a;
    if (localc != null)
    {
      g localg = new g();
      localg.c(paramg.e());
      localg.b(paramg.c());
      localg.a(paramg.a());
      localg.b(paramg.d());
      localg.c(paramg.f());
      localc.a(localg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.c.a
 * JD-Core Version:    0.7.0.1
 */