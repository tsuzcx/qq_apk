package com.tencent.ark;

import java.util.Timer;

final class ArkVsync$TimerVsync
  implements ArkVsync.ArkVsyncImpl, Runnable
{
  volatile boolean mCallbacking;
  Timer mTimer;
  ArkVsync mVsync;
  
  public void run()
  {
    ArkVsync localArkVsync = this.mVsync;
    if (localArkVsync != null) {
      localArkVsync.frameCallback();
    }
  }
  
  public void start(ArkVsync paramArkVsync)
  {
    if (this.mVsync != null) {
      return;
    }
    this.mTimer = new Timer();
    this.mVsync = paramArkVsync;
    this.mTimer.scheduleAtFixedRate(new ArkVsync.TimerVsync.1(this), 0L, 16L);
  }
  
  public void stop()
  {
    Timer localTimer = this.mTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.mTimer.purge();
      this.mTimer = null;
    }
    this.mVsync = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.TimerVsync
 * JD-Core Version:    0.7.0.1
 */