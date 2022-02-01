package com.tencent.biz.pubaccount.readinjoy.protocol;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ShortWithLongContentUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ArkAppFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ExtraBiuBriefInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FamilyCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianLiveInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.struct.ScripCmsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.Wormhole;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AccountVInfo;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.CardExInfo;
import tencent.im.oidb.articlesummary.articlesummary.CardJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.DiandianLabel;
import tencent.im.oidb.articlesummary.articlesummary.DiandianWording;
import tencent.im.oidb.articlesummary.articlesummary.DisLikeInfo;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.FusionInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.NewPackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeChatVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RichTips;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJMsfHandlerHelper
{
  private static void a(ArticleInfo paramArticleInfo)
  {
    PBRepeatMessageField localPBRepeatMessageField = PBField.initRepeatMessage(articlesummary.SRTUniversalID.class);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(localPBRepeatMessageField.computeSize(1));
    CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
    localPBRepeatMessageField.addAll(paramArticleInfo.srtUniversalID);
    try
    {
      localPBRepeatMessageField.writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      paramArticleInfo.srtUniversalIDBytesList = localByteArrayOutputStream.toByteArray();
      return;
    }
    catch (IOException paramArticleInfo)
    {
      QLog.d("ReadInJoyMSFHandlerUtils", 1, "convertPBToBytes failed $e");
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null)
    {
      paramArticleInfo.mFeedType = 0;
      return;
    }
    paramArticleInfo.mFeedType = RIJPBFieldUtils.a(paramFeedsInfo.feeds_type);
    if ((paramFeedsInfo.uint32_business_id.has()) && ((paramArticleInfo.mPolymericInfo == null) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9))) {
      paramArticleInfo.businessId = RIJPBFieldUtils.a(paramFeedsInfo.uint32_business_id);
    }
    paramArticleInfo.mFeedCookie = RIJPBFieldUtils.a(paramFeedsInfo.bytes_feeds_cookie, "");
    paramArticleInfo.businessName = RIJPBFieldUtils.a(paramFeedsInfo.bytes_business_name, "");
    paramArticleInfo.businessUrl = RIJPBFieldUtils.a(paramFeedsInfo.bytes_business_url, "");
    paramArticleInfo.businessNamePrefix = RIJPBFieldUtils.a(paramFeedsInfo.bytes_business_name_prefix, "");
    b(paramArticleInfo, paramFeedsInfo);
    c(paramArticleInfo, paramFeedsInfo);
    d(paramArticleInfo, paramFeedsInfo);
  }
  
  private void b(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.SocializeFeedsInfo)RIJPBFieldUtils.a(paramFeedsInfo.msg_social_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramArticleInfo.mSocialFeedInfo = SocializeFeedsInfo.a(paramFeedsInfo);
      paramArticleInfo.mSocialFeedInfoByte = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseSocializeFeedsInfo summary.msg_social_feeds_info is null");
  }
  
  private void c(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.TopicRecommendFeedsInfo)RIJPBFieldUtils.a(paramFeedsInfo.msg_topic_recommend_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramArticleInfo.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a(paramFeedsInfo);
      paramArticleInfo.mTopicRecommendFeedsInfoByte = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_Long;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseTopicRecommendFeedsInfo summary.msg_topic_recommend_feeds_info is null");
  }
  
  private void d(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.ArkAppFeedsInfo)RIJPBFieldUtils.a(paramFeedsInfo.msg_ark_app_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramArticleInfo.mArkAppFeedsInfo = ArkAppFeedsInfo.a(paramFeedsInfo);
      paramArticleInfo.mArkAppFeedsInfoBytes = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mArkAppFeedsInfo.jdField_a_of_type_Long;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseArkAppFeedsInfo summary.msg_ark_app_feeds_info is null");
  }
  
  private void m(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.FeedsInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_feeds_info);
    if (paramArticleSummary != null) {
      a(paramArticleInfo, paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseFeedsInfo summary.msg_feeds_info is null");
  }
  
  private void n(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.RecommendFollowInfos)RIJPBFieldUtils.a(paramArticleSummary.recommend_info);
    if (paramArticleSummary != null) {
      paramArticleInfo.mRecommendFollowInfos = RecommendFollowInfos.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseRecommendFollowInfo summary.recommend_info is null");
  }
  
  private void o(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.HotWordInfo)RIJPBFieldUtils.a(paramArticleSummary.hot_word_info);
    if (paramArticleSummary != null) {
      paramArticleInfo.hotWordInfo = HotWordInfo.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseHotWordInfo summary.hot_word_info is null");
  }
  
  private void p(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    boolean bool = false;
    paramArticleSummary = (articlesummary.PartnerAccountInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_partner_account_info);
    if (paramArticleSummary != null)
    {
      paramArticleSummary.uint32_is_wechat_video.set(0);
      paramArticleSummary.uint32_watch_see_later.set(0);
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_account_display) != 0) {
        bool = true;
      }
      paramArticleInfo.isAccountShown = bool;
      paramArticleInfo.mPartnerAccountInfo = paramArticleSummary;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseProteusItemsData summary.msg_partner_account_info is null");
  }
  
  private void q(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary.msg_srt_universal_id.has()) {
      paramArticleInfo.srtUniversalID = paramArticleSummary.msg_srt_universal_id.get();
    }
    if ((paramArticleInfo.srtUniversalID != null) && (!paramArticleInfo.srtUniversalID.isEmpty())) {
      a(paramArticleInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseUniversalID summary.msg_srt_universal_id is null");
  }
  
  private void r(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.AccountVInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_account_v_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.vIconUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_v_icon_url);
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_unowned) == 1)
      {
        bool = true;
        paramArticleInfo.unowned = bool;
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseUniversalID summary.msg_account_v_info is null");
  }
  
  private void s(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(paramArticleSummary.video_multi_column_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.multiVideoColumnInfoBytes = paramArticleSummary.toByteArray();
      paramArticleInfo.multiVideoColumnInfo = MultiVideoColumnInfo.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseMultiVideoColumnInfo summary.video_multi_column_info is null");
  }
  
  private void t(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.KdLiveInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_kd_live_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mKdLiveInfoBytes = paramArticleSummary.toByteArray();
      paramArticleInfo.mKdLiveInfo = KandianLiveInfo.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseKdLiveInfo summary.msg_kd_live_info is null");
  }
  
  private void u(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.WeishiUGInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_ug_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.weishiUGInfo = paramArticleSummary;
      paramArticleInfo.mWeishiUGInfo = paramArticleSummary.toByteArray();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseWeiShiUGInfo summary.msg_ug_info is null");
  }
  
  private void v(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.NewPackInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_new_pack_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mNewPolymericInfo = NewPolymericInfo.a(paramArticleSummary);
      if ((paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        paramArticleInfo.businessId = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseNewPackInfo summary.msg_new_pack_info is null");
  }
  
  private static void w(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleInfo.titleWithTopicJson = RIJPBFieldUtils.a(paramArticleSummary.bytes_title_with_topic);
    if (TextUtils.isEmpty(paramArticleInfo.titleWithTopicJson)) {}
    for (;;)
    {
      return;
      paramArticleInfo.richTitleInfoList = new ArrayList();
      try
      {
        paramArticleSummary = new JSONObject(paramArticleInfo.titleWithTopicJson).getJSONArray("rpt_biu_mutli_level");
        int i = paramArticleSummary.length() - 1;
        while (i >= 0)
        {
          VideoInfo.RichTitleInfo localRichTitleInfo = new VideoInfo.RichTitleInfo((JSONObject)paramArticleSummary.get(i));
          paramArticleInfo.richTitleInfoList.add(localRichTitleInfo);
          i -= 1;
        }
        return;
      }
      catch (Exception paramArticleSummary)
      {
        QLog.d("ReadInJoyMSFHandlerUtils", 1, "parseRichTitleInfo failed $e");
      }
    }
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    paramArticleInfo.mArticleID = RIJPBFieldUtils.a(paramArticleSummary.uint64_article_id);
    paramArticleInfo.mTitle = RIJPBFieldUtils.a(paramArticleSummary.bytes_article_title, "");
    paramArticleInfo.mSummary = RIJPBFieldUtils.a(paramArticleSummary.bytes_article_summary, "");
    paramArticleInfo.mFirstPagePicUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_first_page_pic_url, "");
    paramArticleInfo.mOriginalUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_original_url, "");
    paramArticleInfo.mArticleContentUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_article_content_url, "");
    paramArticleInfo.mTime = RIJPBFieldUtils.a(paramArticleSummary.uint64_time);
    paramArticleInfo.mCommentCount = RIJPBFieldUtils.a(paramArticleSummary.uint32_comment_count);
    paramArticleInfo.mSubscribeID = RIJPBFieldUtils.a(paramArticleSummary.bytes_subscribe_id, "");
    paramArticleInfo.mSubscribeName = RIJPBFieldUtils.a(paramArticleSummary.bytes_subscribe_name, "");
    paramArticleInfo.mRecommendTime = RIJPBFieldUtils.a(paramArticleSummary.uint64_recommend_time);
    paramArticleInfo.mRecommendSeq = RIJPBFieldUtils.a(paramArticleSummary.uint64_recommend_seq);
    if (RIJPBFieldUtils.a(paramArticleSummary.uint32_show_big_picture) == 1)
    {
      bool1 = true;
      paramArticleInfo.mShowBigPicture = bool1;
      paramArticleInfo.mAlgorithmID = RIJPBFieldUtils.a(paramArticleSummary.uint64_algorithm_id);
      paramArticleInfo.mJsonVideoList = RIJPBFieldUtils.a(paramArticleSummary.json_video_list);
      paramArticleInfo.mJsonPictureList = RIJPBFieldUtils.a(paramArticleSummary.json_picture_list);
      paramArticleInfo.mAbandonRepeatFlag = RIJPBFieldUtils.a(paramArticleSummary.uint32_abandon_repeat_flag);
      paramArticleInfo.mArticleSubscriptText = RIJPBFieldUtils.a(paramArticleSummary.bytes_test);
      paramArticleInfo.mArticleSubscriptColor = RIJPBFieldUtils.a(paramArticleSummary.bytes_colour);
      paramArticleInfo.mStrategyId = RIJPBFieldUtils.a(paramArticleSummary.uint32_strategy_id);
      paramArticleInfo.mMergeVideoId = RIJPBFieldUtils.a(paramArticleSummary.uint64_merged_video_id);
      paramArticleInfo.aioShareUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_aio_share_url);
      paramArticleInfo.qzoneShareUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_qzone_share_url);
      b(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mArticleFriendLikeText = RIJPBFieldUtils.a(paramArticleSummary.bytes_friend_like_wording);
      paramArticleInfo.mVideoType = RIJPBFieldUtils.a(paramArticleSummary.uint32_video_show_small_picture);
      paramArticleInfo.mCommentIconType = RIJPBFieldUtils.a(paramArticleSummary.uint32_comment_icon_type);
      paramArticleInfo.mServerContext = RIJPBFieldUtils.a(paramArticleSummary.bytes_server_context);
      c(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mIsDispTimestamp = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_disp_timestamp);
      d(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mIsGallery = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_gallery);
      if (paramArticleInfo.mIsGallery != 0) {
        paramArticleInfo.mGalleryPicNumber = RIJPBFieldUtils.a(paramArticleSummary.uint32_picture_number);
      }
      paramArticleInfo.innerUniqueID = RIJPBFieldUtils.a(paramArticleSummary.bytes_inner_uniq_id);
      f(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mCommentsObj = RIJPBFieldUtils.a(paramArticleSummary.rpt_comments);
      g(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mStrCircleId = RIJPBFieldUtils.a(paramArticleSummary.bytes_circle_id, "");
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_active) != 1) {
        break label1244;
      }
      bool1 = true;
      label482:
      paramArticleInfo.mPUinIsActive = bool1;
      paramArticleInfo.mSubscribeInfoObj = ((articlesummary.SubscribeInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_subscribe_info));
      m(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mVideoPlayCount = RIJPBFieldUtils.a(paramArticleSummary.uint32_video_play_count);
      if (paramArticleSummary.rpt_label_list.has()) {
        paramArticleInfo.mLabelListObj = paramArticleSummary.rpt_label_list.get();
      }
      paramArticleInfo.mAccountLess = RIJPBFieldUtils.a(paramArticleSummary.is_accountless);
      paramArticleInfo.interfaceData = RIJPBFieldUtils.a(paramArticleSummary.bytes_interface_data);
      paramArticleInfo.galleryReprotExdData = RIJPBFieldUtils.a(paramArticleSummary.bytes_gallery_report_extdata);
      paramArticleInfo.articleStyle = RIJPBFieldUtils.a(paramArticleSummary.enum_article_style);
      b(paramArticleSummary, paramInt1, paramInt2, paramArticleInfo);
      e(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mVideoCommentCount = RIJPBFieldUtils.a(paramArticleSummary.uint32_video_comment_count);
      paramArticleInfo.mVideoArticleSubsText = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_subscript_txt);
      paramArticleInfo.mVideoArticleSubsColor = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_subscript_color);
      paramArticleInfo.mVideoAdsJumpUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_ads_jump_url);
      paramArticleInfo.mVideoAdsJumpType = RIJPBFieldUtils.a(paramArticleSummary.uint32_ads_jump_type);
      paramArticleInfo.mVideoAdsSource = RIJPBFieldUtils.a(paramArticleSummary.uint32_ads_source);
      paramArticleInfo.videoReportInfo = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_report_info);
      h(paramArticleSummary, paramArticleInfo);
      v(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mVideoDownloadBarInfo = ((articlesummary.VideoDownloadBarInfo)RIJPBFieldUtils.a(paramArticleSummary.video_download_bar_info));
      n(paramArticleSummary, paramArticleInfo);
      o(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.gifCoverUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_first_page_gif_url);
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_first_page_use_gif) != 1) {
        break label1250;
      }
      bool1 = true;
      label762:
      paramArticleInfo.isUseGif = bool1;
      i(paramArticleSummary, paramArticleInfo);
      j(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mGWCommonData = RIJPBFieldUtils.a(paramArticleSummary.bytes_gw_common_data);
      paramArticleInfo.mReportCommonData = RIJPBFieldUtils.a(paramArticleSummary.bytes_report_common_data);
      paramArticleInfo.mArticleType = RIJPBFieldUtils.a(paramArticleSummary.uint32_article_type);
      paramArticleInfo.isCloseDislike = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_close_dislike);
      paramArticleInfo.isSuperTop = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_super_top_article);
      paramArticleInfo.mVideoLogoUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_logo_url);
      p(paramArticleSummary, paramArticleInfo);
      k(paramArticleSummary, paramArticleInfo);
      articlesummary.VideoColumnInfo localVideoColumnInfo1 = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(paramArticleSummary.video_column_info);
      articlesummary.VideoColumnInfo localVideoColumnInfo2 = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(paramArticleSummary.video_simple_column_info);
      paramArticleInfo.mVideoColumnInfo = VideoColumnInfo.a(localVideoColumnInfo1);
      paramArticleInfo.mSimpleVideoColumnInfo = VideoColumnInfo.a(localVideoColumnInfo2);
      paramArticleInfo.commentJumpUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_comment_button_jump_url);
      paramArticleInfo.mIsShowSearchord = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_show_search_word);
      paramArticleInfo.adReportCommonData = RIJPBFieldUtils.a(paramArticleSummary.bytes_ad_report_common_data);
      q(paramArticleSummary, paramArticleInfo);
      r(paramArticleSummary, paramArticleInfo);
      s(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.columnStyle = RIJPBFieldUtils.a(paramArticleSummary.uint32_column_style);
      paramArticleInfo.isShowFollowButton = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_show_follow_button);
      a(paramArticleSummary, paramInt2, paramArticleInfo);
      t(paramArticleSummary, paramArticleInfo);
      u(paramArticleSummary, paramArticleInfo);
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_expose_repeat_flag) != 1) {
        break label1256;
      }
      bool1 = true;
      label1030:
      paramArticleInfo.isNeeaRealExposureFilter = bool1;
      ShortWithLongContentUtil.a(paramArticleInfo);
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_red_package_flag) != 1) {
        break label1262;
      }
      bool1 = true;
      label1056:
      paramArticleInfo.hasWalletIcon = bool1;
      paramArticleInfo.smallGameData = RIJPBFieldUtils.a(paramArticleSummary.bytes_small_game_rsp_pack);
      paramArticleInfo.mSmallMiniGameInfo = SmallMiniGameInfo.a(paramArticleInfo.smallGameData);
      paramArticleInfo.columnEntrances = VideoColumnInfo.a(paramArticleSummary.card_column_entrances);
      if (paramArticleInfo.isWormhole()) {
        Wormhole.a(paramArticleInfo);
      }
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_forbid_reprint_flag) != 1) {
        break label1268;
      }
    }
    label1244:
    label1250:
    label1256:
    label1262:
    label1268:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramArticleInfo.isForbidReprint = bool1;
      paramArticleInfo.wechatShareUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_wechat_share_url);
      paramArticleInfo.dtReportContentType = RIJPBFieldUtils.a(paramArticleSummary.uint32_backend_content_type);
      if ((paramArticleSummary.msg_card_ex_info.has()) && (paramArticleSummary.msg_card_ex_info.bytes_owner_datacard_info.has())) {
        paramArticleSummary.bytes_interface_data.set(paramArticleSummary.msg_card_ex_info.bytes_owner_datacard_info.get());
      }
      if (paramArticleSummary.msg_card_ex_info.has()) {
        paramArticleInfo.mShareCount = RIJPBFieldUtils.a(paramArticleSummary.msg_card_ex_info.uint32_share_count);
      }
      a(paramArticleSummary, paramArticleInfo);
      w(paramArticleSummary, paramArticleInfo);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label482;
      bool1 = false;
      break label762;
      bool1 = false;
      break label1030;
      bool1 = false;
      break label1056;
    }
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, int paramInt, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.ScripCmsInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_scrip_cms_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.scripCmsInfo = ScripCmsInfo.a(paramArticleSummary);
      paramArticleInfo.scripCmsInfoByte = paramArticleSummary.toByteArray();
      if (paramInt != 7) {
        break label46;
      }
      paramArticleInfo.scripCmsInfo.jdField_b_of_type_Int = 1;
    }
    label46:
    while (paramInt != 6) {
      return;
    }
    paramArticleInfo.scripCmsInfo.jdField_b_of_type_Int = 2;
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary.msg_wechat_video_info.has())
    {
      paramArticleInfo.mPartnerAccountInfo = new articlesummary.PartnerAccountInfo();
      paramArticleInfo.mPartnerAccountInfo.uint64_uin.set(paramArticleSummary.msg_wechat_video_info.uint64_uin.get());
      paramArticleInfo.mPartnerAccountInfo.uint32_account_type.set(paramArticleSummary.msg_wechat_video_info.uint32_account_type.get());
      paramArticleInfo.mPartnerAccountInfo.bytes_recommend_reason.set(paramArticleSummary.msg_wechat_video_info.bytes_recommend_reason.get());
      paramArticleInfo.mPartnerAccountInfo.bytes_v_icon_url.set(paramArticleSummary.msg_wechat_video_info.bytes_v_icon_url.get());
      paramArticleInfo.mPartnerAccountInfo.uint32_is_wechat_video.set(1);
      paramArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.set(0);
      paramArticleInfo.mPartnerAccountInfo.uint32_is_account_display.set(1);
      paramArticleInfo.isAccountShown = true;
    }
  }
  
  public void a(oidb_cmd0x69f.ChannelInfo paramChannelInfo, int paramInt, ChannelCoverInfo paramChannelCoverInfo)
  {
    paramChannelCoverInfo.mChannelCoverId = RIJPBFieldUtils.a(paramChannelInfo.uint32_channel_id, -1);
    paramChannelCoverInfo.mChannelCoverName = RIJPBFieldUtils.a(paramChannelInfo.bytes_channel_name, "");
    paramChannelCoverInfo.mChannelCoverStyle = RIJPBFieldUtils.a(paramChannelInfo.enum_channel_cover_style);
    paramChannelCoverInfo.mFollowType = RIJPBFieldUtils.a(paramChannelInfo.uint32_is_followed, -1);
    paramChannelCoverInfo.mColumnType = RIJPBFieldUtils.b(paramChannelInfo.enum_column_type, -1);
    paramChannelCoverInfo.mFontColor = RIJPBFieldUtils.a(paramChannelInfo.uint32_fonts_color, -1291845632);
    paramChannelCoverInfo.mFrameColor = RIJPBFieldUtils.a(paramChannelInfo.uint32_frame_color, -3355444);
    paramChannelCoverInfo.mChannelId = paramInt;
    paramChannelCoverInfo.mArticleId = RIJPBFieldUtils.a(paramChannelInfo.uint64_channel_cover_article_id, -1L);
    paramChannelCoverInfo.mChannelType = RIJPBFieldUtils.a(paramChannelInfo.uint32_channel_type, -1);
    if (RIJPBFieldUtils.a(paramChannelInfo.uint32_is_topic) > 0)
    {
      bool = true;
      paramChannelCoverInfo.mIsTopic = bool;
      if (RIJPBFieldUtils.a(paramChannelInfo.uint32_is_external_expose) != 1) {
        break label526;
      }
      bool = true;
      label152:
      paramChannelCoverInfo.isExternalExposure = bool;
      paramChannelCoverInfo.externalExposureBackgroundUrl = RIJPBFieldUtils.a(paramChannelInfo.bytes_is_external_bg_url, "");
      if (RIJPBFieldUtils.a(paramChannelInfo.uint32_has_recommend) != 1) {
        break label532;
      }
    }
    label526:
    label532:
    for (boolean bool = true;; bool = false)
    {
      paramChannelCoverInfo.isExternalExposurePersist = bool;
      for (;;)
      {
        try
        {
          localObject = RIJPBFieldUtils.a(paramChannelInfo.bytes_channel_cover_wording);
          if (localObject == null)
          {
            localObject = "";
            paramChannelCoverInfo.mChannelCoverSummary = ((String)localObject);
            localObject = RIJPBFieldUtils.a(paramChannelInfo.bytes_channel_cover_spec);
            if (localObject == null)
            {
              localObject = "";
              paramChannelCoverInfo.mChannelCoverSpec = ((String)localObject);
              localObject = new JSONObject(paramChannelCoverInfo.mChannelCoverSpec).getString("filterColor");
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                paramChannelCoverInfo.hasFilterColor = true;
                paramChannelCoverInfo.filterColor = Color.parseColor((String)localObject);
              }
              localObject = RIJPBFieldUtils.a(paramChannelInfo.bytes_channel_jump_url);
              if (localObject != null) {
                break label466;
              }
              localObject = "";
              paramChannelCoverInfo.mChannelJumpUrl = ((String)localObject);
              paramChannelCoverInfo.mColumnType = 1;
              localObject = RIJPBFieldUtils.a(paramChannelInfo.bytes_channel_cover_picurl);
              if (localObject != null) {
                break label480;
              }
              localObject = "";
              paramChannelCoverInfo.mChannelCoverPicUrl = ((String)localObject);
              localObject = (oidb_cmd0x69f.RichTips)RIJPBFieldUtils.a(paramChannelInfo.msg_rich_tips);
              if (localObject != null)
              {
                paramChannelCoverInfo.mTipsType = RIJPBFieldUtils.a(((oidb_cmd0x69f.RichTips)localObject).uint32_tips_type, -1);
                paramChannelCoverInfo.mUpdateTime = RIJPBFieldUtils.a(((oidb_cmd0x69f.RichTips)localObject).uint32_latest_sticky_time);
                localObject = RIJPBFieldUtils.a(((oidb_cmd0x69f.RichTips)localObject).bytes_tips_text);
                if (localObject != null) {
                  break label494;
                }
                localObject = "";
                paramChannelCoverInfo.mTipsText = ((String)localObject);
              }
              paramChannelInfo = RIJPBFieldUtils.a(paramChannelInfo.bytes_icon_url);
              if (paramChannelInfo != null) {
                break label508;
              }
              paramChannelInfo = "";
              paramChannelCoverInfo.mIconUrl = paramChannelInfo;
            }
          }
          else
          {
            localObject = new String((byte[])localObject);
            continue;
          }
          localObject = new String((byte[])localObject);
        }
        catch (Exception paramChannelInfo)
        {
          QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve channel cover info failed $e");
          paramChannelCoverInfo.mColumnType = 0;
          return;
        }
        continue;
        label466:
        Object localObject = new String((byte[])localObject);
        continue;
        label480:
        localObject = new String((byte[])localObject);
        continue;
        label494:
        localObject = new String((byte[])localObject);
        continue;
        label508:
        paramChannelInfo = new String(paramChannelInfo);
      }
      bool = false;
      break;
      bool = false;
      break label152;
    }
  }
  
  public void b(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary.msg_sub_article_summary.has())
    {
      paramArticleInfo.mSubSummaryListObj = paramArticleSummary.msg_sub_article_summary.get();
      if (paramArticleInfo.mSubSummaryListObj.size() > 0)
      {
        paramArticleSummary = new ArrayList(paramArticleInfo.mSubSummaryListObj.size());
        Iterator localIterator = paramArticleInfo.mSubSummaryListObj.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          Object localObject = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)localIterator.next(), paramInt1, paramInt2, null);
          if (localObject == null) {
            break label282;
          }
          paramArticleSummary.add(localObject);
          if (!QLog.isColorLevel()) {
            break label282;
          }
          localObject = new StringBuilder().append("convertArticleInfo(): 解析 sub articleSummary【");
          int j = i + 1;
          QLog.e("ReadInJoyMSFHandlerUtils", 2, i + "】 id : " + paramArticleInfo.mArticleID + " seq : " + paramArticleInfo.mRecommendSeq + " title : " + RIJAppSetting.a(paramArticleInfo.mTitle) + " , groupID : " + paramArticleInfo.mGroupId + " algorithmID : " + paramArticleInfo.mAlgorithmID + " strategyId : " + paramArticleInfo.mStrategyId + " businessID : " + paramArticleInfo.businessId + " businessName :" + paramArticleInfo.businessName);
          i = j;
        }
      }
    }
    label282:
    for (;;)
    {
      break;
      paramArticleInfo.mSubArtilceList = paramArticleSummary;
      return;
    }
  }
  
  public void b(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo.mTopicPicInfo = RIJPBFieldUtils.a(paramArticleSummary.bytes_media_specs);
      if (paramArticleInfo.mTopicPicInfo == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyMSFHandlerUtils", 2, "test to print media specs true, media_specs:" + paramArticleInfo.mTopicPicInfo);
      }
      paramArticleSummary = new JSONObject(paramArticleInfo.mTopicPicInfo);
      int i = paramArticleSummary.optInt("topic_width");
      int j = paramArticleSummary.optInt("topic_height");
      if (j != 0) {
        paramArticleInfo.mTopicPicWHRatio = (i / 1.0D / j);
      }
      paramArticleInfo.videoJumpChannelID = paramArticleSummary.optInt("jump_channel_id");
      paramArticleInfo.videoJumpChannelType = paramArticleSummary.optInt("jump_channel_type");
      paramArticleInfo.videoJumpChannelName = paramArticleSummary.optString("jump_channel_name");
      return;
    }
    catch (Exception paramArticleSummary)
    {
      QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve bytes_media_specs failed ", paramArticleSummary);
      paramArticleInfo.mTopicPicInfo = "";
      paramArticleInfo.mTopicPicWHRatio = 0.0D;
      paramArticleInfo.videoJumpChannelID = -1;
      paramArticleInfo.videoJumpChannelType = -1;
      paramArticleInfo.videoJumpChannelName = "";
    }
  }
  
  public void c(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.ChannelInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_channel_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mChannelInfoId = RIJPBFieldUtils.a(paramArticleSummary.uint32_channel_id);
      paramArticleInfo.mChannelInfoName = RIJPBFieldUtils.a(paramArticleSummary.bytes_channel_name);
      paramArticleInfo.mChannelInfoType = RIJPBFieldUtils.a(paramArticleSummary.uint32_channel_type);
      paramArticleInfo.mChannelInfoDisplayName = RIJPBFieldUtils.a(paramArticleSummary.bytes_channel_display_name);
    }
  }
  
  public void d(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleInfo.bytesBusiData = RIJPBFieldUtils.a(paramArticleSummary.bytes_gallery_busi_data);
    if ((paramArticleInfo.bytesBusiData != null) && (paramArticleInfo.bytesBusiData.length > 0)) {
      paramArticleInfo.mGalleryFeedsInfo = new galleryFeeds.GalleryFeedsInfo();
    }
    try
    {
      paramArticleInfo.mGalleryFeedsInfo.mergeFrom(paramArticleInfo.bytesBusiData);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArticleSummary)
    {
      QLog.e("ReadInJoyMSFHandlerUtils", 2, paramArticleSummary.getMessage());
    }
  }
  
  public void e(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleInfo.mRecommentdReason = RIJPBFieldUtils.a(paramArticleSummary.bytes_recommend_reason);
    if ((TextUtils.isEmpty(paramArticleInfo.mRecommentdReason)) && (!TextUtils.isEmpty(paramArticleInfo.proteusItemsData))) {}
    try
    {
      paramArticleInfo.mRecommentdReason = new JSONObject(paramArticleInfo.proteusItemsData).optString("recommend_reason");
      return;
    }
    catch (JSONException paramArticleSummary)
    {
      QLog.e("ReadInJoyMSFHandlerUtils", 2, paramArticleSummary.getMessage());
    }
  }
  
  public void f(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary.rpt_dislike_list.has())
    {
      paramArticleSummary = paramArticleSummary.rpt_dislike_list.get();
      if ((paramArticleSummary != null) && (paramArticleSummary.size() > 0))
      {
        int j = paramArticleSummary.size();
        paramArticleInfo.mDislikeInfos = new ArrayList();
        int i = 0;
        while (i < j)
        {
          DislikeInfo localDislikeInfo = new DislikeInfo();
          localDislikeInfo.a((articlesummary.DisLikeInfo)paramArticleSummary.get(i));
          paramArticleInfo.mDislikeInfos.add(localDislikeInfo);
          i += 1;
        }
        paramArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramArticleInfo.mDislikeInfos);
      }
    }
  }
  
  public void g(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.PackInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_pack_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mPackInfoObj = paramArticleSummary;
      paramArticleInfo.mGroupId = RIJPBFieldUtils.a(paramArticleSummary.uint64_pack_id);
      paramArticleInfo.mPolymericInfo = PolymericInfo.a(paramArticleInfo.mPackInfoObj);
    }
    if ((paramArticleInfo.mPolymericInfo != null) && (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9)) {
      paramArticleInfo.businessId = paramArticleInfo.mPolymericInfo.f;
    }
  }
  
  public void h(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    articlesummary.DiandianWording localDiandianWording = (articlesummary.DiandianWording)RIJPBFieldUtils.a(paramArticleSummary.diandian_wording);
    if (localDiandianWording != null)
    {
      paramArticleInfo.msgBoxBriefContent = RIJPBFieldUtils.a(localDiandianWording.bytes_msg_wording);
      paramArticleInfo.msgBoxBriefPreFix = RIJPBFieldUtils.a(localDiandianWording.bytes_uin_or_nick);
      paramArticleInfo.msgBoxBriefPreFixType = RIJPBFieldUtils.a(localDiandianWording.uint32_uin_type);
    }
    paramArticleSummary = (articlesummary.DiandianLabel)RIJPBFieldUtils.a(paramArticleSummary.diandian_label);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mDianDianLabelIconUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_icon_url);
      paramArticleInfo.mDianDianLabelText = RIJPBFieldUtils.a(paramArticleSummary.bytes_icon_wording);
    }
  }
  
  public void i(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_aggregated_list.has()))
    {
      paramArticleSummary = (articlesummary.AggregatedList)paramArticleSummary.msg_feeds_info.msg_aggregated_list.get();
      paramArticleInfo.mExtraBiuBriefInfo = ExtraBiuBriefInfo.a(paramArticleSummary);
      if ((paramArticleSummary.uint32_aggregated_content_type.has()) && (paramArticleSummary.uint32_aggregated_content_type.get() == 2) && (paramArticleSummary.rpt_multi_biu_same_content.has()))
      {
        paramArticleInfo.multiBiuSameContentList = MultiBiuSameContent.a(paramArticleSummary.rpt_multi_biu_same_content.get());
        paramArticleInfo.mMultiBiuSameListObj = paramArticleSummary.rpt_multi_biu_same_content.get();
      }
    }
  }
  
  public void j(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.FamilyCommentInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_family_comment_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.familyCommentInfoByte = paramArticleSummary.toByteArray();
      FamilyCommentInfo localFamilyCommentInfo = new FamilyCommentInfo();
      localFamilyCommentInfo.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramArticleSummary.icon_url);
      localFamilyCommentInfo.jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(paramArticleSummary.jump_url);
      localFamilyCommentInfo.jdField_a_of_type_Int = RIJPBFieldUtils.a(paramArticleSummary.medal_urls_width);
      localFamilyCommentInfo.jdField_b_of_type_Int = RIJPBFieldUtils.a(paramArticleSummary.medal_urls_height);
      paramArticleInfo.familyCommentInfo = localFamilyCommentInfo;
    }
  }
  
  public void k(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_social_feeds_info.has()))
    {
      Object localObject = (articlesummary.SocializeFeedsInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_feeds_info.msg_social_feeds_info);
      if (localObject != null)
      {
        localObject = (articlesummary.CardJumpInfo)RIJPBFieldUtils.a(((articlesummary.SocializeFeedsInfo)localObject).msg_card_jump_info);
        if (localObject != null)
        {
          paramArticleInfo.mCardJumpUrl = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).bytes_card_jump_url);
          paramArticleInfo.isCardJumpUrlAvailable = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).uint32_available);
          paramArticleInfo.commentBtnJumpUrl = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).bytes_comment_btn_url);
          paramArticleInfo.commentShareUrl = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).bytes_share_url);
        }
        paramArticleSummary = (articlesummary.FusionInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_fusion_info);
        if (paramArticleSummary != null)
        {
          paramArticleInfo.commentId = RIJPBFieldUtils.a(paramArticleSummary.str_comment_id);
          paramArticleInfo.commentSrc = RIJPBFieldUtils.a(paramArticleSummary.uint32_comment_src);
        }
      }
    }
  }
  
  public void l(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleInfo.proteusItemsData = RIJPBFieldUtils.a(paramArticleSummary.bytes_interface_data);
    if (paramArticleInfo.proteusItemsData != null) {
      RIJPreParseData.a(paramArticleInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseProteusItemsData summary.bytes_interface_data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.protocol.RIJMsfHandlerHelper
 * JD-Core Version:    0.7.0.1
 */