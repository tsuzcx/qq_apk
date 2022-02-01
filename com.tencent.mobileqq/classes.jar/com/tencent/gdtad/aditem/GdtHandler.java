package com.tencent.gdtad.aditem;

import achn;
import acho;
import acic;
import acim;
import acin;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtHandler
{
  public static AdClickUtil.Params a(GdtHandler.Params paramParams)
  {
    WeakReference localWeakReference = null;
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
      localWeakReference = new WeakReference(paramParams.jdField_b_of_type_JavaLangRefWeakReference.get());
    }
    localParams.appReceiver = localWeakReference;
    localParams.videoCeilingSupportedIfNotInstalled = paramParams.c;
    localParams.videoCeilingSupportedIfInstalled = paramParams.d;
    localParams.videoSpliceSupported = paramParams.e;
    localParams.mediaViewLocationRect = paramParams.jdField_a_of_type_AndroidGraphicsRect;
    localParams.videoStartPositionMillis = paramParams.jdField_a_of_type_Long;
    localParams.extrasForIntent = new Bundle();
    localParams.extrasForIntent.putString("big_brother_source_key", "biz_src_ads");
    if (paramParams.jdField_a_of_type_AndroidOsBundle != null)
    {
      acho.b("GdtHandler", "toParams pass refId " + paramParams.jdField_a_of_type_AndroidOsBundle);
      localParams.extrasForIntent.putAll(paramParams.jdField_a_of_type_AndroidOsBundle);
    }
    for (;;)
    {
      localParams.videoPlayForced = paramParams.f;
      localParams.halfScreenPageEnabled = paramParams.g;
      localParams.antiSpamParams = paramParams.jdField_a_of_type_JavaLangString;
      return localParams;
      acho.b("GdtHandler", "toParams not pass refId \n" + QLog.getStackTraceString(new IllegalArgumentException()));
    }
  }
  
  public static void a(GdtHandler.Params paramParams)
  {
    Object localObject2 = null;
    acho.b("GdtHandler", "handle");
    ThreadManager.getSubThreadHandler().post(new GdtHandler.1(paramParams));
    acim localacim = acim.a();
    if ((paramParams != null) && (paramParams.a())) {}
    for (Object localObject1 = (Activity)paramParams.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject1 = null)
    {
      localacim.a((Context)localObject1, new acin());
      b(paramParams);
      localObject1 = localObject2;
      if (paramParams != null) {
        localObject1 = paramParams.jdField_a_of_type_OrgJsonJSONObject;
      }
      acic.a((JSONObject)localObject1);
      return;
    }
  }
  
  public static boolean a(GdtHandler.Options paramOptions, String paramString)
  {
    if (paramOptions == null) {
      return false;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      acho.b("GdtHandler", String.format("fromJSON %s", new Object[] { paramString }));
      paramString = localJSONObject1.getJSONObject("options");
      boolean bool1 = paramString.getBoolean("reportForClick");
      boolean bool2 = paramString.getBoolean("appAutoDownload");
      boolean bool3 = paramString.optBoolean("videoCeilingSupported", false);
      boolean bool4 = paramString.optBoolean("videoCeilingSupportedIfInstalled", false);
      boolean bool5 = paramString.optBoolean("videoSpliceSupported", false);
      JSONObject localJSONObject2 = paramString.optJSONObject("mediaViewLocationRect");
      Rect localRect = new Rect();
      if (localJSONObject2 != null)
      {
        int i = localJSONObject2.optInt("left", 0);
        int j = localJSONObject2.optInt("top", 0);
        int k = localJSONObject2.optInt("right", 0);
        int m = localJSONObject2.optInt("bottom", 0);
        localRect.left = i;
        localRect.top = j;
        localRect.right = k;
        localRect.bottom = m;
      }
      paramOptions.jdField_a_of_type_Boolean = bool1;
      paramOptions.jdField_b_of_type_Boolean = bool2;
      paramOptions.c = bool3;
      paramOptions.d = bool4;
      paramOptions.e = bool5;
      paramOptions.jdField_a_of_type_AndroidGraphicsRect = localRect;
      paramOptions.f = paramString.optBoolean("videoPlayForced");
      paramOptions.g = paramString.optBoolean("halfScreenPageEnabled");
      if (localJSONObject1.has("adInfo")) {
        paramOptions.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localJSONObject1.getJSONObject("adInfo"))));
      }
      return true;
    }
    catch (Throwable paramOptions)
    {
      acho.d("GdtHandler", "handleJsCallRequest error", paramOptions);
    }
    return false;
  }
  
  private static void b(GdtHandler.Params paramParams)
  {
    int i = 1;
    if (paramParams == null) {}
    while (paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd == null) {
      return;
    }
    AdClickUtil.Params localParams = a(paramParams);
    if (paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isWeChatMiniApp())
    {
      AdReporterForAnalysis.reportForClickStart(localParams);
      Object localObject = new Handler(Looper.getMainLooper());
      localObject = paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.jumpToWechatMiniApp((Handler)localObject);
      if (paramParams.jdField_a_of_type_Boolean)
      {
        paramParams = AdClickUtil.getUrlForClick(localParams);
        AdReporterForClick.reportAsync(new WeakReference((Context)localParams.activity.get()), localParams.ad, paramParams);
      }
      AdReporterForAnalysis.reportForClickEnd(localParams, (AdClickUtil.Result)localObject);
      return;
    }
    paramParams = AdClickUtil.handle(localParams);
    if (paramParams != null) {
      i = paramParams.getErrorCode();
    }
    acho.b("GdtHandler", String.format("handle errorCode:%d", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler
 * JD-Core Version:    0.7.0.1
 */