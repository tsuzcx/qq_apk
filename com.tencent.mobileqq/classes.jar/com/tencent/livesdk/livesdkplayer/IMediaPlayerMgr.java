package com.tencent.livesdk.livesdkplayer;

import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;

public abstract interface IMediaPlayerMgr
{
  public abstract void adVideoView(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase);
  
  public abstract void continuePlay();
  
  public abstract int getBufferPercent();
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDecodeFrameCount();
  
  public abstract long getDurationMs();
  
  public abstract long getRenderFrameCount();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isLoopBack();
  
  public abstract boolean isPaused();
  
  public abstract boolean isPlaying();
  
  public abstract void openMediaPlayer(String paramString);
  
  public abstract void pausePlay();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seek(int paramInt);
  
  public abstract void seek(int paramInt1, int paramInt2);
  
  public abstract void setAudioGainRatio(float paramFloat);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setOnCompletionListener(IMediaPlayerMgr.OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnErrorListener(IMediaPlayerMgr.OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(IMediaPlayerMgr.OnInfoListener paramOnInfoListener);
  
  public abstract void setOnPreparedListener(IMediaPlayerMgr.OnPreparedListener paramOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(IMediaPlayerMgr.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnStopAsyncCompleteListener(IMediaPlayerMgr.OnStopAsyncCompleteListener paramOnStopAsyncCompleteListener);
  
  public abstract void setOnSurfaceChangeListener(IMediaPlayerMgr.OnSurfaceChangeListener paramOnSurfaceChangeListener);
  
  public abstract void setOnVideoFrameOutListener(IMediaPlayerMgr.OnVideoFrameOutListener paramOnVideoFrameOutListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerSurface();
  
  public abstract void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo);
  
  public abstract void startPlay();
  
  public abstract void stopAsyncPlay();
  
  public abstract void stopPlay();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr
 * JD-Core Version:    0.7.0.1
 */