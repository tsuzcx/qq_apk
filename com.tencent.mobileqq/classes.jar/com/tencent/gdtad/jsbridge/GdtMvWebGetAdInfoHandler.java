package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class GdtMvWebGetAdInfoHandler
  extends GdtMvWebJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (localActivity = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (localActivity == null); localActivity = null)
    {
      QLog.i("WebGdtMvWebGetAdInfoHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    localObject = "";
    try
    {
      String str = new JSONObject(paramVarArgs[0]).optString("traceId");
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { localObject });
        AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "getAdInfo", paramGdtAdWebPlugin.a());
        return true;
        localThrowable = localThrowable;
        QLog.i("WebGdtMvWebGetAdInfoHandler", 1, "json", localThrowable);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.i("WebGdtMvWebGetAdInfoHandler", 1, "callJs", paramString);
        }
      }
    }
    localObject = String.format("{\"adInfo\":%s}", new Object[] { a((String)localObject) });
    QLog.i("WebGdtMvWebGetAdInfoHandler", 1, "args=" + paramVarArgs[0] + ",result=" + (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebGetAdInfoHandler
 * JD-Core Version:    0.7.0.1
 */