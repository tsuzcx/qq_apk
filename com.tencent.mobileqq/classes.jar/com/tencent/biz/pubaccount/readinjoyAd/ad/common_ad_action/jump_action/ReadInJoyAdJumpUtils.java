package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.AdvertisementInfoHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class ReadInJoyAdJumpUtils
{
  private static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    int j = paramAdvertisementInfo.mAdJumpMode;
    int i = 5;
    if (j != 2)
    {
      if (j != 3)
      {
        if (j != 4) {
          if (j != 5) {
            if (j == 7) {}
          }
        }
        for (;;)
        {
          return 2;
          if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))
          {
            return 1;
            return 6;
            if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
              break;
            }
          }
        }
      }
      return 4;
    }
    i = 3;
    return i;
  }
  
  public static Integer a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    return a(paramAdvertisementInfo, paramActivity, null);
  }
  
  public static Integer a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
    int i = AdJumpType.a(paramAdvertisementInfo);
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adType = ");
    localStringBuilder.append(i);
    ((IRIJAdLogService)localObject).d("ReadInJoyAdJumpUtils", localStringBuilder.toString());
    switch (i)
    {
    case 5: 
    default: 
      return a(a(paramAdvertisementInfo), paramActivity);
    case 7: 
      a(paramActivity, paramAdvertisementInfo);
      return Integer.valueOf(24);
    case 4: 
      boolean bool = false;
      if (a(paramAdvertisementInfo))
      {
        bool = a(paramAdvertisementInfo.mAdvertisementSoftInfo.g, paramActivity);
        paramReadInJoyGdtAdParams = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jumpScheme result = ");
        ((StringBuilder)localObject).append(bool);
        paramReadInJoyGdtAdParams.d("ReadInJoyAdJumpUtils", ((StringBuilder)localObject).toString());
      }
      if (!bool) {
        return a(a(paramAdvertisementInfo), paramActivity);
      }
      return Integer.valueOf(16);
    case 2: 
    case 6: 
      return Integer.valueOf(-1);
    }
    localObject = paramReadInJoyGdtAdParams;
    if (paramReadInJoyGdtAdParams == null) {
      localObject = new ReadInJoyGdtAdParams();
    }
    if (((paramAdvertisementInfo.mAdvertisementExtInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo.j == 32)) && (a(paramAdvertisementInfo, paramActivity, (ReadInJoyGdtAdParams)localObject)))
    {
      paramAdvertisementInfo = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      paramActivity = new StringBuilder();
      paramActivity.append("jumpToGdt");
      paramActivity.append(((ReadInJoyGdtAdParams)localObject).toString());
      paramAdvertisementInfo.d("ReadInJoyAdJumpUtils", paramActivity.toString());
      return Integer.valueOf(10);
    }
    return a(a(paramAdvertisementInfo), paramActivity);
  }
  
  private static Integer a(String paramString, Activity paramActivity)
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpUrl 。url = ");
    localStringBuilder.append(paramString);
    localIRIJAdLogService.d("ReadInJoyAdJumpUtils", localStringBuilder.toString());
    return ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramActivity, paramString);
  }
  
  private static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentType(paramAdvertisementInfo)) {
      return a(paramAdvertisementInfo.gameAdComData.p, paramAdvertisementInfo.gameAdComData.q, "");
    }
    if (paramAdvertisementInfo.isSoftAd()) {
      return a(paramAdvertisementInfo.mAdvertisementSoftInfo.f, paramAdvertisementInfo.mAdvertisementSoftInfo.h, "");
    }
    return paramAdvertisementInfo.mAdLandingPage;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    } else if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString3;
    }
    return ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).appendUrlParameter(paramString1);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).jumpToPkPage(paramActivity, paramAdvertisementInfo);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    AdvertisementInfoHelper.a(localBundle, paramAdvertisementInfo);
    localBundle.putLong("param_ad_app_info_video_playposition", paramInt);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).startNativeAdVideoFragment(paramActivity, localBundle);
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
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).startReadInJoyNativeAdAppFragment(paramActivity, localBundle);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      if (paramAdvertisementInfo.mAdvertisementSoftInfo == null) {
        return false;
      }
      bool1 = bool2;
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    int i = a(paramAdvertisementInfo);
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gdtType = ");
    localStringBuilder.append(i);
    ((IRIJAdLogService)localObject).d("ReadInJoyAdJumpUtils", localStringBuilder.toString());
    localObject = paramReadInJoyGdtAdParams;
    if (paramReadInJoyGdtAdParams == null) {
      localObject = new ReadInJoyGdtAdParams();
    }
    paramReadInJoyGdtAdParams = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).obtainGdtParams(paramAdvertisementInfo, paramActivity, localObject);
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6) {
              return false;
            }
            a(paramAdvertisementInfo, paramActivity, ((ReadInJoyGdtAdParams)localObject).b);
            return true;
          }
          a(paramAdvertisementInfo, paramActivity, (ReadInJoyGdtAdParams)localObject);
          return true;
        }
        return c(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams, (ReadInJoyGdtAdParams)localObject);
      }
      return a(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams, (ReadInJoyGdtAdParams)localObject);
    }
    return b(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams, (ReadInJoyGdtAdParams)localObject);
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
    if ((paramParams != null) && (paramAdvertisementInfo != null) && (paramContext != null))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(paramAdvertisementInfo);
      GdtHandler.a(paramParams);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdJumpUtils", "jumpToGdtAdRealPage");
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString, Activity paramActivity)
  {
    try
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      ((Intent)localObject).setData(Uri.parse(paramString));
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      ((Intent)localObject).putExtra("big_brother_ref_source_key", "biz_src_feeds_kandian");
      paramString = ((Intent)localObject).resolveActivityInfo(paramActivity.getPackageManager(), 0);
      if (paramString == null)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdJumpUtils", "jumpScheme: ActivityInfo = null");
        return false;
      }
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpScheme: packageName = ");
      localStringBuilder.append(paramString.packageName);
      localIRIJAdLogService.d("ReadInJoyAdJumpUtils", localStringBuilder.toString());
      if (!TextUtils.isEmpty(paramString.packageName))
      {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
        paramActivity.startActivity((Intent)localObject);
        return true;
      }
    }
    catch (Exception paramString)
    {
      paramActivity = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpScheme: e = ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      paramActivity.d("ReadInJoyAdJumpUtils", ((StringBuilder)localObject).toString());
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
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).addVideoCeilingParameter(paramParams, true, paramAdvertisementInfo, paramActivity);
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
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramParams = Uri.parse(paramReadInJoyGdtAdParams).buildUpon();
      if ((NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 1) && (paramAdvertisementInfo.mChannelID != 0L)) {
        paramParams.appendQueryParameter("autodownload", "1");
      } else {
        paramParams.appendQueryParameter("autodownload", "0");
      }
      paramParams = paramParams.toString();
    }
    paramAdvertisementInfo = new GdtVideoCeilingData();
    paramAdvertisementInfo.setVideoData(localGdtVideoData);
    paramAdvertisementInfo.setAd(localGdtAd);
    paramAdvertisementInfo.setWebUrl(paramParams);
    if (paramAdvertisementInfo.getStyle() == -2147483648) {
      paramAdvertisementInfo.setStyle(1);
    }
    paramParams = new Bundle();
    paramParams.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    GdtVideoCeilingFragment.a(paramActivity, paramAdvertisementInfo, paramParams);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils
 * JD-Core Version:    0.7.0.1
 */