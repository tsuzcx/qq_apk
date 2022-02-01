package com.tencent.livesdk.livesdkplayer;

import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;

public abstract interface LiveSdkPlayerHelper$PlayerStatusListener
{
  public abstract void onError(IMediaPlayerMgr paramIMediaPlayerMgr, int paramInt, String paramString);
  
  public abstract void onFirstFrameCome(IMediaPlayerMgr paramIMediaPlayerMgr);
  
  public abstract void onNetworkAnomaly();
  
  public abstract void onNetworkChanged(int paramInt);
  
  public abstract void onPlayCompleted(IMediaPlayerMgr paramIMediaPlayerMgr);
  
  public abstract void onReadyCompleted(IMediaPlayerMgr paramIMediaPlayerMgr);
  
  public abstract void onReadyLayout(ITPPlayerVideoViewBase paramITPPlayerVideoViewBase, int paramInt1, int paramInt2);
  
  public abstract long onReportRoomId();
  
  public abstract void onStartBuffer(IMediaPlayerMgr paramIMediaPlayerMgr);
  
  public abstract void onStopBuffer(IMediaPlayerMgr paramIMediaPlayerMgr);
  
  public abstract void onSurfaceCreated();
  
  public abstract void onSurfaceDestroyed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */