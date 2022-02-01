package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDailyViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.json.RIJR5JsonManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSRijReport;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianLiveInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.ProteusReportUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class RIJVideoReportManager
{
  public static String a(VideoInfo paramVideoInfo, int paramInt)
  {
    VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, null);
    localBuilder.T(ReadinjoyTabFrame.jdField_b_of_type_Int).U(paramInt);
    if (paramVideoInfo != null) {
      if (paramVideoInfo.h) {
        if (paramVideoInfo.jdField_g_of_type_Boolean)
        {
          paramInt = 3;
          localBuilder.a("status", Integer.valueOf(paramInt)).i(paramVideoInfo.jdField_g_of_type_JavaLangString).e(paramVideoInfo.f).e(paramVideoInfo.jdField_a_of_type_JavaLangString).V(0).a(0);
        }
      }
    }
    for (;;)
    {
      return localBuilder.a().a();
      paramInt = 2;
      break;
      paramInt = 4;
      break;
      localBuilder.a("status", Integer.valueOf(1));
    }
  }
  
  public static String a(BaseReportData paramBaseReportData, String paramString, VideoPlayManager paramVideoPlayManager)
  {
    paramString = RIJTransMergeKanDianReport.a(paramString, paramVideoPlayManager.b(), VideoReporter.jdField_a_of_type_Int);
    if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
      return paramString;
    }
    if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
      paramString = new VideoR5.Builder(paramString).c(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).a().a();
    }
    for (;;)
    {
      if (((RIJItemViewType.a((ArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) == 46) || (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem)) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail))) {
        VideoFeedsHelper.a(RIJPBFieldUtils.b(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + RIJPBFieldUtils.b(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
      }
      return paramString;
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, Map<String, Object> paramMap, RIJDataManager paramRIJDataManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramRIJDataManager.a().b() == 0) || (paramRIJDataManager.a().b() == 56))
    {
      if (VideoFeedsHelper.a((Activity)paramRIJDataManager.a().a(), paramArticleInfo1))
      {
        a(paramVideoPlayParam, paramArticleInfo1, paramRIJDataManager);
        if ((paramRIJDataManager.a().b() == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail))) {
          VideoFeedsHelper.a(RIJPBFieldUtils.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + RIJPBFieldUtils.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
        }
        return;
      }
      if ((paramRIJDataManager.a().b() == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
        VideoFeedsHelper.a(RIJPBFieldUtils.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + RIJPBFieldUtils.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
      }
    }
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        ReadInJoyActivityHelper.a(paramRIJDataManager.a().a(), paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        a(paramVideoPlayParam, paramArticleInfo1, paramRIJDataManager);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        ReadInJoyActivityHelper.b(paramRIJDataManager.a().a(), paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (ReadInJoyHelper.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      ReadInJoyActivityHelper.a(paramRIJDataManager.a().a(), paramArticleInfo2, paramArticleInfo1, true);
      a(paramVideoPlayParam, paramArticleInfo1, paramRIJDataManager);
      return;
    }
    paramVideoPlayParam.a = paramMap;
    paramRIJDataManager.a().a().a(paramVideoPlayParam, paramArticleInfo1);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(RIJPBFieldUtils.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      RIJJumpUtils.a(paramContext, RIJPBFieldUtils.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, BaseReportData paramBaseReportData)
  {
    if ((paramBaseArticleInfo == null) || (!RIJFeedsType.q(paramBaseArticleInfo))) {
      return;
    }
    paramBaseReportData = new VideoR5.Builder(null, null, null, null).W(Integer.valueOf("2007").intValue());
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    paramBaseReportData.p(paramBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
    paramBaseReportData.p(localBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
  }
  
  public static void a(BaseReportData paramBaseReportData, long paramLong, int paramInt1, String paramString1, String paramString2, Context paramContext, int paramInt2, int paramInt3, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean)
  {
    Object localObject1 = new VideoR5.Builder(paramString1);
    ((VideoR5.Builder)localObject1).a(Boolean.valueOf(RIJFeedsType.f(paramBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(paramBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).b(paramBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (paramInt2 == 40677)
    {
      ((VideoR5.Builder)localObject1).b(paramBaseReportData.j);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, "0X8009292", "0X8009292", 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), ((VideoR5.Builder)localObject1).a().a(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8009292", paramBaseReportData.jdField_d_of_type_JavaLangString, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_Long, paramBaseReportData.jdField_c_of_type_Int, paramInt2, paramBaseReportData.jdField_d_of_type_Int, paramBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(paramContext), paramBaseReportData.jdField_a_of_type_JavaLangString, paramBaseReportData.jdField_c_of_type_JavaLangString, paramBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramLong, paramInt1, paramBaseReportData.jdField_f_of_type_Int, paramBaseReportData.g, paramBaseReportData.h, paramBaseReportData.jdField_f_of_type_Boolean, paramBaseReportData.j, paramBaseReportData.i, paramBaseReportData.m));
      return;
    }
    if (paramInt3 == 3)
    {
      paramInt3 = -1;
      if ((paramReadInJoyBaseViewController instanceof ReadInJoyChannelViewController)) {
        paramInt3 = ((ReadInJoyChannelViewController)paramReadInJoyBaseViewController).a();
      }
      ((VideoR5.Builder)localObject1).N(paramInt3);
    }
    ((VideoR5.Builder)localObject1).a(paramBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    Object localObject2;
    if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null)
    {
      localObject2 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if ((localObject2 != null) && (((Map)localObject2).entrySet() != null))
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while ((localObject2 != null) && (((Iterator)localObject2).hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((VideoR5.Builder)localObject1).a((String)localEntry.getKey(), localEntry.getValue().toString());
        }
      }
    }
    PTSRijReport.a((VideoR5.Builder)localObject1, paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    RIJStatisticCollectorReport.a(paramString2, paramBaseReportData, (VideoR5.Builder)localObject1);
    if ((paramReadInJoyBaseViewController instanceof ReadInJoyDailyViewController))
    {
      if (paramBoolean)
      {
        paramInt3 = 1;
        label448:
        ((VideoR5.Builder)localObject1).a("from_aio", Integer.valueOf(paramInt3));
      }
    }
    else
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), ((VideoR5.Builder)localObject1).a().a(), false);
      localObject1 = ProteusReportUtil.a(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean);
      paramReadInJoyBaseViewController = paramString1;
      if (localObject1 == null) {
        break label732;
      }
      localObject2 = ((List)localObject1).iterator();
      label559:
      paramReadInJoyBaseViewController = paramString1;
      if (!((Iterator)localObject2).hasNext()) {
        break label732;
      }
      localObject1 = (String)((Iterator)localObject2).next();
    }
    label1026:
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramReadInJoyBaseViewController = new JSONObject(paramString1);
          localObject1 = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute((String)localObject1);
          if (localObject1 == null) {
            break label1026;
          }
          ProteusReportUtil.a(paramReadInJoyBaseViewController, (Map)localObject1);
          paramReadInJoyBaseViewController = paramReadInJoyBaseViewController.toString();
          paramString1 = paramReadInJoyBaseViewController;
        }
        catch (JSONException localJSONException1)
        {
          paramReadInJoyBaseViewController = paramString1;
          paramString1 = localJSONException1;
        }
        try
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), paramString1, false);
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            label732:
            label1008:
            paramReadInJoyBaseViewController = paramString1;
            paramString1 = localJSONException2;
          }
        }
      }
      paramInt3 = 0;
      break label448;
      QLog.d("RIJVideoReportManager", 1, "extra_expose", paramString1);
      paramString1 = paramReadInJoyBaseViewController;
      break label559;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse(paramString2, paramBaseReportData.jdField_d_of_type_JavaLangString, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_Long, paramBaseReportData.jdField_c_of_type_Int, paramInt2, paramBaseReportData.jdField_d_of_type_Int, paramBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(paramContext), paramBaseReportData.jdField_a_of_type_JavaLangString, paramBaseReportData.jdField_c_of_type_JavaLangString, paramBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramLong, paramInt1, paramBaseReportData.jdField_f_of_type_Int, paramBaseReportData.g, paramBaseReportData.h, paramBaseReportData.jdField_f_of_type_Boolean, paramBaseReportData.j, paramBaseReportData.i, paramBaseReportData.m));
      for (;;)
      {
        try
        {
          if ((Aladdin.get(250).getIntegerFromString("pj_enable", 0) != 1) || (DailyModeConfigHandler.c(paramInt2))) {
            break;
          }
          paramString1 = new RIJTransMergeKanDianReport.ReportR5Builder(new JSONObject(paramReadInJoyBaseViewController));
          if (ReadinjoyReportUtils.b() <= 0) {
            break label1008;
          }
          paramInt1 = 0;
          paramString1.b("behavior_type", paramInt1);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, "0X800A9AF", "0X800A9AF", 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), paramString1.a(), false);
          return;
        }
        catch (Exception paramBaseReportData) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RIJVideoReportManager", 2, QLog.getStackTraceString(paramBaseReportData));
        return;
        paramInt1 = 1;
      }
    }
  }
  
  public static void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    String str1 = RIJFeedsType.b(paramBaseArticleInfo);
    int i;
    int j;
    label34:
    VideoR5.Builder localBuilder;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label615;
      }
      j = 0;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseArticleInfo), paramRIJDataManager.a().b(), i), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseArticleInfo), paramRIJDataManager.a().b(), i));
      localBuilder = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseArticleInfo), paramRIJDataManager.a().b(), i, j, NetworkUtil.h(paramRIJDataManager.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, RIJFeedsType.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      localBuilder.a(paramRIJDataManager.a().a(), paramBaseArticleInfo.mArticleID).a(paramRIJDataManager.a().a()).g(VideoReporter.jdField_a_of_type_Int).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(RIJFeedsType.f(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (paramRIJDataManager.a().b() != 0) {
        break label621;
      }
      paramVideoPlayParam.l = VideoReporter.b();
      localBuilder.b(paramVideoPlayParam.l);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localBuilder.Y(paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (RIJItemViewType.a((ArticleInfo)paramBaseArticleInfo) == 6) {
        localBuilder.aa(VideoFeedsHelper.f());
      }
    }
    for (;;)
    {
      if ((paramRIJDataManager.a().a() != null) && (paramRIJDataManager.a().a().a() == paramVideoPlayParam))
      {
        long l = paramRIJDataManager.a().a().a();
        if (l != 0L) {
          localBuilder.f(l);
        }
      }
      if (paramRIJDataManager.a().b() != 40677) {
        break label686;
      }
      localBuilder.b(paramBaseArticleInfo.mVideoAdsJumpType).a(WeishiGuideUtils.a(paramRIJDataManager.a().a()));
      localBuilder.i(2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localBuilder.a().a(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseArticleInfo), paramRIJDataManager.a().b(), i, j, NetworkUtil.h(paramRIJDataManager.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, RIJFeedsType.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i = 0;
      break;
      label615:
      j = 1;
      break label34;
      label621:
      if ((paramRIJDataManager.a().b() == 56) && (paramRIJDataManager.a().a() != null) && (!TextUtils.isEmpty(paramRIJDataManager.a().a().b())))
      {
        paramVideoPlayParam.m = paramRIJDataManager.a().a().b();
        localBuilder.c(paramVideoPlayParam.m);
      }
    }
    label686:
    localBuilder.a(paramBaseArticleInfo).N((int)paramRIJDataManager.a().a()).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((RIJFeedsType.l(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      localBuilder.w(paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int + 1);
    }
    String str2 = ReadinjoyReportUtils.b(paramRIJDataManager.a().b());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), RIJR5JsonManager.a(localBuilder.a().a(), paramVideoPlayParam.a), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse(str2, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseArticleInfo), paramRIJDataManager.a().b(), i, j, NetworkUtil.h(paramRIJDataManager.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, RIJFeedsType.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public static void a(Map<Long, BaseReportData> paramMap, int paramInt, VideoRecommendManager paramVideoRecommendManager)
  {
    if ((paramInt == 56) && (paramVideoRecommendManager != null))
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        localBaseReportData.h = paramVideoRecommendManager.a();
        if (paramVideoRecommendManager.a(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID)) {
          localBaseReportData.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap, RIJDataManager paramRIJDataManager)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = RIJConfigVideoItem.a(paramArticleInfo1);
    localVideoPlayParam.n = paramString;
    localVideoPlayParam.l = VideoReporter.b();
    if ((paramRIJDataManager.a().a() != null) && (!TextUtils.isEmpty(paramRIJDataManager.a().a().b()))) {
      localVideoPlayParam.m = paramRIJDataManager.a().a().b();
    }
    paramString = new VideoR5.Builder(null, null, null, null);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramString = paramString.Z(i).b(localVideoPlayParam.l).c(localVideoPlayParam.m).a(paramRIJDataManager.a().b()).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)paramRIJDataManager.a().a()).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString, false);
      if (!VideoFeedsHelper.a(paramArticleInfo1, paramRIJDataManager.a().a())) {
        break;
      }
      a(localVideoPlayParam, paramArticleInfo1, paramRIJDataManager);
      return;
    }
    if ((paramArticleInfo1.isAccountShown) && (paramRIJDataManager.a().b() == 0) && (!TextUtils.isEmpty(paramArticleInfo1.mArticleContentUrl)))
    {
      RIJJumpUtils.a(paramRIJDataManager.a().a(), paramArticleInfo1.mArticleContentUrl);
      paramString = new VideoR5.Builder(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
      if (paramBoolean)
      {
        i = 0;
        paramArticleInfo2 = paramString.Z(i).b(localVideoPlayParam.l).c(localVideoPlayParam.m).a(paramRIJDataManager.a().b()).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)paramRIJDataManager.a().a()).W(RIJFeedsType.a(paramArticleInfo1)).e(paramArticleInfo1).R(7).f(paramArticleInfo2);
        if ((paramArticleInfo1.columnEntrances != null) && (paramArticleInfo1.columnEntrances.size() > 0))
        {
          paramArticleInfo1 = (VideoColumnInfo)paramArticleInfo1.columnEntrances.get(0);
          if (paramArticleInfo1.jdField_a_of_type_Int == 0) {
            break label537;
          }
          paramArticleInfo2.a("is_column", "1");
          paramArticleInfo2.a("column_id", String.valueOf(paramArticleInfo1.jdField_a_of_type_Int));
          if (!paramArticleInfo1.jdField_a_of_type_Boolean) {
            break label530;
          }
          paramArticleInfo1 = "1";
          label464:
          paramArticleInfo2.a("subscribe_flag", paramArticleInfo1);
        }
      }
      for (;;)
      {
        paramArticleInfo1 = paramArticleInfo2.a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", RIJR5JsonManager.a(paramArticleInfo1, paramMap), false);
        return;
        i = 1;
        break;
        label530:
        paramArticleInfo1 = "2";
        break label464;
        label537:
        paramArticleInfo2.a("is_column", "0");
      }
    }
    if (paramArticleInfo1.isVideoItemForAdJump())
    {
      paramArticleInfo2 = (Activity)paramRIJDataManager.a().a();
      if (paramArticleInfo2 != null)
      {
        paramString = new Intent(paramArticleInfo2, QQBrowserActivity.class);
        paramString.putExtra("url", paramArticleInfo1.mVideoAdsJumpUrl);
        paramString.putExtra("big_brother_source_key", RIJJumpUtils.a(paramRIJDataManager.a().b()));
        paramArticleInfo2.startActivity(paramString);
      }
      a(localVideoPlayParam, paramArticleInfo1, paramRIJDataManager);
      return;
    }
    a(paramArticleInfo1, paramArticleInfo2, paramMap, paramRIJDataManager, localVideoPlayParam);
  }
  
  public static void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo, Context paramContext, int paramInt, long paramLong)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      RIJJumpUtils.a(paramContext, paramBaseArticleInfo.mArticleContentUrl);
      paramContext = new VideoR5.Builder(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label147;
      }
    }
    label147:
    for (int i = 0;; i = 1)
    {
      paramBaseArticleInfo = paramContext.Z(i).a(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).N((int)paramLong).W(RIJFeedsType.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).R(6).f(paramBaseArticleInfo).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", paramBaseArticleInfo, false);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, BaseReportData paramBaseReportData)
  {
    if ((paramJSONObject == null) || (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    for (;;)
    {
      return;
      Object localObject = new VideoR5.Builder(null, null, null, null).W(Integer.valueOf("1031").intValue()).q(paramJSONObject.optString("double_videocard_jump_page")).r(paramJSONObject.optString("double_videocard_jump_src")).a((int)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID);
      if (ReadinjoyReportUtils.b() > 0) {}
      for (int i = 0;; i = 1)
      {
        paramBaseReportData = ((VideoR5.Builder)localObject).ag(i).f(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        if (!paramBoolean) {
          break;
        }
        localObject = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBaseReportData.a("columnId", localObject);
        }
        paramBaseReportData.i(paramJSONObject.optString("all_rowkey"));
        paramBaseReportData.s(paramJSONObject.optString("subscript"));
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
        return;
      }
      i = 0;
      while (i < 2)
      {
        localObject = paramJSONObject.optString("columnId_" + (i + 1));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBaseReportData.a("columnId", localObject);
        }
        paramBaseReportData.i(paramJSONObject.optString("rowKey_" + (i + 1)));
        paramBaseReportData.s(paramJSONObject.optString("subscript_" + (i + 1)));
        paramBaseReportData.Z(i);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
        i += 1;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, BaseArticleInfo paramBaseArticleInfo, Activity paramActivity, int paramInt, VideoRecommendManager paramVideoRecommendManager, VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager.b()) {
      paramVideoPlayManager.a();
    }
    if (paramVideoRecommendManager != null) {
      paramVideoRecommendManager.a(1, paramBaseArticleInfo, 0L, 0L);
    }
    paramVideoRecommendManager = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramVideoRecommendManager.putExtra("arg_article_info", (ArticleInfo)paramBaseArticleInfo);
    paramVideoRecommendManager.putExtra("biu_src", 2);
    paramVideoRecommendManager.putExtra("arg_from_type", 7);
    paramVideoRecommendManager.putExtra("fast_biu_type", paramBoolean2);
    paramActivity.startActivityForResult(paramVideoRecommendManager, 2);
    paramActivity.overridePendingTransition(0, 0);
    paramVideoRecommendManager = paramVideoPlayManager.a();
    if ((paramVideoRecommendManager != null) && (paramVideoRecommendManager.jdField_c_of_type_JavaLangString.equals(paramBaseArticleInfo.mVideoVid))) {}
    for (long l1 = paramVideoPlayManager.a();; l1 = 0L)
    {
      paramVideoPlayManager = new VideoR5.Builder(null, paramBaseArticleInfo.mSubscribeID, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID).a(l1).c(paramBaseArticleInfo.mVideoDuration * 1000).e(paramBaseArticleInfo.mAlgorithmID).c(paramBaseArticleInfo.mStrategyId).a(paramInt).g(paramBoolean1).h(paramBoolean2).a().a();
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str = paramBaseArticleInfo.mSubscribeID;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))
      {
        paramVideoRecommendManager = paramBaseArticleInfo.innerUniqueID;
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramVideoRecommendManager, paramVideoPlayManager, false);
        long l2 = paramActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
        paramActivity = new ReportInfo.VideoExtraRepoerData();
        paramActivity.jdField_d_of_type_Int = ((int)l1);
        paramActivity.jdField_e_of_type_Int = (paramBaseArticleInfo.mVideoDuration * 1000);
        if (l2 != 0L) {
          break label342;
        }
      }
      label342:
      for (int i = 1;; i = 2)
      {
        paramActivity.jdField_c_of_type_Int = i;
        VideoReporter.a(paramBaseArticleInfo, paramInt, 25, -1L, paramActivity);
        return;
        paramVideoRecommendManager = "0";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager
 * JD-Core Version:    0.7.0.1
 */