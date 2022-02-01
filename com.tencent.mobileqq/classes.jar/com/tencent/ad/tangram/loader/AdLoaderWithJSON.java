package com.tencent.ad.tangram.loader;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdSettings;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public final class AdLoaderWithJSON
{
  private static final String TAG = "AdLoaderWithJSON";
  
  public static int getErrorCode(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == -2147483648) {
      return 3;
    }
    int i = 5;
    if (paramInt1 != 200) {
      return 5;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 == 1) {
        i = 4;
      }
      return i;
    }
    if (paramInt3 != 0)
    {
      if (paramInt3 == 102006) {
        i = 101;
      }
      return i;
    }
    return 0;
  }
  
  public static void load(AdLoaderWithJSON.Session paramSession)
  {
    AdLog.i("AdLoaderWithJSON", "load");
    String str;
    if ((paramSession != null) && (paramSession.request != null)) {
      str = paramSession.request.toString();
    } else {
      str = null;
    }
    AdLog.i("AdLoaderWithJSON", String.format("load request:%s", new Object[] { str }));
    if ((paramSession != null) && (paramSession.canSend()))
    {
      AdHttp.Params localParams = new AdHttp.Params();
      if (AdSettings.isTestMode()) {
        localParams.setUrl("https://ttc.gdt.qq.com/api/gdt.display.QQAdService.GetAds");
      } else {
        localParams.setUrl("https://v6mi.gdt.qq.com/api/gdt.display.QQAdService.GetAds");
      }
      localParams.method = "POST";
      localParams.contentType = "application/json";
      localParams.requestData = str.getBytes();
      if (localParams.canSend())
      {
        long l = System.currentTimeMillis();
        AdHttp.send(localParams);
        paramSession.timeMillis = (System.currentTimeMillis() - l);
        paramSession.httpResponseCode = localParams.responseCode;
        AdLog.i("AdLoaderWithJSON", String.format("load responseCode:%d", new Object[] { Integer.valueOf(paramSession.httpResponseCode) }));
        if ((localParams.responseCode == 200) && (localParams.responseData != null))
        {
          str = new String(localParams.responseData);
          AdLog.i("AdLoaderWithJSON", String.format("load response:%s", new Object[] { str }));
          try
          {
            paramSession.response = new JSONObject(str);
            return;
          }
          catch (JSONException paramSession)
          {
            AdLog.e("AdLoaderWithJSON", "load", paramSession);
          }
        }
      }
    }
    AdLog.e("AdLoaderWithJSON", "load error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoaderWithJSON
 * JD-Core Version:    0.7.0.1
 */