package com.tencent.map.sdk.a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public final class jk
  implements Executor
{
  private final ThreadFactory a = new jk.1(this);
  private final BlockingQueue<Runnable> b = new jk.a(this);
  private final Executor c = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, this.b, this.a, new ThreadPoolExecutor.DiscardOldestPolicy());
  
  public final void execute(Runnable paramRunnable)
  {
    this.c.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jk
 * JD-Core Version:    0.7.0.1
 */