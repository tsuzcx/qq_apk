package com.tencent.mobileqq.activity;

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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.loginregister.ILoginSmsPageView;
import com.tencent.mobileqq.loginregister.SubAccountProxy;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.mobileqq.widget.VerifyCodeView.OnVerifyCodeChangedListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;

public class LoginVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, SMSBodyObserver, ILoginSmsPageView, VerifyCodeView.OnVerifyCodeChangedListener
{
  WtloginObserver a = new LoginVerifyCodeActivity.2(this);
  private VerifyCodeView b;
  private boolean c = false;
  private QQProgressDialog d;
  private TextView e;
  private SmsContent f;
  private int g = 60;
  private String h;
  private String i = null;
  private String j;
  private String k;
  private String l;
  private SubAccountProxy m;
  private Runnable n = new LoginVerifyCodeActivity.1(this);
  private Runnable o = new LoginVerifyCodeActivity.5(this);
  
  private void a(int paramInt)
  {
    this.e.setEnabled(false);
    this.e.setClickable(false);
    this.g = paramInt;
    TextView localTextView = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131914089));
    localStringBuilder.append(" (");
    localStringBuilder.append(this.g);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.e.setTextColor(-7894119);
    this.handler.postDelayed(this.n, 1000L);
  }
  
  private boolean a(WUserSigInfo paramWUserSigInfo)
  {
    boolean bool = true;
    if (paramWUserSigInfo == null) {
      return true;
    }
    try
    {
      paramWUserSigInfo = PhoneNumQuickLoginManager.a(paramWUserSigInfo, 2);
      if (paramWUserSigInfo != null)
      {
        if (paramWUserSigInfo.size() == 0) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    catch (InvalidProtocolBufferMicroException paramWUserSigInfo)
    {
      QLog.e("LoginVerifyCodeActivity", 1, "canSmsLoginDirectly: 0x543 tlv illegal, merge error : InvalidProtocolBufferMicroException ", paramWUserSigInfo);
    }
    return false;
  }
  
  private int c()
  {
    String str = this.l;
    if (str == null) {
      return 0;
    }
    if ("fromLogin".equals(str)) {
      return 4;
    }
    if (LoginView.class.getName().equals(this.l)) {
      return 1;
    }
    if ("fromAddAccount".equals(this.l)) {
      return 3;
    }
    if ("fromSubLogin".equals(this.l)) {
      return 2;
    }
    return 0;
  }
  
  private String d()
  {
    if (this.mRuntime == null) {
      return "";
    }
    if (this.mRuntime.isLogin()) {
      return "";
    }
    return this.phoneNum;
  }
  
  private void e()
  {
    setTitleText(2131914120);
    setBackListener();
    setTitleHint();
    this.e = ((TextView)findViewById(2131429992));
    this.e.setOnClickListener(this);
    TextView localTextView = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131914089));
    localStringBuilder.append(" (");
    localStringBuilder.append(this.g);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.handler.postDelayed(this.n, 1000L);
    this.b = ((VerifyCodeView)findViewById(2131449357));
    this.b.a(this);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "startLogin start...");
    }
    if (this.c)
    {
      PhoneNumLoginImpl.a().b(this.mRuntime, this.mRuntime.getCurrentAccountUin(), this.countryCode, this.phoneNum, this.a);
      return;
    }
    PhoneNumLoginImpl.a().b(this.mRuntime, this.countryCode, this.phoneNum, this.a);
  }
  
  private void g()
  {
    createWaitingDialog(2131914100);
    if (PhoneNumLoginImpl.a().a(this.mRuntime, this.countryCode, this.phoneNum, this.a) != 0)
    {
      closeDialog();
      notifyToast(2131915702, 1);
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
    if (!TextUtils.isEmpty(str1))
    {
      createWaitingDialog(2131914022);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
      if (PhoneNumLoginImpl.a().a(this.mRuntime, this.countryCode, this.phoneNum, str1, this.a) != 0)
      {
        closeDialog();
        notifyToast(2131915702, 1);
      }
    }
    else
    {
      notifyToast(2131914033, 0);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    notifyToast(paramString, paramInt);
  }
  
  public void b()
  {
    closeDialog();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool = true;
    if (paramInt1 == 1)
    {
      if (QLog.isDevelopLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("doOnActivityResult, REQ_CODE_NOTIFICATION_LH  ");
        if (paramInt2 != -1) {
          bool = false;
        }
        paramIntent.append(bool);
        QLog.i("LoginVerifyCodeActivity", 4, paramIntent.toString());
      }
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131629626);
    this.m = new SubAccountProxy();
    this.m.a(this);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.h = paramBundle.getStringExtra("fromWhere");
      this.c = paramBundle.getBooleanExtra("isSubaccount", false);
      this.l = paramBundle.getStringExtra("entrance");
    }
    if ((this.c) && ((this.mRuntime instanceof AppInterface))) {
      ((AppInterface)this.mRuntime).addObserver(this.m.a(this, this));
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.countryCode = getIntent().getStringExtra("key");
    e();
    this.f = new SmsContent(null, paramBundle.getLongExtra("verify_code_start_time", 0L));
    this.f.a(this, this);
    ReportController.a(this.mRuntime, "dc00898", "", d(), "0X800B109", "0X800B109", c(), 0, "", "", "", "");
    getWindow().setSoftInputMode(5);
    return true;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    QLog.d("LoginVerifyCodeActivity", 1, new Object[] { "getSmsContent, smsAddress : ", paramString1, " smsBody : ", paramString2 });
    if (this.k != null) {
      this.handler.removeCallbacks(this.o);
    }
    this.j = paramString1;
    this.k = paramString2;
    this.handler.postDelayed(this.o, 1500L);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (getIntent().getBooleanExtra("login_from_account_change", false))
    {
      setResult(-1);
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      notifyToast(2131889169, 0);
    }
    else if (paramView.getId() == 2131429992)
    {
      g();
      ReportController.a(this.mRuntime, "dc00898", "", d(), "0X800B10A", "0X800B10A", c(), 0, "", "", "", "");
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
    if ((this.c) && ((this.mRuntime instanceof AppInterface))) {
      ((AppInterface)this.mRuntime).removeObserver(this.m.a(this, this));
    }
    SmsContent localSmsContent = this.f;
    if (localSmsContent != null) {
      localSmsContent.a();
    }
    this.f = null;
  }
  
  public void onVerifyCodeChanged(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */