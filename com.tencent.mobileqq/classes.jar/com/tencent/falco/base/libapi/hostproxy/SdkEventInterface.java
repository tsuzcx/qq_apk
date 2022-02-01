package com.tencent.falco.base.libapi.hostproxy;

import android.app.Activity;
import java.util.Map;

public abstract interface SdkEventInterface
{
  public abstract boolean onBackPressed();
  
  public abstract void onChargeJump(HostChargeCallback paramHostChargeCallback);
  
  public abstract void onCreateRoom();
  
  public abstract void onDestroyRoom();
  
  public abstract void onEnterRoom(long paramLong, int paramInt);
  
  public abstract void onExitLive();
  
  public abstract void onExitRoom();
  
  public abstract void onFirstFrame();
  
  public abstract void onStartLive();
  
  public abstract void onTransferWebViewAction(String paramString, Runnable paramRunnable, Map<String, String> paramMap);
  
  public abstract void overridePendingTransition(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.SdkEventInterface
 * JD-Core Version:    0.7.0.1
 */