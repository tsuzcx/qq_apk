package com.huawei.hmf.tasks;

public abstract interface SuccessContinuation<TResult, TContinuationResult>
{
  public abstract Task<TContinuationResult> then(TResult paramTResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hmf.tasks.SuccessContinuation
 * JD-Core Version:    0.7.0.1
 */