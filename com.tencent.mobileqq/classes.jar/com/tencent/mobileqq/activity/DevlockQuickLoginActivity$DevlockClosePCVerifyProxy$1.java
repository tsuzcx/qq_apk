package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class DevlockQuickLoginActivity$DevlockClosePCVerifyProxy$1
  implements Runnable
{
  DevlockQuickLoginActivity$DevlockClosePCVerifyProxy$1(DevlockQuickLoginActivity.DevlockClosePCVerifyProxy paramDevlockClosePCVerifyProxy, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleSetPCVerify: isSuccess: ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("DevlockQuickLoginActivity", 1, ((StringBuilder)localObject1).toString());
      if (DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.a(this.this$0)) {
        return;
      }
      localObject1 = (BaseActivity)DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.a(this.this$0).get();
      localObject2 = (TextView)DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.b(this.this$0).get();
      if (((BaseActivity)localObject1).isFinishing())
      {
        QLog.e("DevlockQuickLoginActivity", 1, "handleSetPCVerify error: activity.isFinishing()");
        return;
      }
      if (this.a)
      {
        ((TextView)localObject2).setVisibility(4);
        QQToast.a(BaseApplication.getContext(), 2, 2131698701, 1).a();
        return;
      }
      QQToast.a(BaseApplication.getContext(), 1, 2131698700, 1).a();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleSetPCVerify error: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("DevlockQuickLoginActivity", 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.1
 * JD-Core Version:    0.7.0.1
 */