package com.tencent.biz.pubaccount.readinjoy.video.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.SubscriptInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ReadInJoySrtHandler;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;

public final class VideoR5$Builder
{
  private final VideoR5 a;
  
  public VideoR5$Builder(VideoInfo paramVideoInfo)
  {
    String str1;
    Object localObject3;
    if (paramVideoInfo != null)
    {
      str1 = paramVideoInfo.j;
      localObject3 = paramVideoInfo.jdField_a_of_type_JavaLangString;
      String str2 = paramVideoInfo.g;
      localObject1 = localObject2;
      if (paramVideoInfo.jdField_a_of_type_Int == 0)
      {
        localObject1 = localObject2;
        if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
          localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
      }
      localObject2 = localObject3;
      localObject3 = localObject1;
      localObject1 = str2;
    }
    for (;;)
    {
      this.a = new VideoR5((String)localObject3, str1, localObject2, (String)localObject1);
      if (paramVideoInfo != null) {
        a(paramVideoInfo.w);
      }
      return;
      localObject2 = null;
      str1 = null;
      localObject3 = null;
    }
  }
  
  public VideoR5$Builder(String paramString)
  {
    this.a = new VideoR5(paramString);
  }
  
  public VideoR5$Builder(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new VideoR5(paramString1, paramString2, paramString3, paramString4);
  }
  
  public VideoR5$Builder(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new VideoR5(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public VideoR5$Builder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new VideoR5(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (ReadInJoyHelper.m()) {
      return 0;
    }
    return 1;
  }
  
  public Builder A(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder B(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder C(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder D(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public Builder E(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder F(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 302;
    }
    for (;;)
    {
      this.a.a("source", Integer.valueOf(paramInt));
      return this;
      if ((paramInt == 1) || (paramInt == 3)) {
        paramInt = 300;
      } else if ((paramInt == 2) || (paramInt == 6)) {
        paramInt = 301;
      } else {
        paramInt = 310;
      }
    }
  }
  
  public Builder G(int paramInt)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localVideoR5.a("video_format", str);
      return this;
    }
  }
  
  public Builder H(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder I(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder J(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder K(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder L(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder M(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder N(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public Builder O(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder P(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder Q(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder R(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder S(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder T(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder U(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder V(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder W(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder X(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder Y(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder Z(int paramInt)
  {
    this.a.a("double_card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder a()
  {
    VideoR5 localVideoR5 = this.a;
    int i;
    if (RIJAppSetting.c()) {
      i = 2;
    }
    for (;;)
    {
      localVideoR5.a("app_type", Integer.valueOf(i));
      return this;
      if (RIJPushNotification.c()) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  public Builder a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder a(int paramInt, String paramString)
  {
    if (ReadInJoyHelper.g(paramInt)) {
      this.a.a("column_play_session_id", paramString);
    }
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder a(VideoInfo.SoftAdDownloadBarInfo paramSoftAdDownloadBarInfo)
  {
    VideoR5 localVideoR5 = this.a;
    if ((paramSoftAdDownloadBarInfo != null) && (paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) {}
    for (paramSoftAdDownloadBarInfo = paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramSoftAdDownloadBarInfo = "")
    {
      localVideoR5.a("ad_guide_area_video_report_info", paramSoftAdDownloadBarInfo);
      return this;
    }
  }
  
  public Builder a(VideoInfo paramVideoInfo)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo != null)) {
      this.a.a("corner_mark", Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.c));
    }
    return this;
  }
  
  public Builder a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mVideoColumnInfo != null) && (paramBaseArticleInfo.mChannelID == 56L))
    {
      if (!paramBoolean) {
        break label58;
      }
      paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo;
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.e == null)) {
        break label69;
      }
    }
    label58:
    label69:
    for (paramBaseArticleInfo = paramBaseArticleInfo.e;; paramBaseArticleInfo = "")
    {
      p(paramBaseArticleInfo);
      return this;
      paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.c;
      break;
    }
  }
  
  public Builder a(VideoColumnInfo paramVideoColumnInfo)
  {
    int i = 1;
    if (paramVideoColumnInfo != null)
    {
      this.a.a("is_column", Integer.valueOf(1));
      this.a.a("column_id", Integer.valueOf(paramVideoColumnInfo.jdField_a_of_type_Int));
      VideoR5 localVideoR5 = this.a;
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        localVideoR5.a("subscribe_flag", Integer.valueOf(i));
        return this;
        i = 0;
      }
    }
    this.a.a("is_column", Integer.valueOf(0));
    return this;
  }
  
  public Builder a(VideoRecommendManager paramVideoRecommendManager)
  {
    Builder localBuilder = this;
    if (paramVideoRecommendManager != null) {
      localBuilder = d(paramVideoRecommendManager.a());
    }
    return localBuilder;
  }
  
  public Builder a(VideoRecommendManager paramVideoRecommendManager, long paramLong)
  {
    Builder localBuilder = this;
    if (paramVideoRecommendManager != null) {
      localBuilder = c(paramVideoRecommendManager.a(paramLong));
    }
    return localBuilder;
  }
  
  public Builder a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public Builder a(String paramString)
  {
    VideoR5 localVideoR5 = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localVideoR5.a("video_report_info", str);
    return this;
  }
  
  public Builder a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public Builder a(ArrayList<DislikeInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      int j;
      for (int i = 1; paramArrayList.hasNext(); i = j)
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
        j = i;
        if (localDislikeInfo != null)
        {
          if (i == 0) {
            localStringBuilder.append("|");
          }
          j = 0;
          localStringBuilder.append(localDislikeInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
    return l(localStringBuilder.toString());
  }
  
  public Builder a(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localVideoR5.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public VideoR5 a()
  {
    return this.a;
  }
  
  public Builder aa(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder ab(int paramInt)
  {
    this.a.a("subscribe_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder ac(int paramInt)
  {
    this.a.a("return_sence", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder ad(int paramInt)
  {
    this.a.a("video_speed", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder ae(int paramInt)
  {
    this.a.a("topic_from_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder af(int paramInt)
  {
    this.a.a("follow_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder ag(int paramInt)
  {
    this.a.a("behavior_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (VideoFeedsHelper.e()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public Builder b(VideoColumnInfo paramVideoColumnInfo)
  {
    Builder localBuilder = this;
    if (paramVideoColumnInfo != null) {
      localBuilder = Y(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localBuilder;
  }
  
  public Builder b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("interact_button_style", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder c(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder c(BaseArticleInfo paramBaseArticleInfo)
  {
    Builder localBuilder = this;
    if (paramBaseArticleInfo != null)
    {
      localBuilder = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localBuilder = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localBuilder = b(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localBuilder;
  }
  
  public Builder c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (ReadInJoyHelper.e())
        {
          i = j;
          if (paramBaseArticleInfo.mVideoColumnInfo != null) {
            i = 2;
          }
        }
      }
    }
    this.a.a("video_feeds_type", Integer.valueOf(i));
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public Builder d(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localVideoR5.a("fans", str);
      return this;
    }
  }
  
  public Builder e(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(RIJTransMergeKanDianReport.a(paramBaseArticleInfo)));
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public Builder e(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder f(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (ReadInJoySrtHandler.a().a(paramBaseArticleInfo, false, ReadInJoySrtHandler.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(UGRuleManager.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public Builder f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public Builder f(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localVideoR5.a("video_code_format", str);
      return this;
    }
  }
  
  public Builder g(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder g(String paramString)
  {
    this.a.a("topic_id", paramString);
    return this;
  }
  
  public Builder g(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder h(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder h(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public Builder h(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localVideoR5.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder i(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder i(long paramLong)
  {
    this.a.a("duration", Long.valueOf(paramLong));
    return this;
  }
  
  public Builder i(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public Builder i(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder j(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder j(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public Builder j(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder k(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder k(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public Builder k(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("video_speed_icon", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder l(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder l(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public Builder l(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("is_play", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder m(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder m(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public Builder m(boolean paramBoolean)
  {
    VideoR5 localVideoR5 = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localVideoR5.a("UG", Integer.valueOf(i));
      return this;
    }
  }
  
  public Builder n(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder n(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public Builder o(int paramInt)
  {
    this.a.a("add_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder o(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public Builder p(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder p(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public Builder q(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder q(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public Builder r(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder r(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public Builder s(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder s(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public Builder t(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder u(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder v(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public Builder w(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder x(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder y(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public Builder z(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder
 * JD-Core Version:    0.7.0.1
 */