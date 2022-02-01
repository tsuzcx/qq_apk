package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import org.json.JSONObject;

class GdtLocationJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramGdtAdWebPlugin != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramGdtAdWebPlugin.a();
        paramVarArgs = GdtLocationUtil.a(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        if (paramGdtAdWebPlugin != null) {
          paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
        }
      }
      catch (Throwable paramString)
      {
        JSONObject localJSONObject;
        GdtLog.d("GdtLocationJsCallHandler", "handleJsCallRequest", paramString);
        continue;
        paramString = null;
        continue;
      }
      if (paramGdtAdWebPlugin == null) {
        continue;
      }
      paramString = paramGdtAdWebPlugin.a();
      paramVarArgs = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramVarArgs = paramGdtAdWebPlugin.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getLocation", paramVarArgs);
      return true;
      paramVarArgs = null;
      continue;
      localJSONObject.put("lat", JSONObject.NULL);
      localJSONObject.put("lon", JSONObject.NULL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLocationJsCallHandler
 * JD-Core Version:    0.7.0.1
 */