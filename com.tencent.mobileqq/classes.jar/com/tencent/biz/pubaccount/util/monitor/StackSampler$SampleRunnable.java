package com.tencent.biz.pubaccount.util.monitor;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class StackSampler$SampleRunnable
  implements Runnable
{
  private StackSampler$SampleRunnable(StackSampler paramStackSampler) {}
  
  public void run()
  {
    if (StackSampler.a(this.this$0))
    {
      StackSampler.b(this.this$0);
      ThreadManager.getSubThreadHandler().postDelayed(StackSampler.c(this.this$0), 52L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.StackSampler.SampleRunnable
 * JD-Core Version:    0.7.0.1
 */