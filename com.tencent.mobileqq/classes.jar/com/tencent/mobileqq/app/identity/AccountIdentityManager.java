package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.loginregister.LoginSuccDialogMessage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

public class AccountIdentityManager
  extends BaseAccountLifecycle
{
  private static volatile AccountIdentityManager b;
  protected AtomicBoolean a = new AtomicBoolean(false);
  private QQCustomDialog c;
  private AccountIdentityManager.AccountIdentityFinishReceiver d;
  
  public static AccountIdentityManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new AccountIdentityManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(Context paramContext)
  {
    this.c = null;
    AccountIdentityManager.AccountIdentityFinishReceiver localAccountIdentityFinishReceiver = this.d;
    if (localAccountIdentityFinishReceiver != null)
    {
      try
      {
        paramContext.unregisterReceiver(localAccountIdentityFinishReceiver);
      }
      catch (Exception paramContext)
      {
        QLog.d("AccountIdentityManager", 1, new Object[] { "DismissListener unregisterReceiver error : ", paramContext.getMessage() });
      }
      this.d = null;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, cmd0x9ae.RspBody paramRspBody, LoginVerifyObserver paramLoginVerifyObserver)
  {
    boolean bool1 = paramRspBody.bool_has_been_authenticated.get();
    boolean bool2 = paramRspBody.bool_need_auth_tips.get();
    Object localObject = (cmd0x9ae.AuthTips)paramRspBody.msg_auth_tips.get();
    String str1 = ((cmd0x9ae.AuthTips)localObject).string_lbutton.get();
    String str2 = ((cmd0x9ae.AuthTips)localObject).string_rbutton.get();
    String str5 = ((cmd0x9ae.AuthTips)localObject).string_tips_action.get();
    String str3 = ((cmd0x9ae.AuthTips)localObject).string_tips_action_url.get();
    String str4 = ((cmd0x9ae.AuthTips)localObject).string_tips_context.get();
    localObject = ((cmd0x9ae.AuthTips)localObject).string_tips_title.get();
    paramRspBody = paramRspBody.bytes_jwt.get().toStringUtf8();
    String str6 = paramAppRuntime.getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("AccountIdentityManager", 2, new Object[] { "success, isAuthenticated : ", Boolean.valueOf(bool1), " needAuth : ", Boolean.valueOf(bool2), " leftText : ", str1, " rightText : ", str2, " tipsAction : ", str5, " url : ", str3, " content : ", str4, " title : ", localObject, " jwt : ", paramRspBody });
    }
    if (TextUtils.isEmpty(paramRspBody))
    {
      QLog.e("AccountIdentityManager", 1, "error : jwt is empty");
      paramLoginVerifyObserver.onFailedResponse("OidbSvc.0x9ae_13", -1, null);
      return;
    }
    str5 = IdentityUtils.a(paramRspBody);
    if (str5 == null)
    {
      QLog.e("AccountIdentityManager", 1, "error : jwt parse error");
      paramLoginVerifyObserver.onFailedResponse("OidbSvc.0x9ae_13", -1, null);
      return;
    }
    BaseSharedPreUtil.a(BaseApplication.getContext(), str6, true, "account_identity_time", paramRspBody);
    if (bool1)
    {
      if (IdentityUtils.a(this.c)) {
        this.c.dismiss();
      }
      return;
    }
    if (IdentityUtils.a(this.c))
    {
      QLog.d("AccountIdentityManager", 1, "refreshAuthorityState showDialog, but dialog is showing");
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new AccountIdentityManager.2(this, str1, str2, str3, str4, (String)localObject, str5, paramAppRuntime), 700L);
  }
  
  private void c(Activity paramActivity)
  {
    if (IdentityUtils.a(this.c))
    {
      if (IdentityUtils.a(this.c, paramActivity))
      {
        this.c.dismiss();
        return;
      }
      b(MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
  }
  
  public void a(Activity paramActivity)
  {
    c(paramActivity);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, AppRuntime paramAppRuntime)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      boolean bool = IdentityUtils.b(paramString6);
      this.c = IdentityUtils.a(localQBaseActivity, paramString1, paramString2, paramString4, paramString5, bool ^ true, new AccountIdentityManager.3(this, bool, localQBaseActivity, paramAppRuntime), new AccountIdentityManager.4(this, paramString3, localQBaseActivity, bool, paramAppRuntime));
      this.c.setOnDismissListener(new AccountIdentityManager.5(this, localQBaseActivity));
      this.c.setOnCancelListener(new AccountIdentityManager.6(this, localQBaseActivity));
      this.c.show();
      if (bool) {
        paramString1 = "0X800B275";
      } else {
        paramString1 = "0X800B272";
      }
      ReportController.b(paramAppRuntime, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      return;
    }
    QLog.e("AccountIdentityManager", 1, "create dialog, but activity is finishing");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && (paramAppRuntime.isLogin()))
    {
      if (IdentityUtils.a(this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountIdentityManager", 2, "checkAccountIdentityState, dialog is showing");
        }
        return;
      }
      String str = paramAppRuntime.getAccount();
      if (IdentityUtils.a((String)BaseSharedPreUtil.a(BaseApplication.getContext(), str, "account_identity_time", ""), NetConnInfoCenter.getServerTime()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountIdentityManager", 2, "checkAccountIdentityState, is not time");
        }
        return;
      }
      b(paramAppRuntime);
      return;
    }
    QLog.d("AccountIdentityManager", 1, "checkAccountIdentityState, appInterface is null or is not login");
  }
  
  public void b()
  {
    if (MobileQQ.sProcessId == 1)
    {
      a(MobileQQ.sMobileQQ.waitAppRuntime(null));
      d();
    }
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    try
    {
      if (MobileQQ.sProcessId != 1)
      {
        QLog.e("AccountIdentityManager", 1, "refreshAuthorityState only run in main process");
        return;
      }
      if ((paramAppRuntime != null) && (paramAppRuntime.isLogin()))
      {
        if (this.a.get())
        {
          QLog.d("AccountIdentityManager", 1, "refreshAuthorityState, is requesting");
          return;
        }
        this.a.set(true);
        LoginVerifyServlet.a(paramAppRuntime, new AccountIdentityManager.1(this, paramAppRuntime));
        return;
      }
      QLog.d("AccountIdentityManager", 1, "refreshAuthorityState, appInterface is null or is not login");
      return;
    }
    finally {}
  }
  
  public void c()
  {
    if (MobileQQ.sProcessId == 1) {
      a(MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
  }
  
  protected void d()
  {
    QLog.d("AccountIdentityManager", 1, "checkPhoneQuickLoginNotice");
    LoginSuccDialogMessage localLoginSuccDialogMessage = LoginStaticField.b();
    if (localLoginSuccDialogMessage == null)
    {
      QLog.d("AccountIdentityManager", 1, "checkPhoneQuickLoginNotice， message is null");
      return;
    }
    if (QBaseActivity.sTopActivity == null)
    {
      QLog.d("AccountIdentityManager", 1, "checkPhoneQuickLoginNotice， sTopActivity is null");
      return;
    }
    ILoginRegisterApi localILoginRegisterApi = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_dialog_title", localLoginSuccDialogMessage.b());
    localHashMap.put("key_dialog_msg", localLoginSuccDialogMessage.a());
    localHashMap.put("key_dialog_ok_btn_text", HardCodeUtil.a(2131892366));
    localILoginRegisterApi.showBottomDialog(QBaseActivity.sTopActivity, localHashMap);
    LoginStaticField.c();
    ReportController.a(null, "dc00898", "", "", "0X800B8DA", "0X800B8DA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager
 * JD-Core Version:    0.7.0.1
 */