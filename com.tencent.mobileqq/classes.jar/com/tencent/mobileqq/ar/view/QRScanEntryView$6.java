package com.tencent.mobileqq.ar.view;

import android.net.Uri;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.ImageData;
import com.tencent.qphone.base.util.QLog;

class QRScanEntryView$6
  implements Runnable
{
  QRScanEntryView$6(QRScanEntryView paramQRScanEntryView, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("file://");
    ((StringBuilder)localObject1).append(this.a);
    localObject1 = Uri.parse(((StringBuilder)localObject1).toString());
    localObject1 = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile((Uri)localObject1, this.this$0.a, 3, false);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doDealGalleryPicFile scannerResult:");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("AREngine_QRScanEntryView", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ScannerMultiResultSelectView.ImageData();
    ((ScannerMultiResultSelectView.ImageData)localObject2).a = this.a;
    QRScanEntryView.a(this.this$0, (ScannerResult)localObject1, (ScannerMultiResultSelectView.ImageData)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.6
 * JD-Core Version:    0.7.0.1
 */