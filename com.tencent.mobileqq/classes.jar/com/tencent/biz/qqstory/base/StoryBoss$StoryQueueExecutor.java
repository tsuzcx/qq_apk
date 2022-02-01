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
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final Queue<Runnable> jdField_a_of_type_JavaUtilQueue;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int b;
  
  private StoryBoss$StoryQueueExecutor(@NonNull String paramString, int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
    int i = this.jdField_a_of_type_JavaUtilQueue.size();
    StringBuilder localStringBuilder;
    if (i > Runtime.getRuntime().availableProcessors())
    {
      paramRunnable = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("too many runnable remained in the queue, size ");
      localStringBuilder.append(i);
      SLog.b(paramRunnable, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= this.jdField_a_of_type_Int)
    {
      paramRunnable = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("current number of task threshold is ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      SLog.b(paramRunnable, localStringBuilder.toString());
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        paramRunnable = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (paramRunnable != null) {
          ThreadManager.excute(paramRunnable, this.b, new StoryBoss.StoryQueueExecutor.1(this, paramRunnable), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryBoss.StoryQueueExecutor
 * JD-Core Version:    0.7.0.1
 */