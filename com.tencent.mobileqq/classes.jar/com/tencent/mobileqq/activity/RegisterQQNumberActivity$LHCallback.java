package com.tencent.mobileqq.activity;

import android.os.Looper;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.RequestCallBack;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class RegisterQQNumberActivity$LHCallback
  implements CheckRegisterLiangHao.RequestCallBack
{
  private final WeakReference<RegisterQQNumberActivity> a;
  
  RegisterQQNumberActivity$LHCallback(RegisterQQNumberActivity paramRegisterQQNumberActivity)
  {
    this.a = new WeakReference(paramRegisterQQNumberActivity);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterQQNumberActivity", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
      return;
    }
    RegisterQQNumberActivity localRegisterQQNumberActivity = (RegisterQQNumberActivity)this.a.get();
    if (localRegisterQQNumberActivity != null) {
      localRegisterQQNumberActivity.a(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity.LHCallback
 * JD-Core Version:    0.7.0.1
 */