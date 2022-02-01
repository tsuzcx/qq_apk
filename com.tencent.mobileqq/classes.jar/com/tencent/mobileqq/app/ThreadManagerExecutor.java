package com.tencent.mobileqq.app;

import android.support.annotation.NonNull;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadManagerExecutor
  extends AbstractExecutorService
{
  private final int type;
  
  ThreadManagerExecutor(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static ExecutorService getExecutorService(int paramInt)
  {
    return new ThreadManagerExecutor(paramInt);
  }
  
  public static ExecutorService getSingleThreadExecutorService(int paramInt)
  {
    return new SingleThreadExecutor(paramInt);
  }
  
  public boolean awaitTermination(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, this.type, null, false);
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  public List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerExecutor
 * JD-Core Version:    0.7.0.1
 */