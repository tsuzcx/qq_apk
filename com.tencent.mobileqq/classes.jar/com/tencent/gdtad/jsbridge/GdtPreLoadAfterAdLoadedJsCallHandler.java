package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
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
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      GdtLog.b("GdtPreLoaderJsCallHandler", paramVarArgs.toString());
      paramVarArgs = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramVarArgs.getJSONObject("adInfo"))));
      GdtPreLoader.a().a(paramVarArgs);
      paramGdtAdWebPlugin.callJs(paramString, null);
      if (paramGdtAdWebPlugin != null)
      {
        paramString = paramGdtAdWebPlugin.a();
        if (paramGdtAdWebPlugin == null) {
          break label99;
        }
      }
      label99:
      for (paramGdtAdWebPlugin = paramGdtAdWebPlugin.a();; paramGdtAdWebPlugin = null)
      {
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "preLoadAfterAdLoaded", paramGdtAdWebPlugin, paramVarArgs);
        return true;
        paramString = null;
        break;
      }
      return true;
    }
    catch (Throwable paramGdtAdWebPlugin)
    {
      paramGdtAdWebPlugin.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtPreLoadAfterAdLoadedJsCallHandler
 * JD-Core Version:    0.7.0.1
 */