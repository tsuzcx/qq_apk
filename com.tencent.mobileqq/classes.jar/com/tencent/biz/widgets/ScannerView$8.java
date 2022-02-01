package com.tencent.biz.widgets;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;

class ScannerView$8
  implements Runnable
{
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      label6:
      Camera localCamera = this.this$0.o;
      if (localCamera == null)
      {
        this.this$0.u.obtainMessage(10, Boolean.FALSE).sendToTarget();
        return;
      }
      ScannerView.a(this.this$0, localCamera, this.a);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.8
 * JD-Core Version:    0.7.0.1
 */