package com.tencent.ad.tangram.process;

import android.support.annotation.Keep;

@Keep
public abstract interface AdProcessManagerAdapter
{
  public abstract Boolean isOnMainProcess();
  
  public abstract Boolean isWebProcessRunning();
  
  public abstract Boolean isWebProcessRunningForPreloading();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.process.AdProcessManagerAdapter
 * JD-Core Version:    0.7.0.1
 */