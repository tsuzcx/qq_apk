package com.nostra13.universalimageloader.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class DefaultConfigurationFactory$DefaultThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger poolNumber = new AtomicInteger(1);
  private final ThreadGroup group;
  private final String namePrefix;
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  private final int threadPriority;
  
  DefaultConfigurationFactory$DefaultThreadFactory(int paramInt, String paramString)
  {
    this.threadPriority = paramInt;
    this.group = Thread.currentThread().getThreadGroup();
    this.namePrefix = (paramString + poolNumber.getAndIncrement() + "-thread-");
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.group, paramRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    paramRunnable.setPriority(this.threadPriority);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DefaultConfigurationFactory.DefaultThreadFactory
 * JD-Core Version:    0.7.0.1
 */