package com.tencent.luggage.wxa.ct;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class b$c$1
  implements Runnable
{
  b$c$1(b.c paramc) {}
  
  public final void run()
  {
    m localm = this.a.b;
    if (localm != null)
    {
      ((a)localm).a((c)this.a.a, this.a.c, this.a.d);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandAsyncJsApi<com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponent>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.b.c.1
 * JD-Core Version:    0.7.0.1
 */