package com.tencent.mobileqq.activity;

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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;

public class LoginVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, View.OnKeyListener, SMSBodyObserver, ILoginSmsPageView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131381177, 2131381178, 2131381179, 2131381180, 2131381181, 2131381182 };
  private int jdField_a_of_type_Int = 60;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private SubAccountProxy jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountProxy;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LoginVerifyCodeActivity.1(this);
  private String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new LoginVerifyCodeActivity.2(this);
  private boolean jdField_a_of_type_Boolean = false;
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private Runnable jdField_b_of_type_JavaLangRunnable = new LoginVerifyCodeActivity.5(this);
  private String jdField_b_of_type_JavaLangString = null;
  private String c;
  private String d;
  private String e;
  
  private int a()
  {
    if (this.e == null) {}
    do
    {
      return 0;
      if ("fromLogin".equals(this.e)) {
        return 4;
      }
      if (LoginView.class.getName().equals(this.e)) {
        return 1;
      }
      if ("fromAddAccount".equals(this.e)) {
        return 3;
      }
    } while (!"fromSubLogin".equals(this.e));
    return 2;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716973) + "(" + this.jdField_a_of_type_Int + ")");
    this.handler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private boolean a(WUserSigInfo paramWUserSigInfo)
  {
    boolean bool = false;
    if (paramWUserSigInfo == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramWUserSigInfo = PhoneNumQuickLoginManager.a(paramWUserSigInfo, 2);
        if ((paramWUserSigInfo == null) || (paramWUserSigInfo.size() == 0)) {
          return true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramWUserSigInfo)
      {
        QLog.e("LoginVerifyCodeActivity", 1, "canSmsLoginDirectly: 0x543 tlv illegal, merge error : InvalidProtocolBufferMicroException ", paramWUserSigInfo);
      }
    }
    return false;
  }
  
  private void b()
  {
    int i = 0;
    setTitleText(2131717004);
    setBackListener();
    ((TextView)findViewById(2131380792)).setText(getString(2131716999, new Object[] { "+" + this.countryCode + " " + this.phoneNum }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364115));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716973) + "(" + this.jdField_a_of_type_Int + ")");
    this.handler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(jdField_a_of_type_ArrayOfInt[i]).findViewById(2131380795));
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
      i += 1;
    }
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
    createWaitingDialog(2131716984);
    if (PhoneNumLoginImpl.a().a(this.mRuntime, this.countryCode, this.phoneNum, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      closeDialog();
      notifyToast(2131718552, 1);
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      notifyToast(2131692257, 0);
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
      createWaitingDialog(2131716906);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
    } while (PhoneNumLoginImpl.a().a(this.mRuntime, this.countryCode, this.phoneNum, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    closeDialog();
    notifyToast(2131718552, 1);
    return;
    notifyToast(2131716917, 0);
  }
  
  public void a()
  {
    closeDialog();
  }
  
  public void a(String paramString, int paramInt)
  {
    notifyToast(paramString, paramInt);
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
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[j]).findViewById(2131370412);
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
          e();
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
    setContentView(2131561321);
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
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      notifyToast(2131692257, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if (i == 2131364061)
      {
        e();
      }
      else if (i == 2131364115)
      {
        d();
        ReportController.a(this.mRuntime, "dc00898", "", a(), "0X800B10A", "0X800B10A", a(), 0, "", "", "", "");
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
    closeDialog();
    if ((this.jdField_a_of_type_Boolean) && ((this.mRuntime instanceof AppInterface))) {
      ((AppInterface)this.mRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterSubAccountProxy.a(this, this));
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