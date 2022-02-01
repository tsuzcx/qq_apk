package com.tencent.mobileqq.activity;

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
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.register.RegisterLimitHelperImpl;
import com.tencent.mobileqq.register.RegisterManager;
import com.tencent.mobileqq.register.RegisterWithNick;
import com.tencent.mobileqq.register.RegisterWithNickAndPwd;
import com.tencent.mobileqq.register.RegisterWithNickAndPwdInfo;
import com.tencent.mobileqq.register.RegisterWithNickAndPwdInfoBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, SMSBodyObserver
{
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131381177, 2131381178, 2131381179, 2131381180, 2131381181, 2131381182 };
  private int jdField_a_of_type_Int = 60;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private RegisterWithNick jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
  private RegisterWithNickAndPwd jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RegisterVerifyCodeActivity.1(this);
  private String jdField_a_of_type_JavaLangString = null;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new RegisterVerifyCodeActivity.3(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new RegisterVerifyCodeActivity.2(this);
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private int jdField_b_of_type_Int = 60;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString = null;
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString = null;
  private boolean jdField_e_of_type_Boolean;
  private String f = null;
  
  static
  {
    jdField_a_of_type_Boolean = true;
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
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716973) + "(" + this.jdField_a_of_type_Int + "s)");
    this.handler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void b()
  {
    setTitleText(2131717004);
    setBackListener();
    boolean bool = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    if (bool) {
      setBarProgress(100);
    }
    for (;;)
    {
      TextView localTextView = (TextView)findViewById(2131380792);
      String str1 = "+" + this.countryCode + " " + this.phoneNum;
      String str2 = getString(2131717000, new Object[] { str1 });
      SpannableString localSpannableString = new SpannableString(str2);
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
      int i = str2.indexOf(str1);
      int j = str2.indexOf(str1);
      localSpannableString.setSpan(localForegroundColorSpan, i, str1.length() + j, 33);
      localTextView.setText(localSpannableString);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364115));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716973) + "(" + this.jdField_a_of_type_Int + "s)");
      this.handler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      i = 0;
      while (i < 6)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(jdField_a_of_type_ArrayOfInt[i]).findViewById(2131380795));
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
        i += 1;
      }
      setBarProgress(66);
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364715));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370090));
    if ((this.mIsPhoneNumRegistered) && (!this.mHasPwd))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_Boolean = false;
    }
    do
    {
      return;
      if (bool)
      {
        this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        if (!this.jdField_b_of_type_Boolean) {
          jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380777));
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364721));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370155));
    } while (getResources().getDisplayMetrics().heightPixels < 480);
    new RegisterVerifyCodeActivity.RegDevLockCfgDownloadTask(this).execute(new Void[0]);
  }
  
  private void c()
  {
    try
    {
      this.f = null;
      ((AccountManager)this.mRuntime.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      createWaitingDialog(2131716984);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      notifyToast(2131692257, 0);
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
          ((AccountManager)this.mRuntime.getManager(0)).sendRegisterByCommitSmsVerifycode((String)localObject, this.jdField_a_of_type_MqqObserverAccountObserver);
          createWaitingDialog(2131716906);
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 0, 0, "", "", "", "");
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()))
          {
            ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 1, 0, "", "", "", "");
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
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 4, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())) {
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 2, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) || (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
          break;
        }
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 3, 0, "", "", "", "");
        return;
      }
      notifyToast(2131716917, 0);
      return;
    }
  }
  
  public void a()
  {
    jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
    PhoneNumLoginImpl.a().a(this.mRuntime, this.jdField_d_of_type_Boolean);
    boolean bool1 = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    boolean bool2 = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    for (int i = 1;; i = 0)
    {
      localObject1 = new StringBuilder("");
      int j = 0;
      while (j < 6)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].getText();
        if (localObject2 != null) {
          ((StringBuilder)localObject1).append(localObject2.toString());
        }
        j += 1;
      }
    }
    Object localObject2 = ((StringBuilder)localObject1).toString();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    if (bool1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd == null) {
        this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = new RegisterWithNickAndPwd(this);
      }
      getIntent().putExtra("key_register_smscode", (String)localObject1);
      getIntent().putExtra("key_register_autologin", true);
      getIntent().putExtra("key_register_phonenum_bindnewqq", bool2);
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.a(getIntent());
      return;
    }
    if (i != 0)
    {
      localObject1 = new RegisterWithNickAndPwdInfoBuilder().a(this.phoneNum).b(this.countryCode).c((String)localObject1).a(false).b(this.mHasPwd).d(this.inviteCode).a(5).e("").f("").c(true).d(false).e(this.jdField_e_of_type_Boolean).a();
      RegisterLimitHelperImpl.a().a(this, this.jdField_d_of_type_JavaLangString, (RegisterWithNickAndPwdInfo)localObject1);
      return;
    }
    RegisterByNicknameAndPwdActivity.gotoRegisterByNicknameAndPwdActivity(this, this.phoneNum, this.countryCode, (String)localObject1, this.mIsPhoneNumRegistered, this.mHasPwd, this.inviteCode, 5, "", "", true, this.jdField_e_of_type_Boolean);
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
        break label116;
        if (i != 0) {
          d();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562025);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    int i = getIntent().getIntExtra("key_register_left_time", 0);
    long l = getIntent().getLongExtra("key_register_exit_time", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onCreate countryCode=").append(this.countryCode).append(", phoneNum=").append(PhoneCodeUtils.a(this.phoneNum)).append(", leftTime=").append(i).append(", exitTime=").append(l).append(", inviteCode=");
      if (this.inviteCode == null)
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
      this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
      this.mHasPwd = getIntent().getBooleanExtra("key_register_has_pwd", true);
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_register_binded_qq");
      this.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_friend_verify", false);
      LoginUtils.a(this.mRuntime, getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      b();
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null, getIntent().getLongExtra("register_verify_code_start_time", 0L));
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
      ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006656", "0X8006656", 0, 0, "", "", "", "");
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 0, 0, "", "", "", "");
      if (this.mIsPhoneNumRegistered) {
        break label630;
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 1, 0, "", "", "", "");
      label516:
      if (this.mFrom != 7) {
        break label715;
      }
      ReportController.a(this.mRuntime, "new_reg_805", "msg_page", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
      label572:
      i = 0;
      if (!this.jdField_e_of_type_Boolean) {
        break label765;
      }
      i = 2;
    }
    for (;;)
    {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8009CEC", "0X8009CEC", i, 0, "", "", this.phoneNum, "");
      return true;
      paramBundle = this.inviteCode;
      break;
      label630:
      if (!this.mHasPwd)
      {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 2, 0, "", "", "", "");
        break label516;
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007361", "0X8007361", 3, 0, "", "", "", "");
      break label516;
      label715:
      ReportController.a(this.mRuntime, "new_reg_805", "msg_page", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
      break label572;
      label765:
      if (this.mFrom == 7) {
        i = 1;
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    RegisterManager.a().a(3);
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.b();
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
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.d();
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
    if (paramCompoundButton.getId() == 2131364721) {
      this.jdField_d_of_type_Boolean = paramBoolean;
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006657", "0X8006657", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_b_of_type_AndroidWidgetCheckBox != null) {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(true);
        }
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_b_of_type_AndroidWidgetCheckBox != null)
        {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
          this.jdField_d_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        }
      }
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
        d();
      }
      else if (i == 2131364115)
      {
        c();
        ReportController.a(this.mRuntime, "new_reg_805", "msg_page", "resend_clk", "", 1, "", "", "", "", "", "", "", "", "");
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8009CED", "0X8009CED", 0, 0, "", "", this.phoneNum, "");
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
    this.handler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd = null;
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
      if ((this.dialog != null) && (this.dialog.isShowing())) {
        this.dialog.dismiss();
      }
      this.dialog = null;
      if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd != null) {
        this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwd.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */