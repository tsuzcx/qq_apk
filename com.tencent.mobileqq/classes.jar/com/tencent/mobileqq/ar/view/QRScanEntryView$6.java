package com.tencent.mobileqq.ar.view;

import android.net.Uri;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.qphone.base.util.QLog;
import zmh;
import zmk;

class QRScanEntryView$6
  implements Runnable
{
  QRScanEntryView$6(QRScanEntryView paramQRScanEntryView, String paramString) {}
  
  public void run()
  {
    ScannerResult localScannerResult = zmk.a(Uri.parse("file://" + this.a), this.this$0.a, 3);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "doDealGalleryPicFile scannerResult:" + localScannerResult);
    }
    zmh localzmh = new zmh();
    localzmh.a = this.a;
    QRScanEntryView.a(this.this$0, localScannerResult, localzmh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.6
 * JD-Core Version:    0.7.0.1
 */