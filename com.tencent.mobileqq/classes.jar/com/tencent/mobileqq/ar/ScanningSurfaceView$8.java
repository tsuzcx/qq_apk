package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.qphone.base.util.QLog;

class ScanningSurfaceView$8
  implements Runnable
{
  ScanningSurfaceView$8(ScanningSurfaceView paramScanningSurfaceView, ScanningData paramScanningData1, ScanningData paramScanningData2) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.a) && (this.a.f))
    {
      this.a.c();
      this.a.w();
      this.a.a = false;
      if (QLog.isColorLevel()) {
        QLog.d("ScanningSurfaceView", 2, "4=" + this.a.a);
      }
      this.a.c = false;
      ScanningSurfaceView.a(this.this$0, this.a);
    }
    if (this.b != null)
    {
      this.b.c();
      this.b.w();
      this.b.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("ScanningSurfaceView", 2, "5=" + this.b.a);
      }
      this.b.c = true;
      this.this$0.a.a.a(3, this.b.g, this.b.h, new ScanningSurfaceView.8.1(this));
      ScanningSurfaceView.a(this.this$0, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView.8
 * JD-Core Version:    0.7.0.1
 */