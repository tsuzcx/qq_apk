package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceUtil;
import org.json.JSONException;
import org.json.JSONObject;

class GdtCarrierJsCallHandler
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
        localJSONObject.put("carrier", GdtDeviceUtil.b(paramVarArgs));
      }
      catch (JSONException localJSONException)
      {
        GdtLog.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", localJSONException);
      }
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Throwable paramString)
      {
        GdtLog.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", paramString);
      }
      paramString = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.b();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramVarArgs, false, "getCarrier", paramString);
      return true;
    }
    GdtLog.d("GdtCarrierJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtCarrierJsCallHandler
 * JD-Core Version:    0.7.0.1
 */