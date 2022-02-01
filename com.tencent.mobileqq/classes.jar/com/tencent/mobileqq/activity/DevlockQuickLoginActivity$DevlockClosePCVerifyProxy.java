package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.quicklogin.ClosePCVerifyProxy;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class DevlockQuickLoginActivity$DevlockClosePCVerifyProxy
  implements ClosePCVerifyProxy
{
  private WeakReference<BaseActivity> a;
  private WeakReference<TextView> b;
  
  public DevlockQuickLoginActivity$DevlockClosePCVerifyProxy(WeakReference<BaseActivity> paramWeakReference, WeakReference<TextView> paramWeakReference1)
  {
    if (paramWeakReference != null)
    {
      if (paramWeakReference1 == null) {
        return;
      }
      this.a = paramWeakReference;
      this.b = paramWeakReference1;
    }
  }
  
  private boolean a()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (this.b != null) && (localWeakReference.get() != null) && (this.b.get() != null)) {
      return false;
    }
    QLog.e("DevlockQuickLoginActivity", 1, "sanityCheckPCVerifyWrong(): params empty");
    return true;
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity.DevlockClosePCVerifyProxy
 * JD-Core Version:    0.7.0.1
 */