package com.huawei.hmf.tasks;

import android.app.Activity;
import java.util.concurrent.Executor;

public abstract class Task<TResult>
{
  public Task<TResult> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener)
  {
    throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
  }
  
  public Task<TResult> addOnCanceledListener(OnCanceledListener paramOnCanceledListener)
  {
    throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
  }
  
  public Task<TResult> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
  }
  
  public Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener)
  {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  public Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  public abstract Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener);
  
  public abstract Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener);
  
  public abstract Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener);
  
  public abstract Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<TResult> paramOnSuccessListener);
  
  public abstract Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> paramOnSuccessListener);
  
  public abstract Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<TResult> paramOnSuccessListener);
  
  public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    throw new UnsupportedOperationException("continueWith is not implemented");
  }
  
  public <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation)
  {
    throw new UnsupportedOperationException("continueWith is not implemented");
  }
  
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    throw new UnsupportedOperationException("continueWithTask is not implemented");
  }
  
  public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    throw new UnsupportedOperationException("continueWithTask is not implemented");
  }
  
  public abstract Exception getException();
  
  public abstract TResult getResult();
  
  public abstract <E extends Throwable> TResult getResultThrowException(Class<E> paramClass);
  
  public abstract boolean isCanceled();
  
  public abstract boolean isComplete();
  
  public abstract boolean isSuccessful();
  
  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    throw new UnsupportedOperationException("onSuccessTask is not implemented");
  }
  
  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    throw new UnsupportedOperationException("onSuccessTask is not implemented");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hmf.tasks.Task
 * JD-Core Version:    0.7.0.1
 */