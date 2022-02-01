package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStartStatistic;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RIJFullVideoPlayActivity
{
  private static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (1 == paramBaseArticleInfo.mVideoType) {}
    while (0L == paramBaseArticleInfo.mChannelID) {
      return 1;
    }
    return 9091;
  }
  
  public static Bundle a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, VideoPlayManager paramVideoPlayManager, RIJDataManager paramRIJDataManager)
  {
    boolean bool2 = true;
    Bundle localBundle = new Bundle();
    label110:
    int i;
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1)
    {
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramVideoPlayParam.jdField_f_of_type_Int != 6) {
        break label1321;
      }
      localBundle.putString("VIDEO_H5_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle.putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1350;
      }
      localBundle.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      label145:
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1392;
      }
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      label166:
      localBundle.putString("VIDEO_VID", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle.putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle.putString("VIDEO_SECOND_INDEX_INNER_ID", paramVideoPlayParam.n);
      if ((paramRIJDataManager.a().a() == null) || (paramRIJDataManager.a().a().a() == null) || (paramVideoPlayManager == null) || (paramRIJDataManager.a().a().a().jdField_c_of_type_Long != paramVideoPlayParam.jdField_c_of_type_Long)) {
        break label1434;
      }
      localBundle.putLong("VIDEO_PLAY_POSITION", paramVideoPlayManager.a());
      label295:
      if (paramVideoPlayParam.jdField_f_of_type_Int != 6) {
        break label1445;
      }
      localBundle.putString("VIDEO_ARTICLE_ID", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.longValue());
      localBundle.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.intValue());
      localBundle.putString("VIDEO_TITLE", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      label398:
      localBundle.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", ReadInJoyHelper.a(paramRIJDataManager.a().a()));
      if (paramVideoPlayParam.jdField_f_of_type_Int != 1) {
        break label1470;
      }
      bool1 = true;
      label426:
      localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
      localBundle.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle.putBoolean("isFromKandian", true);
      localBundle.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label1476;
      }
      i = 0;
      label512:
      localBundle.putInt("interactionType", i);
      localBundle.putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
      localBundle.putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramVideoPlayParam.jdField_f_of_type_Long);
      localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_f_of_type_Int);
      paramRIJDataManager = new Bundle();
      paramRIJDataManager.putString("VINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      paramRIJDataManager.putString("TINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      paramRIJDataManager.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
      if (paramVideoPlayManager != null) {
        break label1482;
      }
      i = 0;
      label637:
      paramRIJDataManager.putInt("PREVIEW_START_POSI", VideoPlayUtils.a(i, paramVideoPlayParam.jdField_b_of_type_Int));
      paramRIJDataManager.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_c_of_type_Int);
      paramRIJDataManager.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_d_of_type_Int);
      paramRIJDataManager.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
      paramRIJDataManager.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramVideoPlayParam.jdField_f_of_type_Int != 1) {
        break label1492;
      }
      paramRIJDataManager.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      paramRIJDataManager.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      label727:
      if ((paramVideoPlayParam.jdField_f_of_type_Int != 6) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1517;
      }
      paramRIJDataManager.putString("compatible_text", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString + ": " + ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      paramRIJDataManager.putInt("req_type", 125);
      label860:
      paramRIJDataManager.putInt("TYPE", paramVideoPlayParam.jdField_f_of_type_Int);
      paramRIJDataManager.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      paramRIJDataManager.putInt("layout_item", 5);
      paramRIJDataManager.putBoolean("video_url_load", false);
      paramRIJDataManager.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      if (paramBaseArticleInfo.aioShareUrl == null) {
        break label1530;
      }
      paramRIJDataManager.putString("detail_url", paramBaseArticleInfo.aioShareUrl);
      label927:
      paramRIJDataManager.putString("video_url", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      paramRIJDataManager.putString("title", paramBaseArticleInfo.mTitle);
      paramRIJDataManager.putString("req_create_time", ReadInJoyTimeUtils.b(paramBaseArticleInfo.mTime));
      paramRIJDataManager.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(paramRIJDataManager)).getBytes());
      localBundle.putString("VIDEO_SUBS_TEXT", paramBaseArticleInfo.mVideoArticleSubsText);
      localBundle.putString("VIDEO_SUBS_COLOR", paramBaseArticleInfo.mVideoArticleSubsColor);
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      localBundle.putInt("VIDEO_PLAY_COUNT", paramBaseArticleInfo.mVideoPlayCount);
      localBundle.putString("VIDEO_ACCOUNT_AVATAR_URL", paramBaseArticleInfo.preloadAvatarUrl);
      localBundle.putBoolean("VIDEO_ACCOUNT_IS_FOLLOWED", VideoFeedsHelper.a(paramBaseArticleInfo.getSubscribeUin()));
      if (paramBaseArticleInfo.mSocialFeedInfo != null) {
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int != 1) {
          break label1563;
        }
      }
    }
    label1434:
    label1563:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBundle.putBoolean("VIDEO_IS_DIANZAN", bool1);
      localBundle.putInt("VIDEO_DIAN_ZAN_COUNT", paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
      localBundle.putInt("VIDEO_COMMENT_COUNT", paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int);
      localBundle.putInt("VIDEO_BIU_COUNT", paramBaseArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
      return localBundle;
      if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
      {
        if (RIJItemViewType.g(paramBaseArticleInfo)) {
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaLangString);
          if (RIJItemViewType.q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle.putString("VIDEO_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1321:
      localBundle.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(paramBaseArticleInfo.mTime, true));
      break label110;
      label1350:
      if (paramVideoPlayParam.jdField_f_of_type_Int != 6) {
        break label145;
      }
      localBundle.putString("VIDEO_WIDTH", String.valueOf(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label145;
      label1392:
      if (paramVideoPlayParam.jdField_f_of_type_Int != 6) {
        break label166;
      }
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
      break label166;
      localBundle.putLong("VIDEO_PLAY_POSITION", 0L);
      break label295;
      label1445:
      localBundle.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label398;
      label1470:
      bool1 = false;
      break label426;
      label1476:
      i = 1;
      break label512;
      label1482:
      i = (int)paramVideoPlayManager.a();
      break label637;
      label1492:
      paramRIJDataManager.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      paramRIJDataManager.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break label727;
      label1517:
      paramRIJDataManager.putInt("req_type", 140);
      break label860;
      label1530:
      paramRIJDataManager.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      break label927;
    }
  }
  
  private static void a(Bundle paramBundle)
  {
    paramBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 6);
    paramBundle.putInt("VIDEO_FROM_TYPE", 9);
    paramBundle.putInt("key_source", 0);
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 8);
  }
  
  private static void a(Bundle paramBundle, RIJDataManager paramRIJDataManager)
  {
    if (paramRIJDataManager.a().a() == 3) {
      paramBundle.putInt("VIDEO_FROM_TYPE", 6);
    }
    for (;;)
    {
      paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 5);
      return;
      paramBundle.putInt("VIDEO_FROM_TYPE", 7);
    }
  }
  
  private static void a(Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo)
  {
    if (RIJFeedsType.g(paramBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 14);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
      return;
    }
    paramBundle.putInt("VIDEO_FROM_TYPE", 8);
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
  }
  
  private static void a(Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (paramRIJDataManager.a().b() == 0)
    {
      b(paramBundle, paramBaseArticleInfo);
      return;
    }
    if (paramRIJDataManager.a().b() == 56)
    {
      a(paramRIJDataManager, paramBundle, paramBaseArticleInfo);
      return;
    }
    if (paramRIJDataManager.a().b() == 70)
    {
      a(paramBundle, paramBaseArticleInfo);
      return;
    }
    if (paramRIJDataManager.a().b() == 40677)
    {
      a(paramBundle);
      return;
    }
    if (DailyModeConfigHandler.c(paramRIJDataManager.a().b()))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 24);
      return;
    }
    a(paramBundle, paramRIJDataManager);
  }
  
  private static void a(RIJDataManager paramRIJDataManager)
  {
    if ((paramRIJDataManager != null) && (paramRIJDataManager.a().a() != null))
    {
      paramRIJDataManager.a().a().d();
      paramRIJDataManager.a().b(true);
    }
  }
  
  private static void a(RIJDataManager paramRIJDataManager, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    try
    {
      bool = MultiVideoConfigHandler.a(paramBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(paramBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(paramBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(paramBundle.getString("VIDEO_TIME")).intValue());
      if (bool)
      {
        MultiVideoHelper.a((Activity)paramRIJDataManager.a().a(), paramIntent, paramInt);
        ((Activity)paramRIJDataManager.a().a()).overridePendingTransition(2130772014, 0);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, new Object[] { "openFullVideoPlayActivity MultiVideoConfigHandler.isEnterMultiMode is error:", paramBundle.getMessage() });
        }
        boolean bool = false;
      }
      ((Activity)paramRIJDataManager.a().a()).startActivityForResult(paramIntent, paramInt);
      ((Activity)paramRIJDataManager.a().a()).overridePendingTransition(2130772086, 2130772087);
    }
  }
  
  private static void a(RIJDataManager paramRIJDataManager, Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo)
  {
    if (RIJFeedsType.i(paramBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 5);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
    }
    for (;;)
    {
      paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
      return;
      if (RIJFeedsType.g(paramBaseArticleInfo))
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 5);
        paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
      }
      else if (paramRIJDataManager.a().a() == 1004L)
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 25);
      }
      else
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 2);
      }
    }
  }
  
  public static void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, RIJDataManager paramRIJDataManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramVideoPlayParam.jdField_d_of_type_Long + ",vid : " + paramVideoPlayParam.jdField_c_of_type_JavaLangString + ", showComment : " + paramBoolean);
    }
    if (paramRIJDataManager.a().a() != null) {
      paramRIJDataManager.a().a().b();
    }
    paramRIJDataManager.a().a(true);
    Bundle localBundle;
    if (RIJFeedsType.g(paramBaseArticleInfo))
    {
      localBundle = b(paramVideoPlayParam, paramBaseArticleInfo, paramRIJDataManager.a().a(), paramRIJDataManager);
      if (paramRIJDataManager.a().a() != null) {
        if (paramRIJDataManager.a().a().b() != paramBaseArticleInfo.mArticleID) {
          break label668;
        }
      }
    }
    label668:
    for (int i = paramRIJDataManager.a().a().a();; i = 1)
    {
      localBundle.putInt("VIDEO_PLAY_STATUS", i);
      if (paramVideoPlayParam.jdField_f_of_type_Int == 2)
      {
        localObject = ThirdVideoManager.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        if (localObject != null)
        {
          localBundle.putString("VIDEO_THIRD_VID_URL", ((VideoUrlInfo)localObject).jdField_a_of_type_JavaLangString);
          localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((VideoUrlInfo)localObject).jdField_b_of_type_Long);
        }
      }
      localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
      localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      a(localBundle, paramBaseArticleInfo, paramRIJDataManager);
      localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", paramRIJDataManager.a().b());
      localBundle.putParcelable("VIDEO_COLUMN_INFO", paramBaseArticleInfo.mVideoColumnInfo);
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      Object localObject = new Intent(paramRIJDataManager.a().a(), VideoFeedsPlayActivity.class);
      ((Intent)localObject).addFlags(536870912);
      if (BaseApplicationImpl.sProcessId != 1)
      {
        localBundle.putBoolean("param_needSmooth", VideoVolumeControl.a().d());
        VideoVolumeControl.a().d(true);
        localBundle.putBoolean("param_needAlertInXg", VideoAutoPlayController.d());
      }
      ((Intent)localObject).putExtras(localBundle);
      if ((paramVideoPlayParam.jdField_f_of_type_Int == 6) && (!RIJFeedsType.g(paramBaseArticleInfo))) {
        ((Intent)localObject).putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
      }
      i = a(paramBaseArticleInfo);
      ((Intent)localObject).putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramVideoPlayParam.l);
      ((Intent)localObject).putExtra("VIDEO_CHANNEL_SESSION_ID", paramVideoPlayParam.m);
      ((Intent)localObject).putExtra("item_x", paramVideoPlayParam.h);
      ((Intent)localObject).putExtra("item_y", paramVideoPlayParam.i);
      ((Intent)localObject).putExtra("item_width", paramVideoPlayParam.j);
      ((Intent)localObject).putExtra("item_height", paramVideoPlayParam.k);
      VideoFeedsHelper.a(paramBaseArticleInfo, (Intent)localObject);
      ((Intent)localObject).putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", RIJFeedsType.a(paramBaseArticleInfo));
      ((Intent)localObject).putExtra("VIDEO_SHOW_COMMENT", paramBoolean);
      ((Intent)localObject).putExtra("video_player_session_id", paramRIJDataManager.a().a().a());
      a(paramRIJDataManager, (Intent)localObject, localBundle, i);
      if ((localBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) && (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {
        RIJFeedsDynamicInsertController.a.a(paramBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ENTER, 0, 0, 0), 6);
      }
      VideoFeedsStartStatistic.a();
      a(paramRIJDataManager);
      if (ReadInJoyHelper.n()) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", VideoReporter.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, paramRIJDataManager.a().b(), null), false);
      }
      return;
      localBundle = a(paramVideoPlayParam, paramBaseArticleInfo, paramRIJDataManager.a().a(), paramRIJDataManager);
      break;
    }
  }
  
  private static Bundle b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, VideoPlayManager paramVideoPlayManager, RIJDataManager paramRIJDataManager)
  {
    Object localObject1 = null;
    Object localObject2;
    if (RIJFeedsType.n(paramBaseArticleInfo))
    {
      Iterator localIterator = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (NewPolymericInfo.PackArticleInfo)localIterator.next();
        if ((((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo == null) || (!TextUtils.equals(paramVideoPlayParam.jdField_c_of_type_JavaLangString, ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString))) {
          break label934;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (NewPolymericInfo.PackArticleInfo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      }
      localObject1 = new Bundle();
      label377:
      boolean bool;
      if (((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_Boolean)
      {
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_c_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_b_of_type_Int);
        if (((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackVideoInfo != null) {}
        ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramVideoPlayParam.jdField_c_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramVideoPlayParam.jdField_d_of_type_Int));
        ((Bundle)localObject1).putString("VIDEO_VID", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
        ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramVideoPlayParam.jdField_g_of_type_Int);
        ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramVideoPlayParam.jdField_g_of_type_Long);
        ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramVideoPlayParam.n);
        if ((paramRIJDataManager.a().a() == null) || (paramRIJDataManager.a().a().a() == null) || (paramVideoPlayManager == null) || (paramRIJDataManager.a().a().a().jdField_c_of_type_Long != paramVideoPlayParam.jdField_c_of_type_Long)) {
          break label907;
        }
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", paramVideoPlayManager.a());
        ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_TITLE", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", ReadInJoyHelper.a(paramRIJDataManager.a().a()));
        if (paramVideoPlayParam.jdField_f_of_type_Int != 1) {
          break label918;
        }
        bool = true;
        label429:
        ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
        ((Bundle)localObject1).putBoolean("isFromKandian", true);
        ((Bundle)localObject1).putLong("channelID", paramBaseArticleInfo.mChannelID);
        ((Bundle)localObject1).putLong("algorithmID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_b_of_type_Long);
        ((Bundle)localObject1).putString("innderId", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("strategyId", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_g_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramVideoPlayParam.jdField_f_of_type_Long);
        ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_f_of_type_Int);
        paramRIJDataManager = new Bundle();
        paramRIJDataManager.putString("VINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        paramRIJDataManager.putString("TINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        paramRIJDataManager.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
        if (paramVideoPlayManager != null) {
          break label924;
        }
      }
      label907:
      label918:
      label924:
      for (int i = 0;; i = (int)paramVideoPlayManager.a())
      {
        paramRIJDataManager.putInt("PREVIEW_START_POSI", VideoPlayUtils.a(i, paramVideoPlayParam.jdField_b_of_type_Int));
        paramRIJDataManager.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_c_of_type_Int);
        paramRIJDataManager.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_d_of_type_Int);
        paramRIJDataManager.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
        paramRIJDataManager.putString("source_puin", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_e_of_type_JavaLangString);
        paramRIJDataManager.putString("ACCOUNT_UIN", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_e_of_type_JavaLangString);
        paramRIJDataManager.putString("ACCOUNT_NAME", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_f_of_type_JavaLangString);
        paramRIJDataManager.putInt("TYPE", paramVideoPlayParam.jdField_f_of_type_Int);
        paramRIJDataManager.putString("ARTICLE_ID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_g_of_type_JavaLangString);
        paramRIJDataManager.putInt("layout_item", 5);
        paramRIJDataManager.putBoolean("video_url_load", false);
        paramRIJDataManager.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
        paramRIJDataManager.putString("detail_url", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_d_of_type_JavaLangString + "&sourcefrom=0");
        paramRIJDataManager.putString("video_url", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        paramRIJDataManager.putString("title", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_JavaLangString);
        paramRIJDataManager.putString("req_create_time", ReadInJoyTimeUtils.b(paramBaseArticleInfo.mTime));
        paramRIJDataManager.putString("brief_key", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_JavaLangString);
        paramRIJDataManager.putInt("req_type", 140);
        ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(paramRIJDataManager)).getBytes());
        ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
        return localObject1;
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_f_of_type_JavaLangString);
        ((Bundle)localObject1).putString("VIDEO_H5_URL", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_d_of_type_JavaLangString);
        break;
        ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", 0L);
        break label377;
        bool = false;
        break label429;
      }
      label934:
      break;
      localObject1 = null;
    }
  }
  
  private static void b(Bundle paramBundle, BaseArticleInfo paramBaseArticleInfo)
  {
    if (RIJFeedsType.i(paramBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 4);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
    }
    for (;;)
    {
      paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      return;
      if (RIJFeedsType.g(paramBaseArticleInfo))
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 13);
        paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
      }
      else
      {
        paramBundle.putInt("VIDEO_FROM_TYPE", 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJFullVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */