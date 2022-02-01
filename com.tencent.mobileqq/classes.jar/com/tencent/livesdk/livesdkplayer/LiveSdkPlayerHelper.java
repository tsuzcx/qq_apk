package com.tencent.livesdk.livesdkplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.livesdk.livesdkplayer.network.NetWorkManager;
import com.tencent.livesdk.livesdkplayer.network.NetWorkReceiver.OnNetworkCallback;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import com.tencent.thumbplayer.api.report.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.TPVodReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class LiveSdkPlayerHelper
  implements ThreadCenter.HandlerKeyable, NetWorkReceiver.OnNetworkCallback
{
  private static final int DELAY_TIME = 1000;
  private static final int GET_GAP_FRAME_MSG = 100;
  private static final int GET_GAP_TIME = 2000;
  private static final int MAX_RETRY_TIME = 3;
  private static final int NETWORK_STATE_3G4G = 102;
  private static final int NETWORK_STATE_CLOSED = 100;
  private static final int NETWORK_STATE_WIFI = 101;
  private static final String SDK_TYPE = "thumbsdk";
  private static final String SDK_VERSION = "2.5.1.98";
  private static final String TAG = "LiveSdkPlayerHelper";
  private boolean isEnableSwitchScreen = false;
  private boolean isFloatPlayerModel = false;
  private boolean isLandscape = false;
  private boolean isStopByNetChange = false;
  private LogAdapter mAdapter;
  private ImageView mBackgroundView;
  private AVCatonReportParams mCatonReportParams;
  private LiveSdkPlayerHelper.PlayerParams mCurrentParams;
  private Runnable mGetFrameRunnable = new LiveSdkPlayerHelper.11(this);
  private boolean mIsHoldPlayerLog = false;
  private TPPlayerMgr.OnLogListener mLogListener = new LiveSdkPlayerHelper.1(this);
  private IMediaPlayerMgr mMediaPlayer;
  private boolean mNeedInitTPPlatform = false;
  private LiveSdkPlayerHelper.PlayerStatusListener mPlayerStatusListener;
  private ImageView mRenderBgView;
  @SuppressLint({"HandlerLeak"})
  private Handler mReportHandle = new LiveSdkPlayerHelper.3(this);
  private int mRetryTime = 0;
  private int mTPPlatform;
  private String mTPPlayerGuid;
  private ITPPlayerVideoViewBase mVideoView;
  private int offsetY = 0;
  private IMediaPlayerMgr.OnCompletionListener onCompletionListener = new LiveSdkPlayerHelper.7(this);
  private IMediaPlayerMgr.OnErrorListener onErrorListener = new LiveSdkPlayerHelper.5(this);
  private IMediaPlayerMgr.OnInfoListener onInfoListener = new LiveSdkPlayerHelper.6(this);
  private IMediaPlayerMgr.OnPreparedListener onPreparedListener = new LiveSdkPlayerHelper.4(this);
  private IMediaPlayerMgr.OnSeekCompleteListener onSeekCompleteListener = new LiveSdkPlayerHelper.8(this);
  private IMediaPlayerMgr.OnSurfaceChangeListener onSurfaceChangeListener = new LiveSdkPlayerHelper.10(this);
  private IMediaPlayerMgr.OnVideoFrameOutListener onVideoFrameOutListener = new LiveSdkPlayerHelper.9(this);
  
  private void initListener()
  {
    this.mCatonReportParams = new AVCatonReportParams();
    this.mMediaPlayer.setOnPreparedListener(this.onPreparedListener);
    this.mMediaPlayer.setOnCompletionListener(this.onCompletionListener);
    this.mMediaPlayer.setOnErrorListener(this.onErrorListener);
    this.mMediaPlayer.setOnInfoListener(this.onInfoListener);
    this.mMediaPlayer.setOnSeekCompleteListener(this.onSeekCompleteListener);
    this.mMediaPlayer.setOnVideoFrameOutListener(this.onVideoFrameOutListener);
    this.mMediaPlayer.setOnSurfaceChangeListener(this.onSurfaceChangeListener);
    this.mReportHandle.removeCallbacksAndMessages(null);
  }
  
  private void reportCaton()
  {
    if (this.mCatonReportParams.e() <= 0L) {
      return;
    }
    if (this.mCatonReportParams.g() <= 0L)
    {
      localObject = this.mPlayerStatusListener;
      if (localObject != null) {
        this.mCatonReportParams.f(((LiveSdkPlayerHelper.PlayerStatusListener)localObject).onReportRoomId());
      }
    }
    AVCatonReportManager.a().a().a(this.mCatonReportParams.a(), this.mCatonReportParams.b(), this.mCatonReportParams.c(), this.mCatonReportParams.d());
    AVCatonReport4Player localAVCatonReport4Player = AVCatonReportManager.a().a();
    String str1 = this.mCatonReportParams.a();
    String str2 = this.mCatonReportParams.b();
    long l = this.mCatonReportParams.g();
    Object localObject = this.mCurrentParams;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((LiveSdkPlayerHelper.PlayerParams)localObject).userId;
    }
    localAVCatonReport4Player.a(str1, str2, String.valueOf(l), "thumbsdk", "2.5.1.98", (String)localObject);
    AVCatonReportManager.a().a().a(this.mCatonReportParams.e() - this.mCatonReportParams.h(), this.mCatonReportParams.f());
    AVCatonReportManager.a().a().a();
  }
  
  public void destroyRenderBackground()
  {
    ImageView localImageView = this.mRenderBgView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public LiveSdkPlayerHelper.PlayerParams getCurrentParams()
  {
    return this.mCurrentParams;
  }
  
  public long getCurrentPositionMs()
  {
    return this.mMediaPlayer.getCurrentPositionMs();
  }
  
  public Rect getDisplayViewRect()
  {
    return this.mVideoView.getDisplayViewRect();
  }
  
  public long getDurationMs()
  {
    return this.mMediaPlayer.getDurationMs();
  }
  
  public String getPlayUrl()
  {
    return this.mCurrentParams.getPlayUrl();
  }
  
  public String getTransferUrl(String paramString)
  {
    return paramString.replaceFirst("https", "http");
  }
  
  public int getVideoHeight()
  {
    return this.mMediaPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.mMediaPlayer.getVideoWidth();
  }
  
  public void handleNetwork(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("netWorkChange netStatus: ");
    ((StringBuilder)localObject).append(paramInt);
    TPLogUtil.i("LiveSdkPlayerHelper", ((StringBuilder)localObject).toString());
    localObject = this.mPlayerStatusListener;
    if (localObject != null) {
      ((LiveSdkPlayerHelper.PlayerStatusListener)localObject).onNetworkChanged(paramInt);
    }
  }
  
  public void init(Context paramContext, IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    if (this.mNeedInitTPPlatform)
    {
      TPPlayerMgr.initSdk(paramContext, this.mTPPlayerGuid, this.mTPPlatform);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init sdk need init platform is :");
      localStringBuilder.append(this.mNeedInitTPPlatform);
      TPLogUtil.i("LiveSdkPlayerHelper", localStringBuilder.toString());
    }
    NetWorkManager.getInstance().init(paramContext);
    if (paramIMediaPlayerMgr == null) {
      this.mMediaPlayer = new MediaPlayerMgr(paramContext);
    } else {
      this.mMediaPlayer = paramIMediaPlayerMgr;
    }
    TPPlayerConfig.setP2PEnable(false);
    initListener();
    NetWorkManager.getInstance().addNetWorkChangeCallback(this);
    ThreadCenter.postDelayedUITask(this, this.mGetFrameRunnable, 1000L);
  }
  
  public void initTPPlayerId(String paramString, int paramInt, boolean paramBoolean)
  {
    this.mTPPlayerGuid = paramString;
    this.mTPPlatform = paramInt;
    this.mNeedInitTPPlatform = paramBoolean;
  }
  
  public boolean isPaused()
  {
    return this.mMediaPlayer.isPaused();
  }
  
  public boolean isPlaying()
  {
    return this.mMediaPlayer.isPlaying();
  }
  
  public void mutePlay(boolean paramBoolean)
  {
    this.mMediaPlayer.setOutputMute(paramBoolean);
  }
  
  public void onScreenOrientationChange(boolean paramBoolean)
  {
    if (!this.isEnableSwitchScreen) {
      return;
    }
    this.isLandscape = paramBoolean;
    if (!paramBoolean)
    {
      this.mVideoView.setRenderGravity(48);
      ((View)this.mVideoView).setPadding(0, this.offsetY, 0, 0);
      this.mVideoView.setFixedSize(getVideoWidth(), getVideoHeight());
    }
    else
    {
      this.mVideoView.setRenderGravity(17);
      ((View)this.mVideoView).setPadding(0, 0, 0, 0);
      this.mVideoView.setFixedSize(getVideoWidth(), getVideoHeight());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScreenOrientationChange landscape: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" offsetY:");
    localStringBuilder.append(this.offsetY);
    TPLogUtil.i("LiveSdkPlayerHelper", localStringBuilder.toString());
    this.mVideoView.setXYAxis(0);
  }
  
  public void openPlay()
  {
    if (this.mCurrentParams == null) {
      return;
    }
    initListener();
    this.mCatonReportParams.a(this.mCurrentParams.getPlayUrl(), this.mCurrentParams.roomId);
    this.mCatonReportParams.g(System.currentTimeMillis());
    String str2 = this.mCurrentParams.getPlayUrl();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      TPLogUtil.i("LiveSdkPlayerHelper", "getPlayUrl is empty...");
      if (!TextUtils.isEmpty(this.mCurrentParams.url_high))
      {
        TPLogUtil.i("LiveSdkPlayerHelper", "set playUrl = url_high");
        str1 = this.mCurrentParams.url_high;
      }
      else if (!TextUtils.isEmpty(this.mCurrentParams.url))
      {
        TPLogUtil.i("LiveSdkPlayerHelper", "set playUrl = url");
        str1 = this.mCurrentParams.url;
      }
      else
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.mCurrentParams.url_low))
        {
          TPLogUtil.i("LiveSdkPlayerHelper", "set playUrl = url_low");
          str1 = this.mCurrentParams.url_low;
        }
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      TPLogUtil.i("LiveSdkPlayerHelper", "play url is empty, do not execute openMediaPlayer.");
      return;
    }
    this.mMediaPlayer.openMediaPlayer(str1);
    TPLogUtil.i("LiveSdkPlayerHelper", "openPlay");
  }
  
  public void pausePlay()
  {
    this.mMediaPlayer.pausePlay();
  }
  
  public void readyPlay(FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    if (paramFrameLayout != null)
    {
      this.isEnableSwitchScreen = false;
      Object localObject = this.mVideoView;
      if (((localObject instanceof TPPlayerVideoView)) && (((TPPlayerVideoView)localObject).getParent() != null))
      {
        localObject = ((TPPlayerVideoView)this.mVideoView).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView((TPPlayerVideoView)this.mVideoView);
        }
      }
      if (this.mMediaPlayer.isPlaying())
      {
        TPLogUtil.i("LiveSdkPlayerHelper", "readyPlay is playing and stop");
        this.mVideoView = null;
      }
      if (this.mBackgroundView == null)
      {
        this.mBackgroundView = new ImageView(paramFrameLayout.getContext());
        localObject = new ViewGroup.LayoutParams(-1, -1);
        this.mBackgroundView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mBackgroundView.setVisibility(0);
        this.mBackgroundView.setId(2131378663);
        this.mBackgroundView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      if ((this.mBackgroundView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mBackgroundView.getParent()).removeView(this.mBackgroundView);
      }
      paramFrameLayout.addView(this.mBackgroundView);
      if (this.mRenderBgView == null)
      {
        this.mRenderBgView = new ImageView(paramFrameLayout.getContext());
        localObject = new ViewGroup.LayoutParams(-1, -1);
        ((ViewGroup.LayoutParams)localObject).height = getVideoHeight();
        ((ViewGroup.LayoutParams)localObject).width = getVideoWidth();
        this.mRenderBgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mRenderBgView.setVisibility(0);
        this.mRenderBgView.setId(2131378665);
      }
      if ((this.mRenderBgView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mRenderBgView.getParent()).removeView(this.mRenderBgView);
      }
      paramFrameLayout.addView(this.mRenderBgView);
      if (this.mVideoView == null) {
        this.mVideoView = new TPPlayerVideoView(paramFrameLayout.getContext(), true, true, true);
      }
      localObject = (View)this.mVideoView;
      ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      ((View)localObject).setVisibility(0);
      ((View)localObject).setId(2131378664);
      paramFrameLayout.addView((View)localObject);
      this.mMediaPlayer.adVideoView(this.mVideoView);
      if ((getVideoWidth() > 0) && (getVideoHeight() > 0))
      {
        if (this.isFloatPlayerModel != paramBoolean) {
          if (paramBoolean)
          {
            this.mVideoView.setRenderGravity(17);
            ((View)this.mVideoView).setPadding(0, 0, 0, 0);
            this.mVideoView.setXYAxis(2);
          }
          else if (getVideoWidth() > getVideoHeight())
          {
            this.mVideoView.setRenderGravity(48);
            ((View)this.mVideoView).setPadding(0, this.offsetY, 0, 0);
            this.mVideoView.setXYAxis(0);
            this.isEnableSwitchScreen = true;
          }
          else
          {
            this.mVideoView.setRenderGravity(17);
            ((View)this.mVideoView).setPadding(0, 0, 0, 0);
            this.mVideoView.setXYAxis(2);
          }
        }
        this.mVideoView.setFixedSize(getVideoWidth(), getVideoHeight());
      }
      else
      {
        this.mVideoView.setRenderGravity(17);
        ((View)this.mVideoView).setPadding(0, 0, 0, 0);
        this.mVideoView.setXYAxis(2);
      }
      this.isFloatPlayerModel = paramBoolean;
      TPLogUtil.i("LiveSdkPlayerHelper", "readyPlay");
      return;
    }
    throw new IllegalArgumentException("video container is null!!!");
  }
  
  public void reset()
  {
    TPLogUtil.i("LiveSdkPlayerHelper", "reset");
    this.mMediaPlayer.reset();
  }
  
  public void resumePlay()
  {
    if (this.isStopByNetChange)
    {
      openPlay();
      return;
    }
    this.mMediaPlayer.continuePlay();
  }
  
  public void seek(int paramInt)
  {
    this.mMediaPlayer.seek(paramInt);
  }
  
  public void setCanvasBackground(Bitmap paramBitmap)
  {
    ImageView localImageView = this.mBackgroundView;
    if ((localImageView != null) && (paramBitmap != null)) {
      localImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setIsHoldPlayerLog(boolean paramBoolean)
  {
    this.mIsHoldPlayerLog = paramBoolean;
  }
  
  public void setLog(LogAdapter paramLogAdapter)
  {
    this.mAdapter = paramLogAdapter;
    if (!this.mIsHoldPlayerLog)
    {
      this.mAdapter.i("LiveSdkPlayerHelper", "set log listener", new Object[0]);
      TPLogUtil.setOnLogListener(this.mLogListener);
    }
  }
  
  public void setOffsetY(int paramInt)
  {
    this.offsetY = paramInt;
    if (this.offsetY == 0)
    {
      localITPPlayerVideoViewBase = this.mVideoView;
      if (localITPPlayerVideoViewBase != null)
      {
        paramInt = com.tencent.livesdk.livesdkplayer.utils.UIUtil.getScreenWidth(((View)localITPPlayerVideoViewBase).getContext());
        int i = com.tencent.livesdk.livesdkplayer.utils.UIUtil.getScreenHeight(((View)this.mVideoView).getContext());
        this.offsetY = Math.max(paramInt / 5, i / 5);
      }
    }
    ITPPlayerVideoViewBase localITPPlayerVideoViewBase = this.mVideoView;
    if ((localITPPlayerVideoViewBase != null) && (com.tencent.falco.utils.UIUtil.isScreenPortrait(((View)localITPPlayerVideoViewBase).getContext()))) {
      ((View)this.mVideoView).setPadding(0, this.offsetY, 0, 0);
    }
  }
  
  public void setParams(LiveSdkPlayerHelper.PlayerParams paramPlayerParams)
  {
    LiveSdkPlayerHelper.PlayerParams localPlayerParams = this.mCurrentParams;
    if ((localPlayerParams != null) && (paramPlayerParams != null) && (!TextUtils.isEmpty(localPlayerParams.getPlayUrl())) && (!this.mCurrentParams.getPlayUrl().equals(paramPlayerParams.getPlayUrl()))) {
      this.mRetryTime = 0;
    }
    this.mCurrentParams = paramPlayerParams;
    paramPlayerParams = this.mCurrentParams;
    if (paramPlayerParams == null) {
      return;
    }
    if (paramPlayerParams.videoType == 0)
    {
      paramPlayerParams = new TPLiveReportInfo();
      this.mMediaPlayer.setReportInfoGetter(paramPlayerParams);
      return;
    }
    if (this.mCurrentParams.videoType == 1)
    {
      paramPlayerParams = new TPVodReportInfo();
      this.mMediaPlayer.setReportInfoGetter(paramPlayerParams);
      return;
    }
    TPLogUtil.i("LiveSdkPlayerHelper", "setParams: setReportInfoGetter null");
  }
  
  public void setPlayerStatusListener(LiveSdkPlayerHelper.PlayerStatusListener paramPlayerStatusListener)
  {
    this.mPlayerStatusListener = paramPlayerStatusListener;
  }
  
  public void setPlayerSurface()
  {
    this.mMediaPlayer.setPlayerSurface();
  }
  
  public void setRenderBG(Bitmap paramBitmap)
  {
    ImageView localImageView = this.mRenderBgView;
    if ((localImageView != null) && (paramBitmap != null)) {
      localImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setRenderViewVisiable(boolean paramBoolean)
  {
    Object localObject = this.mVideoView;
    if ((localObject instanceof TPPlayerVideoView))
    {
      localObject = (TPPlayerVideoView)localObject;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      ((TPPlayerVideoView)localObject).setVisibility(i);
    }
  }
  
  public void startPlay()
  {
    this.mMediaPlayer.startPlay();
  }
  
  public void stopPlay()
  {
    this.mMediaPlayer.stopPlay();
    this.mCatonReportParams.h(System.currentTimeMillis());
    this.mReportHandle.removeCallbacksAndMessages(null);
    reportCaton();
    this.mCatonReportParams.a("", 0L);
  }
  
  public void uninit()
  {
    ThreadCenter.clear(this);
    new Thread(new LiveSdkPlayerHelper.2(this), "uninit_thumb_player").start();
    this.mMediaPlayer.release();
    TPLogUtil.i("LiveSdkPlayerHelper", "uninit");
    this.mVideoView.release();
    this.mRenderBgView = null;
    this.mBackgroundView = null;
    this.mVideoView = null;
    this.mPlayerStatusListener = null;
    if (!this.mIsHoldPlayerLog)
    {
      this.mAdapter.i("LiveSdkPlayerHelper", "set log listener uninit", new Object[0]);
      TPLogUtil.setOnLogListener(null);
    }
    this.mLogListener = null;
    this.mAdapter = null;
    NetWorkManager.getInstance().removeNetWorkChangeCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper
 * JD-Core Version:    0.7.0.1
 */