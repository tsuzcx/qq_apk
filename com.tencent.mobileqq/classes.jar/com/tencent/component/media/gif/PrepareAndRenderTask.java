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
        l1 = System.currentTimeMillis();
        this.mGifDrawable.mGifDecoder.prepareData();
        long l2 = System.currentTimeMillis();
        l1 = this.invalidationDelay - (l2 - l1);
        this.canRenderCounts.release();
        ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = this.mExecutor;
        Runnable localRunnable = this.mRenderTask;
        if (l1 > 0L)
        {
          this.mSchedule = localScheduledThreadPoolExecutor.schedule(localRunnable, l1, TimeUnit.MILLISECONDS);
          return;
        }
      }
      finally {}
      long l1 = 0L;
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
      ILog localILog = ImageManagerEnv.getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("wait finish ");
      ((StringBuilder)localObject).append(hashCode());
      localILog.w("PrepareAndRenderTask", new Object[] { ((StringBuilder)localObject).toString() });
      if (this.mSchedule != null)
      {
        this.mSchedule.get();
        return;
      }
    }
    catch (ExecutionException localExecutionException)
    {
      localObject = ImageManagerEnv.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("catch an exception: ");
      localStringBuilder.append(Log.getStackTraceString(localExecutionException));
      ((ILog)localObject).w("PrepareAndRenderTask", new Object[] { localStringBuilder.toString() });
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Object localObject = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("catch an exception: ");
      localStringBuilder.append(Log.getStackTraceString(localInterruptedException));
      ((ILog)localObject).w("PrepareAndRenderTask", new Object[] { localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.gif.PrepareAndRenderTask
 * JD-Core Version:    0.7.0.1
 */