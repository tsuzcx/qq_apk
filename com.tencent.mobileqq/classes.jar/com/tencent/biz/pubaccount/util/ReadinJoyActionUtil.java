package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.NativeAd.report.VideoAdClickRecorder;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.Param;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.AdvertisementInfoHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdPKImageData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.ItemViewBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.api.IRIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo;

public class ReadinJoyActionUtil
{
  public static GdtAppReceiver a = null;
  public static boolean b = false;
  private static ArrayList<Integer> c = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(12), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(41), Integer.valueOf(1000) }));
  
  private static AdHandler.ItemViewBuilder a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, String paramString)
  {
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramIReadInJoyBaseAdapter.d();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int i = Math.max(localReadInJoyXListView.getHeaderViewsCount(), j);
    for (;;)
    {
      int k = paramIReadInJoyBaseAdapter.h().size();
      int m = localReadInJoyXListView.getHeaderViewsCount();
      Object localObject = null;
      if (i >= k + m) {
        break;
      }
      k = i - localReadInJoyXListView.getHeaderViewsCount();
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyBaseAdapter.a(k);
      if ((66 == paramIReadInJoyBaseAdapter.getItemViewType(k)) && (localAbsBaseArticleInfo != null) && (TextUtils.equals(localAbsBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        i -= j;
        if ((i >= 0) && (i < localReadInJoyXListView.getChildCount())) {
          paramIReadInJoyBaseAdapter = localReadInJoyXListView.getChildAt(i);
        } else if ((k >= 0) && (k < paramIReadInJoyBaseAdapter.h().size())) {
          paramIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter.getView(k, null, localReadInJoyXListView);
        } else {
          paramIReadInJoyBaseAdapter = null;
        }
        paramString = localObject;
        if (paramIReadInJoyBaseAdapter != null)
        {
          paramString = localObject;
          if ((paramIReadInJoyBaseAdapter.getTag() instanceof AdHandler.ItemViewBuilder)) {
            paramString = (AdHandler.ItemViewBuilder)paramIReadInJoyBaseAdapter.getTag();
          }
        }
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AdJumpParams paramAdJumpParams)
  {
    if ((paramBoolean2) && (!((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).checkConditionForJumpToGdt(paramAdvertisementInfo, paramInt))) {
      return null;
    }
    Object localObject = new ReadInJoyGdtAdParams();
    ((ReadInJoyGdtAdParams)localObject).c = paramBoolean1;
    ((ReadInJoyGdtAdParams)localObject).g = paramBoolean3;
    if (paramAdJumpParams != null)
    {
      ((ReadInJoyGdtAdParams)localObject).b = (paramAdJumpParams.b ^ true);
      ((ReadInJoyGdtAdParams)localObject).e = paramAdJumpParams.a;
      ((ReadInJoyGdtAdParams)localObject).d = paramAdJumpParams.d;
    }
    if (paramIReadInJoyBaseAdapter != null) {
      ((ReadInJoyGdtAdParams)localObject).d = paramIReadInJoyBaseAdapter.f();
    }
    paramIReadInJoyBaseAdapter = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).obtainGdtParams(paramAdvertisementInfo, (Activity)paramContext, localObject, paramIReadInJoyBaseAdapter);
    if ((paramAdJumpParams != null) && (paramAdJumpParams.f == 0) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(paramAdvertisementInfo))) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramIReadInJoyBaseAdapter.a.info.ext_json.get());
        paramAdvertisementInfo = "";
        localObject = paramContext.optJSONArray("exp_map");
        paramInt = 0;
        paramContext = paramAdvertisementInfo;
        if (paramInt < ((JSONArray)localObject).length())
        {
          paramContext = ((JSONArray)localObject).getJSONObject(paramInt);
          if (!paramContext.getString("key").equals("109882")) {
            break label339;
          }
          paramContext = paramContext.getString("value");
        }
        paramIReadInJoyBaseAdapter.a.info.display_info.creative_size.set(585);
        if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals("default")))
        {
          if (paramContext.equals("landing_page"))
          {
            paramIReadInJoyBaseAdapter.f = false;
            paramIReadInJoyBaseAdapter.g = false;
            return paramIReadInJoyBaseAdapter;
          }
          paramIReadInJoyBaseAdapter.h = paramContext;
          paramIReadInJoyBaseAdapter.f = true;
          paramIReadInJoyBaseAdapter.g = true;
          return paramIReadInJoyBaseAdapter;
        }
        paramIReadInJoyBaseAdapter.i = true;
        paramIReadInJoyBaseAdapter.j = paramAdJumpParams.e;
        return paramIReadInJoyBaseAdapter;
      }
      catch (Exception paramContext)
      {
        ReadInJoyAdLog.a("ReadinJoyActionUtil", paramContext.getStackTrace().toString());
      }
      return paramIReadInJoyBaseAdapter;
      label339:
      paramInt += 1;
    }
  }
  
  public static GdtHandler.Params a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    return a(paramAdvertisementInfo, paramActivity, paramReadInJoyGdtAdParams, null);
  }
  
  public static GdtHandler.Params a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if ((paramAdvertisementInfo != null) && (paramActivity != null))
    {
      GdtHandler.Params localParams = new GdtHandler.Params();
      ReadInJoyGdtAdParams localReadInJoyGdtAdParams = paramReadInJoyGdtAdParams;
      if (paramReadInJoyGdtAdParams == null) {
        localReadInJoyGdtAdParams = new ReadInJoyGdtAdParams();
      }
      paramReadInJoyGdtAdParams = (qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo, paramIReadInJoyBaseAdapter);
      localParams.q = 1;
      localParams.r = new WeakReference(paramActivity);
      localParams.a = new GdtAd(paramReadInJoyGdtAdParams);
      localParams.b = localReadInJoyGdtAdParams.b;
      localParams.e = false;
      if (paramAdvertisementInfo.clickPos > 0)
      {
        localParams.d = paramAdvertisementInfo.clickPos;
        paramAdvertisementInfo.resetClickPos();
      }
      localParams.k = localReadInJoyGdtAdParams.d;
      if (a == null)
      {
        a = new GdtAppReceiver();
        a.register(BaseApplicationImpl.getContext());
      }
      localParams.s = new WeakReference(a);
      long l = paramAdvertisementInfo.mChannelID;
      if ((l != 3L) && (l != 4L) && (paramAdvertisementInfo.mAdJumpMode != 6) && (!localReadInJoyGdtAdParams.g) && (l != 2000001L)) {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).addVideoCeilingParameter(localParams, localReadInJoyGdtAdParams.e, paramAdvertisementInfo, paramActivity);
      }
      localParams.p = new Bundle();
      localParams.p.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      return localParams;
    }
    return null;
  }
  
  public static Integer a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    paramAdJumpParams = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (paramAdJumpParams != null)
    {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).addVideoCeilingParameter(paramAdJumpParams, true, paramAdvertisementInfo, paramActivity);
      paramAdJumpParams = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(paramAdJumpParams, paramActivity, paramAdvertisementInfo);
      if (paramAdJumpParams.intValue() != -1) {
        return paramAdJumpParams;
      }
    }
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramAdJumpParams = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramAdJumpParams.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramAdJumpParams.click_url.set(paramAdvertisementInfo.mAdRl);
    paramAdJumpParams.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramAdJumpParams);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramAdJumpParams = (AdJumpParams)localObject;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramAdJumpParams = Uri.parse((String)localObject).buildUpon();
      if ((NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 1) && (paramInt != 0)) {
        paramAdJumpParams.appendQueryParameter("autodownload", "1");
      } else {
        paramAdJumpParams.appendQueryParameter("autodownload", "0");
      }
      paramAdJumpParams = paramAdJumpParams.toString();
    }
    localObject = new GdtVideoCeilingData();
    ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
    ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
    ((GdtVideoCeilingData)localObject).setWebUrl(paramAdJumpParams);
    paramInt = paramAdvertisementInfo.mAdJumpMode;
    if (QLog.isColorLevel())
    {
      paramAdJumpParams = new StringBuilder();
      paramAdJumpParams.append("jump mode = ");
      paramAdJumpParams.append(paramInt);
      QLog.d("ReadinJoyActionUtil", 0, paramAdJumpParams.toString());
    }
    if (paramInt == 4)
    {
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        return a(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, 0, null);
      }
      a(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, 0, false);
      return Integer.valueOf(0);
    }
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, 0, false);
      return Integer.valueOf(10);
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    GdtVideoCeilingFragment.a(paramActivity, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
    return Integer.valueOf(11);
  }
  
  public static Integer a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2, AdJumpParams paramAdJumpParams)
  {
    if (paramAdvertisementInfo == null) {
      return Integer.valueOf(-1);
    }
    Object localObject = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean1, paramAdJumpParams);
    if (localObject != null)
    {
      ((GdtHandler.Params)localObject).l = paramBoolean2;
      if (paramAdJumpParams == null) {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).addVideoCeilingParameter(localObject, true, paramAdvertisementInfo, paramActivity);
      }
      paramAdJumpParams = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localObject, paramActivity, paramAdvertisementInfo);
      if (paramAdJumpParams.intValue() != -1) {
        return paramAdJumpParams;
      }
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramAdJumpParams = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramAdJumpParams.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramAdJumpParams.click_url.set(paramAdvertisementInfo.mAdRl);
    paramAdJumpParams.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramAdJumpParams);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setDirectPlay(paramBoolean2);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramAdJumpParams = (AdJumpParams)localObject;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramAdJumpParams = Uri.parse((String)localObject).buildUpon();
      if ((NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 1) && (paramInt != 0)) {
        paramAdJumpParams.appendQueryParameter("autodownload", "1");
      } else {
        paramAdJumpParams.appendQueryParameter("autodownload", "0");
      }
      paramAdJumpParams = paramAdJumpParams.toString();
    }
    localObject = new GdtVideoCeilingData();
    ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
    ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
    ((GdtVideoCeilingData)localObject).setWebUrl(paramAdJumpParams);
    paramInt = paramAdvertisementInfo.mAdJumpMode;
    if (QLog.isColorLevel())
    {
      paramAdJumpParams = new StringBuilder();
      paramAdJumpParams.append("jump mode = ");
      paramAdJumpParams.append(paramInt);
      QLog.d("ReadinJoyActionUtil", 0, paramAdJumpParams.toString());
    }
    if (paramInt == 4)
    {
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        return a(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, 0, null);
      }
      a(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, 0, false);
      return Integer.valueOf(0);
    }
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, 0, false);
      return Integer.valueOf(10);
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    GdtVideoCeilingFragment.a(paramActivity, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
    return Integer.valueOf(11);
  }
  
  public static Integer a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, AdJumpParams paramAdJumpParams)
  {
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
      return Integer.valueOf(-1);
    }
    if (paramInt == 0)
    {
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      if (paramIReadInJoyBaseAdapter != null) {
        paramIReadInJoyBaseAdapter.notifyDataSetChanged();
      }
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
    int i = localAdvertisementInfo.clickPos;
    Object localObject = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
    boolean bool;
    if (i == 8) {
      bool = true;
    } else {
      bool = false;
    }
    GdtHandler.Params localParams = (GdtHandler.Params)((IRIJAdActionUtilService)localObject).getAdInfoParams(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, bool, paramAdJumpParams);
    if ((localParams != null) && (paramAdJumpParams == null)) {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).addVideoCeilingParameter(localParams, true, localAdvertisementInfo, paramActivity);
    }
    paramAdJumpParams = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localParams, paramActivity, localAdvertisementInfo);
    localAdvertisementInfo.clickPos = i;
    paramIReadInJoyBaseAdapter = paramAdJumpParams;
    if (paramAdJumpParams.intValue() == -1)
    {
      localObject = paramAbsBaseArticleInfo.mArticleContentUrl;
      paramIReadInJoyBaseAdapter = (IReadInJoyBaseAdapter)localObject;
      if (ReadInJoyAdUtils.i(localAdvertisementInfo))
      {
        paramIReadInJoyBaseAdapter = b(localAdvertisementInfo);
        if (paramIReadInJoyBaseAdapter != null) {
          paramAdJumpParams = paramIReadInJoyBaseAdapter.a;
        } else {
          paramAdJumpParams = "";
        }
        paramIReadInJoyBaseAdapter = (IReadInJoyBaseAdapter)localObject;
        if (!TextUtils.isEmpty(paramAdJumpParams)) {
          paramIReadInJoyBaseAdapter = paramAdJumpParams;
        }
      }
      paramAdJumpParams = paramIReadInJoyBaseAdapter;
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo))
      {
        paramAdJumpParams = paramIReadInJoyBaseAdapter;
        if (NetworkUtil.isWifiConnected(null))
        {
          if (paramIReadInJoyBaseAdapter.contains("?"))
          {
            paramAdJumpParams = new StringBuilder();
            paramAdJumpParams.append(paramIReadInJoyBaseAdapter);
            paramAdJumpParams.append("&");
            paramIReadInJoyBaseAdapter = paramAdJumpParams.toString();
          }
          else
          {
            paramAdJumpParams = new StringBuilder();
            paramAdJumpParams.append(paramIReadInJoyBaseAdapter);
            paramAdJumpParams.append("?");
            paramIReadInJoyBaseAdapter = paramAdJumpParams.toString();
          }
          paramAdJumpParams = new StringBuilder();
          paramAdJumpParams.append(paramIReadInJoyBaseAdapter);
          paramAdJumpParams.append("acttype=42");
          paramAdJumpParams = paramAdJumpParams.toString();
        }
      }
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
      if (ReadInJoyAdUtils.l(localAdvertisementInfo))
      {
        paramIReadInJoyBaseAdapter = ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramActivity, paramAdJumpParams);
        a(paramActivity, paramAbsBaseArticleInfo, paramInt, paramIReadInJoyBaseAdapter);
        return paramIReadInJoyBaseAdapter;
      }
      paramIReadInJoyBaseAdapter = new Intent(paramActivity, QQBrowserActivity.class);
      paramIReadInJoyBaseAdapter.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramIReadInJoyBaseAdapter.putExtra("url", paramAdJumpParams);
      paramIReadInJoyBaseAdapter.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      if ((localParams != null) && (localParams.a != null))
      {
        if (localParams.a.getNocoId() != 0L) {
          paramIReadInJoyBaseAdapter.putExtra("GdtNocoId", localParams.a.getNocoId());
        }
        if (!TextUtils.isEmpty(localParams.a.getUrlForEffect())) {
          paramIReadInJoyBaseAdapter.putExtra("GdtWebReportQQ_ACTION_URL", localParams.a.getUrlForAction());
        }
        if (!TextUtils.isEmpty(localParams.a.getTraceId())) {
          paramIReadInJoyBaseAdapter.putExtra("GdtWebReportQQ_TRACE_ID", localParams.a.getTraceId());
        }
      }
      paramActivity.startActivity(paramIReadInJoyBaseAdapter);
      paramIReadInJoyBaseAdapter = Integer.valueOf(11);
    }
    a(paramActivity, paramAbsBaseArticleInfo, paramInt, paramIReadInJoyBaseAdapter);
    return paramIReadInJoyBaseAdapter;
  }
  
  public static Integer a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2, AdJumpParams paramAdJumpParams)
  {
    boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo);
    Integer localInteger1 = Integer.valueOf(-1);
    if (bool)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return localInteger1;
      }
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (LiujinAdJump.isFromLiuJin(localAdvertisementInfo))
      {
        Integer localInteger2 = LiujinAdJump.doJumpAction(localAdvertisementInfo, paramActivity, paramBoolean1);
        if (localInteger2.intValue() != -1)
        {
          a(paramActivity, paramAbsBaseArticleInfo, paramInt, localInteger2);
          return Integer.valueOf(10);
        }
      }
      if (paramAdJumpParams == null) {
        paramAdJumpParams = new AdJumpParams();
      }
      if ((localAdvertisementInfo.mAdProductType == 6) && (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startMiniApp(paramActivity, 2086, paramAbsBaseArticleInfo)))
      {
        a(paramActivity, paramAbsBaseArticleInfo, paramInt, Integer.valueOf(6));
        if (paramInt == 0)
        {
          ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
          if (paramIReadInJoyBaseAdapter != null) {
            paramIReadInJoyBaseAdapter.notifyDataSetChanged();
          }
        }
        return Integer.valueOf(6);
      }
      if ((localAdvertisementInfo.mAdvertisementExtInfo != null) && (localAdvertisementInfo.mAdvertisementExtInfo.l == 1035) && (!((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).hasEggReport())) {
        ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).reportAdClick();
      }
      switch (localAdvertisementInfo.mAdJumpMode)
      {
      default: 
        return localInteger1;
      case 5: 
        b(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, true);
        return Integer.valueOf(10);
      case 4: 
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdAppJson)) {
          return a(paramActivity, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt, null);
        }
        a(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, true);
        return Integer.valueOf(0);
      case 3: 
        paramAdJumpParams.a = a(paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter);
        int i = localAdvertisementInfo.clickPos;
        paramAdJumpParams = a(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean1, paramBoolean2, paramAdJumpParams);
        localAdvertisementInfo.clickPos = i;
        a(paramActivity, paramAbsBaseArticleInfo, paramInt, paramAdJumpParams);
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramIReadInJoyBaseAdapter != null) {
          paramIReadInJoyBaseAdapter.notifyDataSetChanged();
        }
        return paramAdJumpParams;
      case 2: 
        return d(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean1, paramAdJumpParams);
      }
      return a(paramActivity, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt, paramAdJumpParams);
    }
    return localInteger1;
  }
  
  public static Integer a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    paramIReadInJoyBaseAdapter = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, null);
    if (paramIReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    return b(paramIReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    paramIReadInJoyBaseAdapter = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (paramIReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    return b(paramIReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramIReadInJoyBaseAdapter = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean1, null);
    if (paramIReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    paramIReadInJoyBaseAdapter.l = paramBoolean2;
    return b(paramIReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer a(Context paramContext, AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject = Integer.valueOf(-1);
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (paramAdData != null))
    {
      if (paramAdvertisementInfo == null) {
        return localObject;
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramAdData))
      {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramContext);
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(paramAdvertisementInfo);
        paramContext = FastWeqAdUtils.a(paramContext, paramAdData);
        localObject = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a((AppInterface)localObject).a(BaseApplication.getContext()).a(1).b(25).b(paramContext).a(paramAdvertisementInfo).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdData)));
        return paramContext;
      }
    }
    return localObject;
  }
  
  public static Integer a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramParams == null) {
      return Integer.valueOf(-1);
    }
    return b(paramParams, paramContext, paramAdvertisementInfo);
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      paramAbsBaseArticleInfo = ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo;
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
        return "";
      }
      try
      {
        paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo).optString(paramString);
        return paramAbsBaseArticleInfo;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("http"))
      {
        localObject = paramString;
        if (!paramString.startsWith("https")) {}
      }
      else
      {
        String str = paramString;
        try
        {
          if (QLog.isColorLevel())
          {
            str = paramString;
            localObject = new StringBuilder();
            str = paramString;
            ((StringBuilder)localObject).append("appendUrlParameter, before url:");
            str = paramString;
            ((StringBuilder)localObject).append(paramString);
            str = paramString;
            QLog.e("ReadinJoyActionUtil", 0, ((StringBuilder)localObject).toString());
          }
          str = paramString;
          localObject = Uri.parse(paramString).buildUpon();
          str = paramString;
          ((Uri.Builder)localObject).appendQueryParameter("adclickts", String.valueOf(System.currentTimeMillis()));
          str = paramString;
          paramString = ((Uri.Builder)localObject).build().toString();
          str = paramString;
          localObject = paramString;
          if (QLog.isColorLevel())
          {
            str = paramString;
            localObject = new StringBuilder();
            str = paramString;
            ((StringBuilder)localObject).append("appendUrlParameter, after url:");
            str = paramString;
            ((StringBuilder)localObject).append(paramString);
            str = paramString;
            QLog.e("ReadinJoyActionUtil", 0, ((StringBuilder)localObject).toString());
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          localObject = str;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("appendUrlParameter, url:");
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(" , error:");
            ((StringBuilder)localObject).append(paramString.getMessage());
            QLog.e("ReadinJoyActionUtil", 0, ((StringBuilder)localObject).toString());
            localObject = str;
          }
        }
      }
    }
    return localObject;
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo, null);
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if (paramAdvertisementInfo == null) {
      return null;
    }
    Object localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).advertiser_id.set(paramAdvertisementInfo.mAdAdvertiseId);
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdCorporateLogo)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_logo.set(paramAdvertisementInfo.mAdCorporateLogo);
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdCorporateImageName)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_image_name.set(paramAdvertisementInfo.mAdCorporateImageName);
    }
    Object localObject4 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
    if (paramAdvertisementInfo.mAdVideoUrl != null) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject4).video_url.set(paramAdvertisementInfo.mAdVideoUrl);
    }
    Object localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).advertiser_info.set((MessageMicro)localObject1);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).video_info.set((MessageMicro)localObject4);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).mini_program_type.set(paramAdvertisementInfo.miniProgramType);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject3).basic_info.img.set(paramAdvertisementInfo.mAdImg);
    Object localObject5 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject5).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject5).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject5).view_id.set(paramAdvertisementInfo.mAdViewId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject5).product_id.set(paramAdvertisementInfo.mAdProductId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject5).via.set(paramAdvertisementInfo.mAdVia);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject5).noco_id.set(paramAdvertisementInfo.mAdNocoId);
    localObject4 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject4).exposure_url.set(paramAdvertisementInfo.mAdApurl);
    localObject1 = paramAdvertisementInfo.mAdRl;
    Object localObject6 = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if ((paramAdvertisementInfo.mChannelID == 0L) && (localObject6 != null))
    {
      localObject6 = (ReadInjoyADExposureManager)((QQAppInterface)localObject6).getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
      if (localObject6 != null)
      {
        i = ((ReadInjoyADExposureManager)localObject6).a(paramAdvertisementInfo, paramIReadInJoyBaseAdapter);
        if (i > 0)
        {
          l = ((ReadInjoyADExposureManager)localObject6).a(paramAdvertisementInfo);
          paramIReadInJoyBaseAdapter = ((String)localObject1).concat(String.format("&imp_per=%d&imp_dur=%d", new Object[] { Integer.valueOf(i), Long.valueOf(l) }));
          break label381;
        }
        l = 0L;
        paramIReadInJoyBaseAdapter = (IReadInJoyBaseAdapter)localObject1;
        break label381;
      }
    }
    long l = 0L;
    int i = 0;
    paramIReadInJoyBaseAdapter = (IReadInJoyBaseAdapter)localObject1;
    label381:
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject4).click_url.set(paramIReadInJoyBaseAdapter);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject4).effect_url.set(paramAdvertisementInfo.mAdEffectUrl);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject4).landing_page_report_url.set(paramAdvertisementInfo.mAdLandingPageReportUrl);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject4).trace_info.set((MessageMicro)localObject5);
    paramIReadInJoyBaseAdapter = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
    if (paramAdvertisementInfo.mCToSClickUrl != null) {
      paramIReadInJoyBaseAdapter.api_click_monitor_url.set(paramAdvertisementInfo.mCToSClickUrl);
    }
    if (paramAdvertisementInfo.mCToSExposureUrl != null) {
      paramIReadInJoyBaseAdapter.api_exposure_monitor_url.set(paramAdvertisementInfo.mCToSExposureUrl);
    }
    if (paramAdvertisementInfo.mC2SVideoPlayUrl != null) {
      paramIReadInJoyBaseAdapter.video_play_monitor_url.set(paramAdvertisementInfo.mC2SVideoPlayUrl);
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject4).thirdparty_monitor_urls.set(paramIReadInJoyBaseAdapter);
    localObject6 = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
    localObject1 = paramAdvertisementInfo.mAdLandingPage;
    paramIReadInJoyBaseAdapter = (IReadInJoyBaseAdapter)localObject1;
    if (paramAdvertisementInfo.mAdvertisementExtInfo != null)
    {
      paramIReadInJoyBaseAdapter = (IReadInJoyBaseAdapter)localObject1;
      if (paramAdvertisementInfo.mAdvertisementExtInfo.o == 32768) {
        paramIReadInJoyBaseAdapter = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).appendUrlParameter((String)localObject1);
      }
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject6).landing_page.set(paramIReadInJoyBaseAdapter);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject6).canvas_json.set(paramAdvertisementInfo.mAdCanvasJson);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject6).dest_type.set(paramAdvertisementInfo.mAdDestType);
    localObject5 = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
    paramIReadInJoyBaseAdapter = GdtBaseAdItem.a(paramAdvertisementInfo.mAdExt);
    ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject5).app_package_name.set(paramIReadInJoyBaseAdapter.a);
    try
    {
      localObject1 = new JSONObject(paramAdvertisementInfo.mAdExt);
      paramIReadInJoyBaseAdapter = ((JSONObject)localObject1).optString("pkgurl");
      try
      {
        localObject1 = ((JSONObject)localObject1).optString("appname");
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramIReadInJoyBaseAdapter = null;
    }
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramIReadInJoyBaseAdapter)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject5).pkg_url.set(paramIReadInJoyBaseAdapter);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject5).app_name.set((String)localObject2);
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject5).android_app_id.set(paramAdvertisementInfo.mAdProductId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject5).pkg_download_schema.set(paramAdvertisementInfo.mAdAppDownLoadSchema);
    ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject5).customized_invoke_url.set(paramAdvertisementInfo.mAdCustomizedInvokeUrl);
    if (QLog.isColorLevel())
    {
      paramIReadInJoyBaseAdapter = new StringBuilder();
      paramIReadInJoyBaseAdapter.append("getAdInfoParams  mSubordinateProductId= ");
      paramIReadInJoyBaseAdapter.append(paramAdvertisementInfo.mSubordinateProductId);
      QLog.d("ReadinJoyActionUtil", 0, paramIReadInJoyBaseAdapter.toString());
    }
    localObject2 = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject5).channel_id;
    if (paramAdvertisementInfo.mSubordinateProductId == null) {
      paramIReadInJoyBaseAdapter = "";
    } else {
      paramIReadInJoyBaseAdapter = paramAdvertisementInfo.mSubordinateProductId;
    }
    ((PBStringField)localObject2).set(paramIReadInJoyBaseAdapter);
    if ((ReadInJoyAdUtils.i(paramAdvertisementInfo)) && (paramAdvertisementInfo.mAdvertisementExtInfo.m != null) && (paramAdvertisementInfo.mAdvertisementExtInfo.m.size() >= 2))
    {
      AdPKImageData localAdPKImageData = b(paramAdvertisementInfo);
      if (localAdPKImageData != null)
      {
        if (!TextUtils.isEmpty(localAdPKImageData.b))
        {
          localObject2 = localAdPKImageData.b;
          paramIReadInJoyBaseAdapter = (IReadInJoyBaseAdapter)localObject2;
          if (paramAdvertisementInfo.mChannelID == 0L) {
            paramIReadInJoyBaseAdapter = ((String)localObject2).concat(String.format("&imp_per=%d&imp_dur=%d", new Object[] { Integer.valueOf(i), Long.valueOf(l) }));
          }
          ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject4).click_url.set(paramIReadInJoyBaseAdapter);
        }
        if (!TextUtils.isEmpty(localAdPKImageData.a)) {
          ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject6).landing_page.set(localAdPKImageData.a);
        }
      }
    }
    paramIReadInJoyBaseAdapter = new qq_ad_get.QQAdGetRsp.AdInfo();
    paramIReadInJoyBaseAdapter.product_type.set(paramAdvertisementInfo.mAdProductType);
    paramIReadInJoyBaseAdapter.display_info.set((MessageMicro)localObject3);
    paramIReadInJoyBaseAdapter.report_info.set((MessageMicro)localObject4);
    paramIReadInJoyBaseAdapter.dest_info.set((MessageMicro)localObject6);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo();
    localObject3 = paramAdvertisementInfo.mAdExtInfo;
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        ((qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo)localObject2).ad_trace_data.set(((JSONObject)localObject3).optString("wechat_ad_trace_data"));
        ((qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo)localObject2).app_id.set(((JSONObject)localObject3).optString("wxappid"));
        ((qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo)localObject2).app_path.set(((JSONObject)localObject3).optString("wechat_app_path"));
        ((qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo)localObject2).app_token.set(((JSONObject)localObject3).optString("wechat_app_token"));
        ((qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo)localObject2).app_username.set(((JSONObject)localObject3).optString("wechat_app_username"));
        ((qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo)localObject2).pos_id.set(paramAdvertisementInfo.mAdPosID);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    paramIReadInJoyBaseAdapter.wechat_app_info.set((MessageMicro)localObject2);
    paramIReadInJoyBaseAdapter.app_info.set((MessageMicro)localObject5);
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdExt))
    {
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExt).optString("sdk_data", "");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getAdInfoParams  advertisementInfo sdkData:");
          ((StringBuilder)localObject2).append(paramAdvertisementInfo);
          QLog.d("ReadinJoyActionUtil", 0, ((StringBuilder)localObject2).toString());
        }
        paramIReadInJoyBaseAdapter.ext_json.set(paramAdvertisementInfo);
        return paramIReadInJoyBaseAdapter;
      }
      catch (Exception paramAdvertisementInfo)
      {
        if (!QLog.isColorLevel()) {
          return paramIReadInJoyBaseAdapter;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAdInfoParams  parse adext error message= ");
      ((StringBuilder)localObject2).append(paramAdvertisementInfo.getMessage());
      QLog.d("ReadinJoyActionUtil", 0, ((StringBuilder)localObject2).toString());
      return paramIReadInJoyBaseAdapter;
    }
    else
    {
      paramIReadInJoyBaseAdapter.ext_json.set("");
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyActionUtil", 0, "getAdInfoParams  advertisementInfo.mAdExt=null");
      }
    }
    return paramIReadInJoyBaseAdapter;
  }
  
  public static void a()
  {
    if ((BaseApplicationImpl.getContext() != null) && (a != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(a);
      a = null;
    }
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    if ((paramIReadInJoyBaseAdapter != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt, Integer.valueOf(0));
    }
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
    if (paramIReadInJoyBaseAdapter != null) {
      localBundle.putLong("param_ad_app_info_video_playposition", paramIReadInJoyBaseAdapter.f());
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).startReadInJoyNativeAdAppFragment(paramActivity, localBundle);
  }
  
  public static void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, Integer paramInteger)
  {
    Object localObject2 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getSpecialFeedsSource(paramAbsBaseArticleInfo);
    int j;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      j = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      j = 0;
    }
    int m = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true;
    if (paramAbsBaseArticleInfo.videoJumpChannelID > 0) {
      i = paramAbsBaseArticleInfo.videoJumpChannelID;
    } else {
      i = 56;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, j), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, j));
    Object localObject3 = ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).getClickT(paramAbsBaseArticleInfo.mChannelID);
    Object localObject4;
    int k;
    Object localObject5;
    if ((!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGCSocial(paramAbsBaseArticleInfo)) && (!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGC(paramAbsBaseArticleInfo)) && (!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGCRecommendTopic(paramAbsBaseArticleInfo)) && (!((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isUGCRecommendTopicSocial(paramAbsBaseArticleInfo)))
    {
      localObject1 = ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, j, m, NetworkUtil.isWifiConnected(paramActivity), (String)localObject2, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getAccountType(paramAbsBaseArticleInfo), i, paramAbsBaseArticleInfo);
      if (paramInt == 0)
      {
        localObject4 = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getVideoSessionId(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyChannelActivityClazz());
        localObject1 = ((IVideoReporter)QRoute.api(IVideoReporter.class)).addJump2ChannelAndVieoSessionID2R5(i, (String)localObject4, (String)localObject1);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), (String)localObject1, false);
      k = i;
    }
    else
    {
      localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      long l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
      localObject4 = Long.toString(paramAbsBaseArticleInfo.mFeedId);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramAbsBaseArticleInfo.businessId);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      String str1 = Integer.toString(paramAbsBaseArticleInfo.mStrategyId);
      IRIJTransMergeKanDianReport localIRIJTransMergeKanDianReport = (IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class);
      long l2 = paramAbsBaseArticleInfo.mAlgorithmID;
      int n = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo);
      boolean bool = NetworkUtil.isWifiConnected(paramActivity);
      long l3 = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      String str2 = paramAbsBaseArticleInfo.mStrCircleId;
      String str3 = paramAbsBaseArticleInfo.innerUniqueID;
      String str4 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getAccountType(paramAbsBaseArticleInfo);
      k = i;
      ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(l1), (String)localObject3, (String)localObject3, 0, 0, (String)localObject4, (String)localObject5, str1, localIRIJTransMergeKanDianReport.transMergeKandianReportR5WithTime(l2, n, paramInt, j, m, bool, String.valueOf(l3), str2, str3, str4, i, paramAbsBaseArticleInfo), false);
    }
    int i = paramInt;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject3, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, j, m, NetworkUtil.isWifiConnected(paramActivity), (String)localObject2, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getAccountType(paramAbsBaseArticleInfo), k, paramAbsBaseArticleInfo));
    Object localObject1 = new ArrayList();
    localObject2 = new ReportInfo();
    ((ReportInfo)localObject2).mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    ((ReportInfo)localObject2).mSource = 0;
    ((ReportInfo)localObject2).mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    ((ReportInfo)localObject2).mChannelId = i;
    ((ReportInfo)localObject2).mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    ((ReportInfo)localObject2).mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    ((ReportInfo)localObject2).mOperation = 1;
    ((ReportInfo)localObject2).mServerContext = paramAbsBaseArticleInfo.mServerContext;
    ((ReportInfo)localObject2).mReadTimeLength = -1;
    ((ReportInfo)localObject2).mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      localObject3 = new FeedsReportData();
      ((FeedsReportData)localObject3).a = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
        ((FeedsReportData)localObject3).b = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      }
      ((FeedsReportData)localObject3).d = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
      ((FeedsReportData)localObject3).e = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
      localObject4 = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
      {
        ((FeedsReportData)localObject3).c = new ArrayList();
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (FeedsInfoUser)((Iterator)localObject4).next();
          if (localObject5 != null) {
            ((FeedsReportData)localObject3).c.add(Long.valueOf(((FeedsInfoUser)localObject5).a));
          }
        }
      }
      ((ReportInfo)localObject2).mFeedsReportData = ((FeedsReportData)localObject3);
    }
    ((List)localObject1).add(localObject2);
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a((List)localObject1);
    ((IRIJFeedsInsertUtil)QRoute.api(IRIJFeedsInsertUtil.class)).updateLastClickArticleInfo(i, paramAbsBaseArticleInfo);
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      if (paramAbsBaseArticleInfo.mChannelID == 56L)
      {
        paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
        VideoAdClickRecorder.a(paramAbsBaseArticleInfo);
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(1).b(15).b(paramInteger).a(paramAbsBaseArticleInfo).c(paramAbsBaseArticleInfo.clickPos));
        return;
      }
      localObject1 = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if ((ReadInJoyAdUtils.l((AdvertisementInfo)localObject1)) && (ReadInJoySuperMaskAdUtil.a)) {
        paramInt = 37;
      } else if (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).checkConditionForJumpToGdt((AdvertisementInfo)localObject1, i)) {
        paramInt = 8;
      } else if (((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAbsBaseArticleInfo)) {
        paramInt = 11;
      } else {
        paramInt = 3;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(1).b(paramInt).b(paramInteger).a((AdvertisementInfo)localObject1).c(((AdvertisementInfo)localObject1).clickPos));
    }
  }
  
  public static void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (LiujinAdJump.isFromLiuJin(localAdvertisementInfo))
      {
        Integer localInteger = LiujinAdJump.doJumpAction(localAdvertisementInfo, paramActivity, paramBoolean);
        if (localInteger.intValue() != -1)
        {
          a(paramActivity, paramAbsBaseArticleInfo, paramInt, localInteger);
          return;
        }
      }
      switch (localAdvertisementInfo.mAdJumpMode)
      {
      default: 
      case 5: 
        b(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, true);
        return;
      case 4: 
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdAppJson))
        {
          a(paramActivity, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt, paramAdJumpParams);
          return;
        }
        a(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, true);
        return;
      case 3: 
        int i = localAdvertisementInfo.clickPos;
        paramAdJumpParams = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).gotoAdvVideoCellPage(paramActivity, localAdvertisementInfo, null, paramInt, paramBoolean, paramAdJumpParams);
        localAdvertisementInfo.clickPos = i;
        a(paramActivity, paramAbsBaseArticleInfo, paramInt, paramAdJumpParams);
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramIReadInJoyBaseAdapter != null)
        {
          paramIReadInJoyBaseAdapter.notifyDataSetChanged();
          return;
        }
        break;
      case 2: 
        d(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
        return;
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        a(paramActivity, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt, paramAdJumpParams);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("ad", paramAdvertisementInfo);
    localIntent.putExtra("fragmentClass", ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyAdIMAXBrowserFragmentClazz());
    localIntent.setClass(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130771996, 17432577);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(paramContext, 7);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeFloatWindow error:");
        localStringBuilder.append(paramContext.getMessage());
        QLog.e("ReadinJoyActionUtil", 0, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    int j = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true;
    String str1 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getSpecialFeedsSource(paramAbsBaseArticleInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, i), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, i));
    String str2 = ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).getClickT(paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getAccountType(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse(str2, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getAccountType(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo));
    ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).doArticleClickEvent64Report(paramAbsBaseArticleInfo, paramInt);
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      if (paramAbsBaseArticleInfo.mChannelID == 56L) {
        paramInt = 4;
      } else if (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).checkConditionForJumpToGdt((AdvertisementInfo)paramAbsBaseArticleInfo, paramInt)) {
        paramInt = 8;
      } else if (((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAbsBaseArticleInfo)) {
        paramInt = 11;
      } else {
        paramInt = 3;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(1).b(paramInt).a((AdvertisementInfo)paramAbsBaseArticleInfo));
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, Integer paramInteger)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(1).b(paramInt2).b(paramInteger).a((AdvertisementInfo)paramAbsBaseArticleInfo).e(new JSONObject()));
      b(paramContext, paramAbsBaseArticleInfo, paramInt1);
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, Integer paramInteger)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      int i;
      if (paramAbsBaseArticleInfo.mChannelID == 56L)
      {
        i = 4;
      }
      else
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
        if ((ReadInJoyAdUtils.l(localAdvertisementInfo)) && (ReadInJoySuperMaskAdUtil.a))
        {
          i = 37;
        }
        else if (((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).checkConditionForJumpToGdt(localAdvertisementInfo, paramInt))
        {
          i = 8;
        }
        else if (((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAbsBaseArticleInfo))
        {
          i = 11;
        }
        else
        {
          if ((ReadInJoyAdUtils.i(localAdvertisementInfo)) && (localAdvertisementInfo.isClickFromPkFragment)) {
            return;
          }
          if (localAdvertisementInfo.isCommentAd()) {
            i = 38;
          } else {
            i = 3;
          }
        }
      }
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).reportDataWhenClickForAdOrigin(paramContext, paramAbsBaseArticleInfo, paramInt, i, paramInteger);
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt)
  {
    a(paramContext, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt, false);
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    if ((paramIReadInJoyBaseAdapter != null) && (paramAbsBaseArticleInfo != null) && ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) && ((paramContext instanceof Activity)))
    {
      paramIReadInJoyBaseAdapter.a((GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramContext, (AdvertisementInfo)paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, null));
      long l;
      if (paramIReadInJoyBaseAdapter.g() != null) {
        l = SystemClock.elapsedRealtime();
      } else {
        l = -2147483648L;
      }
      paramIReadInJoyBaseAdapter.a(l);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("h5url", paramString1);
      localIntent.putExtra("adrl", paramString2);
      localIntent.putExtra("traceId", paramString3);
      localIntent.putExtra("fragmentClass", ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyAdPopSheetBrowserFragmentClazz());
      localIntent.setClass(BaseApplicationImpl.getApplication(), QQTranslucentBrowserActivity.class);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(ViewBase paramViewBase, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt1, int paramInt2)
  {
    b(paramViewBase, null, paramActivity, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt1, paramInt2);
  }
  
  public static void a(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt1, int paramInt2)
  {
    if ((paramViewBase2 != null) && (paramActivity != null))
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      b(paramViewBase1, paramViewBase2, paramActivity, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter, paramInt1, paramInt2);
      paramViewBase1 = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
      if (paramViewBase1 != null)
      {
        paramViewBase1 = (ReadInjoyADExposureManager)paramViewBase1.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
        if (paramViewBase1 != null) {
          paramViewBase1.a(paramIReadInJoyBaseAdapter, paramActivity, false);
        }
      }
    }
  }
  
  public static void a(GdtHandler.Params paramParams, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if (a(paramAdvertisementInfo, paramContext))
    {
      paramParams.f = false;
      paramParams.g = false;
      return;
    }
    if ((!ReadInJoyAdUtils.t(paramAdvertisementInfo)) && (!ReadInJoyAdUtils.z(paramAdvertisementInfo)) && (!ReadInJoyAdUtils.w(paramAdvertisementInfo)) && (!ReadInJoyAdUtils.x(paramAdvertisementInfo)))
    {
      paramParams.f = true;
      paramParams.g = true;
      return;
    }
    paramParams.f = false;
    paramParams.g = false;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5);
  }
  
  public static boolean a(Context paramContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      boolean bool = ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, ((AdvertisementInfo)paramAbsBaseArticleInfo).mAdLandingPage, paramInt, null);
      if (bool) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean a(Context paramContext, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramIReadInJoyBaseAdapter != null)
    {
      if (paramIReadInJoyBaseAdapter.c() != 0) {
        return false;
      }
      if (!ReadInJoyAdUtils.q(paramAbsBaseArticleInfo)) {
        return false;
      }
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).preParseArticleJsonParam(paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo.innerUniqueID = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdExtParam(paramAbsBaseArticleInfo, "landing_page_rowkey");
      AdHandler.ItemViewBuilder localItemViewBuilder = a(paramIReadInJoyBaseAdapter, paramAbsBaseArticleInfo.innerUniqueID);
      if (localItemViewBuilder != null)
      {
        a(paramContext, paramAbsBaseArticleInfo, paramIReadInJoyBaseAdapter.c(), Integer.valueOf(25));
        paramIReadInJoyBaseAdapter.a(localItemViewBuilder.a(), paramAbsBaseArticleInfo);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null)
    {
      QLog.e("ReadinJoyActionUtil", 3, "JumpToGdtAdPage error advertisementInfo is null");
      return false;
    }
    if (!(paramAdvertisementInfo instanceof AdvertisementInfo)) {
      return false;
    }
    if (ReadInJoyAdUtils.q(paramAdvertisementInfo)) {
      return false;
    }
    if ((paramInt != 2) && (paramInt != 5) && (paramInt != 3) && (paramInt != 56) && (paramInt != 4) && (paramInt != 2000001) && (paramInt != 95555552) && ((!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(paramInt)) || (a(paramAdvertisementInfo.mAdJumpMode)) || (!c.contains(Integer.valueOf(paramAdvertisementInfo.mAdProductType)))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readInjoy product not go Gdt QQB channelId:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" AdProductType:");
      localStringBuilder.append(paramAdvertisementInfo.mAdProductType);
      QLog.e("ReadinJoyActionUtil", 3, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo)) && (!ReadInJoyAdUtils.a(paramAdvertisementInfo))) {
      return false;
    }
    if (paramAdvertisementInfo.mAdProductType != 30)
    {
      if (paramAdvertisementInfo.mAdProductType == 41) {
        return false;
      }
      return ((paramAdvertisementInfo.mAdProductType != 1000) && (paramAdvertisementInfo.mAdProductType != 25)) || (a(paramAdvertisementInfo.mAdCustomizedInvokeUrl, paramContext));
    }
    return false;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((b) && ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)))
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if ((paramAbsBaseArticleInfo.mAdFeedId != 0L) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mAdInteractionReportUrl))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ViewBase paramViewBase, Activity paramActivity, int paramInt, IVideoPlayManager paramIVideoPlayManager, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo.mImaxShowAdType != 1001) && (paramAdvertisementInfo.mImaxShowAdType != 1002)) {
      return false;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
    if (localAdvertisementInfo.isHideForAnimate) {
      return true;
    }
    if (paramAdvertisementInfo.mImaxShowAdType == 1001)
    {
      localObject1 = paramViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
      if ((localObject1 != null) && (((ViewBase)localObject1).getNativeView() != null) && (((ViewBase)localObject1).getNativeView().getVisibility() == 0))
      {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startImaxNativeLoadingPage(paramActivity, paramAdvertisementInfo.mAdLandingPage, paramAdvertisementInfo);
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).reportDataWhenClickForAdOrigin(paramActivity, paramAbsBaseArticleInfo, paramInt, 29, Integer.valueOf(23));
        return true;
      }
    }
    Object localObject1 = null;
    if (paramAdvertisementInfo.mImaxShowAdType == 1002)
    {
      ViewBase localViewBase = paramViewBase.findViewBaseByName("idArticleDoubleImage");
      localObject2 = localViewBase;
      if (localViewBase == null) {
        localObject2 = paramViewBase.findViewBaseByName("id_article_double_image");
      }
      if (localObject2 != null) {
        localObject1 = ((ViewBase)localObject2).getNativeView();
      }
    }
    else
    {
      localObject2 = paramViewBase.findViewBaseByName("id_article_large_imge");
      if (localObject2 != null) {
        localObject1 = ((ViewBase)localObject2).getNativeView();
      }
    }
    localAdvertisementInfo.isHideForAnimate = true;
    if (paramIVideoPlayManager != null)
    {
      paramIVideoPlayManager.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
      paramIVideoPlayManager.a(0);
    }
    Object localObject2 = new int[2];
    paramIVideoPlayManager = paramViewBase.getNativeView();
    if (localObject1 != null)
    {
      if ((localObject1 instanceof NativeReadInjoyImageView))
      {
        ReadInjoyIMAXAdFragment.e = ((NativeReadInjoyImageView)localObject1).getDrawable();
      }
      else if ((localObject1 instanceof FrameLayout))
      {
        paramIVideoPlayManager = (FrameLayout)localObject1;
        if (paramIVideoPlayManager.getChildCount() > 0)
        {
          paramIVideoPlayManager = paramIVideoPlayManager.getChildAt(0);
          if ((paramIVideoPlayManager instanceof NativeReadInjoyImageView)) {
            ReadInjoyIMAXAdFragment.e = ((NativeReadInjoyImageView)paramIVideoPlayManager).getDrawable();
          }
        }
      }
      paramIVideoPlayManager = (IVideoPlayManager)localObject1;
    }
    paramIVideoPlayManager.getLocationOnScreen((int[])localObject2);
    if (localAdvertisementInfo.mImaxShowAdType == 1001)
    {
      localObject1 = paramViewBase.findViewBaseByName("id_video_bg");
      if (localObject1 != null) {
        ((ViewBase)localObject1).getNativeView().setVisibility(4);
      }
      localObject1 = paramViewBase.findViewBaseByName("idViewAdCompleteGudie");
      if (localObject1 != null) {
        ((ViewBase)localObject1).getNativeView().setVisibility(4);
      }
      localObject1 = paramViewBase.findViewBaseByName("idLargeVideoIcon");
      if (localObject1 != null) {
        ((ViewBase)localObject1).getNativeView().setVisibility(4);
      }
      localObject1 = paramViewBase.findViewBaseByName("idLargeVideoDuration");
      if (localObject1 != null) {
        ((ViewBase)localObject1).getNativeView().setVisibility(4);
      }
      if (localAdvertisementInfo.isIMaxAndNewStyle)
      {
        paramViewBase = paramViewBase.findViewBaseByName("idArtilceTitle");
        if (paramViewBase != null) {
          paramViewBase.getNativeView().setVisibility(4);
        }
      }
    }
    int i = localObject2[1];
    int j = localObject2[0];
    int k = paramIVideoPlayManager.getWidth();
    int m = paramIVideoPlayManager.getHeight();
    paramViewBase = new ReadInjoyIMAXAdFragment.Param();
    paramViewBase.b = i;
    paramViewBase.a = j;
    paramViewBase.c = k;
    paramViewBase.d = m;
    paramViewBase.e = paramAdvertisementInfo;
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
    ReadInjoyIMAXAdFragment.a(paramActivity, paramViewBase);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).reportDataWhenClickForAdOrigin(paramActivity, paramAbsBaseArticleInfo, paramInt, 29, Integer.valueOf(23));
    return true;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if ((paramIReadInJoyBaseAdapter != null) && (paramIReadInJoyBaseAdapter.e() != null) && (paramIReadInJoyBaseAdapter.e().g()) && (paramIReadInJoyBaseAdapter.e().a() != null))
    {
      paramIReadInJoyBaseAdapter = paramIReadInJoyBaseAdapter.e().a();
      if ((paramIReadInJoyBaseAdapter.M) && (paramIReadInJoyBaseAdapter.D != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramIReadInJoyBaseAdapter.D)))
      {
        paramIReadInJoyBaseAdapter = (AdvertisementInfo)paramIReadInJoyBaseAdapter.D;
        if ((!TextUtils.isEmpty(paramIReadInJoyBaseAdapter.mAdTraceId)) && ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) && (paramIReadInJoyBaseAdapter.mAdTraceId.equals(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdTraceId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    try
    {
      paramContext = paramString.resolveActivityInfo(paramContext.getPackageManager(), 0);
      paramString = "";
      if (paramContext != null) {
        paramString = paramContext.packageName;
      }
      boolean bool = TextUtils.isEmpty(paramString);
      return bool ^ true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadinJoyActionUtil", 1, "resolveActivityInfo error!", paramString);
      }
    }
    return false;
  }
  
  private static AdPKImageData b(AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject3 = localObject5;
    if (paramAdvertisementInfo != null)
    {
      Object localObject2 = localObject4;
      localObject3 = localObject5;
      try
      {
        if (paramAdvertisementInfo.mAdvertisementExtInfo != null)
        {
          localObject2 = localObject4;
          localObject3 = localObject5;
          if (paramAdvertisementInfo.mAdvertisementExtInfo.m != null)
          {
            localObject2 = localObject4;
            localObject3 = localObject5;
            if (paramAdvertisementInfo.mAdvertisementExtInfo.m.size() >= 2)
            {
              localObject2 = localObject4;
              if (paramAdvertisementInfo.clickPos == 101)
              {
                localObject2 = localObject4;
                localObject1 = (AdPKImageData)paramAdvertisementInfo.mAdvertisementExtInfo.m.get(0);
              }
              localObject2 = localObject1;
              localObject3 = localObject1;
              if (paramAdvertisementInfo.clickPos == 102)
              {
                localObject2 = localObject1;
                paramAdvertisementInfo = (AdPKImageData)paramAdvertisementInfo.mAdvertisementExtInfo.m.get(1);
                return paramAdvertisementInfo;
              }
            }
          }
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handlePkImageData error: ");
          ((StringBuilder)localObject1).append(paramAdvertisementInfo.getMessage());
          QLog.e("ReadinJoyActionUtil", 3, ((StringBuilder)localObject1).toString());
          localObject3 = localObject2;
        }
      }
    }
    return localObject3;
  }
  
  public static Integer b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    Integer localInteger2 = Integer.valueOf(-1);
    Integer localInteger1;
    if (LiujinAdJump.isFromLiuJin(paramAdvertisementInfo)) {
      localInteger1 = LiujinAdJump.doJumpAction(paramAdvertisementInfo, paramContext, paramBoolean);
    } else {
      localInteger1 = localInteger2;
    }
    if (localInteger1.intValue() != -1)
    {
      a(paramContext, paramAdvertisementInfo, paramInt, localInteger1);
      return Integer.valueOf(10);
    }
    paramIReadInJoyBaseAdapter = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (paramIReadInJoyBaseAdapter == null) {
      return localInteger2;
    }
    return b(paramIReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer b(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramParams != null) && (paramAdvertisementInfo != null) && (paramContext != null))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(paramAdvertisementInfo);
      if ((paramAdvertisementInfo.mAdJumpMode == 7) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)))
      {
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramContext);
        if (QLog.isColorLevel()) {
          QLog.i("ReadinJoyActionUtil", 3, "JumpToGdtAdPage tovialo true");
        }
        return ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, paramAdvertisementInfo.mAdLandingPage);
      }
      if ((paramAdvertisementInfo.mAdvertisementExtInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo.o != 32)) {
        return ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramContext, paramAdvertisementInfo.mAdLandingPage);
      }
      GdtHandler.a(paramParams);
      if (QLog.isColorLevel()) {
        QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
      }
      return Integer.valueOf(10);
    }
    return Integer.valueOf(-1);
  }
  
  private static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    if ((paramIReadInJoyBaseAdapter != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt, Integer.valueOf(10));
    }
    Bundle localBundle = new Bundle();
    AdvertisementInfoHelper.a(localBundle, paramAdvertisementInfo);
    long l2 = 0L;
    long l1 = l2;
    if (paramIReadInJoyBaseAdapter != null)
    {
      l1 = l2;
      if (paramIReadInJoyBaseAdapter.e() != null)
      {
        l1 = l2;
        if (paramIReadInJoyBaseAdapter.e().a() != null)
        {
          l1 = l2;
          if (paramIReadInJoyBaseAdapter.e().a().j == paramAdvertisementInfo.mArticleID) {
            l1 = paramIReadInJoyBaseAdapter.f();
          }
        }
      }
    }
    localBundle.putLong("param_ad_app_info_video_playposition", l1);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).startNativeAdVideoFragment(paramActivity, localBundle);
  }
  
  public static void b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramAdvertisementInfo.clickPos;
    paramIReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean1, paramBoolean2);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt, paramIReadInJoyBaseAdapter);
  }
  
  private static void b(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
    String str1 = ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getSpecialFeedsSource(paramAbsBaseArticleInfo);
    String str2 = ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).getClickT(paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramAbsBaseArticleInfo.mAlgorithmID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).checkArticleType(paramAbsBaseArticleInfo), paramInt, i, bool ^ true, NetworkUtil.isWifiConnected(paramContext), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, ((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).getAccountType(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo), false);
  }
  
  public static void b(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt1, int paramInt2)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).setAdapterMonitorClickAdParams(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt1);
      int i;
      if ((paramInt2 == 6) && ((paramIReadInJoyBaseAdapter == null) || (paramIReadInJoyBaseAdapter.e() == null) || (!paramIReadInJoyBaseAdapter.e().g()))) {
        i = 5;
      } else {
        i = paramInt2;
      }
      if (paramInt2 == 103) {
        i = 101;
      }
      if (paramInt2 == 104) {
        i = 102;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, i, null);
      IVideoPlayManager localIVideoPlayManager;
      if (paramIReadInJoyBaseAdapter != null) {
        localIVideoPlayManager = paramIReadInJoyBaseAdapter.e();
      } else {
        localIVideoPlayManager = null;
      }
      if ((ReadInJoyAdUtils.i(localAdvertisementInfo)) && ((paramInt2 == 4) || (paramInt2 == 3) || (paramInt2 == 1) || (paramInt2 == 1000)))
      {
        if (paramInt2 == 1) {
          i = 3;
        }
        ReadInJoyAdUtils.a(paramActivity, 1);
        ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).closeFloatWindow(paramActivity);
        a(paramActivity, localAdvertisementInfo);
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(1).b(31).b(Integer.valueOf(24)).a(localAdvertisementInfo).c(i));
        return;
      }
      if ((paramViewBase1 != null) && (a(paramAbsBaseArticleInfo, paramViewBase1, paramActivity, paramInt1, localIVideoPlayManager, localAdvertisementInfo))) {
        return;
      }
      boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt2);
      paramViewBase1 = new AdJumpParams();
      if (paramInt2 == 8) {
        paramViewBase1.c = true;
      }
      if (a(paramActivity, paramIReadInJoyBaseAdapter, paramAbsBaseArticleInfo)) {
        return;
      }
      try
      {
        if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(paramAbsBaseArticleInfo)) && (paramViewBase2 != null) && (paramViewBase2.getNativeView() != null))
        {
          paramViewBase1.e = new Rect();
          paramViewBase2.getNativeView().getGlobalVisibleRect(paramViewBase1.e);
          paramViewBase1.f = 0;
        }
      }
      catch (Exception paramViewBase2)
      {
        paramViewBase2.printStackTrace();
      }
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport(paramActivity, localAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt1, bool, ReadInJoyAdSwitchUtil.e(localAdvertisementInfo), paramViewBase1);
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : doAdClickAction");
    }
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    paramIReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, false, false, null);
    if (paramIReadInJoyBaseAdapter == null) {
      return false;
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).addVideoCeilingParameter(paramIReadInJoyBaseAdapter, true, paramAdvertisementInfo, paramContext);
    GdtHandler.a(paramIReadInJoyBaseAdapter);
    QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static GdtHandler.Params c(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    return a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, true, false, paramAdJumpParams);
  }
  
  public static Integer d(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    int i = paramAdvertisementInfo.clickPos;
    paramIReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt, paramIReadInJoyBaseAdapter);
    return paramIReadInJoyBaseAdapter;
  }
  
  public static Integer e(Context paramContext, AdvertisementInfo paramAdvertisementInfo, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    paramIReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramIReadInJoyBaseAdapter, paramInt, paramBoolean, false, false, paramAdJumpParams);
    if (paramIReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).addVideoCeilingParameter(paramIReadInJoyBaseAdapter, true, paramAdvertisementInfo, paramContext);
    return b(paramIReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinJoyActionUtil
 * JD-Core Version:    0.7.0.1
 */