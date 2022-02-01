package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.security.RegisterOverseaHelper;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.register.RegisterLimitHelperImpl;
import com.tencent.mobileqq.register.RegisterManager;
import com.tencent.mobileqq.register.RegisterWithNick;
import com.tencent.mobileqq.register.RegisterWithNickAndPwd;
import com.tencent.mobileqq.register.RegisterWithNickAndPwdInfo;
import com.tencent.mobileqq.register.RegisterWithNickAndPwdInfoBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterSendUpSms
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RegisterWithNick jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
  private RegisterWithNickAndPwd jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = null;
  private String jdField_a_of_type_JavaLangString;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new RegisterSendUpSms.2(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new RegisterSendUpSms.1(this);
  private String b;
  private String c = null;
  private String d = null;
  
  private CharSequence a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("RegisterSendUpSms", 1, "src is empty");
      return null;
    }
    if (paramString2 == null)
    {
      QLog.d("RegisterSendUpSms", 1, "value is null");
      return paramString1;
    }
    int i = paramString1.indexOf("%s");
    if (i == -1)
    {
      QLog.d("RegisterSendUpSms", 1, "getColorSpan, no %s tag");
      return paramString1;
    }
    paramString1 = new SpannableString(String.format(paramString1, new Object[] { paramString2 }));
    paramString1.setSpan(new ForegroundColorSpan(-16777216), i, paramString2.length() + i, 17);
    paramString1.setSpan(new StyleSpan(1), i, paramString2.length() + i, 17);
    return paramString1;
  }
  
  private String a(String paramString, RegisterSendUpSms.SpaceRule paramSpaceRule)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("RegisterSendUpSms", 1, "insertSpace charSequence is null");
      return null;
    }
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramString.charAt(i));
      if (paramSpaceRule.a(i)) {
        localStringBuilder.append(" ");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = LoginUtils.a(this, 2131701233);
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.getString("upmsg");
      this.b = paramString.getString("upnum");
      if ((TextUtils.isEmpty(this.phoneNum)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)))
      {
        QLog.e("RegisterSendUpSms", 1, new Object[] { "initView, data is unexpected, phoneNum : ", this.phoneNum, " upMsg : ", this.jdField_a_of_type_JavaLangString, " upNum : ", this.b });
        return;
      }
      paramString = (TextView)findViewById(2131380509);
      TextView localTextView1 = (TextView)findViewById(2131380605);
      TextView localTextView2 = (TextView)findViewById(2131380545);
      String str1 = a(this.phoneNum, new RegisterSendUpSms.PhoneRule(null));
      String str2 = a(this.b, new RegisterSendUpSms.MobileRule(null));
      paramString.setText(a(getString(2131716961), str1));
      localTextView1.setText(a(getString(2131716962), this.jdField_a_of_type_JavaLangString));
      localTextView2.setText(a(getString(2131716960), str2));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("RegisterSendUpSms", 1, new Object[] { "initView error : ", paramString.getMessage() });
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setData(Uri.parse("smsto:"));
      localIntent1.setType("vnd.android-dir/mms-sms");
      localIntent1.putExtra("address", paramString1);
      localIntent1.putExtra("sms_body", paramString2);
      startActivity(localIntent1);
      if (QLog.isColorLevel()) {
        QLog.d("RegisterSendUpSms", 2, String.format("sendSMS phoneNum:%s, msgBody:%s", new Object[] { paramString1, paramString2 }));
      }
      ReportController.a(this.mRuntime, "new_reg_805", "send_msg", "send_clk", "", 1, "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Intent localIntent2 = new Intent("android.intent.action.SENDTO");
        localIntent2.setData(Uri.parse("smsto:" + paramString1));
        localIntent2.putExtra("sms_body", paramString2);
        startActivity(localIntent2);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      QLog.d("RegisterSendUpSms", 1, "hide loading dialog, but dialog is null");
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void c()
  {
    AccountManager localAccountManager = (AccountManager)this.mRuntime.getManager(0);
    if (localAccountManager != null)
    {
      localAccountManager.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      a();
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  private void d()
  {
    ReportController.a(this.mRuntime, "new_reg", "send_msg", "next_clk", "", 1, "");
    boolean bool = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    if (!TextUtils.isEmpty(this.d)) {}
    for (int i = 1; bool; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd == null) {
        this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = new RegisterWithNickAndPwd(this);
      }
      getIntent().putExtra("key_register_smscode", this.jdField_a_of_type_JavaLangString);
      getIntent().putExtra("key_register_autologin", true);
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.a(getIntent());
      return;
    }
    if (i != 0)
    {
      RegisterWithNickAndPwdInfo localRegisterWithNickAndPwdInfo = new RegisterWithNickAndPwdInfoBuilder().a(this.phoneNum).b(this.countryCode).c(this.jdField_a_of_type_JavaLangString).a(true).b(false).d(this.inviteCode).a(4).e("").f("").c(true).d(true).e(false).a();
      RegisterLimitHelperImpl.a().a(this, this.d, localRegisterWithNickAndPwdInfo);
      return;
    }
    RegisterByNicknameAndPwdActivity.gotoRegisterByNicknameAndPwdActivity(this, this.phoneNum, this.countryCode, this.jdField_a_of_type_JavaLangString, this.mIsPhoneNumRegistered, this.mHasPwd, this.inviteCode, 4, "", "", true, false);
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
    setContentView(2131562943);
    setTitleText(2131716968);
    setBackListener();
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      setBarProgress(90);
      LoginUtils.a(this.mRuntime, getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      Intent localIntent = super.getIntent();
      if (localIntent != null)
      {
        this.phoneNum = localIntent.getStringExtra("phonenum");
        this.inviteCode = localIntent.getStringExtra("invite_code");
        this.countryCode = localIntent.getStringExtra("key");
        this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
        this.mHasPwd = getIntent().getBooleanExtra("key_register_has_pwd", true);
        this.c = getIntent().getStringExtra("key_register_binded_qq");
      }
      if (QLog.isDevelopLevel()) {
        RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
      }
      this.jdField_a_of_type_JavaLangString = super.getString(2131716969);
      this.b = super.getString(2131716970);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364111));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380254));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramBundle = "";
      if (localIntent != null) {
        paramBundle = localIntent.getStringExtra("key_register_prompt_info");
      }
      if (!TextUtils.isEmpty(paramBundle)) {
        a(paramBundle);
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 0, 0, "", "", this.phoneNum, "");
      if (this.mIsPhoneNumRegistered) {
        break label490;
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 1, 0, "", "", this.phoneNum, "");
      label340:
      if (!TextUtils.isEmpty(this.c)) {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 3, 0, "", "", this.phoneNum, "");
      }
      if (this.mFrom != 7) {
        break label537;
      }
      ReportController.a(this.mRuntime, "new_reg_805", "send_msg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      ReportController.a(null, "dc00898", "", "", "0X800B8DB", "0X800B8DB", 0, 0, "", "", RegisterOverseaHelper.a().a(), "");
      return true;
      setBarProgress(50);
      break;
      label490:
      if (this.mHasPwd) {
        break label340;
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 2, 0, "", "", this.phoneNum, "");
      break label340;
      label537:
      ReportController.a(this.mRuntime, "new_reg_805", "send_msg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    RegisterManager.a().a(2);
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "doOnResume mState: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if (this.jdField_a_of_type_Int == 1) {
      c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.b();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.d();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131380254)
    {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B4BA", "0X800B4BA", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int == 2) {
        QLog.d("RegisterSendUpSms", 1, "check sms, but is querying");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
      continue;
      if (i == 2131364111)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "onClick mState: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B4B9", "0X800B4B9", 0, 0, "", "", "", "");
        a(this.b, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Int = 1;
      }
    }
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
    LoginUtils.a(this.mRuntime, getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = null;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */