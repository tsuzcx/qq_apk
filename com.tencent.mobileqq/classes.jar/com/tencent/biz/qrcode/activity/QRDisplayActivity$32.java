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
    QRDisplayActivity.j(this.e);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadCanceled:");
      paramURLDrawable.append(this.a.a);
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
      paramThrowable.append(this.a.a);
      QLog.d("QRDisplayActivity", 2, paramThrowable.toString());
    }
    if (paramURLDrawable != null) {
      this.e.aa.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
    QRDisplayActivity.j(this.e);
    paramURLDrawable = this.e;
    QQToast.makeText(paramURLDrawable, paramURLDrawable.getString(2131894236), 0).show();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.a(this.e, this.a, this.b, this.c, this.d);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoadSuccessed: urlDrawable = ");
      localStringBuilder.append(paramURLDrawable);
      localStringBuilder.append(" bkgURL = ");
      localStringBuilder.append(this.a.a);
      QLog.d("QRDisplayActivity", 2, localStringBuilder.toString());
    }
    if (paramURLDrawable != null) {
      this.e.aa.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.32
 * JD-Core Version:    0.7.0.1
 */