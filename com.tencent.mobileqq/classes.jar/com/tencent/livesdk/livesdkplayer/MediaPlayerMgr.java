package com.tencent.livesdk.livesdkplayer;

import android.content.Context;
import android.util.Log;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase.IVideoViewCallback;
import com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Random;

public class MediaPlayerMgr
  implements IMediaPlayerMgr, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener
{
  private static final long DEFAULT_BUFFERING_TIMEOUT_MS = 15000L;
  private static final long DEFAULT_BUFFER_PACKET_MAX_DURATION = 60000L;
  private static final long DEFAULT_BUFFER_PACKET_MIN_DURATION = 3000L;
  private static final long DEFAULT_MAX_BUFFERING_TIME_MS = 10000L;
  private static final long DEFAULT_MIN_BUFFERING_TIME_MS = 1000L;
  private static final long DEFAULT_RETRY_TIME = 10L;
  private static final String FILE_NAME = "TPPlayer[MediaPlayerMgr";
  public static final int TP_PLAY_INFO_FIRST_FRAME = 106;
  public static final int TP_PLAY_TYPE_LIVE = 1;
  public static final int TP_PLAY_TYPE_VOD = 0;
  private String TAG;
  private Context mContext;
  private boolean mIsCompleted;
  private boolean mIsLoopback;
  private boolean mIsPaused;
  private boolean mIsPlaying;
  private IMediaPlayerMgr.OnCompletionListener mOnCompletionListener;
  private IMediaPlayerMgr.OnErrorListener mOnErrorListener;
  private IMediaPlayerMgr.OnInfoListener mOnInfoListener;
  private IMediaPlayerMgr.OnPreparedListener mOnPreparedListener;
  private IMediaPlayerMgr.OnSeekCompleteListener mOnSeekCompleteListener;
  private IMediaPlayerMgr.OnStopAsyncCompleteListener mOnStopAsyncCompleteListener;
  private IMediaPlayerMgr.OnSurfaceChangeListener mOnSurfaceChangeListener;
  private IMediaPlayerMgr.OnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayer mPlayer;
  private ITPPlayerVideoViewBase mVideoView;
  private ITPPlayerVideoViewBase.IVideoViewCallback mVideoViewCallback = new MediaPlayerMgr.1(this);
  
  public MediaPlayerMgr(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TPPlayer[MediaPlayerMgr");
    localStringBuilder.append(new Random().nextInt());
    localStringBuilder.append("]");
    this.TAG = localStringBuilder.toString();
    this.mContext = paramContext.getApplicationContext();
    this.mPlayer = TPPlayerFactory.createTPPlayer(this.mContext);
    initPlayer();
    TPLogUtil.i(this.TAG, "create tp player");
  }
  
  private void checkNotNull(ITPPlayer paramITPPlayer)
  {
    TPCommonUtils.requireNotNull(paramITPPlayer, "TPPlayer is null, create MediaPlayerMgr first");
  }
  
  private void initListener()
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.setOnPreparedListener(this);
    this.mPlayer.setOnInfoListener(this);
    this.mPlayer.setOnErrorListener(this);
    this.mPlayer.setOnCompletionListener(this);
    this.mPlayer.setOnSeekCompleteListener(this);
    this.mPlayer.setOnStopAsyncCompleteListener(this);
  }
  
  private void initPlayer()
  {
    this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 3000L));
    this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(117, 60000L));
    this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(105, 1000L));
    this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(106, 10000L));
    this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(107, 15000L));
    this.mPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(109, 10L));
    initListener();
  }
  
  public void adVideoView(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase)
  {
    if ((paramITPPlayerVideoViewBase instanceof TPPlayerVideoView)) {
      this.mVideoView = paramITPPlayerVideoViewBase;
    }
    paramITPPlayerVideoViewBase = this.mVideoView;
    if (paramITPPlayerVideoViewBase != null) {
      paramITPPlayerVideoViewBase.addVideoViewCallback(this.mVideoViewCallback);
    }
  }
  
  public void continuePlay()
  {
    if (this.mIsPaused)
    {
      this.mIsPaused = false;
      try
      {
        this.mPlayer.start();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("continuePlay exception: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        TPLogUtil.e(str, localStringBuilder.toString());
        localIllegalStateException.printStackTrace();
      }
    }
  }
  
  public int getBufferPercent()
  {
    checkNotNull(this.mPlayer);
    return this.mPlayer.getBufferPercent();
  }
  
  public long getCurrentPositionMs()
  {
    ITPPlayer localITPPlayer = this.mPlayer;
    if (localITPPlayer == null) {
      return 0L;
    }
    return localITPPlayer.getCurrentPositionMs();
  }
  
  public long getDecodeFrameCount()
  {
    ITPPlayer localITPPlayer = this.mPlayer;
    if (localITPPlayer == null) {
      return 0L;
    }
    return localITPPlayer.getPropertyLong(208);
  }
  
  public long getDurationMs()
  {
    checkNotNull(this.mPlayer);
    return this.mPlayer.getDurationMs();
  }
  
  public long getRenderFrameCount()
  {
    ITPPlayer localITPPlayer = this.mPlayer;
    if (localITPPlayer == null) {
      return 0L;
    }
    return localITPPlayer.getPropertyLong(209);
  }
  
  public int getVideoHeight()
  {
    ITPPlayer localITPPlayer = this.mPlayer;
    if (localITPPlayer == null) {
      return 0;
    }
    return localITPPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    ITPPlayer localITPPlayer = this.mPlayer;
    if (localITPPlayer == null) {
      return 0;
    }
    return localITPPlayer.getVideoWidth();
  }
  
  public boolean isLoopBack()
  {
    if (this.mPlayer == null) {
      return false;
    }
    return this.mIsLoopback;
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onCompletion(paramITPPlayer);
    TPLogUtil.i(this.TAG, "onCompletion : 播放完成");
    paramITPPlayer = this.mOnCompletionListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.onCompletion(this);
    }
    this.mIsCompleted = true;
    this.mIsPlaying = false;
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ReportThumbPlayer.getInstance().onError(paramITPPlayer, paramInt1, paramInt2);
    paramITPPlayer = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError : errorType = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("errorCode = ");
    localStringBuilder.append(paramInt2);
    TPLogUtil.e(paramITPPlayer, localStringBuilder.toString());
    paramITPPlayer = this.mOnErrorListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.onError(this, paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ReportThumbPlayer.getInstance().onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2);
    paramITPPlayer = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInfo : what = ");
    localStringBuilder.append(paramInt);
    TPLogUtil.i(paramITPPlayer, localStringBuilder.toString());
    paramITPPlayer = this.mOnInfoListener;
    if (paramITPPlayer != null) {
      try
      {
        paramITPPlayer.onInfo(this, paramInt, paramLong1, paramLong2, paramObject);
        return;
      }
      catch (Exception paramITPPlayer)
      {
        paramITPPlayer.printStackTrace();
      }
    }
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onPrepared(paramITPPlayer);
    TPLogUtil.i(this.TAG, "onPrepared");
    paramITPPlayer = this.mOnPreparedListener;
    if (paramITPPlayer != null)
    {
      paramITPPlayer.onPrepared(this);
      this.mIsPaused = false;
      return;
    }
    TPLogUtil.e(this.TAG, "OnPreparedListener is null, do something when player prepared");
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    TPLogUtil.i(this.TAG, "Seek completion");
    paramITPPlayer = this.mOnSeekCompleteListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.onSeekComplete(this);
    }
  }
  
  public void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    paramITPPlayer = this.mOnStopAsyncCompleteListener;
    if (paramITPPlayer != null) {
      paramITPPlayer.a();
    }
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    IMediaPlayerMgr.OnVideoFrameOutListener localOnVideoFrameOutListener = this.mOnVideoFrameOutListener;
    if (localOnVideoFrameOutListener != null) {
      localOnVideoFrameOutListener.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
    }
  }
  
  public void openMediaPlayer(String paramString)
  {
    checkNotNull(this.mPlayer);
    try
    {
      initPlayer();
      this.mPlayer.setDataSource(paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      TPLogUtil.e(this.TAG, Log.getStackTraceString(paramString));
    }
    try
    {
      this.mPlayer.prepareAsync();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      TPLogUtil.e(this.TAG, Log.getStackTraceString(paramString));
    }
  }
  
  public void pausePlay()
  {
    checkNotNull(this.mPlayer);
    try
    {
      this.mPlayer.pause();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pausePlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.mIsPaused = true;
  }
  
  public void release()
  {
    this.mIsPlaying = false;
    this.mIsPaused = false;
    ITPPlayerVideoViewBase localITPPlayerVideoViewBase = this.mVideoView;
    if (localITPPlayerVideoViewBase != null) {
      localITPPlayerVideoViewBase.removeVideoViewCallback(this.mVideoViewCallback);
    }
    this.mVideoView = null;
    this.mOnPreparedListener = null;
    this.mOnInfoListener = null;
    this.mOnErrorListener = null;
    this.mOnCompletionListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnVideoFrameOutListener = null;
    checkNotNull(this.mPlayer);
    this.mPlayer.release();
  }
  
  public void reset()
  {
    checkNotNull(this.mPlayer);
    try
    {
      this.mPlayer.reset();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reset exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void seek(int paramInt)
  {
    checkNotNull(this.mPlayer);
    try
    {
      this.mPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void seek(int paramInt1, int paramInt2)
  {
    checkNotNull(this.mPlayer);
    try
    {
      this.mPlayer.seekTo(paramInt1, paramInt2);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.setAudioGainRatio(paramFloat);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    checkNotNull(this.mPlayer);
    this.mIsLoopback = paramBoolean;
    this.mPlayer.setLoopback(this.mIsLoopback);
  }
  
  public void setOnCompletionListener(IMediaPlayerMgr.OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(IMediaPlayerMgr.OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(IMediaPlayerMgr.OnInfoListener paramOnInfoListener)
  {
    this.mOnInfoListener = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(IMediaPlayerMgr.OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayerMgr.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setOnStopAsyncCompleteListener(IMediaPlayerMgr.OnStopAsyncCompleteListener paramOnStopAsyncCompleteListener)
  {
    this.mOnStopAsyncCompleteListener = paramOnStopAsyncCompleteListener;
  }
  
  public void setOnSurfaceChangeListener(IMediaPlayerMgr.OnSurfaceChangeListener paramOnSurfaceChangeListener)
  {
    this.mOnSurfaceChangeListener = paramOnSurfaceChangeListener;
  }
  
  public void setOnVideoFrameOutListener(IMediaPlayerMgr.OnVideoFrameOutListener paramOnVideoFrameOutListener)
  {
    this.mOnVideoFrameOutListener = paramOnVideoFrameOutListener;
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.setOutputMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setPlayerSurface()
  {
    checkNotNull(this.mPlayer);
    ITPPlayerVideoViewBase localITPPlayerVideoViewBase = this.mVideoView;
    if (localITPPlayerVideoViewBase != null) {
      this.mPlayer.setSurface(localITPPlayerVideoViewBase.getViewSurface());
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    ITPPlayer localITPPlayer = this.mPlayer;
    if (localITPPlayer != null) {
      localITPPlayer.getReportManager().setReportInfoGetter(paramTPDefaultReportInfo);
    }
  }
  
  public void startPlay()
  {
    checkNotNull(this.mPlayer);
    try
    {
      this.mPlayer.start();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.mIsPlaying = true;
    this.mIsPaused = false;
  }
  
  public void stopAsyncPlay()
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.stopAsync();
    this.mIsPlaying = false;
  }
  
  public void stopPlay()
  {
    checkNotNull(this.mPlayer);
    try
    {
      this.mPlayer.stop();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPlay exception: ");
      localStringBuilder.append(localIllegalStateException.getMessage());
      TPLogUtil.e(str, localStringBuilder.toString());
      localIllegalStateException.printStackTrace();
    }
    this.mIsPlaying = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.MediaPlayerMgr
 * JD-Core Version:    0.7.0.1
 */