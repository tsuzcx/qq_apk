package com.tencent.gdtad.jsbridge;

import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONException;
import org.json.JSONObject;

class GdtOSVersionJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramGdtAdWebPlugin != null) {}
    for (paramVarArgs = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      GdtLog.d("GdtOSVersionJsCall", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("osVersion", Build.VERSION.RELEASE);
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramGdtAdWebPlugin != null) {
            paramString = paramGdtAdWebPlugin.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getOSVersion", paramString);
          return true;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtOSVersionJsCallHandler
 * JD-Core Version:    0.7.0.1
 */