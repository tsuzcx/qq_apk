package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.qz.o;

class f$2
  implements c.a
{
  f$2(f paramf, k paramk) {}
  
  public void a(String paramString, b paramb)
  {
    if (paramb == b.d)
    {
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.DESTROYED, uninit");
      this.a.k();
      return;
    }
    if (paramb == b.c)
    {
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.SUSPEND, suspendListening");
      this.a.e();
      return;
    }
    if (paramb == b.a)
    {
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.FOREGROUND, resumeListening");
      this.a.f();
      return;
    }
    if (paramb == b.b)
    {
      if (!this.a.a())
      {
        o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, stopListening");
        this.a.h();
        return;
      }
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "AppRunningState.BACKGROUND, do nothing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.f.2
 * JD-Core Version:    0.7.0.1
 */