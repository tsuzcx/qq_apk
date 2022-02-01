package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.NativeAd.report.VideoAdClickRecorder;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.common.AdvertisementInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdPopSheetBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.Param;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.AdParamsFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdPKImageData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.ItemViewBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class ReadinJoyActionUtil
{
  public static GdtAppReceiver a;
  private static ArrayList<Integer> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(12), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(41), Integer.valueOf(1000) }));
    jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    jdField_a_of_type_Boolean = false;
  }
  
  /* Error */
  private static AdPKImageData a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +141 -> 144
    //   6: aload_0
    //   7: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   10: ifnull +134 -> 144
    //   13: aload_0
    //   14: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   17: getfield 52	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   20: ifnull +124 -> 144
    //   23: aload_0
    //   24: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   27: getfield 52	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: invokeinterface 58 1 0
    //   35: iconst_2
    //   36: if_icmplt +108 -> 144
    //   39: aload_0
    //   40: getfield 62	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   43: bipush 101
    //   45: if_icmpne +20 -> 65
    //   48: aload_0
    //   49: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   52: getfield 52	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: iconst_0
    //   56: invokeinterface 66 2 0
    //   61: checkcast 68	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdPKImageData
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 62	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   69: bipush 102
    //   71: if_icmpne +71 -> 142
    //   74: aload_0
    //   75: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   78: getfield 52	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: iconst_1
    //   82: invokeinterface 66 2 0
    //   87: checkcast 68	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdPKImageData
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: invokestatic 74	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   101: ifeq -10 -> 91
    //   104: ldc 76
    //   106: iconst_3
    //   107: new 78	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   114: ldc 81
    //   116: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 89	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 96	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_0
    //   133: areturn
    //   134: astore_2
    //   135: aload_1
    //   136: astore_0
    //   137: aload_2
    //   138: astore_1
    //   139: goto -43 -> 96
    //   142: aload_1
    //   143: areturn
    //   144: aconst_null
    //   145: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	64	1	localAdPKImageData	AdPKImageData
    //   93	43	1	localException1	Exception
    //   138	5	1	localObject1	Object
    //   90	8	2	localObject2	Object
    //   134	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	39	93	java/lang/Exception
    //   39	65	93	java/lang/Exception
    //   65	91	134	java/lang/Exception
  }
  
  private static AdHandler.ItemViewBuilder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, String paramString)
  {
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramReadInJoyBaseAdapter.a();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int i = Math.max(localReadInJoyXListView.getHeaderViewsCount(), j);
    int k;
    if (i < paramReadInJoyBaseAdapter.a().size() + localReadInJoyXListView.getHeaderViewsCount())
    {
      k = i - localReadInJoyXListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = paramReadInJoyBaseAdapter.b(k);
      if ((66 == paramReadInJoyBaseAdapter.getItemViewType(k)) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < localReadInJoyXListView.getChildCount())) {
          paramReadInJoyBaseAdapter = localReadInJoyXListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if ((paramReadInJoyBaseAdapter != null) && ((paramReadInJoyBaseAdapter.getTag() instanceof AdHandler.ItemViewBuilder)))
      {
        return (AdHandler.ItemViewBuilder)paramReadInJoyBaseAdapter.getTag();
        if ((k >= 0) && (k < paramReadInJoyBaseAdapter.a().size())) {
          paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.getView(k, null, localReadInJoyXListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramReadInJoyBaseAdapter = null;
    }
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    return a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, true, false, paramAdJumpParams);
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AdJumpParams paramAdJumpParams)
  {
    if ((paramBoolean2) && (!a(paramAdvertisementInfo, paramInt))) {
      return null;
    }
    ReadInJoyGdtAdParams localReadInJoyGdtAdParams = new ReadInJoyGdtAdParams();
    localReadInJoyGdtAdParams.b = paramBoolean1;
    localReadInJoyGdtAdParams.d = paramBoolean3;
    if (paramAdJumpParams != null) {
      if (paramAdJumpParams.b) {
        break label105;
      }
    }
    label105:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localReadInJoyGdtAdParams.jdField_a_of_type_Boolean = paramBoolean1;
      localReadInJoyGdtAdParams.c = paramAdJumpParams.jdField_a_of_type_Boolean;
      localReadInJoyGdtAdParams.jdField_a_of_type_Long = paramAdJumpParams.jdField_a_of_type_Long;
      if (paramReadInJoyBaseAdapter != null) {
        localReadInJoyGdtAdParams.jdField_a_of_type_Long = paramReadInJoyBaseAdapter.a();
      }
      return AdParamsFactory.a(paramAdvertisementInfo, (Activity)paramContext, localReadInJoyGdtAdParams);
    }
  }
  
  public static Integer a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    paramAdJumpParams = a(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (paramAdJumpParams != null)
    {
      a(paramAdJumpParams, true, paramAdvertisementInfo, paramActivity);
      paramAdJumpParams = a(paramAdJumpParams, paramActivity, paramAdvertisementInfo);
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
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramAdJumpParams = Uri.parse((String)localObject).buildUpon();
      if ((NetworkUtil.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label353;
      }
      paramAdJumpParams.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramAdJumpParams = paramAdJumpParams.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramAdJumpParams);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label381;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      return a(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, 0, null);
      label353:
      paramAdJumpParams.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, 0, false);
    return Integer.valueOf(0);
    label381:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, 0, false);
      return Integer.valueOf(10);
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
    return Integer.valueOf(11);
  }
  
  public static Integer a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2, AdJumpParams paramAdJumpParams)
  {
    if (paramAdvertisementInfo == null) {
      paramAdJumpParams = Integer.valueOf(-1);
    }
    do
    {
      return paramAdJumpParams;
      localObject = a(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean1, paramAdJumpParams);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = paramBoolean2;
      if (paramAdJumpParams == null) {
        a((GdtHandler.Params)localObject, true, paramAdvertisementInfo, paramActivity);
      }
      localObject = a((GdtHandler.Params)localObject, paramActivity, paramAdvertisementInfo);
      paramAdJumpParams = (AdJumpParams)localObject;
    } while (((Integer)localObject).intValue() != -1);
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
    localGdtVideoData.setDirectPlay(paramBoolean2);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramAdJumpParams = (AdJumpParams)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramAdJumpParams = Uri.parse((String)localObject).buildUpon();
      if ((NetworkUtil.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label386;
      }
      paramAdJumpParams.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramAdJumpParams = paramAdJumpParams.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramAdJumpParams);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label414;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      return a(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, 0, null);
      label386:
      paramAdJumpParams.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, 0, false);
    return Integer.valueOf(0);
    label414:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, 0, false);
      return Integer.valueOf(10);
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
    return Integer.valueOf(11);
  }
  
  public static Integer a(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, AdJumpParams paramAdJumpParams)
  {
    if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
      return Integer.valueOf(-1);
    }
    if (paramInt == 0)
    {
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (paramReadInJoyBaseAdapter != null) {
        paramReadInJoyBaseAdapter.notifyDataSetChanged();
      }
    }
    int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
    Object localObject = (AdvertisementInfo)paramArticleInfo;
    boolean bool;
    if (i == 8)
    {
      bool = true;
      localObject = a(paramActivity, (AdvertisementInfo)localObject, paramReadInJoyBaseAdapter, paramInt, bool, paramAdJumpParams);
      if ((localObject != null) && (paramAdJumpParams == null)) {
        a((GdtHandler.Params)localObject, true, (AdvertisementInfo)paramArticleInfo, paramActivity);
      }
      paramReadInJoyBaseAdapter = a((GdtHandler.Params)localObject, paramActivity, (AdvertisementInfo)paramArticleInfo);
      ((AdvertisementInfo)paramArticleInfo).clickPos = i;
      if (paramReadInJoyBaseAdapter.intValue() != -1) {
        break label479;
      }
      paramAdJumpParams = paramArticleInfo.mArticleContentUrl;
      if (!ReadInJoyAdUtils.e((AdvertisementInfo)paramArticleInfo)) {
        break label466;
      }
      paramReadInJoyBaseAdapter = a((AdvertisementInfo)paramArticleInfo);
      if (paramReadInJoyBaseAdapter == null) {
        break label472;
      }
      paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a;
      if (TextUtils.isEmpty(paramReadInJoyBaseAdapter)) {
        break label466;
      }
      label165:
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) || (!NetworkUtil.h(null))) {
        break label463;
      }
      if (!paramReadInJoyBaseAdapter.contains("?")) {
        break label266;
      }
    }
    label266:
    for (paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter + "&";; paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter + "?")
    {
      paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter + "acttype=42";
      label231:
      a(paramActivity);
      if (!ReadInJoyAdUtils.h((AdvertisementInfo)paramArticleInfo)) {
        break label290;
      }
      paramReadInJoyBaseAdapter = RIJJumpUtils.a(paramActivity, paramReadInJoyBaseAdapter);
      a(paramActivity, paramArticleInfo, paramInt, paramReadInJoyBaseAdapter);
      return paramReadInJoyBaseAdapter;
      bool = false;
      break;
    }
    label290:
    paramAdJumpParams = new Intent(paramActivity, QQBrowserActivity.class);
    paramAdJumpParams.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramAdJumpParams.putExtra("url", paramReadInJoyBaseAdapter);
    paramAdJumpParams.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
    if ((localObject != null) && (((GdtHandler.Params)localObject).a != null))
    {
      if (((GdtHandler.Params)localObject).a.getNocoId() != 0L) {
        paramAdJumpParams.putExtra("GdtNocoId", ((GdtHandler.Params)localObject).a.getNocoId());
      }
      if (!TextUtils.isEmpty(((GdtHandler.Params)localObject).a.getUrlForEffect())) {
        paramAdJumpParams.putExtra("GdtWebReportQQ_ACTION_URL", ((GdtHandler.Params)localObject).a.getUrlForAction());
      }
      if (!TextUtils.isEmpty(((GdtHandler.Params)localObject).a.getTraceId())) {
        paramAdJumpParams.putExtra("GdtWebReportQQ_TRACE_ID", ((GdtHandler.Params)localObject).a.getTraceId());
      }
    }
    paramActivity.startActivity(paramAdJumpParams);
    paramReadInJoyBaseAdapter = Integer.valueOf(11);
    label463:
    label466:
    label472:
    label479:
    for (;;)
    {
      a(paramActivity, paramArticleInfo, paramInt, paramReadInJoyBaseAdapter);
      return paramReadInJoyBaseAdapter;
      break label231;
      paramReadInJoyBaseAdapter = paramAdJumpParams;
      break label165;
      paramReadInJoyBaseAdapter = "";
      break;
    }
  }
  
  public static Integer a(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2, AdJumpParams paramAdJumpParams)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return Integer.valueOf(-1);
    }
    if (LiujinAdJump.isFromLiuJin((AdvertisementInfo)paramArticleInfo))
    {
      Integer localInteger = LiujinAdJump.doJumpAction((AdvertisementInfo)paramArticleInfo, paramActivity, paramBoolean1);
      if (localInteger.intValue() != -1)
      {
        a(paramActivity, paramArticleInfo, paramInt, localInteger);
        return Integer.valueOf(10);
      }
    }
    if (paramAdJumpParams == null) {
      paramAdJumpParams = new AdJumpParams();
    }
    for (;;)
    {
      if ((((AdvertisementInfo)paramArticleInfo).mAdProductType == 6) && (a(paramActivity, 2086, paramArticleInfo)))
      {
        a(paramActivity, paramArticleInfo, paramInt, Integer.valueOf(6));
        if (paramInt == 0)
        {
          ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
          if (paramReadInJoyBaseAdapter != null) {
            paramReadInJoyBaseAdapter.notifyDataSetChanged();
          }
        }
        return Integer.valueOf(6);
      }
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return Integer.valueOf(-1);
      case 2: 
        return c(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean1, paramAdJumpParams);
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        return a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, paramAdJumpParams);
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson)) {
          return a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, null);
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, true);
        return Integer.valueOf(0);
      case 3: 
        paramAdJumpParams.jdField_a_of_type_Boolean = a(paramArticleInfo, paramReadInJoyBaseAdapter);
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        paramAdJumpParams = a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean1, paramBoolean2, paramAdJumpParams);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        a(paramActivity, paramArticleInfo, paramInt, paramAdJumpParams);
        ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramReadInJoyBaseAdapter != null) {
          paramReadInJoyBaseAdapter.notifyDataSetChanged();
        }
        return paramAdJumpParams;
      }
      b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, true);
      return Integer.valueOf(10);
    }
  }
  
  public static Integer a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, null);
    if (paramReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    return b(paramReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (paramReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    return b(paramReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean1, null);
    if (paramReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    paramReadInJoyBaseAdapter.f = paramBoolean2;
    return b(paramReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer a(Context paramContext, AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (paramAdData == null) || (paramAdvertisementInfo == null)) {
      return Integer.valueOf(-1);
    }
    if (FastWeqAdUtils.a(paramAdData))
    {
      a(paramContext);
      ReadInJoyAdUtils.b(paramAdvertisementInfo);
      paramContext = FastWeqAdUtils.a(paramContext, paramAdData);
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      NativeAdUtils.a(new AdReportData().a(localQQAppInterface).a(BaseApplication.getContext()).a(1).b(25).b(paramContext).a(paramAdvertisementInfo).d(NativeAdUtils.a(paramAdData)));
      return paramContext;
    }
    return Integer.valueOf(-1);
  }
  
  public static Integer a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramParams == null) {
      return Integer.valueOf(-1);
    }
    return b(paramParams, paramContext, paramAdvertisementInfo);
  }
  
  public static String a(ArticleInfo paramArticleInfo, String paramString)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      paramArticleInfo = ((AdvertisementInfo)paramArticleInfo).mAdExtInfo;
      if (!TextUtils.isEmpty(paramArticleInfo)) {}
    }
    else
    {
      return "";
    }
    try
    {
      paramArticleInfo = new JSONObject(paramArticleInfo).optString(paramString);
      return paramArticleInfo;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("http"))
      {
        localObject = paramString;
        if (!paramString.startsWith("https")) {}
      }
      else
      {
        str = paramString;
      }
    }
    try
    {
      if (QLog.isColorLevel())
      {
        str = paramString;
        QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, before url:" + paramString);
      }
      str = paramString;
      localObject = Uri.parse(paramString).buildUpon();
      str = paramString;
      ((Uri.Builder)localObject).appendQueryParameter("adclickts", String.valueOf(System.currentTimeMillis()));
      str = paramString;
      paramString = ((Uri.Builder)localObject).build().toString();
      localObject = paramString;
      str = paramString;
      if (QLog.isColorLevel())
      {
        str = paramString;
        QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, after url:" + paramString);
        localObject = paramString;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        localObject = str;
      } while (!QLog.isColorLevel());
      QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, url:" + str + " , error:" + paramString.getMessage());
    }
    return localObject;
    return str;
  }
  
  /* Error */
  public static qq_ad_get.QQAdGetRsp.AdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_1
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: new 655	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
    //   13: dup
    //   14: invokespecial 656	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: getfield 659	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:advertiser_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   22: aload_0
    //   23: getfield 662	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAdvertiseId	J
    //   26: invokevirtual 222	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   29: aload_0
    //   30: getfield 665	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   33: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +14 -> 50
    //   39: aload_1
    //   40: getfield 668	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_logo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   43: aload_0
    //   44: getfield 665	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   47: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 671	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   54: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +14 -> 71
    //   60: aload_1
    //   61: getfield 674	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_image_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: aload_0
    //   65: getfield 671	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   68: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   71: new 676	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
    //   74: dup
    //   75: invokespecial 677	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:<init>	()V
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 293	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: getfield 680	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: aload_0
    //   91: getfield 293	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   94: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   97: new 682	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
    //   100: dup
    //   101: invokespecial 683	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: getfield 687	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   109: aload_1
    //   110: invokevirtual 688	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   113: aload_3
    //   114: getfield 692	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   117: aload_2
    //   118: invokevirtual 693	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   121: aload_3
    //   122: getfield 697	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:mini_program_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: aload_0
    //   126: getfield 700	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:miniProgramType	I
    //   129: invokevirtual 704	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   132: new 208	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   135: dup
    //   136: invokespecial 209	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: getfield 213	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: aload_0
    //   145: getfield 216	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAid	J
    //   148: invokevirtual 222	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   151: aload_1
    //   152: getfield 226	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   155: aload_0
    //   156: getfield 230	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   159: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   162: aload_1
    //   163: getfield 238	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: aload_0
    //   167: getfield 241	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdViewId	Ljava/lang/String;
    //   170: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: getfield 707	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:product_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: aload_0
    //   178: getfield 710	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   181: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: getfield 713	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:via	Lcom/tencent/mobileqq/pb/PBStringField;
    //   188: aload_0
    //   189: getfield 716	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVia	Ljava/lang/String;
    //   192: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: getfield 720	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:noco_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   199: aload_0
    //   200: getfield 723	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdNocoId	J
    //   203: invokevirtual 726	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   206: new 243	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   209: dup
    //   210: invokespecial 244	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   213: astore 4
    //   215: aload 4
    //   217: getfield 247	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: aload_0
    //   221: getfield 250	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdApurl	Ljava/lang/String;
    //   224: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   227: aload 4
    //   229: getfield 253	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: aload_0
    //   233: getfield 256	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   236: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   239: aload 4
    //   241: getfield 729	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:effect_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   244: aload_0
    //   245: getfield 732	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdEffectUrl	Ljava/lang/String;
    //   248: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: getfield 735	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: aload_0
    //   257: getfield 738	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPageReportUrl	Ljava/lang/String;
    //   260: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   263: aload 4
    //   265: getfield 260	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   268: aload_1
    //   269: invokevirtual 263	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   272: new 740	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls
    //   275: dup
    //   276: invokespecial 741	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:<init>	()V
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 744	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   284: ifnull +14 -> 298
    //   287: aload_1
    //   288: getfield 748	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   291: aload_0
    //   292: getfield 744	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   295: invokevirtual 753	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   298: aload_0
    //   299: getfield 756	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   302: ifnull +14 -> 316
    //   305: aload_1
    //   306: getfield 759	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   309: aload_0
    //   310: getfield 756	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   313: invokevirtual 753	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   316: aload_0
    //   317: getfield 762	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   320: ifnull +14 -> 334
    //   323: aload_1
    //   324: getfield 765	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:video_play_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   327: aload_0
    //   328: getfield 762	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   331: invokevirtual 753	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   334: aload 4
    //   336: getfield 769	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   339: aload_1
    //   340: invokevirtual 770	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   343: new 772	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   346: dup
    //   347: invokespecial 773	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   350: astore 6
    //   352: aload_0
    //   353: getfield 299	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: aload_0
    //   360: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   363: ifnull +23 -> 386
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   372: getfield 776	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:j	I
    //   375: ldc_w 777
    //   378: if_icmpne +8 -> 386
    //   381: aload_2
    //   382: invokestatic 779	com/tencent/biz/pubaccount/util/ReadinJoyActionUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: aload 6
    //   388: getfield 782	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   391: aload_1
    //   392: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   395: aload 6
    //   397: getfield 785	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   400: aload_0
    //   401: getfield 788	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCanvasJson	Ljava/lang/String;
    //   404: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   407: aload 6
    //   409: getfield 791	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:dest_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   412: aload_0
    //   413: getfield 794	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdDestType	I
    //   416: invokevirtual 704	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: new 796	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo
    //   422: dup
    //   423: invokespecial 797	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:<init>	()V
    //   426: astore 5
    //   428: aload_0
    //   429: getfield 800	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   432: invokestatic 805	com/tencent/gdtad/aditem/GdtBaseAdItem:a	(Ljava/lang/String;)Lcom/tencent/gdtad/aditem/GdtBaseAdItem;
    //   435: astore_1
    //   436: aload 5
    //   438: getfield 808	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: aload_1
    //   442: getfield 809	com/tencent/gdtad/aditem/GdtBaseAdItem:a	Ljava/lang/String;
    //   445: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   448: new 617	org/json/JSONObject
    //   451: dup
    //   452: aload_0
    //   453: getfield 800	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   456: invokespecial 619	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   459: astore_2
    //   460: aload_2
    //   461: ldc_w 811
    //   464: invokevirtual 623	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_1
    //   468: aload_2
    //   469: ldc_w 813
    //   472: invokevirtual 623	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: astore_2
    //   476: aload_1
    //   477: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +12 -> 492
    //   483: aload 5
    //   485: getfield 816	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   488: aload_1
    //   489: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   492: aload_2
    //   493: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +12 -> 508
    //   499: aload 5
    //   501: getfield 819	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: aload_2
    //   505: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   508: aload 5
    //   510: getfield 822	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:android_app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   513: aload_0
    //   514: getfield 710	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   517: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   520: aload 5
    //   522: getfield 825	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_download_schema	Lcom/tencent/mobileqq/pb/PBStringField;
    //   525: aload_0
    //   526: getfield 828	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAppDownLoadSchema	Ljava/lang/String;
    //   529: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   532: aload 5
    //   534: getfield 831	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:customized_invoke_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   537: aload_0
    //   538: getfield 834	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCustomizedInvokeUrl	Ljava/lang/String;
    //   541: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   544: invokestatic 74	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   547: ifeq +32 -> 579
    //   550: ldc 76
    //   552: iconst_0
    //   553: new 78	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 836
    //   563: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 839	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   570: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 358	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload 5
    //   581: getfield 842	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:channel_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   584: astore_2
    //   585: aload_0
    //   586: getfield 839	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   589: ifnonnull +351 -> 940
    //   592: ldc_w 521
    //   595: astore_1
    //   596: aload_2
    //   597: aload_1
    //   598: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   601: aload_0
    //   602: invokestatic 440	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdUtils:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   605: ifeq +38 -> 643
    //   608: aload_0
    //   609: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   612: getfield 52	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   615: ifnull +28 -> 643
    //   618: aload_0
    //   619: getfield 47	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   622: getfield 52	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   625: invokeinterface 58 1 0
    //   630: iconst_2
    //   631: if_icmplt +12 -> 643
    //   634: aload_0
    //   635: invokestatic 442	com/tencent/biz/pubaccount/util/ReadinJoyActionUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdPKImageData;
    //   638: astore_1
    //   639: aload_1
    //   640: ifnonnull +308 -> 948
    //   643: new 265	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   646: dup
    //   647: invokespecial 266	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   650: astore_1
    //   651: aload_1
    //   652: getfield 845	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   655: aload_0
    //   656: getfield 535	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   659: invokevirtual 704	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   662: aload_1
    //   663: getfield 849	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   666: aload_3
    //   667: invokevirtual 850	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   670: aload_1
    //   671: getfield 270	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   674: aload 4
    //   676: invokevirtual 271	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   679: aload_1
    //   680: getfield 854	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   683: aload 6
    //   685: invokevirtual 855	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   688: new 857	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo
    //   691: dup
    //   692: invokespecial 858	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:<init>	()V
    //   695: astore_2
    //   696: aload_0
    //   697: getfield 615	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   700: astore_3
    //   701: aload_3
    //   702: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   705: ifne +93 -> 798
    //   708: new 617	org/json/JSONObject
    //   711: dup
    //   712: aload_3
    //   713: invokespecial 619	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   716: astore_3
    //   717: aload_2
    //   718: getfield 861	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:ad_trace_data	Lcom/tencent/mobileqq/pb/PBStringField;
    //   721: aload_3
    //   722: ldc_w 863
    //   725: invokevirtual 623	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   731: aload_2
    //   732: getfield 866	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   735: aload_3
    //   736: ldc_w 868
    //   739: invokevirtual 623	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   742: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   745: aload_2
    //   746: getfield 871	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   749: aload_3
    //   750: ldc_w 873
    //   753: invokevirtual 623	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   759: aload_2
    //   760: getfield 876	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_token	Lcom/tencent/mobileqq/pb/PBStringField;
    //   763: aload_3
    //   764: ldc_w 878
    //   767: invokevirtual 623	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   770: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   773: aload_2
    //   774: getfield 881	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_username	Lcom/tencent/mobileqq/pb/PBStringField;
    //   777: aload_3
    //   778: ldc_w 883
    //   781: invokevirtual 623	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   784: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   787: aload_2
    //   788: getfield 886	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   791: aload_0
    //   792: getfield 889	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   795: invokevirtual 222	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   798: aload_1
    //   799: getfield 893	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:wechat_app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo;
    //   802: aload_2
    //   803: invokevirtual 894	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   806: aload_1
    //   807: getfield 898	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   810: aload 5
    //   812: invokevirtual 899	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   815: aload_0
    //   816: getfield 800	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   819: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   822: ifne +181 -> 1003
    //   825: new 617	org/json/JSONObject
    //   828: dup
    //   829: aload_0
    //   830: getfield 800	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   833: invokespecial 619	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   836: ldc_w 901
    //   839: ldc_w 521
    //   842: invokevirtual 904	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   845: astore_0
    //   846: invokestatic 74	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   849: ifeq +29 -> 878
    //   852: ldc 76
    //   854: iconst_0
    //   855: new 78	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 906
    //   865: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_0
    //   869: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 358	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: aload_1
    //   879: getfield 909	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   882: aload_0
    //   883: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   886: aload_1
    //   887: areturn
    //   888: astore_2
    //   889: aload_1
    //   890: astore_0
    //   891: invokestatic 74	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   894: ifeq -886 -> 8
    //   897: ldc 76
    //   899: iconst_0
    //   900: new 78	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   907: ldc_w 911
    //   910: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload_2
    //   914: invokevirtual 89	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   917: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 358	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   926: aload_1
    //   927: areturn
    //   928: astore_2
    //   929: aconst_null
    //   930: astore_1
    //   931: aload_2
    //   932: invokevirtual 912	java/lang/Exception:printStackTrace	()V
    //   935: aconst_null
    //   936: astore_2
    //   937: goto -461 -> 476
    //   940: aload_0
    //   941: getfield 839	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   944: astore_1
    //   945: goto -349 -> 596
    //   948: aload_1
    //   949: getfield 914	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdPKImageData:b	Ljava/lang/String;
    //   952: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   955: ifne +15 -> 970
    //   958: aload 4
    //   960: getfield 253	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   963: aload_1
    //   964: getfield 914	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdPKImageData:b	Ljava/lang/String;
    //   967: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   970: aload_1
    //   971: getfield 444	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdPKImageData:a	Ljava/lang/String;
    //   974: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   977: ifne -334 -> 643
    //   980: aload 6
    //   982: getfield 782	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   985: aload_1
    //   986: getfield 444	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdPKImageData:a	Ljava/lang/String;
    //   989: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   992: goto -349 -> 643
    //   995: astore_3
    //   996: aload_3
    //   997: invokevirtual 626	org/json/JSONException:printStackTrace	()V
    //   1000: goto -202 -> 798
    //   1003: aload_1
    //   1004: getfield 909	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1007: ldc_w 521
    //   1010: invokevirtual 235	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1013: aload_1
    //   1014: astore_0
    //   1015: invokestatic 74	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1018: ifeq -1010 -> 8
    //   1021: ldc 76
    //   1023: iconst_0
    //   1024: ldc_w 916
    //   1027: invokestatic 358	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1030: aload_1
    //   1031: areturn
    //   1032: astore_2
    //   1033: goto -102 -> 931
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1036	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	1030	1	localObject1	Object
    //   78	725	2	localObject2	Object
    //   888	26	2	localException1	Exception
    //   928	4	2	localException2	Exception
    //   936	1	2	localObject3	Object
    //   1032	1	2	localException3	Exception
    //   104	674	3	localObject4	Object
    //   995	2	3	localJSONException	JSONException
    //   213	746	4	localReportInfo	qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo
    //   426	385	5	localAppInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo
    //   350	631	6	localDestInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo
    // Exception table:
    //   from	to	target	type
    //   825	878	888	java/lang/Exception
    //   878	886	888	java/lang/Exception
    //   448	468	928	java/lang/Exception
    //   708	798	995	org/json/JSONException
    //   468	476	1032	java/lang/Exception
  }
  
  public static void a()
  {
    if ((BaseApplicationImpl.getContext() != null) && (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    }
  }
  
  public static void a(int paramInt, GdtHandler.Params paramParams, long paramLong) {}
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    if ((paramReadInJoyBaseAdapter != null) && (paramBoolean)) {
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
    if (paramReadInJoyBaseAdapter != null) {
      localBundle.putLong("param_ad_app_info_video_playposition", paramReadInJoyBaseAdapter.a());
    }
    a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, int paramInt, Integer paramInteger)
  {
    Object localObject3 = RIJFeedsType.b(paramArticleInfo);
    int i;
    int j;
    label32:
    int k;
    label45:
    Object localObject4;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label674;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label680;
      }
      k = paramArticleInfo.videoJumpChannelID;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i));
      localObject4 = ReadinjoyReportUtils.b(paramArticleInfo.mChannelID);
      if ((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break label687;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), (String)localObject4, (String)localObject4, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), k, paramArticleInfo), false);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject4, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), (String)localObject3, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), k, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = ReadInJoyUtils.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = paramInt;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label820;
      }
      localObject3 = new ReportInfo.FeedsReportData();
      ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        ((ReportInfo.FeedsReportData)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((ReportInfo.FeedsReportData)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label813;
      }
      ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject4).next();
        if (localFeedsInfoUser != null) {
          ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label674:
      j = 1;
      break label32;
      label680:
      k = 56;
      break label45;
      label687:
      localObject2 = RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), (String)localObject3, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), k, paramArticleInfo);
      localObject1 = localObject2;
      if (paramInt == 0) {
        localObject1 = VideoReporter.a(k, (String)VideoReporter.a.get(ReadInJoyChannelActivity.class), (String)localObject2);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject4, (String)localObject4, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), (String)localObject1, false);
    }
    label813:
    ((ReportInfo)localObject2).mFeedsReportData = ((ReportInfo.FeedsReportData)localObject3);
    label820:
    ((List)localObject1).add(localObject2);
    ReadInJoyLogicEngine.a().a((List)localObject1);
    RIJFeedsInsertUtil.a.b(paramInt, paramArticleInfo);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L)
      {
        VideoAdClickRecorder.a((AdvertisementInfo)paramArticleInfo);
        NativeAdUtils.a(new AdReportData().a(paramActivity).a(1).b(15).b(paramInteger).a((AdvertisementInfo)paramArticleInfo).c(((AdvertisementInfo)paramArticleInfo).clickPos));
      }
    }
    else {
      return;
    }
    if ((ReadInJoyAdUtils.h((AdvertisementInfo)paramArticleInfo)) && (ReadInJoySuperMaskAdUtil.jdField_a_of_type_Boolean)) {
      paramInt = 37;
    }
    for (;;)
    {
      NativeAdUtils.a(new AdReportData().a(paramActivity).a(1).b(paramInt).b(paramInteger).a((AdvertisementInfo)paramArticleInfo).c(((AdvertisementInfo)paramArticleInfo).clickPos));
      return;
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        paramInt = 8;
      } else if (RIJFeedsType.a(paramArticleInfo)) {
        paramInt = 11;
      } else {
        paramInt = 3;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      return;
      if (LiujinAdJump.isFromLiuJin((AdvertisementInfo)paramArticleInfo))
      {
        Integer localInteger = LiujinAdJump.doJumpAction((AdvertisementInfo)paramArticleInfo, paramActivity, paramBoolean);
        if (localInteger.intValue() != -1)
        {
          a(paramActivity, paramArticleInfo, paramInt, localInteger);
          return;
        }
      }
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, paramAdJumpParams);
        return;
      case 2: 
        c(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, paramAdJumpParams);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, true);
        return;
      case 3: 
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        paramAdJumpParams = a(paramActivity, (AdvertisementInfo)paramArticleInfo, null, paramInt, paramBoolean, paramAdJumpParams);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        a(paramActivity, paramArticleInfo, paramInt, paramAdJumpParams);
        ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      }
    } while (paramReadInJoyBaseAdapter == null);
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
    return;
    b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, true);
  }
  
  public static void a(Activity paramActivity, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("ad", paramAdvertisementInfo);
    localIntent.putExtra("fragmentClass", ReadInJoyAdIMAXBrowserFragment.class);
    localIntent.setClass(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130771981, 17432577);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadinJoyActionUtil", 0, "closeFloatWindow error:" + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramAdvertisementInfo.clickPos;
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean1, paramBoolean2);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt, paramReadInJoyBaseAdapter);
  }
  
  private static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label131;
      }
    }
    label131:
    for (int j = 0;; j = 1)
    {
      String str1 = RIJFeedsType.b(paramArticleInfo);
      String str2 = ReadinjoyReportUtils.b(paramInt);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramContext), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo), false);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, Integer paramInteger)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      NativeAdUtils.a(new AdReportData().a(paramContext).a(1).b(paramInt2).b(paramInteger).a((AdvertisementInfo)paramArticleInfo).e(new JSONObject()));
      a(paramContext, paramArticleInfo, paramInt1);
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt, Integer paramInteger)
  {
    int i;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID != 56L) {
        break label31;
      }
      i = 4;
    }
    for (;;)
    {
      a(paramContext, paramArticleInfo, paramInt, i, paramInteger);
      label31:
      do
      {
        return;
        if ((ReadInJoyAdUtils.h((AdvertisementInfo)paramArticleInfo)) && (ReadInJoySuperMaskAdUtil.jdField_a_of_type_Boolean))
        {
          i = 37;
          break;
        }
        if (a((AdvertisementInfo)paramArticleInfo, paramInt))
        {
          i = 8;
          break;
        }
        if (RIJFeedsType.a(paramArticleInfo))
        {
          i = 11;
          break;
        }
      } while ((ReadInJoyAdUtils.e((AdvertisementInfo)paramArticleInfo)) && (((AdvertisementInfo)paramArticleInfo).isClickFromPkFragment));
      if (((AdvertisementInfo)paramArticleInfo).isCommentAd()) {
        i = 38;
      } else {
        i = 3;
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    a(paramContext, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, false);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    if ((paramReadInJoyBaseAdapter != null) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && ((paramContext instanceof Activity)))
    {
      paramReadInJoyBaseAdapter.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(paramContext, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, null);
      if (paramReadInJoyBaseAdapter.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
        break label58;
      }
    }
    label58:
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      paramReadInJoyBaseAdapter.jdField_a_of_type_Long = l;
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("h5url", paramString1);
    localIntent.putExtra("adrl", paramString2);
    localIntent.putExtra("traceId", paramString3);
    localIntent.putExtra("fragmentClass", ReadInJoyAdPopSheetBrowserFragment.class);
    localIntent.setClass(BaseApplicationImpl.getApplication(), QQTranslucentBrowserActivity.class);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    a(3, paramVideoFeedsAdapter.a.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, paramVideoFeedsAdapter.a.jdField_a_of_type_Long);
    paramVideoFeedsAdapter.a.jdField_a_of_type_Long = -2147483648L;
    paramVideoFeedsAdapter.a.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
  }
  
  public static void a(ViewBase paramViewBase, Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt1, int paramInt2)
  {
    AdvertisementInfo localAdvertisementInfo;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      localAdvertisementInfo = (AdvertisementInfo)paramArticleInfo;
      a(paramActivity, localAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt1);
      if ((paramInt2 != 6) || ((paramReadInJoyBaseAdapter != null) && (paramReadInJoyBaseAdapter.a() != null) && (paramReadInJoyBaseAdapter.a().b()))) {
        break label289;
      }
    }
    label289:
    for (int i = 5;; i = paramInt2)
    {
      if (paramInt2 == 103) {
        i = 101;
      }
      if (paramInt2 == 104) {
        i = 102;
      }
      for (;;)
      {
        ReadInJoyAdUtils.a(localAdvertisementInfo, i, null);
        VideoPlayManager localVideoPlayManager = null;
        if (paramReadInJoyBaseAdapter != null) {
          localVideoPlayManager = paramReadInJoyBaseAdapter.a();
        }
        if ((ReadInJoyAdUtils.e((AdvertisementInfo)paramArticleInfo)) && ((paramInt2 == 4) || (paramInt2 == 3) || (paramInt2 == 1)))
        {
          if (paramInt2 == 1) {
            i = 3;
          }
          ReadInJoyAdUtils.a(paramActivity, 1);
          a(paramActivity);
          a(paramActivity, (AdvertisementInfo)paramArticleInfo);
          NativeAdUtils.a(new AdReportData().a(paramActivity).a(1).b(31).b(Integer.valueOf(24)).a((AdvertisementInfo)paramArticleInfo).c(i));
        }
        boolean bool;
        do
        {
          do
          {
            return;
          } while ((paramViewBase != null) && (a(paramArticleInfo, paramViewBase, paramActivity, paramInt1, localVideoPlayManager, localAdvertisementInfo)));
          bool = NativeAdUtils.a(paramInt2);
          paramViewBase = new AdJumpParams();
          if (paramInt2 == 8) {
            paramViewBase.c = true;
          }
        } while (a(paramActivity, paramReadInJoyBaseAdapter, paramArticleInfo));
        a(paramActivity, localAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt1, bool, ReadInJoyAdSwitchUtil.b((AdvertisementInfo)paramArticleInfo), paramViewBase);
        SuperMaskUIMgr.a.b(-1);
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : doAdClickAction");
        return;
      }
    }
  }
  
  public static void a(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt1, int paramInt2)
  {
    if ((paramViewBase2 == null) || (paramActivity == null) || (paramArticleInfo == null)) {
      return;
    }
    a(paramViewBase1, paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt1, paramInt2);
  }
  
  public static void a(GdtHandler.Params paramParams, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if (a(paramAdvertisementInfo, paramContext))
    {
      paramParams.c = false;
      paramParams.d = false;
      return;
    }
    paramParams.c = true;
    paramParams.d = true;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5);
  }
  
  public static boolean a(Context paramContext, int paramInt, ArticleInfo paramArticleInfo)
  {
    try
    {
      boolean bool = ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, ((AdvertisementInfo)paramArticleInfo).mAdLandingPage, paramInt, null);
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
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, false, false, null);
    if (paramReadInJoyBaseAdapter == null) {
      return false;
    }
    a(paramReadInJoyBaseAdapter, true, paramAdvertisementInfo, paramContext);
    GdtHandler.a(paramReadInJoyBaseAdapter);
    QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  private static boolean a(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, ArticleInfo paramArticleInfo)
  {
    if ((paramReadInJoyBaseAdapter == null) || (paramReadInJoyBaseAdapter.a() != 0)) {}
    AdHandler.ItemViewBuilder localItemViewBuilder;
    do
    {
      do
      {
        return false;
      } while (!ReadInJoyAdUtils.a(paramArticleInfo));
      RIJPreParseData.b(paramArticleInfo);
      paramArticleInfo.innerUniqueID = a(paramArticleInfo, "landing_page_rowkey");
      localItemViewBuilder = a(paramReadInJoyBaseAdapter, paramArticleInfo.innerUniqueID);
    } while (localItemViewBuilder == null);
    a(paramContext, paramArticleInfo, paramReadInJoyBaseAdapter.a(), Integer.valueOf(25));
    paramReadInJoyBaseAdapter.a(localItemViewBuilder.a(), paramArticleInfo);
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      QLog.e("ReadinJoyActionUtil", 3, "JumpToGdtAdPage error advertisementInfo is null");
    }
    while ((!(paramAdvertisementInfo instanceof AdvertisementInfo)) || (ReadInJoyAdUtils.a(paramAdvertisementInfo))) {
      return false;
    }
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 3) || (paramInt == 56) || (paramInt == 4) || (paramInt == 2000001) || (paramInt == 95555552) || ((ReadInJoyAdUtils.a(paramInt)) && (!a(paramAdvertisementInfo.mAdJumpMode)) && (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramAdvertisementInfo.mAdProductType))))) {
      return true;
    }
    QLog.e("ReadinJoyActionUtil", 3, "readInjoy product not go Gdt QQB channelId:" + paramInt + " AdProductType:" + paramAdvertisementInfo.mAdProductType);
    return false;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (!ReadInJoyAdUtils.a(paramAdvertisementInfo))) {}
    while ((paramAdvertisementInfo.mAdProductType == 30) || (paramAdvertisementInfo.mAdProductType == 41) || (((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (!a(paramAdvertisementInfo.mAdCustomizedInvokeUrl, paramContext)))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return (jdField_a_of_type_Boolean) && ((paramArticleInfo instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramArticleInfo).mAdFeedId != 0L) && (!TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdInteractionReportUrl));
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramReadInJoyBaseAdapter != null) && (paramReadInJoyBaseAdapter.a() != null) && (paramReadInJoyBaseAdapter.a().b()) && (paramReadInJoyBaseAdapter.a().a() != null))
    {
      paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a().a();
      if ((paramReadInJoyBaseAdapter.b) && (paramReadInJoyBaseAdapter.a != null) && (AdvertisementInfo.isAdvertisementInfo(paramReadInJoyBaseAdapter.a)))
      {
        paramReadInJoyBaseAdapter = (AdvertisementInfo)paramReadInJoyBaseAdapter.a;
        if ((!TextUtils.isEmpty(paramReadInJoyBaseAdapter.mAdTraceId)) && ((paramArticleInfo instanceof AdvertisementInfo)) && (paramReadInJoyBaseAdapter.mAdTraceId.equals(((AdvertisementInfo)paramArticleInfo).mAdTraceId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, ViewBase paramViewBase, Activity paramActivity, int paramInt, VideoPlayManager paramVideoPlayManager, AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramAdvertisementInfo.mImaxShowAdType == 1001) || (paramAdvertisementInfo.mImaxShowAdType == 1002))
    {
      if (((AdvertisementInfo)paramArticleInfo).isHideForAnimate) {
        return true;
      }
      if (paramAdvertisementInfo.mImaxShowAdType == 1001)
      {
        localObject1 = paramViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
        if ((localObject1 != null) && (((ViewBase)localObject1).getNativeView() != null) && (((ViewBase)localObject1).getNativeView().getVisibility() == 0))
        {
          a(paramActivity, paramAdvertisementInfo.mAdLandingPage, paramAdvertisementInfo);
          a(paramActivity, paramArticleInfo, paramInt, 29, Integer.valueOf(23));
          return true;
        }
      }
      localObject1 = null;
      if (paramAdvertisementInfo.mImaxShowAdType == 1002)
      {
        localObject3 = paramViewBase.findViewBaseByName("idArticleDoubleImage");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = paramViewBase.findViewBaseByName("id_article_double_image");
        }
        if (localObject2 != null) {
          localObject1 = ((ViewBase)localObject2).getNativeView();
        }
      }
    }
    for (;;)
    {
      ((AdvertisementInfo)paramArticleInfo).isHideForAnimate = true;
      if (paramVideoPlayManager != null)
      {
        paramVideoPlayManager.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
        paramVideoPlayManager.b(0);
      }
      localObject2 = new int[2];
      paramVideoPlayManager = paramViewBase.getNativeView();
      if (localObject1 != null) {
        if ((localObject1 instanceof NativeReadInjoyImageView))
        {
          ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localObject1).getDrawable();
          paramVideoPlayManager = (VideoPlayManager)localObject1;
        }
      }
      for (;;)
      {
        paramVideoPlayManager.getLocationOnScreen((int[])localObject2);
        if (((AdvertisementInfo)paramArticleInfo).mImaxShowAdType == 1001)
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
          if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
          {
            paramViewBase = paramViewBase.findViewBaseByName("idArtilceTitle");
            if (paramViewBase != null) {
              paramViewBase.getNativeView().setVisibility(4);
            }
          }
        }
        int i = localObject2[1];
        int j = localObject2[0];
        int k = paramVideoPlayManager.getWidth();
        int m = paramVideoPlayManager.getHeight();
        paramViewBase = new ReadInjoyIMAXAdFragment.Param();
        paramViewBase.jdField_b_of_type_Int = i;
        paramViewBase.jdField_a_of_type_Int = j;
        paramViewBase.c = k;
        paramViewBase.d = m;
        paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        a(paramActivity);
        ReadInjoyIMAXAdFragment.a(paramActivity, paramViewBase);
        a(paramActivity, paramArticleInfo, paramInt, 29, Integer.valueOf(23));
        return true;
        localObject1 = paramViewBase.findViewBaseByName("id_article_large_imge");
        if (localObject1 == null) {
          break label550;
        }
        localObject1 = ((ViewBase)localObject1).getNativeView();
        break;
        paramVideoPlayManager = (VideoPlayManager)localObject1;
        if ((localObject1 instanceof FrameLayout))
        {
          paramVideoPlayManager = (VideoPlayManager)localObject1;
          if (((FrameLayout)localObject1).getChildCount() > 0)
          {
            localObject3 = ((FrameLayout)localObject1).getChildAt(0);
            paramVideoPlayManager = (VideoPlayManager)localObject1;
            if ((localObject3 instanceof NativeReadInjoyImageView))
            {
              ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localObject3).getDrawable();
              paramVideoPlayManager = (VideoPlayManager)localObject1;
              continue;
              return false;
            }
          }
        }
      }
      label550:
      localObject1 = null;
    }
  }
  
  private static boolean a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return false;
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
          if (!bool) {
            return true;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadinJoyActionUtil", 1, "resolveActivityInfo error!", paramString);
    return false;
  }
  
  public static Integer b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    Integer localInteger = Integer.valueOf(-1);
    if (LiujinAdJump.isFromLiuJin(paramAdvertisementInfo)) {
      localInteger = LiujinAdJump.doJumpAction(paramAdvertisementInfo, paramContext, paramBoolean);
    }
    if (localInteger.intValue() != -1)
    {
      a(paramContext, paramAdvertisementInfo, paramInt, localInteger);
      return Integer.valueOf(10);
    }
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (paramReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    return b(paramReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
  
  public static Integer b(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      return Integer.valueOf(-1);
    }
    ReadInJoyAdUtils.b(paramAdvertisementInfo);
    if ((paramAdvertisementInfo.mAdJumpMode == 7) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)))
    {
      a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("ReadinJoyActionUtil", 3, "JumpToGdtAdPage tovialo true");
      }
      return RIJJumpUtils.a(paramContext, paramAdvertisementInfo.mAdLandingPage);
    }
    if ((paramAdvertisementInfo.mAdvertisementExtInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo.j == 32))
    {
      GdtHandler.a(paramParams);
      if (QLog.isColorLevel()) {
        QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
      }
      return Integer.valueOf(10);
    }
    return RIJJumpUtils.a(paramContext, paramAdvertisementInfo.mAdLandingPage);
  }
  
  private static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean)
  {
    if ((paramReadInJoyBaseAdapter != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt, Integer.valueOf(10));
    }
    Bundle localBundle = new Bundle();
    AdvertisementInfoHelper.a(localBundle, paramAdvertisementInfo);
    long l2 = 0L;
    long l1 = l2;
    if (paramReadInJoyBaseAdapter != null)
    {
      l1 = l2;
      if (paramReadInJoyBaseAdapter.a() != null)
      {
        l1 = l2;
        if (paramReadInJoyBaseAdapter.a().a() != null)
        {
          l1 = l2;
          if (paramReadInJoyBaseAdapter.a().a().c == paramAdvertisementInfo.mArticleID) {
            l1 = paramReadInJoyBaseAdapter.a();
          }
        }
      }
    }
    localBundle.putLong("param_ad_app_info_video_playposition", l1);
    a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  public static Integer c(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    int i = paramAdvertisementInfo.clickPos;
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, paramAdJumpParams);
    if (i >= 0) {
      paramAdvertisementInfo.setClickPos(i);
    }
    a(paramContext, paramAdvertisementInfo, paramInt, paramReadInJoyBaseAdapter);
    return paramReadInJoyBaseAdapter;
  }
  
  public static Integer d(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, boolean paramBoolean, AdJumpParams paramAdJumpParams)
  {
    paramReadInJoyBaseAdapter = a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt, paramBoolean, false, false, paramAdJumpParams);
    if (paramReadInJoyBaseAdapter == null) {
      return Integer.valueOf(-1);
    }
    a(paramReadInJoyBaseAdapter, true, paramAdvertisementInfo, paramContext);
    return b(paramReadInJoyBaseAdapter, paramContext, paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinJoyActionUtil
 * JD-Core Version:    0.7.0.1
 */