package com.huawei.hmf.tasks;

public abstract class CancellationToken
{
  public abstract boolean isCancellationRequested();
  
  public abstract CancellationToken register(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hmf.tasks.CancellationToken
 * JD-Core Version:    0.7.0.1
 */