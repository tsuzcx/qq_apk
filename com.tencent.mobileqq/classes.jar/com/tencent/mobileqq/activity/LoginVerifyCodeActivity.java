package com.tencent.mobileqq.activity;

import Override;
import aeie;
import aeif;
import aeig;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import aoef;
import apak;
import apam;
import azit;
import bdla;
import bisl;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.SubAccountObserver;
import mqq.observer.WtloginObserver;

public class LoginVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, View.OnKeyListener, apak
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131380729, 2131380730, 2131380731, 2131380732, 2131380733, 2131380734 };
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public aoef a;
  private apam jdField_a_of_type_Apam;
  private bisl jdField_a_of_type_Bisl;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LoginVerifyCodeActivity.1(this);
  public SubAccountObserver a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aeie(this);
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private int jdField_b_of_type_Int = 60;
  private Runnable jdField_b_of_type_JavaLangRunnable = new LoginVerifyCodeActivity.7(this);
  private boolean c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public LoginVerifyCodeActivity()
  {
    this.jdField_a_of_type_MqqObserverSubAccountObserver = new aeif(this);
    this.jdField_a_of_type_Aoef = new aeig(this);
  }
  
  private int a()
  {
    if (this.h == null) {}
    do
    {
      return 0;
      if (Login.class.getName().equals(this.h)) {
        return 4;
      }
      if (LoginView.class.getName().equals(this.h)) {
        return 1;
      }
      if (AddAccountActivity.class.getName().equals(this.h)) {
        return 3;
      }
    } while (!SubLoginActivity.class.getName().equals(this.h));
    return 2;
  }
  
  private void a()
  {
    int i = 0;
    c(2131716509);
    b();
    ((TextView)findViewById(2131380349)).setText(getString(2131716504, new Object[] { "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364016));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716478) + "(" + this.jdField_b_of_type_Int + ")");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(jdField_a_of_type_ArrayOfInt[i]).findViewById(2131380352));
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
      i += 1;
    }
  }
  
  private String b()
  {
    if (this.app == null) {
      return "";
    }
    if (this.app.isLogin()) {
      return "";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "startLogin start...");
    }
    if (this.c)
    {
      azit.a().b(this.app, this.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
    }
    azit.a().b(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716478) + "(" + this.jdField_b_of_type_Int + ")");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    b(2131716489);
    if (azit.a().a(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      c();
      a(2131718059, 1);
    }
  }
  
  private void f()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      a(2131692125, 0);
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = new StringBuilder("");
      int i = 0;
      while (i < 6)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
        if (localObject2 != null) {
          ((StringBuilder)localObject1).append(localObject2.toString());
        }
        i += 1;
      }
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break;
      }
      b(2131716413);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
    } while (azit.a().a(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    c();
    a(2131718059, 1);
    return;
    a(2131716424, 0);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 1;
    int j = 0;
    Editable localEditable;
    if (j < 6)
    {
      localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].getText();
      if (localEditable == null) {
        break label207;
      }
    }
    label135:
    label207:
    for (int k = localEditable.toString().length();; k = 0)
    {
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[j]).findViewById(2131370141);
      if ((localEditable != null) && (localEditable == paramEditable))
      {
        if (k <= 0) {
          break label135;
        }
        localView.setBackgroundColor(-9474193);
        if (j < 5)
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].requestFocus();
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].length());
        }
      }
      label116:
      if ((localEditable == null) || (k <= 0)) {
        i = 0;
      }
      for (;;)
      {
        j += 1;
        break;
        if (k != 0) {
          break label116;
        }
        localView.setBackgroundColor(-2170912);
        if ((j <= 0) || (j >= 6)) {
          break label116;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j - 1)].requestFocus();
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j - 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j - 1)].length());
        break label116;
        if (i != 0) {
          f();
        }
        return;
      }
    }
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (QLog.isDevelopLevel())
      {
        paramIntent = new StringBuilder().append("doOnActivityResult, REQ_CODE_NOTIFICATION_LH  ");
        if (paramInt2 != -1) {
          break label65;
        }
      }
    }
    for (;;)
    {
      QLog.i("LoginVerifyCodeActivity", 4, bool);
      if (paramInt2 == -1) {
        finish();
      }
      return;
      label65:
      bool = false;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561216);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.d = paramBundle.getStringExtra("fromWhere");
      this.c = paramBundle.getBooleanExtra("isSubaccount", false);
      this.h = paramBundle.getStringExtra("entrance");
    }
    if (this.c) {
      addObserver(this.jdField_a_of_type_Aoef);
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    a();
    this.jdField_a_of_type_Apam = new apam(null);
    this.jdField_a_of_type_Apam.a(this, this);
    bdla.a(this.app, "dc00898", "", b(), "0X800B109", "0X800B109", a(), 0, "", "", "", "");
    return true;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    QLog.d("LoginVerifyCodeActivity", 1, new Object[] { "getSmsContent, smsAddress : ", paramString1, " smsBody : ", paramString2 });
    if (this.g != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.f = paramString1;
    this.g = paramString2;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1500L);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      a(2131692125, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363964: 
        f();
        break;
      case 2131364016: 
        e();
        bdla.a(this.app, "dc00898", "", b(), "0X800B10A", "0X800B10A", a(), 0, "", "", "", "");
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
    if (this.c) {
      removeObserver(this.jdField_a_of_type_Aoef);
    }
    if (this.jdField_a_of_type_Apam != null) {
      this.jdField_a_of_type_Apam.a();
    }
    this.jdField_a_of_type_Apam = null;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if ((paramKeyEvent.getAction() == 0) && ((paramView instanceof EditText)))
    {
      paramView = ((EditText)paramView).getText();
      i = 0;
    }
    for (;;)
    {
      if (i < 6)
      {
        paramKeyEvent = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
        if ((paramKeyEvent == null) || (paramKeyEvent != paramView)) {
          break label180;
        }
        if (paramInt != 67) {
          break label119;
        }
        if ((i > 0) && (i < 6) && (paramKeyEvent.toString().length() <= 0))
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i - 1)].requestFocus();
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i - 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i - 1)].length());
        }
      }
      label119:
      while ((i < 0) || (i >= 5) || (paramKeyEvent.toString().length() < 1)) {
        return false;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i + 1)].requestFocus();
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i + 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i + 1)].length());
      return false;
      label180:
      i += 1;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */