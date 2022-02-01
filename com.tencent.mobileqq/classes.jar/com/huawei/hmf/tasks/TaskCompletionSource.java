package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

public class TaskCompletionSource<TResult>
{
  private final i<TResult> task = new i();
  
  public TaskCompletionSource() {}
  
  public TaskCompletionSource(CancellationToken paramCancellationToken)
  {
    paramCancellationToken.register(new TaskCompletionSource.1(this));
  }
  
  public Task<TResult> getTask()
  {
    return this.task;
  }
  
  public void setException(Exception paramException)
  {
    this.task.a(paramException);
  }
  
  public void setResult(TResult paramTResult)
  {
    this.task.a(paramTResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.TaskCompletionSource
 * JD-Core Version:    0.7.0.1
 */