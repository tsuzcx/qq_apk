package com.tencent.map.sdk.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class jl$1
  implements ThreadFactory
{
  private final AtomicInteger b = new AtomicInteger(1);
  
  jl$1(jl paramjl) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AsyncTask Low #" + this.b.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jl.1
 * JD-Core Version:    0.7.0.1
 */