package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
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
        JSONObject localJSONObject = new JSONObject();
        if (paramVarArgs != null)
        {
          localJSONObject.put("lat", paramVarArgs[0]);
          localJSONObject.put("lon", paramVarArgs[1]);
        }
        else
        {
          localJSONObject.put("lat", JSONObject.NULL);
          localJSONObject.put("lon", JSONObject.NULL);
        }
        if (paramGdtAdWebPlugin == null) {
          continue;
        }
        paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Throwable paramString)
      {
        continue;
      }
      GdtLog.d("GdtLocationJsCallHandler", "handleJsCallRequest", paramString);
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.a();
      } else {
        paramString = null;
      }
      paramVarArgs = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramVarArgs = paramGdtAdWebPlugin.a();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramString, false, "getLocation", paramVarArgs);
      return true;
      paramVarArgs = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLocationJsCallHandler
 * JD-Core Version:    0.7.0.1
 */