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
import com.tencent.mobileqq.widget.VerifyCodeView.OnVerifyCodeCompleteListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, SMSBodyObserver, VerifyCodeView.OnVerifyCodeCompleteListener
{
  private int jdField_a_of_type_Int = 60;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private RegisterWithNick jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
  private RegisterWithNickAndPwd jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = null;
  private VerifyCodeView jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RegisterVerifyCodeActivity.1(this);
  private String jdField_a_of_type_JavaLangString = null;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new RegisterVerifyCodeActivity.3(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new RegisterVerifyCodeActivity.2(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 60;
  private String jdField_b_of_type_JavaLangString = null;
  
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
  
  private void b()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackEvent second=");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(", curTime=");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("RegisterVerifyCodeActivity", 2, localStringBuilder.toString());
      }
      getIntent().putExtra("key_register_left_time", this.jdField_a_of_type_Int);
      getIntent().putExtra("key_register_exit_time", System.currentTimeMillis());
      setResult(-1, getIntent());
    }
    finish();
  }
  
  private void c()
  {
    setTitleText(2131716657);
    setTitleHint();
    setBackListener();
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false)) {
      setBarProgress(100);
    } else {
      setBarProgress(66);
    }
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
  
  private void d()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      ((AccountManager)this.mRuntime.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      createWaitingDialog(2131716637);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
    if ((str1 != null) && (str1.length() > 0)) {
      try
      {
        ((AccountManager)this.mRuntime.getManager(0)).sendRegisterByCommitSmsVerifycode(str1, this.jdField_a_of_type_MqqObserverAccountObserver);
        createWaitingDialog(2131716559);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    notifyToast(2131716570, 0);
  }
  
  public void a()
  {
    PhoneNumLoginImpl.a().a(this.mRuntime, true);
    boolean bool1 = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    boolean bool2 = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    boolean bool3 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetVerifyCodeView.a();
    Object localObject = str;
    if (str != null) {
      localObject = str.trim();
    }
    if (bool1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd == null) {
        this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = new RegisterWithNickAndPwd(this);
      }
      getIntent().putExtra("key_register_smscode", (String)localObject);
      getIntent().putExtra("key_register_autologin", true);
      getIntent().putExtra("key_register_phonenum_bindnewqq", bool2);
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.a(getIntent());
      return;
    }
    if ((bool3 ^ true))
    {
      localObject = new RegisterWithNickAndPwdInfoBuilder().a(this.phoneNum).b(this.countryCode).c((String)localObject).a(false).b(this.mHasPwd).d(this.inviteCode).a(5).e("").f("").c(true).d(false).e(this.jdField_a_of_type_Boolean).a();
      RegisterLimitHelperImpl.a().a(this, this.jdField_a_of_type_JavaLangString, (RegisterWithNickAndPwdInfo)localObject);
      return;
    }
    RegisterByNicknameAndPwdActivity.gotoRegisterByNicknameAndPwdActivity(this, this.phoneNum, this.countryCode, (String)localObject, this.mIsPhoneNumRegistered, this.mHasPwd, this.inviteCode, 5, "", "", true, this.jdField_a_of_type_Boolean);
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
    setContentView(2131563018);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    int i = getIntent().getIntExtra("key_register_left_time", 0);
    long l = getIntent().getLongExtra("key_register_exit_time", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate countryCode=");
      localStringBuilder.append(this.countryCode);
      localStringBuilder.append(", phoneNum=");
      localStringBuilder.append(PhoneCodeUtils.a(this.phoneNum));
      localStringBuilder.append(", leftTime=");
      localStringBuilder.append(i);
      localStringBuilder.append(", exitTime=");
      localStringBuilder.append(l);
      localStringBuilder.append(", inviteCode=");
      if (this.inviteCode == null) {
        paramBundle = "";
      } else {
        paramBundle = this.inviteCode;
      }
      localStringBuilder.append(paramBundle);
      QLog.d("RegisterVerifyCodeActivity", 2, localStringBuilder.toString());
    }
    if ((i > 0) && (i < 60) && (l > 0L))
    {
      l = System.currentTimeMillis() - l;
      if ((l > 0L) && (l < i * 1000L)) {
        this.jdField_a_of_type_Int = (i - (int)(l / 1000L));
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate interval=");
        paramBundle.append(l);
        paramBundle.append(", second=");
        paramBundle.append(this.jdField_a_of_type_Int);
        QLog.d("RegisterVerifyCodeActivity", 2, paramBundle.toString());
      }
    }
    this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.mHasPwd = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_friend_verify", false);
    LoginUtils.a(this.mRuntime, getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null, getIntent().getLongExtra("register_verify_code_start_time", 0L));
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
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
    if (this.jdField_a_of_type_Boolean) {
      i = 2;
    } else if (this.mFrom == 7) {
      i = 1;
    } else {
      i = 0;
    }
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8009CEC", "0X8009CEC", i, 0, "", "", this.phoneNum, "");
    getWindow().setSoftInputMode(5);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RegisterManager.a().a(3);
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd;
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
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.d();
    }
  }
  
  protected boolean onBackEvent()
  {
    b();
    return false;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
    if (localObject != null) {
      ((SmsContent)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
    this.handler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    localObject = this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick;
    if (localObject != null) {
      ((RegisterWithNick)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd;
    if (localObject != null) {
      ((RegisterWithNickAndPwd)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = null;
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
      if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.c();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onVerifyCodeComplete()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */