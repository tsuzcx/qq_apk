package com.tencent.mobileqq.activity;

import android.os.Looper;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.RequestCallBack;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AutoLoginHelper$LHCallback
  implements CheckRegisterLiangHao.RequestCallBack
{
  private final WeakReference<AutoLoginHelper> a;
  
  AutoLoginHelper$LHCallback(AutoLoginHelper paramAutoLoginHelper)
  {
    this.a = new WeakReference(paramAutoLoginHelper);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
      return;
    }
    AutoLoginHelper localAutoLoginHelper = (AutoLoginHelper)this.a.get();
    if (localAutoLoginHelper != null) {
      localAutoLoginHelper.a(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.LHCallback
 * JD-Core Version:    0.7.0.1
 */