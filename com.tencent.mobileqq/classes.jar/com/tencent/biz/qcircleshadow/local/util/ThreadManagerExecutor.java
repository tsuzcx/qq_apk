package com.tencent.biz.qcircleshadow.local.util;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadManagerExecutor
  extends AbstractExecutorService
{
  private final int a;
  
  ThreadManagerExecutor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static ExecutorService a(int paramInt)
  {
    return new ThreadManagerExecutor(paramInt);
  }
  
  public boolean awaitTermination(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).execute(paramRunnable, this.a, null, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.util.ThreadManagerExecutor
 * JD-Core Version:    0.7.0.1
 */