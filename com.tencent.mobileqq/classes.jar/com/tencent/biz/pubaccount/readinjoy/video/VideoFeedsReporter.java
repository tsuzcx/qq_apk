package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LocationInfo;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.report.PlayInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter;", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "firstVideoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "(Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/biz/pubaccount/VideoInfo;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;)V", "autoSeekBarDragTimes", "", "exposeVidSet", "Ljava/util/HashSet;", "", "firstVideoExposureR5", "Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder;", "fromType", "isReplayFromVideoChannel", "", "isTiktokStyle", "isWeiShiMode", "kandianMode", "kandianModeNew", "pageSessionId", "kotlin.jvm.PlatformType", "playingVideoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "playingVideoInfo", "sessionID", "videoChannelSessionID", "doColumnBannerExposeReport", "", "videoInfo", "doLocationExposeReport", "doReportOnCenterViewChanged", "holder", "isVideoRealChanged", "doReportOnVideoInitiate", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "doReportOnVideoStop", "reportList", "", "Lcom/tencent/biz/pubaccount/readinjoy/video/report/PlayInfoForReport;", "reportData", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;", "duration", "", "recommendIndex", "isShowYourFollowed", "doRichTitleExposureReport", "doSpeedRatioBtnReport", "action", "innerDoReportOnCenterViewChanged", "position", "recommendPosition", "itemType", "isLiveAvatorShow", "isFollowBtnShow", "isShareBtnShow", "innerReportVideoExposure", "r5", "innerSeekBarDrag", "way", "onAutoSeekBarDrag", "onAutoSeekBarEndTouchUp", "onAutoSeekBarTouchOn", "onCenterViewChanged", "viewHolder", "onDestory", "onFollowBtnRerport", "isClick", "isFollowed", "onLiveAvatorExposue", "onLiveAvatorReport", "onSeekBaarDragEnd", "reportRewardBtnAction", "info", "reportShareBtnEvent", "iconType", "tryReportFirstVideoExposure", "updateDtReportInfo", "videoPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "videoReportInfo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsReporter
{
  public static final VideoFeedsReporter.Companion a;
  private final int jdField_a_of_type_Int;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private final VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter;
  private VideoR5.Builder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReportVideoR5$Builder;
  private BaseVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
  private final String jdField_a_of_type_JavaLangString;
  private final HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private final boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private final String jdField_b_of_type_JavaLangString;
  private final boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private final String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter$Companion = new VideoFeedsReporter.Companion(null);
  }
  
  public VideoFeedsReporter(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @NotNull VideoInfo paramVideoInfo, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter;
    this.jdField_b_of_type_Int = VideoReporter.a();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARGS_SESSION_ID");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.jdField_a_of_type_Boolean = ReadInJoyHelper.d();
    this.jdField_c_of_type_Int = paramBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("ARGS_PAGE_SESSION_ID");
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    int i;
    int j;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        i = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        j = k;
        if (i != 4)
        {
          j = k;
          if (i != 5)
          {
            j = k;
            if (i != 2)
            {
              if (i != 1) {
                break label266;
              }
              j = k;
            }
          }
        }
        label186:
        this.jdField_a_of_type_Int = j;
        long l = paramBundle.getLong("VIDEO_PLAY_POSITION", 0L);
        if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3) && (this.jdField_c_of_type_Int != 6) && (this.jdField_c_of_type_Int != 7)) {
          break label274;
        }
        i = 1;
        label238:
        if ((l <= 0L) || (i == 0)) {
          break label280;
        }
      }
    }
    label266:
    label274:
    label280:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      i = 0;
      break;
      j = ReadInJoyUtils.a();
      break label186;
      i = 0;
      break label238;
    }
  }
  
  private final void a(int paramInt)
  {
    Object localObject = new VideoR5.Builder(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("video_progress_control_way", Integer.valueOf(paramInt));
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (localVideoInfo != null) {}
    for (paramInt = localVideoInfo.jdField_d_of_type_Int;; paramInt = 0)
    {
      localObject = ((VideoR5.Builder)localObject).i(paramInt * 1000L).M(0).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B3D8", "0X800B3D8", 0, 0, "", "", "", ((VideoR5)localObject).a(), false);
      return;
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    String str2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
    String str1 = paramVideoInfo.jdField_a_of_type_JavaLangString;
    Object localObject4 = paramVideoInfo.g;
    Object localObject2;
    label64:
    Object localObject3;
    label122:
    VideoR5.Builder localBuilder;
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject1 == null) {
        break label811;
      }
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 == null) {
        break label811;
      }
      int i = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int j = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int k = ((Intent)localObject1).getIntExtra("RETURN_SCENE", 0);
      localObject3 = VideoAutoPlayController.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "VideoAutoPlayController.getInstance()");
      if (!((VideoAutoPlayController)localObject3).c()) {
        break label823;
      }
      localObject3 = "1";
      localBuilder = new VideoR5.Builder((String)localObject2, str2, str1, (String)localObject4).e(paramVideoInfo.f).c(paramVideoInfo.s).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).g(i).a(409409).l(paramInt2).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.w).e(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).J(paramVideoInfo.l).K(j).n(0).j(paramVideoInfo.jdField_j_of_type_Boolean).n(paramVideoInfo.t).b(this.jdField_a_of_type_Boolean).ac(k).a(this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString).M(0);
      if (paramBoolean3)
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label831;
        }
        localObject2 = localObject4;
        label308:
        localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str2, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), (String)localObject3, (String)localObject2, localBuilder.a().a(), false);
      }
      i = ((Intent)localObject1).getIntExtra("VIDEO_FROM_TYPE", -1);
      localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
      j = ((Intent)localObject1).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      localBuilder.u(i).h((String)localObject2).E(j).M(0).L(MultiVideoConfigHandler.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int));
      localBuilder.v(((Intent)localObject1).getIntExtra("key_source", -1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "exposed video [video_from_type : " + i + ", first_video_row_key : " + (String)localObject2 + ", first_video_type : " + j + "]");
      }
      if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
        localBuilder.H(((Intent)localObject1).getIntExtra("VIDEO_CHAT_TYPE", 0)).I(((Intent)localObject1).getIntExtra("VIDEO_KANDIAN_TYPE", 0)).k(((Intent)localObject1).getStringExtra("VIDEO_CHAT_UIN"));
      }
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str1))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(str1);
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramVideoInfo.w != null)) {
          break label839;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReportVideoR5$Builder = localBuilder;
        label595:
        if ((paramInt3 == 2) && (paramVideoInfo.a()))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label849;
          }
          localObject2 = "0X8009489";
          label620:
          localObject3 = new VideoR5.Builder(null, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).a(409409).a(paramVideoInfo.w).u(((Intent)localObject1).getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          localObject4 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          str1 = paramVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
            break label857;
          }
        }
      }
    }
    label811:
    label823:
    label831:
    label839:
    label849:
    label857:
    for (Object localObject1 = paramVideoInfo.g;; localObject1 = "0")
    {
      ((IPublicAccountReportUtils)localObject4).publicAccountReportClickEvent(null, str1, (String)localObject2, (String)localObject2, 0, 0, "", "", (String)localObject1, (String)localObject3, false);
      d(paramVideoInfo);
      e(paramVideoInfo);
      if (paramBoolean1) {
        a(paramVideoInfo);
      }
      if (paramBoolean2) {
        a(paramVideoInfo, "0X800B1A6", false, paramVideoInfo.jdField_q_of_type_Boolean);
      }
      if (paramVideoInfo.p) {
        a(paramVideoInfo, "0X800B2EA");
      }
      if (paramBoolean4) {
        a(this, paramVideoInfo, "0X800B941", 0, 4, null);
      }
      return;
      localObject2 = null;
      break;
      localObject1 = new Intent();
      break label64;
      localObject3 = "0";
      break label122;
      localObject2 = "0";
      break label308;
      a(paramVideoInfo, localBuilder);
      break label595;
      localObject2 = "0X8009484";
      break label620;
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, VideoR5.Builder paramBuilder)
  {
    int i = 1;
    if (paramBuilder == null) {
      return;
    }
    String str;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {}
      for (localObject1 = paramVideoInfo.g;; localObject1 = "0")
      {
        ((IPublicAccountReportUtils)localObject2).videoDataReportWithFansInfoInR5(null, str, "0X8009298", "0X8009298", 0, 0, "0", "", (String)localObject1, paramBuilder.a().a(), false);
        c(paramVideoInfo, "0X800AD00");
        if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList == null) || (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        c(paramVideoInfo);
        return;
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ShortVideoItemHolder)) {
      localObject1 = null;
    }
    localObject1 = (ShortVideoItemHolder)localObject1;
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((ShortVideoItemHolder)localObject1).e;
      if ((localObject1 != null) && (((TextView)localObject1).getVisibility() == 0))
      {
        bool = true;
        label179:
        if ((TextUtils.isEmpty((CharSequence)paramVideoInfo.u)) || (!VideoFeedsHelper.e())) {
          break label314;
        }
        label198:
        paramBuilder.S(i).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).b(this.jdField_a_of_type_Boolean).a(paramVideoInfo, bool).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo);
        localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str = paramVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
          break label319;
        }
      }
    }
    label314:
    label319:
    for (localObject1 = paramVideoInfo.g;; localObject1 = "0")
    {
      ((IPublicAccountReportUtils)localObject2).videoDataReportWithFansInfoInR5(null, str, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, paramBuilder.a().a(), false);
      break;
      bool = false;
      break label179;
      i = 0;
      break label198;
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, String paramString, int paramInt)
  {
    VideoR5 localVideoR5 = new VideoR5.Builder(paramVideoInfo).i(paramVideoInfo.g).b(this.jdField_a_of_type_Boolean).a("is_viola", Integer.valueOf(0)).a("icon_type", Integer.valueOf(paramInt)).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, paramVideoInfo.g, "", "", localVideoR5.a(), false);
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.e == 1))
    {
      paramVideoInfo = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).M(0).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", paramVideoInfo.a(), false);
    }
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    String str2;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    String str1;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo != null)
    {
      str2 = new VideoR5.Builder("", paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).i(paramVideoInfo.g).a().a();
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label109;
      }
      str1 = "1";
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label116;
      }
    }
    label109:
    label116:
    for (paramVideoInfo = "";; paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X800B4CE", "0X800B4CE", 0, 0, str1, paramVideoInfo, "", str2, false);
      return;
      str1 = "2";
      break;
    }
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReportVideoR5$Builder != null) {
      ThreadManager.excute((Runnable)new VideoFeedsReporter.onDestory.1(this), 16, null, true);
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    ThreadManager.excute((Runnable)new VideoFeedsReporter.onLiveAvatorExposue.1(this, paramVideoInfo), 16, null, true);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @Nullable String paramString)
  {
    int i = 1;
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    Object localObject = new VideoR5.Builder(paramVideoInfo).a("video_mode", Integer.valueOf(1));
    if (paramVideoInfo.o) {
      i = 3;
    }
    localObject = ((VideoR5.Builder)localObject).a("status", Integer.valueOf(i)).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, paramVideoInfo.g, "", "", ((VideoR5)localObject).a(), false);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    int i;
    Object localObject2;
    label120:
    String str;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 != null)
      {
        i = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        localObject2 = new VideoR5.Builder(paramVideoInfo).a().a("scene_type", Integer.valueOf(3)).i(paramVideoInfo.g).e(paramVideoInfo.f).c(paramVideoInfo.s).K(i).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
        if (!paramVideoInfo.jdField_b_of_type_Boolean) {
          break label267;
        }
        localObject1 = paramVideoInfo.jdField_j_of_type_JavaLangString;
        localObject2 = ((VideoR5.Builder)localObject2).a("ugcuin", localObject1);
        if (!paramBoolean1) {
          break label273;
        }
        localObject1 = "click_type";
        label141:
        if (!paramBoolean2) {
          break label281;
        }
        i = 2;
        label149:
        localObject1 = ((VideoR5.Builder)localObject2).a((String)localObject1, Integer.valueOf(i));
        if (!paramBoolean1) {
          break label293;
        }
        if (!paramBoolean2) {
          break label287;
        }
        i = 1;
        label175:
        ((VideoR5.Builder)localObject1).a("click_type", Integer.valueOf(i));
        localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str = paramVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
          break label324;
        }
      }
    }
    label267:
    label273:
    label281:
    label287:
    label293:
    label324:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      ((IPublicAccountReportUtils)localObject2).videoDataReportWithFansInfoInR5(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, ((VideoR5.Builder)localObject1).a().a(), false);
      return;
      localObject1 = new Intent();
      break;
      localObject1 = null;
      break label120;
      localObject1 = "button_type";
      break label141;
      i = 1;
      break label149;
      i = 2;
      break label175;
      if (paramBoolean2) {}
      for (i = 2;; i = 1)
      {
        ((VideoR5.Builder)localObject1).a("button_type", Integer.valueOf(i));
        break;
      }
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull List<? extends PlayInfoForReport> paramList, @NotNull ReadinjoyVideoReportData paramReadinjoyVideoReportData, long paramLong, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramList, "reportList");
    Intrinsics.checkParameterIsNotNull(paramReadinjoyVideoReportData, "reportData");
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject2;
    String str2;
    label85:
    int n;
    int i1;
    int j;
    label116:
    int i3;
    int k;
    label207:
    int m;
    label229:
    PlayInfoForReport localPlayInfoForReport;
    int i;
    label328:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((Activity)localObject1).getIntent();
      if (localObject2 != null)
      {
        str2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
        String str3 = paramVideoInfo.jdField_a_of_type_JavaLangString;
        String str1 = paramVideoInfo.g;
        if ((paramVideoInfo.jdField_a_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label1005;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        n = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i1 = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.jdField_c_of_type_Boolean) {
          break label1011;
        }
        j = 1;
        this.jdField_c_of_type_Boolean = false;
        int i2 = ((Intent)localObject2).getIntExtra("key_source", -1);
        i3 = ((Intent)localObject2).getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = ((Intent)localObject2).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = ((Intent)localObject2).getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = ((Intent)localObject2).getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str4 = ((Intent)localObject2).getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty((CharSequence)paramVideoInfo.u)) || (!VideoFeedsHelper.e())) {
          break label1017;
        }
        k = 1;
        int i7 = ((Intent)localObject2).getIntExtra("RETURN_SCENE", 0);
        int i8 = paramList.size();
        m = 0;
        if (m >= i8) {
          return;
        }
        localPlayInfoForReport = (PlayInfoForReport)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsReporter", 2, "播放VV上报 totalPlayTime = " + localPlayInfoForReport.a + ", currentPlayTime = " + localPlayInfoForReport.b);
        }
        if ((localPlayInfoForReport.b != 0L) || (localPlayInfoForReport.a != 0L))
        {
          if (m != 0) {
            break label1023;
          }
          i = 0;
          localObject2 = new VideoR5.Builder((String)localObject1, str2, str3, str1).d(localPlayInfoForReport.a).a(localPlayInfoForReport.b).x(i).y(i8 - 1).v(i2).A(paramReadinjoyVideoReportData.n).z(paramReadinjoyVideoReportData.m).C(paramReadinjoyVideoReportData.l).B(paramReadinjoyVideoReportData.k).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.w).e(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).e(paramVideoInfo.f).c(paramVideoInfo.s).D(j).J(paramVideoInfo.l).E(i4).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).u(i3).K(i1).i(false).n(0).j(paramVideoInfo.jdField_j_of_type_Boolean).n(paramVideoInfo.t).S(k).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).L(MultiVideoConfigHandler.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).M(0).b(this.jdField_a_of_type_Boolean).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).ac(i7).k(PlayerHelper.a.a());
          if (!paramBoolean) {
            break label1045;
          }
          i = 1;
          label640:
          localObject2 = ((VideoR5.Builder)localObject2).a("is_show_followed", Integer.valueOf(i)).a(this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString);
          if (this.jdField_c_of_type_Int == 32) {
            ((VideoR5.Builder)localObject2).o(paramVideoInfo.jdField_q_of_type_Int);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            ((VideoR5.Builder)localObject2).H(i5).I(i6).k(str4);
          }
          localObject3 = ((VideoR5.Builder)localObject2).a().a();
          if (TextUtils.isEmpty((CharSequence)str1)) {
            break label1051;
          }
          localObject2 = str1;
          label809:
          if (!this.jdField_b_of_type_Boolean) {
            break label1059;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, str2, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), (String)localObject2, (String)localObject3, false);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8009297", str2, String.valueOf(n), String.valueOf(i1), "", (String)localObject3);
        }
      }
    }
    for (;;)
    {
      localObject2 = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_d_of_type_Int = ((int)localPlayInfoForReport.b);
      ((ReportInfo.VideoExtraRepoerData)localObject2).e = ((int)paramLong);
      ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_b_of_type_Boolean = true;
      localObject3 = VideoAutoPlayController.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "VideoAutoPlayController.getInstance()");
      ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_a_of_type_Boolean = ((VideoAutoPlayController)localObject3).c();
      ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_b_of_type_Int = n;
      ((ReportInfo.VideoExtraRepoerData)localObject2).f = i3;
      VideoReporter.b(paramVideoInfo, i1, 12, (int)localPlayInfoForReport.a, (ReportInfo.VideoExtraRepoerData)localObject2, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
      m += 1;
      break label229;
      localObject2 = new Intent();
      break;
      label1005:
      localObject1 = null;
      break label85;
      label1011:
      j = -1;
      break label116;
      label1017:
      k = 0;
      break label207;
      label1023:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.e())
      {
        i = 2;
        break label328;
      }
      i = 1;
      break label328;
      label1045:
      i = 0;
      break label640;
      label1051:
      localObject2 = "0";
      break label809;
      label1059:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, str2, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), (String)localObject2, (String)localObject3, false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007409", str2, String.valueOf(n), String.valueOf(i1), "", (String)localObject3);
    }
  }
  
  public final void a(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {}
    for (VideoInfo localVideoInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; localVideoInfo = null)
    {
      if ((localVideoInfo != null) && (!this.jdField_b_of_type_Boolean)) {
        VideoReporter.b(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      return;
    }
  }
  
  public final void a(@Nullable VideoPlayerWrapper paramVideoPlayerWrapper, @Nullable String paramString)
  {
    VideoDTReport.a(paramVideoPlayerWrapper, paramString);
  }
  
  public final void a(@Nullable BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = paramBaseVideoItemHolder;
    if (paramBaseVideoItemHolder != null)
    {
      paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if (paramBaseVideoItemHolder == null) {}
    }
    for (paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; paramBaseVideoItemHolder = null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramBaseVideoItemHolder;
      return;
    }
  }
  
  public final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    Object localObject1 = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    int i;
    int j;
    int k;
    boolean bool1;
    label65:
    boolean bool2;
    if (localObject1 != null)
    {
      localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      i = paramBaseVideoItemHolder.jdField_b_of_type_Int;
      j = paramBaseVideoItemHolder.jdField_c_of_type_Int;
      k = paramBaseVideoItemHolder.jdField_a_of_type_Int;
      if ((!(paramBaseVideoItemHolder instanceof ShortVideoItemHolder)) || (((ShortVideoItemHolder)paramBaseVideoItemHolder).a.getVisibility() != 0)) {
        break label183;
      }
      bool1 = true;
      if (!(paramBaseVideoItemHolder instanceof VideoItemHolder)) {
        break label189;
      }
      Object localObject2 = ((VideoItemHolder)paramBaseVideoItemHolder).a;
      if (localObject2 == null) {
        break label189;
      }
      localObject2 = ((IVideoFeedsFollowButton)localObject2).a();
      if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0)) {
        break label189;
      }
      bool2 = true;
      label111:
      if (!(paramBaseVideoItemHolder instanceof VideoItemHolder)) {
        break label195;
      }
      paramBaseVideoItemHolder = ((VideoItemHolder)paramBaseVideoItemHolder).q;
      if ((paramBaseVideoItemHolder == null) || (paramBaseVideoItemHolder.getVisibility() != 0)) {
        break label195;
      }
    }
    label183:
    label189:
    label195:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (localObject1 != null) {
        ThreadManager.post((Runnable)new VideoFeedsReporter.doReportOnCenterViewChanged..inlined.also.lambda.1(this, (VideoInfo)localObject1, i, j, k, bool1, bool2, paramBoolean, bool3), 1, null, true);
      }
      return;
      localObject1 = null;
      break;
      bool1 = false;
      break label65;
      bool2 = false;
      break label111;
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (localVideoInfo != null) {
      a(localVideoInfo, paramString, paramInt);
    }
  }
  
  public final void b()
  {
    this.jdField_d_of_type_Int += 1;
  }
  
  public final void b(@Nullable VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReportVideoR5$Builder != null))
    {
      VideoR5.Builder localBuilder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReportVideoR5$Builder;
      if (localBuilder != null) {
        localBuilder.a(paramVideoInfo.w);
      }
      a(paramVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReportVideoR5$Builder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReportVideoR5$Builder = ((VideoR5.Builder)null);
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    VideoR5 localVideoR5 = new VideoR5.Builder(paramVideoInfo).e(paramVideoInfo.f).i(paramVideoInfo.g).a("live_circle_from_page", Integer.valueOf(2)).a();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, localVideoR5.a(), false);
      return;
    }
  }
  
  public final void c()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  public final void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList != null) && (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.iterator();
      label137:
      while (localIterator.hasNext())
      {
        Object localObject1 = (VideoInfo.RichTitleInfo)localIterator.next();
        if (((VideoInfo.RichTitleInfo)localObject1).jdField_a_of_type_Int == 1)
        {
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter$Companion.a(paramVideoInfo);
        }
        else
        {
          Object localObject2 = ((VideoInfo.RichTitleInfo)localObject1).jdField_b_of_type_JavaLangString;
          if (localObject2 != null)
          {
            if (((CharSequence)localObject2).length() > 0) {}
            for (int i = 1;; i = 0)
            {
              if (i != 1) {
                break label137;
              }
              localObject2 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter$Companion;
              localObject1 = ((VideoInfo.RichTitleInfo)localObject1).jdField_b_of_type_JavaLangString;
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.topicId");
              ((VideoFeedsReporter.Companion)localObject2).b(paramVideoInfo, (String)localObject1);
              break;
            }
          }
        }
      }
    }
  }
  
  public final void c(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).i;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
        if (localObject == null) {
          break label173;
        }
      }
    }
    label173:
    for (localObject = ((BaseVideoItemHolder)localObject).i;; localObject = null)
    {
      VideoFeedsHelper.a(localObject, paramVideoInfo, "click_speed");
      paramVideoInfo = new VideoR5.Builder(paramVideoInfo).ad(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a()).b(this.jdField_a_of_type_Boolean).c(paramVideoInfo.jdField_d_of_type_Int).M(0).a(paramVideoInfo.w).L(MultiVideoConfigHandler.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", paramVideoInfo.a(), false);
      return;
    }
  }
  
  public final void d()
  {
    int i = 3;
    if (this.jdField_d_of_type_Int < 3) {
      i = 4;
    }
    a(i);
    this.jdField_d_of_type_Int = 0;
  }
  
  public final void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.b())
    {
      a(2);
      return;
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsReporter
 * JD-Core Version:    0.7.0.1
 */