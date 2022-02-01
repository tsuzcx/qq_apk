package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class f$5$1
  implements f.a
{
  f$5$1(f.5 param5, com.tencent.luggage.wxa.ro.b paramb) {}
  
  public void a(String paramString)
  {
    if (af.c(paramString))
    {
      o.b("Luggage.OpenSDKBridgedJsApi", "invokeByOpenSdk result is empty, name[%s] appId[%s] callbackId[%d]", new Object[] { this.b.c.d(), this.b.a.getAppId(), Integer.valueOf(this.b.b) });
      this.a.a("fail:internal error");
      return;
    }
    this.a.a(new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.f.5.1
 * JD-Core Version:    0.7.0.1
 */