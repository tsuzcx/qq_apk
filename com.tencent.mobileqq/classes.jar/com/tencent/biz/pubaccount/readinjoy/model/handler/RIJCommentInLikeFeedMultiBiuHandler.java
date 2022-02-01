package com.tencent.biz.pubaccount.readinjoy.model.handler;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.NowLiveInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ShareWebPageInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCPicInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCVideoInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsTitle;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCPicInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVideoInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo;

public class RIJCommentInLikeFeedMultiBiuHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedMultiBiuHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  private feeds_info.BiuMultiLevel a(SocializeFeedsInfo.BiuInfo paramBiuInfo, ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = new feeds_info.BiuMultiLevel();
    if (paramBiuInfo.jdField_a_of_type_JavaLangLong != null) {
      paramByteStringMicro.uint64_origin_feeds_id.set(paramBiuInfo.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (paramBiuInfo.b != null) {
      paramByteStringMicro.uint64_origin_feeds_type.set(paramBiuInfo.b.longValue());
    }
    paramBiuInfo = paramBiuInfo.jdField_a_of_type_JavaUtilList.iterator();
    while (paramBiuInfo.hasNext())
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramBiuInfo.next();
      feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(localBiuCommentInfo.mBiuComment);
      localBiuOneLevelItem.bytes_biu_comments.set(localByteStringMicro);
      localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.mBiuTime);
      localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.mFeedId.longValue());
      localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.mUin.longValue());
      localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.mFeedsType);
      localBiuOneLevelItem.op_type.set(localBiuCommentInfo.mOpType);
      if (localBiuCommentInfo.jumpInfo != null)
      {
        localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
        localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jumpInfo.getId());
        localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getWording()));
        localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getJumpUrl()));
      }
      if (localBiuCommentInfo.ugcVoiceInfo != null)
      {
        localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
        localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.ugcVoiceInfo.voiceUrl));
        localBiuOneLevelItem.msg_voice_info.uint32_duration.set(localBiuCommentInfo.ugcVoiceInfo.duration);
        localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(localBiuCommentInfo.ugcVoiceInfo.fileSize);
      }
      paramByteStringMicro.rpt_biu_mutli_level.add(localBiuOneLevelItem);
    }
    return paramByteStringMicro;
  }
  
  private oidb_cmd0x83e.FeedsInfo a(ArticleInfo paramArticleInfo, int paramInt, oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
    localFeedsInfo.feeds_type.set(paramInt);
    if ((RIJFeedsType.c(paramArticleInfo)) || (RIJFeedsType.d(paramArticleInfo)) || (RIJFeedsType.f(paramArticleInfo)) || (RIJFeedsType.g(paramArticleInfo))) {
      if ((paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localFeedsInfo.uint32_business_id.set(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      localFeedsInfo.msg_social_feeds_info.set(paramSocializeFeedsInfo);
      if (!TextUtils.isEmpty(paramArticleInfo.businessName)) {
        localFeedsInfo.bytes_business_name.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessName));
      }
      if (!TextUtils.isEmpty(paramArticleInfo.businessUrl)) {
        localFeedsInfo.bytes_business_url.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessUrl));
      }
      if (!TextUtils.isEmpty(paramArticleInfo.businessNamePrefix)) {
        localFeedsInfo.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessNamePrefix));
      }
      return localFeedsInfo;
      localFeedsInfo.uint32_business_id.set((int)paramArticleInfo.businessId);
    }
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo != null))
    {
      feeds_info.ShareWebPageInfo localShareWebPageInfo = new feeds_info.ShareWebPageInfo();
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo;
      RIJPBFieldUtils.a(localShareWebPageInfo.bytes_source, paramArticleInfo.jdField_d_of_type_JavaLangString);
      RIJPBFieldUtils.a(localShareWebPageInfo.bytes_title, paramArticleInfo.jdField_b_of_type_JavaLangString);
      RIJPBFieldUtils.a(localShareWebPageInfo.bytes_pic_url, paramArticleInfo.jdField_c_of_type_JavaLangString);
      RIJPBFieldUtils.a(localShareWebPageInfo.bytes_web_url, paramArticleInfo.jdField_a_of_type_JavaLangString);
      paramSocializeFeedsInfo.share_web_page_info.set(localShareWebPageInfo);
    }
  }
  
  private void b(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo != null)) {
      paramSocializeFeedsInfo.now_live_info.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo.a());
    }
  }
  
  private void c(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null) && (RIJItemViewType.g(paramArticleInfo)))
    {
      Object localObject1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
      paramArticleInfo = new feeds_info.UGCFeedsInfo();
      RIJPBFieldUtils.a(paramArticleInfo.bytes_ugc_comments, ((SocializeFeedsInfo.UGCFeedsInfo)localObject1).jdField_a_of_type_JavaLangString);
      paramArticleInfo.enum_ugc_feeds_card_type.set(((SocializeFeedsInfo.UGCFeedsInfo)localObject1).jdField_a_of_type_Int);
      paramArticleInfo.uint64_cuin.set(((SocializeFeedsInfo.UGCFeedsInfo)localObject1).jdField_a_of_type_Long);
      Object localObject2 = ((SocializeFeedsInfo.UGCFeedsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject3;
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SocializeFeedsInfo.UGCPicInfo)((Iterator)localObject2).next();
        localObject4 = new feeds_info.UGCPicInfo();
        ((feeds_info.UGCPicInfo)localObject4).is_animation.set(((SocializeFeedsInfo.UGCPicInfo)localObject3).jdField_c_of_type_Int);
        ((feeds_info.UGCPicInfo)localObject4).uint32_pic_height.set(((SocializeFeedsInfo.UGCPicInfo)localObject3).jdField_b_of_type_Int);
        ((feeds_info.UGCPicInfo)localObject4).uint32_pic_width.set(((SocializeFeedsInfo.UGCPicInfo)localObject3).jdField_a_of_type_Int);
        RIJPBFieldUtils.a(((feeds_info.UGCPicInfo)localObject4).bytes_pic_md5, ((SocializeFeedsInfo.UGCPicInfo)localObject3).jdField_a_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCPicInfo)localObject4).bytes_pic_url, ((SocializeFeedsInfo.UGCPicInfo)localObject3).jdField_b_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCPicInfo)localObject4).bytes_thumbnail_url, ((SocializeFeedsInfo.UGCPicInfo)localObject3).jdField_c_of_type_JavaLangString);
        paramArticleInfo.msg_ugc_pic_info_list.add((MessageMicro)localObject4);
      }
      localObject2 = ((SocializeFeedsInfo.UGCFeedsInfo)localObject1).c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SocializeFeedsInfo.UGCVoiceInfo)((Iterator)localObject2).next();
        localObject4 = new feeds_info.UGCVoiceInfo();
        RIJPBFieldUtils.a(((feeds_info.UGCVoiceInfo)localObject4).bytes_voice_url, ((SocializeFeedsInfo.UGCVoiceInfo)localObject3).voiceUrl);
        ((feeds_info.UGCVoiceInfo)localObject4).uint32_duration.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject3).duration);
        ((feeds_info.UGCVoiceInfo)localObject4).uint32_file_size.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject3).fileSize);
        paramArticleInfo.msg_ugc_voice_info_list.add((MessageMicro)localObject4);
      }
      localObject1 = ((SocializeFeedsInfo.UGCFeedsInfo)localObject1).b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SocializeFeedsInfo.UGCVideoInfo)((Iterator)localObject1).next();
        localObject3 = new feeds_info.UGCVideoInfo();
        ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_height.set(((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_d_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_width.set(((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_c_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_video_height.set(((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_b_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_video_width.set(((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_a_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint64_duration.set(((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_a_of_type_Long);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_create_time.set(((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_e_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_busi_type.set(((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_f_of_type_Int);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_pic_md5, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_c_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_pic_url, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_d_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_video_md5, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_a_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_video_url, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_b_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_title, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_e_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_uuid, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_f_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_vid, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).i);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_share_url, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).h);
        RIJPBFieldUtils.a(((feeds_info.UGCVideoInfo)localObject3).bytes_uniq_id, ((SocializeFeedsInfo.UGCVideoInfo)localObject2).g);
        paramArticleInfo.msg_ugc_video_info_list.add((MessageMicro)localObject3);
      }
      paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(paramArticleInfo);
    }
  }
  
  private void d(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (RIJItemViewType.a(paramArticleInfo)))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo;
      feeds_info.PGCFeedsInfo localPGCFeedsInfo = new feeds_info.PGCFeedsInfo();
      Iterator localIterator = paramArticleInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject1;
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject1 = (SocializeFeedsInfo.PGCPicInfo)localIterator.next();
        localObject2 = new feeds_info.PGCPicInfo();
        RIJPBFieldUtils.a(((feeds_info.PGCPicInfo)localObject2).bytes_pic_md5, ((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_a_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.PGCPicInfo)localObject2).bytes_pic_url, ((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_b_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.PGCPicInfo)localObject2).bytes_thumbnail_url, ((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_c_of_type_JavaLangString);
        ((feeds_info.PGCPicInfo)localObject2).is_animation.set(((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_c_of_type_Int);
        ((feeds_info.PGCPicInfo)localObject2).uint32_pic_height.set(((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_b_of_type_Int);
        ((feeds_info.PGCPicInfo)localObject2).uint32_pic_width.set(((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_a_of_type_Int);
        localPGCFeedsInfo.msg_pgc_pic_info_list.add((MessageMicro)localObject2);
      }
      localIterator = paramArticleInfo.b.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (SocializeFeedsInfo.PGCVideoInfo)localIterator.next();
        localObject2 = new feeds_info.PGCVideoInfo();
        RIJPBFieldUtils.a(((feeds_info.PGCVideoInfo)localObject2).bytes_pic_md5, ((SocializeFeedsInfo.PGCVideoInfo)localObject1).jdField_c_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.PGCVideoInfo)localObject2).bytes_pic_url, ((SocializeFeedsInfo.PGCVideoInfo)localObject1).jdField_d_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.PGCVideoInfo)localObject2).bytes_video_md5, ((SocializeFeedsInfo.PGCVideoInfo)localObject1).jdField_a_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.PGCVideoInfo)localObject2).bytes_video_url, ((SocializeFeedsInfo.PGCVideoInfo)localObject1).jdField_b_of_type_JavaLangString);
        localPGCFeedsInfo.msg_pgc_video_info_list.add((MessageMicro)localObject2);
      }
      RIJPBFieldUtils.a(localPGCFeedsInfo.bytes_pgc_comments, paramArticleInfo.jdField_a_of_type_JavaLangString);
      paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(localPGCFeedsInfo);
    }
  }
  
  private void e(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null) && (RIJItemViewType.h(paramArticleInfo)))
    {
      feeds_info.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new feeds_info.TopicRecommendFeedsInfo();
      localTopicRecommendFeedsInfo.uint32_feeds_style.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_Int);
      localTopicRecommendFeedsInfo.uint64_feeds_id.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_Long);
      Object localObject = new ArrayList();
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next();
          feeds_info.TopicRecommendInfo localTopicRecommendInfo1 = new feeds_info.TopicRecommendInfo();
          localTopicRecommendInfo1.uint32_number_of_participants.set(localTopicRecommendInfo.jdField_b_of_type_Int);
          RIJPBFieldUtils.a(localTopicRecommendInfo1.bytes_business_name, localTopicRecommendInfo.jdField_a_of_type_JavaLangString);
          RIJPBFieldUtils.a(localTopicRecommendInfo1.bytes_business_name_prefix, localTopicRecommendInfo.jdField_c_of_type_JavaLangString);
          RIJPBFieldUtils.a(localTopicRecommendInfo1.bytes_business_url, localTopicRecommendInfo.jdField_b_of_type_JavaLangString);
          RIJPBFieldUtils.a(localTopicRecommendInfo1.bytes_pic_url, localTopicRecommendInfo.jdField_d_of_type_JavaLangString);
          localTopicRecommendInfo1.uint32_business_id.set(localTopicRecommendInfo.jdField_a_of_type_Int);
          ((List)localObject).add(localTopicRecommendInfo1);
        }
      }
      localTopicRecommendFeedsInfo.msg_topic_recommend_info.set((List)localObject);
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null)
      {
        localObject = new feeds_info.TopicRecommendFeedsTitle();
        RIJPBFieldUtils.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_url, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_title_content, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString);
        localTopicRecommendFeedsInfo.msg_left_title.set((MessageMicro)localObject);
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null)
      {
        localObject = new feeds_info.TopicRecommendFeedsTitle();
        RIJPBFieldUtils.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_url, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString);
        RIJPBFieldUtils.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_title_content, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString);
        localTopicRecommendFeedsInfo.msg_right_title.set((MessageMicro)localObject);
      }
      RIJPBFieldUtils.a(localTopicRecommendFeedsInfo.bytes_subscribe_id, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaLangString);
      localTopicRecommendFeedsInfo.uint64_uin.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_Long);
      RIJPBFieldUtils.a(localTopicRecommendFeedsInfo.bytes_comments, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString);
      paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(localTopicRecommendFeedsInfo);
    }
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 1, "start request0x83eDeliverAction");
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint64_feeds_id.set(paramLong2);
    localReqBody.uint32_operation.set(4);
    oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
    localSocializeFeedsInfo.uint64_feeds_id.set(paramLong2);
    localSocializeFeedsInfo.uint64_article_id.set(paramLong4);
    feeds_info.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new feeds_info.SocializeFeedsInfoUser();
    localSocializeFeedsInfoUser.uint64_uin.set(paramLong3);
    Object localObject = ByteStringMicro.copyFromUtf8(paramString1);
    localSocializeFeedsInfo.bytes_comments.set((ByteStringMicro)localObject);
    a(paramArticleInfo, localSocializeFeedsInfo);
    b(paramArticleInfo, localSocializeFeedsInfo);
    localObject = a(paramBiuInfo, (ByteStringMicro)localObject);
    localSocializeFeedsInfo.msg_biu_mutli_level.set((MessageMicro)localObject);
    localSocializeFeedsInfo.msg_master_uin.set(localSocializeFeedsInfoUser);
    QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 1, "request0x83eDeliver feedID=" + paramLong2 + ", feeds_type=" + paramInt2 + ", articleId=" + paramLong4 + ", masterUin=" + paramLong3 + ", comment=" + paramString1 + ",mOriFeedId=" + paramBiuInfo.jdField_a_of_type_JavaLangLong + ",mOriFeedType" + paramBiuInfo.b + ",bussinessId = " + paramArticleInfo.businessId);
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      c(paramArticleInfo, localSocializeFeedsInfo);
      d(paramArticleInfo, localSocializeFeedsInfo);
      e(paramArticleInfo, localSocializeFeedsInfo);
    }
    paramBiuInfo = a(paramArticleInfo, paramInt2, localSocializeFeedsInfo);
    QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 1, "request0x83eDeliver enum_biu_src=" + paramInt1);
    localReqBody.enum_biu_src.set(paramInt1);
    if (((paramInt1 == 17) || (paramInt1 == 2) || (paramInt1 == 100)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      localReqBody.bytes_inner_uniq_id.set(paramString1);
      QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 1, "request0x83eDeliver innerUniqueIDc=" + paramString2);
    }
    localReqBody.msg_feeds_info.set(paramBiuInfo);
    paramBiuInfo = localReqBody.uint32_is_one_touch_biu;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramBiuInfo.set(paramInt1);
      paramBiuInfo = String.valueOf(ReadInJoyUtils.a()) + System.currentTimeMillis();
      localReqBody.bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramBiuInfo));
      paramBiuInfo = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramBiuInfo.addAttribute("biu_deliver", Integer.valueOf(1));
      paramBiuInfo.addAttribute("BaseArticleSeq", Long.valueOf(paramLong5));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(paramBiuInfo);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 1, "handle0x83eBiuDeliverAction result:" + i);
    }
    long l;
    if (i == 0)
    {
      l = ((Long)paramToServiceMsg.getAttribute("BaseArticleSeq")).longValue();
      paramToServiceMsg = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(Integer.valueOf(0), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 2, new Object[] { "handle0x83eBiuDeliverAction, channel_id = ", Integer.valueOf(0), " articleId = ", Long.valueOf(paramToServiceMsg.mArticleID), " before biu count = ", Integer.valueOf(paramToServiceMsg.mSocialFeedInfo.jdField_f_of_type_Int) });
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.jdField_f_of_type_Int += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramToServiceMsg);
      }
      paramToServiceMsg = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a().a(Integer.valueOf(70), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 2, new Object[] { "handle0x83eBiuDeliverAction, channel_id = ", Integer.valueOf(70), " articleId = ", Long.valueOf(paramToServiceMsg.mArticleID), " before biu count = ", Integer.valueOf(paramToServiceMsg.mSocialFeedInfo.jdField_f_of_type_Int) });
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.jdField_f_of_type_Int += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramToServiceMsg);
      }
    }
    for (;;)
    {
      paramToServiceMsg = BaseApplication.getContext().getString(2131718196);
      if (localRspBody.bytes_result_desc.has())
      {
        paramToServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
        QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 2, "handle0x83eBiuDeliverAction | resp errorMsg ： " + paramToServiceMsg);
      }
      l = localRspBody.uint64_feeds_id.get();
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJCommentInLikeFeedMultiBiuHandler.1(this, l, i, paramToServiceMsg));
      return;
      if (i != 33) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedMultiBiuHandler
 * JD-Core Version:    0.7.0.1
 */