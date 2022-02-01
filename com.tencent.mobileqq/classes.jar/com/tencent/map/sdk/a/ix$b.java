package com.tencent.map.sdk.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ix$b
  implements ThreadFactory
{
  private final ThreadGroup a;
  private final AtomicInteger b = new AtomicInteger(1);
  private final String c;
  
  ix$b(ix paramix)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.a = ((ThreadGroup)localObject);
    localObject = new StringBuilder("tileOverlay-");
    ((StringBuilder)localObject).append(paramix.i);
    ((StringBuilder)localObject).append("-thread-");
    this.c = ((StringBuilder)localObject).toString();
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.b.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ix.b
 * JD-Core Version:    0.7.0.1
 */