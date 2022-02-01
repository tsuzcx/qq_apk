package com.tencent.mobileqq.ar.view;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.ImageData;
import com.tencent.qphone.base.util.QLog;

class QRScanEntryView$7
  implements Runnable
{
  QRScanEntryView$7(QRScanEntryView paramQRScanEntryView, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult, ScannerMultiResultSelectView.ImageData paramImageData) {}
  
  public void run()
  {
    Object localObject = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeBitmapFromYuv(this.a, this.b, this.c);
    ScannerResult localScannerResult;
    if (localObject != null) {
      localScannerResult = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp((Bitmap)localObject, 3);
    } else {
      localScannerResult = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecognizeSuccess new result:");
      localStringBuilder.append(localScannerResult);
      localStringBuilder.append(" bitmap:");
      localStringBuilder.append(localObject);
      QLog.d("AREngine_QRScanEntryView", 2, localStringBuilder.toString());
    }
    localObject = this.this$0;
    if ((localScannerResult == null) || (!localScannerResult.f())) {
      localScannerResult = this.d;
    }
    QRScanEntryView.a((QRScanEntryView)localObject, localScannerResult, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.7
 * JD-Core Version:    0.7.0.1
 */