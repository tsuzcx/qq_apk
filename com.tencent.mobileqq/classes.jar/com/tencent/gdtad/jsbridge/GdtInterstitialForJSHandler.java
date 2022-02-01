package com.tencent.gdtad.jsbridge;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import org.json.JSONException;
import org.json.JSONObject;

final class GdtInterstitialForJSHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramString == null); paramString = null)
    {
      GdtLog.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramGdtAdWebPlugin = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramGdtAdWebPlugin, "com.tencent.mobileqq"))
        {
          paramGdtAdWebPlugin = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramGdtAdWebPlugin, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
      if (TextUtils.equals(paramGdtAdWebPlugin, "com.tencent.mobileqq:tool")) {
        paramGdtAdWebPlugin = PublicFragmentActivityForTool.class;
      } else {
        paramGdtAdWebPlugin = QQMiniManager.getPublicFragmentActivityForMiniClass();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialForJSHandler
 * JD-Core Version:    0.7.0.1
 */