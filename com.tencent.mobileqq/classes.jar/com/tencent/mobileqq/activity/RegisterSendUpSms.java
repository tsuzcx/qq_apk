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
  private String a;
  private String b;
  private String c = null;
  private String d = null;
  private Button e;
  private TextView f;
  private Dialog g;
  private int h = 0;
  private MqqHandler i = new RegisterSendUpSms.1(this);
  private RegisterWithNick j = null;
  private RegisterWithNickAndPwd k = null;
  private AccountObserver l = new RegisterSendUpSms.2(this);
  
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
    int m = paramString1.indexOf("%s");
    if (m == -1)
    {
      QLog.d("RegisterSendUpSms", 1, "getColorSpan, no %s tag");
      return paramString1;
    }
    paramString1 = new SpannableString(String.format(paramString1, new Object[] { paramString2 }));
    paramString1.setSpan(new ForegroundColorSpan(-16777216), m, paramString2.length() + m, 17);
    paramString1.setSpan(new StyleSpan(1), m, paramString2.length() + m, 17);
    return paramString1;
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.getString("upmsg");
      this.b = paramString.getString("upnum");
      if ((!TextUtils.isEmpty(this.phoneNum)) && (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)))
      {
        paramString = (TextView)findViewById(2131448639);
        TextView localTextView1 = (TextView)findViewById(2131448755);
        TextView localTextView2 = (TextView)findViewById(2131448689);
        String str1 = a(this.phoneNum, new RegisterSendUpSms.PhoneRule());
        String str2 = a(this.b, new RegisterSendUpSms.MobileRule());
        paramString.setText(a(getString(2131914077), str1));
        localTextView1.setText(a(getString(2131914078), this.a));
        localTextView2.setText(a(getString(2131914076), str2));
        return;
      }
      QLog.e("RegisterSendUpSms", 1, new Object[] { "initView, data is unexpected, phoneNum : ", this.phoneNum, " upMsg : ", this.a, " upNum : ", this.b });
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("RegisterSendUpSms", 1, new Object[] { "initView error : ", paramString.getMessage() });
    }
  }
  
  private void b()
  {
    if (this.g == null) {
      this.g = LoginUtils.a(this, 2131899402);
    }
    this.g.show();
  }
  
  private void b(String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setData(Uri.parse("smsto:"));
      localIntent1.setType("vnd.android-dir/mms-sms");
      localIntent1.putExtra("address", paramString1);
      localIntent1.putExtra("sms_body", paramString2);
      startActivity(localIntent1);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Intent localIntent2 = new Intent("android.intent.action.SENDTO");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramString1);
      localIntent2.setData(Uri.parse(localStringBuilder.toString()));
      localIntent2.putExtra("sms_body", paramString2);
      startActivity(localIntent2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterSendUpSms", 2, String.format("sendSMS phoneNum:%s, msgBody:%s", new Object[] { paramString1, paramString2 }));
    }
    ReportController.a(this.mRuntime, "new_reg_805", "send_msg", "send_clk", "", 1, "");
  }
  
  private void c()
  {
    Dialog localDialog = this.g;
    if (localDialog == null)
    {
      QLog.d("RegisterSendUpSms", 1, "hide loading dialog, but dialog is null");
      return;
    }
    localDialog.dismiss();
  }
  
  private void d()
  {
    AccountManager localAccountManager = (AccountManager)this.mRuntime.getManager(0);
    if (localAccountManager != null)
    {
      localAccountManager.queryUpSmsStat(this.l);
      b();
      this.h = 2;
    }
  }
  
  private void e()
  {
    ReportController.a(this.mRuntime, "new_reg", "send_msg", "next_clk", "", 1, "");
    boolean bool1 = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    boolean bool2 = TextUtils.isEmpty(this.d);
    if (bool1)
    {
      if (this.k == null) {
        this.k = new RegisterWithNickAndPwd(this);
      }
      getIntent().putExtra("key_register_smscode", this.a);
      getIntent().putExtra("key_register_autologin", true);
      this.k.a(getIntent());
      return;
    }
    if ((bool2 ^ true))
    {
      RegisterWithNickAndPwdInfo localRegisterWithNickAndPwdInfo = new RegisterWithNickAndPwdInfoBuilder().a(this.phoneNum).b(this.countryCode).c(this.a).a(true).b(false).d(this.inviteCode).a(4).e("").f("").c(true).d(true).e(false).a();
      RegisterLimitHelperImpl.a().a(this, this.d, localRegisterWithNickAndPwdInfo);
      return;
    }
    RegisterByNicknameAndPwdActivity.gotoRegisterByNicknameAndPwdActivity(this, this.phoneNum, this.countryCode, this.a, this.mIsPhoneNumRegistered, this.mHasPwd, this.inviteCode, 4, "", "", true, false);
  }
  
  protected String a(String paramString, RegisterSendUpSms.SpaceRule paramSpaceRule)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("RegisterSendUpSms", 1, "insertSpace charSequence is null");
      return null;
    }
    int n = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    while (m < n)
    {
      localStringBuilder.append(paramString.charAt(m));
      if (paramSpaceRule.a(m)) {
        localStringBuilder.append(" ");
      }
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 0, 0, "", "", this.phoneNum, "");
    if (!this.mIsPhoneNumRegistered) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 1, 0, "", "", this.phoneNum, "");
    } else if (!this.mHasPwd) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 2, 0, "", "", this.phoneNum, "");
    }
    if (!TextUtils.isEmpty(this.c)) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007364", "0X8007364", 3, 0, "", "", this.phoneNum, "");
    }
    if (this.mFrom == 7) {
      ReportController.a(this.mRuntime, "new_reg_805", "send_msg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "new_reg_805", "send_msg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
    ReportController.a(null, "dc00898", "", "", "0X800B8DB", "0X800B8DB", 0, 0, "", "", RegisterOverseaHelper.a().b(), "");
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("key_register_from_fail_pay_lh", false)) {
      setBarProgress(90);
    } else {
      setBarProgress(50);
    }
    LoginUtils.a(this.mRuntime, getClass(), this.i);
    if (paramIntent != null)
    {
      this.phoneNum = paramIntent.getStringExtra("phonenum");
      this.inviteCode = paramIntent.getStringExtra("invite_code");
      this.countryCode = paramIntent.getStringExtra("key");
      this.mIsPhoneNumRegistered = paramIntent.getBooleanExtra("key_register_is_phone_num_registered", false);
      this.mHasPwd = paramIntent.getBooleanExtra("key_register_has_pwd", true);
      this.c = paramIntent.getStringExtra("key_register_binded_qq");
    }
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    a();
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
    setContentView(2131629195);
    setTitleText(2131914084);
    setBackListener();
    paramBundle = getIntent();
    a(paramBundle);
    this.a = super.getString(2131914085);
    this.b = super.getString(2131914086);
    this.e = ((Button)findViewById(2131429988));
    this.f = ((TextView)findViewById(2131448325));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    if (paramBundle != null) {
      paramBundle = paramBundle.getStringExtra("key_register_prompt_info");
    } else {
      paramBundle = "";
    }
    if (!TextUtils.isEmpty(paramBundle)) {
      a(paramBundle);
    }
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.k;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RegisterManager.b().a(2);
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "doOnResume mState: %s", new Object[] { Integer.valueOf(this.h) }));
    }
    if (this.h == 1) {
      d();
    }
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.k;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.b();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.k;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.d();
    }
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131448325)
    {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B4BA", "0X800B4BA", 0, 0, "", "", "", "");
      if (this.h == 2) {
        QLog.d("RegisterSendUpSms", 1, "check sms, but is querying");
      } else {
        d();
      }
    }
    else if (m == 2131429988)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "onClick mState: %s", new Object[] { Integer.valueOf(this.h) }));
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B4B9", "0X800B4B9", 0, 0, "", "", "", "");
      b(this.b, this.a);
      this.h = 1;
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
    LoginUtils.b(this.mRuntime, getClass());
    Object localObject = this.j;
    if (localObject != null) {
      ((RegisterWithNick)localObject).a();
    }
    this.j = null;
    localObject = this.k;
    if (localObject != null) {
      ((RegisterWithNickAndPwd)localObject).a();
    }
    this.k = null;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */