import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;

public class biik
  extends QIPCModule
{
  private static boolean a;
  
  public biik(String paramString)
  {
    super(paramString);
  }
  
  public static biik a()
  {
    return biin.a;
  }
  
  public static void a()
  {
    QLog.i("Q.quicklogin.OpenSdkQIPCClient", 1, "registerModule isRegisterModule=" + a);
    if (!a)
    {
      QIPCClientHelper.getInstance().getClient().registerModule(a());
      QIPCClientHelper.getInstance().getClient().connect(new biil());
      a = true;
    }
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
      QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "doWtLogin uin=" + bipr.a(str1) + ", maskPasswd=" + paramBundle + ", appId=" + str3);
      bjsy.a(str3, str1, str2, new biim(this, paramInt));
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
    if (bipr.a(paramString, (AppRuntime)localObject, true) != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bipr.a(paramString, (AppRuntime)localObject);
      QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "clearLoginData hasA2=" + bool1 + ", hasDA2=" + bool2);
      if ((!bool1) && (!bool2)) {
        break;
      }
      localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
      ((WtloginManager)localObject).ClearUserFastLoginData(paramString, 16L);
      ((WtloginManager)localObject).RefreshMemorySig();
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "backToMainProcess uin=" + bipr.a(paramString) + ", ssoResult=" + paramInt2 + ", epicCode=" + paramInt3);
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
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biik
 * JD-Core Version:    0.7.0.1
 */