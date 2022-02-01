package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.ScanEntranceDPC;

class QRScanEntryView$9
  implements Runnable
{
  QRScanEntryView$9(QRScanEntryView paramQRScanEntryView, int paramInt) {}
  
  public void run()
  {
    if (!QRScanEntryView.d(this.this$0))
    {
      boolean bool;
      if (this.a <= ScanEntranceDPC.a().h) {
        bool = true;
      } else {
        bool = false;
      }
      if (QRScanEntryView.c(this.this$0) != bool)
      {
        QRScanEntryView.d(this.this$0, bool);
        QRScanEntryView.b(this.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.9
 * JD-Core Version:    0.7.0.1
 */