package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.qz.o;

class e$2
  implements c.a
{
  e$2(e parame, k paramk) {}
  
  public void a(String paramString, b paramb)
  {
    if (paramb == b.d)
    {
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.DESTROYED, uninit");
      this.a.k();
      return;
    }
    if (paramb == b.c)
    {
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.SUSPEND, suspendListening");
      this.a.e();
      return;
    }
    if (paramb == b.a)
    {
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.FOREGROUND, resumeListening");
      this.a.f();
      return;
    }
    if (paramb == b.b)
    {
      if (!this.a.a())
      {
        o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, stopListening");
        this.a.h();
        return;
      }
      o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, do nothing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.e.2
 * JD-Core Version:    0.7.0.1
 */