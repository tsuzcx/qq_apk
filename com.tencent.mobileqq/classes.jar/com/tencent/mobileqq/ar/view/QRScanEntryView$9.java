package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.ScanEntranceDPC;

class QRScanEntryView$9
  implements Runnable
{
  QRScanEntryView$9(QRScanEntryView paramQRScanEntryView, int paramInt) {}
  
  public void run()
  {
    if (!QRScanEntryView.b(this.this$0))
    {
      boolean bool;
      if (this.a <= ScanEntranceDPC.a().c) {
        bool = true;
      } else {
        bool = false;
      }
      if (QRScanEntryView.a(this.this$0) != bool)
      {
        QRScanEntryView.b(this.this$0, bool);
        QRScanEntryView.a(this.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.9
 * JD-Core Version:    0.7.0.1
 */