package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import com.tencent.mobileqq.ar.model.QRSession;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.ImageData;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.MultiSelectListener;
import com.tencent.qphone.base.util.QLog;

class QRScanEntryView$16
  implements ScannerMultiResultSelectView.MultiSelectListener
{
  QRScanEntryView$16(QRScanEntryView paramQRScanEntryView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onMultiCancel");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession instanceof QRSession)) && (this.a.m)) {
      this.a.postDelayed(new QRScanEntryView.16.1(this), 500L);
    }
  }
  
  public void a(QBarResult paramQBarResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMultiSelectQr result:");
      ((StringBuilder)localObject).append(paramQBarResult);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AREngine_QRScanEntryView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    String str1 = paramQBarResult.b;
    String str2 = paramQBarResult.a;
    Activity localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
    if (paramImageData != null) {
      paramQBarResult = paramImageData.a;
    } else {
      paramQBarResult = null;
    }
    QRScanEntryView.a((QRScanEntryView)localObject, str1, str2, localActivity, paramQBarResult);
  }
  
  public void a(QMiniResult paramQMiniResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMultiSelectMini result:");
      ((StringBuilder)localObject).append(paramQMiniResult);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AREngine_QRScanEntryView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    String str = paramQMiniResult.a;
    Activity localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
    if (paramImageData != null) {
      paramQMiniResult = paramImageData.a;
    } else {
      paramQMiniResult = null;
    }
    QRScanEntryView.a((QRScanEntryView)localObject, str, localActivity, paramQMiniResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.16
 * JD-Core Version:    0.7.0.1
 */