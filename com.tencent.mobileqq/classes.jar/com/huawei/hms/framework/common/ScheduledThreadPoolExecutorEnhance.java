package com.huawei.hms.framework.common;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class ScheduledThreadPoolExecutorEnhance
  extends ScheduledThreadPoolExecutor
{
  private static final String TAG = "ScheduledThreadPoolExec";
  
  public ScheduledThreadPoolExecutorEnhance(int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory);
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    if ((paramRunnable instanceof RunnableScheduledFutureEnhance))
    {
      Object localObject2 = ((RunnableScheduledFutureEnhance)paramRunnable).getParentName();
      int i = ((String)localObject2).lastIndexOf(" -->");
      Object localObject1 = localObject2;
      if (i != -1) {
        localObject1 = StringUtils.substring((String)localObject2, i + 4);
      }
      Object localObject3 = paramThread.getName();
      i = ((String)localObject3).lastIndexOf(" -->");
      localObject2 = localObject3;
      if (i != -1) {
        localObject2 = StringUtils.substring((String)localObject3, i + 4);
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" -->");
      ((StringBuilder)localObject3).append((String)localObject2);
      paramThread.setName(((StringBuilder)localObject3).toString());
    }
    super.beforeExecute(paramThread, paramRunnable);
  }
  
  protected <V> RunnableScheduledFuture<V> decorateTask(Runnable paramRunnable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
  {
    return new RunnableScheduledFutureEnhance(super.decorateTask(paramRunnable, paramRunnableScheduledFuture));
  }
  
  protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> paramCallable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
  {
    return new RunnableScheduledFutureEnhance(super.decorateTask(paramCallable, paramRunnableScheduledFuture));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ScheduledThreadPoolExecutorEnhance
 * JD-Core Version:    0.7.0.1
 */