package com.tencent.component.network.utils.thread;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import plk;
import pll;
import plm;
import plo;
import plp;
import plq;
import plr;
import plt;

public abstract class AsyncTask
{
  private static final BlockingQueue jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  public static final Executor a;
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new plk();
  public static final Executor b;
  private static volatile Executor c = jdField_b_of_type_JavaUtilConcurrentExecutor;
  private volatile AsyncTask.Status jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status = AsyncTask.Status.PENDING;
  private final FutureTask jdField_a_of_type_JavaUtilConcurrentFutureTask = new plm(this, this.jdField_a_of_type_Plt);
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private final plt jdField_a_of_type_Plt = new pll(this);
  private final AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue(10);
    jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(1, 128, 1L, TimeUnit.SECONDS, jdField_a_of_type_JavaUtilConcurrentBlockingQueue, jdField_a_of_type_JavaUtilConcurrentThreadFactory);
    jdField_b_of_type_JavaUtilConcurrentExecutor = new plr(null);
  }
  
  public AsyncTask()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  private Object a(Object paramObject)
  {
    plp.a.obtainMessage(1, new plo(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
  
  private void c(Object paramObject)
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(paramObject);
    }
  }
  
  private void d(Object paramObject)
  {
    if (a()) {
      b(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status = AsyncTask.Status.FINISHED;
      return;
      a(paramObject);
    }
  }
  
  public final AsyncTask a(Executor paramExecutor, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status != AsyncTask.Status.PENDING) {}
    switch (pln.a[this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status.ordinal()])
    {
    default: 
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status = AsyncTask.Status.RUNNING;
      a();
      this.jdField_a_of_type_Plt.a = paramVarArgs;
      paramExecutor.execute(this.jdField_a_of_type_JavaUtilConcurrentFutureTask);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public final AsyncTask a(Object... paramVarArgs)
  {
    return a(c, paramVarArgs);
  }
  
  public abstract Object a(Object... paramVarArgs);
  
  protected void a() {}
  
  public void a(Object paramObject) {}
  
  public void a(Object... paramVarArgs) {}
  
  public final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  protected void b() {}
  
  protected void b(Object paramObject)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask
 * JD-Core Version:    0.7.0.1
 */