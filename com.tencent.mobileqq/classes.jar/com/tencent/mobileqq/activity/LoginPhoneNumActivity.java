package com.tencent.mobileqq.activity;

import Override;
import adqq;
import adqr;
import adqs;
import adqt;
import adqu;
import adqx;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import aych;
import bcef;
import bfxb;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class LoginPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private adqx jdField_a_of_type_Adqx;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adqu(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adqq(this);
  private byte[] jdField_a_of_type_ArrayOfByte;
  private TextView b;
  private boolean c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  
  private int a()
  {
    if (this.e == null) {}
    do
    {
      return 0;
      if (Login.class.getName().equals(this.e)) {
        return 4;
      }
      if (LoginView.class.getName().equals(this.e)) {
        return 1;
      }
      if (AddAccountActivity.class.getName().equals(this.e)) {
        return 3;
      }
    } while (!SubLoginActivity.class.getName().equals(this.e));
    return 2;
  }
  
  private String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.jdField_b_of_type_JavaLangString)) {
          break label170;
        }
        if ("853".equals(this.jdField_b_of_type_JavaLangString))
        {
          break label170;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.jdField_b_of_type_JavaLangString)) {
            i = 0;
          }
        }
        if (!"86".equals(this.jdField_b_of_type_JavaLangString)) {
          break label162;
        }
        j = paramString.length();
        if (j == 11) {
          break label162;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label145;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_b_of_type_JavaLangString);
      if (bool)
      {
        i = 9;
        continue;
        label145:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        i = 6;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString());
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      a(2131716098, 1);
      bool = false;
    }
    return bool;
  }
  
  private String b()
  {
    if (this.app == null) {
      return "";
    }
    if (this.app.isLogin()) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
  }
  
  private void d()
  {
    c(2131719445);
    b();
    a(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379972));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362973));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379971));
    this.jdField_b_of_type_JavaLangString = bfxb.b(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("+" + this.jdField_b_of_type_JavaLangString);
    if ("86".equals(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716057));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131371968));
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setCustomSelectionActionModeCallback(new adqs(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363892));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setOnCreateContextMenuListener(new adqt(this));
    }
  }
  
  private void e()
  {
    if (!a()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ArrayOfByte == null)
      {
        QLog.d("LoginPhoneNumActivity", 1, "startQueryAccount, but mReqData is null");
        return;
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        a(2131692035, 0);
        return;
      }
      b(2131705879);
    } while (aych.a().a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    c();
    a(getString(2131716113), 1);
  }
  
  public void a()
  {
    boolean bool = getIntent().getBooleanExtra("login_from_account_change", false);
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("isSubaccount", this.c);
    localIntent.putExtra("fromWhere", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("login_from_account_change", bool);
    localIntent.putExtra("entrance", this.e);
    if ((bool) || (Login.class.getName().equals(this.e)))
    {
      startActivityForResult(localIntent, 20140319);
      return;
    }
    startActivity(localIntent);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (a(paramEditable.toString()) != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
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
    setContentView(2131561153);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.c = paramBundle.getBooleanExtra("isSubaccount", false);
      this.e = paramBundle.getStringExtra("entrance");
    }
    if (this.app != null) {
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    }
    d();
    this.jdField_a_of_type_Adqx = new adqx();
    paramBundle = new adqr(this);
    this.jdField_a_of_type_Adqx.a(paramBundle);
    bcef.a(this.app, "dc00898", "", "", "0X800B104", "0X800B104", a(), 0, "", "", "", "");
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("+" + this.jdField_b_of_type_JavaLangString);
      try
      {
        if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString()) != null)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if ((paramInt1 == 20140319) && (paramInt2 == -1))
    {
      if (paramIntent != null) {
        paramIntent.putExtra("fromLoginPhoneNum", true);
      }
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      startActivityForResult(new Intent(this, NewStyleCountryActivity.class), 1);
      bcef.a(this.app, "dc00898", "", "", "0X800B105", "0X800B105", a(), 0, "", "", "", "");
      continue;
      if (!this.jdField_a_of_type_Adqx.a(this))
      {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      else
      {
        QLog.d("LoginPhoneNumActivity", 1, "click next step");
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("keyFrom", LoginPhoneNumActivity.class.getName());
        startActivity(localIntent.putExtra("url", "https://ti.qq.com/safe/tools/captcha/sms-verify-login"));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_d_of_type_Boolean = true;
        bcef.a(this.app, "dc00898", "", b(), "0X800B106", "0X800B106", a(), 0, "", "", "", "");
        bcef.a(this.app, "dc00898", "", b(), "0X800B108", "0X800B108", a(), 0, "", "", "", "");
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
    c();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */