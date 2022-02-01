import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenSdkQIPCModule.1;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class bizv
  extends QIPCModule
{
  private static volatile bizv a;
  
  private bizv(String paramString)
  {
    super(paramString);
  }
  
  public static bizv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bizv("open_sdk_qipc_module");
      }
      return a;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.getInt("key_sso_ret", -1000) == 0)
    {
      String str = paramBundle.getString("uin");
      boolean bool = paramBundle.getBoolean("is_from_login");
      bjmq.b(str);
      bkki.a(BaseActivity.sTopActivity, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      OpenSdkIMBlockFragment.a(BaseActivity.sTopActivity, str, bool);
    }
    for (;;)
    {
      if ((BaseActivity.sTopActivity instanceof NotificationActivity)) {
        BaseActivity.sTopActivity.finish();
      }
      return;
      QQToast.a(BaseActivity.sTopActivity, 2131694461, 0).a();
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.i("Q.quicklogin.OpenSdkQIPCModule", 1, "onCall main proc action : " + paramString);
    if ("action_get_accountInfo".equals(paramString))
    {
      paramString = new Bundle();
      EIPCResult localEIPCResult = EIPCResult.createResult(0, paramString);
      paramBundle = paramBundle.getString("uin");
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((!TextUtils.isEmpty(paramBundle)) && ((localAppRuntime instanceof QQAppInterface))) {
        paramString.putString("key_nickname", ContactUtils.getFriendNickName((QQAppInterface)localAppRuntime, paramBundle));
      }
      callbackResult(paramInt, localEIPCResult);
    }
    do
    {
      for (;;)
      {
        return null;
        if ("action_ptlogin_cancel".equals(paramString))
        {
          paramString = BaseActivity.sTopActivity;
          QLog.i("Q.quicklogin.OpenSdkQIPCModule", 1, "onCall ptlogin cancel activity=" + paramString);
          if ((paramString instanceof SplashActivity)) {
            paramString.doOnBackPressed();
          }
        }
        else
        {
          if (!"action_on_sso_login_complete".equals(paramString)) {
            break;
          }
          ThreadManager.getUIHandler().post(new OpenSdkQIPCModule.1(this, paramBundle));
        }
      }
    } while (!"action_on_agent_activity_destroy".equals(paramString));
    GuardManager.a.b("com.tencent.mobileqq:openSdk");
    return EIPCResult.createResult(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizv
 * JD-Core Version:    0.7.0.1
 */