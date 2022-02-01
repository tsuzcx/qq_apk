package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;
import com.huawei.hmf.tasks.a.j;
import com.huawei.hmf.tasks.a.j.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tasks
{
  private static j IMPL = new j();
  
  public static Task<List<Task<?>>> allOf(Collection<? extends Task<?>> paramCollection)
  {
    return j.a(paramCollection);
  }
  
  public static Task<List<Task<?>>> allOf(Task<?>... paramVarArgs)
  {
    return j.a(Arrays.asList(paramVarArgs));
  }
  
  public static <TResult> TResult await(Task<TResult> paramTask)
  {
    j.a("await must not be called on the UI thread");
    if (paramTask.isComplete()) {
      return j.a(paramTask);
    }
    j.a locala = new j.a();
    paramTask.addOnSuccessListener(locala).addOnFailureListener(locala);
    locala.a.await();
    return j.a(paramTask);
  }
  
  public static <TResult> TResult await(Task<TResult> paramTask, long paramLong, TimeUnit paramTimeUnit)
  {
    j.a("await must not be called on the UI thread");
    if (!paramTask.isComplete())
    {
      j.a locala = new j.a();
      paramTask.addOnSuccessListener(locala).addOnFailureListener(locala);
      if (!locala.a.await(paramLong, paramTimeUnit)) {
        throw new TimeoutException("Timed out waiting for Task");
      }
    }
    return j.a(paramTask);
  }
  
  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable)
  {
    return IMPL.a(TaskExecutors.immediate(), paramCallable);
  }
  
  public static <TResult> Task<TResult> callInBackground(Callable<TResult> paramCallable)
  {
    return IMPL.a(TaskExecutors.background(), paramCallable);
  }
  
  public static <TResult> Task<TResult> callInBackground(Executor paramExecutor, Callable<TResult> paramCallable)
  {
    return IMPL.a(paramExecutor, paramCallable);
  }
  
  public static <TResult> Task<TResult> fromCanceled()
  {
    i locali = new i();
    locali.a();
    return locali;
  }
  
  public static <TResult> Task<TResult> fromException(Exception paramException)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setException(paramException);
    return localTaskCompletionSource.getTask();
  }
  
  public static <TResult> Task<TResult> fromResult(TResult paramTResult)
  {
    return j.a(paramTResult);
  }
  
  public static Task<Void> join(Collection<? extends Task<?>> paramCollection)
  {
    return j.c(paramCollection);
  }
  
  public static Task<Void> join(Task<?>... paramVarArgs)
  {
    return j.c(Arrays.asList(paramVarArgs));
  }
  
  public static <TResult> Task<List<TResult>> successOf(Collection<? extends Task<TResult>> paramCollection)
  {
    return j.b(paramCollection);
  }
  
  public static <TResult> Task<List<TResult>> successOf(Task<?>... paramVarArgs)
  {
    return j.b(Arrays.asList(paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hmf.tasks.Tasks
 * JD-Core Version:    0.7.0.1
 */