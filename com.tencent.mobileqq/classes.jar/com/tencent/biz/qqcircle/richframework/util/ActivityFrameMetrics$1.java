package com.tencent.biz.qqcircle.richframework.util;

import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import com.tencent.qphone.base.util.QLog;

class ActivityFrameMetrics$1
  implements Window.OnFrameMetricsAvailableListener
{
  private int c = 0;
  private int d = 0;
  
  ActivityFrameMetrics$1(ActivityFrameMetrics paramActivityFrameMetrics, String paramString) {}
  
  public void onFrameMetricsAvailable(Window paramWindow, FrameMetrics paramFrameMetrics, int paramInt)
  {
    paramFrameMetrics = new FrameMetrics(paramFrameMetrics);
    this.c += 1;
    double d1 = paramFrameMetrics.getMetric(8);
    Double.isNaN(d1);
    float f1 = (float)(d1 * 1.0E-006D);
    if (f1 > ActivityFrameMetrics.a(this.b))
    {
      this.d += 1;
      paramWindow = String.format("Janky frame detected on %s with total duration: %.2fms\n", new Object[] { this.a, Float.valueOf(f1) });
      d1 = paramFrameMetrics.getMetric(3);
      Double.isNaN(d1);
      float f2 = (float)(d1 * 1.0E-006D);
      d1 = paramFrameMetrics.getMetric(4);
      Double.isNaN(d1);
      float f3 = (float)(d1 * 1.0E-006D);
      d1 = paramFrameMetrics.getMetric(6);
      Double.isNaN(d1);
      float f4 = (float)(d1 * 1.0E-006D);
      float f5 = this.d / this.c;
      paramFrameMetrics = new StringBuilder();
      paramFrameMetrics.append(paramWindow);
      paramFrameMetrics.append(String.format("Layout/measure: %.2fms, draw:%.2fms, gpuCommand:%.2fms others:%.2fms\n", new Object[] { Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1 - f2 - f3 - f4) }));
      paramWindow = paramFrameMetrics.toString();
      paramFrameMetrics = new StringBuilder();
      paramFrameMetrics.append(paramWindow);
      paramFrameMetrics.append("Janky frames: ");
      paramFrameMetrics.append(this.d);
      paramFrameMetrics.append("/");
      paramFrameMetrics.append(this.c);
      paramFrameMetrics.append("(");
      paramFrameMetrics.append(f5 * 100.0F);
      paramFrameMetrics.append("%)");
      paramWindow = paramFrameMetrics.toString();
      if ((ActivityFrameMetrics.b(this.b)) && (f1 > ActivityFrameMetrics.c(this.b)))
      {
        QLog.e("ActivityFrameMetrics", 1, paramWindow);
        return;
      }
      if (ActivityFrameMetrics.d(this.b)) {
        QLog.w("ActivityFrameMetrics", 1, paramWindow);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.ActivityFrameMetrics.1
 * JD-Core Version:    0.7.0.1
 */