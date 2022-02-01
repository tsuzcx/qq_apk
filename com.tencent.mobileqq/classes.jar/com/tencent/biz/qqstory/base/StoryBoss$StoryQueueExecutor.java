package com.tencent.biz.qqstory.base;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class StoryBoss$StoryQueueExecutor
  implements Executor
{
  private final Queue<Runnable> a;
  private final AtomicInteger b;
  private int c;
  private final String d;
  private int e;
  
  private StoryBoss$StoryQueueExecutor(@NonNull String paramString, int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    this.d = paramString;
    this.e = paramInt1;
    this.c = paramInt2;
    this.a = new ConcurrentLinkedQueue();
    this.b = new AtomicInteger(0);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.a.offer(paramRunnable);
    int i = this.a.size();
    StringBuilder localStringBuilder;
    if (i > Runtime.getRuntime().availableProcessors())
    {
      paramRunnable = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("too many runnable remained in the queue, size ");
      localStringBuilder.append(i);
      SLog.b(paramRunnable, localStringBuilder.toString());
    }
    if (this.b.get() <= this.c)
    {
      paramRunnable = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("current number of task threshold is ");
      localStringBuilder.append(this.b.get());
      SLog.b(paramRunnable, localStringBuilder.toString());
      while (!this.a.isEmpty())
      {
        paramRunnable = (Runnable)this.a.poll();
        if (paramRunnable != null) {
          ThreadManager.excute(paramRunnable, this.e, new StoryBoss.StoryQueueExecutor.1(this, paramRunnable), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss.StoryQueueExecutor
 * JD-Core Version:    0.7.0.1
 */