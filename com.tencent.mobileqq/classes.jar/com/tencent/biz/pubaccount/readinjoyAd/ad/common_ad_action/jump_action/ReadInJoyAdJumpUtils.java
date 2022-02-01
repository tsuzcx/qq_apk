package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.common.AdvertisementInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class ReadInJoyAdJumpUtils
{
  private static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdvertisementInfo.mAdJumpMode)
    {
    }
    do
    {
      do
      {
        return 2;
        return 3;
      } while (TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson));
      return 5;
      return 4;
      return 6;
    } while (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage));
    return 1;
  }
  
  public static Integer a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    return a(paramAdvertisementInfo, paramActivity, null);
  }
  
  public static Integer a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    ReadinJoyActionUtil.a(paramActivity);
    int i = AdJumpType.a(paramAdvertisementInfo);
    ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "adType = " + i);
    switch (i)
    {
    case 5: 
    default: 
      return a(a(paramAdvertisementInfo), paramActivity);
    case 2: 
    case 6: 
      return Integer.valueOf(-1);
    case 4: 
      boolean bool = false;
      if (a(paramAdvertisementInfo))
      {
        bool = a(paramAdvertisementInfo.mAdvertisementSoftInfo.g, paramActivity);
        ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "jumpScheme result = " + bool);
      }
      if (!bool) {
        return a(a(paramAdvertisementInfo), paramActivity);
      }
      return Integer.valueOf(16);
    case 7: 
      a(paramActivity, paramAdvertisementInfo);
      return Integer.valueOf(24);
    }
    ReadInJoyGdtAdParams localReadInJoyGdtAdParams = paramReadInJoyGdtAdParams;
    if (paramReadInJoyGdtAdParams == null) {
      localReadInJoyGdtAdParams = new ReadInJoyGdtAdParams();
    }
    if (((paramAdvertisementInfo.mAdvertisementExtInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo.j == 32)) && (a(paramAdvertisementInfo, paramActivity, localReadInJoyGdtAdParams)))
    {
      ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "jumpToGdt" + localReadInJoyGdtAdParams.toString());
      return Integer.valueOf(10);
    }
    return a(a(paramAdvertisementInfo), paramActivity);
  }
  
  private static Integer a(String paramString, Activity paramActivity)
  {
    ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "jumpUrl 。url = " + paramString);
    return RIJJumpUtils.a(paramActivity, paramString);
  }
  
  private static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (FastWeqAdUtils.a(paramAdvertisementInfo)) {
      return a(paramAdvertisementInfo.gameAdComData.p, paramAdvertisementInfo.gameAdComData.q, "");
    }
    if (paramAdvertisementInfo.isSoftAd()) {
      return a(paramAdvertisementInfo.mAdvertisementSoftInfo.f, paramAdvertisementInfo.mAdvertisementSoftInfo.h, "");
    }
    return paramAdvertisementInfo.mAdLandingPage;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return ReadinJoyActionUtil.a(paramString2);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString2 = paramString3;
      } else {
        paramString2 = paramString1;
      }
    }
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    AdvertisementInfoHelper.a(localBundle, paramAdvertisementInfo);
    localBundle.putLong("param_ad_app_info_video_playposition", paramInt);
    ReadinJoyActionUtil.a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    String str = paramAdvertisementInfo.mAdAppJson;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_ad_json", str);
    localBundle.putString("param_ad_app_info_trace_id", paramAdvertisementInfo.mAdTraceId);
    localBundle.putLong("param_ad_app_info_pull_time", paramAdvertisementInfo.mAdFetchTime);
    localBundle.putString("param_ad_app_info_view_id", paramAdvertisementInfo.mAdViewId);
    localBundle.putLong("param_ad_app_info_pos_id", paramAdvertisementInfo.mAdPosID);
    localBundle.putInt("param_ad_app_info_kd_pos", paramAdvertisementInfo.mAdKdPos);
    localBundle.putString("param_ad_app_info_product_id", paramAdvertisementInfo.mAdProductId);
    localBundle.putInt("param_ad_app_info_product_type", paramAdvertisementInfo.mAdProductType);
    localBundle.putString("param_ad_app_info_ap_url", paramAdvertisementInfo.mAdApurl);
    localBundle.putLong("param_ad_app_info_video_playposition", paramReadInJoyGdtAdParams.b);
    ReadinJoyActionUtil.a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {}
    while ((!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    int i = a(paramAdvertisementInfo);
    ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "gdtType = " + i);
    ReadInJoyGdtAdParams localReadInJoyGdtAdParams = paramReadInJoyGdtAdParams;
    if (paramReadInJoyGdtAdParams == null) {
      localReadInJoyGdtAdParams = new ReadInJoyGdtAdParams();
    }
    paramReadInJoyGdtAdParams = AdParamsFactory.a(paramAdvertisementInfo, paramActivity, localReadInJoyGdtAdParams);
    switch (i)
    {
    default: 
      return false;
    case 2: 
      return b(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams, localReadInJoyGdtAdParams);
    case 3: 
      return a(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams, localReadInJoyGdtAdParams);
    case 4: 
      return c(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams, localReadInJoyGdtAdParams);
    case 5: 
      a(paramAdvertisementInfo, paramActivity, localReadInJoyGdtAdParams);
      return true;
    }
    a(paramAdvertisementInfo, paramActivity, localReadInJoyGdtAdParams.b);
    return true;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    boolean bool = false;
    if (paramParams == null) {
      return false;
    }
    if ((paramAdvertisementInfo.mChannelID == 0L) || (paramAdvertisementInfo.mChannelID == 2L) || (paramAdvertisementInfo.isCommentAd())) {
      bool = ReadInJoyAdSwitchUtil.b(paramAdvertisementInfo);
    }
    paramParams.f = bool;
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  private static boolean a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      return false;
    }
    ReadInJoyAdUtils.b(paramAdvertisementInfo);
    GdtHandler.a(paramParams);
    ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "jumpToGdtAdRealPage");
    return true;
  }
  
  public static boolean a(String paramString, Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      localIntent.putExtra("big_brother_ref_source_key", "biz_src_feeds_kandian");
      paramString = localIntent.resolveActivityInfo(paramActivity.getPackageManager(), 0);
      if (paramString == null)
      {
        ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "jumpScheme: ActivityInfo = null");
        return false;
      }
      ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "jumpScheme: packageName = " + paramString.packageName);
      if (!TextUtils.isEmpty(paramString.packageName))
      {
        ReadinJoyActionUtil.a(paramActivity);
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ReadInJoyAdLog.a("ReadInJoyAdJumpUtils", "jumpScheme: e = " + paramString.getMessage());
    }
    return false;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    if (paramParams == null) {
      return false;
    }
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    if (paramParams == null) {
      return false;
    }
    ReadinJoyActionUtil.a(paramParams, true, paramAdvertisementInfo, paramActivity);
    if (a(paramParams, paramActivity, paramAdvertisementInfo)) {
      return true;
    }
    paramReadInJoyGdtAdParams = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    paramReadInJoyGdtAdParams.aid.set(paramAdvertisementInfo.mAdAid);
    paramReadInJoyGdtAdParams.traceid.set(paramAdvertisementInfo.mAdTraceId);
    paramReadInJoyGdtAdParams.view_id.set(paramAdvertisementInfo.mAdViewId);
    paramParams = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramParams.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramParams.click_url.set(paramAdvertisementInfo.mAdRl);
    paramParams.trace_info.set(paramReadInJoyGdtAdParams);
    paramReadInJoyGdtAdParams = new qq_ad_get.QQAdGetRsp.AdInfo();
    paramReadInJoyGdtAdParams.report_info.set(paramParams);
    GdtAd localGdtAd = new GdtAd(paramReadInJoyGdtAdParams);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    paramReadInJoyGdtAdParams = paramAdvertisementInfo.mAdLandingPage;
    paramParams = paramReadInJoyGdtAdParams;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramParams = Uri.parse(paramReadInJoyGdtAdParams).buildUpon();
      if ((NetworkUtil.b(BaseApplicationImpl.getApplication()) != 1) || (paramAdvertisementInfo.mChannelID == 0L)) {
        break label292;
      }
      paramParams.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramParams = paramParams.toString();
      paramAdvertisementInfo = new GdtVideoCeilingData();
      paramAdvertisementInfo.setVideoData(localGdtVideoData);
      paramAdvertisementInfo.setAd(localGdtAd);
      paramAdvertisementInfo.setWebUrl(paramParams);
      if (paramAdvertisementInfo.getStyle() == -2147483648) {
        paramAdvertisementInfo.setStyle(1);
      }
      paramParams = new Bundle();
      paramParams.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, paramAdvertisementInfo, paramParams);
      return false;
      label292:
      paramParams.appendQueryParameter("autodownload", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils
 * JD-Core Version:    0.7.0.1
 */