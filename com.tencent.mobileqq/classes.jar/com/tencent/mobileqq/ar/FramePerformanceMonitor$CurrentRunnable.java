package com.tencent.mobileqq.ar;

class FramePerformanceMonitor$CurrentRunnable
  implements Runnable
{
  private boolean a;
  
  public void run()
  {
    try
    {
      while (this.a) {
        if (FramePerformanceMonitor.a(this.this$0).a() == 0)
        {
          Thread.sleep(FramePerformanceMonitor.a(this.this$0));
        }
        else
        {
          GapDataCollector.RefreshData localRefreshData = FramePerformanceMonitor.a(this.this$0).a();
          FramePerformanceMonitor.a(this.this$0).a(localRefreshData);
          Thread.sleep(FramePerformanceMonitor.a(this.this$0));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor.CurrentRunnable
 * JD-Core Version:    0.7.0.1
 */