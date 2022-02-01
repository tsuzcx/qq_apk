import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aony
  implements aonv
{
  private WeakReference<LoginActivity> a;
  
  public aony(BaseActivity paramBaseActivity)
  {
    if (a(paramBaseActivity)) {
      return;
    }
    this.a = new WeakReference((LoginActivity)paramBaseActivity);
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
  
  private boolean a(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity == null) || (!(paramBaseActivity instanceof LoginActivity)))
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "LoginViewOpenSDKCb constructor params wrong");
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
    LoginActivity localLoginActivity = (LoginActivity)this.a.get();
    if (localLoginActivity == null)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "onLoginFailed error: activity == null");
      return;
    }
    QQToast.a(localLoginActivity, 2131698537, 0).a();
  }
  
  public void a(String paramString)
  {
    QLog.d("ThirdPartyLoginUtilImpl", 1, "onLoginSuccess");
    bdll.a(null, "dc00898", "", "", "0X800B18A", "0X800B18A", 0, 0, "", "", "", "");
    if (a()) {
      return;
    }
    LoginActivity localLoginActivity = (LoginActivity)this.a.get();
    if (localLoginActivity == null)
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "onLoginSuccess error: activity == null");
      return;
    }
    ThreadManager.getUIHandler().post(new ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb.1(this, localLoginActivity, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aony
 * JD-Core Version:    0.7.0.1
 */