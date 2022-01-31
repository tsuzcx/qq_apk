package com.tencent.mobileqq.activity;

import aduh;
import adui;
import aduj;
import aduk;
import aepi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import axmj;
import axml;
import azqs;
import bcyz;
import bdgm;
import bdjz;
import bebv;
import bety;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterChooseLoginActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  public int a;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axmj jdField_a_of_type_Axmj;
  private axml jdField_a_of_type_Axml;
  private bety jdField_a_of_type_Bety;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aduk(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aduh(this);
  public boolean a;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String f;
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      super.setTitle(2131717526);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    super.setTitle(2131717529);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  private void d()
  {
    bdgm.a(this, 0, null, super.getResources().getString(2131717490, new Object[] { "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString }), super.getResources().getString(2131717454), super.getResources().getString(2131717472), null, new adui(this), new aduj(this)).show();
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "gotoRegisterByNickAndPwd ,isPhoneNumBindNewQQ=" + paramBoolean);
    }
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      if (this.jdField_a_of_type_Axml == null) {
        this.jdField_a_of_type_Axml = new axml(this);
      }
      this.jdField_a_of_type_Axml.a(getIntent());
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, this.jdField_c_of_type_Boolean, false, this.jdField_c_of_type_JavaLangString, 6, "", "", paramBoolean);
  }
  
  private void e()
  {
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
  
  public void a()
  {
    c(2131717507);
    b();
    a(65);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379154));
    Object localObject1 = (ImageView)super.findViewById(2131373521);
    Object localObject2 = super.getIntent().getStringExtra("key_register_binded_qq_face_url");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        int i = aepi.a(70.0F, super.getResources());
        int j = aepi.a(70.0F, super.getResources());
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mLoadingDrawable = super.getResources().getDrawable(2130840085);
        localURLDrawableOptions.mFailedDrawable = super.getResources().getDrawable(2130840392);
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        ((URLDrawable)localObject2).setTag(bcyz.a(i, j));
        ((URLDrawable)localObject2).setDecodeHandler(bcyz.a);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        localObject1 = (TextView)super.findViewById(2131373566);
        localObject2 = super.getIntent().getStringExtra("key_register_binded_qq_nick");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label264;
        }
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)super.findViewById(2131373567)).setText(this.f);
        ((Button)super.findViewById(2131363533)).setOnClickListener(this);
        ((Button)super.findViewById(2131363534)).setOnClickListener(this);
        c(false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localException.setImageResource(2130840392);
      continue;
      label264:
      localException.setVisibility(8);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561669);
    if (QLog.isDevelopLevel()) {
      bebv.a(getClass().getSimpleName(), getIntent());
    }
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("key_register_from", -1);
    this.jdField_d_of_type_JavaLangString = super.getIntent().getStringExtra("key_register_smscode");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = "";
    }
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = super.getIntent().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = super.getIntent().getStringExtra("key");
    this.jdField_e_of_type_JavaLangString = super.getIntent().getStringExtra("key_register_binded_qq");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      int i = this.jdField_e_of_type_JavaLangString.length();
      this.f = (this.jdField_e_of_type_JavaLangString.substring(0, 2) + "****" + this.jdField_e_of_type_JavaLangString.substring(i - 2, i));
    }
    this.jdField_e_of_type_Boolean = super.getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    this.jdField_c_of_type_Boolean = super.getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    this.jdField_b_of_type_Boolean = true;
    a();
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    azqs.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 0, 0, "", "", "", "");
    if (!this.jdField_c_of_type_Boolean) {
      azqs.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 1, 0, "", "", "", "");
    }
    if (!this.jdField_e_of_type_Boolean)
    {
      azqs.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 2, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int != 4) {
        break label448;
      }
      azqs.a(this.app, "new_reg_805", "already_reg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      azqs.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 3, 0, "", "", "", "");
      break;
      label448:
      if (this.jdField_a_of_type_Int == 5) {
        azqs.a(this.app, "new_reg_805", "already_reg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
      } else {
        azqs.a(this.app, "new_reg_805", "already_reg", "page_exp", "", 1, "", "3", "", "", "", "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Axmj != null) {
      this.jdField_a_of_type_Axmj.a();
    }
    this.jdField_a_of_type_Axmj = null;
    if (this.jdField_a_of_type_Axml != null) {
      this.jdField_a_of_type_Axml.a();
    }
    this.jdField_a_of_type_Axml = null;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "onAccountChanged success");
    }
    this.app = ((QQAppInterface)getAppRuntime());
    LoginActivity.a(this.app, this.app.getAccount());
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.b);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    super.finish();
    localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
    e();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean) {
      c(false);
    }
    for (;;)
    {
      return true;
      MqqHandler localMqqHandler = this.app.getHandler(RegisterVerifyCodeActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(108);
      }
      super.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363533: 
      paramView = new Intent(this, LoginActivity.class);
      paramView.putExtra("from_register_choose", true);
      paramView.putExtra("uin", this.jdField_e_of_type_JavaLangString);
      paramView.putExtra("hasPwd", this.jdField_c_of_type_Boolean);
      startActivity(paramView);
      azqs.a(this.app, "new_reg_805", "already_reg", "log_clk", "", 1, "");
      return;
    }
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false)) {
      d(true);
    }
    for (;;)
    {
      azqs.a(this.app, "new_reg_805", "already_reg", "con_clk", "", 1, "");
      return;
      if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
        d(false);
      } else {
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterChooseLoginActivity
 * JD-Core Version:    0.7.0.1
 */