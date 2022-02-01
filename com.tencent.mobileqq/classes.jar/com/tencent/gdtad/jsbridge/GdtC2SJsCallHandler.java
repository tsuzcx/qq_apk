package com.tencent.gdtad.jsbridge;

import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtC2SJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramVarArgs[0]);
        GdtLog.a("GdtC2SJsCallHandler", paramString.toString());
        int i = paramString.optInt("operationType");
        int j = paramString.optInt("businessType");
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString.getJSONObject("adInfo")));
        GdtC2SReporter.a(i, j, localAdInfo);
        paramVarArgs = null;
        if (paramGdtAdWebPlugin != null)
        {
          paramString = paramGdtAdWebPlugin.a();
          if (paramGdtAdWebPlugin != null) {
            paramVarArgs = paramGdtAdWebPlugin.a();
          }
          AdAnalysisHelperForUtil.reportForJSBridgeInvoked(paramString, false, "c2sReport", paramVarArgs, new GdtAd(localAdInfo));
          return true;
        }
      }
      catch (Exception paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtC2SJsCallHandler", "handleJsCallRequest", paramGdtAdWebPlugin);
        return true;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtC2SJsCallHandler
 * JD-Core Version:    0.7.0.1
 */