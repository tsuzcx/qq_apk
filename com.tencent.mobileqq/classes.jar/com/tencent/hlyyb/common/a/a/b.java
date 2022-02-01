package com.tencent.hlyyb.common.a.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class b
  extends LinkedBlockingQueue<Runnable>
{
  private d a = null;
  private Integer b = null;
  
  public b() {}
  
  public b(int paramInt)
  {
    super(16);
  }
  
  private Runnable a(long paramLong, TimeUnit paramTimeUnit)
  {
    paramTimeUnit = (Runnable)super.poll(paramLong, paramTimeUnit);
    if ((paramTimeUnit == null) && (this.a != null)) {
      this.a.a();
    }
    return paramTimeUnit;
  }
  
  public final void a(d paramd)
  {
    this.a = paramd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.a.b
 * JD-Core Version:    0.7.0.1
 */