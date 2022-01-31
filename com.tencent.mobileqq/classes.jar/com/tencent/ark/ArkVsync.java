package com.tencent.ark;

import android.os.Build.VERSION;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

class ArkVsync
{
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String TAG = "ArkApp.ArkVsync";
  static final ArkVsync gInstance = new ArkVsync();
  protected ArkFrameCallback[] mCallbackArrays;
  protected Set<ArkFrameCallback> mCallbacks = new HashSet();
  protected ArkVsyncImpl mImpl;
  
  private ArkVsync()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mImpl = new TimerVsync();
      return;
    }
    this.mImpl = new SystemVsync();
  }
  
  public static ArkVsync getInstance()
  {
    return gInstance;
  }
  
  void addFrameCallback(ArkFrameCallback paramArkFrameCallback)
  {
    if (paramArkFrameCallback == null) {}
    do
    {
      return;
      this.mCallbacks.add(paramArkFrameCallback);
      this.mCallbackArrays = null;
    } while ((this.mCallbacks.size() != 1) || (this.mImpl == null));
    this.mImpl.start(this);
  }
  
  void frameCallback()
  {
    if (this.mCallbacks.size() <= 0) {}
    for (;;)
    {
      return;
      if (this.mCallbackArrays == null) {
        this.mCallbackArrays = ((ArkFrameCallback[])this.mCallbacks.toArray(new ArkFrameCallback[this.mCallbacks.size()]));
      }
      ArkFrameCallback[] arrayOfArkFrameCallback = this.mCallbackArrays;
      int j = arrayOfArkFrameCallback.length;
      int i = 0;
      while (i < j)
      {
        arrayOfArkFrameCallback[i].doFrame();
        i += 1;
      }
    }
  }
  
  void removeFrameCallback(ArkFrameCallback paramArkFrameCallback)
  {
    if (paramArkFrameCallback == null) {}
    do
    {
      return;
      this.mCallbacks.remove(paramArkFrameCallback);
      this.mCallbackArrays = null;
    } while ((this.mCallbacks.size() != 0) || (this.mImpl == null));
    this.mImpl.stop();
  }
  
  public static abstract interface ArkFrameCallback
  {
    public abstract void doFrame();
  }
  
  public static abstract interface ArkVsyncImpl
  {
    public abstract void start(ArkVsync paramArkVsync);
    
    public abstract void stop();
  }
  
  static final class SystemVsync
    implements ArkVsync.ArkVsyncImpl, Choreographer.FrameCallback
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
      if (this.mVsync != null) {
        return;
      }
      if (this.mChoreographer == null) {
        this.mChoreographer = Choreographer.getInstance();
      }
      this.mVsync = paramArkVsync;
      this.mChoreographer.postFrameCallback(this);
    }
    
    public void stop()
    {
      if (this.mChoreographer != null)
      {
        this.mChoreographer.removeFrameCallback(this);
        this.mChoreographer = null;
        this.mVsync = null;
      }
    }
  }
  
  static final class TimerVsync
    implements ArkVsync.ArkVsyncImpl, Runnable
  {
    Timer mTimer;
    ArkVsync mVsync;
    
    public void run()
    {
      if (this.mVsync != null) {
        this.mVsync.frameCallback();
      }
    }
    
    public void start(ArkVsync paramArkVsync)
    {
      if (this.mVsync != null) {
        return;
      }
      this.mTimer = new Timer();
      this.mVsync = paramArkVsync;
      this.mTimer.scheduleAtFixedRate(new TimerTask()
      {
        public void run()
        {
          ArkDispatchTask.getInstance().removeTask(ArkVsync.TimerVsync.this);
          ArkDispatchTask.getInstance().post(ArkVsync.TimerVsync.this);
        }
      }, 0L, 16L);
    }
    
    public void stop()
    {
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer.purge();
        this.mTimer = null;
      }
      this.mVsync = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ArkVsync
 * JD-Core Version:    0.7.0.1
 */