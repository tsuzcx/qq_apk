package com.tencent.component.network.utils.thread;

public abstract interface ThreadPool$JobContext
{
  public abstract boolean isCancelled();
  
  public abstract void setCancelListener(ThreadPool.CancelListener paramCancelListener);
  
  public abstract boolean setMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.ThreadPool.JobContext
 * JD-Core Version:    0.7.0.1
 */