package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.log.GdtLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GdtBannerJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {
      paramString = paramGdtAdWebPlugin.a();
    } else {
      paramString = null;
    }
    if ((paramGdtAdWebPlugin != null) && (paramString != null)) {
      try
      {
        GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
        return true;
      }
      catch (JSONException paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
    }
    GdtLog.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerJsCallHandler
 * JD-Core Version:    0.7.0.1
 */