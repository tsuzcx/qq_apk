package com.tencent.ilivesdk.avplayerservice_interface;

import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;

public abstract interface PlayerStatusListener
{
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onFirstFrameCome();
  
  public abstract void onNetworkAnomaly();
  
  public abstract void onNetworkChanged(int paramInt);
  
  public abstract void onPlayCaton();
  
  public abstract void onPlayCatonRecover();
  
  public abstract void onPlayCompleted();
  
  public abstract void onPlayPause(long paramLong);
  
  public abstract void onPlayResume(long paramLong);
  
  public abstract void onPreloadFirstFrame(AVPreloadTaskInterface paramAVPreloadTaskInterface);
  
  public abstract void onPushPlayOver();
  
  public abstract void onReadyCompleted();
  
  public abstract void onStartBuffer();
  
  public abstract void onStopBuffer();
  
  public abstract void onSurfaceCreated();
  
  public abstract void onSurfaceDestroyed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */