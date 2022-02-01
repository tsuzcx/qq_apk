package com.huawei.hmf.tasks;

public abstract interface Continuation<TResult, TContinuationResult>
{
  public abstract TContinuationResult then(Task<TResult> paramTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.Continuation
 * JD-Core Version:    0.7.0.1
 */