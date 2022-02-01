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
import com.tencent.mobileqq.widget.VerifyCodeView.OnVerifyCodeCompleteListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;

public class LoginVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, SMSBodyObserver, ILoginSmsPageView, VerifyCodeView.OnVerifyCodeCompleteListener
{
  private int jdField_a_of_type_Int = 60;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private SubAccountProxy jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountProxy;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private VerifyCodeView jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LoginVerifyCodeActivity.1(this);
  private String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new LoginVerifyCodeActivity.2(this);
  private boolean jdField_a_of_type_Boolean = false;
  private Runnable jdField_b_of_type_JavaLangRunnable = new LoginVerifyCodeActivity.5(this);
  private String jdField_b_of_type_JavaLangString = null;
  private String c;
  private String d;
  private String e;
  
  private int a()
  {
    String str = this.e;
    if (str == null) {
      return 0;
    }
    if ("fromLogin".equals(str)) {
      return 4;
    }
    if (LoginView.class.getName().equals(this.e)) {
      return 1;
    }
    if ("fromAddAccount".equals(this.e)) {
      return 3;
    }
    if ("fromSubLogin".equals(this.e)) {
      return 2;
    }
    return 0;
  }
  
  private String a()
  {
    if (this.mRuntime == null) {
      return "";
    }
    if (this.mRuntime.isLogin()) {
      return "";
    }
    return this.phoneNum;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_Int = paramInt;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131716626));
    localStringBuilder.append(" (");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-7894119);
    this.handler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
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
  
  private void b()
  {
    setTitleText(2131716657);
    setBackListener();
    setTitleHint();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364036));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131716626));
    localStringBuilder.append(" (");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.handler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView = ((VerifyCodeView)findViewById(2131380407));
    this.jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView.a(this);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "startLogin start...");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      PhoneNumLoginImpl.a().b(this.mRuntime, this.mRuntime.getCurrentAccountUin(), this.countryCode, this.phoneNum, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
    }
    PhoneNumLoginImpl.a().b(this.mRuntime, this.countryCode, this.phoneNum, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void d()
  {
    createWaitingDialog(2131716637);
    if (PhoneNumLoginImpl.a().a(this.mRuntime, this.countryCode, this.phoneNum, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      closeDialog();
      notifyToast(2131718220, 1);
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      notifyToast(2131692183, 0);
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView.a();
    String str1 = str2;
    if (str2 != null) {
      str1 = str2.trim();
    }
    if (!TextUtils.isEmpty(str1))
    {
      createWaitingDialog(2131716559);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
      if (PhoneNumLoginImpl.a().a(this.mRuntime, this.countryCode, this.phoneNum, str1, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        closeDialog();
        notifyToast(2131718220, 1);
      }
    }
    else
    {
      notifyToast(2131716570, 0);
    }
  }
  
  public void a()
  {
    closeDialog();
  }
  
  public void a(String paramString, int paramInt)
  {
    notifyToast(paramString, paramInt);
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
    setContentView(2131563018);
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountProxy = new SubAccountProxy();
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountProxy.a(this);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("fromWhere");
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isSubaccount", false);
      this.e = paramBundle.getStringExtra("entrance");
    }
    if ((this.jdField_a_of_type_Boolean) && ((this.mRuntime instanceof AppInterface))) {
      ((AppInterface)this.mRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountProxy.a(this, this));
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.countryCode = getIntent().getStringExtra("key");
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
    ReportController.a(this.mRuntime, "dc00898", "", a(), "0X800B109", "0X800B109", a(), 0, "", "", "", "");
    getWindow().setSoftInputMode(5);
    return true;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    QLog.d("LoginVerifyCodeActivity", 1, new Object[] { "getSmsContent, smsAddress : ", paramString1, " smsBody : ", paramString2 });
    if (this.d != null) {
      this.handler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.c = paramString1;
    this.d = paramString2;
    this.handler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1500L);
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
      notifyToast(2131692183, 0);
    }
    else if (paramView.getId() == 2131364036)
    {
      d();
      ReportController.a(this.mRuntime, "dc00898", "", a(), "0X800B10A", "0X800B10A", a(), 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Boolean) && ((this.mRuntime instanceof AppInterface))) {
      ((AppInterface)this.mRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountProxy.a(this, this));
    }
    SmsContent localSmsContent = this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
    if (localSmsContent != null) {
      localSmsContent.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
  }
  
  public void onVerifyCodeComplete()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */