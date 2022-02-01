package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceUtil;
import org.json.JSONException;
import org.json.JSONObject;

class GdtDeviceIdJsCallHandler
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
        localJSONObject.put("deviceId", GdtDeviceUtil.a(paramVarArgs));
      }
      catch (JSONException localJSONException)
      {
        GdtLog.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", localJSONException);
      }
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Throwable paramString)
      {
        GdtLog.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", paramString);
      }
      paramString = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.a();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramVarArgs, false, "getDeviceId", paramString);
      return true;
    }
    GdtLog.d("GdtDeviceJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceIdJsCallHandler
 * JD-Core Version:    0.7.0.1
 */