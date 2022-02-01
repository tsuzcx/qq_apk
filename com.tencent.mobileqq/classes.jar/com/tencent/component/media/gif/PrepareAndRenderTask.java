package com.tencent.component.media.gif;

import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrepareAndRenderTask
  extends RenderTask
{
  private static final String TAG = "PrepareAndRenderTask";
  private Semaphore canPrepareCounts = new Semaphore(1);
  private Semaphore canRenderCounts = new Semaphore(0);
  private long invalidationDelay = 0L;
  private ScheduledThreadPoolExecutor mExecutor;
  private Runnable mRenderTask = new PrepareAndRenderTask.1(this);
  ScheduledFuture<?> mSchedule;
  
  PrepareAndRenderTask(NewGifDrawable paramNewGifDrawable)
  {
    super(paramNewGifDrawable);
    this.mExecutor = paramNewGifDrawable.mExecutor;
  }
  
  public void doWork()
  {
    for (;;)
    {
      try
      {
        if (!this.canPrepareCounts.tryAcquire())
        {
          ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "unRender true,doRender" });
          return;
        }
        long l1 = System.currentTimeMillis();
        this.mGifDrawable.mGifDecoder.prepareData();
        long l2 = System.currentTimeMillis();
        l1 = this.invalidationDelay - (l2 - l1);
        this.canRenderCounts.release();
        ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = this.mExecutor;
        Runnable localRunnable = this.mRenderTask;
        if (l1 > 0L) {
          this.mSchedule = localScheduledThreadPoolExecutor.schedule(localRunnable, l1, TimeUnit.MILLISECONDS);
        } else {
          l1 = 0L;
        }
      }
      finally {}
    }
  }
  
  public long getFrameDelay()
  {
    return this.invalidationDelay;
  }
  
  public void waitFinish()
  {
    try
    {
      ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "wait finish " + hashCode() });
      if (this.mSchedule != null) {
        this.mSchedule.get();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "catch an exception: " + Log.getStackTraceString(localInterruptedException) });
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "catch an exception: " + Log.getStackTraceString(localExecutionException) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.gif.PrepareAndRenderTask
 * JD-Core Version:    0.7.0.1
 */