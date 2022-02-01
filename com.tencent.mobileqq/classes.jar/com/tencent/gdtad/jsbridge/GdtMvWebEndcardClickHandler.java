package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONObject;

class GdtMvWebEndcardClickHandler
  extends GdtMvWebJsCallHandler
{
  private final int a = 1;
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (localActivity = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (localActivity == null); localActivity = null)
    {
      QLog.i("WebGdtMvWebEndcardClickHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    QLog.i("WebGdtMvWebEndcardClickHandler", 1, "args=" + Arrays.toString(paramVarArgs));
    String str = "";
    localObject = str;
    try
    {
      QLog.i("WebGdtMvWebEndcardClickHandler", 1, "args = " + paramVarArgs[0]);
      localObject = str;
      JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
      localObject = str;
      paramVarArgs = localJSONObject.optString("antiSpam");
      localObject = paramVarArgs;
      int i = localJSONObject.optInt("atd");
      if (i != 1) {
        break label182;
      }
      bool = true;
    }
    catch (Throwable paramVarArgs)
    {
      try
      {
        for (;;)
        {
          paramGdtAdWebPlugin.callJs(paramString, new String[] { "" });
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleRewardVideoClick", paramGdtAdWebPlugin.a());
          return true;
          bool = false;
        }
        paramVarArgs = paramVarArgs;
        QLog.i("WebGdtMvWebEndcardClickHandler", 1, "json", paramVarArgs);
        paramVarArgs = (String[])localObject;
        boolean bool = false;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.i("WebGdtMvWebEndcardClickHandler", 1, "callJs", paramString);
        }
      }
    }
    a(paramVarArgs, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebEndcardClickHandler
 * JD-Core Version:    0.7.0.1
 */