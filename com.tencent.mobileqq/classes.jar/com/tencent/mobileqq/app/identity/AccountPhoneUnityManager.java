package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.SmallTips;

public class AccountPhoneUnityManager
  extends BaseAccountLifecycle
{
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  
  private void b(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {}
    try
    {
      QLog.d("AccountPhoneUnityManager", 1, "unregisterReceiver, context is null, use application");
      localObject = BaseApplication.getContext();
      paramContext = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
      if (paramContext != null)
      {
        try
        {
          QLog.d("AccountPhoneUnityManager", 1, "unregisterReceiver");
          ((Context)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        }
        catch (Exception paramContext)
        {
          QLog.d("AccountPhoneUnityManager", 1, new Object[] { "unregisterReceiver error : ", paramContext.getMessage() });
        }
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      return;
    }
    finally {}
  }
  
  private boolean c()
  {
    return new PhoneUnityProxy().a(QBaseActivity.sTopActivity);
  }
  
  private void g()
  {
    if (MobileQQ.sProcessId != 1)
    {
      QLog.d("AccountPhoneUnityManager", 1, "refresh only run in main process");
      return;
    }
    AppRuntime localAppRuntime = a();
    if (localAppRuntime == null)
    {
      QLog.d("AccountPhoneUnityManager", 1, "refresh, app is null");
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new AccountPhoneUnityManager.1(this, localAppRuntime), 800L);
    if (a()) {
      f();
    }
  }
  
  AppRuntime a()
  {
    if (MobileQQ.sProcessId != 1)
    {
      QLog.d("AccountPhoneUnityManager", 1, "getAppInterface only run in main process");
      return null;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!localAppRuntime.isLogin())
    {
      QLog.e("AccountPhoneUnityManager", 1, "getAppInterface, but not login");
      return null;
    }
    return localAppRuntime;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPhoneUnityManager", 2, "onAccountLoginOrSwitch");
    }
    g();
  }
  
  public void a(Activity paramActivity)
  {
    if ((IdentityUtils.a(this.jdField_a_of_type_AndroidAppDialog)) && (!new PhoneUnityProxy().a(paramActivity)))
    {
      boolean bool = IdentityUtils.a(this.jdField_a_of_type_AndroidAppDialog, paramActivity);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("AccountPhoneUnityManager", 2, new Object[] { "dialog is showing, current activity is dialog context [", Boolean.valueOf(bool), "] activity : ", paramActivity.getClass().getSimpleName() });
      }
      if ((!bool) && (QBaseActivity.sTopActivity != null)) {
        f();
      }
    }
  }
  
  void a(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      QLog.d("AccountPhoneUnityManager", 1, "registerReceiver, context is null");
      return;
    }
    finally {}
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      QLog.d("AccountPhoneUnityManager", 1, "registerReceiver");
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AccountPhoneUnityManager.PhoneUnityReceiver(null);
      paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AppRuntime paramAppRuntime, Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        if (IdentityUtils.a(this.jdField_a_of_type_AndroidAppDialog))
        {
          QLog.d("AccountPhoneUnityManager", 1, "dialog is showing");
          return;
        }
        QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
        if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
        {
          boolean bool = IdentityUtils.a(paramString1);
          this.jdField_a_of_type_AndroidAppDialog = IdentityUtils.a(localQBaseActivity, paramString2, paramString3, paramString4, paramString5, false, new AccountPhoneUnityManager.4(this, bool, localQBaseActivity, paramAppRuntime), new AccountPhoneUnityManager.5(this, paramActivity, bool, paramAppRuntime));
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new AccountPhoneUnityManager.6(this));
          this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new AccountPhoneUnityManager.7(this));
          if (bool)
          {
            paramString1 = "0X800B3E6";
            a(localQBaseActivity);
            ReportController.b(paramAppRuntime, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
          }
        }
        else
        {
          QLog.e("AccountPhoneUnityManager", 1, "create dialog, but activity is finishing or null");
          return;
        }
      }
      finally {}
      paramString1 = "0X800B3E3";
    }
  }
  
  void a(AppRuntime paramAppRuntime)
  {
    try
    {
      if (!b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountPhoneUnityManager", 1, "not need show banner");
        }
        return;
      }
      QLog.d("AccountPhoneUnityManager", 1, "show banner");
      BannerManager.a().a(BannerTypeCollections.b, 2, null);
      a(QBaseActivity.sTopActivity);
      return;
    }
    finally {}
  }
  
  void a(AppRuntime paramAppRuntime, Context paramContext)
  {
    try
    {
      QLog.d("AccountPhoneUnityManager", 1, "hideBanner");
      BannerManager.a().a(BannerTypeCollections.b, 0, null);
      paramAppRuntime = paramAppRuntime.getAccount();
      BaseSharedPreUtil.a(paramContext, paramAppRuntime, true, "phone_unity_banner_tips", "");
      BaseSharedPreUtil.a(paramContext, paramAppRuntime, true, "phone_unity_banner_tips_need_show", Boolean.valueOf(false));
      return;
    }
    finally
    {
      paramAppRuntime = finally;
      throw paramAppRuntime;
    }
  }
  
  void a(AppRuntime paramAppRuntime, cmd0x9ae.RspBody paramRspBody)
  {
    boolean bool1 = paramRspBody.bool_need_auth_tips.get();
    Object localObject1 = (cmd0x9ae.AuthTips)paramRspBody.msg_auth_tips.get();
    String str1 = ((cmd0x9ae.AuthTips)localObject1).string_lbutton.get();
    String str2 = ((cmd0x9ae.AuthTips)localObject1).string_rbutton.get();
    String str5 = ((cmd0x9ae.AuthTips)localObject1).string_tips_action.get();
    Object localObject2 = ((cmd0x9ae.AuthTips)localObject1).string_tips_action_url.get();
    String str3 = ((cmd0x9ae.AuthTips)localObject1).string_tips_context.get();
    localObject1 = ((cmd0x9ae.AuthTips)localObject1).string_tips_title.get();
    String str4 = paramRspBody.bytes_jwt.get().toStringUtf8();
    paramRspBody = paramRspBody.msg_small_tips.string_tips_context.get();
    boolean bool2 = QLog.isColorLevel();
    int i = 0;
    if (bool2) {
      QLog.d("AccountPhoneUnityManager", 2, new Object[] { "success, needAuth : ", Boolean.valueOf(bool1), " leftText : ", str1, " rightText : ", str2, " tipsAction : ", str5, " url : ", localObject2, " content : ", str3, " title : ", localObject1, " jwt : ", str4, "tips : ", paramRspBody });
    }
    if (TextUtils.isEmpty(str4))
    {
      QLog.e("AccountPhoneUnityManager", 1, "error : jwt is empty");
      return;
    }
    str5 = IdentityUtils.a(str4);
    if (TextUtils.isEmpty(str5))
    {
      QLog.e("AccountPhoneUnityManager", 1, "error : jwt parse error");
      return;
    }
    localObject2 = QBaseActivity.sTopActivity;
    if (localObject2 == null)
    {
      QLog.e("AccountPhoneUnityManager", 1, "onPhoneUnityDataResp, but activity is null");
      return;
    }
    String str6 = paramAppRuntime.getAccount();
    BaseSharedPreUtil.a((Context)localObject2, str6, true, "phone_unity_jwt", str4);
    bool2 = IdentityUtils.a(this.jdField_a_of_type_AndroidAppDialog);
    if (!bool1)
    {
      QLog.d("AccountPhoneUnityManager", 1, new Object[] { "need auth false, isShowing : ", Boolean.valueOf(bool2) });
      if (bool2) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      a(paramAppRuntime, (Context)localObject2);
      return;
    }
    if (bool2)
    {
      if ((IdentityUtils.a(this.jdField_a_of_type_AndroidAppDialog, (Activity)localObject2)) || (c())) {
        i = 1;
      }
      if (i != 0)
      {
        QLog.d("AccountPhoneUnityManager", 1, "dialog is invalid");
        return;
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    BaseSharedPreUtil.a((Context)localObject2, str6, true, "phone_unity_banner_tips", paramRspBody);
    BaseSharedPreUtil.a((Context)localObject2, str6, true, "phone_unity_banner_tips_need_show", Boolean.valueOf(true));
    ThreadManager.getUIHandler().postDelayed(new AccountPhoneUnityManager.3(this, str5, str1, str2, str3, (String)localObject1, paramAppRuntime, (Activity)localObject2), 700L);
  }
  
  boolean a()
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    if (IdentityUtils.a(this.jdField_a_of_type_AndroidAppDialog))
    {
      if (c())
      {
        QLog.d("AccountPhoneUnityManager", 1, new Object[] { "current top activity : ", QBaseActivity.sTopActivity.getActivityName(), " is in white list" });
        return false;
      }
      bool = IdentityUtils.a(this.jdField_a_of_type_AndroidAppDialog, QBaseActivity.sTopActivity);
      QLog.d("AccountPhoneUnityManager", 1, new Object[] { "dialog is showing, dialog is top activity[", Boolean.valueOf(bool), "]" });
      if (!bool) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return bool ^ true;
    }
    localObject = ((AppRuntime)localObject).getAccount();
    boolean bool = IdentityUtils.a((String)BaseSharedPreUtil.a(BaseApplication.getContext(), (String)localObject, "phone_unity_jwt", ""), NetConnInfoCenter.getServerTime());
    if (bool) {
      QLog.d("AccountPhoneUnityManager", 1, "dont need refresh, not time");
    }
    return bool ^ true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPhoneUnityManager", 2, "onForegroundSwitch");
    }
    g();
  }
  
  boolean b()
  {
    try
    {
      Object localObject1 = a();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((AppRuntime)localObject1).getAccount();
      boolean bool = ((Boolean)BaseSharedPreUtil.a(BaseApplication.getContext(), (String)localObject1, "phone_unity_banner_tips_need_show", Boolean.valueOf(false))).booleanValue();
      return bool;
    }
    finally {}
  }
  
  public void e()
  {
    b(QBaseActivity.sTopActivity);
  }
  
  void f()
  {
    if (MobileQQ.sProcessId != 1)
    {
      QLog.d("AccountPhoneUnityManager", 1, "refreshPhoneUnityData only run in main process");
      return;
    }
    AppRuntime localAppRuntime = a();
    if (localAppRuntime == null) {
      return;
    }
    LoginVerifyServlet.c(localAppRuntime, new AccountPhoneUnityManager.2(this, localAppRuntime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager
 * JD-Core Version:    0.7.0.1
 */