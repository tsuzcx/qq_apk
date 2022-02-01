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
    TextView localTextView;
    try
    {
      QLog.d("DevlockQuickLoginActivity", 1, "handleSetPCVerify: isSuccess: " + this.a);
      if (DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.a(this.this$0)) {
        return;
      }
      BaseActivity localBaseActivity = (BaseActivity)DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.a(this.this$0).get();
      localTextView = (TextView)DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.b(this.this$0).get();
      if (localBaseActivity.isFinishing())
      {
        QLog.e("DevlockQuickLoginActivity", 1, "handleSetPCVerify error: activity.isFinishing()");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("DevlockQuickLoginActivity", 1, "handleSetPCVerify error: " + localException.getMessage());
      return;
    }
    if (this.a)
    {
      localTextView.setVisibility(4);
      QQToast.a(BaseApplication.getContext(), 2, 2131698635, 1).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131698634, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.1
 * JD-Core Version:    0.7.0.1
 */