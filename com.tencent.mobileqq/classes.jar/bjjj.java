import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.manager.VerifyCodeManager;
import mqq.manager.WtloginManager;
import mqq.os.MqqHandler;

public class bjjj
  extends QIPCModule
{
  private static boolean a;
  
  public bjjj(String paramString)
  {
    super(paramString);
  }
  
  public static bjjj a()
  {
    return bjjm.a;
  }
  
  public static void a()
  {
    QLog.i("Q.quicklogin.OpenSdkQIPCClient", 1, "registerModule isRegisterModule=" + a);
    if (!a)
    {
      QIPCClientHelper.getInstance().getClient().registerModule(a());
      QIPCClientHelper.getInstance().getClient().connect(new bjjk());
      a = true;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "submitPuzzleVerifyCode");
    if (paramBundle == null)
    {
      QLog.e("Q.quicklogin.OpenSdkQIPCClient", 1, "submitPuzzleVerifyCode params==null");
      return;
    }
    int i = paramBundle.getInt("seq");
    paramBundle = paramBundle.getString("ticket");
    Object localObject = (AppInterface)BaseApplicationImpl.sApplication.peekAppRuntime();
    VerifyCodeManager localVerifyCodeManager = (VerifyCodeManager)((AppInterface)localObject).getManager(6);
    if (localVerifyCodeManager == null)
    {
      QLog.e("Q.quicklogin.OpenSdkQIPCClient", 1, "submitPuzzleVerifyCode verifyCodeManager==null");
      return;
    }
    localObject = ((AppInterface)localObject).getHandler(Login.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(8);
    }
    localVerifyCodeManager.submitPuzzleVerifyCodeTicket(i, paramBundle);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      QLog.e("Q.quicklogin.OpenSdkQIPCClient", 1, "doWtLogin params==null");
      a("", paramInt, 1005, -102);
      return;
    }
    String str1 = paramBundle.getString("key_uin");
    String str2 = paramBundle.getString("key_passwd");
    String str3 = paramBundle.getString("key_appid");
    if (TextUtils.isEmpty(str2)) {}
    for (paramBundle = "empty";; paramBundle = "****")
    {
      QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "doWtLogin uin=" + bjqq.a(str1) + ", maskPasswd=" + paramBundle + ", appId=" + str3);
      bktz.a(str3, str1, str2, new bjjl(this, paramInt));
      return;
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.sApplication.peekAppRuntime();
    if (!(localObject instanceof OpenSDKAppInterface))
    {
      QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "clearLoginData !(app instanceof OpenSDKAppInterface)");
      return;
    }
    ((OpenSDKAppInterface)localObject).a().a(paramString);
    if (bjqq.a(paramString, (AppRuntime)localObject, true) != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bjqq.a(paramString, (AppRuntime)localObject);
      QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "clearLoginData hasA2=" + bool1 + ", hasDA2=" + bool2);
      if ((!bool1) && (!bool2)) {
        break;
      }
      localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
      ((WtloginManager)localObject).clearUserFastLoginData(paramString, 16L);
      ((WtloginManager)localObject).refreshMemorySig();
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "backToMainProcess uin=" + bjqq.a(paramString) + ", ssoResult=" + paramInt2 + ", epicCode=" + paramInt3);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_uin", paramString);
      localBundle.putInt("key_sso_ret", paramInt2);
      callbackResult(paramInt1, EIPCResult.createResult(paramInt3, localBundle));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Q.quicklogin.OpenSdkQIPCClient", 1, "Exception", paramString);
    }
  }
  
  public static void b()
  {
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "unRegisterModule isRegisterModule=" + a);
    if (a)
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
      a = false;
    }
  }
  
  public static void c()
  {
    QLog.i("Q.quicklogin.OpenSdkQIPCClient", 1, "doPtloginCancel");
    QIPCClientHelper.getInstance().callServer("open_sdk_qipc_module", "action_ptlogin_cancel", new Bundle());
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "onCall action=" + paramString);
    if ("action_to_wt_login".equals(paramString)) {
      a(paramBundle, paramInt);
    }
    for (;;)
    {
      return null;
      if ("action_submit_puzzle_verify_code".equals(paramString)) {
        a(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjj
 * JD-Core Version:    0.7.0.1
 */