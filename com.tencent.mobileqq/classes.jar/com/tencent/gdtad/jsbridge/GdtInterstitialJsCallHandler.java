package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtAnalysisHelperForInterstitial;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class GdtInterstitialJsCallHandler
  implements GdtJsCallHandler
{
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 8;
    }
    return -2147483648;
  }
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    Activity localActivity;
    if (paramGdtAdWebPlugin != null) {
      localActivity = paramGdtAdWebPlugin.a();
    } else {
      localActivity = null;
    }
    GdtHandler.Options localOptions = new GdtHandler.Options();
    int i = 0;
    boolean bool = GdtHandler.a(localOptions, paramVarArgs[0]);
    if ((paramGdtAdWebPlugin != null) && (localActivity != null) && (bool)) {}
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        GdtLog.b("GdtInterstitialJsCallHandler", paramVarArgs.toString());
        int j = a(paramVarArgs.getJSONObject("options").optInt("orientation"));
        paramVarArgs = paramGdtAdWebPlugin.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key"))) {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
        } else {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
        }
        localOptions.p = new Bundle();
        localOptions.p.putString("big_brother_ref_source_key", paramVarArgs);
        GdtLog.b("GdtInterstitialJsCallHandler", String.format("handleJsCallRequest Source.KEY_REF_ID:%s", new Object[] { paramVarArgs }));
        paramVarArgs = new GdtInterstitialParams();
        paramVarArgs.d = localOptions;
        paramVarArgs.e = j;
        paramVarArgs.f = true;
        bool = ((IGdtInterstitialAPI)QRoute.api(IGdtInterstitialAPI.class)).build(localActivity, paramVarArgs).a(localActivity);
        paramGdtAdWebPlugin.callJs(paramString, null);
        if (!bool) {
          break label293;
        }
        GdtAnalysisHelperForInterstitial.a(localActivity, paramVarArgs, i);
        paramString = localObject;
        if (paramGdtAdWebPlugin != null) {
          paramString = paramGdtAdWebPlugin.b();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, true, "showInterstitial", paramString, localOptions.a);
        return true;
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
      GdtLog.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error");
      return true;
      label293:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialJsCallHandler
 * JD-Core Version:    0.7.0.1
 */