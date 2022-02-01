package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

public class TaskApiCallWrapper<TResult>
  extends BaseContentWrapper
{
  private final TaskApiCall<? extends AnyClient, TResult> mTaskApiCall;
  private final TaskCompletionSource<TResult> mTaskCompletionSource;
  
  public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> paramTaskApiCall, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    super(1);
    this.mTaskApiCall = paramTaskApiCall;
    this.mTaskCompletionSource = paramTaskCompletionSource;
  }
  
  public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall()
  {
    return this.mTaskApiCall;
  }
  
  public TaskCompletionSource<TResult> getTaskCompletionSource()
  {
    return this.mTaskCompletionSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.TaskApiCallWrapper
 * JD-Core Version:    0.7.0.1
 */