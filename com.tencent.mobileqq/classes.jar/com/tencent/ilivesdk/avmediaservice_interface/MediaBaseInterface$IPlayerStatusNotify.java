package com.tencent.ilivesdk.avmediaservice_interface;

import android.view.MotionEvent;

public abstract interface MediaBaseInterface$IPlayerStatusNotify
{
  public abstract boolean isLandscape();
  
  public abstract void onAVChildEventConsumeTime(int paramInt1, int paramInt2);
  
  public abstract void onAVStart();
  
  public abstract void onAVTimeEvent(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onCameraError();
  
  public abstract void onChatEvent(String paramString);
  
  public abstract void onFirstFrameReady();
  
  public abstract void onIsNotWifi();
  
  public abstract void onPlayFailed(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract void onPlayOver();
  
  public abstract void onPlayPause();
  
  public abstract void onPlayRecover();
  
  public abstract void onPlayStartFailed(int paramInt, String paramString);
  
  public abstract void onPlaySupervise(int paramInt, String paramString);
  
  public abstract boolean onPlayerTouched(MotionEvent paramMotionEvent);
  
  public abstract void onSwitchCapType(int paramInt);
  
  public abstract void onUploadMicEvent(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onVideoScreenInfo(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.MediaBaseInterface.IPlayerStatusNotify
 * JD-Core Version:    0.7.0.1
 */