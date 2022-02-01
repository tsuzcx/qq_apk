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
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.util.Random;

public class MediaPlayerMgr
  implements IMediaPlayerMgr, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener
{
  private static final long DEFAULT_BUFFERING_TIMEOUT_MS = 15000L;
  private static final long DEFAULT_BUFFER_PACKET_MAX_DURATION = 60000L;
  private static final long DEFAULT_BUFFER_PACKET_MIN_DURATION = 3000L;
  private static final long DEFAULT_MAX_BUFFERING_TIME_MS = 10000L;
  private static final long DEFAULT_MIN_BUFFERING_TIME_MS = 1000L;
  private static final long DEFAULT_RETRY_TIME = 10L;
  private static final String FILE_NAME = "TPPlayer[MediaPlayerMgr";
  private String TAG = "TPPlayer[MediaPlayerMgr" + new Random().nextInt() + "]";
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
  private IMediaPlayerMgr.OnSurfaceChangeListener mOnSurfaceChangeListener;
  private IMediaPlayerMgr.OnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayer mPlayer;
  private ITPPlayerVideoViewBase mVideoView;
  private ITPPlayerVideoViewBase.IVideoViewCallback mVideoViewCallback = new MediaPlayerMgr.1(this);
  
  public MediaPlayerMgr(Context paramContext)
  {
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
    if (this.mVideoView != null) {
      this.mVideoView.addVideoViewCallback(this.mVideoViewCallback);
    }
  }
  
  public void continuePlay()
  {
    if (this.mIsPaused)
    {
      this.mIsPaused = false;
      this.mPlayer.start();
    }
  }
  
  public int getBufferPercent()
  {
    checkNotNull(this.mPlayer);
    return this.mPlayer.getBufferPercent();
  }
  
  public long getCurrentPositionMs()
  {
    if (this.mPlayer == null) {
      return 0L;
    }
    return this.mPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    checkNotNull(this.mPlayer);
    return this.mPlayer.getDurationMs();
  }
  
  public int getVideoHeight()
  {
    if (this.mPlayer == null) {
      return 0;
    }
    return this.mPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    if (this.mPlayer == null) {
      return 0;
    }
    return this.mPlayer.getVideoWidth();
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
    if (this.mOnCompletionListener != null) {
      this.mOnCompletionListener.onCompletion(this);
    }
    this.mIsCompleted = true;
    this.mIsPlaying = false;
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ReportThumbPlayer.getInstance().onError(paramITPPlayer, paramInt1, paramInt2);
    TPLogUtil.e(this.TAG, "onError : errorType = " + paramInt1 + "errorCode = " + paramInt2);
    if (this.mOnErrorListener != null) {
      this.mOnErrorListener.onError(this, paramInt1, paramInt2, paramLong1, paramLong2);
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ReportThumbPlayer.getInstance().onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2);
    TPLogUtil.i(this.TAG, "onInfo : what = " + paramInt);
    if (this.mOnInfoListener != null) {}
    try
    {
      this.mOnInfoListener.onInfo(this, paramInt, paramLong1, paramLong2, paramObject);
      return;
    }
    catch (Exception paramITPPlayer) {}
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onPrepared(paramITPPlayer);
    TPLogUtil.i(this.TAG, "onPrepared");
    if (this.mOnPreparedListener != null)
    {
      this.mOnPreparedListener.onPrepared(this);
      this.mIsPaused = false;
      return;
    }
    TPLogUtil.e(this.TAG, "OnPreparedListener is null, do something when player prepared");
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    TPLogUtil.i(this.TAG, "Seek completion");
    if (this.mOnSeekCompleteListener != null) {
      this.mOnSeekCompleteListener.onSeekComplete(this);
    }
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    if (this.mOnVideoFrameOutListener != null) {
      this.mOnVideoFrameOutListener.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
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
      for (;;)
      {
        try
        {
          this.mPlayer.prepareAsync();
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          TPLogUtil.e(this.TAG, Log.getStackTraceString(paramString));
        }
        paramString = paramString;
        paramString.printStackTrace();
        TPLogUtil.e(this.TAG, Log.getStackTraceString(paramString));
      }
    }
  }
  
  public void pausePlay()
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.pause();
    this.mIsPaused = true;
  }
  
  public void release()
  {
    this.mIsPlaying = false;
    this.mIsPaused = false;
    if (this.mVideoView != null) {
      this.mVideoView.removeVideoViewCallback(this.mVideoViewCallback);
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
    this.mPlayer.reset();
  }
  
  public void seek(int paramInt)
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.seekTo(paramInt);
  }
  
  public void seek(int paramInt1, int paramInt2)
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.seekTo(paramInt1, paramInt2);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.setAudioGainRatio(paramFloat);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.setLoopback(this.mIsLoopback);
    this.mIsLoopback = paramBoolean;
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
    if (this.mVideoView != null) {
      this.mPlayer.setSurface(this.mVideoView.getViewSurface());
    }
  }
  
  public void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo)
  {
    if (this.mPlayer != null) {
      this.mPlayer.getReportManager().setReportInfoGetter(paramTPDefaultReportInfo);
    }
  }
  
  public void startPlay()
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.start();
    this.mIsPlaying = true;
    this.mIsPaused = false;
  }
  
  public void stopPlay()
  {
    checkNotNull(this.mPlayer);
    this.mPlayer.stop();
    this.mIsPlaying = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.MediaPlayerMgr
 * JD-Core Version:    0.7.0.1
 */