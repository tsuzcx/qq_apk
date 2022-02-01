package com.tencent.livesdk.livesdkplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.livesdk.livesdkplayer.network.NetWorkManager;
import com.tencent.livesdk.livesdkplayer.network.NetWorkReceiver.OnNetworkCallback;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView;
import com.tencent.livesdk.livesdkplayer.utils.UIUtil;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import com.tencent.thumbplayer.api.report.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.TPVodReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class LiveSdkPlayerHelper
  implements NetWorkReceiver.OnNetworkCallback
{
  private static final int GET_GAP_FRAME_MSG = 100;
  private static final int GET_GAP_TIME = 1000;
  private static final int MAX_RETRY_TIME = 3;
  private static final int NETWORK_STATE_3G4G = 102;
  private static final int NETWORK_STATE_CLOSED = 100;
  private static final int NETWORK_STATE_WIFI = 101;
  private static final String SDK_TYPE = "thumbsdk";
  private static final String SDK_VERSION = "2.5.1.98";
  private static final String TAG = "LiveSdkPlayerHelper";
  private boolean isEnableSwitchScreen = false;
  private boolean isFloatPlayerModel = false;
  private boolean isStopByNetChange = false;
  private LogAdapter mAdapter;
  private AVCatonReportParams mCatonReportParams;
  private LiveSdkPlayerHelper.PlayerParams mCurrentParams;
  private TPPlayerMgr.OnLogListener mLogListener = new LiveSdkPlayerHelper.1(this);
  private IMediaPlayerMgr mMediaPlayer;
  private boolean mNeedInitTPPlatform = false;
  private LiveSdkPlayerHelper.PlayerStatusListener mPlayerStatusListener;
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
    if ((this.mCatonReportParams.g() <= 0L) && (this.mPlayerStatusListener != null)) {
      this.mCatonReportParams.f(this.mPlayerStatusListener.onReportRoomId());
    }
    AVCatonReportManager.a().a().a(this.mCatonReportParams.a(), this.mCatonReportParams.b(), this.mCatonReportParams.c(), this.mCatonReportParams.d());
    AVCatonReport4Player localAVCatonReport4Player = AVCatonReportManager.a().a();
    String str2 = this.mCatonReportParams.a();
    String str3 = this.mCatonReportParams.b();
    long l = this.mCatonReportParams.g();
    if (this.mCurrentParams == null) {}
    for (String str1 = "";; str1 = this.mCurrentParams.userId)
    {
      localAVCatonReport4Player.a(str2, str3, String.valueOf(l), "thumbsdk", "2.5.1.98", str1);
      AVCatonReportManager.a().a().a(this.mCatonReportParams.e() - this.mCatonReportParams.h(), this.mCatonReportParams.f());
      AVCatonReportManager.a().a().a();
      return;
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
    TPLogUtil.i("LiveSdkPlayerHelper", "netWorkChange netStatus: " + paramInt);
    if (this.mPlayerStatusListener != null) {
      this.mPlayerStatusListener.onNetworkChanged(paramInt);
    }
  }
  
  public void init(Context paramContext)
  {
    if (this.mNeedInitTPPlatform)
    {
      TPPlayerMgr.initSdk(paramContext, this.mTPPlayerGuid, this.mTPPlatform);
      TPLogUtil.i("LiveSdkPlayerHelper", "init sdk need init platform is :" + this.mNeedInitTPPlatform);
    }
    NetWorkManager.getInstance().init(paramContext);
    this.mMediaPlayer = new MediaPlayerMgr(paramContext);
    TPPlayerConfig.setP2PEnable(false);
    initListener();
    NetWorkManager.getInstance().addNetWorkChangeCallback(this);
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
    if (!paramBoolean)
    {
      this.mVideoView.setRenderGravity(48);
      ((View)this.mVideoView).setPadding(0, this.offsetY, 0, 0);
    }
    for (;;)
    {
      TPLogUtil.i("LiveSdkPlayerHelper", "onScreenOrientationChange landscape: " + paramBoolean + " offsetY:" + this.offsetY);
      this.mVideoView.setXYAxis(0);
      return;
      this.mVideoView.setRenderGravity(17);
      ((View)this.mVideoView).setPadding(0, 0, 0, 0);
    }
  }
  
  public void openPlay()
  {
    if (this.mCurrentParams == null) {
      return;
    }
    initListener();
    this.mCatonReportParams.a(this.mCurrentParams.getPlayUrl(), this.mCurrentParams.roomId);
    this.mCatonReportParams.g(System.currentTimeMillis());
    this.mMediaPlayer.openMediaPlayer(this.mCurrentParams.getPlayUrl());
    TPLogUtil.i("LiveSdkPlayerHelper", "openPlay");
  }
  
  public void pausePlay()
  {
    this.mMediaPlayer.pausePlay();
  }
  
  public void readyPlay(FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    if (paramFrameLayout == null) {
      throw new IllegalArgumentException("video container is null!!!");
    }
    this.isEnableSwitchScreen = false;
    if (((this.mVideoView instanceof TPPlayerVideoView)) && (((TPPlayerVideoView)this.mVideoView).getParent() != null))
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
    if (this.mVideoView == null) {
      this.mVideoView = new TPPlayerVideoView(paramFrameLayout.getContext(), true, true, true);
    }
    this.mVideoView.setXYAxis(2);
    Object localObject = (View)this.mVideoView;
    ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((View)localObject).setVisibility(0);
    ((View)localObject).setId(2131379313);
    paramFrameLayout.addView((View)localObject);
    this.mMediaPlayer.adVideoView(this.mVideoView);
    if (this.isFloatPlayerModel != paramBoolean)
    {
      if (!paramBoolean) {
        break label254;
      }
      this.mVideoView.setRenderGravity(17);
      ((View)this.mVideoView).setPadding(0, 0, 0, 0);
    }
    for (;;)
    {
      this.isFloatPlayerModel = paramBoolean;
      this.mVideoView.setFixedSize(getVideoWidth(), getVideoHeight());
      TPLogUtil.i("LiveSdkPlayerHelper", "readyPlay");
      return;
      label254:
      if (getVideoWidth() > getVideoHeight())
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
      }
    }
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
  
  public void setLog(LogAdapter paramLogAdapter)
  {
    this.mAdapter = paramLogAdapter;
    TPLogUtil.setOnLogListener(this.mLogListener);
  }
  
  public void setOffsetY(int paramInt)
  {
    this.offsetY = paramInt;
    if ((this.offsetY == 0) && (this.mVideoView != null))
    {
      paramInt = UIUtil.getScreenWidth(((View)this.mVideoView).getContext());
      int i = UIUtil.getScreenHeight(((View)this.mVideoView).getContext());
      this.offsetY = Math.max(paramInt / 5, i / 5);
    }
  }
  
  public void setParams(LiveSdkPlayerHelper.PlayerParams paramPlayerParams)
  {
    if ((this.mCurrentParams != null) && (paramPlayerParams != null) && (!TextUtils.isEmpty(this.mCurrentParams.getPlayUrl())) && (!this.mCurrentParams.getPlayUrl().equals(paramPlayerParams.getPlayUrl()))) {
      this.mRetryTime = 0;
    }
    this.mCurrentParams = paramPlayerParams;
    if (this.mCurrentParams == null) {
      return;
    }
    if (this.mCurrentParams.videoType == 0)
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
    new Thread(new LiveSdkPlayerHelper.2(this), "uninit_thumb_player").start();
    this.mMediaPlayer.release();
    TPLogUtil.i("LiveSdkPlayerHelper", "uninit");
    this.mVideoView.release();
    this.mVideoView = null;
    this.mPlayerStatusListener = null;
    TPLogUtil.setOnLogListener(null);
    this.mLogListener = null;
    this.mAdapter = null;
    NetWorkManager.getInstance().removeNetWorkChangeCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper
 * JD-Core Version:    0.7.0.1
 */