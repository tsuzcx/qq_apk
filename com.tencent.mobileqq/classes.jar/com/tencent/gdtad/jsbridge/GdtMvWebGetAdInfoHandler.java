package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class GdtMvWebGetAdInfoHandler
  extends GdtMvWebJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Activity localActivity;
    if (paramGdtAdWebPlugin != null) {
      localActivity = paramGdtAdWebPlugin.a();
    } else {
      localActivity = null;
    }
    if ((paramGdtAdWebPlugin != null) && (localActivity != null))
    {
      try
      {
        String str1 = new JSONObject(paramVarArgs[0]).optString("traceId");
      }
      catch (Throwable localThrowable)
      {
        QLog.i("WebGdtMvWebGetAdInfoHandler", 1, "json", localThrowable);
        str2 = "";
      }
      String str2 = String.format("{\"adInfo\":%s}", new Object[] { a(str2) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("args=");
      localStringBuilder.append(paramVarArgs[0]);
      localStringBuilder.append(",result=");
      localStringBuilder.append(str2);
      QLog.i("WebGdtMvWebGetAdInfoHandler", 1, localStringBuilder.toString());
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { str2 });
      }
      catch (Throwable paramString)
      {
        QLog.i("WebGdtMvWebGetAdInfoHandler", 1, "callJs", paramString);
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "getAdInfo", paramGdtAdWebPlugin.a());
      return true;
    }
    QLog.i("WebGdtMvWebGetAdInfoHandler", 1, "webPlugin == null || activity == null");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebGetAdInfoHandler
 * JD-Core Version:    0.7.0.1
 */