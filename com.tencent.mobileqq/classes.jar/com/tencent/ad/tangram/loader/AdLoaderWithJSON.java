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
    int j = 5;
    int i;
    if (paramInt1 == -2147483648) {
      i = 3;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt1 != 200);
        if (paramInt2 == 0) {
          break;
        }
        i = j;
      } while (paramInt2 != 1);
      return 4;
      if (paramInt3 == 0) {
        break;
      }
      i = j;
    } while (paramInt3 != 102006);
    return 101;
    return 0;
  }
  
  public static void load(AdLoaderWithJSON.Session paramSession)
  {
    AdLog.i("AdLoaderWithJSON", "load");
    if ((paramSession != null) && (paramSession.request != null)) {}
    for (String str = paramSession.request.toString();; str = null)
    {
      AdLog.i("AdLoaderWithJSON", String.format("load request:%s", new Object[] { str }));
      if ((paramSession != null) && (paramSession.canSend())) {
        break;
      }
      AdLog.e("AdLoaderWithJSON", "load error");
      return;
    }
    AdHttp.Params localParams = new AdHttp.Params();
    if (AdSettings.isTestMode()) {
      localParams.setUrl("https://ttc.gdt.qq.com/api/gdt.display.QQAdService.GetAds");
    }
    for (;;)
    {
      localParams.method = "POST";
      localParams.contentType = "application/json";
      localParams.requestData = str.getBytes();
      if (!localParams.canSend()) {
        break;
      }
      long l = System.currentTimeMillis();
      AdHttp.send(localParams);
      paramSession.timeMillis = (System.currentTimeMillis() - l);
      paramSession.httpResponseCode = localParams.responseCode;
      AdLog.i("AdLoaderWithJSON", String.format("load responseCode:%d", new Object[] { Integer.valueOf(paramSession.httpResponseCode) }));
      if ((localParams.responseCode != 200) || (localParams.responseData == null)) {
        break;
      }
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
      break;
      localParams.setUrl("https://v6mi.gdt.qq.com/api/gdt.display.QQAdService.GetAds");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoaderWithJSON
 * JD-Core Version:    0.7.0.1
 */