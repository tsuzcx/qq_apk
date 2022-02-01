package com.tencent.mobileqq.ar;

class FramePerformanceMonitor$CurrentRunnable
  implements Runnable
{
  private boolean a = false;
  
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
      GapDataCollector.RefreshData localRefreshData = FramePerformanceMonitor.a(this.this$0).a();
      FramePerformanceMonitor.a(this.this$0).a(localRefreshData);
      Thread.sleep(FramePerformanceMonitor.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor.CurrentRunnable
 * JD-Core Version:    0.7.0.1
 */