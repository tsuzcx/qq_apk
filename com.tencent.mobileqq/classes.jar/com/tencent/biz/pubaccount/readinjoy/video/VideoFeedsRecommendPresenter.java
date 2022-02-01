package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertConfig;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.PlayInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.VideoFeedsAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoStatusListener;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView$ListEventListener;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsVideoUIDelegate$CallBack;", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "playManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;", "recyclerView", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;", "isLoopPlayMode", "", "videoDataList", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/VideoInfo;", "videoFromType", "", "(Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;ZLjava/util/ArrayList;I)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "setApp", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getBundle", "()Landroid/os/Bundle;", "dynamicInsertProgress", "getDynamicInsertProgress", "()I", "firstVideoInfo", "getFirstVideoInfo", "()Lcom/tencent/biz/pubaccount/VideoInfo;", "hasRequestDynamicInsert", "getHasRequestDynamicInsert", "()Z", "setHasRequestDynamicInsert", "(Z)V", "<set-?>", "isFullScreen", "isKingCardUser", "isTikTokStyle", "lastResumeTimeStamp", "", "lastStayDuration", "lastVideoItemHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "mEventHandler", "Landroid/os/Handler;", "getMEventHandler", "()Landroid/os/Handler;", "mFirstVideoPlayerSessionId", "", "mHasJumpColumnPage", "mKandianMode", "mKandianModeNew", "mPlayInfoListForReport", "Lcom/tencent/biz/pubaccount/readinjoy/video/report/PlayInfoForReport;", "mRecommendManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendManager;", "mUpglideCount", "mVideoAdFetchManager", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdExposureManager;", "onColumnActionObserver", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "getPlayManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;", "playingVideoInfo", "getPlayingVideoInfo", "playingVideoItemHolder", "getPlayingVideoItemHolder", "()Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "playingVideoParams", "getPlayingVideoParams", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "reporter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter;", "getReporter", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter;", "speedRatioIndex", "getSpeedRatioIndex", "getVideoDataList", "()Ljava/util/ArrayList;", "getVideoFromType", "afterVideoStart", "", "playParam", "beforeVideoStart", "doOnPause", "doOnResume", "doWhenJumpColumnPage", "handlePlayButtonClick", "handleSpeedRatioBtnClick", "isDynamicInsertEnable", "onCenterViewChanged", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onCenterViewIdle", "onChangeScreenOrientation", "onCompletion", "onDestroyView", "onLoadMore", "onProgressChanged", "currentMillisTime", "duration", "onSeekBarDragEnd", "onVideoBufferEnd", "isPlaying", "onVideoBufferStart", "onVideoError", "model", "what", "errorMsg", "onVideoInitiate", "onVideoPause", "onVideoReplayOnLoop", "times", "onVideoRestart", "onVideoStop", "isCompleted", "recordDynamicInsertAction", "action", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "recordDynamicInsertExposuedVideo", "list", "reportDtOnVideoEnd", "isComplete", "reportDtOnVideoLoop", "reportDtOnVideoStart", "reportOnCreate", "reportUpglideCount", "reportUseDuration", "resetSpeedRatio", "resumePlayWhenBackFromColumnPage", "setRecommendManager", "recommendManager", "setVideoAdFetchManager", "videoAdExposureManager", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter
  implements VideoFeedsPlayManager.VideoStatusListener, VideoFeedsRecyclerView.ListEventListener, VideoFeedsVideoUIDelegate.CallBack
{
  public static final VideoFeedsRecommendPresenter.Companion a;
  @NotNull
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 1.5F, 2.0F };
  @NotNull
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130850002, 2130850001, 2130850003 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @Nullable
  private Activity jdField_a_of_type_AndroidAppActivity;
  @NotNull
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  @NotNull
  private final Handler jdField_a_of_type_AndroidOsHandler;
  @Nullable
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private final ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver;
  @Nullable
  private VideoFeedsPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
  @NotNull
  private final VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager;
  @NotNull
  private final VideoFeedsReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter;
  private BaseVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
  private VideoAdExposureManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager;
  @Nullable
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private final ArrayList<PlayInfoForReport> jdField_a_of_type_JavaUtilArrayList;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  @NotNull
  private final VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  @Nullable
  private BaseVideoItemHolder jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
  @NotNull
  private final ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private final boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int;
  private final boolean jdField_f_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter$Companion = new VideoFeedsRecommendPresenter.Companion(null);
  }
  
  public VideoFeedsRecommendPresenter(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @Nullable QQAppInterface paramQQAppInterface, @NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager, @NotNull VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean, @NotNull ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (CUKingCardHelper.a() == 1)
    {
      paramBoolean = true;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = ((ReadInJoyObserver)new VideoFeedsRecommendPresenter.onColumnActionObserver.1(this));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a((VideoFeedsPlayManager.VideoStatusListener)this);
      paramVideoFeedsRecyclerView.a((VideoFeedsRecyclerView.ListEventListener)this);
      paramActivity = this.jdField_b_of_type_JavaUtilArrayList.get(0);
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "videoDataList[0]");
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)paramActivity);
      this.jdField_a_of_type_Int = ReadInJoyUtils.a();
      this.jdField_b_of_type_Int = VideoReporter.a();
      paramActivity = this.jdField_a_of_type_AndroidAppActivity;
      paramInt = i;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getIntent();
        paramInt = i;
        if (paramActivity != null) {
          paramInt = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        }
      }
      this.jdField_a_of_type_Boolean = ReadInJoyHelper.d();
      if ((paramInt == 4) || (paramInt == 5) || (paramInt == 2) || (paramInt == 1)) {
        this.jdField_a_of_type_Int = 5;
      }
    }
    try
    {
      paramActivity = this.jdField_a_of_type_AndroidAppActivity;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getWindow();
        if (paramActivity != null) {
          paramActivity.addFlags(128);
        }
      }
    }
    catch (Exception paramActivity)
    {
      label293:
      break label293;
    }
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null) {}
    }
    for (paramActivity = paramActivity.getStringExtra("video_player_session_id");; paramActivity = null)
    {
      this.jdField_a_of_type_JavaLangString = paramActivity;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter = new VideoFeedsReporter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, this);
      this.jdField_e_of_type_Int = RIJFeedsDynamicInsertConfig.a.a(6);
      ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.1(this), 16, null, true);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void c(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (paramVideoPlayParam != null) {}
    for (paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;; paramVideoPlayParam = null)
    {
      VideoDTReport.a(paramVideoPlayParam);
      return;
    }
  }
  
  private final void h(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    int j = 2;
    if (paramVideoPlayParam != null) {}
    for (Object localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper; localObject == null; localObject = null) {
      return;
    }
    boolean bool = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean)
    {
      i = 1;
      localObject = VideoDTReport.Builder.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("6").b(i).a(paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index", -1));
      VideoPlayerWrapper localVideoPlayerWrapper = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      Intrinsics.checkExpressionValueIsNotNull(localVideoPlayerWrapper, "playParam.videoPlayer");
      localObject = ((VideoDTReport.Builder)localObject).b(localVideoPlayerWrapper.b());
      localVideoPlayerWrapper = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      Intrinsics.checkExpressionValueIsNotNull(localVideoPlayerWrapper, "playParam.videoPlayer");
      localObject = ((VideoDTReport.Builder)localObject).d(localVideoPlayerWrapper.a()).a(bool);
      if (!this.jdField_f_of_type_Boolean) {
        break label175;
      }
    }
    label175:
    for (int i = j;; i = 1)
    {
      localObject = ((VideoDTReport.Builder)localObject).d(i);
      VideoDTReport.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, (VideoDTReport.Builder)localObject);
      return;
      i = 2;
      break;
    }
  }
  
  private final void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    int i;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        i = ((Intent)localObject).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        if (localObject == null) {
          break label147;
        }
        localObject = ((Activity)localObject).getIntent();
        if (localObject == null) {
          break label147;
        }
      }
    }
    label147:
    for (int j = ((Intent)localObject).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; j = 0)
    {
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
      String str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.j;
      VideoR5.Builder localBuilder = new VideoR5.Builder(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
      localBuilder.M(0).X(i).o((String)localObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, str, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", (String)localObject, localBuilder.a().a(), false);
      return;
      i = 0;
      break;
    }
  }
  
  private final void k()
  {
    Object localObject3 = null;
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    for (;;)
    {
      try
      {
        Object localObject4 = new VideoR5.Builder(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).M(0);
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
          break label201;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject1 != null)
        {
          localObject1 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
          localObject4 = ((VideoR5.Builder)localObject4).b((VideoColumnInfo)localObject1).b(this.jdField_b_of_type_Long).u(this.jdField_f_of_type_Int);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localObject1 == null) {
            break label206;
          }
          localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
          localObject4 = ((VideoR5.Builder)localObject4).m((String)localObject1).a();
          IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
            localObject1 = localObject3;
            if (localVideoInfo != null) {
              localObject1 = localVideoInfo.j;
            }
            localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, (String)localObject1, "0X800AF2E", "0X800AF2E", 0, 0, "", "", "", ((VideoR5)localObject4).a(), false);
            return;
          }
          localObject1 = "";
          continue;
        }
        localObject2 = null;
      }
      catch (Exception localException)
      {
        return;
      }
      continue;
      label201:
      Object localObject2 = null;
      continue;
      label206:
      localObject2 = null;
    }
  }
  
  private final void l()
  {
    VideoR5.Builder localBuilder;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    AppInterface localAppInterface;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      localBuilder = new VideoR5.Builder(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localBuilder.P(this.jdField_c_of_type_Int);
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localAppInterface = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label96;
      }
    }
    label96:
    for (Object localObject = ((VideoInfo)localObject).j;; localObject = null)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, (String)localObject, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localBuilder.a().a(), false);
      return;
    }
  }
  
  private final void m()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      if (localObject == null) {
        break label55;
      }
    }
    label55:
    for (Object localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;; localObject = null)
    {
      localVideoFeedsPlayManager.a((VideoFeedsPlayManager.VideoPlayParam)localObject, false);
      return;
    }
  }
  
  public void E_() {}
  
  public final int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @Nullable
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @Nullable
  public final VideoFeedsPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
  }
  
  @NotNull
  public final VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  @NotNull
  public final VideoFeedsReporter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter;
  }
  
  @Nullable
  public final BaseVideoItemHolder a()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
  }
  
  @Nullable
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController;
    if ((d()) && (!this.jdField_e_of_type_Boolean) && (paramLong1 >= this.jdField_e_of_type_Int))
    {
      localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.a;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label78;
      }
    }
    label78:
    for (Object localObject = ((VideoInfo)localObject).g;; localObject = null)
    {
      localRIJFeedsDynamicInsertController.a((String)localObject, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_NONE, 0, 0, 0, 14, null), 6);
      this.jdField_e_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    BaseVideoItemHolder localBaseVideoItemHolder = null;
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    if ((paramViewHolder instanceof BaseVideoItemHolder))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = ((BaseVideoItemHolder)paramViewHolder);
      paramViewHolder = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = paramViewHolder;
        VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        paramViewHolder = localBaseVideoItemHolder;
        if (localVideoPlayParam != null) {
          paramViewHolder = localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramViewHolder;
        paramViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        if (paramViewHolder != null)
        {
          paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
          if (paramViewHolder != null) {
            paramViewHolder.i();
          }
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null))
      {
        paramViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
        if (paramViewHolder != null)
        {
          localBaseVideoItemHolder = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
          if ((localBaseVideoItemHolder != null) && (paramViewHolder.jdField_c_of_type_Int > localBaseVideoItemHolder.jdField_c_of_type_Int)) {
            this.jdField_c_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder);
      d();
      return;
      paramViewHolder = null;
      break;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = ((BaseVideoItemHolder)null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = ((VideoFeedsPlayManager.VideoPlayParam)null);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)null);
    }
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final void a(@NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController;
    if (d())
    {
      localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.a;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label41;
      }
    }
    label41:
    for (Object localObject = ((VideoInfo)localObject).g;; localObject = null)
    {
      localRIJFeedsDynamicInsertController.a((String)localObject, paramRIJFeedsInsertAction, 6);
      return;
    }
  }
  
  public void a(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  public void a(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
    {
      Object localObject = new PlayInfoForReport();
      ((PlayInfoForReport)localObject).jdField_a_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(true);
      VideoPlayerWrapper localVideoPlayerWrapper = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      Intrinsics.checkExpressionValueIsNotNull(localVideoPlayerWrapper, "playParam.videoPlayer");
      ((PlayInfoForReport)localObject).jdField_b_of_type_Long = localVideoPlayerWrapper.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + ((PlayInfoForReport)localObject).jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + ((PlayInfoForReport)localObject).jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter$Companion, paramVideoPlayParam)) && (this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        VideoFeedsAdReportUtils.a(paramVideoPlayParam, (Context)this.jdField_a_of_type_AndroidAppActivity, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
      }
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      if (localObject != null)
      {
        paramInt = ((BaseVideoItemHolder)localObject).jdField_c_of_type_Int;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager;
        if (localObject != null) {
          ((VideoAdExposureManager)localObject).b(paramInt, paramVideoPlayParam, this.jdField_b_of_type_JavaUtilArrayList);
        }
      }
    }
  }
  
  public void a(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
  }
  
  public void a(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    int i;
    Object localObject2;
    long l1;
    label81:
    List localList;
    if (localObject1 != null)
    {
      i = ((BaseVideoItemHolder)localObject1).jdField_c_of_type_Int;
      localObject1 = new PlayInfoForReport();
      if (!paramBoolean) {
        break label238;
      }
      localObject2 = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
      l1 = ((VideoPlayerWrapper)localObject2).b();
      ((PlayInfoForReport)localObject1).jdField_b_of_type_Long = l1;
      ((PlayInfoForReport)localObject1).jdField_a_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      localList = (List)new ArrayList((Collection)this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      localObject1 = localObject2;
      if (!(localObject2 instanceof ShortVideoItemHolder)) {
        localObject1 = null;
      }
      localObject1 = (ShortVideoItemHolder)localObject1;
      if (localObject1 == null) {
        break label262;
      }
      localObject1 = ((ShortVideoItemHolder)localObject1).d;
      if ((localObject1 == null) || (((TextView)localObject1).getVisibility() != 0)) {
        break label262;
      }
    }
    label262:
    for (boolean bool = true;; bool = false)
    {
      if (localVideoInfo != null) {
        ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.onVideoStop..inlined.let.lambda.1(localVideoInfo, this, localList, paramVideoPlayParam, l2, i, bool), 16, null, true);
      }
      c(paramVideoPlayParam, paramBoolean);
      return;
      i = 0;
      break;
      label238:
      localObject2 = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
      l1 = ((VideoPlayerWrapper)localObject2).a();
      break label81;
    }
  }
  
  public final void a(@Nullable VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = paramVideoFeedsRecommendManager;
  }
  
  public final void a(@Nullable VideoAdExposureManager paramVideoAdExposureManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager = paramVideoAdExposureManager;
  }
  
  public final void a(@NotNull ArrayList<VideoInfo> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((VideoInfo)paramArrayList.next()).g);
    }
    RIJFeedsDynamicInsertController.a.a((List)localArrayList);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public final void b()
  {
    int i = 0;
    Object localObject1;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null)
    {
      localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      if (localObject1 != null)
      {
        localObject1 = ((BaseVideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
        label27:
        if (localObject1 == null) {
          break label157;
        }
      }
    }
    label157:
    for (Object localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
        i = ((VideoPlayerWrapper)localObject2).b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "handlePlayButtonClick() status()=" + i);
      }
      switch (i)
      {
      default: 
        return;
        localObject1 = null;
        break label27;
        localObject1 = null;
        break label27;
      }
    }
    if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter$Companion, (VideoFeedsPlayManager.VideoPlayParam)localObject1)) && (localObject1 != null))
    {
      localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (localObject2 != null) {
        ((ReadinjoyAdVideoReportData)localObject2).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a((VideoFeedsPlayManager.VideoPlayParam)localObject1, false);
    return;
    if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter$Companion, (VideoFeedsPlayManager.VideoPlayParam)localObject1)) && (localObject1 != null))
    {
      localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (localObject2 != null) {
        ((ReadinjoyAdVideoReportData)localObject2).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((VideoFeedsPlayManager.VideoPlayParam)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a((VideoFeedsPlayManager.VideoPlayParam)localObject1, true);
    return;
    String str1;
    if (localObject1 != null)
    {
      localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localObject2 != null) && (((VideoInfo)localObject2).jdField_a_of_type_Int == 0) && (((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
        str1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      }
    }
    for (;;)
    {
      try
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject2 == null) {
          continue;
        }
        str2 = ((VideoInfo)localObject2).j;
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((VideoInfo)localObject2).g;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((VideoInfo)localObject2).g;
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((VideoInfo)localObject3).j;
        if (localObject1 == null) {
          continue;
        }
        localObject4 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject4 == null) {
          continue;
        }
        localObject4 = ((VideoInfo)localObject4).jdField_a_of_type_JavaLangString;
        if (localObject1 == null) {
          continue;
        }
        localObject5 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject5 == null) {
          continue;
        }
        localObject5 = ((VideoInfo)localObject5).g;
        long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject1 == null) {
          continue;
        }
        i = ((VideoInfo)localObject1).a();
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X800740D", "0X800740D", 0, 0, "", "", (String)localObject2, VideoReporter.a(str1, (String)localObject3, (String)localObject4, (String)localObject5, l, i * 1000, new JSONObject().put("video_type", 0)), false);
      }
      catch (Exception localException)
      {
        String str2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        boolean bool;
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
      str1 = null;
      continue;
      str2 = null;
      continue;
      localObject2 = null;
      continue;
      localObject2 = null;
      continue;
      localObject2 = "0";
      continue;
      localObject3 = null;
      continue;
      localObject4 = null;
      continue;
      localObject5 = null;
      continue;
      i = 0;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    return;
    if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter$Companion, (VideoFeedsPlayManager.VideoPlayParam)localObject1)) && (localObject1 != null))
    {
      localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (localObject2 != null) {
        ((ReadinjoyAdVideoReportData)localObject2).jdField_a_of_type_Boolean = false;
      }
    }
    if (localObject1 != null) {}
    for (bool = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).a("continue_pause", false); !bool; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    return;
    if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter$Companion, (VideoFeedsPlayManager.VideoPlayParam)localObject1)) && (localObject1 != null))
    {
      localObject1 = ((VideoFeedsPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (localObject1 != null) {
        ((ReadinjoyAdVideoReportData)localObject1).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
  }
  
  public void b(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void b(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  public final boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public final void c()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    l();
    k();
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)null);
  }
  
  public void c(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  public final boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public final void d()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(jdField_a_of_type_ArrayOfFloat[0]);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null)
    {
      Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      if (localObject != null)
      {
        localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate;
        if (localObject != null) {
          ((IVideoFeedsItemUIDelegate)localObject).b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        }
      }
    }
  }
  
  public void d(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager != null))
    {
      VideoAdExposureManager localVideoAdExposureManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoStrategyVideoAdExposureManager;
      if (localVideoAdExposureManager != null) {
        localVideoAdExposureManager.a(((BaseVideoItemHolder)localObject).jdField_c_of_type_Int, paramVideoPlayParam, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString))
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      if (localObject != null) {
        ((VideoPlayerWrapper)localObject).b(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaLangString = ((String)null);
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      BridgeModule.addRowkeyToConsumeMap(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public final boolean d()
  {
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    return (localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.jdField_b_of_type_Int == 0) && (this.jdField_f_of_type_Int == 3);
  }
  
  public final void e()
  {
    int i;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder != null)
    {
      i = this.jdField_d_of_type_Int;
      if (i < jdField_a_of_type_ArrayOfFloat.length - 1) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      float f1 = jdField_a_of_type_ArrayOfFloat[i];
      this.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(f1);
      Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
      if (localObject != null)
      {
        localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate;
        if (localObject != null) {
          ((IVideoFeedsItemUIDelegate)localObject).b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        }
      }
      return;
      label76:
      i += 1;
    }
  }
  
  public void e(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.a(paramVideoPlayParam);
  }
  
  public final boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public final void f()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void f(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    h(paramVideoPlayParam);
  }
  
  public final void g()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void g(@NotNull VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  public final void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    m();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsReporter.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter
 * JD-Core Version:    0.7.0.1
 */