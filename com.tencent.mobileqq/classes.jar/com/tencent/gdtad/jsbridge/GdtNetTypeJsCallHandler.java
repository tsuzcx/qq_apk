package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtNetUtil;
import org.json.JSONException;
import org.json.JSONObject;

class GdtNetTypeJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramGdtAdWebPlugin != null) {}
    for (paramVarArgs = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      GdtLog.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("netType", GdtNetUtil.a(paramVarArgs));
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
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getNetType", paramString);
          return true;
          localJSONException = localJSONException;
          GdtLog.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          GdtLog.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtNetTypeJsCallHandler
 * JD-Core Version:    0.7.0.1
 */