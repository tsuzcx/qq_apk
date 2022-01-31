package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;
import mqq.observer.WtloginObserver;
import taq;
import tar;
import tas;
import tat;
import tau;

public class LoginVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, View.OnKeyListener, SMSBodyObserver
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131370411, 2131370412, 2131370413, 2131370414, 2131370415, 2131370416 };
  private int jdField_a_of_type_Int = 60;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SubAccountBindObserver a;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private Runnable jdField_a_of_type_JavaLangRunnable = new taq(this);
  public SubAccountObserver a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new tar(this);
  private boolean jdField_a_of_type_Boolean;
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private String c;
  private String d;
  
  public LoginVerifyCodeActivity()
  {
    this.jdField_a_of_type_MqqObserverSubAccountObserver = new tas(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new tat(this);
  }
  
  private void a()
  {
    int i = 0;
    c(2131434274);
    b();
    ((TextView)findViewById(2131370069)).setText(getString(2131434276, new Object[] { "+" + this.b + " " + this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370071));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434277) + "(" + this.jdField_a_of_type_Int + ")");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(jdField_a_of_type_ArrayOfInt[i]).findViewById(2131374956));
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
      i += 1;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "startLogin start...");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      PhoneNumLoginImpl.a().b(this.app, this.app.getCurrentAccountUin(), this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
    }
    PhoneNumLoginImpl.a().b(this.app, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434277) + "(" + this.jdField_a_of_type_Int + ")");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    b(2131434231);
    if (PhoneNumLoginImpl.a().a(this.app, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      c();
      a(2131434460, 1);
    }
  }
  
  private void f()
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      a(2131433009, 0);
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
      b(2131434235);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
    } while (PhoneNumLoginImpl.a().a(this.app, this.b, this.jdField_a_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    c();
    a(2131434460, 1);
    return;
    a(2131434275, 0);
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
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[j]).findViewById(2131374957);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970404);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.c = paramBundle.getStringExtra("fromWhere");
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isSubaccount", false);
    }
    if (this.jdField_a_of_type_Boolean) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.b = getIntent().getStringExtra("key");
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
    return true;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new tau(this, paramString1, paramString2));
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
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2131433009, 0);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370071: 
      e();
      return;
    }
    f();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (this.jdField_a_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */