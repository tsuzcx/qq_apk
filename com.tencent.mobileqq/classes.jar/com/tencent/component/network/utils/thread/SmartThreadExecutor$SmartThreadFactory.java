package com.tencent.component.network.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class SmartThreadExecutor$SmartThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger ID = new AtomicInteger();
  private static final String TAG = "SmartThreadFactory";
  
  public Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("smart-");
    localStringBuilder.append(ID.incrementAndGet());
    paramRunnable = new SmartThreadExecutor.SmartThreadFactory.1(this, localStringBuilder.toString(), paramRunnable);
    paramRunnable.setPriority(5);
    paramRunnable.setDaemon(false);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor.SmartThreadFactory
 * JD-Core Version:    0.7.0.1
 */