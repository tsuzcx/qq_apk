package com.tencent.luggage.wxa.fy;

import android.app.Activity;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.or.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;

class a$2
  implements f.c
{
  a$2(a parama, u paramu) {}
  
  public void d()
  {
    o.e("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy");
    Activity localActivity = this.a.Y();
    if (localActivity == null)
    {
      o.c("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy, null == activity");
      return;
    }
    h.a(localActivity).b(a.d(this.b));
    this.a.b(a.e(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.a.2
 * JD-Core Version:    0.7.0.1
 */