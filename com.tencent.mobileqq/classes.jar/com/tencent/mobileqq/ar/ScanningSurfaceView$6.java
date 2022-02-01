package com.tencent.mobileqq.ar;

import bdla;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

class ScanningSurfaceView$6
  implements Runnable
{
  ScanningSurfaceView$6(ScanningSurfaceView paramScanningSurfaceView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (ScanningSurfaceView.a(this.this$0).size() > 0)
    {
      ScanningSurfaceView.b(this.this$0).add(this.a);
      ScanningSurfaceView.a(this.this$0, this.b);
      bdla.b(null, "dc00898", "", "", "0X8008350", "0X8008350", 0, 0, "", "", "", "");
      return;
    }
    QLog.d("ScanningSurfaceView", 1, "the dataList is null, cancel the jump action.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */