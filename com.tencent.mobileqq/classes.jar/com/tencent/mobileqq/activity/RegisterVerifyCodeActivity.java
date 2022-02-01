package com.tencent.mobileqq.activity;

import Override;
import afko;
import afkp;
import afkr;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import apdw;
import apdy;
import azoz;
import bbbf;
import bbbh;
import bbbj;
import bbbl;
import bbbm;
import bdll;
import bhnv;
import bhoe;
import bijm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, apdw
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131380667, 2131380668, 2131380669, 2131380670, 2131380671, 2131380672 };
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apdy jdField_a_of_type_Apdy;
  private bbbh jdField_a_of_type_Bbbh;
  private bbbj jdField_a_of_type_Bbbj;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RegisterVerifyCodeActivity.1(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new afkp(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new afko(this);
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private int jdField_b_of_type_Int = 60;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = 60;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  private String f;
  private String g;
  private String h;
  private String i;
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "v1:" + paramString1 + " v2:" + paramString2);
    }
    String[] arrayOfString = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int k;
    int m;
    if (arrayOfString.length > paramString2.length)
    {
      k = arrayOfString.length;
      m = 0;
    }
    for (;;)
    {
      if (m >= k) {
        break label141;
      }
      int j;
      int n;
      for (;;)
      {
        try
        {
          j = Integer.parseInt(arrayOfString[m]);
        }
        catch (Exception paramString1)
        {
          j = 0;
        }
        try
        {
          n = Integer.parseInt(paramString2[m]);
          if (j <= n) {
            break label124;
          }
          return 1;
        }
        catch (Exception paramString1)
        {
          break label114;
        }
        k = paramString2.length;
        break;
        label114:
        paramString1.printStackTrace();
        n = 0;
      }
      label124:
      if (j < n) {
        return -1;
      }
      m += 1;
    }
    label141:
    return 0;
  }
  
  private void d()
  {
    c(2131715919);
    b();
    boolean bool = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    if (bool) {
      a(100);
    }
    for (;;)
    {
      TextView localTextView = (TextView)findViewById(2131380287);
      String str1 = "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
      String str2 = getString(2131715915, new Object[] { str1 });
      SpannableString localSpannableString = new SpannableString(str2);
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
      int j = str2.indexOf(str1);
      int k = str2.indexOf(str1);
      localSpannableString.setSpan(localForegroundColorSpan, j, str1.length() + k, 33);
      localTextView.setText(localSpannableString);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363916));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131715891) + "(" + this.jdField_b_of_type_Int + "s)");
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      j = 0;
      while (j < 6)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j] = ((EditText)findViewById(jdField_a_of_type_ArrayOfInt[j]).findViewById(2131380291));
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].addTextChangedListener(this);
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].setOnKeyListener(this);
        j += 1;
      }
      a(66);
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364500));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369661));
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Boolean = false;
    }
    do
    {
      return;
      if (bool)
      {
        this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        if (!this.jdField_c_of_type_Boolean) {
          azoz.a().jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380268));
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364506));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369727));
    } while (getResources().getDisplayMetrics().heightPixels < 480);
    new afkr(this).execute(new Void[0]);
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131715891) + "(" + this.jdField_b_of_type_Int + "s)");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    try
    {
      this.i = null;
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      b(2131715899);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      a(2131691989, 0);
      return;
    }
    Object localObject = new StringBuilder("");
    int j = 0;
    while (j < 6)
    {
      Editable localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].getText();
      if (localEditable != null) {
        ((StringBuilder)localObject).append(localEditable.toString());
      }
      j += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (localObject != null) {
      localObject = ((String)localObject).trim();
    }
    for (;;)
    {
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        try
        {
          ((AccountManager)this.app.getManager(0)).sendRegisterByCommitSmsVerifycode((String)localObject, this.jdField_a_of_type_MqqObserverAccountObserver);
          b(2131715831);
          bdll.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 0, 0, "", "", "", "");
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()))
          {
            bdll.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 1, 0, "", "", "", "");
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) && ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)))
        {
          bdll.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 4, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())) {
          bdll.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 2, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) || (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
          break;
        }
        bdll.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 3, 0, "", "", "", "");
        return;
      }
      a(2131715842, 0);
      return;
    }
  }
  
  public void a()
  {
    azoz.a().jdField_a_of_type_Boolean = this.jdField_e_of_type_Boolean;
    azoz.a().a(this.app, this.jdField_e_of_type_Boolean);
    boolean bool1 = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    boolean bool2 = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    if (!TextUtils.isEmpty(this.g)) {}
    for (int j = 1;; j = 0)
    {
      localObject1 = new StringBuilder("");
      int k = 0;
      while (k < 6)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[k].getText();
        if (localObject2 != null) {
          ((StringBuilder)localObject1).append(localObject2.toString());
        }
        k += 1;
      }
    }
    Object localObject2 = ((StringBuilder)localObject1).toString();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    if (bool1)
    {
      if (this.jdField_a_of_type_Bbbj == null) {
        this.jdField_a_of_type_Bbbj = new bbbj(this);
      }
      getIntent().putExtra("key_register_smscode", (String)localObject1);
      getIntent().putExtra("key_register_autologin", true);
      getIntent().putExtra("key_register_phonenum_bindnewqq", bool2);
      this.jdField_a_of_type_Bbbj.a(getIntent());
      return;
    }
    if (j != 0)
    {
      localObject1 = new bbbm().a(this.jdField_a_of_type_JavaLangString).b(this.jdField_b_of_type_JavaLangString).c((String)localObject1).a(false).b(this.jdField_b_of_type_Boolean).d(this.jdField_c_of_type_JavaLangString).a(5).e("").f("").c(true).d(false).a();
      bbbf.a().a(this, this.g, (bbbl)localObject1);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_JavaLangString, 5, "", "", true);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = 1;
    int k = 0;
    Editable localEditable;
    if (k < 6)
    {
      localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[k].getText();
      if (localEditable == null) {
        break label163;
      }
    }
    label135:
    label163:
    for (int m = localEditable.toString().length();; m = 0)
    {
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[k]).findViewById(2131369977);
      if ((localEditable != null) && (localEditable == paramEditable))
      {
        if (m <= 0) {
          break label135;
        }
        localView.setBackgroundColor(-9474193);
        if (k < 5)
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(k + 1)].requestFocus();
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(k + 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(k + 1)].length());
        }
      }
      label116:
      if ((localEditable == null) || (m <= 0)) {
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        if (m != 0) {
          break label116;
        }
        localView.setBackgroundColor(-2170912);
        break label116;
        if (j != 0) {
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561947);
    if (QLog.isDevelopLevel()) {
      bijm.a(getClass().getSimpleName(), getIntent());
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    int j = getIntent().getIntExtra("key_register_left_time", 0);
    long l = getIntent().getLongExtra("key_register_exit_time", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onCreate countryCode=").append(this.jdField_b_of_type_JavaLangString).append(", phoneNum=").append(bhoe.a(this.jdField_a_of_type_JavaLangString)).append(", leftTime=").append(j).append(", exitTime=").append(l).append(", inviteCode=");
      if (this.jdField_c_of_type_JavaLangString == null)
      {
        paramBundle = "";
        QLog.d("RegisterVerifyCodeActivity", 2, paramBundle);
      }
    }
    else
    {
      if ((j > 0) && (j < 60) && (l > 0L))
      {
        l = System.currentTimeMillis() - l;
        if ((l > 0L) && (l < j * 1000L)) {
          this.jdField_b_of_type_Int = (j - (int)(l / 1000L));
        }
        if (QLog.isColorLevel()) {
          QLog.d("RegisterVerifyCodeActivity", 2, "onCreate interval=" + l + ", second=" + this.jdField_b_of_type_Int);
        }
      }
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_register_binded_qq");
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      d();
      this.jdField_a_of_type_Apdy = new apdy(null, getIntent().getLongExtra("register_verify_code_start_time", 0L));
      this.jdField_a_of_type_Apdy.a(this, this);
      bdll.b(this.app, "CliOper", "", "", "0X8006656", "0X8006656", 0, 0, "", "", "", "");
      bdll.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        break label567;
      }
      bdll.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 1, 0, "", "", "", "");
      label501:
      if (this.jdField_a_of_type_Int != 7) {
        break label652;
      }
      bdll.a(this.app, "new_reg_805", "msg_page", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      paramBundle = this.jdField_c_of_type_JavaLangString;
      break;
      label567:
      if (!this.jdField_b_of_type_Boolean)
      {
        bdll.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 2, 0, "", "", "", "");
        break label501;
      }
      bdll.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 3, 0, "", "", "", "");
      break label501;
      label652:
      bdll.a(this.app, "new_reg_805", "msg_page", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Bbbj != null) {
      this.jdField_a_of_type_Bbbj.b();
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new RegisterVerifyCodeActivity.4(this, paramString1, paramString2));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Bbbj != null) {
      this.jdField_a_of_type_Bbbj.d();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_Int > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "onBackEvent second=" + this.jdField_b_of_type_Int + ", curTime=" + System.currentTimeMillis());
      }
      getIntent().putExtra("key_register_left_time", this.jdField_b_of_type_Int);
      getIntent().putExtra("key_register_exit_time", System.currentTimeMillis());
      setResult(-1, getIntent());
    }
    finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131364506) {
      this.jdField_e_of_type_Boolean = paramBoolean;
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        bdll.b(this.app, "CliOper", "", "", "0X8006657", "0X8006657", 0, 0, "", "", "", "");
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_b_of_type_AndroidWidgetCheckBox != null) {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(true);
        }
      }
      else
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_b_of_type_AndroidWidgetCheckBox != null)
        {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
          this.jdField_e_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (!bhnv.d(BaseApplication.getContext())) {
      a(2131691989, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363866: 
        f();
        break;
      case 2131363916: 
        e();
        bdll.a(this.app, "new_reg_805", "msg_page", "resend_clk", "", 1, "", "", "", "", "", "", "", "", "");
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
    if (this.jdField_a_of_type_Apdy != null) {
      this.jdField_a_of_type_Apdy.a();
    }
    this.jdField_a_of_type_Apdy = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Bbbh != null) {
      this.jdField_a_of_type_Bbbh.a();
    }
    this.jdField_a_of_type_Bbbh = null;
    if (this.jdField_a_of_type_Bbbj != null) {
      this.jdField_a_of_type_Bbbj.a();
    }
    this.jdField_a_of_type_Bbbj = null;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && ((paramView instanceof EditText)))
    {
      paramView = ((EditText)paramView).getText();
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < 6)
      {
        paramKeyEvent = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[paramInt].getText();
        if ((paramKeyEvent == null) || (paramKeyEvent != paramView)) {
          break label159;
        }
        if ((paramInt <= 0) || (paramInt >= 6) || (paramKeyEvent.toString().length() > 0)) {
          break label125;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].setText("");
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].requestFocus();
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].length());
      }
      label125:
      while ((paramInt < 0) || (paramInt >= 6) || (paramKeyEvent.toString().length() <= 0)) {
        return false;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[paramInt].setText("");
      return false;
      label159:
      paramInt += 1;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
      if (this.jdField_a_of_type_Bbbj != null) {
        this.jdField_a_of_type_Bbbj.c();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */