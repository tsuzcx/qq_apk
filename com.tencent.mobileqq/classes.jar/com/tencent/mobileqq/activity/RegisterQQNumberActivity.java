package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.loginregister.ContactProxy;
import com.tencent.mobileqq.loginregister.IRegisterView;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class RegisterQQNumberActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, IRegisterView
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactProxy jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy;
  private RegisterLiangHaoHelper jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString = null;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new RegisterQQNumberActivity.2(this);
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new RegisterQQNumberActivity.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  private boolean c = false;
  private boolean d = true;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  private void a()
  {
    int i;
    if (this.d) {
      i = 2131716646;
    } else {
      i = 2131716565;
    }
    setTitleText(i);
    setBackListener();
    setBarProgress(100);
    Object localObject1 = (ImageView)findViewById(2131374670);
    ((ImageView)localObject1).setVisibility(0);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).rightMargin = ((int)(getResources().getDisplayMetrics().density * 10.0F));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject5 = (ImageView)findViewById(2131374670);
    Object localObject3 = (TextView)findViewById(2131380055);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380045));
    Object localObject4 = (Button)findViewById(2131363959);
    ((Button)localObject4).setOnClickListener(this);
    localObject2 = (TextView)findViewById(2131372549);
    localObject1 = (TextView)findViewById(2131371956);
    View localView = findViewById(2131368949);
    if (!this.d)
    {
      ((ImageView)localObject5).setImageResource(2130847199);
      ((TextView)localObject3).setVisibility(8);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131374665);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(getResources().getDisplayMetrics().density * 50.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131716566);
      ((TextView)localObject2).setVisibility(8);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131380045);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(getResources().getDisplayMetrics().density * 50.0F));
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((Button)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((Button)localObject4).setText(2131699824);
      ((TextView)localObject1).setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.c)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject4 = new SpannableString(String.format(getString(2131716635), new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 8, this.jdField_b_of_type_JavaLangString.length() + 8, 33);
        ((TextView)localObject2).setText((CharSequence)localObject4);
      }
      else
      {
        ((TextView)localObject2).setVisibility(8);
      }
    }
    else if (!this.jdField_b_of_type_Boolean)
    {
      localObject4 = new StringBuilder("+");
      ((StringBuilder)localObject4).append(this.countryCode);
      ((StringBuilder)localObject4).append(" ");
      ((StringBuilder)localObject4).append(this.phoneNum.substring(0, 3));
      ((StringBuilder)localObject4).append("-");
      ((StringBuilder)localObject4).append(this.phoneNum.substring(3, 7));
      ((StringBuilder)localObject4).append("-");
      ((StringBuilder)localObject4).append(this.phoneNum.substring(7));
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new SpannableString(String.format(getString(2131716592), new Object[] { localObject4 }));
      ((SpannableString)localObject5).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 9, ((String)localObject4).length() + 9, 33);
      ((TextView)localObject2).setText((CharSequence)localObject5);
    }
    else
    {
      ((TextView)localObject2).setVisibility(8);
    }
    if (this.e)
    {
      ((TextView)localObject3).setText(2131716600);
      ((TextView)localObject1).setVisibility(8);
      return;
    }
    ((TextView)localObject3).setText(2131716599);
    ((TextView)localObject1).setVisibility(0);
    if (!TextUtils.isEmpty(this.inviteCode)) {
      localView.setVisibility(0);
    }
  }
  
  private void a(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    if (this.c) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    if (!this.mIsPhoneNumRegistered) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
    } else if (!this.mHasPwd) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
    } else if (!bool) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
    }
    if (getIntent().getBooleanExtra("key_register_from_send_sms", false))
    {
      if (!bool)
      {
        ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
        return;
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 7, 0, "", "", "", "");
    }
  }
  
  private void b()
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("tab_index", 0);
    ((Intent)localObject).putExtra("fragment_id", 1);
    ((Intent)localObject).addFlags(67108864);
    LoginUtils.a(this, (Intent)localObject, "/base/start/splash");
    finish();
    if (!(this.mRuntime instanceof AppInterface))
    {
      QLog.e("RegisterQQNumberActivity", 1, "closeAllActs, app is not appinterface");
      return;
    }
    localObject = ((AppInterface)this.mRuntime).getHandler(LoginProgressClazz.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(2004);
    }
  }
  
  private void c()
  {
    PhoneNumLoginImpl.a().a(true);
    PhoneNumLoginImpl.a().b(this.mRuntime, this.countryCode, this.phoneNum, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void d()
  {
    this.handler.post(new RegisterQQNumberActivity.3(this));
  }
  
  private void e()
  {
    this.handler.post(new RegisterQQNumberActivity.4(this));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (!paramString.equals(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      this.f = paramBoolean;
      if ((!this.f) && (this.g))
      {
        e();
        notifyToast(2131716598, 0);
      }
      else if ((this.f) && (this.g))
      {
        if (this.jdField_b_of_type_Boolean) {
          getAppRuntime().login(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this.mRuntime, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString);
        }
      }
      this.g = false;
      this.h = false;
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
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void k()
  {
    c();
  }
  
  public void l()
  {
    e();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged success");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.mRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this));
      if (this.c)
      {
        this.mRuntime = getAppRuntime();
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this.mRuntime, this.jdField_a_of_type_JavaLangString);
      }
      b();
      e();
      return;
    }
    if (!PhoneNumLoginImpl.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged not phonenum login");
      }
      return;
    }
    this.mRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this));
    this.mRuntime = getAppRuntime();
    this.mRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this));
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this.mRuntime);
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this.mRuntime, this.jdField_a_of_type_JavaLangString);
    b();
    e();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363959)
    {
      ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006655", "0X8006655", 0, 0, "", "", "", "");
      ReportController.a(this.mRuntime, "new_reg", "result_page", "login_clk", "", 1, "", this.jdField_a_of_type_JavaLangString, "", "", "", "", "", "", " ");
      if (this.d)
      {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CCB", "0X8007CCB", 0, 0, "", "", "", "");
        a("0X8007CCB");
        if (this.c) {
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          notifyToast(2131692183, 0);
        }
        else if ((this.e) && (!this.f))
        {
          if (!this.h)
          {
            this.h = true;
            if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper == null) {
              this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = new RegisterLiangHaoHelper(this, null);
            }
            this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a(this.jdField_a_of_type_JavaLangString, new RegisterQQNumberActivity.LHCallback(this));
          }
          this.g = true;
          d();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("RegisterQQNumberActivity", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
          }
          d();
          if (QLog.isColorLevel()) {
            if (this.jdField_a_of_type_ArrayOfByte != null)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("swz mSign = ");
                localStringBuilder.append(HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
                QLog.d("RegisterQQNumberActivity", 2, localStringBuilder.toString());
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("RegisterQQNumberActivity", 2, "swz mSign = null");
            }
          }
          if (this.jdField_b_of_type_Boolean)
          {
            getAppRuntime().login(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
          }
          else
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("RegisterQQNumberActivity", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.jdField_a_of_type_JavaLangString, com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte) }));
            }
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this.mRuntime, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString);
          }
        }
      }
      else
      {
        finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561856);
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy = new ContactProxy();
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    this.c = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    if (this.c) {
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key_register_secret_phone");
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.mHasPwd = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = Locale.getDefault();
      localObject2 = this.jdField_a_of_type_JavaLangString;
      String str = com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte);
      if (this.inviteCode == null) {
        paramBundle = "";
      } else {
        paramBundle = this.inviteCode;
      }
      QLog.d("RegisterQQNumberActivity", 4, String.format((Locale)localObject1, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { localObject2, str, paramBundle }));
    }
    paramBundle = getIntent().getStringExtra("key_register_password");
    if (paramBundle != null) {
      this.jdField_b_of_type_ArrayOfByte = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte(paramBundle);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCreate ,pwd = ");
      ((StringBuilder)localObject1).append(paramBundle);
      ((StringBuilder)localObject1).append(",mPassByte = ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_ArrayOfByte);
      QLog.d("RegisterQQNumberActivity", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_unbind", false);
    if (this.mRuntime == null)
    {
      QLog.d("RegisterQQNumberActivity", 2, "onCreate app is null");
      finish();
      return;
    }
    this.mRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this));
    this.d = getIntent().getBooleanExtra("key_register_result", true);
    this.e = getIntent().getBooleanExtra("key_register_is_lh", false);
    if ((this.d) && (this.e))
    {
      this.g = false;
      this.h = true;
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = new RegisterLiangHaoHelper(this, null);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a(this.jdField_a_of_type_JavaLangString, new RegisterQQNumberActivity.LHCallback(this));
    }
    a();
    closeAllActs(true);
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006654", "0X8006654", 0, 0, "", "", "", "");
    Object localObject2 = this.mRuntime;
    if (this.d) {
      paramBundle = "0X800735F";
    } else {
      paramBundle = "0X8007CCA";
    }
    if (this.d) {
      localObject1 = "0X800735F";
    } else {
      localObject1 = "0X8007CCA";
    }
    ReportController.a((AppRuntime)localObject2, "dc00898", "", "", paramBundle, (String)localObject1, 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "new_reg", "result_page", "page_exp", "", 1, "", this.jdField_a_of_type_JavaLangString, "", "", "", "", "", "", "");
    a("0X800735F");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mRuntime != null) {
      this.mRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactProxy.a(this));
    }
    closeDialog();
    e();
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity
 * JD-Core Version:    0.7.0.1
 */