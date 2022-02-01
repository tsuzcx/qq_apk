package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;

class u$5
  implements Runnable
{
  u$5(u paramu) {}
  
  public void run()
  {
    if (!this.a.d())
    {
      o.b("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", new Object[] { this.a.getAppId(), this.a.an() });
      return;
    }
    this.a.q().ao().a(u.i(this.a));
    if (this.a.S() != null) {
      this.a.S().k();
    }
    this.a.at();
    this.a.P();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.5
 * JD-Core Version:    0.7.0.1
 */