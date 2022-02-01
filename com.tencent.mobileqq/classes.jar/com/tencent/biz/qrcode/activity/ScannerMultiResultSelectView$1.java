package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import zmh;

class ScannerMultiResultSelectView$1
  implements Runnable
{
  ScannerMultiResultSelectView$1(ScannerMultiResultSelectView paramScannerMultiResultSelectView, zmh paramzmh) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScannerMultiResultSelectView", 2, "decodeBitmap mShowing：" + ScannerMultiResultSelectView.a(this.this$0));
    }
    if (!ScannerMultiResultSelectView.a(this.this$0)) {
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        ScannerMultiResultSelectView.a(this.this$0, PhotoUtils.getBitmapFromFile(this.a.jdField_a_of_type_JavaLangString, ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight()));
      }
      for (;;)
      {
        ScannerMultiResultSelectView.a(this.this$0);
        return;
        if (this.a.jdField_a_of_type_ArrayOfByte != null)
        {
          ScannerMultiResultSelectView.a(this.this$0, ScannerMultiResultSelectView.a(this.a.jdField_a_of_type_ArrayOfByte, this.a.jdField_a_of_type_Int, this.a.b));
          this.a.jdField_a_of_type_ArrayOfByte = null;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ScannerMultiResultSelectView.a(this.this$0, null);
        QLog.i("ScannerMultiResultSelectView", 2, "decodeBitmap error:", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView.1
 * JD-Core Version:    0.7.0.1
 */