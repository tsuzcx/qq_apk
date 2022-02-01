package com.huawei.hmf.tasks.a;

import android.app.Activity;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class i<TResult>
  extends Task<TResult>
{
  private final Object a = new Object();
  private boolean b;
  private volatile boolean c;
  private TResult d;
  private Exception e;
  private List<ExecuteResult<TResult>> f = new ArrayList();
  
  private Task<TResult> a(ExecuteResult<TResult> paramExecuteResult)
  {
    synchronized (this.a)
    {
      boolean bool = isComplete();
      if (!bool) {
        this.f.add(paramExecuteResult);
      }
      if (bool) {
        paramExecuteResult.onComplete(this);
      }
      return this;
    }
  }
  
  private void b()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        ExecuteResult localExecuteResult = (ExecuteResult)localIterator.next();
        try
        {
          localExecuteResult.onComplete(this);
        }
        catch (Exception localException)
        {
          throw new RuntimeException(localException);
        }
        catch (RuntimeException localRuntimeException)
        {
          throw localRuntimeException;
        }
      }
      this.f = null;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void a(Exception paramException)
  {
    synchronized (this.a)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      this.e = paramException;
      this.a.notifyAll();
      b();
      return;
    }
  }
  
  public final void a(TResult paramTResult)
  {
    synchronized (this.a)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      this.d = paramTResult;
      this.a.notifyAll();
      b();
      return;
    }
  }
  
  public final boolean a()
  {
    synchronized (this.a)
    {
      if (this.b) {
        return false;
      }
      this.b = true;
      this.c = true;
      this.a.notifyAll();
      b();
      return true;
    }
  }
  
  public final Task<TResult> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener)
  {
    paramOnCanceledListener = new b(TaskExecutors.uiThread(), paramOnCanceledListener);
    g.a(paramActivity, paramOnCanceledListener);
    return a(paramOnCanceledListener);
  }
  
  public final Task<TResult> addOnCanceledListener(OnCanceledListener paramOnCanceledListener)
  {
    return addOnCanceledListener(TaskExecutors.uiThread(), paramOnCanceledListener);
  }
  
  public final Task<TResult> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    return a(new b(paramExecutor, paramOnCanceledListener));
  }
  
  public final Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    paramOnCompleteListener = new d(TaskExecutors.uiThread(), paramOnCompleteListener);
    g.a(paramActivity, paramOnCompleteListener);
    return a(paramOnCompleteListener);
  }
  
  public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.uiThread(), paramOnCompleteListener);
  }
  
  public final Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return a(new d(paramExecutor, paramOnCompleteListener));
  }
  
  public final Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new f(TaskExecutors.uiThread(), paramOnFailureListener);
    g.a(paramActivity, paramOnFailureListener);
    return a(paramOnFailureListener);
  }
  
  public final Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.uiThread(), paramOnFailureListener);
  }
  
  public final Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    return a(new f(paramExecutor, paramOnFailureListener));
  }
  
  public final Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<TResult> paramOnSuccessListener)
  {
    paramOnSuccessListener = new h(TaskExecutors.uiThread(), paramOnSuccessListener);
    g.a(paramActivity, paramOnSuccessListener);
    return a(paramOnSuccessListener);
  }
  
  public final Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.uiThread(), paramOnSuccessListener);
  }
  
  public final Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<TResult> paramOnSuccessListener)
  {
    return a(new h(paramExecutor, paramOnSuccessListener));
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(TaskExecutors.uiThread(), paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation)
  {
    i locali = new i();
    addOnCompleteListener(paramExecutor, new i.5(this, locali, paramContinuation));
    return locali;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(TaskExecutors.uiThread(), paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    i locali = new i();
    addOnCompleteListener(paramExecutor, new i.4(this, paramContinuation, locali));
    return locali;
  }
  
  public final Exception getException()
  {
    synchronized (this.a)
    {
      Exception localException = this.e;
      return localException;
    }
  }
  
  public final TResult getResult()
  {
    synchronized (this.a)
    {
      if (this.e == null)
      {
        Object localObject2 = this.d;
        return localObject2;
      }
      throw new RuntimeException(this.e);
    }
  }
  
  public final <E extends Throwable> TResult getResultThrowException(Class<E> paramClass)
  {
    Object localObject = this.a;
    if (paramClass != null) {}
    try
    {
      if (paramClass.isInstance(this.e)) {
        throw ((Throwable)paramClass.cast(this.e));
      }
      if (this.e == null)
      {
        paramClass = this.d;
        return paramClass;
      }
      throw new RuntimeException(this.e);
    }
    finally {}
  }
  
  public final boolean isCanceled()
  {
    return this.c;
  }
  
  public final boolean isComplete()
  {
    synchronized (this.a)
    {
      boolean bool = this.b;
      return bool;
    }
  }
  
  public final boolean isSuccessful()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if ((this.b) && (!isCanceled()) && (this.e == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    return onSuccessTask(TaskExecutors.uiThread(), paramSuccessContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    i locali = new i();
    addOnSuccessListener(paramExecutor, new i.1(this, paramSuccessContinuation, locali));
    addOnFailureListener(new i.2(this, locali));
    addOnCanceledListener(new i.3(this, locali));
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.i
 * JD-Core Version:    0.7.0.1
 */