package com.tencent.falco.base.libapi.hostproxy;

public abstract interface SdkInfoInterface
{
  public abstract boolean aekitResAsyncLoad();
  
  public abstract boolean disableExternalMiniCard();
  
  public abstract void floatWindowPermissionRequestResult(boolean paramBoolean);
  
  public abstract boolean isBackgroundPlay();
  
  public abstract boolean isFloatWindowEnabled();
  
  public abstract boolean isFloatWindowShowWhenAppInBackground();
  
  public abstract boolean isFloatWindowShowWhenRoomFinish();
  
  public abstract boolean isTestEnv();
  
  public abstract boolean isWebActivityShowFloatWindow();
  
  public abstract boolean stopPlayingWhenRoomActivityStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface
 * JD-Core Version:    0.7.0.1
 */