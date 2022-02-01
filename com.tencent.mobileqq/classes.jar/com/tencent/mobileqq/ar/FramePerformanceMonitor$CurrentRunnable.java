package com.tencent.mobileqq.ar;

import aowo;
import aowp;
import aowq;

class FramePerformanceMonitor$CurrentRunnable
  implements Runnable
{
  private boolean a;
  
  private FramePerformanceMonitor$CurrentRunnable(FramePerformanceMonitor paramFramePerformanceMonitor) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a)
        {
          if (FramePerformanceMonitor.a(this.this$0).a() == 0) {
            Thread.sleep(FramePerformanceMonitor.a(this.this$0));
          }
        }
        else {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      aowq localaowq = FramePerformanceMonitor.a(this.this$0).a();
      FramePerformanceMonitor.a(this.this$0).a(localaowq);
      Thread.sleep(FramePerformanceMonitor.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor.CurrentRunnable
 * JD-Core Version:    0.7.0.1
 */