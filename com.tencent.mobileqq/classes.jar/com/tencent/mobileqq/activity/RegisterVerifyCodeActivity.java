package com.tencent.mobileqq.activity;

import adqm;
import adqn;
import adqp;
import amna;
import amnc;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import awdr;
import axia;
import axic;
import azmj;
import bdee;
import bdes;
import bdxm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements amna, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131379488, 2131379489, 2131379490, 2131379491, 2131379492, 2131379493 };
  private int jdField_a_of_type_Int = 60;
  private amnc jdField_a_of_type_Amnc;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axia jdField_a_of_type_Axia;
  private axic jdField_a_of_type_Axic;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RegisterVerifyCodeActivity.1(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new adqn(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adqm(this);
  private boolean jdField_a_of_type_Boolean = true;
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  private String f;
  private String g;
  private String h;
  
  public RegisterVerifyCodeActivity()
  {
    this.jdField_c_of_type_Int = 60;
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "v1:" + paramString1 + " v2:" + paramString2);
    }
    String[] arrayOfString = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int j;
    int k;
    if (arrayOfString.length > paramString2.length)
    {
      j = arrayOfString.length;
      k = 0;
    }
    for (;;)
    {
      if (k >= j) {
        break label141;
      }
      int i;
      int m;
      for (;;)
      {
        try
        {
          i = Integer.parseInt(arrayOfString[k]);
        }
        catch (Exception paramString1)
        {
          i = 0;
        }
        try
        {
          m = Integer.parseInt(paramString2[k]);
          if (i <= m) {
            break label124;
          }
          return 1;
        }
        catch (Exception paramString1)
        {
          break label114;
        }
        j = paramString2.length;
        break;
        label114:
        paramString1.printStackTrace();
        m = 0;
      }
      label124:
      if (i < m) {
        return -1;
      }
      k += 1;
    }
    label141:
    return 0;
  }
  
  private void d()
  {
    c(2131717573);
    b();
    boolean bool = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    if (bool) {
      a(100);
    }
    for (;;)
    {
      TextView localTextView = (TextView)findViewById(2131379120);
      String str1 = "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
      String str2 = getString(2131717565, new Object[] { str1 });
      SpannableString localSpannableString = new SpannableString(str2);
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
      int i = str2.indexOf(str1);
      int j = str2.indexOf(str1);
      localSpannableString.setSpan(localForegroundColorSpan, i, str1.length() + j, 33);
      localTextView.setText(localSpannableString);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363687));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717532) + "(" + this.jdField_a_of_type_Int + "s)");
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      i = 0;
      while (i < 6)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(jdField_a_of_type_ArrayOfInt[i]).findViewById(2131379123));
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
        i += 1;
      }
      a(66);
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364246));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369160));
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
    do
    {
      return;
      if (bool)
      {
        this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        if (!this.jdField_a_of_type_Boolean) {
          awdr.a().jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379103));
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364251));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369225));
    } while (getResources().getDisplayMetrics().heightPixels < 480);
    new adqp(this).execute(new Void[0]);
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717532) + "(" + this.jdField_a_of_type_Int + "s)");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    try
    {
      this.h = null;
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      b(2131717544);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (!bdee.d(BaseApplication.getContext()))
    {
      a(2131692397, 0);
      return;
    }
    Object localObject = new StringBuilder("");
    int i = 0;
    while (i < 6)
    {
      Editable localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
      if (localEditable != null) {
        ((StringBuilder)localObject).append(localEditable.toString());
      }
      i += 1;
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
          b(2131717453);
          azmj.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 0, 0, "", "", "", "");
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()))
          {
            azmj.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 1, 0, "", "", "", "");
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
          azmj.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 4, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())) {
          azmj.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 2, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) || (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
          break;
        }
        azmj.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 3, 0, "", "", "", "");
        return;
      }
      a(2131717464, 0);
      return;
    }
  }
  
  public void a()
  {
    awdr.a().jdField_a_of_type_Boolean = this.jdField_e_of_type_Boolean;
    awdr.a().a(this.app, this.jdField_e_of_type_Boolean);
    boolean bool1 = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    boolean bool2 = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    Object localObject1 = new StringBuilder("");
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
    if (bool1)
    {
      if (this.jdField_a_of_type_Axic == null) {
        this.jdField_a_of_type_Axic = new axic(this);
      }
      getIntent().putExtra("key_register_smscode", (String)localObject1);
      getIntent().putExtra("key_register_autologin", true);
      getIntent().putExtra("key_register_phonenum_bindnewqq", bool2);
      this.jdField_a_of_type_Axic.a(getIntent());
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = new Intent(this, RegisterChooseLoginActivity.class);
      ((Intent)localObject2).putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("invite_code", this.jdField_c_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_register_smscode", (String)localObject1);
      ((Intent)localObject2).putExtra("key_register_binded_qq", this.jdField_d_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_register_binded_qq_nick", this.jdField_e_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_register_binded_qq_face_url", this.f);
      ((Intent)localObject2).putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
      ((Intent)localObject2).putExtra("key_register_chose_bind_phone", this.jdField_a_of_type_Boolean);
      ((Intent)localObject2).putExtra("key_register_from", 5);
      startActivity((Intent)localObject2);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1, false, this.jdField_c_of_type_Boolean, true, this.jdField_c_of_type_JavaLangString, 5, "", "", true);
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
        break label163;
      }
    }
    label135:
    label163:
    for (int k = localEditable.toString().length();; k = 0)
    {
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[j]).findViewById(2131369467);
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
    setContentView(2131561652);
    if (QLog.isDevelopLevel()) {
      bdxm.a(getClass().getSimpleName(), getIntent());
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    int i = getIntent().getIntExtra("key_register_left_time", 0);
    long l = getIntent().getLongExtra("key_register_exit_time", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onCreate countryCode=").append(this.jdField_b_of_type_JavaLangString).append(", phoneNum=").append(bdes.a(this.jdField_a_of_type_JavaLangString)).append(", leftTime=").append(i).append(", exitTime=").append(l).append(", inviteCode=");
      if (this.jdField_c_of_type_JavaLangString == null)
      {
        paramBundle = "";
        QLog.d("RegisterVerifyCodeActivity", 2, paramBundle);
      }
    }
    else
    {
      if ((i > 0) && (i < 60) && (l > 0L))
      {
        l = System.currentTimeMillis() - l;
        if ((l > 0L) && (l < i * 1000L)) {
          this.jdField_a_of_type_Int = (i - (int)(l / 1000L));
        }
        if (QLog.isColorLevel()) {
          QLog.d("RegisterVerifyCodeActivity", 2, "onCreate interval=" + l + ", second=" + this.jdField_a_of_type_Int);
        }
      }
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
      this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_register_binded_qq");
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      d();
      this.jdField_a_of_type_Amnc = new amnc(null, getIntent().getLongExtra("register_verify_code_start_time", 0L));
      this.jdField_a_of_type_Amnc.a(this, this);
      azmj.b(this.app, "CliOper", "", "", "0X8006656", "0X8006656", 0, 0, "", "", "", "");
      azmj.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Boolean) {
        break label567;
      }
      azmj.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 1, 0, "", "", "", "");
      label501:
      if (this.jdField_b_of_type_Int != 7) {
        break label652;
      }
      azmj.a(this.app, "new_reg_805", "msg_page", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      paramBundle = this.jdField_c_of_type_JavaLangString;
      break;
      label567:
      if (!this.jdField_c_of_type_Boolean)
      {
        azmj.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 2, 0, "", "", "", "");
        break label501;
      }
      azmj.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 3, 0, "", "", "", "");
      break label501;
      label652:
      azmj.a(this.app, "new_reg_805", "msg_page", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Axic != null) {
      this.jdField_a_of_type_Axic.b();
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
    if (this.jdField_a_of_type_Axic != null) {
      this.jdField_a_of_type_Axic.d();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "onBackEvent second=" + this.jdField_a_of_type_Int + ", curTime=" + System.currentTimeMillis());
      }
      getIntent().putExtra("key_register_left_time", this.jdField_a_of_type_Int);
      getIntent().putExtra("key_register_exit_time", System.currentTimeMillis());
      setResult(-1, getIntent());
    }
    finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131364251) {
      this.jdField_e_of_type_Boolean = paramBoolean;
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        azmj.b(this.app, "CliOper", "", "", "0X8006657", "0X8006657", 0, 0, "", "", "", "");
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(true);
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (!bdee.d(BaseApplication.getContext()))
    {
      a(2131692397, 0);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363636: 
      f();
      return;
    }
    e();
    azmj.a(this.app, "new_reg_805", "msg_page", "resend_clk", "", 1, "", "", "", "", "", "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (this.jdField_a_of_type_Amnc != null) {
      this.jdField_a_of_type_Amnc.a();
    }
    this.jdField_a_of_type_Amnc = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Axia != null) {
      this.jdField_a_of_type_Axia.a();
    }
    this.jdField_a_of_type_Axia = null;
    if (this.jdField_a_of_type_Axic != null) {
      this.jdField_a_of_type_Axic.a();
    }
    this.jdField_a_of_type_Axic = null;
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
      if (this.jdField_a_of_type_Axic != null) {
        this.jdField_a_of_type_Axic.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */