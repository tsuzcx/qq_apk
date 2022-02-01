package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtPreLoadAfterAdLoadedJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        GdtLog.b("GdtPreLoaderJsCallHandler", paramVarArgs.toString());
        GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramVarArgs.getJSONObject("adInfo"))));
        GdtPreLoader.a().a(localGdtAd);
        paramVarArgs = null;
        paramGdtAdWebPlugin.callJs(paramString, null);
        if (paramGdtAdWebPlugin != null)
        {
          paramString = paramGdtAdWebPlugin.a();
          if (paramGdtAdWebPlugin != null) {
            paramVarArgs = paramGdtAdWebPlugin.b();
          }
          AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramString, true, "preLoadAfterAdLoaded", paramVarArgs, localGdtAd);
          return true;
        }
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        paramGdtAdWebPlugin.printStackTrace();
        return true;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtPreLoadAfterAdLoadedJsCallHandler
 * JD-Core Version:    0.7.0.1
 */