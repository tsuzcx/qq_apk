package androidx.core.app;

import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;

class FrameMetricsAggregator$FrameMetricsApi24Impl$1
  implements Window.OnFrameMetricsAvailableListener
{
  FrameMetricsAggregator$FrameMetricsApi24Impl$1(FrameMetricsAggregator.FrameMetricsApi24Impl paramFrameMetricsApi24Impl) {}
  
  public void onFrameMetricsAvailable(Window paramWindow, FrameMetrics paramFrameMetrics, int paramInt)
  {
    if ((this.this$0.mTrackingFlags & 0x1) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[0], paramFrameMetrics.getMetric(8));
    }
    if ((this.this$0.mTrackingFlags & 0x2) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[1], paramFrameMetrics.getMetric(1));
    }
    if ((this.this$0.mTrackingFlags & 0x4) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[2], paramFrameMetrics.getMetric(3));
    }
    if ((this.this$0.mTrackingFlags & 0x8) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[3], paramFrameMetrics.getMetric(4));
    }
    if ((this.this$0.mTrackingFlags & 0x10) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[4], paramFrameMetrics.getMetric(5));
    }
    if ((this.this$0.mTrackingFlags & 0x40) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[6], paramFrameMetrics.getMetric(7));
    }
    if ((this.this$0.mTrackingFlags & 0x20) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[5], paramFrameMetrics.getMetric(6));
    }
    if ((this.this$0.mTrackingFlags & 0x80) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[7], paramFrameMetrics.getMetric(0));
    }
    if ((this.this$0.mTrackingFlags & 0x100) != 0)
    {
      paramWindow = this.this$0;
      paramWindow.addDurationItem(paramWindow.mMetrics[8], paramFrameMetrics.getMetric(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
 * JD-Core Version:    0.7.0.1
 */