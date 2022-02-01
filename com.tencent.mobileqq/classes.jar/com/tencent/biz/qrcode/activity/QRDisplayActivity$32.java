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
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadCanceled:");
      paramURLDrawable.append(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList.a);
      QLog.d("QRDisplayActivity", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("onLoadFialed: urlDrawable = ");
      paramThrowable.append(paramURLDrawable);
      paramThrowable.append(" bkgURL = ");
      paramThrowable.append(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList.a);
      QLog.d("QRDisplayActivity", 2, paramThrowable.toString());
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.j.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
    QRDisplayActivity.e(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    paramURLDrawable = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity;
    QQToast.a(paramURLDrawable, paramURLDrawable.getString(2131696464), 0).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoadSuccessed: urlDrawable = ");
      localStringBuilder.append(paramURLDrawable);
      localStringBuilder.append(" bkgURL = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQrCodeConfBean$QrCodeList.a);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.j.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.32
 * JD-Core Version:    0.7.0.1
 */