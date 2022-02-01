import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

public class bjsy
{
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, EIPCResultCallback paramEIPCResultCallback)
  {
    if (paramEIPCResultCallback == null)
    {
      QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk callback is null");
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.d("LoginHelper", 1, new Object[] { "toWtLoginOnOpenSdk appId=", paramString3, ", uin=", bipr.a(paramString1) });
      paramString2 = new Bundle();
      paramString2.putString("key_uin", paramString1);
      paramString2.putInt("key_sso_ret", 1007);
      paramEIPCResultCallback.onCallback(EIPCResult.createResult(-102, paramString2));
      return;
    }
    QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_uin", paramString1);
    localBundle.putString("key_passwd", paramString2);
    localBundle.putString("key_appid", paramString3);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:openSdk", "ae_camera_get_info_client", "action_to_wt_login", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    QLog.d("LoginHelper", 1, new Object[] { "doWtLoginOnOpenSdk appId=", paramString1, ", uin=", bipr.a(paramString2), ", observer=", paramSSOAccountObserver });
    if (!a(paramString1, paramString2, paramString3, paramSSOAccountObserver)) {
      return;
    }
    AppRuntime localAppRuntime;
    try
    {
      localAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
      QLog.d("LoginHelper", 1, new Object[] { "doWtLoginOnOpenSdk app = ", localAppRuntime });
      if (localAppRuntime == null)
      {
        paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
        return;
      }
    }
    catch (Exception paramString2)
    {
      QLog.e("LoginHelper", 1, "Exception ", paramString2);
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("connect_data", bipr.a(paramString1));
    localAppRuntime.ssoLogin(paramString2, paramString3, 4096, paramSSOAccountObserver, localBundle);
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    if (paramSSOAccountObserver == null)
    {
      QLog.d("LoginHelper", 1, "checkParamsValid null == observer");
      return false;
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("LoginHelper", 1, "checkParamsValid invalid params");
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return false;
    }
    if (!"com.tencent.mobileqq:openSdk".equals(BaseApplicationImpl.getApplication().getQQProcessName()))
    {
      QLog.d("LoginHelper", 1, new Object[] { "checkParamsValid process = ", BaseApplicationImpl.getApplication().getQQProcessName() });
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsy
 * JD-Core Version:    0.7.0.1
 */