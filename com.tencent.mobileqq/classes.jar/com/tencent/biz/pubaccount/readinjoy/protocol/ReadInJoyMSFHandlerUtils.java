package com.tencent.biz.pubaccount.readinjoy.protocol;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArkAppFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeResult;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeResult;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArkAppFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArticleSummary;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.DisLikeInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PosAdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RichTips;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.InterestLabelInfo;

public class ReadInJoyMSFHandlerUtils
{
  private static Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) };
  private static Integer[] jdField_a_of_type_ArrayOfJavaLangInteger;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "时事", "娱乐", "科技", "动漫", "体育", "搞笑", "时尚", "情感", "汽车", "旅行" };
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[] { Integer.valueOf(4779), Integer.valueOf(1166), Integer.valueOf(5293), Integer.valueOf(501), Integer.valueOf(73), Integer.valueOf(5729), Integer.valueOf(1314), Integer.valueOf(3817), Integer.valueOf(3689), Integer.valueOf(3076) };
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if ((paramInt1 % 5 == 0) || (paramInt1 % 5 == 1)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return 0;
  }
  
  public static ArticleInfo a(oidb_cmd0x68b.ArticleSummary paramArticleSummary, int paramInt, ArticleInfo paramArticleInfo)
  {
    int j = 0;
    boolean bool2 = true;
    if (paramArticleSummary == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo: channelID:" + paramInt);
    }
    ArticleInfo localArticleInfo1 = paramArticleInfo;
    if (paramArticleInfo == null) {
      localArticleInfo1 = new ArticleInfo();
    }
    localArticleInfo1.mChannelID = paramInt;
    if (paramArticleSummary.uint64_article_id.has()) {
      localArticleInfo1.mArticleID = paramArticleSummary.uint64_article_id.get();
    }
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localArticleInfo1.mTitle = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
      localArticleInfo1.mSummary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_first_page_pic_url.has()) && (paramArticleSummary.bytes_first_page_pic_url.get() != null)) {
      localArticleInfo1.mFirstPagePicUrl = paramArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_original_url.has()) && (paramArticleSummary.bytes_original_url.get() != null)) {
      localArticleInfo1.mOriginalUrl = paramArticleSummary.bytes_original_url.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_content_url.has()) && (paramArticleSummary.bytes_article_content_url.get() != null)) {
      localArticleInfo1.mArticleContentUrl = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
    }
    if (paramArticleSummary.uint64_time.has()) {
      localArticleInfo1.mTime = paramArticleSummary.uint64_time.get();
    }
    if (paramArticleSummary.uint32_comment_count.has()) {
      localArticleInfo1.mCommentCount = paramArticleSummary.uint32_comment_count.get();
    }
    if ((paramArticleSummary.bytes_subscribe_id.has()) && (paramArticleSummary.bytes_subscribe_id.get() != null)) {
      localArticleInfo1.mSubscribeID = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_subscribe_name.has()) && (paramArticleSummary.bytes_subscribe_name.get() != null)) {
      localArticleInfo1.mSubscribeName = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
    }
    if (paramArticleSummary.uint64_recommend_time.has()) {
      localArticleInfo1.mRecommendTime = paramArticleSummary.uint64_recommend_time.get();
    }
    if (paramArticleSummary.uint64_recommend_seq.has()) {
      localArticleInfo1.mRecommendSeq = paramArticleSummary.uint64_recommend_seq.get();
    }
    if (paramArticleSummary.uint32_show_big_picture.has()) {
      if (paramArticleSummary.uint32_show_big_picture.get() != 1) {
        break label1310;
      }
    }
    label1310:
    for (boolean bool1 = true;; bool1 = false)
    {
      localArticleInfo1.mShowBigPicture = bool1;
      if (paramArticleSummary.uint64_algorithm_id.has()) {
        localArticleInfo1.mAlgorithmID = paramArticleSummary.uint64_algorithm_id.get();
      }
      if ((paramArticleSummary.bytes_recommend_reason.has()) && (paramArticleSummary.bytes_recommend_reason.get() != null)) {
        localArticleInfo1.mRecommentdReason = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
      }
      if ((paramArticleSummary.json_video_list.has()) && (paramArticleSummary.json_video_list.get() != null)) {
        localArticleInfo1.mJsonVideoList = paramArticleSummary.json_video_list.get().toStringUtf8();
      }
      if ((paramArticleSummary.json_picture_list.has()) && (paramArticleSummary.json_picture_list.get() != null)) {
        localArticleInfo1.mJsonPictureList = paramArticleSummary.json_picture_list.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_abandon_repeat_flag.has()) {
        localArticleInfo1.mAbandonRepeatFlag = paramArticleSummary.uint32_abandon_repeat_flag.get();
      }
      if ((paramArticleSummary.bytes_test.has()) && (paramArticleSummary.bytes_test.get() != null)) {
        localArticleInfo1.mArticleSubscriptText = paramArticleSummary.bytes_test.get().toStringUtf8();
      }
      if ((paramArticleSummary.bytes_colour.has()) && (paramArticleSummary.bytes_colour.get() != null)) {
        localArticleInfo1.mArticleSubscriptColor = paramArticleSummary.bytes_colour.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_strategy_id.has()) {
        localArticleInfo1.mStrategyId = paramArticleSummary.uint32_strategy_id.get();
      }
      if (paramArticleSummary.uint64_merged_video_id.has()) {
        localArticleInfo1.mMergeVideoId = paramArticleSummary.uint64_merged_video_id.get();
      }
      if ((paramArticleSummary.bytes_media_specs.has()) && (paramArticleSummary.bytes_media_specs.get() != null)) {}
      try
      {
        localArticleInfo1.mTopicPicInfo = paramArticleSummary.bytes_media_specs.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyMSFHandlerUtils", 2, "test to print media specs true, media_specs:" + localArticleInfo1.mTopicPicInfo);
        }
        paramArticleInfo = new JSONObject(localArticleInfo1.mTopicPicInfo);
        i = paramArticleInfo.optInt("topic_width");
        k = paramArticleInfo.optInt("topic_height");
        if (k != 0) {
          localArticleInfo1.mTopicPicWHRatio = (i / 1.0D / k);
        }
        localArticleInfo1.videoJumpChannelID = paramArticleInfo.optInt("jump_channel_id");
        localArticleInfo1.videoJumpChannelType = paramArticleInfo.optInt("jump_channel_type");
        localArticleInfo1.videoJumpChannelName = paramArticleInfo.optString("jump_channel_name");
      }
      catch (Exception paramArticleInfo)
      {
        int i;
        Object localObject;
        for (;;)
        {
          int k;
          QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve bytes_media_specs failed ", paramArticleInfo);
          localArticleInfo1.mTopicPicInfo = "";
          localArticleInfo1.mTopicPicWHRatio = 0.0D;
          localArticleInfo1.videoJumpChannelID = -1;
          localArticleInfo1.videoJumpChannelType = -1;
          localArticleInfo1.videoJumpChannelName = "";
          continue;
          localArticleInfo1.mDislikeInfos.add(localObject);
        }
        localArticleInfo1.mDiskLikeInfoString = DislikeInfo.a(localArticleInfo1.mDislikeInfos);
        if (!paramArticleSummary.rpt_comments.has()) {
          break label1413;
        }
        localArticleInfo1.mCommentsObj = paramArticleSummary.rpt_comments.get();
        if (!paramArticleSummary.msg_pack_info.has()) {
          break label1584;
        }
        localArticleInfo1.mPackInfoObj = ((oidb_cmd0x68b.PackInfo)paramArticleSummary.msg_pack_info.get());
        localArticleInfo1.mGroupId = localArticleInfo1.mPackInfoObj.uint64_pack_id.get();
        localArticleInfo1.mPolymericInfo = PolymericInfo.a(localArticleInfo1.mPackInfoObj);
        if (localArticleInfo1.mPolymericInfo.jdField_a_of_type_Int != 9) {
          break label1493;
        }
        localArticleInfo1.businessId = localArticleInfo1.mPolymericInfo.f;
        if (!QLog.isColorLevel()) {
          break label1584;
        }
        QLog.d("PolymericSmallVideo_ReadInJoyMSFHandlerUtils", 2, "groupId:" + localArticleInfo1.mGroupId + " articleID:" + localArticleInfo1.mArticleID + " type:" + ((oidb_cmd0x68b.PackInfo)localArticleInfo1.mPackInfoObj.get()).pack_type.get() + " recommendId:" + localArticleInfo1.mRecommendSeq);
        if (!paramArticleSummary.bytes_circle_id.has()) {
          break label2308;
        }
        localArticleInfo1.mStrCircleId = paramArticleSummary.bytes_circle_id.get().toStringUtf8();
        if (!paramArticleSummary.uint32_is_active.has()) {
          break label2325;
        }
        if (paramArticleSummary.uint32_is_active.get() != 1) {
          break label2319;
        }
        bool1 = bool2;
        for (localArticleInfo1.mPUinIsActive = bool1;; localArticleInfo1.mPUinIsActive = true)
        {
          if (paramArticleSummary.msg_subscribe_info.has()) {
            localArticleInfo1.mSubscribeInfoObj = ((oidb_cmd0x68b.SubscribeInfo)paramArticleSummary.msg_subscribe_info.get());
          }
          if (paramArticleSummary.msg_feeds_info.has()) {
            a(localArticleInfo1, (oidb_cmd0x68b.FeedsInfo)paramArticleSummary.msg_feeds_info.get());
          }
          if (paramArticleSummary.uint32_video_play_count.has())
          {
            localArticleInfo1.mVideoPlayCount = paramArticleSummary.uint32_video_play_count.get();
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.mVideoPlayCount =" + localArticleInfo1.mVideoPlayCount);
            }
          }
          if (paramArticleSummary.rpt_label_list.has())
          {
            localArticleInfo1.mLabelListObj = paramArticleSummary.rpt_label_list.get();
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): summary.rpt_label_list.has() = true");
            }
          }
          if (paramArticleSummary.is_accountless.has())
          {
            localArticleInfo1.mAccountLess = paramArticleSummary.is_accountless.get();
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.mAccountLess =" + localArticleInfo1.mAccountLess);
            }
          }
          if (paramArticleSummary.bytes_interface_data.has())
          {
            localArticleInfo1.interfaceData = paramArticleSummary.bytes_interface_data.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.interfaceData = " + localArticleInfo1.interfaceData);
            }
          }
          if (paramArticleSummary.bytes_gallery_report_extdata.has())
          {
            localArticleInfo1.galleryReprotExdData = paramArticleSummary.bytes_gallery_report_extdata.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.galleryReprotExdData = " + localArticleInfo1.galleryReprotExdData);
            }
          }
          if (paramArticleSummary.enum_article_style.has())
          {
            localArticleInfo1.articleStyle = paramArticleSummary.enum_article_style.get();
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.articleStyle = " + localArticleInfo1.articleStyle);
            }
          }
          if (!paramArticleSummary.msg_sub_article_summary.has()) {
            break label2381;
          }
          localArticleInfo1.mSubSummaryListObj = paramArticleSummary.msg_sub_article_summary.get();
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): summary.msg_sub_article_summary.has() = true");
          }
          if ((localArticleInfo1.mSubSummaryListObj == null) || (localArticleInfo1.mSubSummaryListObj.size() <= 0)) {
            break label2381;
          }
          paramArticleInfo = new ArrayList(localArticleInfo1.mSubSummaryListObj.size());
          localObject = localArticleInfo1.mSubSummaryListObj.iterator();
          i = j;
          while (((Iterator)localObject).hasNext())
          {
            ArticleInfo localArticleInfo2 = a((oidb_cmd0x68b.ArticleSummary)((Iterator)localObject).next(), paramInt, null);
            paramArticleInfo.add(localArticleInfo2);
            if ((QLog.isColorLevel()) && (localArticleInfo2 != null))
            {
              QLog.e("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): 解析 sub articleSummary【" + i + "】 id : " + localArticleInfo1.mArticleID + " seq : " + localArticleInfo1.mRecommendSeq + " title : " + ReadInJoyUtils.c(localArticleInfo1.mTitle) + " , groupID : " + localArticleInfo1.mGroupId + " algorithmID : " + localArticleInfo1.mAlgorithmID + " strategyId : " + localArticleInfo1.mStrategyId + " businessID : " + localArticleInfo1.businessId + " businessName :" + localArticleInfo1.businessName);
              i += 1;
            }
          }
          localArticleInfo1.mStrCircleId = "";
          break;
          bool1 = false;
          break label1634;
        }
        localArticleInfo1.mSubArtilceList = paramArticleInfo;
        if (!QLog.isColorLevel()) {
          break label2381;
        }
        QLog.e("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): summary.msg_sub_article_summary.size = " + localArticleInfo1.mSubSummaryListObj.size());
        if (!paramArticleSummary.bytes_interface_data.has()) {
          break label2406;
        }
        localArticleInfo1.proteusItemsData = paramArticleSummary.bytes_interface_data.get().toStringUtf8();
        if (!paramArticleSummary.uint32_video_comment_count.has()) {
          break label2428;
        }
        localArticleInfo1.mVideoCommentCount = paramArticleSummary.uint32_video_comment_count.get();
        if ((!paramArticleSummary.bytes_video_subscript_txt.has()) || (paramArticleSummary.bytes_video_subscript_txt.get() == null)) {
          break label2463;
        }
        localArticleInfo1.mVideoArticleSubsText = paramArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_video_subscript_color.has()) || (paramArticleSummary.bytes_video_subscript_color.get() == null)) {
          break label2498;
        }
        localArticleInfo1.mVideoArticleSubsColor = paramArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_ads_jump_url.has()) || (paramArticleSummary.bytes_ads_jump_url.get() == null)) {
          break label2533;
        }
        localArticleInfo1.mVideoAdsJumpUrl = paramArticleSummary.bytes_ads_jump_url.get().toStringUtf8();
        if (!paramArticleSummary.uint32_ads_jump_type.has()) {
          break label2555;
        }
        localArticleInfo1.mVideoAdsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
        if (!paramArticleSummary.uint32_ads_source.has()) {
          break label2577;
        }
        localArticleInfo1.mVideoAdsSource = paramArticleSummary.uint32_ads_source.get();
        ReadInJoyUtils.a(localArticleInfo1);
      }
      if ((paramArticleSummary.bytes_friend_like_wording.has()) && (paramArticleSummary.bytes_friend_like_wording.get() != null)) {
        localArticleInfo1.mArticleFriendLikeText = paramArticleSummary.bytes_friend_like_wording.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_video_show_small_picture.has()) {
        localArticleInfo1.mVideoType = paramArticleSummary.uint32_video_show_small_picture.get();
      }
      if (paramArticleSummary.uint32_comment_icon_type.has()) {
        localArticleInfo1.mCommentIconType = paramArticleSummary.uint32_comment_icon_type.get();
      }
      if ((paramArticleSummary.bytes_server_context.has()) && (paramArticleSummary.bytes_server_context.get() != null)) {
        localArticleInfo1.mServerContext = paramArticleSummary.bytes_server_context.get().toByteArray();
      }
      if (paramArticleSummary.msg_channel_info.has())
      {
        paramArticleInfo = (oidb_cmd0x68b.ChannelInfo)paramArticleSummary.msg_channel_info.get();
        if (paramArticleInfo.uint32_channel_id.has()) {
          localArticleInfo1.mChannelInfoId = paramArticleInfo.uint32_channel_id.get();
        }
        if (paramArticleInfo.bytes_channel_name.has()) {
          localArticleInfo1.mChannelInfoName = paramArticleInfo.bytes_channel_name.get().toStringUtf8();
        }
        if (paramArticleInfo.uint32_channel_type.has()) {
          localArticleInfo1.mChannelInfoType = paramArticleInfo.uint32_channel_type.get();
        }
        if (paramArticleInfo.bytes_channel_display_name.has()) {
          localArticleInfo1.mChannelInfoDisplayName = paramArticleInfo.bytes_channel_display_name.get().toStringUtf8();
        }
      }
      if (paramArticleSummary.uint32_is_disp_timestamp.has()) {
        localArticleInfo1.mIsDispTimestamp = paramArticleSummary.uint32_is_disp_timestamp.get();
      }
      if (paramArticleSummary.uint32_is_gallery.has())
      {
        localArticleInfo1.mIsGallery = paramArticleSummary.uint32_is_gallery.get();
        if ((localArticleInfo1.mIsGallery != 0) && (paramArticleSummary.uint32_picture_number.has())) {
          localArticleInfo1.mGalleryPicNumber = paramArticleSummary.uint32_picture_number.get();
        }
      }
      if ((paramArticleSummary.bytes_inner_uniq_id.has()) && (paramArticleSummary.bytes_inner_uniq_id.get() != null)) {
        localArticleInfo1.innerUniqueID = paramArticleSummary.bytes_inner_uniq_id.get().toStringUtf8();
      }
      if (!paramArticleSummary.rpt_dislike_list.has()) {
        break label1391;
      }
      paramArticleInfo = paramArticleSummary.rpt_dislike_list.get();
      if ((paramArticleInfo == null) || (paramArticleInfo.size() <= 0)) {
        break label1391;
      }
      k = paramArticleInfo.size();
      localArticleInfo1.mDislikeInfos = new ArrayList();
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label1378;
        }
        localObject = new DislikeInfo();
        ((DislikeInfo)localObject).a((oidb_cmd0x68b.DisLikeInfo)paramArticleInfo.get(i));
        if (!TextUtils.isEmpty(((DislikeInfo)localObject).jdField_a_of_type_JavaLangString)) {
          break;
        }
        i += 1;
      }
    }
    label1378:
    label1391:
    label2428:
    return localArticleInfo1;
  }
  
  public static ChannelCoverInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo, int paramInt)
  {
    boolean bool2 = true;
    ChannelCoverInfo localChannelCoverInfo1 = new ChannelCoverInfo();
    if (paramChannelInfo.uint32_channel_id.has()) {
      localChannelCoverInfo1.mChannelCoverId = paramChannelInfo.uint32_channel_id.get();
    }
    if ((paramChannelInfo.bytes_channel_name.has()) && (paramChannelInfo.bytes_channel_name.get() != null)) {
      localChannelCoverInfo1.mChannelCoverName = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
    }
    if (paramChannelInfo.enum_channel_cover_style.has()) {
      localChannelCoverInfo1.mChannelCoverStyle = paramChannelInfo.enum_channel_cover_style.get();
    }
    if ((paramChannelInfo.bytes_channel_cover_wording.has()) && (paramChannelInfo.bytes_channel_cover_wording.get() != null)) {}
    try
    {
      localChannelCoverInfo1.mChannelCoverSummary = new String(paramChannelInfo.bytes_channel_cover_wording.get().toByteArray(), "utf-8");
      if ((!paramChannelInfo.bytes_channel_cover_spec.has()) || (paramChannelInfo.bytes_channel_cover_spec.get() == null)) {}
    }
    catch (Exception localException4)
    {
      try
      {
        localChannelCoverInfo1.mChannelCoverSpec = new String(paramChannelInfo.bytes_channel_cover_spec.get().toByteArray(), "utf-8");
        localObject = new JSONObject(localChannelCoverInfo1.mChannelCoverSpec).getString("filterColor");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localChannelCoverInfo1.hasFilterColor = true;
          localChannelCoverInfo1.filterColor = Color.parseColor((String)localObject);
        }
        if ((!paramChannelInfo.bytes_channel_jump_url.has()) || (paramChannelInfo.bytes_channel_jump_url.get() == null)) {}
      }
      catch (Exception localException4)
      {
        try
        {
          localChannelCoverInfo1.mChannelJumpUrl = new String(paramChannelInfo.bytes_channel_jump_url.get().toByteArray(), "utf-8");
          if ((!paramChannelInfo.bytes_channel_cover_picurl.has()) || (paramChannelInfo.bytes_channel_cover_picurl.get() == null)) {}
        }
        catch (Exception localException4)
        {
          try
          {
            localChannelCoverInfo1.mChannelCoverPicUrl = new String(paramChannelInfo.bytes_channel_cover_picurl.get().toByteArray(), "utf-8");
            if (paramChannelInfo.uint32_is_followed.has()) {
              localChannelCoverInfo1.mFollowType = paramChannelInfo.uint32_is_followed.get();
            }
            if (paramChannelInfo.enum_column_type.has()) {
              localChannelCoverInfo1.mColumnType = paramChannelInfo.enum_column_type.get();
            }
            if ((paramChannelInfo.msg_rich_tips.has()) && (paramChannelInfo.msg_rich_tips.get() != null))
            {
              localObject = (oidb_cmd0x69f.RichTips)paramChannelInfo.msg_rich_tips.get();
              if (((oidb_cmd0x69f.RichTips)localObject).uint32_tips_type.has()) {
                localChannelCoverInfo1.mTipsType = ((oidb_cmd0x69f.RichTips)localObject).uint32_tips_type.get();
              }
              if ((!((oidb_cmd0x69f.RichTips)localObject).bytes_tips_text.has()) || (((oidb_cmd0x69f.RichTips)localObject).bytes_tips_text.get() == null)) {}
            }
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                localChannelCoverInfo1.mTipsText = new String(((oidb_cmd0x69f.RichTips)localObject).bytes_tips_text.get().toByteArray(), "utf-8");
                if (((oidb_cmd0x69f.RichTips)localObject).uint32_latest_sticky_time.has()) {
                  localChannelCoverInfo1.mUpdateTime = ((oidb_cmd0x69f.RichTips)localObject).uint32_latest_sticky_time.get();
                }
                Object localObject = (ArrayList)ReadInJoyLogicEngine.a().a(paramInt);
                if (localObject == null) {
                  break;
                }
                localObject = ((ArrayList)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  ChannelCoverInfo localChannelCoverInfo2 = (ChannelCoverInfo)((Iterator)localObject).next();
                  if (localChannelCoverInfo2.mChannelCoverId == localChannelCoverInfo1.mChannelCoverId) {
                    localChannelCoverInfo1.mPreUpdateTime = localChannelCoverInfo2.mPreUpdateTime;
                  }
                }
                localException1 = localException1;
                QLog.d("ChannelInfoModule", 1, "resolve channel cover title failed " + localException1.toString());
                continue;
                localException2 = localException2;
                QLog.d("ChannelInfoModule", 1, "resolve bytes_channel_cover_spec failed " + localException2.toString());
                continue;
                localException3 = localException3;
                QLog.d("ChannelInfoModule", 1, "resolve channel cover jumpurl failed " + localException3.toString());
              }
              localException4 = localException4;
              QLog.d("ChannelInfoModule", 1, "resolve channel cover picurl failed " + localException4.toString());
            }
            catch (Exception localException6)
            {
              for (;;)
              {
                QLog.d("ChannelInfoModule", 1, "resolve channel cover bytes_tips_text failed " + localException6.toString());
              }
            }
            if ((!paramChannelInfo.bytes_icon_url.has()) || (paramChannelInfo.bytes_icon_url.get() == null)) {}
          }
        }
      }
    }
    try
    {
      localChannelCoverInfo1.mIconUrl = new String(paramChannelInfo.bytes_icon_url.get().toByteArray(), "utf-8");
      if ((paramChannelInfo.uint32_fonts_color.has()) && (paramChannelInfo.uint32_fonts_color.get() != 0)) {
        localChannelCoverInfo1.mFontColor = paramChannelInfo.uint32_fonts_color.get();
      }
      if ((paramChannelInfo.uint32_frame_color.has()) && (paramChannelInfo.uint32_frame_color.get() != 0)) {
        localChannelCoverInfo1.mFrameColor = paramChannelInfo.uint32_frame_color.get();
      }
      localChannelCoverInfo1.mChannelId = paramInt;
      if (paramChannelInfo.uint64_channel_cover_article_id.has()) {
        localChannelCoverInfo1.mArticleId = paramChannelInfo.uint64_channel_cover_article_id.get();
      }
      if (paramChannelInfo.uint32_channel_type.has()) {
        localChannelCoverInfo1.mChannelType = paramChannelInfo.uint32_channel_type.get();
      }
      if (paramChannelInfo.uint32_is_topic.has())
      {
        if (paramChannelInfo.uint32_is_topic.get() > 0)
        {
          bool1 = true;
          localChannelCoverInfo1.mIsTopic = bool1;
        }
      }
      else
      {
        if (paramChannelInfo.uint32_is_external_expose.has())
        {
          if (paramChannelInfo.uint32_is_external_expose.get() != 1) {
            break label1053;
          }
          bool1 = true;
          localChannelCoverInfo1.isExternalExposure = bool1;
        }
        if (paramChannelInfo.bytes_is_external_bg_url.has()) {
          localChannelCoverInfo1.externalExposureBackgroundUrl = paramChannelInfo.bytes_is_external_bg_url.get().toStringUtf8();
        }
        if (paramChannelInfo.uint32_has_recommend.has())
        {
          if (paramChannelInfo.uint32_has_recommend.get() != 1) {
            break label1058;
          }
          bool1 = bool2;
          localChannelCoverInfo1.isExternalExposurePersist = bool1;
        }
        return localChannelCoverInfo1;
      }
    }
    catch (Exception localException5)
    {
      for (;;)
      {
        QLog.d("ChannelInfoModule", 1, "resolve channel cover bytes_icon_url failed " + localException5.toString());
        continue;
        boolean bool1 = false;
        continue;
        label1053:
        bool1 = false;
        continue;
        label1058:
        bool1 = false;
      }
    }
  }
  
  public static ChannelInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo)
  {
    ChannelInfo localChannelInfo = new ChannelInfo();
    if (paramChannelInfo.uint32_channel_id.has()) {
      localChannelInfo.mChannelID = paramChannelInfo.uint32_channel_id.get();
    }
    if ((paramChannelInfo.bytes_channel_name.has()) && (paramChannelInfo.bytes_channel_name.get() != null)) {
      localChannelInfo.mChannelName = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
    }
    if (paramChannelInfo.uint32_channel_type.has()) {
      localChannelInfo.mChannelType = paramChannelInfo.uint32_channel_type.get();
    }
    if ((paramChannelInfo.uint32_is_first_req.has()) && (localChannelInfo.mChannelType == 1)) {
      if (paramChannelInfo.uint32_is_first_req.get() == 0) {
        break label227;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localChannelInfo.mIsFirstReq = bool;
      if ((paramChannelInfo.uint32_frame_color.has()) && (paramChannelInfo.uint32_frame_color.get() != 0)) {
        localChannelInfo.mFrameColor = paramChannelInfo.uint32_frame_color.get();
      }
      if ((paramChannelInfo.uint32_fonts_color.has()) && (paramChannelInfo.uint32_fonts_color.get() != 0)) {
        localChannelInfo.mFontColor = paramChannelInfo.uint32_fonts_color.get();
      }
      if ((paramChannelInfo.bytes_channel_jump_url.has()) && (paramChannelInfo.bytes_channel_jump_url.get() != null)) {}
      try
      {
        localChannelInfo.mJumpUrl = new String(paramChannelInfo.bytes_channel_jump_url.get().toByteArray(), "utf-8");
        return localChannelInfo;
      }
      catch (Exception paramChannelInfo)
      {
        label227:
        QLog.d("ChannelInfoModule", 1, "resolve search channel jump url failed " + paramChannelInfo.toString());
      }
    }
    return localChannelInfo;
  }
  
  public static ArrayList a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x68b.RspGetFollowTabFeeds localRspGetFollowTabFeeds = (oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.next();
      if ((localRspGetFollowTabFeeds.msg_article_summary.has()) && (localRspGetFollowTabFeeds.uint32_feeds_type.has()))
      {
        ArticleInfo localArticleInfo = a((oidb_cmd0x68b.ArticleSummary)localRspGetFollowTabFeeds.msg_article_summary.get(), 70, null);
        if ((localArticleInfo != null) && (localArticleInfo.mArticleID != -1L) && (localArticleInfo.mRecommendSeq != -1L))
        {
          localArticleInfo.mFeedType = localRspGetFollowTabFeeds.uint32_feeds_type.get();
          localArrayList.add(localArticleInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((oidb_cmd0x69f.ChannelInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((oidb_cmd0x68b.ArticleSummary)paramList.next(), paramInt, null));
    }
    return localArrayList;
  }
  
  public static List a(List paramList1, List paramList2)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = j;
    if (paramList1 != null)
    {
      if (paramList1.size() == 0) {
        i = j;
      }
    }
    else
    {
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        paramList1 = new InterestLabelInfo();
        paramList1.mInterestLabelNme = jdField_a_of_type_ArrayOfJavaLangString[i];
        paramList1.mInterestLabelID = jdField_a_of_type_ArrayOfJavaLangInteger[i].intValue();
        paramList1.mIsDefault = jdField_a_of_type_ArrayOfJavaLangBoolean[i].booleanValue();
        localArrayList.add(paramList1);
        i += 1;
      }
      return localArrayList;
    }
    j = paramList1.size();
    paramList1 = paramList1.iterator();
    i = 0;
    if (paramList1.hasNext())
    {
      oidb_cmd0x6e5.InterestLabelInfo localInterestLabelInfo = (oidb_cmd0x6e5.InterestLabelInfo)paramList1.next();
      InterestLabelInfo localInterestLabelInfo1 = new InterestLabelInfo();
      if (localInterestLabelInfo.uint32_interest_label_id.has()) {
        localInterestLabelInfo1.mInterestLabelID = localInterestLabelInfo.uint32_interest_label_id.get();
      }
      if ((localInterestLabelInfo.bytes_interest_label_name.has()) && (localInterestLabelInfo.bytes_interest_label_name.get() != null)) {
        localInterestLabelInfo1.mInterestLabelNme = localInterestLabelInfo.bytes_interest_label_name.get().toStringUtf8();
      }
      if ((paramList2 != null) && (!paramList2.isEmpty())) {
        localInterestLabelInfo1.mIsDefault = paramList2.contains(Integer.valueOf(localInterestLabelInfo1.mInterestLabelID));
      }
      if ((localInterestLabelInfo1.mInterestLabelNme != null) && (localInterestLabelInfo1.mInterestLabelNme.length() > 3))
      {
        i = a(i, j);
        localArrayList.add(i, localInterestLabelInfo1);
      }
      for (;;)
      {
        break;
        localArrayList.add(localInterestLabelInfo1);
      }
    }
    return localArrayList;
  }
  
  public static void a(ArticleInfo paramArticleInfo, oidb_cmd0x68b.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null)
    {
      paramArticleInfo.mFeedType = 0;
      return;
    }
    if (paramFeedsInfo.feeds_type.has()) {
      paramArticleInfo.mFeedType = paramFeedsInfo.feeds_type.get();
    }
    if (paramFeedsInfo.uint32_business_id.has()) {
      paramArticleInfo.businessId = paramFeedsInfo.uint32_business_id.get();
    }
    if (paramFeedsInfo.bytes_business_name.has()) {
      paramArticleInfo.businessName = paramFeedsInfo.bytes_business_name.get().toStringUtf8();
    }
    if (paramFeedsInfo.bytes_business_url.has()) {
      paramArticleInfo.businessUrl = paramFeedsInfo.bytes_business_url.get().toStringUtf8();
    }
    if (paramFeedsInfo.bytes_business_name_prefix.has()) {
      paramArticleInfo.businessNamePrefix = paramFeedsInfo.bytes_business_name_prefix.get().toStringUtf8();
    }
    Object localObject;
    if ((paramFeedsInfo.msg_social_feeds_info.has()) && (paramFeedsInfo.msg_social_feeds_info.get() != null))
    {
      localObject = (oidb_cmd0x68b.SocializeFeedsInfo)paramFeedsInfo.msg_social_feeds_info.get();
      paramArticleInfo.mSocialFeedInfo = SocializeFeedsInfo.a((oidb_cmd0x68b.SocializeFeedsInfo)localObject);
      paramArticleInfo.mSocialFeedInfoByte = ((oidb_cmd0x68b.SocializeFeedsInfo)localObject).toByteArray();
      if (paramArticleInfo.mSocialFeedInfo != null) {
        paramArticleInfo.mFeedId = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      }
    }
    if (((!paramFeedsInfo.msg_pos_ad_info.has()) || (paramFeedsInfo.msg_pos_ad_info.get() == null)) || ((paramFeedsInfo.msg_topic_recommend_feeds_info.has()) && (paramFeedsInfo.msg_topic_recommend_feeds_info.get() != null)))
    {
      localObject = (oidb_cmd0x68b.TopicRecommendFeedsInfo)paramFeedsInfo.msg_topic_recommend_feeds_info.get();
      paramArticleInfo.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a((oidb_cmd0x68b.TopicRecommendFeedsInfo)localObject);
      paramArticleInfo.mTopicRecommendFeedsInfoByte = ((oidb_cmd0x68b.TopicRecommendFeedsInfo)localObject).toByteArray();
      if (paramArticleInfo.mTopicRecommendFeedsInfo == null) {
        break label342;
      }
    }
    label342:
    for (long l = paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_Long;; l = 0L)
    {
      paramArticleInfo.mFeedId = l;
      if ((!paramFeedsInfo.msg_ark_app_feeds_info.has()) || (paramFeedsInfo.msg_ark_app_feeds_info.get() == null)) {
        break;
      }
      paramFeedsInfo = (oidb_cmd0x68b.ArkAppFeedsInfo)paramFeedsInfo.msg_ark_app_feeds_info.get();
      paramArticleInfo.mArkAppFeedsInfo = ArkAppFeedsInfo.a(paramFeedsInfo);
      paramArticleInfo.mArkAppFeedsInfoBytes = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mArkAppFeedsInfo.jdField_a_of_type_Long;
      return;
    }
  }
  
  public static void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ReadInJoyUtils.a((ArticleInfo)paramList.next());
      }
    }
  }
  
  public static List b(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeResult localDislikeResult = (oidb_cmd0x46f.DislikeResult)paramList.next();
      DislikeResult localDislikeResult1 = new DislikeResult();
      if (localDislikeResult.uint64_articleid.has()) {
        localDislikeResult1.jdField_a_of_type_Long = localDislikeResult.uint64_articleid.get();
      }
      if (localDislikeResult.uint32_result.has()) {
        localDislikeResult1.jdField_a_of_type_Int = localDislikeResult.uint32_result.get();
      }
      if (localDislikeResult.str_message.has()) {
        localDislikeResult1.jdField_a_of_type_JavaLangString = localDislikeResult.str_message.get();
      }
      localArrayList.add(localDislikeResult1);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils
 * JD-Core Version:    0.7.0.1
 */