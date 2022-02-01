package com.tencent.mobileqq.apollo.utils.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskThreadPool
{
  protected final ScheduledFuture<?> a = this.e.scheduleAtFixedRate(this.d, 0L, 100L, TimeUnit.MILLISECONDS);
  private final Queue<Runnable> b = new LinkedList();
  private final RejectedExecutionHandler c = new TaskThreadPool.1(this);
  private final Runnable d = new TaskThreadPool.2(this);
  private final ScheduledExecutorService e = Executors.newScheduledThreadPool(1);
  private final ThreadPoolExecutor f;
  
  public TaskThreadPool(String paramString, int paramInt1, int paramInt2)
  {
    this.f = new ThreadPoolExecutor(paramInt1, paramInt2, 5000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new TaskThreadPool.CustomThreadFactory(paramString), this.c);
  }
  
  private boolean a()
  {
    return this.b.isEmpty() ^ true;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.f.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskThreadPool
 * JD-Core Version:    0.7.0.1
 */