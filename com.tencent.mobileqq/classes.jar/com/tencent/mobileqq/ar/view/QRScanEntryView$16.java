package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import com.tencent.biz.qrcode.activity.QMiniResult;
import com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView.ImageData;
import com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView.MultiSelectListener;
import com.tencent.mobileqq.ar.model.QRSession;
import com.tencent.qbar.QBarResult;
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
  
  public void a(QMiniResult paramQMiniResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onMultiSelectMini result:" + paramQMiniResult + " " + paramInt);
    }
    QRScanEntryView localQRScanEntryView = this.a;
    String str = paramQMiniResult.a;
    Activity localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
    if (paramImageData != null) {}
    for (paramQMiniResult = paramImageData.a;; paramQMiniResult = null)
    {
      QRScanEntryView.a(localQRScanEntryView, str, localActivity, paramQMiniResult);
      return;
    }
  }
  
  public void a(QBarResult paramQBarResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QRScanEntryView", 2, "onMultiSelectQr result:" + paramQBarResult + " " + paramInt);
    }
    QRScanEntryView localQRScanEntryView = this.a;
    String str1 = paramQBarResult.b;
    String str2 = paramQBarResult.a;
    Activity localActivity = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
    if (paramImageData != null) {}
    for (paramQBarResult = paramImageData.a;; paramQBarResult = null)
    {
      QRScanEntryView.a(localQRScanEntryView, str1, str2, localActivity, paramQBarResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.16
 * JD-Core Version:    0.7.0.1
 */