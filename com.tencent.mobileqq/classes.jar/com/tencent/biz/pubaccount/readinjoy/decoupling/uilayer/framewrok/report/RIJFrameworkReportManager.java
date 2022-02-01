package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.FeedsOperation;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySrtUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.comment.RIJMedalUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgCard;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.CoreReport;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Long;Lcom.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;>;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJFrameworkReportManager
{
  private Pair<Integer, Long> a(Context paramContext, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    long l;
    if ((paramContext instanceof ReadInJoyNewFeedsActivity)) {
      if (((ReadInJoyNewFeedsActivity)paramContext).a() > 0L)
      {
        l = ((ReadInJoyNewFeedsActivity)paramContext).a();
        if (!((ReadInJoyNewFeedsActivity)paramContext).b()) {
          break label81;
        }
        paramInt = i;
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt), Long.valueOf(l));
      l = System.currentTimeMillis() - ((ReadInJoyNewFeedsActivity)paramContext).b();
      break;
      label81:
      paramInt = 1;
      continue;
      if ((paramContext instanceof SplashActivity))
      {
        paramContext = RIJJumpUtils.a(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.a();
          if (paramContext.a() != 0) {}
          for (paramInt = j;; paramInt = 1)
          {
            l = paramContext.a();
            break;
          }
        }
      }
      else if (DailyModeConfigHandler.c(paramInt))
      {
        if (KandianDailyReportUtils.b() != 0) {}
        for (paramInt = k;; paramInt = 1)
        {
          l = 0L;
          break;
        }
      }
      paramInt = -1;
      l = 0L;
    }
  }
  
  private static String a(long paramLong)
  {
    if ((DailyModeConfigHandler.a((int)paramLong)) || (ReadInJoyHelper.a(paramLong))) {
      return "0X8009CCB";
    }
    if (ReadinjoyReportUtils.a(paramLong)) {
      return "0X8009356";
    }
    return "0X8009332";
  }
  
  private String a(BaseReportData paramBaseReportData, String paramString)
  {
    int i = RIJItemViewType.a((ArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if ((i == 6) || (i == 66) || (i == 115) || (i == 28) || (i == 11) || (i == 26) || (i == 19)) {
      paramBaseReportData = VideoReporter.a(VideoReporter.a((ArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramString);
    }
    for (;;)
    {
      paramString = paramBaseReportData;
      if (i == 6)
      {
        paramBaseReportData = new VideoR5.Builder(paramBaseReportData);
        paramBaseReportData.aa(VideoFeedsHelper.f());
        paramString = paramBaseReportData.a().a();
      }
      return paramString;
      if ((i == 46) || (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem))
      {
        paramString = new VideoR5.Builder(paramString);
        paramString.e(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid);
        paramString.W(RIJFeedsType.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramString.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        if (i == 46) {
          paramString.Z(0);
        }
        for (;;)
        {
          paramString.e(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          paramBaseReportData = paramString.a().a();
          break;
          paramString.Z(1);
        }
      }
      if (i == 118)
      {
        paramString = new VideoR5.Builder(paramString);
        if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)
        {
          paramString.Y(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
          if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
            paramString.p(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramBaseReportData = paramString.a().a();
      }
      else if (i == 128)
      {
        paramString = new VideoR5.Builder(paramString);
        if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo != null)
        {
          paramString.Y(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.jdField_a_of_type_Int);
          if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
            paramString.p(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramBaseReportData = paramString.a().a();
      }
      else
      {
        paramBaseReportData = paramString;
      }
    }
  }
  
  public static String a(String paramString, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfString == null)) {}
    label60:
    for (;;)
    {
      return null;
      int j = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label60;
        }
        String str = paramArrayOfString[i];
        if (str.contains(paramString))
        {
          paramString = str.split("=");
          if (paramString.length != 2) {
            break;
          }
          return paramString[1];
        }
        i += 1;
      }
    }
  }
  
  private String a(Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap, String paramString1, BaseReportData paramBaseReportData, String paramString2, int paramInt)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        localJSONObject = new JSONObject(paramString2);
        localJSONObject.put("folder_status", paramString1);
        localJSONObject.put("is_change", ChannelListDynamicOrderConfigHandler.a(ReadInJoyUtils.a(), paramInt));
        if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
          return localJSONObject.toString();
        }
        bool = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData)) || (!paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
          continue;
        }
        paramInt = 1;
      }
      catch (Exception paramMap)
      {
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RIJFrameworkReportManager", 2, QLog.getStackTraceString(paramMap));
        return paramString2;
        paramInt = 0;
        break label173;
        return paramString2;
      }
      paramMap = (ReadinjoyReportUtils.ExposureReportItem)paramMap.get(Long.valueOf(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID));
      if ((paramMap != null) && (paramMap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        localJSONObject.put("main_text_read_time", paramMap.jdField_a_of_type_Long);
        continue;
        label173:
        if (!bool) {
          if (paramInt == 0) {}
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new RIJFrameworkReportManager.3(paramInt));
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramInt1 == 40677)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, ReadInJoyHelper.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.a(paramInt1, paramString, paramInt2, paramInt3, false, -1).a(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8009294", "", "", "", "", RIJTransMergeKanDianReport.b(paramInt1));
    }
    if (paramInt1 == 56) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", VideoReporter.a(paramInt1, null), false);
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ThreadManager.executeOnSubThread(new RIJFrameworkReportManager.1(paramInt, System.currentTimeMillis() - paramLong));
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt1;
      localReportInfo.mSourceArticleId = Long.valueOf(paramString1).longValue();
      localReportInfo.mAlgorithmId = Integer.valueOf(paramString3).intValue();
      localReportInfo.mStrategyId = Integer.valueOf(paramString2).intValue();
      localReportInfo.mUin = RIJQQAppInterfaceUtil.a();
      if (TextUtils.isEmpty(paramString4)) {}
      for (long l = -1L;; l = Long.valueOf(paramString4).longValue())
      {
        localReportInfo.mPuin = l;
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
          paramInt1 = RIJKanDianFolderStatus.jdField_a_of_type_Int;
        }
        localReportInfo.mFolderStatus = paramInt1;
        localReportInfo.mOpSource = 3;
        if (RIJXTabConfigHandler.b().a()) {
          localReportInfo.mChannelId = RIJXTabNormalRedDotStore.a.a();
        }
        if (localReportInfo.mChannelId == -1) {
          localReportInfo.mChannelId = 0;
        }
        localArrayList.add(localReportInfo);
        new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).b(localArrayList);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("RIJFrameworkReportManager", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str1 = "0X800A189";; str1 = "0X800A18A")
    {
      String str2 = new VideoR5.Builder(null, null, null, null).e(paramLong).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, str1, str1, 0, 0, "", "", "", str2, false);
      return;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label591;
      }
    }
    Object localObject1;
    Object localObject2;
    label591:
    for (int j = 0;; j = 1)
    {
      localObject1 = RIJFeedsType.b(paramArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i));
      localObject2 = ReadinjoyReportUtils.b(paramInt);
      Object localObject3 = RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo);
      localObject3 = RIJMsgReport.a.b((String)localObject3);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), (String)localObject3, false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = RIJQQAppInterfaceUtil.a();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label604;
      }
      localObject2 = new ReportInfo.FeedsReportData();
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label597;
      }
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        localObject3 = (SocializeFeedsInfo.FeedsInfoUser)paramArticleInfo.next();
        if (localObject3 != null) {
          ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)localObject3).jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
    }
    label597:
    ((ReportInfo)localObject1).mFeedsReportData = ((ReportInfo.FeedsReportData)localObject2);
    label604:
    paramContext.add(localObject1);
    ReadInJoyLogicEngine.a().a(paramContext);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    int i;
    label17:
    int j;
    label29:
    String str1;
    String str2;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label249;
      }
      j = 0;
      str1 = RIJFeedsType.b(paramArticleInfo);
      str2 = RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo);
      if ((!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break label254;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
        break label263;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
    }
    for (;;)
    {
      String str3 = ReadinjoyReportUtils.b(paramInt);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridClickEvent channelId: ", Integer.valueOf(paramInt), ", toUin: ", str1, ", r5: ", str2 });
      return;
      i = 0;
      break label17;
      label249:
      j = 1;
      break label29;
      label254:
      str1 = paramArticleInfo.mSubscribeID;
      continue;
      label263:
      str1 = "";
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    long l2 = paramArticleInfo.mFeedId;
    paramInt1 += 1;
    String str1;
    long l1;
    if ((RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
        break label284;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = RIJTransMergeKanDianReport.a(paramInt2, paramInt1, null, RIJFeedsType.a(paramArticleInfo), paramArticleInfo.innerUniqueID, RIJFeedsType.b(paramArticleInfo), paramArticleInfo);
      if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridImageClickEvent report click data, toUin: ", str1, ", r2(feedsId): ", Long.valueOf(l2), ", r3(articleId): ", Long.valueOf(l1), " r4(imagePos): ", Integer.valueOf(paramInt1), ", r5: ", str3 });
        return;
        str1 = paramArticleInfo.mSubscribeID;
        l1 = paramArticleInfo.mArticleID;
        break label77;
      }
      label284:
      l1 = 0L;
      str1 = "";
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt)
  {
    a(paramArticleInfo, paramActivity, paramInt, Integer.valueOf(0));
  }
  
  public static void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, Integer paramInteger)
  {
    Object localObject1 = RIJFeedsType.b(paramArticleInfo);
    int i;
    int j;
    label32:
    int k;
    label45:
    Object localObject2;
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label786;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label792;
      }
      k = paramArticleInfo.videoJumpChannelID;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i));
      localObject2 = ReadinjoyReportUtils.b(paramInt);
      if ((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break label799;
      }
      localObject3 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), k, paramArticleInfo));
      if (paramInt == 0) {
        ((VideoR5.Builder)localObject3).h(k).c((String)VideoReporter.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(RIJFeedsType.f(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((VideoR5.Builder)localObject3).a().a(), false);
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), k, paramArticleInfo));
      paramActivity = new ArrayList();
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
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if ((!UGRuleManager.c(paramArticleInfo)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject1).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject1).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label960;
      }
      localObject2 = new ReportInfo.FeedsReportData();
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      localObject3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label953;
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
      label786:
      j = 1;
      break label32;
      label792:
      k = 56;
      break label45;
      label799:
      localObject3 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i, j, NetworkUtil.h(paramActivity), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), k, paramArticleInfo));
      if (paramInt == 0) {
        ((VideoR5.Builder)localObject3).h(k).c((String)VideoReporter.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(RIJFeedsType.f(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((VideoR5.Builder)localObject3).a().a(), false);
    }
    label953:
    ((ReportInfo)localObject1).mFeedsReportData = ((ReportInfo.FeedsReportData)localObject2);
    label960:
    paramActivity.add(localObject1);
    ReadInJoyLogicEngine.a().a(paramActivity);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!ReadinJoyActionUtil.a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        break label1033;
      }
      paramInt = 8;
    }
    for (;;)
    {
      NativeAdUtils.a(new AdReportData().a(BaseApplicationImpl.getContext()).a(1).b(paramInt).b(paramInteger).a((AdvertisementInfo)paramArticleInfo));
      return;
      label1033:
      if (RIJFeedsType.a(paramArticleInfo)) {
        paramInt = 11;
      } else {
        paramInt = 3;
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str2 = "";
    long l2 = 0L;
    int i = 0;
    long l3 = paramArticleInfo.mFeedId;
    int j = paramInt + 1;
    long l1;
    String str1;
    if ((RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
    {
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label376;
      }
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = RIJTransMergeKanDianReport.a(paramInt, j, paramString, RIJFeedsType.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = RIJTransMergeKanDianReport.a(paramInt, j, null, RIJFeedsType.a(paramArticleInfo), paramArticleInfo.innerUniqueID, RIJFeedsType.b(paramArticleInfo), paramArticleInfo);
      paramBundle.putString("to_uin", str1);
      paramBundle.putString("feeds_id", Long.toString(l3));
      paramBundle.putString("article_id", Long.toString(l1));
      paramBundle.putInt("position", j);
      paramBundle.putString("read_article_r5", paramString);
      paramBundle.putString("scroll_image_r5", str2);
      paramBundle.putLong("channel_id", paramArticleInfo.mChannelID);
      paramBundle.putString("strategy_id", "" + paramArticleInfo.mStrategyId);
      return;
      str2 = paramArticleInfo.mSubscribeID;
      l2 = paramArticleInfo.mArticleID;
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        str1 = str2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size();
            l1 = l2;
            str1 = str2;
            continue;
          }
        }
      }
      label376:
      paramInt = i;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    a(paramArticleInfo, paramString1, paramString2, paramInt, null);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = RIJFeedsType.b(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, NetworkUtil.h(null), (String)localObject, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), 0, RIJTransMergeKanDianReport.a(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, RIJFeedsType.b(paramArticleInfo), paramString1, paramString2, 0, 0, RIJStringUtils.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      AIOUtils.a("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      ReadinjoyReportUtils.CoreReport.a(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    paramBaseArticleInfo = new VideoR5.Builder(null, null, null, null).W(54).i(paramBaseArticleInfo.getInnerUniqueID()).w(paramInt + 1).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", paramBaseArticleInfo, false);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[");
    int j = paramBaseArticleInfo.mGroupSubArticleList.size();
    int i = 0;
    while (i < j)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(i);
      String str = localBaseArticleInfo.getInnerUniqueID();
      int k = localBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int;
      if (localBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean)
      {
        localStringBuilder.append(str);
        if (QLog.isColorLevel()) {
          QLog.d("RIJFrameworkReportManager", 2, "position：" + k + ", rowKey: " + str);
        }
      }
      if ((j != 1) && (i != j - 1)) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    paramBaseArticleInfo = new VideoR5.Builder(paramString, null, null, null, null).W(54).i(localStringBuilder.toString()).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", paramBaseArticleInfo, false);
  }
  
  private void a(BaseReportData paramBaseReportData)
  {
    if (RIJFeedsType.k(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
    }
  }
  
  private void a(BaseReportData paramBaseReportData, int paramInt)
  {
    if (paramBaseReportData.jdField_c_of_type_Boolean) {
      try
      {
        if (paramBaseReportData.jdField_d_of_type_Boolean)
        {
          JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
          localJSONObject.put("feeds_source", paramBaseReportData.jdField_a_of_type_JavaLangString);
          localJSONObject.put("kandian_mode", RIJAppSetting.a());
          if (ReadinjoyReportUtils.a(paramInt)) {}
          for (String str = "0X8009358";; str = "0X800744E")
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", str, str, 0, 0, RIJFeedsType.c(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", localJSONObject.toString(), false);
            return;
          }
        }
        return;
      }
      catch (JSONException paramBaseReportData)
      {
        paramBaseReportData.printStackTrace();
      }
    }
  }
  
  private void a(BaseReportData paramBaseReportData, int paramInt, String paramString)
  {
    if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 0) {
      ComponentContentRecommend.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt, paramString);
    }
    do
    {
      return;
      if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 1)
      {
        ComponentContentRecommendFollowList.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt, paramString);
        return;
      }
    } while (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int != 2);
    ComponentContentRecommendFollowGroup.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt, paramString);
  }
  
  private void a(BaseReportData paramBaseReportData, Context paramContext, int paramInt)
  {
    if (RIJFeedsType.j(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
    {
      Object localObject = (BaseArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0);
      paramContext = ReadinjoyReportUtils.a(paramContext, ((BaseArticleInfo)localObject).mArticleID, ((BaseArticleInfo)localObject).mAlgorithmID, 54, paramInt, ((BaseArticleInfo)localObject).getInnerUniqueID(), ((BaseArticleInfo)localObject).getVideoVid(), ReadinjoyReportUtils.a((BaseArticleInfo)localObject), ((BaseArticleInfo)localObject).videoReportInfo);
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramContext);
          if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowGif)
          {
            ((JSONObject)localObject).put("short_content_gif", 1);
            localObject = ((JSONObject)localObject).toString();
            paramContext = (Context)localObject;
          }
        }
        catch (JSONException localJSONException1)
        {
          QLog.e("RIJFrameworkReportManager", 2, localJSONException1.getMessage());
          continue;
        }
        try
        {
          localObject = new JSONObject(paramContext);
          ((JSONObject)localObject).put("account_expose_card", RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          paramContext = (Context)localObject;
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("RIJFrameworkReportManager", 2, localJSONException2.getMessage());
          continue;
        }
        a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramContext);
        return;
        ((JSONObject)localObject).put("short_content_gif", 0);
      }
    }
    paramContext = ReadinjoyReportUtils.a(paramContext, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource, paramBaseReportData.k, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), 54, ReadinjoyReportUtils.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), Integer.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId), paramContext, false);
    paramBaseReportData = new VideoR5.Builder(null, null, null, null).W(54).i(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()).w(paramBaseReportData.k + 1).f(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData, false);
  }
  
  private void a(BaseReportData paramBaseReportData, String paramString1, String paramString2)
  {
    int i = 0;
    while (i < paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramBaseReportData.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int + "", Integer.toString(paramBaseReportData.jdField_b_of_type_Int), paramString1, false);
      i += 1;
    }
  }
  
  private void a(BaseReportData paramBaseReportData, String paramString1, String paramString2, Context paramContext, int paramInt, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (!paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = RIJQQAppInterfaceUtil.b();
      if (localQQAppInterface == null) {
        break label461;
      }
    }
    label461:
    for (paramString1 = localQQAppInterface.getCurrentUin();; paramString1 = "0")
    {
      String str = RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramInt, 0, 0, NetworkUtil.h(paramContext), paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, null, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, (ArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", str, false);
      paramString2 = ReadinjoyReportUtils.a(paramInt);
      if (localQQAppInterface != null) {
        paramString1 = localQQAppInterface.getCurrentUin();
      }
      paramContext = RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramInt, NetworkUtil.h(paramContext), paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, 0, paramBaseReportData.jdField_f_of_type_Int, (ArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      if (paramBoolean) {
        paramInt = 1;
      }
      do
      {
        try
        {
          for (;;)
          {
            paramContext.put("from_aio", paramInt);
            paramContext = paramContext.toString();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", paramContext, false);
            return;
            paramInt = 0;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("RIJFrameworkReportManager", 2, localJSONException.getMessage());
          }
        }
      } while (!RIJFeedsType.n(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramString1, false);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
      localJSONObject.put("tab_source", paramString);
      localJSONObject.put("kandian_mode_new", VideoReporter.a());
      paramString = localJSONObject.toString();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramString = str;
        if (QLog.isColorLevel())
        {
          QLog.e("RIJFrameworkReportManager", 2, "firstClassDeliverOperationReport:" + localJSONException.toString());
          paramString = str;
        }
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.contains("dailyJumpSrc")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dailyJumpSrc", a("dailyJumpSrc", paramString.split("&")));
      localJSONObject.put("jumpSuccess", paramInt1);
      localJSONObject.put("fullScheme", paramString);
      localJSONObject.put("isCancelJump", paramInt2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("RIJFrameworkReportManager", 2, paramString.getMessage());
    }
  }
  
  private void a(Map<Long, BaseReportData> paramMap, int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (BaseReportData)paramMap.next();
      if (!((BaseReportData)localObject2).jdField_b_of_type_Boolean)
      {
        ((BaseReportData)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = ReadInJoyUtils.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((BaseReportData)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = paramInt;
        localReportInfo.mAlgorithmId = ((int)((BaseReportData)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((BaseReportData)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((BaseReportData)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((BaseReportData)localObject2).jdField_e_of_type_JavaLangString;
        if (((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (paramInt == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new ReportInfo.VideoExtraRepoerData();
          if (paramLong != 0L) {
            break label592;
          }
        }
        label592:
        for (int i = 1;; i = 0)
        {
          ((ReportInfo.VideoExtraRepoerData)localObject1).jdField_c_of_type_Int = i;
          localObject1 = ((ReportInfo.VideoExtraRepoerData)localObject1).toString();
          localReportInfo.mInnerId = ((BaseReportData)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if (((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null) {
            break label605;
          }
          localObject1 = new ReportInfo.FeedsReportData();
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Long = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
            ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Long = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
          }
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Int = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Int = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject2).next();
            if (localFeedsInfoUser != null) {
              ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((ReportInfo.FeedsReportData)localObject1);
        label605:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      ReadInJoyLogicEngine.a().a(localArrayList);
    }
  }
  
  private void a(Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap, boolean paramBoolean)
  {
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      ReadinjoyReportUtils.ExposureReportItem localExposureReportItem = (ReadinjoyReportUtils.ExposureReportItem)localIterator.next();
      ArticleInfo localArticleInfo = (ArticleInfo)localExposureReportItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((!RIJFeedsType.g(localArticleInfo)) || (!localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
      {
        String str1 = RIJFeedsType.b(localArticleInfo);
        paramMap = localArticleInfo.innerUniqueID;
        Object localObject = paramMap;
        if (RIJFeedsType.j(localArticleInfo))
        {
          localObject = paramMap;
          if (localArticleInfo.mGroupSubArticleList.size() >= 1) {
            localObject = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        String str2 = RIJFeedsType.d(localArticleInfo);
        if (((RIJItemViewType.g(localArticleInfo)) || (RIJItemViewType.i(localArticleInfo)) || (RIJItemViewType.j(localArticleInfo)) || (RIJItemViewType.k(localArticleInfo))) && (!RIJItemViewType.o(localArticleInfo))) {
          paramMap = String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
        }
        for (;;)
        {
          for (;;)
          {
            localObject = RIJTransMergeKanDianReport.a(localArticleInfo.mAlgorithmID, RIJFeedsType.a(localArticleInfo), (int)localArticleInfo.mChannelID, NetworkState.isWifiConn(), str1, (String)localObject, str2, 0, localExposureReportItem.jdField_a_of_type_Int, localArticleInfo);
            str1 = a(localArticleInfo.mChannelID);
            try
            {
              ((JSONObject)localObject).put("exposure_time", "" + (float)localExposureReportItem.jdField_a_of_type_Long / 1000.0F);
              if (DailyModeConfigHandler.c((int)localArticleInfo.mChannelID)) {
                ((JSONObject)localObject).put("cmd", ReadInJoyHelper.i());
              }
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramMap, str1, str1, 0, 0, Long.toString(localArticleInfo.mFeedId), localArticleInfo.mArticleID + "", localArticleInfo.mStrategyId + "", ((JSONObject)localObject).toString(), false);
            }
            catch (JSONException paramMap)
            {
              paramMap.printStackTrace();
            }
          }
          break;
          if ((RIJFeedsType.i(localArticleInfo)) && (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6)) {
            paramMap = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "";
          } else {
            paramMap = localArticleInfo.mSubscribeID;
          }
        }
      }
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = ReadinjoyReportUtils.b(paramInt);
    a(paramArticleInfo, str, str, paramInt);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mVideoColumnInfo == null)) {
      return;
    }
    paramBaseArticleInfo = new VideoR5.Builder(null, null, null, null).i(paramBaseArticleInfo.innerUniqueID).c(paramBaseArticleInfo).d(paramBaseArticleInfo).R(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo, false).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", paramBaseArticleInfo, false);
  }
  
  private void b(BaseReportData paramBaseReportData)
  {
    if ((paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyMedalInfo != null)) {
      RIJMedalUtils.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyMedalInfo, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
  }
  
  private void b(BaseReportData paramBaseReportData, Context paramContext, int paramInt)
  {
    long l3;
    int i;
    int j;
    int k;
    long l1;
    String str1;
    String str2;
    if ((paramBaseReportData.jdField_c_of_type_Int == 48) || (paramBaseReportData.jdField_c_of_type_Int == 49) || (paramBaseReportData.jdField_c_of_type_Int == 50) || (paramBaseReportData.jdField_c_of_type_Int == 51) || (paramBaseReportData.jdField_c_of_type_Int == 52) || (paramBaseReportData.jdField_c_of_type_Int == 53) || (paramBaseReportData.jdField_c_of_type_Int == 78) || (paramBaseReportData.jdField_c_of_type_Int == 79) || (paramBaseReportData.jdField_c_of_type_Int == 80) || (paramBaseReportData.jdField_c_of_type_Int == 1005) || (paramBaseReportData.jdField_c_of_type_Int == 1006) || (paramBaseReportData.jdField_c_of_type_Int == 1007))
    {
      l3 = paramBaseReportData.jdField_b_of_type_Long;
      i = paramBaseReportData.k;
      j = GalleryReportedUtils.a(paramInt, paramBaseReportData.jdField_c_of_type_Int);
      k = GalleryReportedUtils.a(paramBaseReportData.jdField_c_of_type_Int);
      l1 = 0L;
      str1 = null;
      str2 = null;
      if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
        break label313;
      }
      l1 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      str1 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      str2 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
    }
    label313:
    for (long l2 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      paramContext = GalleryReportedUtils.a(paramContext, ReadInJoyUtils.a(), j, l1, l3, i, str1, str2, k, paramInt);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramBaseReportData.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", paramContext, false);
      GalleryReportedUtils.a(7, ReadInJoyUtils.a(), (int)l2, j, l3, i, str1, str2);
      return;
    }
  }
  
  private void b(BaseReportData paramBaseReportData, String paramString1, String paramString2)
  {
    if ((paramBaseReportData == null) || (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    Object localObject1;
    for (;;)
    {
      return;
      try
      {
        if ((RecycleViewAdapterHelper.a() != null) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null)
          {
            localObject1 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
            if ((localObject1 != null) && (((Map)localObject1).entrySet() != null))
            {
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
              {
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                paramString1.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue().toString());
              }
            }
          }
          localObject1 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
        }
      }
      catch (JSONException paramBaseReportData)
      {
        QLog.e("RIJFrameworkReportManager", 2, paramBaseReportData.getMessage());
        return;
      }
    }
    Object localObject2 = RecycleViewAdapterHelper.a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject2).next();
      if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
      {
        paramString1.put("rowkey", ((NewPolymericInfo.PackArticleInfo)((List)localObject1).get(localInteger.intValue())).g);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), paramString1.toString(), false);
      }
    }
    RecycleViewAdapterHelper.a();
  }
  
  public static void c(ArticleInfo paramArticleInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = RIJQQAppInterfaceUtil.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramArticleInfo.innerUniqueID;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
      localFeedsReportData.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        localFeedsReportData.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      localFeedsReportData.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localFeedsReportData.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
      {
        localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramArticleInfo = paramArticleInfo.iterator();
        while (paramArticleInfo.hasNext())
        {
          SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)paramArticleInfo.next();
          if (localFeedsInfoUser != null) {
            localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localFeedsReportData;
    }
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (DailyModeConfigHandler.c(paramInt1))
    {
      if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
        break label28;
      }
      KandianDailyReportUtils.a(1);
    }
    label28:
    while (paramInt2 == 2) {
      return;
    }
    KandianDailyReportUtils.a(1);
  }
  
  public void a(Map<Integer, BaseReportData> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int j = ChannelCoverView.jdField_b_of_type_Int;
        if ((localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int i = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; i = 0)
        {
          ChannelCoverView.a("0X8009495", localTabChannelCoverInfo, j, i, -1);
          break;
        }
      }
    }
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString, Context paramContext, int paramInt)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("RIJFrameworkReportManager", 2, "report data is null ");
      return;
    }
    Iterator localIterator = paramMap.values().iterator();
    BaseReportData localBaseReportData;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localBaseReportData = (BaseReportData)localIterator.next();
        if (!localBaseReportData.jdField_a_of_type_Boolean)
        {
          localBaseReportData.jdField_a_of_type_Boolean = true;
          if ((localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo != null))
          {
            i = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            localBaseReportData.jdField_c_of_type_Int = 1008;
            if (i == 5) {
              localBaseReportData.jdField_c_of_type_Int = 1009;
            }
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt, localBaseReportData.jdField_d_of_type_Int), false);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FC", "", "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt, localBaseReportData.jdField_d_of_type_Int));
          if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            paramMap = RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(paramContext), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i, localBaseReportData.m);
            try
            {
              localObject = new JSONObject(paramMap);
              ((JSONObject)localObject).put("feeds_type", localBaseReportData.jdField_c_of_type_Int);
              ((JSONObject)localObject).put("folder_status", paramString);
              localObject = ((JSONObject)localObject).toString();
              paramMap = (Map<Long, BaseReportData>)localObject;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Object localObject;
                int j;
                long l3;
                long l1;
                QLog.e("RIJFrameworkReportManager", 2, localJSONException.getMessage());
                continue;
                str1 = "0X8007626";
              }
            }
            if (ReadinjoyReportUtils.a(paramInt))
            {
              localObject = "0X8009354";
              paramMap = new VideoR5.Builder(paramMap);
              paramMap.a(localBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, (String)localObject, (String)localObject, 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), paramMap.a().a(), false);
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject, localBaseReportData.jdField_d_of_type_JavaLangString, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(paramContext), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i, localBaseReportData.m));
              if ((localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo == null)) {
                continue;
              }
              j = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
              i = 8;
              if (j == 5) {
                i = 12;
              }
              l3 = localBaseReportData.jdField_b_of_type_Long;
              j = localBaseReportData.k;
              l1 = 0L;
              paramMap = null;
              localObject = null;
              if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
                break label955;
              }
              l1 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
              paramMap = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
              localObject = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
            }
          }
        }
      }
    }
    label955:
    for (long l2 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str2 = GalleryReportedUtils.a(paramContext, ReadInJoyUtils.a(), 16, l1, l3, j, paramMap, (String)localObject, i, paramInt);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localBaseReportData.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str2, false);
      GalleryReportedUtils.a(7, ReadInJoyUtils.a(), (int)l2, 16, l3, j, paramMap, (String)localObject);
      break;
      String str1;
      b(paramMap1);
      return;
    }
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean1, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString, Context paramContext, int paramInt1, int paramInt2, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean2, long paramLong)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean1))
    {
      QLog.d("RIJFrameworkReportManager", 2, "report data is null ");
      if ((paramMap1 != null) && (!paramMap1.isEmpty())) {
        a(paramMap1, paramBoolean2);
      }
      return;
    }
    RIJVideoReportManager.a(paramMap, paramInt1, paramReadInJoyBaseViewController.a());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.values().iterator();
    label81:
    BaseReportData localBaseReportData;
    Object localObject;
    long l;
    int i;
    String str;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localBaseReportData = (BaseReportData)localIterator.next();
        if (!localBaseReportData.jdField_a_of_type_Boolean)
        {
          localBaseReportData.jdField_a_of_type_Boolean = true;
          localObject = a(paramContext, paramInt1);
          l = ((Long)((Pair)localObject).second).longValue();
          i = ((Integer)((Pair)localObject).first).intValue();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt1, localBaseReportData.jdField_d_of_type_Int), false);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FC", "", "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt1, localBaseReportData.jdField_d_of_type_Int));
          if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            str = RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt1, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(paramContext), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l, i, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i, localBaseReportData.m);
            if (paramInt1 == 56)
            {
              localObject = RIJVideoReportManager.a(localBaseReportData, str, paramReadInJoyBaseViewController.a());
              label421:
              localObject = a(paramMap1, paramString, localBaseReportData, (String)localObject, paramInt1);
              str = RIJMsgReport.a.b((String)localObject);
              if (!ReadinjoyReportUtils.a(paramInt1)) {
                break label558;
              }
              localObject = "0X8009354";
              label460:
              if ((!DailyModeConfigHandler.a(paramInt1)) && (!ReadInJoyHelper.a(paramInt1))) {
                break label964;
              }
              localObject = "0X8009CC8";
            }
          }
        }
      }
    }
    label558:
    label964:
    for (;;)
    {
      if (RIJItemViewType.i(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        a(localBaseReportData, str, (String)localObject);
      }
      for (;;)
      {
        b(localBaseReportData, paramContext, paramInt1);
        a(localBaseReportData, paramInt1);
        a(localBaseReportData);
        b(localBaseReportData);
        break label81;
        localObject = str;
        if (paramInt1 != 0) {
          break label421;
        }
        localObject = a(localBaseReportData, str);
        break label421;
        localObject = "0X8007626";
        break label460;
        if (RIJFeedsType.l(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localBaseReportData, paramContext, paramInt1);
        }
        else if (RIJFeedsType.s(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          b(localBaseReportData, str, (String)localObject);
        }
        else if (RIJFeedsType.g(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localBaseReportData, str, (String)localObject, paramContext, paramInt1, paramBoolean2);
        }
        else if (RIJFeedsType.t(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localBaseReportData, paramInt1, (String)localObject);
        }
        else
        {
          if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType == 33)
          {
            localObject = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getProteusItemData();
            if (localObject == null) {
              break;
            }
            RIJVideoReportManager.a(false, (JSONObject)localObject, localBaseReportData);
            RIJVideoReportManager.a(true, (JSONObject)localObject, localBaseReportData);
            continue;
          }
          if (RIJFeedsType.q(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            RIJVideoReportManager.a(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localBaseReportData);
          }
          else
          {
            if (RIJFeedsType.i(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
            {
              BaseArticleInfo localBaseArticleInfo = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              JSONObject localJSONObject = RIJKanDianFolderStatus.a(localBaseArticleInfo.mPolymericInfo);
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X8008F57", "0X8008F57", 0, 0, localBaseReportData.k + "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(localBaseArticleInfo.mPolymericInfo.d), localJSONObject.toString(), false);
              if (localHashMap.containsKey(Long.valueOf(localBaseArticleInfo.mPolymericInfo.c))) {
                break label81;
              }
              localHashMap.put(Long.valueOf(localBaseArticleInfo.mPolymericInfo.c), Boolean.valueOf(true));
            }
            RIJVideoReportManager.a(localBaseReportData, l, i, str, (String)localObject, paramContext, paramInt1, paramInt2, paramReadInJoyBaseViewController, paramBoolean2);
          }
        }
      }
      if (paramInt1 != 40677) {
        a(paramMap, paramInt1, paramLong);
      }
      a(paramMap1, paramBoolean2);
      ReadinjoySocialMsgCard.a(((Integer)a(paramContext, paramInt1).first).intValue());
      return;
    }
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean1, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString, boolean paramBoolean2, int paramInt1, Context paramContext, int paramInt2, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean3, long paramLong)
  {
    ThreadManager.post(new RIJFrameworkReportManager.2(this, paramBoolean2, paramMap, paramBoolean1, paramMap1, paramString, paramContext, paramInt1, paramInt2, paramReadInJoyBaseViewController, paramBoolean3, paramLong), 5, null, false);
  }
  
  public void b(Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap)
  {
    a(paramMap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager
 * JD-Core Version:    0.7.0.1
 */