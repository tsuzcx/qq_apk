package com.tencent.component.media.gif;

import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import pga;
import pgb;

public class PrepareAndRenderTask
  extends pgb
{
  private long jdField_a_of_type_Long = 0L;
  private Runnable jdField_a_of_type_JavaLangRunnable = new pga(this);
  ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  private Semaphore jdField_a_of_type_JavaUtilConcurrentSemaphore = new Semaphore(0);
  private Semaphore b;
  
  PrepareAndRenderTask(NewGifDrawable paramNewGifDrawable)
  {
    super(paramNewGifDrawable);
    this.jdField_b_of_type_JavaUtilConcurrentSemaphore = new Semaphore(1);
    this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = paramNewGifDrawable.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  }
  
  public void doWork()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_b_of_type_JavaUtilConcurrentSemaphore.tryAcquire())
        {
          ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "unRender true,doRender" });
          return;
        }
        long l1 = System.currentTimeMillis();
        this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.prepareData();
        long l2 = System.currentTimeMillis();
        l1 = this.jdField_a_of_type_Long - (l2 - l1);
        this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
        ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
        Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
        if (l1 > 0L) {
          this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = localScheduledThreadPoolExecutor.schedule(localRunnable, l1, TimeUnit.MILLISECONDS);
        } else {
          l1 = 0L;
        }
      }
      finally {}
    }
  }
  
  public long getFrameDelay()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void waitFinish()
  {
    try
    {
      ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "wait finish " + hashCode() });
      if (this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.PrepareAndRenderTask
 * JD-Core Version:    0.7.0.1
 */