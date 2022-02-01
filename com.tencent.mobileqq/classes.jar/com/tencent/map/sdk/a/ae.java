package com.tencent.map.sdk.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ae
  implements ThreadFactory
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private final ThreadGroup b;
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d;
  
  public ae(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.b = ((ThreadGroup)localObject);
      this.d = (paramString + "_" + a.getAndIncrement() + "_thread_");
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */