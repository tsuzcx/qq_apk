package com.tencent.mobileqq.app.decoupleim;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ThirdPartyLoginBlockUtilImpl$LoginViewOpenSDKCb
  implements OpenSDKLoginCallback
{
  private WeakReference<QBaseActivity> a;
  
  public ThirdPartyLoginBlockUtilImpl$LoginViewOpenSDKCb(QBaseActivity paramQBaseActivity)
  {
    if (paramQBaseActivity == null)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "LoginViewOpenSDKCb constructor params wrong");
      return;
    }
    this.a = new WeakReference(paramQBaseActivity);
  }
  
  private boolean a()
  {
    if (this.a == null)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "LoginViewOpenSDKCb mActRef error");
      return true;
    }
    return false;
  }
  
  public void a()
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "onLoginFailed");
    if (a()) {
      return;
    }
    QBaseActivity localQBaseActivity = (QBaseActivity)this.a.get();
    if (localQBaseActivity == null)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "onLoginFailed error: activity == null");
      return;
    }
    QQToast.a(localQBaseActivity, 2131699704, 0).a();
  }
  
  public void a(String paramString)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "onLoginSuccess");
    ReportController.a(null, "dc00898", "", "", "0X800B18A", "0X800B18A", 0, 0, "", "", "", "");
    if (a()) {
      return;
    }
    QBaseActivity localQBaseActivity = (QBaseActivity)this.a.get();
    if (localQBaseActivity == null)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "onLoginSuccess error: activity == null");
      return;
    }
    ThreadManager.getUIHandler().post(new ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb.1(this, localQBaseActivity, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb
 * JD-Core Version:    0.7.0.1
 */