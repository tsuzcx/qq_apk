package com.tencent.mobileqq.app;

import java.util.concurrent.ThreadFactory;

class PriorityThreadFactory
  implements ThreadFactory
{
  public String mName;
  public int mPriority;
  public volatile int threadIndex = 0;
  
  PriorityThreadFactory(String paramString, int paramInt)
  {
    this.mPriority = paramInt;
    this.mName = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    this.threadIndex += 1;
    if (this.threadIndex > 10000) {
      this.threadIndex = 0;
    }
    return new Thread(paramRunnable, this.mName + this.threadIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */