package com.tencent.gdtad.jsbridge;

import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONException;
import org.json.JSONObject;

class GdtOSVersionJsCallHandler
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
        localJSONObject.put("osVersion", Build.VERSION.RELEASE);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      paramString = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.a();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramVarArgs, false, "getOSVersion", paramString);
      return true;
    }
    GdtLog.d("GdtOSVersionJsCall", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtOSVersionJsCallHandler
 * JD-Core Version:    0.7.0.1
 */