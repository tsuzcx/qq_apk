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
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.a = ((ThreadGroup)localObject);
      this.c = ("tileOverlay-" + paramix.i + "-thread-");
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.a, paramRunnable, this.c + this.b.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ix.b
 * JD-Core Version:    0.7.0.1
 */