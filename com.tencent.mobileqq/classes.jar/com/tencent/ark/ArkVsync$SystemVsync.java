package com.tencent.ark;

import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class ArkVsync$SystemVsync
  implements Choreographer.FrameCallback, ArkVsync.ArkVsyncImpl
{
  Choreographer mChoreographer;
  ArkVsync mVsync;
  
  public void doFrame(long paramLong)
  {
    if ((this.mVsync == null) || (this.mChoreographer == null)) {
      return;
    }
    this.mVsync.frameCallback();
    this.mChoreographer.postFrameCallback(this);
  }
  
  public void start(ArkVsync paramArkVsync)
  {
    if (this.mVsync != null)
    {
      Log.d("ArkApp.ArkVsync", String.format("mVsync != null", new Object[0]));
      return;
    }
    this.mVsync = paramArkVsync;
    ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.SystemVsync.1(this));
  }
  
  public void stop()
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkVsync.SystemVsync.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.SystemVsync
 * JD-Core Version:    0.7.0.1
 */