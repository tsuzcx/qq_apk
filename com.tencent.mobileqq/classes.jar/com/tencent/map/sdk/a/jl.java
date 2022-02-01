package com.tencent.map.sdk.a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public final class jl
  implements Executor
{
  public final Executor a = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, this.c, this.b, new ThreadPoolExecutor.DiscardOldestPolicy());
  private final ThreadFactory b = new jl.1(this);
  private final BlockingQueue<Runnable> c = new LinkedBlockingQueue(20);
  
  public final void execute(Runnable paramRunnable)
  {
    this.a.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jl
 * JD-Core Version:    0.7.0.1
 */