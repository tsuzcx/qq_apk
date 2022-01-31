package com.tencent.mobileqq.ar;

import amxx;
import amxy;
import amxz;

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
      amxz localamxz = FramePerformanceMonitor.a(this.this$0).a();
      FramePerformanceMonitor.a(this.this$0).a(localamxz);
      Thread.sleep(FramePerformanceMonitor.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor.CurrentRunnable
 * JD-Core Version:    0.7.0.1
 */