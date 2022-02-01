package com.tencent.component.network.utils.thread;

import java.util.concurrent.atomic.AtomicLong;

class PriorityThreadPool$PriorityJob<T>
  implements ThreadPool.Job<T>, Comparable<PriorityJob>
{
  private static final AtomicLong SEQ = new AtomicLong(0L);
  private final boolean mFifo;
  private final ThreadPool.Job<T> mJob;
  private final int mPriority;
  private final long mSeqNum;
  
  public PriorityThreadPool$PriorityJob(ThreadPool.Job<T> paramJob, int paramInt, boolean paramBoolean)
  {
    this.mJob = paramJob;
    this.mPriority = paramInt;
    this.mFifo = paramBoolean;
    this.mSeqNum = SEQ.getAndIncrement();
  }
  
  private int subCompareTo(PriorityJob paramPriorityJob)
  {
    long l1 = this.mSeqNum;
    long l2 = paramPriorityJob.mSeqNum;
    int i;
    if (l1 < l2) {
      i = -1;
    } else if (l1 > l2) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mFifo) {
      return i;
    }
    return -i;
  }
  
  public int compareTo(PriorityJob paramPriorityJob)
  {
    int i = this.mPriority;
    int j = paramPriorityJob.mPriority;
    if (i > j) {
      return -1;
    }
    if (i < j) {
      return 1;
    }
    return subCompareTo(paramPriorityJob);
  }
  
  public T run(ThreadPool.JobContext paramJobContext)
  {
    try
    {
      String str = Thread.currentThread().getName();
      str = str.substring(0, str.indexOf(" sub:") + 5);
      Thread localThread = Thread.currentThread();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.mJob.getClass().toString());
      localThread.setName(localStringBuilder.toString());
      label66:
      return this.mJob.run(paramJobContext);
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadPool.PriorityJob
 * JD-Core Version:    0.7.0.1
 */