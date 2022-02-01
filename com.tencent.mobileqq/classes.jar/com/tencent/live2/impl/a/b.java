package com.tencent.live2.impl.a;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePusherObserver;

public abstract class b
  extends V2TXLivePusherObserver
{
  public abstract void onEnterRoom(long paramLong);
  
  public abstract void onExitRoom(int paramInt);
  
  public abstract void onNetworkQuality(int paramInt);
  
  public abstract void onPushEvent(int paramInt, Bundle paramBundle);
  
  public abstract void onPushNetStatus(Bundle paramBundle);
  
  public abstract void onRemoteUserEnter(String paramString);
  
  public abstract void onRemoteUserExit(String paramString, int paramInt);
  
  public abstract void onUserAudioAvailable(String paramString, boolean paramBoolean);
  
  public abstract void onUserVideoAvailable(String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.a.b
 * JD-Core Version:    0.7.0.1
 */