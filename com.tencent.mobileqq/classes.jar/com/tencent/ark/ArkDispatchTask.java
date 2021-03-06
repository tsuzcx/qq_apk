package com.tencent.ark;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

public class ArkDispatchTask
{
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String LOG_TAG = "ArkApp.DispatchTask";
  private final Handler mMainHandler = new Handler(Looper.getMainLooper());
  private final Handler mSubHandler;
  private HandlerThread mSubThread = ENV.createHandlerThread("ArkAppThread");
  
  private ArkDispatchTask()
  {
    if (this.mSubThread == null)
    {
      this.mSubThread = new HandlerThread("ArkAppThread", -1);
      Logger.logD("ArkApp.DispatchTask", "ENV not init thread use Ark's HandlerThread");
    }
    this.mSubThread.start();
    this.mSubHandler = new Handler(this.mSubThread.getLooper());
  }
  
  public static ArkDispatchTask getInstance()
  {
    return ArkDispatchTask.LazyHolder.gInstance;
  }
  
  static final boolean postImpl(Handler paramHandler, Runnable paramRunnable, long paramLong)
  {
    paramRunnable = Message.obtain(paramHandler, paramRunnable);
    ThreadMessageHandler.IMPL.setAsynchronous(paramRunnable, true);
    return paramHandler.sendMessageDelayed(paramRunnable, paramLong);
  }
  
  public boolean CheckQueueValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.logD("ArkApp.DispatchTask", "DispatchTask.CheckQueueValid false, queuekey is empty ");
      return false;
    }
    return true;
  }
  
  public boolean isMainThread()
  {
    return this.mMainHandler.getLooper() == Looper.myLooper();
  }
  
  public boolean isTaskThread()
  {
    return this.mMainHandler.getLooper() != Looper.myLooper();
  }
  
  public void post(String paramString, Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      if (!CheckQueueValid(paramString)) {
        return;
      }
      try
      {
        ArkDispatchQueue.asyncRun(paramString, paramRunnable);
        return;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramRunnable = new StringBuilder();
        paramRunnable.append("DispatchTask.post.exception: ");
        paramRunnable.append(paramString.getLocalizedMessage());
        Logger.logE("ArkApp.DispatchTask", paramRunnable.toString());
      }
    }
  }
  
  public void postDelayed(String paramString, Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null)
    {
      if (!CheckQueueValid(paramString)) {
        return;
      }
      try
      {
        ArkDispatchQueue.asyncRun(paramString, paramRunnable, paramLong);
        return;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramRunnable = new StringBuilder();
        paramRunnable.append("DispatchTask.postDelayed.exception: ");
        paramRunnable.append(paramString.getLocalizedMessage());
        Logger.logE("ArkApp.DispatchTask", paramRunnable.toString());
      }
    }
  }
  
  public void postToArkThread(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Handler localHandler = this.mSubHandler;
      if (localHandler == null) {
        return;
      }
      postImpl(localHandler, paramRunnable, 0L);
    }
  }
  
  public void postToArkThreadDelay(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null)
    {
      Handler localHandler = this.mSubHandler;
      if (localHandler == null) {
        return;
      }
      postImpl(localHandler, paramRunnable, paramLong);
    }
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Handler localHandler = this.mMainHandler;
      if (localHandler == null) {
        return;
      }
      postImpl(localHandler, paramRunnable, 0L);
    }
  }
  
  public void postToMainThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null)
    {
      Handler localHandler = this.mMainHandler;
      if (localHandler == null) {
        return;
      }
      localHandler.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public void removeTaskInMainThread(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Handler localHandler = this.mMainHandler;
      if (localHandler == null) {
        return;
      }
      localHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void send(String paramString, Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      if (!CheckQueueValid(paramString)) {
        return;
      }
      try
      {
        ArkDispatchQueue.syncRun(paramString, paramRunnable);
        return;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramRunnable = new StringBuilder();
        paramRunnable.append("DispatchTask.send.exception: ");
        paramRunnable.append(paramString.getLocalizedMessage());
        Logger.logE("ArkApp.DispatchTask", paramRunnable.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkDispatchTask
 * JD-Core Version:    0.7.0.1
 */