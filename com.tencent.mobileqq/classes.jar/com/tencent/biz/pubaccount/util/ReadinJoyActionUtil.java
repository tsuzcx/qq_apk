package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.util.GdtAppOpenUtil;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mvm;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class ReadinJoyActionUtil
{
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).view_id.set(paramAdvertisementInfo.mAdViewId);
    Object localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.set(paramAdvertisementInfo.mAdApurl);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.set(paramAdvertisementInfo.mAdRl);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.set((MessageMicro)localObject2);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.set((MessageMicro)localObject1);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject2 = paramAdvertisementInfo.mAdLandingPage;
    localObject1 = localObject2;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramAdvertisementInfo = Uri.parse((String)localObject2).buildUpon();
      if (NetworkUtil.b(BaseApplicationImpl.getApplication()) != 1) {
        break label221;
      }
      paramAdvertisementInfo.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      localObject1 = paramAdvertisementInfo.toString();
      paramAdvertisementInfo = new GdtVideoCeilingData();
      paramAdvertisementInfo.setVideoData(localGdtVideoData);
      paramAdvertisementInfo.setAd(localGdtAd);
      paramAdvertisementInfo.setWebUrl((String)localObject1);
      ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, paramAdvertisementInfo);
      return;
      label221:
      paramAdvertisementInfo.appendQueryParameter("autodownload", "0");
    }
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    a(paramActivity, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt);
    paramReadInJoyBaseAdapter = paramAdvertisementInfo.mAdAppJson;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_ad_json", paramReadInJoyBaseAdapter);
    localBundle.putString("param_ad_app_info_trace_id", paramAdvertisementInfo.mAdTraceId);
    localBundle.putLong("param_ad_app_info_pull_time", paramAdvertisementInfo.mAdFetchTime);
    localBundle.putString("param_ad_app_info_view_id", paramAdvertisementInfo.mAdViewId);
    localBundle.putLong("param_ad_app_info_pos_id", paramAdvertisementInfo.mAdPosID);
    localBundle.putInt("param_ad_app_info_kd_pos", paramAdvertisementInfo.mAdKdPos);
    localBundle.putString("param_ad_app_info_product_id", paramAdvertisementInfo.mAdProductId);
    localBundle.putInt("param_ad_app_info_product_type", paramAdvertisementInfo.mAdProductType);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
    if (PublicAccountImageCollectionUtils.a(paramArticleInfo))
    {
      paramReadInJoyBaseAdapter = new Intent(paramActivity, PublicAccountImageCollectionMainActivity.class);
      paramReadInJoyBaseAdapter.putExtra("source_for_report", 9);
      PublicAccountImageCollectionUtils.a(paramActivity, paramReadInJoyBaseAdapter, String.valueOf(paramArticleInfo.innerUniqueID));
      return;
    }
    paramInt = paramReadInJoyBaseAdapter.a();
    long l = paramArticleInfo.mRecommendSeq;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (ReadInJoyBaseAdapter.a(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!ReadInJoyBaseAdapter.c(paramArticleInfo)) {
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a.get(0)).b;
      }
    }
    localObject2 = localObject1;
    label270:
    Intent localIntent;
    if (!(paramArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        localObject2 = (String)localObject1 + "from=0";
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
      {
        localObject1 = localObject2;
        if (NetworkUtil.h(null))
        {
          if (!((String)localObject2).contains("?")) {
            break label701;
          }
          localObject1 = (String)localObject2 + "&";
          localObject1 = (String)localObject1 + "acttype=42";
        }
      }
      localBundle.putString("url", (String)localObject1);
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putString("from", String.valueOf(53));
      localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
      localBundle.putLong("articleid", paramArticleInfo.mArticleID);
      localBundle.putLong("recommendSeq", l);
      localBundle.putInt("channelid", paramInt);
      localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
      localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
      localBundle.putInt("articalChannelId", 9);
      localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
      localBundle.putBoolean("ip_connect", PublicAccountConfigUtil.m);
      l = System.currentTimeMillis();
      localBundle.putLong("startOpenPageTime", l);
      localBundle.putLong("click_time", l);
      localBundle.putLong("available_memory", DeviceInfoUtil.f());
      localBundle.putBoolean("preload_tool_white_list", ReadInJoyUtils.f());
      localIntent = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
      localObject2 = PreloadManager.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if ((FileUtils.b(AppConstants.cn + (String)localObject1)) && (PreloadManager.a().b((String)localObject1) != null))
      {
        localBundle.putString("read_in_joy_from_cache", (String)localObject1);
        if (!paramReadInJoyBaseAdapter.a(paramInt, paramArticleInfo.mArticleID))
        {
          paramArticleInfo = PreloadManager.a();
          if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4)) {
            break label739;
          }
          paramReadInJoyBaseAdapter = paramArticleInfo.a((String)localObject1);
          if ((paramReadInJoyBaseAdapter != null) && (paramReadInJoyBaseAdapter.size() > 0))
          {
            ThreadManager.post(new mvm(paramArticleInfo, (PreloadManager.ImgStruct)paramReadInJoyBaseAdapter.get(0)), 5, null, false);
            if (paramReadInJoyBaseAdapter.size() <= 1) {
              break label727;
            }
            localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramReadInJoyBaseAdapter.get(1)).a);
          }
        }
      }
    }
    for (;;)
    {
      localIntent.putExtras(localBundle);
      paramActivity.startActivityForResult(localIntent, 9991);
      return;
      localObject1 = (String)localObject1 + "?";
      break;
      label701:
      localObject1 = (String)localObject2 + "?";
      break label270;
      label727:
      localBundle.putString("preload_iamge_url", null);
      continue;
      label739:
      paramArticleInfo = paramArticleInfo.a((String)localObject1);
      if ((paramArticleInfo != null) && (paramArticleInfo.size() > 0)) {
        localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramArticleInfo.get(0)).a);
      } else {
        localBundle.putString("preload_iamge_url", null);
      }
    }
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    GdtBaseAdItem localGdtBaseAdItem = GdtBaseAdItem.obtain(paramAdvertisementInfo.mAdExt).setClz(ReadInJoyArticleDetailActivity.class).setTraceId(paramAdvertisementInfo.mAdTraceId).setProductId(paramAdvertisementInfo.mAdProductId).setDeepLinkUrl(paramAdvertisementInfo.mAdCustomizedInvokeUrl).setAutoDownLoad(true).setDownloadScheme(paramAdvertisementInfo.mAdRl);
    localGdtBaseAdItem.setDeepLinkUrl(null).setPackageName(null);
    GdtAppOpenUtil.a(localGdtBaseAdItem);
    a(paramContext, paramAdvertisementInfo, paramReadInJoyBaseAdapter, paramInt);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    int k = paramReadInJoyBaseAdapter.a();
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label567;
      }
    }
    ReportInfo localReportInfo;
    ReportInfo.FeedsReportData localFeedsReportData;
    label567:
    for (int j = 0;; j = 1)
    {
      paramReadInJoyBaseAdapter = ReadInJoyUtils.a(paramArticleInfo);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.b(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), k, i), false);
      PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.b(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i));
      PublicAccountReportUtils.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), k, i, j, NetworkUtil.h(paramContext), paramReadInJoyBaseAdapter, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), paramArticleInfo), false);
      PublicAccountReportUtils.a("0X8007625", paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), k, i, j, NetworkUtil.h(paramContext), paramReadInJoyBaseAdapter, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), paramArticleInfo));
      paramReadInJoyBaseAdapter = new ArrayList();
      localReportInfo = new ReportInfo();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
      localReportInfo.mChannelId = k;
      localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
      localReportInfo.mOperation = 1;
      localReportInfo.mServerContext = paramArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if ((paramArticleInfo.mFeedType == 3) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID))) {
        localReportInfo.mInnerId = paramArticleInfo.innerUniqueID;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label580;
      }
      localFeedsReportData = new ReportInfo.FeedsReportData();
      localFeedsReportData.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        localFeedsReportData.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      localFeedsReportData.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localFeedsReportData.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      Object localObject = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label573;
      }
      localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject).next();
        if (localFeedsInfoUser != null) {
          localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
    }
    label573:
    localReportInfo.mFeedsReportData = localFeedsReportData;
    label580:
    paramReadInJoyBaseAdapter.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(paramReadInJoyBaseAdapter);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L) {
        NativeAdUtils.a(null, paramContext, NativeAdUtils.jdField_a_of_type_Int, NativeAdUtils.j, (AdvertisementInfo)paramArticleInfo, null, 0);
      }
      ReadInJoyLogicEngine.a().a(2, (AdvertisementInfo)paramArticleInfo);
    }
  }
  
  public static void b(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
    {
    default: 
      return;
    case 1: 
      a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
      return;
    case 2: 
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
      return;
    case 4: 
      if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
      {
        a(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
        return;
      }
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
      return;
    }
    a(paramActivity, (AdvertisementInfo)paramArticleInfo);
    c(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
  }
  
  public static void c(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    Object localObject2 = ReadInJoyUtils.a(paramArticleInfo);
    int i;
    int j;
    label32:
    int k;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label614;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label620;
      }
      k = paramArticleInfo.videoJumpChannelID;
      label45:
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.b(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i), false);
      PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.b(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i));
      if ((!ReadInJoyBaseAdapter.g(paramArticleInfo)) && (!ReadInJoyBaseAdapter.f(paramArticleInfo)) && (!ReadInJoyBaseAdapter.h(paramArticleInfo)) && (!ReadInJoyBaseAdapter.i(paramArticleInfo))) {
        break label627;
      }
      PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), k, paramArticleInfo), false);
    }
    Object localObject1;
    for (;;)
    {
      PublicAccountReportUtils.a("0X8007625", paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), k, paramArticleInfo));
      paramReadInJoyBaseAdapter = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = ReadInJoyUtils.a();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label748;
      }
      localObject2 = new ReportInfo.FeedsReportData();
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      Object localObject3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label741;
      }
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject3).next();
        if (localFeedsInfoUser != null) {
          ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label614:
      j = 1;
      break label32;
      label620:
      k = 56;
      break label45;
      label627:
      localObject1 = ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), k, paramArticleInfo);
      paramReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)localObject1;
      if (paramInt == 0) {
        paramReadInJoyBaseAdapter = VideoReporter.a(k, (String)VideoReporter.a.get(ReadInJoyChannelActivity.class), (String)localObject1);
      }
      PublicAccountReportUtils.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramReadInJoyBaseAdapter, false);
    }
    label741:
    ((ReportInfo)localObject1).mFeedsReportData = ((ReportInfo.FeedsReportData)localObject2);
    label748:
    paramReadInJoyBaseAdapter.add(localObject1);
    ReadInJoyLogicEngine.a().a(paramReadInJoyBaseAdapter);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L) {
        NativeAdUtils.a(null, paramActivity, NativeAdUtils.jdField_a_of_type_Int, NativeAdUtils.j, (AdvertisementInfo)paramArticleInfo, null, 0);
      }
      ReadInJoyLogicEngine.a().a(7, (AdvertisementInfo)paramArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinJoyActionUtil
 * JD-Core Version:    0.7.0.1
 */