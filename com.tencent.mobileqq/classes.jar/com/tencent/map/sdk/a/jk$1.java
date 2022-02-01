package com.tencent.map.sdk.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class jk$1
  implements ThreadFactory
{
  private final AtomicInteger b = new AtomicInteger(1);
  
  jk$1(jk paramjk) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "AsyncTask High #" + this.b.getAndIncrement());
    paramRunnable.setPriority(6);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jk.1
 * JD-Core Version:    0.7.0.1
 */