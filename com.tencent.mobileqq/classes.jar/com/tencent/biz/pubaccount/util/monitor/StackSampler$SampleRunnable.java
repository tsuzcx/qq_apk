package com.tencent.biz.pubaccount.util.monitor;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class StackSampler$SampleRunnable
  implements Runnable
{
  public void run()
  {
    if (StackSampler.a(this.this$0))
    {
      StackSampler.a(this.this$0);
      ThreadManager.getSubThreadHandler().postDelayed(StackSampler.a(this.this$0), 52L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.StackSampler.SampleRunnable
 * JD-Core Version:    0.7.0.1
 */