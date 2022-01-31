package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class VideoFrameReleaseTimeHelper$VSyncSampler
  implements Handler.Callback, Choreographer.FrameCallback
{
  private static final int CREATE_CHOREOGRAPHER = 0;
  private static final VSyncSampler INSTANCE = new VSyncSampler();
  private static final int MSG_ADD_OBSERVER = 1;
  private static final int MSG_REMOVE_OBSERVER = 2;
  private Choreographer choreographer;
  private final HandlerThread choreographerOwnerThread = new HandlerThread("ChoreographerOwner:Handler");
  private final Handler handler;
  private int observerCount;
  public volatile long sampledVsyncTimeNs = -9223372036854775807L;
  
  private VideoFrameReleaseTimeHelper$VSyncSampler()
  {
    this.choreographerOwnerThread.start();
    this.handler = new Handler(this.choreographerOwnerThread.getLooper(), this);
    this.handler.sendEmptyMessage(0);
  }
  
  private void addObserverInternal()
  {
    this.observerCount += 1;
    if (this.observerCount == 1) {
      this.choreographer.postFrameCallback(this);
    }
  }
  
  private void createChoreographerInstanceInternal()
  {
    this.choreographer = Choreographer.getInstance();
  }
  
  public static VSyncSampler getInstance()
  {
    return INSTANCE;
  }
  
  private void removeObserverInternal()
  {
    this.observerCount -= 1;
    if (this.observerCount == 0)
    {
      this.choreographer.removeFrameCallback(this);
      this.sampledVsyncTimeNs = -9223372036854775807L;
    }
  }
  
  public void addObserver()
  {
    this.handler.sendEmptyMessage(1);
  }
  
  public void doFrame(long paramLong)
  {
    this.sampledVsyncTimeNs = paramLong;
    this.choreographer.postFrameCallbackDelayed(this, 500L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      createChoreographerInstanceInternal();
      return true;
    case 1: 
      addObserverInternal();
      return true;
    }
    removeObserverInternal();
    return true;
  }
  
  public void removeObserver()
  {
    this.handler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler
 * JD-Core Version:    0.7.0.1
 */