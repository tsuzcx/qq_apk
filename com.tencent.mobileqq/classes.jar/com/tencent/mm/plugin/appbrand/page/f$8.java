package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.jx.f.g;
import com.tencent.luggage.wxa.qz.o;

class f$8
  implements f.g
{
  f$8(f paramf, u paramu, f.c paramc, long paramLong, String paramString) {}
  
  public void a()
  {
    this.a.b(this);
    this.b.run();
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    o.d("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { this.e.getAppId(), this.d, Long.valueOf(l1 - l2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f.8
 * JD-Core Version:    0.7.0.1
 */