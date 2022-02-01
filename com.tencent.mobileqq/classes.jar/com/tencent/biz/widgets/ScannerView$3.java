package com.tencent.biz.widgets;

import android.os.Handler;

class ScannerView$3
  implements Runnable
{
  ScannerView$3(ScannerView paramScannerView) {}
  
  public void run()
  {
    if (!ScannerView.b(this.this$0)) {
      this.this$0.b.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.3
 * JD-Core Version:    0.7.0.1
 */