package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI.OnInteractionListener;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;

public class SubLoginActivity
  extends SubAccountBaseActivity
  implements AddAccountBaseUI.OnInteractionListener
{
  boolean a = false;
  protected AddAccountBaseUI b = new AddAccountBaseUI(this, this);
  MqqHandler c = new SubLoginActivity.1(this);
  public BroadcastReceiver d = new SubLoginActivity.2(this);
  public SubAccountBindObserver e = new SubLoginActivity.3(this);
  private boolean f;
  private String g;
  private boolean h;
  private boolean i = false;
  private boolean j;
  private LoginFailedHelper k = new LoginFailedHelper();
  private SubAccountObserver l = new SubLoginActivity.4(this);
  
  private void a()
  {
    this.b.q();
    if (!TextUtils.isEmpty(this.g))
    {
      this.b.a(this.g);
      this.b.k().setEnabled(false);
      if (this.f)
      {
        this.b.a(2131916856);
        return;
      }
      this.b.a(2131916876);
      this.b.p().setText(2131917813);
      return;
    }
    this.b.a(2131916856);
  }
  
  private int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "accountType isEmpty ");
      return 0;
    }
    int m;
    if (LoginFailedHelper.a(paramString))
    {
      if (paramString.length() == 11) {
        m = 1;
      } else {
        m = 2;
      }
    }
    else if (paramString.contains("@")) {
      m = 3;
    } else {
      m = 0;
    }
    QLog.d("Q.subaccount.SubLoginActivity", 2, new Object[] { "accountType = ", Integer.valueOf(m) });
    return m;
  }
  
  private void b()
  {
    int m = b(this.b.m());
    if ((m == 1) || (m == 2) || (m == 3)) {
      ReportController.b(this.app, "dc00898", "", "", "0X800BDEA", "0X800BDEA", 0, 0, String.valueOf(m), "", "", "");
    }
  }
  
  public String a(String paramString)
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Constants.PropertiesKey.uinDisplayName.toString());
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((MobileQQ)localObject1).getProperty(((StringBuilder)localObject2).toString());
    localObject1 = paramString;
    if (localObject2 != null)
    {
      if (((String)localObject2).length() == 0) {
        return paramString;
      }
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int m = 2;
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CNR setAutoLoginSharePre auto =");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SharedPreUtils", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_auto");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
      paramContext = paramContext.getSharedPreferences("sp_login_auto", 4).edit();
      if (!paramBoolean) {
        m = 1;
      }
      paramContext.putInt(paramString, m).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doLogin()
  {
    String str1 = this.b.m();
    boolean bool = false;
    if ((str1 != null) && (str1.length() != 0) && (str1.trim().length() != 0))
    {
      String str2 = this.b.n();
      if (TextUtils.isEmpty(str2))
      {
        showQQToast(getString(2131892394));
        this.b.s();
        return;
      }
      if ((!str1.equals(a(this.app.getAccount()))) && (!str1.equals(this.app.getAccount())))
      {
        if (this.f)
        {
          ISubAccountService localISubAccountService = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, null);
          if (localISubAccountService != null) {
            bool = localISubAccountService.isSubAccountUin(str1);
          }
          if (bool)
          {
            showQQToast(getString(2131916872));
            return;
          }
          if ((localISubAccountService != null) && (localISubAccountService.getBindedNumber() >= 2))
          {
            SubAccountControllUtil.a(this.app, this);
            return;
          }
        }
        if (!isNetConnToast()) {
          return;
        }
        if (this.h) {
          showJuhua(2131916904);
        } else {
          showJuhua(2131916859);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: no login so go to loginSubAccount");
        }
        LoginStaticField.a(2);
        getAppRuntime().loginSubAccount(this.app.getAccount(), str1, str2, null);
        return;
      }
      showQQToast(getString(2131916871));
      return;
    }
    QQToast.makeText(this, 2131892234, 0).show(getTitleBarHeight());
    this.b.r();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.g = getIntent().getStringExtra("subuin");
    if (!TextUtils.isEmpty(this.g))
    {
      this.h = true;
      this.b.a(false, 0);
    }
    super.doOnCreate(paramBundle);
    this.app.registObserver(this.l);
    this.f = getIntent().getBooleanExtra("is_need_bind", true);
    if (this.d != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.d, paramBundle);
    }
    a();
    this.app.setHandler(LoginProgressClazz.class, this.c);
    addObserver(this.e);
    return true;
  }
  
  protected void doOnDestroy()
  {
    hideJuhua();
    dimissDialog();
    super.doOnDestroy();
    this.app.removeHandler(LoginProgressClazz.class);
    removeObserver(this.e);
    this.app.unRegistObserver(this.l);
    BroadcastReceiver localBroadcastReceiver = this.d;
    if (localBroadcastReceiver != null) {
      unregisterReceiver(localBroadcastReceiver);
    }
    try
    {
      dismissDialog(0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.subaccount.SubLoginActivity", 1, new Object[] { "dismiss progress dialog error : ", localException.getMessage() });
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onPause:....loginActivity..................");
    }
    super.doOnPause();
    this.b.t();
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.b.k().clearFocus();
    if (this.h)
    {
      this.b.l().requestFocus();
      this.b.l().performClick();
    }
    else
    {
      this.b.l().clearFocus();
    }
    if (this.i)
    {
      QLog.d("Q.subaccount.SubLoginActivity", 1, "mShouldAutoLogin: true, then login");
      this.i = false;
      doLogin();
    }
    if (this.j) {
      try
      {
        showDialog(0);
        this.j = false;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("Q.subaccount.SubLoginActivity", 1, new Object[] { "show progress dialog error : ", localException.getMessage() });
      }
    }
  }
  
  public void doPhoneLogin()
  {
    ReportController.a(this.app, "dc00898", "", "", "0X800AFDF", "0X800AFDF", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("isSubaccount", true);
    localIntent.putExtra("fromWhere", this.fromWhere);
    localIntent.putExtra("entrance", "fromSubLogin");
    RouteUtils.a(this, localIntent, "/base/safe/loginPhoneNumActivity");
  }
  
  public void onBackClick() {}
  
  protected boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFindPwdClick()
  {
    ReportController.a(this.app, "dc00898", "", "", "0X800B290", "0X800B290", 0, 0, "", "", "", "");
  }
  
  public void onPwdClear() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity
 * JD-Core Version:    0.7.0.1
 */