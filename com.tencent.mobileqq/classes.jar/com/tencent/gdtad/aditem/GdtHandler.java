package com.tencent.gdtad.aditem;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtHandler
{
  public static AdClickUtil.Params a(GdtHandler.Params paramParams)
  {
    Object localObject = null;
    if (paramParams == null) {
      return null;
    }
    AdClickUtil.Params localParams = new AdClickUtil.Params();
    localParams.activity = paramParams.jdField_a_of_type_JavaLangRefWeakReference;
    localParams.ad = paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localParams.reportForClick = paramParams.jdField_a_of_type_Boolean;
    localParams.sceneID = paramParams.jdField_a_of_type_Int;
    localParams.componentID = paramParams.jdField_b_of_type_Int;
    localParams.enableAutoDownload = paramParams.jdField_b_of_type_Boolean;
    if (paramParams.jdField_b_of_type_JavaLangRefWeakReference != null) {
      localObject = new WeakReference(paramParams.jdField_b_of_type_JavaLangRefWeakReference.get());
    }
    localParams.appReceiver = ((WeakReference)localObject);
    localParams.videoCeilingSupportedIfNotInstalled = paramParams.c;
    localParams.videoCeilingSupportedIfInstalled = paramParams.d;
    localParams.videoSpliceSupported = paramParams.e;
    localParams.mediaViewLocationRect = paramParams.jdField_a_of_type_AndroidGraphicsRect;
    localParams.videoStartPositionMillis = paramParams.jdField_a_of_type_Long;
    localParams.extrasForIntent = new Bundle();
    localParams.extrasForIntent.putString("big_brother_source_key", "biz_src_ads");
    if (paramParams.jdField_a_of_type_AndroidOsBundle != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toParams pass refId ");
      ((StringBuilder)localObject).append(paramParams.jdField_a_of_type_AndroidOsBundle);
      GdtLog.b("GdtHandler", ((StringBuilder)localObject).toString());
      localParams.extrasForIntent.putAll(paramParams.jdField_a_of_type_AndroidOsBundle);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toParams not pass refId \n");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(new IllegalArgumentException()));
      GdtLog.b("GdtHandler", ((StringBuilder)localObject).toString());
    }
    localParams.videoPlayForced = paramParams.f;
    localParams.halfScreenPageEnabled = paramParams.g;
    localParams.antiSpamParams = paramParams.jdField_a_of_type_JavaLangString;
    return localParams;
  }
  
  @Deprecated
  public static void a(GdtHandler.Params paramParams)
  {
    GdtLog.b("GdtHandler", "handle");
    ThreadManager.getSubThreadHandler().post(new GdtHandler.1(paramParams));
    IGdtAdAPI localIGdtAdAPI = (IGdtAdAPI)QRoute.api(IGdtAdAPI.class);
    if (localIGdtAdAPI == null)
    {
      QLog.i("GdtHandler", 1, "gdtAdAPI == null");
      return;
    }
    Object localObject2 = null;
    if ((paramParams != null) && (paramParams.a())) {
      localObject1 = (Activity)paramParams.jdField_a_of_type_JavaLangRefWeakReference.get();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      localIGdtAdAPI.initGdtContext((Context)localObject1, new InitGdtContextParams());
    }
    b(paramParams);
    Object localObject1 = localObject2;
    if (paramParams != null) {
      localObject1 = paramParams.jdField_a_of_type_OrgJsonJSONObject;
    }
    GdtReportForAntiSpam.a((JSONObject)localObject1);
  }
  
  public static boolean a(GdtHandler.Options paramOptions, String paramString)
  {
    if (paramOptions == null) {
      return false;
    }
    label307:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        GdtLog.b("GdtHandler", String.format("fromJSON %s", new Object[] { paramString }));
        paramString = localJSONObject1.getJSONObject("options");
        boolean bool1 = paramString.getBoolean("reportForClick");
        boolean bool2 = paramString.getBoolean("appAutoDownload");
        boolean bool3 = paramString.optBoolean("videoCeilingSupported", false);
        boolean bool4 = paramString.optBoolean("videoCeilingSupportedIfInstalled", false);
        boolean bool5 = paramString.optBoolean("videoSpliceSupported", false);
        JSONObject localJSONObject2 = paramString.optJSONObject("mediaViewLocationRect");
        Rect localRect = new Rect();
        if (localJSONObject2 == null) {
          break label307;
        }
        int i = localJSONObject2.optInt("left", 0);
        int j = localJSONObject2.optInt("top", 0);
        int k = localJSONObject2.optInt("right", 0);
        try
        {
          int m = localJSONObject2.optInt("bottom", 0);
          localRect.left = i;
          localRect.top = j;
          localRect.right = k;
          localRect.bottom = m;
          paramOptions.jdField_a_of_type_Boolean = bool1;
          paramOptions.jdField_b_of_type_Boolean = bool2;
          paramOptions.c = bool3;
          paramOptions.d = bool4;
          paramOptions.e = bool5;
          paramOptions.jdField_a_of_type_AndroidGraphicsRect = localRect;
          paramOptions.f = paramString.optBoolean("videoPlayForced");
          paramOptions.g = paramString.optBoolean("halfScreenPageEnabled");
          if (localJSONObject1.has("adInfo")) {
            paramOptions.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localJSONObject1.getJSONObject("adInfo"))));
          }
          return true;
        }
        catch (Throwable paramOptions) {}
        GdtLog.d("GdtHandler", "handleJsCallRequest error", paramOptions);
      }
      catch (Throwable paramOptions) {}
      return false;
    }
  }
  
  private static void b(GdtHandler.Params paramParams)
  {
    if (paramParams == null) {
      return;
    }
    if (paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd == null) {
      return;
    }
    AdClickUtil.Params localParams = a(paramParams);
    boolean bool = paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isWeChatMiniApp();
    int i = 1;
    if (bool)
    {
      AdAnalysisHelperForUtil.reportForClickStart(localParams);
      Object localObject = new Handler(Looper.getMainLooper());
      IGdtAdAPI localIGdtAdAPI = (IGdtAdAPI)QRoute.api(IGdtAdAPI.class);
      if (localIGdtAdAPI == null)
      {
        QLog.i("GdtHandler", 1, "gdtAdAPI == null");
        return;
      }
      localObject = localIGdtAdAPI.jumpToWechatMiniApp((Handler)localObject, paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      if (paramParams.jdField_a_of_type_Boolean)
      {
        paramParams = AdClickUtil.getUrlForClick(localParams);
        AdReporterForClick.reportAsync(new WeakReference((Context)localParams.activity.get()), localParams.ad, paramParams);
      }
      AdAnalysisHelperForUtil.reportForClickEnd(localParams, (AdClickUtil.Result)localObject);
      return;
    }
    paramParams = AdClickUtil.handle(localParams);
    if (paramParams != null) {
      i = paramParams.getErrorCode();
    }
    GdtLog.b("GdtHandler", String.format("handle errorCode:%d", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler
 * JD-Core Version:    0.7.0.1
 */