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
  private final Runnable jdField_a_of_type_JavaLangRunnable = new TaskThreadPool.2(this);
  private final Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private final RejectedExecutionHandler jdField_a_of_type_JavaUtilConcurrentRejectedExecutionHandler = new TaskThreadPool.1(this);
  private final ScheduledExecutorService jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService = Executors.newScheduledThreadPool(1);
  protected final ScheduledFuture<?> a;
  private final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  
  public TaskThreadPool(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService.scheduleAtFixedRate(this.jdField_a_of_type_JavaLangRunnable, 0L, 100L, TimeUnit.MILLISECONDS);
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(paramInt1, paramInt2, 5000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new TaskThreadPool.CustomThreadFactory(paramString), this.jdField_a_of_type_JavaUtilConcurrentRejectedExecutionHandler);
  }
  
  private boolean a()
  {
    return !this.jdField_a_of_type_JavaUtilQueue.isEmpty();
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskThreadPool
 * JD-Core Version:    0.7.0.1
 */