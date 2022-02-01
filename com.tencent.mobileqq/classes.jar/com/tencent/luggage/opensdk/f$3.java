package com.tencent.luggage.opensdk;

import android.text.TextUtils;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;

class f$3
  implements e.c<String>
{
  f$3(f paramf, b paramb, int paramInt) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      o.d("Luggage.OpenSDKBridgedJsApi", "result is empty, appId[%s] callbackId[%d]", new Object[] { this.a.getAppId(), Integer.valueOf(this.b) });
      paramString = this.c;
      f.a(paramString, this.a, this.b, paramString.b("fail:internal error"));
      return;
    }
    String str = this.c.a(paramString);
    o.d("Luggage.OpenSDKBridgedJsApi", "appId:%s callbackId:%d result:%s, processedResult:%s", new Object[] { this.a.getAppId(), Integer.valueOf(this.b), paramString, str });
    f.a(this.c, this.a, this.b, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.f.3
 * JD-Core Version:    0.7.0.1
 */