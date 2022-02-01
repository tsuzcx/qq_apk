package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;

class f$5
  implements com.tencent.luggage.wxa.rl.b<String, String>
{
  f$5(f paramf, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  public String a(String paramString)
  {
    WXLaunchMiniProgram.Req localReq = new WXLaunchMiniProgram.Req();
    localReq.userName = f.a(this.a);
    if (af.c(localReq.userName))
    {
      o.b("Luggage.OpenSDKBridgedJsApi", "invoke fail, username is empty");
      h.b().a("fail:internal error");
      return null;
    }
    localReq.miniprogramType = this.a.q().ab();
    localReq.extData = f.a(this.c, paramString);
    localReq.path = "__wx__/open-api-redirecting-page";
    o.e("Luggage.OpenSDKBridgedJsApi", "params:%s", new Object[] { localReq.extData });
    paramString = h.c();
    f.a(this.b, localReq, new f.5.1(this, paramString));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.f.5
 * JD-Core Version:    0.7.0.1
 */