package com.tencent.biz.widgets;

import android.hardware.Camera;

class ScannerView$AutoFocusThread$1
  implements Runnable
{
  ScannerView$AutoFocusThread$1(ScannerView.AutoFocusThread paramAutoFocusThread) {}
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    try
    {
      this.a.a.cancelAutoFocus();
      label21:
      ScannerView.b(this.a.this$0, true);
      return;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.AutoFocusThread.1
 * JD-Core Version:    0.7.0.1
 */