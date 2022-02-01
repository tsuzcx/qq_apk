package com.tencent.hlyyb.common.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  implements ThreadFactory
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private final ThreadGroup b;
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d;
  
  public a(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.b = ((ThreadGroup)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(a.getAndIncrement());
    ((StringBuilder)localObject).append("-thread-");
    this.d = ((StringBuilder)localObject).toString();
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.c.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    try
    {
      paramRunnable.setPriority(5);
      return paramRunnable;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.a.a
 * JD-Core Version:    0.7.0.1
 */