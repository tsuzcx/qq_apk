package com.tencent.hlyyb.downloader.f.a;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class a
  extends PriorityBlockingQueue<Runnable>
{
  private b a = null;
  private Integer b = null;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(64);
  }
  
  private Runnable a(long paramLong, TimeUnit paramTimeUnit)
  {
    paramTimeUnit = (Runnable)super.poll(paramLong, paramTimeUnit);
    if ((paramTimeUnit == null) && (this.a != null)) {
      this.a.a();
    }
    return paramTimeUnit;
  }
  
  public final void a(b paramb)
  {
    this.a = paramb;
  }
  
  public final boolean a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.a.isShutdown()) {
      throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
    }
    return super.offer(paramRunnable, paramLong, paramTimeUnit);
  }
  
  public final int remainingCapacity()
  {
    return super.remainingCapacity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.f.a.a
 * JD-Core Version:    0.7.0.1
 */