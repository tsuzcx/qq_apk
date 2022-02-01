package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.register.RegisterLimitHelperImpl;
import com.tencent.mobileqq.register.RegisterManager;
import com.tencent.mobileqq.register.RegisterWithNick;
import com.tencent.mobileqq.register.RegisterWithNickAndPwd;
import com.tencent.mobileqq.register.RegisterWithNickAndPwdInfo;
import com.tencent.mobileqq.register.RegisterWithNickAndPwdInfoBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.mobileqq.widget.VerifyCodeView.OnVerifyCodeChangedListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, SMSBodyObserver, VerifyCodeView.OnVerifyCodeChangedListener
{
  private TextView a;
  private VerifyCodeView b;
  private SmsContent c;
  private String d = null;
  private int e = 60;
  private int f = 60;
  private String g = null;
  private RegisterWithNick h = null;
  private RegisterWithNickAndPwd i = null;
  private boolean j;
  private boolean k;
  private Runnable l = new RegisterVerifyCodeActivity.1(this);
  private MqqHandler m = new RegisterVerifyCodeActivity.2(this);
  private AccountObserver n = new RegisterVerifyCodeActivity.3(this);
  
  private void a(int paramInt)
  {
    this.a.setEnabled(false);
    this.a.setClickable(false);
    this.e = paramInt;
    TextView localTextView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131914089));
    localStringBuilder.append(" (");
    localStringBuilder.append(this.e);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.a.setTextColor(-7894119);
    this.handler.postDelayed(this.l, 1000L);
  }
  
  private void c()
  {
    if (this.e > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackEvent second=");
        localStringBuilder.append(this.e);
        localStringBuilder.append(", curTime=");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("RegisterVerifyCodeActivity", 2, localStringBuilder.toString());
      }
      getIntent().putExtra("key_register_left_time", this.e);
      getIntent().putExtra("key_register_exit_time", System.currentTimeMillis());
      setResult(-1, getIntent());
    }
    finish();
  }
  
  private void d()
  {
    setTitleText(2131914120);
    setTitleHint();
    setBackListener();
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false)) {
      setBarProgress(100);
    } else {
      setBarProgress(66);
    }
    this.a = ((TextView)findViewById(2131429992));
    this.a.setOnClickListener(this);
    TextView localTextView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131914089));
    localStringBuilder.append(" (");
    localStringBuilder.append(this.e);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.handler.postDelayed(this.l, 1000L);
    this.b = ((VerifyCodeView)findViewById(2131449357));
    this.b.a(this);
  }
  
  private void e()
  {
    try
    {
      this.g = null;
      ((AccountManager)this.mRuntime.getManager(0)).sendRegistByResendSms(this.n);
      createWaitingDialog(2131914100);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      notifyToast(2131889169, 0);
      return;
    }
    String str2 = this.b.getCode();
    String str1 = str2;
    if (str2 != null) {
      str1 = str2.trim();
    }
    if ((str1 != null) && (str1.length() > 0)) {
      try
      {
        ((AccountManager)this.mRuntime.getManager(0)).sendRegisterByCommitSmsVerifycode(str1, this.n);
        createWaitingDialog(2131914022);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    notifyToast(2131914033, 0);
  }
  
  public void b()
  {
    PhoneNumLoginImpl.a().a(this.mRuntime, true);
    boolean bool1 = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    boolean bool2 = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    boolean bool3 = TextUtils.isEmpty(this.d);
    String str = this.b.getCode();
    Object localObject = str;
    if (str != null) {
      localObject = str.trim();
    }
    if (bool1)
    {
      if (this.i == null) {
        this.i = new RegisterWithNickAndPwd(this);
      }
      getIntent().putExtra("key_register_smscode", (String)localObject);
      getIntent().putExtra("key_register_autologin", true);
      getIntent().putExtra("key_register_phonenum_bindnewqq", bool2);
      this.i.a(getIntent());
      return;
    }
    if ((bool3 ^ true))
    {
      localObject = new RegisterWithNickAndPwdInfoBuilder().a(this.phoneNum).b(this.countryCode).c((String)localObject).a(false).b(this.mHasPwd).d(this.inviteCode).a(5).e("").f("").c(true).d(false).e(this.j).a();
      RegisterLimitHelperImpl.a().a(this, this.d, (RegisterWithNickAndPwdInfo)localObject);
      return;
    }
    RegisterByNicknameAndPwdActivity.gotoRegisterByNicknameAndPwdActivity(this, this.phoneNum, this.countryCode, (String)localObject, this.mIsPhoneNumRegistered, this.mHasPwd, this.inviteCode, 5, "", "", true, this.j);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131629626);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    int i1 = getIntent().getIntExtra("key_register_left_time", 0);
    long l1 = getIntent().getLongExtra("key_register_exit_time", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate countryCode=");
      localStringBuilder.append(this.countryCode);
      localStringBuilder.append(", phoneNum=");
      localStringBuilder.append(PhoneCodeUtils.a(this.phoneNum));
      localStringBuilder.append(", leftTime=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", exitTime=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", inviteCode=");
      if (this.inviteCode == null) {
        paramBundle = "";
      } else {
        paramBundle = this.inviteCode;
      }
      localStringBuilder.append(paramBundle);
      QLog.d("RegisterVerifyCodeActivity", 2, localStringBuilder.toString());
    }
    if ((i1 > 0) && (i1 < 60) && (l1 > 0L))
    {
      l1 = System.currentTimeMillis() - l1;
      if ((l1 > 0L) && (l1 < i1 * 1000L)) {
        this.e = (i1 - (int)(l1 / 1000L));
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate interval=");
        paramBundle.append(l1);
        paramBundle.append(", second=");
        paramBundle.append(this.e);
        QLog.d("RegisterVerifyCodeActivity", 2, paramBundle.toString());
      }
    }
    this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.mHasPwd = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.j = getIntent().getBooleanExtra("key_register_from_friend_verify", false);
    this.k = getIntent().getBooleanExtra("key_register_from_face_verify", false);
    LoginUtils.a(this.mRuntime, getClass(), this.m);
    d();
    this.c = new SmsContent(null, getIntent().getLongExtra("register_verify_code_start_time", 0L));
    this.c.a(this, this);
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006656", "0X8006656", 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 0, 0, "", "", "", "");
    if (!this.mIsPhoneNumRegistered) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 1, 0, "", "", "", "");
    } else if (!this.mHasPwd) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 2, 0, "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 3, 0, "", "", "", "");
    }
    if (this.mFrom == 7) {
      ReportController.a(this.mRuntime, "new_reg_805", "msg_page", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "new_reg_805", "msg_page", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
    if (this.k) {
      i1 = 3;
    } else if (this.j) {
      i1 = 2;
    } else if (this.mFrom == 7) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8009CEC", "0X8009CEC", i1, 0, "", "", this.phoneNum, "");
    getWindow().setSoftInputMode(5);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RegisterManager.b().a(3);
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.i;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.b();
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new RegisterVerifyCodeActivity.4(this, paramString1, paramString2));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.i;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.d();
    }
  }
  
  protected boolean onBackEvent()
  {
    c();
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      notifyToast(2131889169, 0);
    }
    else if (paramView.getId() == 2131429992)
    {
      e();
      ReportController.a(this.mRuntime, "new_reg_805", "msg_page", "resend_clk", "", 1, "", "", "", "", "", "", "", "", "");
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8009CED", "0X8009CED", 0, 0, "", "", this.phoneNum, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    closeDialog();
    Object localObject = this.c;
    if (localObject != null) {
      ((SmsContent)localObject).a();
    }
    this.c = null;
    this.handler.removeCallbacks(this.l);
    localObject = this.h;
    if (localObject != null) {
      ((RegisterWithNick)localObject).a();
    }
    this.h = null;
    localObject = this.i;
    if (localObject != null) {
      ((RegisterWithNickAndPwd)localObject).a();
    }
    this.i = null;
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((this.dialog != null) && (this.dialog.isShowing())) {
        this.dialog.dismiss();
      }
      this.dialog = null;
      if (this.i != null)
      {
        this.i.c();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onVerifyCodeChanged(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */