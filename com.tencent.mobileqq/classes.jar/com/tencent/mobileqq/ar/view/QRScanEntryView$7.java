package com.tencent.mobileqq.ar.view;

import android.graphics.Bitmap;
import com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.qphone.base.util.QLog;
import zmh;
import zmk;

class QRScanEntryView$7
  implements Runnable
{
  QRScanEntryView$7(QRScanEntryView paramQRScanEntryView, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult, zmh paramzmh) {}
  
  public void run()
  {
    Object localObject = ScannerMultiResultSelectView.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b);
    ScannerResult localScannerResult = null;
    if (localObject != null) {
      localScannerResult = zmk.a((Bitmap)localObject, 3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onRecognizeSuccess new result:" + localScannerResult + " bitmap:" + localObject);
    }
    localObject = this.this$0;
    if ((localScannerResult != null) && (localScannerResult.b())) {}
    for (;;)
    {
      QRScanEntryView.a((QRScanEntryView)localObject, localScannerResult, this.jdField_a_of_type_Zmh);
      return;
      localScannerResult = this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.7
 * JD-Core Version:    0.7.0.1
 */