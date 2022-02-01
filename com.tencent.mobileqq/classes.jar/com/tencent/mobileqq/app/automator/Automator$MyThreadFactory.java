package com.tencent.mobileqq.app.automator;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class Automator$MyThreadFactory
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "Automator_" + this.a.getAndIncrement());
    if (paramRunnable.getPriority() != 10) {
      paramRunnable.setPriority(10);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.Automator.MyThreadFactory
 * JD-Core Version:    0.7.0.1
 */