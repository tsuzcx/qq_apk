package com.tencent.mobileqq.activity;

import aduv;
import aduw;
import adux;
import aduy;
import alud;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awhw;
import awhy;
import awia;
import azqs;
import bdin;
import bebv;
import bebz;
import bety;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class RegisterQQNumberActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  awhw jdField_a_of_type_Awhw = new aduw(this);
  private bebz jdField_a_of_type_Bebz;
  private bety jdField_a_of_type_Bety;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new adux(this);
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aduv(this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] b;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f = true;
  private boolean g = true;
  private boolean h;
  private boolean i;
  private boolean j;
  
  private void a()
  {
    int k;
    Object localObject1;
    Object localObject2;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    View localView;
    if (this.f)
    {
      k = 2131717567;
      c(k);
      b();
      a(100);
      localObject1 = (ImageView)findViewById(2131373925);
      ((ImageView)localObject1).setVisibility(0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).rightMargin = ((int)(10.0F * getResources().getDisplayMetrics().density));
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject5 = (ImageView)findViewById(2131373925);
      localObject3 = (TextView)findViewById(2131379178);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379166));
      localObject4 = (Button)findViewById(2131363614);
      ((Button)localObject4).setOnClickListener(this);
      localObject2 = (TextView)findViewById(2131371795);
      localObject1 = (TextView)findViewById(2131371243);
      localView = findViewById(2131368430);
      if (this.f) {
        break label386;
      }
      ((ImageView)localObject5).setImageResource(2130846513);
      ((TextView)localObject3).setVisibility(8);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131373920);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(50.0F * getResources().getDisplayMetrics().density));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717471);
      ((TextView)localObject2).setVisibility(8);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131379166);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(50.0F * getResources().getDisplayMetrics().density));
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((Button)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((Button)localObject4).setText(2131720421);
      ((TextView)localObject1).setVisibility(8);
    }
    label386:
    do
    {
      return;
      k = 2131717470;
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_e_of_type_Boolean) {
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          localObject4 = new SpannableString(String.format(getString(2131717553), new Object[] { this.jdField_e_of_type_JavaLangString }));
          ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 8, this.jdField_e_of_type_JavaLangString.length() + 8, 33);
          ((TextView)localObject2).setText((CharSequence)localObject4);
        }
      }
      while (this.g)
      {
        ((TextView)localObject3).setText(2131717518);
        ((TextView)localObject1).setVisibility(8);
        return;
        ((TextView)localObject2).setVisibility(8);
        continue;
        if (!this.jdField_d_of_type_Boolean)
        {
          localObject4 = "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString.substring(0, 3) + "-" + this.jdField_a_of_type_JavaLangString.substring(3, 7) + "-" + this.jdField_a_of_type_JavaLangString.substring(7);
          localObject5 = new SpannableString(String.format(getString(2131717509), new Object[] { localObject4 }));
          ((SpannableString)localObject5).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 9, ((String)localObject4).length() + 9, 33);
          ((TextView)localObject2).setText((CharSequence)localObject5);
        }
        else
        {
          ((TextView)localObject2).setVisibility(8);
        }
      }
      ((TextView)localObject3).setText(2131717516);
      ((TextView)localObject1).setVisibility(0);
    } while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
    localView.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    if (this.jdField_e_of_type_Boolean) {
      azqs.a(this.app, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    if (!this.jdField_b_of_type_Boolean) {
      azqs.a(this.app, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("key_register_from_send_sms", false))
      {
        if (bool) {
          break;
        }
        azqs.a(this.app, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
      }
      return;
      if (!this.jdField_c_of_type_Boolean) {
        azqs.a(this.app, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
      } else if (!bool) {
        azqs.a(this.app, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
      } else {
        azqs.a(this.app, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
      }
    }
    azqs.a(this.app, "dc00898", "", "", paramString, paramString, 7, 0, "", "", "", "");
  }
  
  private void d()
  {
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.b);
    ((Intent)localObject).putExtra("fragment_id", 1);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
    localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
  }
  
  private void e()
  {
    awia.a().a(true);
    awia.a().b(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RegisterQQNumberActivity.5(this));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RegisterQQNumberActivity.6(this));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_d_of_type_JavaLangString))) {
      return;
    }
    this.h = paramBoolean;
    if ((!this.h) && (this.i))
    {
      g();
      a(2131717515, 0);
    }
    for (;;)
    {
      this.i = false;
      this.j = false;
      return;
      if ((this.h) && (this.i)) {
        if (this.jdField_d_of_type_Boolean) {
          getAppRuntime().login(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
        } else {
          awhy.a(this.app, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_JavaLangString);
        }
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged success");
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Awhw);
      if (this.jdField_e_of_type_Boolean)
      {
        this.app = ((QQAppInterface)getAppRuntime());
        LoginActivity.a(this.app, this.app.getAccount());
      }
      d();
      g();
    }
    do
    {
      return;
      if (awia.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged not phonenum login");
    return;
    this.app.unRegistObserver(this.jdField_a_of_type_Awhw);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_Awhw);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.a(new RegisterQQNumberActivity.1(this));
      QQToast.a(BaseApplicationImpl.sApplication, alud.a(2131713746), 0).a();
    }
    LoginActivity.a(this.app, this.app.getAccount());
    d();
    g();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    azqs.b(this.app, "CliOper", "", "", "0X8006655", "0X8006655", 0, 0, "", "", "", "");
    azqs.a(this.app, "new_reg", "result_page", "login_clk", "", 1, "", this.jdField_d_of_type_JavaLangString, "", "", "", "", "", "", " ");
    if (this.f)
    {
      azqs.a(this.app, "dc00898", "", "", "0X8007CCB", "0X8007CCB", 0, 0, "", "", "", "");
      a("0X8007CCB");
      if (this.jdField_e_of_type_Boolean) {
        azqs.a(this.app, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
      }
      if (!bdin.d(BaseApplication.getContext())) {
        a(2131692398, 0);
      }
    }
    else
    {
      finish();
      return;
    }
    if ((this.g) && (!this.h))
    {
      if (!this.j)
      {
        this.j = true;
        if (this.jdField_a_of_type_Bebz == null) {
          this.jdField_a_of_type_Bebz = new bebz(this, null);
        }
        this.jdField_a_of_type_Bebz.a(this.jdField_d_of_type_JavaLangString, new aduy(this));
      }
      this.i = true;
      f();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    f();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label398;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
    }
    while (this.jdField_d_of_type_Boolean)
    {
      getAppRuntime().login(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
      label398:
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = null");
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RegisterQQNumberActivity", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.jdField_d_of_type_JavaLangString, com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte) }));
    }
    awhy.a(this.app, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_JavaLangString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561668);
    if (QLog.isDevelopLevel()) {
      bebv.a(getClass().getSimpleName(), getIntent());
    }
    this.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_register_secret_phone");
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    String str;
    if (QLog.isDevelopLevel())
    {
      localObject1 = Locale.getDefault();
      localObject2 = this.jdField_d_of_type_JavaLangString;
      str = com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label340;
      }
    }
    label340:
    for (paramBundle = "";; paramBundle = this.jdField_c_of_type_JavaLangString)
    {
      QLog.d("RegisterQQNumberActivity", 4, String.format((Locale)localObject1, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { localObject2, str, paramBundle }));
      paramBundle = getIntent().getStringExtra("key_register_password");
      if (paramBundle != null) {
        this.jdField_b_of_type_ArrayOfByte = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte(paramBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "onCreate ,pwd = " + paramBundle + ",mPassByte = " + this.jdField_b_of_type_ArrayOfByte);
      }
      this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("key_register_unbind", false);
      if (this.app != null) {
        break;
      }
      QLog.d("RegisterQQNumberActivity", 2, "onCreate app is null");
      finish();
      return;
    }
    this.app.registObserver(this.jdField_a_of_type_Awhw);
    this.f = getIntent().getBooleanExtra("key_register_result", true);
    this.g = getIntent().getBooleanExtra("key_register_is_lh", false);
    if ((this.f) && (this.g))
    {
      this.i = false;
      this.j = true;
      this.jdField_a_of_type_Bebz = new bebz(this, null);
      this.jdField_a_of_type_Bebz.a(this.jdField_d_of_type_JavaLangString, new aduy(this));
    }
    a();
    b(true);
    azqs.b(this.app, "CliOper", "", "", "0X8006654", "0X8006654", 0, 0, "", "", "", "");
    Object localObject2 = this.app;
    if (this.f)
    {
      paramBundle = "0X800735F";
      if (!this.f) {
        break label609;
      }
    }
    label609:
    for (Object localObject1 = "0X800735F";; localObject1 = "0X8007CCA")
    {
      azqs.a((QQAppInterface)localObject2, "dc00898", "", "", paramBundle, (String)localObject1, 0, 0, "", "", "", "");
      azqs.a(this.app, "new_reg", "result_page", "page_exp", "", 1, "", this.jdField_d_of_type_JavaLangString, "", "", "", "", "", "", "");
      a("0X800735F");
      return;
      paramBundle = "0X8007CCA";
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_Awhw);
    }
    c();
    g();
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing()))
      {
        this.jdField_a_of_type_Bety.dismiss();
        this.jdField_a_of_type_Bety.cancel();
      }
      this.jdField_a_of_type_Bety = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity
 * JD-Core Version:    0.7.0.1
 */