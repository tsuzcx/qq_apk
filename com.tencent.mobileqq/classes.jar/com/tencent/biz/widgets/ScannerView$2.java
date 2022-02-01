package com.tencent.biz.widgets;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ScannerView$2
  implements Runnable
{
  ScannerView$2(ScannerView paramScannerView) {}
  
  public void run()
  {
    if ((ScannerView.d(this.this$0)) && (ScannerView.e(this.this$0)))
    {
      ThreadManager.getUIHandler().post(new ScannerView.2.1(this));
      this.this$0.u.sendEmptyMessage(7);
      return;
    }
    this.this$0.u.sendEmptyMessage(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.2
 * JD-Core Version:    0.7.0.1
 */