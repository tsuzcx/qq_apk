package com.tencent.biz.pubaccount.readinjoy.reward;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJUserLevelTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.IRIJRewardTaskTimingContract.IView;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoStatusListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.OnPlayStateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskVideoTimer;", "Lcom/tencent/biz/pubaccount/readinjoy/reward/IRIJRewardTaskTimer;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoStatusListener;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$OnPlayStateListener;", "()V", "curRowKey", "", "isResume", "", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingPresenter;", "kotlin.jvm.PlatformType", "getPresenter", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingPresenter;", "presenter$delegate", "Lkotlin/Lazy;", "afterVideoStart", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "attach", "activity", "Landroid/app/Activity;", "manager", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager;", "attachDebugView", "beforeVideoStart", "enabled", "onCompletion", "onPause", "onResume", "onStateChange", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;", "videoPlayerWrapper", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "oldState", "", "newState", "extra", "", "onVideoBufferEnd", "isPlaying", "onVideoBufferStart", "onVideoError", "model", "what", "errorMsg", "onVideoInitiate", "onVideoPause", "onVideoReplayOnLoop", "times", "onVideoRestart", "onVideoStop", "isCompleted", "startTiming", "rowKey", "maxTaskTimeInMs", "stopTiming", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskVideoTimer
  implements IRIJRewardTaskTimer, VideoFeedsPlayManager.VideoStatusListener, VideoPlayManager.OnPlayStateListener
{
  private String jdField_a_of_type_JavaLangString;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskVideoTimer.presenter.2.INSTANCE);
  private boolean jdField_a_of_type_Boolean;
  
  private final RIJRewardTaskTimingPresenter a()
  {
    return (RIJRewardTaskTimingPresenter)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final void h(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramVideoPlayParam == null) {
        break label121;
      }
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label121;
      }
      localObject = ((VideoInfo)localObject).g;
      if ((Intrinsics.areEqual(localObject, this.jdField_a_of_type_JavaLangString) ^ true)) {
        c();
      }
    }
    if (paramVideoPlayParam != null)
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localObject != null) && (((VideoInfo)localObject).c == true)) {}
    }
    else if (paramVideoPlayParam != null)
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).g;
        if (localObject != null)
        {
          paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
          if (paramVideoPlayParam == null) {
            break label127;
          }
        }
      }
    }
    label121:
    label127:
    for (long l = paramVideoPlayParam.b();; l = 0L)
    {
      a((String)localObject, (int)l);
      return;
      localObject = null;
      break;
    }
  }
  
  private final void i(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramVideoPlayParam == null) {
        break label41;
      }
      paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramVideoPlayParam == null) {
        break label41;
      }
    }
    label41:
    for (paramVideoPlayParam = paramVideoPlayParam.g;; paramVideoPlayParam = null)
    {
      if (Intrinsics.areEqual(paramVideoPlayParam, this.jdField_a_of_type_JavaLangString)) {
        c();
      }
      return;
    }
  }
  
  public final void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (!ReadInJoyHelper.k(ReadInJoyHelper.a())) {
      return;
    }
    Object localObject = paramActivity.findViewById(16908290);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    if (((ViewGroup)localObject).findViewById(2131376609) == null) {
      ((ViewGroup)localObject).addView(LayoutInflater.from((Context)paramActivity).inflate(2131562892, (ViewGroup)localObject, false));
    }
    paramActivity = (IRIJRewardTaskTimingContract.IView)new RIJRewardTaskVideoTimer.attachDebugView.view.1((TextView)((ViewGroup)localObject).findViewById(2131379733), (TextView)((ViewGroup)localObject).findViewById(2131363064), (TextView)((ViewGroup)localObject).findViewById(2131363065), (TextView)((ViewGroup)localObject).findViewById(2131379727), (TextView)((ViewGroup)localObject).findViewById(2131365502));
    a().a(paramActivity);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramVideoFeedsPlayManager, "manager");
    a(paramActivity);
    paramVideoFeedsPlayManager.a((VideoFeedsPlayManager.VideoStatusListener)this);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull VideoPlayManager paramVideoPlayManager)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramVideoPlayManager, "manager");
    a(paramActivity);
    paramVideoPlayManager.a((VideoPlayManager.OnPlayStateListener)this);
  }
  
  public void a(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    h(paramVideoPlayParam);
  }
  
  public void a(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt) {}
  
  public void a(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, @Nullable String paramString)
  {
    i(paramVideoPlayParam);
  }
  
  public void a(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    i(paramVideoPlayParam);
  }
  
  public void a(@Nullable VideoPlayManager.VideoPlayParam paramVideoPlayParam, @Nullable VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    if ((paramVideoPlayParam == null) || (paramVideoPlayParam.b)) {
      c();
    }
    do
    {
      return;
      if (paramInt2 == 3)
      {
        if ((this.jdField_a_of_type_JavaLangString != null) && ((Intrinsics.areEqual(paramVideoPlayParam.j, this.jdField_a_of_type_JavaLangString) ^ true))) {
          c();
        }
        paramVideoPlayParam = paramVideoPlayParam.j;
        Intrinsics.checkExpressionValueIsNotNull(paramVideoPlayParam, "playParam.videoArticleID");
        if (paramVideoPlayerWrapper != null) {}
        for (long l = paramVideoPlayerWrapper.b();; l = 0L)
        {
          a(paramVideoPlayParam, (int)l);
          return;
        }
      }
    } while ((paramInt1 != 3) || (this.jdField_a_of_type_JavaLangString == null) || (!Intrinsics.areEqual(paramVideoPlayParam.j, this.jdField_a_of_type_JavaLangString)));
    c();
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    if ((a()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      a().a(paramString, paramInt, 2);
    }
  }
  
  public boolean a()
  {
    return ((RIJRewardTaskConfig.a()) || (RIJUserLevelTimeUtils.a())) && (RIJXTabFrameUtils.a.a());
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    i(paramVideoPlayParam);
  }
  
  public void b(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    h(paramVideoPlayParam);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = ((String)null);
    a().a();
  }
  
  public void c(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    i(paramVideoPlayParam);
  }
  
  public void d(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    h(paramVideoPlayParam);
  }
  
  public void e(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void f(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void g(@Nullable VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    i(paramVideoPlayParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskVideoTimer
 * JD-Core Version:    0.7.0.1
 */