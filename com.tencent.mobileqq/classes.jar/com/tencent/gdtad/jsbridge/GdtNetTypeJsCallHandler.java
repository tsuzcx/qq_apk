package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
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
    if (paramGdtAdWebPlugin != null) {
      paramVarArgs = paramGdtAdWebPlugin.a();
    } else {
      paramVarArgs = null;
    }
    if ((paramGdtAdWebPlugin != null) && (paramVarArgs != null))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("netType", GdtNetUtil.a(paramVarArgs));
      }
      catch (JSONException localJSONException)
      {
        GdtLog.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", localJSONException);
      }
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Throwable paramString)
      {
        GdtLog.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error", paramString);
      }
      paramString = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.a();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramVarArgs, false, "getNetType", paramString);
      return true;
    }
    GdtLog.d("GdtNetTypeJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtNetTypeJsCallHandler
 * JD-Core Version:    0.7.0.1
 */