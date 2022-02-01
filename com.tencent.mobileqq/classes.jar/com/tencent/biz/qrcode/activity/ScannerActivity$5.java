package com.tencent.biz.qrcode.activity;

import com.tencent.qbar.QBarResult;
import com.tencent.qphone.base.util.QLog;

class ScannerActivity$5
  implements ScannerMultiResultSelectView.MultiSelectListener
{
  ScannerActivity$5(ScannerActivity paramScannerActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onMultiCancel");
    }
    this.a.doOnBackPressed();
  }
  
  public void a(QMiniResult paramQMiniResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onMultiSelectMini result:" + paramQMiniResult + " " + paramInt);
    }
    ScannerActivity.a(this.a, 2, "", paramQMiniResult.a, paramInt);
  }
  
  public void a(QBarResult paramQBarResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onMultiSelectQr result:" + paramQBarResult + " " + paramInt);
    }
    ScannerActivity.a(this.a, 1, paramQBarResult.a, paramQBarResult.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity.5
 * JD-Core Version:    0.7.0.1
 */