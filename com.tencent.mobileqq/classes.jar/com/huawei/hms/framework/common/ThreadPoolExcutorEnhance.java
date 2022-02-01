package com.huawei.hms.framework.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorEnhance
  extends ThreadPoolExecutor
{
  public ThreadPoolExcutorEnhance(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    if ((paramRunnable instanceof RunnableEnhance))
    {
      Object localObject2 = ((RunnableEnhance)paramRunnable).getParentName();
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
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(new RunnableEnhance(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.ThreadPoolExcutorEnhance
 * JD-Core Version:    0.7.0.1
 */