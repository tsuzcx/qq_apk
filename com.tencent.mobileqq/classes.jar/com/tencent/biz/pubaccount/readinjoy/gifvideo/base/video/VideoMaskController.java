package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoReportUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.MsgLayoutHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoMaskController;", "", "context", "Landroid/content/Context;", "rootView", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "videoPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "hideVideoMaskRunnable", "Ljava/lang/Runnable;", "<set-?>", "", "isSeeking", "()Z", "lastProgress", "", "lastX", "lastY", "Landroid/widget/ImageButton;", "loadingButton", "getLoadingButton", "()Landroid/widget/ImageButton;", "maskShowDuration", "", "msgLayoutHelper", "Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/MsgLayoutHelper;", "getMsgLayoutHelper", "()Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/MsgLayoutHelper;", "setMsgLayoutHelper", "(Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/MsgLayoutHelper;)V", "Lcom/tencent/biz/pubaccount/readinjoy/proteus/view/impl/NativeReadInjoyImageView;", "muteButton", "getMuteButton", "()Lcom/tencent/biz/pubaccount/readinjoy/proteus/view/impl/NativeReadInjoyImageView;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Landroid/widget/ImageView;", "playIcon", "getPlayIcon", "()Landroid/widget/ImageView;", "retryClickListener", "Landroid/view/View$OnClickListener;", "getRetryClickListener", "()Landroid/view/View$OnClickListener;", "setRetryClickListener", "(Landroid/view/View$OnClickListener;)V", "rootVideoView", "Landroid/widget/SeekBar;", "seekBar", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarChangeListener", "com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoMaskController$seekBarChangeListener$1", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoMaskController$seekBarChangeListener$1;", "showLoadingProgressRunnable", "getShowLoadingProgressRunnable", "()Ljava/lang/Runnable;", "speedRatio", "", "speedRatioButton", "getSpeedRatioButton", "tvSeekTime", "Landroid/widget/TextView;", "getTvSeekTime", "()Landroid/widget/TextView;", "setTvSeekTime", "(Landroid/widget/TextView;)V", "vid", "videoControlMask", "Landroid/widget/FrameLayout;", "getVideoControlMask", "()Landroid/widget/FrameLayout;", "setVideoControlMask", "(Landroid/widget/FrameLayout;)V", "videoMaskContainer", "getVideoMaskContainer", "setVideoMaskContainer", "getVideoPlayer", "()Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "setVideoPlayer", "(Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;)V", "volumeChangeReceiver", "Landroid/content/BroadcastReceiver;", "changeSeekbarStyle", "", "useCircleBar", "doOnDestroy", "expandTouchArea", "view", "Landroid/view/View;", "top", "bottom", "hideLoading", "hideMask", "hideSeekTime", "hideVideoError", "initArticleInfo", "initMuteButton", "initSeekBar", "initSpeedRatioButton", "initVolumeChangeReceiver", "notifyVideoViewProgress", "progress", "onInit", "onPauseVideo", "onStartPlayVideo", "onStop", "reportSeekBar", "resetMuteButtonUI", "resetSeekBar", "resetSeekTimeTextView", "resetUI", "resumePlayVideo", "seekPlayer", "setSeekTimeTextView", "shouldIntercept", "parent", "Landroid/view/ViewGroup;", "v", "event", "Landroid/view/MotionEvent;", "px", "showLoading", "showMask", "showSeekTime", "showVideoError", "msgType", "msg", "btnText", "showVideoMask", "showVideoMaskForAWhile", "showMillis", "switchMuteState", "switchSpeedRatio", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoMaskController
{
  public static final VideoMaskController.Companion a;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  @NotNull
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = (View.OnClickListener)new VideoMaskController.retryClickListener.1(this);
  @NotNull
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = (View.OnTouchListener)new VideoMaskController.onTouchListener.1(this);
  @NotNull
  public FrameLayout a;
  @NotNull
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  @NotNull
  public TextView a;
  private final VideoMaskController.seekBarChangeListener.1 jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoMaskController$seekBarChangeListener$1 = new VideoMaskController.seekBarChangeListener.1(this);
  private VideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
  @NotNull
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  @Nullable
  private IPlayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
  @NotNull
  public MsgLayoutHelper a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "VideoMaskController";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @NotNull
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  @NotNull
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  @NotNull
  private final Runnable jdField_b_of_type_JavaLangRunnable = (Runnable)new VideoMaskController.showLoadingProgressRunnable.1(this);
  private String jdField_b_of_type_JavaLangString = "";
  private int c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoMaskController$Companion = new VideoMaskController.Companion(null);
  }
  
  public VideoMaskController(@NotNull Context paramContext, @NotNull VideoView paramVideoView, @Nullable IPlayer paramIPlayer)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560502, null);
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext);
    paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131367066);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…yId(R.id.fl_control_mask)");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext);
    paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131377460);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…Id(R.id.sb_play_progress)");
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext);
    paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131380589);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findViewById(R.id.tv_seek_time)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131369732);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…ById(R.id.iv_mute_button)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)paramContext);
    paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131369819);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…id.iv_speed_ratio_button)");
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)paramContext);
    paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131370735);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…ById(R.id.loading_button)");
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramContext);
    paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131373253);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findViewById(R.id.play_icon)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView = paramVideoView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer = paramIPlayer;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper = new MsgLayoutHelper((View)this.jdField_b_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramVideoView.addView((View)this.jdField_b_of_type_AndroidWidgetFrameLayout);
    d();
  }
  
  private final void a(int paramInt)
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localVideoView.updateProgress(paramInt);
  }
  
  private final void a(long paramLong)
  {
    v();
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new VideoMaskController.showVideoMaskForAWhile.1(this));
    }
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.postDelayed(localRunnable, paramLong);
    }
  }
  
  private final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof View))) {
      ((View)localViewParent).post((Runnable)new VideoMaskController.expandTouchArea..inlined.let.lambda.1(localViewParent, this, paramView, paramFloat1, paramFloat2));
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (((VideoView)localObject).getContext() != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      ((SeekBar)localObject).setSelected(paramBoolean);
    }
  }
  
  private final void n()
  {
    this.jdField_a_of_type_Boolean = true;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(0);
  }
  
  private final void o()
  {
    this.jdField_a_of_type_Boolean = false;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(8);
  }
  
  private final void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
    if (localObject != null)
    {
      SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
      if (localSeekBar == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      int i = localSeekBar.getProgress();
      long l = ((IPlayer)localObject).a();
      if (l > 0L) {
        ((IPlayer)localObject).a((int)((float)(l * i) / 100.0F), 3);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      ((VideoView)localObject).startPlay();
    }
  }
  
  private final void q()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = ((BroadcastReceiver)new VideoMaskController.initVolumeChangeReceiver.1(this));
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[initVolumeChangeReceiver]");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.ACTION_DOWN_AUDIO_BUTTON");
      VideoView localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private final void r()
  {
    boolean bool = VideoAudioControlUtil.a.b();
    if (bool) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130843214);
    }
    for (;;)
    {
      VideoView localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.setMute(bool);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130843215);
    }
  }
  
  private final void s()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    boolean bool3 = ((VideoView)localObject).isMute();
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("[switchMuteState] isMute: ").append(bool3).append(" to ");
    if (!bool3)
    {
      bool1 = true;
      QLog.i((String)localObject, 1, bool1);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      if (bool3) {
        break label147;
      }
    }
    label147:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((VideoView)localObject).setMute(bool1);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      if (!((VideoView)localObject).isMute()) {
        break label152;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130843214);
      return;
      bool1 = false;
      break;
    }
    label152:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130843215);
  }
  
  private final void t()
  {
    StringBuilder localStringBuilder = new StringBuilder("[switchSpeedRatio] speedRatio:  " + this.jdField_a_of_type_Float + " to ");
    this.jdField_a_of_type_Float += 0.5F;
    if (Float.compare(this.jdField_a_of_type_Float, 2.0F) > 0) {
      this.jdField_a_of_type_Float = 1.0F;
    }
    localStringBuilder.append(this.jdField_a_of_type_Float);
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(this.jdField_a_of_type_Float);
    }
    if (Float.compare(this.jdField_a_of_type_Float, 1.5F) == 0) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130842889);
    }
    for (;;)
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, localStringBuilder.toString());
      return;
      if (Float.compare(this.jdField_a_of_type_Float, 2.0F) == 0) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130842892);
      } else {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130842891);
      }
    }
  }
  
  private final void u()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
    }
    localFrameLayout.setVisibility(8);
    a(false);
  }
  
  private final void v()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
    }
    localFrameLayout.setVisibility(0);
    a(true);
  }
  
  private final void w()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    v();
  }
  
  private final void x()
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (!localVideoView.isPlaying())
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[resumePlayVideo]");
      localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.resume();
      localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.setManualPause(false);
    }
  }
  
  @NotNull
  public final ImageButton a()
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    return localImageButton;
  }
  
  @NotNull
  public final SeekBar a()
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    return localSeekBar;
  }
  
  @NotNull
  public final VideoMaskController a()
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoMaskController$seekBarChangeListener$1);
    return this;
  }
  
  @NotNull
  public final VideoMaskController a(@Nullable ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    return this;
  }
  
  @NotNull
  public final NativeReadInjoyImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  }
  
  @Nullable
  public final IPlayer a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localObject = ((VideoView)localObject).getVideoView();
    if (localObject != null)
    {
      localObject = ((IVideoView)localObject).a();
      if (localObject != null) {
        ((View)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    a((View)localObject, 5.0F, 15.0F);
    a((View)this.jdField_b_of_type_AndroidWidgetFrameLayout, 0.0F, 15.0F);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    a((View)localObject, 0.0F, 15.0F);
    d();
    q();
  }
  
  public final void a(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "msg");
    Intrinsics.checkParameterIsNotNull(paramString2, "btnText");
    u();
    MsgLayoutHelper localMsgLayoutHelper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper;
    if (localMsgLayoutHelper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("msgLayoutHelper");
    }
    localMsgLayoutHelper.a(paramInt, paramString1, paramString2);
  }
  
  public final void a(@Nullable IPlayer paramIPlayer)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer = paramIPlayer;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final VideoMaskController b()
  {
    View.OnClickListener localOnClickListener = (View.OnClickListener)new VideoMaskController.initMuteButton.muteClickListener.1(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(localOnClickListener);
    return this;
  }
  
  public final void b()
  {
    d();
    Object localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    ((SeekBar)localObject).setOnSeekBarChangeListener(null);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localObject = ((VideoView)localObject).getVideoView();
    if (localObject != null)
    {
      localObject = ((IVideoView)localObject).a();
      if (localObject != null) {
        ((View)localObject).setOnTouchListener(null);
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    ((SeekBar)localObject).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @NotNull
  public final VideoMaskController c()
  {
    View.OnClickListener localOnClickListener = (View.OnClickListener)new VideoMaskController.initSpeedRatioButton.speedRatioClickListener.1(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setOnClickListener(localOnClickListener);
    return this;
  }
  
  public final void c()
  {
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[doOnDestroy]");
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver != null) {}
    try
    {
      VideoView localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.getContext().unregisterReceiver(localBroadcastReceiver);
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[doOnDestroy] unregisterReceiver.");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[doOnDestroy] e = " + localException);
      }
    }
  }
  
  public final void d()
  {
    r();
    e();
    g();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageResource(2130842891);
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(this.jdField_a_of_type_Float);
    }
    u();
    k();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public final void e()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(8);
    localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setText((CharSequence)"");
  }
  
  public final void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject != null)
    {
      int i = ((ArticleInfo)localObject).getVideoDuration();
      localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      int j = ((SeekBar)localObject).getProgress() * i / 100;
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
      }
      ((TextView)localObject).setText((CharSequence)(ReadInJoyDisplayUtils.a(j) + " / " + ReadInJoyDisplayUtils.a(i)));
    }
  }
  
  public final void g()
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setPressed(false);
    localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setProgress(0);
    localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setVisibility(8);
    localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setOnSeekBarChangeListener(null);
  }
  
  public final void h()
  {
    r();
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    a();
    a(this.jdField_a_of_type_Long);
  }
  
  public final void i()
  {
    r();
    w();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public final void j()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
      if (localObject2 != null)
      {
        localObject2 = VideoReportUtil.a.a((ArticleInfo)localObject1, ((IPlayer)localObject2).b());
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).b("video_progress_control_way", "1");
        localObject1 = VideoReportUtil.a;
        localObject2 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "r5Builder.build()");
        ((VideoReportUtil)localObject1).a("", "0X800B3D8", (String)localObject2);
      }
    }
  }
  
  public final void k()
  {
    MsgLayoutHelper localMsgLayoutHelper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackMsgLayoutHelper;
    if (localMsgLayoutHelper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("msgLayoutHelper");
    }
    localMsgLayoutHelper.a();
  }
  
  public final void l()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
  }
  
  public final void m()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    localImageButton.clearAnimation();
    localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    localImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController
 * JD-Core Version:    0.7.0.1
 */