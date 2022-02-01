package com.tencent.biz.qrcode.activity;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.config.business.QrCodeConfBean.QrCodeList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QRDisplayActivity$32
  implements URLDrawable.URLDrawableListener
{
  QRDisplayActivity$32(QRDisplayActivity paramQRDisplayActivity, QrCodeConfBean.QrCodeList paramQrCodeList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.e(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadCanceled:" + this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList.a);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadFialed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList.a);
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.j.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
    QRDisplayActivity.e(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    QQToast.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.getString(2131696445), 0).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadSuccessed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList.a);
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.j.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.32
 * JD-Core Version:    0.7.0.1
 */