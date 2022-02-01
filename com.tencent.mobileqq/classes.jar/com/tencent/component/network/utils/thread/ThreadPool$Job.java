package com.tencent.component.network.utils.thread;

public abstract interface ThreadPool$Job<T>
{
  public abstract T run(ThreadPool.JobContext paramJobContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.ThreadPool.Job
 * JD-Core Version:    0.7.0.1
 */