package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.qrscan.QRCodeEncodeCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QRDisplayActivity$QRCodeEncodeCallbackImp
  implements QRCodeEncodeCallback
{
  public WeakReference<QRDisplayActivity> a;
  public String b;
  public int c;
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (QRDisplayActivity)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, String.format("onReceive qrcode url:%s suc:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if (!((QRDisplayActivity)localObject).h)
    {
      if (((QRDisplayActivity)localObject).isFinishing()) {
        return;
      }
      if (!paramBoolean)
      {
        ((QRDisplayActivity)localObject).i();
        return;
      }
      ((QRDisplayActivity)localObject).a(this.b, this.c, paramString);
      paramString = QRUtils.a(paramString, -1);
      if (paramString != null)
      {
        ((QRDisplayActivity)localObject).e = paramString;
        ((QRDisplayActivity)localObject).h();
        return;
      }
      ((QRDisplayActivity)localObject).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.QRCodeEncodeCallbackImp
 * JD-Core Version:    0.7.0.1
 */