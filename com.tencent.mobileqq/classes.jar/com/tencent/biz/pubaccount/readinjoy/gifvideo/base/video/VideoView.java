package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSmartCropUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IStrategy;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.ErrorCode;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class VideoView
  extends FrameLayout
  implements VideoPlayController.OnStateChangeListener, Runnable
{
  public static final int MSG_FOR_UPDATE_VIDEO_PLAY_POSITION = -2;
  public static int PLAYMODE_AUTO = 1;
  public static int PLAYMODE_CLICK = 2;
  public static int PLAYMODE_DISABLE = 3;
  public static int PLAYMODE_SCROOL = 0;
  public static final int PROGRESS_REFRESH_INTERNAL = 100;
  private static Drawable mLoadingDrawable;
  private ArticleInfo articleInfo;
  private Runnable hideCoverRunnable = new VideoView.5(this);
  private int iconHeight;
  private int iconWidth;
  private boolean isManualPause;
  private boolean isPlayIconVisible = false;
  public int[] lastLocation = new int[2];
  private AtomicInteger mAction = new AtomicInteger(0);
  private Context mContext;
  private NativeReadInjoyImageView mCoverImageView;
  private String mCoverUrl;
  private VideoView.OnCheckShownListener mOnCheckShownListener;
  private VideoView.OnProgressChangedListener mOnProgressChangedListener;
  private NativeReadInjoyImageView mPlayIconImageView;
  private String mPlayIconUrl;
  protected Handler mProgressHandler = new Handler(Looper.getMainLooper());
  private AtomicInteger mState = new AtomicInteger(0);
  private String mVid;
  private String mVideoUrl;
  private IVideoView mVideoView;
  public boolean needInterceptGlobalLayoutChanged = false;
  private ObjectAnimator playCoverAnimator;
  private ObjectAnimator playIconAnimator;
  private int playMode = PLAYMODE_SCROOL;
  private List<String> reportList = new ArrayList();
  private Runnable showCoverRunnable = new VideoView.6(this);
  private boolean showVideoMask = true;
  private long startTime = 0L;
  public String suffix;
  public String tag = "ptsVideoView";
  private Handler uiHandler = new VideoView.2(this, Looper.myLooper());
  private boolean useVid = true;
  private View.OnClickListener videoCoverClickListener = new VideoView.4(this);
  private VideoMaskController videoMaskController;
  private VideoPlayController videoPlayController;
  private VideoPlayListener videoPlayListener;
  private View.OnClickListener videoViewClickListener = new VideoView.3(this);
  private FrameLayout videoViewLayout;
  private int xyAxis = 0;
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private static Drawable getLoadingDrawable()
  {
    if (mLoadingDrawable == null) {
      mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130851165);
    }
    return mLoadingDrawable;
  }
  
  private void hideCoverAnim()
  {
    if (this.mCoverImageView != null)
    {
      QLog.d(this.tag, 1, "hidecover alpha: " + this.mCoverImageView.getAlpha());
      if (this.playIconAnimator == null)
      {
        this.playIconAnimator = ObjectAnimator.ofFloat(this.mCoverImageView, "alpha", new float[] { 1.0F, 0.0F });
        this.playIconAnimator.setDuration(300L);
        this.playIconAnimator.addListener(new VideoView.7(this));
      }
      if (this.playCoverAnimator == null)
      {
        this.playCoverAnimator = this.playIconAnimator.clone();
        this.playCoverAnimator.setTarget(this.mPlayIconImageView);
      }
      this.playIconAnimator.start();
      this.playCoverAnimator.start();
    }
  }
  
  private void initVideoCover()
  {
    this.mCoverImageView = new NativeReadInjoyImageView(this.mContext);
    this.mCoverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mCoverImageView.setClipToOutline(true);
    }
    addView(this.mCoverImageView, -1, -1);
    this.mCoverImageView.setOnClickListener(this.videoCoverClickListener);
    setVideoCover();
  }
  
  private void initVideoFrameLayout()
  {
    if (this.videoViewLayout == null)
    {
      this.videoViewLayout = new FrameLayout(this.mContext);
      this.videoViewLayout.setContentDescription("videoviewFL");
      this.videoViewLayout.setBackgroundDrawable(getResources().getDrawable(2130841881));
      addView(this.videoViewLayout, -1, -1);
    }
  }
  
  private void initVideoMaskController()
  {
    if ((this.showVideoMask) && (this.videoMaskController == null))
    {
      this.videoMaskController = new VideoMaskController(getContext(), this, this.videoPlayController.a());
      this.videoMaskController.a(VideoMaskController.class.getSimpleName() + "." + this.suffix);
      this.videoMaskController.a().b().c().a(this.articleInfo);
    }
  }
  
  private void initVideoPlayIcon()
  {
    this.mPlayIconImageView = new NativeReadInjoyImageView(this.mContext);
    this.mPlayIconImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    if (this.iconWidth != 0) {
      ((FrameLayout.LayoutParams)localObject).width = this.iconWidth;
    }
    if (this.iconHeight != 0) {
      ((FrameLayout.LayoutParams)localObject).height = this.iconHeight;
    }
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.mPlayIconImageView, (ViewGroup.LayoutParams)localObject);
    localObject = this.mPlayIconImageView;
    if (shouldShowPlayIcon()) {}
    for (int i = 0;; i = 4)
    {
      ((NativeReadInjoyImageView)localObject).setVisibility(i);
      this.mPlayIconImageView.setImageResource(2130842886);
      setPlayIcon();
      return;
    }
  }
  
  private void initVideoView()
  {
    if ((this.mVideoView != null) && (this.mVideoView.a() != null))
    {
      this.mVideoView.a().setBackgroundColor(Color.parseColor("#000000"));
      this.videoViewLayout.removeAllViews();
      this.videoViewLayout.addView(this.mVideoView.a(), -1, -1);
      setClipChildren(false);
      ((ViewGroup)getParent()).setClipChildren(false);
      setVideoViewClickListener();
    }
  }
  
  private void onIdle()
  {
    displayCover();
    hideLoading();
  }
  
  private void removeHideCoverRunnable()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.hideCoverRunnable);
    if (this.playCoverAnimator != null) {
      this.playCoverAnimator.cancel();
    }
    if (this.playIconAnimator != null) {
      this.playIconAnimator.cancel();
    }
  }
  
  private void removeShowCoverRunnable()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.showCoverRunnable);
  }
  
  private void setPlayIcon()
  {
    if ((this.mPlayIconImageView != null) && (!TextUtils.isEmpty(this.mPlayIconUrl))) {}
    try
    {
      this.mPlayIconImageView.setImagePlaceHolder(getLoadingDrawable()).setImage(new URL(this.mPlayIconUrl));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void setVideoCover()
  {
    if ((this.mCoverImageView != null) && (!TextUtils.isEmpty(this.mCoverUrl))) {}
    try
    {
      ReadInJoyDisplayUtils.a(this.mCoverImageView, new URL(this.mCoverUrl), this.mContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean shouldShowPlayIcon()
  {
    return (this.isPlayIconVisible) && (!VideoPlayController.a.a());
  }
  
  public void clearVideoViewClick()
  {
    if ((this.mVideoView != null) && (this.mVideoView.a() != null)) {
      this.mVideoView.a().setOnClickListener(null);
    }
  }
  
  @UiThread
  public void destroy()
  {
    QLog.d(this.tag, 1, "destroy");
    this.videoPlayController.d();
  }
  
  public void displayCover()
  {
    removeHideCoverRunnable();
    removeShowCoverRunnable();
    if (RIJThreadHandler.a())
    {
      this.showCoverRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(this.showCoverRunnable);
  }
  
  public int getAction()
  {
    return this.videoPlayController.b().get();
  }
  
  public ArticleInfo getArticleInfo()
  {
    return this.articleInfo;
  }
  
  public int getCurrentState()
  {
    return this.videoPlayController.a().get();
  }
  
  public long getPercentage()
  {
    if (this.videoPlayController.a() != null) {
      return this.videoPlayController.a().b();
    }
    return 0L;
  }
  
  public int getPlayMode()
  {
    return this.playMode;
  }
  
  public String getVideoVid()
  {
    return this.mVid;
  }
  
  public IVideoView getVideoView()
  {
    return this.mVideoView;
  }
  
  public void hideCover()
  {
    removeHideCoverRunnable();
    removeShowCoverRunnable();
    ThreadManager.getUIHandler().post(this.hideCoverRunnable);
  }
  
  public void hideLoading()
  {
    QLog.d(this.tag, 1, "hideLoading");
    if (this.videoMaskController != null) {
      this.videoMaskController.m();
    }
  }
  
  public void hideVideoError()
  {
    QLog.d(this.tag, 1, "hideVideoError");
    if (this.videoMaskController != null) {
      this.videoMaskController.k();
    }
  }
  
  public void init()
  {
    this.suffix = (new Random().nextInt() + "");
    this.tag = (this.tag + "." + this.suffix);
    this.mContext = getContext();
    setClickable(true);
    setBackgroundColor(Color.parseColor("#000000"));
    initVideoFrameLayout();
    initVideoCover();
    initVideoPlayIcon();
    initPTSVideoPlayManager();
    initVideoMaskController();
  }
  
  public void initPTSVideoPlayManager()
  {
    this.videoPlayController = new VideoPlayController(this, this.mState, this.mAction);
    this.videoPlayController.g(this.suffix);
    this.videoPlayController.a(this);
  }
  
  public boolean isMute()
  {
    return this.videoPlayController.a();
  }
  
  public boolean isPlaying()
  {
    return this.videoPlayController.a().get() == 7;
  }
  
  public boolean isShown()
  {
    if (this.mOnCheckShownListener != null) {
      return (super.isShown()) && (this.mOnCheckShownListener.a());
    }
    return super.isShown();
  }
  
  @UiThread
  public void onComplete() {}
  
  @UiThread
  public void onDestroy()
  {
    QLog.d(this.tag, 2, "onDestroy");
    removeShowCoverRunnable();
    removeHideCoverRunnable();
    hideLoading();
    if ((this.mVideoView != null) && (this.mVideoView.a() != null)) {
      removeView(this.mVideoView.a());
    }
    this.isManualPause = false;
    this.mVideoView = null;
    this.mVideoUrl = "";
    this.mCoverUrl = "";
    this.videoPlayListener = null;
    removePlayProgressMessage();
    if (this.videoMaskController != null) {
      this.videoMaskController.c();
    }
    this.videoPlayController.b(this);
  }
  
  @UiThread
  public void onError()
  {
    hideLoading();
    String str1 = ErrorCode.a(this.videoPlayController.b(), this.videoPlayController.c(), this.videoPlayController.a());
    String str2 = HardCodeUtil.a(2131716256);
    QLog.d(this.tag, 1, "errorMsg: " + str1);
    showVideoError(1, str1, str2);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    setVideoCover();
    setPlayIcon();
  }
  
  @UiThread
  public void onInit()
  {
    initVideoView();
    this.videoPlayController.b(this.xyAxis);
    if (this.videoMaskController != null)
    {
      this.videoMaskController.a(this.videoPlayController.a());
      this.videoMaskController.a();
    }
  }
  
  @UiThread
  public void onPause()
  {
    removePlayProgressMessage();
    if (this.videoMaskController != null) {
      this.videoMaskController.i();
    }
  }
  
  @UiThread
  public void onPlay()
  {
    postPlayProgressMessage();
    hideCover();
    hideLoading();
    if (this.mOnProgressChangedListener != null) {
      this.mProgressHandler.postDelayed(this, 500L);
    }
    if (this.videoMaskController != null) {
      this.videoMaskController.h();
    }
    postPlayProgressMessage();
    hideVideoError();
  }
  
  public void onScrollFromList(boolean paramBoolean)
  {
    if (this.playMode == PLAYMODE_AUTO)
    {
      if ((paramBoolean) && (this.mAction.get() != 3)) {
        startPlay();
      }
      if ((!paramBoolean) && (this.mAction.get() != 6)) {
        stop();
      }
    }
  }
  
  @UiThread
  public void onSeekComplete()
  {
    if (this.mOnProgressChangedListener != null) {
      this.mProgressHandler.postDelayed(this, 500L);
    }
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new VideoView.1(this, paramInt2));
  }
  
  @UiThread
  public void onStop()
  {
    displayCover();
    this.mProgressHandler.removeCallbacksAndMessages(null);
    if (this.videoMaskController != null) {
      this.videoMaskController.b();
    }
    removePlayProgressMessage();
    hideLoading();
    if (this.mVideoView != null) {
      this.mVideoView.b();
    }
    if (this.videoPlayListener != null) {
      this.videoPlayListener.b();
    }
  }
  
  public void openVideo()
  {
    ThreadManager.getSubThreadHandler().post(new VideoView.8(this));
  }
  
  @UiThread
  public void pause()
  {
    QLog.d(this.tag, 2, "pause");
    this.videoPlayController.b();
  }
  
  public void postPlayProgressMessage()
  {
    removePlayProgressMessage();
    if (this.uiHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = -2;
      this.uiHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void removePlayProgressMessage()
  {
    if (this.uiHandler != null) {
      this.uiHandler.removeMessages(-2);
    }
  }
  
  public void requestUrlByVid(IStrategy paramIStrategy, IStrategy.URLCallback paramURLCallback)
  {
    this.videoPlayController.a(paramIStrategy, paramURLCallback);
  }
  
  public void resetVideoMaskController()
  {
    if (this.videoMaskController != null) {
      this.videoMaskController.d();
    }
  }
  
  @UiThread
  public void resume()
  {
    this.videoPlayController.c();
  }
  
  public void run()
  {
    long l2;
    if (this.mOnProgressChangedListener != null)
    {
      this.mProgressHandler.postDelayed(this, 500L);
      l2 = 0L;
    }
    try
    {
      l1 = this.videoPlayController.a().b();
      this.mOnProgressChangedListener.a(l1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e(this.tag, 2, "run: " + QLog.getStackTraceString(localException));
          l1 = l2;
        }
      }
    }
  }
  
  public void setArticleInfo(ArticleInfo paramArticleInfo)
  {
    this.articleInfo = paramArticleInfo;
    if ((paramArticleInfo != null) && (paramArticleInfo.mTitle != null))
    {
      String str = paramArticleInfo.mTitle.substring(0, Math.min(paramArticleInfo.mTitle.length(), 2));
      this.tag = ("ptsVideoView." + this.suffix + "." + str);
      this.videoPlayController.g(this.tag);
    }
    if (this.videoMaskController != null) {
      this.videoMaskController.a(paramArticleInfo);
    }
    this.videoPlayController.a(paramArticleInfo);
    this.videoPlayController.a(this);
  }
  
  @Deprecated
  public void setAutoPlayMode(int paramInt) {}
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
    if ((getHeight() > 0) && (getHeight() > 0)) {
      this.mCoverUrl = RIJSmartCropUtils.a(this.mCoverUrl, getWidth(), getHeight());
    }
    setVideoCover();
  }
  
  public void setDtPgid(String paramString)
  {
    this.videoPlayController.e(paramString);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.videoPlayController.a(paramBoolean);
  }
  
  public void setManualPause(boolean paramBoolean)
  {
    this.isManualPause = paramBoolean;
    this.videoPlayController.c(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.videoPlayController.b(paramBoolean);
  }
  
  public void setOnCheckShownListener(VideoView.OnCheckShownListener paramOnCheckShownListener)
  {
    this.mOnCheckShownListener = paramOnCheckShownListener;
  }
  
  public void setOnProgressChangedListener(VideoView.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.mOnProgressChangedListener = paramOnProgressChangedListener;
  }
  
  public void setPlayIconSize(int paramInt1, int paramInt2)
  {
    this.iconWidth = Utils.dp2px(paramInt1);
    this.iconHeight = Utils.dp2px(paramInt2);
    if (this.mPlayIconImageView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mPlayIconImageView.getLayoutParams();
      localLayoutParams.width = this.iconWidth;
      localLayoutParams.height = this.iconHeight;
      this.mPlayIconImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setPlayIconUrl(String paramString)
  {
    this.mPlayIconUrl = paramString;
    setPlayIcon();
  }
  
  public void setPlayIconVisible(boolean paramBoolean)
  {
    this.isPlayIconVisible = paramBoolean;
    NativeReadInjoyImageView localNativeReadInjoyImageView;
    if (this.mPlayIconImageView != null)
    {
      localNativeReadInjoyImageView = this.mPlayIconImageView;
      if (!shouldShowPlayIcon()) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 4)
    {
      localNativeReadInjoyImageView.setVisibility(i);
      return;
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    this.playMode = paramInt;
  }
  
  public void setReportR5(String paramString)
  {
    this.videoPlayController.f(paramString);
  }
  
  public void setScaleType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        this.videoPlayController.b(paramInt);
        return;
      }
      finally {}
      paramInt = 1;
      continue;
      paramInt = 2;
    }
  }
  
  public void setShowVideoMask(boolean paramBoolean)
  {
    this.showVideoMask = paramBoolean;
  }
  
  public void setUseVid(boolean paramBoolean)
  {
    this.useVid = paramBoolean;
  }
  
  public void setVideoBusiType(int paramInt)
  {
    this.videoPlayController.a(paramInt);
  }
  
  public void setVideoPlayListener(VideoPlayListener paramVideoPlayListener)
  {
    this.videoPlayController.a(paramVideoPlayListener);
  }
  
  public void setVideoUrl(String paramString)
  {
    this.mVideoUrl = paramString;
    this.videoPlayController.a(this.mVideoUrl);
  }
  
  public void setVideoVid(String paramString)
  {
    try
    {
      if ((this.mVid != null) && (!TextUtils.equals(this.mVid, paramString))) {
        displayCover();
      }
      this.mVid = paramString;
      this.videoPlayController.b(paramString);
      return;
    }
    finally {}
  }
  
  public void setVideoView(IVideoView paramIVideoView)
  {
    this.mVideoView = paramIVideoView;
  }
  
  public void setVideoViewClickListener()
  {
    if ((this.mVideoView != null) && (this.mVideoView.a() != null)) {
      this.mVideoView.a().setOnClickListener(this.videoViewClickListener);
    }
  }
  
  public void showLoading()
  {
    QLog.d(this.tag, 1, "showLoading");
    if (this.videoMaskController != null) {
      this.videoMaskController.l();
    }
    this.mPlayIconImageView.setVisibility(4);
  }
  
  public void showVideoError(int paramInt, String paramString1, String paramString2)
  {
    QLog.d(this.tag, 1, new Object[] { "showVideoError: " + paramInt, paramString1, paramString2 });
    if (this.videoMaskController != null) {
      this.videoMaskController.a(paramInt, paramString1, paramString2);
    }
  }
  
  @UiThread
  public boolean startPlay()
  {
    return startPlay(3);
  }
  
  public boolean startPlay(int paramInt)
  {
    QLog.d(this.tag, 2, "receive startPlay");
    this.videoPlayController.c(paramInt);
    return true;
  }
  
  @UiThread
  public void stop()
  {
    QLog.d(this.tag, 2, "receive stop current action is " + this.mAction.get());
    setManualPause(false);
    this.videoPlayController.a();
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.videoPlayController != null) {
      this.videoPlayController.d(paramInt);
    }
  }
  
  public void updateSeekBarImmediately()
  {
    IPlayer localIPlayer = this.videoPlayController.a();
    if ((localIPlayer != null) && (this.videoMaskController != null))
    {
      long l1 = localIPlayer.b();
      long l2 = localIPlayer.a();
      int i = Math.min((int)((float)l1 * 100.0F / (float)l2 + 0.5D) + 1, 100);
      this.videoMaskController.a().setProgress(i);
      this.videoPlayController.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView
 * JD-Core Version:    0.7.0.1
 */