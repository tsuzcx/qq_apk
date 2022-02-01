import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

public class bkki
{
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static void a(Activity paramActivity)
  {
    QLog.d("LoginHelper", 1, "ssoLoginByIMBlock");
    Intent localIntent1 = paramActivity.getIntent();
    if (localIntent1 == null)
    {
      QLog.e("LoginHelper", 1, "ssoLoginByIMBlock null == srcIntent");
      return;
    }
    Intent localIntent2 = new Intent(paramActivity, AgentActivity.class);
    localIntent2.putExtra("appid", "0");
    localIntent2.putExtra("uin", localIntent1.getStringExtra("uin"));
    localIntent2.putExtra("passwd", localIntent1.getStringExtra("passwd"));
    localIntent2.putExtra("is_from_login", localIntent1.getBooleanExtra("is_from_login", false));
    localIntent2.putExtra("key_action", "action_sso_login_by_im_block");
    paramActivity.startActivity(localIntent2);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    Object localObject = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject).commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    if ((QQPlayerService.a()) && (paramActivity != null))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast((Intent)localObject);
    }
    bhhr.a(BaseApplicationImpl.sApplication, paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      QLog.e("LoginHelper", 1, "hideLoginDialog null == mApp");
    }
    do
    {
      return;
      MqqHandler localMqqHandler = paramAppInterface.getHandler(LoginActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(20140107);
      }
      localMqqHandler = paramAppInterface.getHandler(SubLoginActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(20140107);
      }
      localMqqHandler = paramAppInterface.getHandler(AddAccountActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(20140107);
      }
      paramAppInterface = paramAppInterface.getHandler(Login.class);
    } while (paramAppInterface == null);
    paramAppInterface.sendEmptyMessage(7);
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
      QLog.d("LoginHelper", 1, new Object[] { "toWtLoginOnOpenSdk appId=", paramString3, ", uin=", bjhh.a(paramString1) });
      paramString2 = new Bundle();
      paramString2.putString("uin", paramString1);
      paramString2.putInt("key_sso_ret", 1007);
      paramEIPCResultCallback.onCallback(EIPCResult.createResult(-102, paramString2));
      return;
    }
    QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk");
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("passwd", paramString2);
    localBundle.putString("appid", paramString3);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:openSdk", "ae_camera_get_info_client", "action_to_wt_login", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    QLog.d("LoginHelper", 1, new Object[] { "doWtLoginOnOpenSdk appId=", paramString1, ", uin=", bjhh.a(paramString2), ", observer=", paramSSOAccountObserver });
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
    if (arct.a()) {
      localBundle.putInt("puzzle_verify_code", 130);
    }
    localBundle.putByteArray("connect_data", bjhh.a(paramString1));
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
  
  public static void b(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      QLog.e("LoginHelper", 1, "showProgressDialog null == mApp");
    }
    do
    {
      return;
      MqqHandler localMqqHandler = paramAppInterface.getHandler(LoginActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(20200515);
      }
      localMqqHandler = paramAppInterface.getHandler(SubLoginActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(20200515);
      }
      localMqqHandler = paramAppInterface.getHandler(AddAccountActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(20200515);
      }
      paramAppInterface = paramAppInterface.getHandler(Login.class);
    } while (paramAppInterface == null);
    paramAppInterface.sendEmptyMessage(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkki
 * JD-Core Version:    0.7.0.1
 */