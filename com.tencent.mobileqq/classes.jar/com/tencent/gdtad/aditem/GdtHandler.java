package com.tencent.gdtad.aditem;

import aano;
import aanp;
import aaos;
import aaot;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
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
  private static AdClickUtil.Params a(GdtHandler.Params paramParams)
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
      aanp.b("GdtHandler", "toParams pass refId " + paramParams.jdField_a_of_type_AndroidOsBundle);
      localParams.extrasForIntent.putAll(paramParams.jdField_a_of_type_AndroidOsBundle);
    }
    for (;;)
    {
      localParams.videoPlayForced = paramParams.f;
      localParams.antiSpamParams = paramParams.jdField_a_of_type_JavaLangString;
      return localParams;
      aanp.b("GdtHandler", "toParams not pass refId \n" + QLog.getStackTraceString(new IllegalArgumentException()));
    }
  }
  
  public static void a(GdtHandler.Params paramParams)
  {
    aanp.b("GdtHandler", "handle");
    ThreadManager.getSubThreadHandler().post(new GdtHandler.1(paramParams));
    aaos localaaos = aaos.a();
    if ((paramParams != null) && (paramParams.a())) {}
    for (Activity localActivity = (Activity)paramParams.jdField_a_of_type_JavaLangRefWeakReference.get();; localActivity = null)
    {
      localaaos.a(localActivity, new aaot());
      b(paramParams);
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
      aanp.b("GdtHandler", String.format("fromJSON %s", new Object[] { paramString }));
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
      if (localJSONObject1.has("adInfo")) {
        paramOptions.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aano.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localJSONObject1.getJSONObject("adInfo"))));
      }
      return true;
    }
    catch (Throwable paramOptions)
    {
      aanp.d("GdtHandler", "handleJsCallRequest error", paramOptions);
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
    paramParams = AdClickUtil.handle(a(paramParams));
    if (paramParams != null) {
      i = paramParams.getErrorCode();
    }
    aanp.b("GdtHandler", String.format("handle errorCode:%d", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler
 * JD-Core Version:    0.7.0.1
 */