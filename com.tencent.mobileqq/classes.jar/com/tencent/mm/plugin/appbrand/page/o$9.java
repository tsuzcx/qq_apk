package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.jx.f.g;
import com.tencent.luggage.wxa.qz.af;

class o$9
  implements f.g
{
  o$9(o paramo, long paramLong, bg parambg, String paramString, m paramm, o.c paramc) {}
  
  public void a()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPageContainer", "navigateToNext, onReady cost[%dms], appId[%s] type[%s], url[%s]", new Object[] { Long.valueOf(af.b() - this.a), this.f.getAppId(), this.b, this.c });
    this.d.getCurrentPageView().b(this);
    this.f.removeCallbacks(this.e);
    this.f.post(this.e);
    this.f.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.9
 * JD-Core Version:    0.7.0.1
 */