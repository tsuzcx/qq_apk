package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.model.QRSession;

class QRScanEntryView$16$1
  implements Runnable
{
  QRScanEntryView$16$1(QRScanEntryView.16 param16) {}
  
  public void run()
  {
    if ((this.a.a.m) && (this.a.a.a != null) && ((this.a.a.a instanceof QRSession))) {
      ((QRSession)this.a.a.a).b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.16.1
 * JD-Core Version:    0.7.0.1
 */