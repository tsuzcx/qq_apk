package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.register.QueryAccount;
import com.tencent.mobileqq.register.RegisterLimitHelperImpl;
import com.tencent.mobileqq.register.RegisterManager;
import com.tencent.mobileqq.register.RegisterWithNickAndPwd;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.io.UnsupportedEncodingException;

@RoutePage(desc="注册输入昵称密码页", path="/base/safe/registerByNickAndPwd")
public class RegisterByNicknameAndPwdActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final int FROM_TYPE_DEFAULT = 0;
  private static final int FROM_TYPE_FRIEND_VERIFY = 2;
  private static final int FROM_TYPE_VERIFY_CODE = 1;
  public static final int MIN_PWD_LENGTH = 8;
  private static final String REPORT_ACTION_SHOW = "0X800B532";
  private static final String REPORT_ACTION_SUCCESS = "0X800B533";
  private static final String TAG = "RegisterByNicknameAndPwdActivity";
  private Button btnLogin;
  private Button btnRegister;
  private ClearableEditText editNickname;
  private ClearableEditText editPassword;
  private boolean isPhoneNumBindNewQQ = false;
  private boolean isQuickRegister = false;
  private RegisterLHAssistant lhAssistant = null;
  private boolean mFromFriendVerify;
  private boolean mPassInvisible = true;
  private ImageView passwordEye;
  private RegisterWithNickAndPwd registerWithNickAndPwd = null;
  private ImageView rule1Img;
  private View rule1Root;
  private ImageView rule2Img;
  private View rule2Root;
  private View vipQQView;
  
  public static int getMixStringLength(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterByNicknameAndPwdActivity", 2, "getMixStringLength, str :" + paramString + ",length :" + i);
    }
    return i;
  }
  
  public static void gotoRegisterByNicknameAndPwdActivity(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4)
  {
    Intent localIntent = new Intent(paramContext, RegisterByNicknameAndPwdActivity.class);
    localIntent.putExtra("phonenum", paramString1);
    localIntent.putExtra("invite_code", paramString4);
    localIntent.putExtra("key", paramString2);
    localIntent.putExtra("key_register_smscode", paramString3);
    localIntent.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    localIntent.putExtra("key_register_has_pwd", paramBoolean2);
    localIntent.putExtra("key_register_from", paramInt);
    localIntent.putExtra("key_register_nick", paramString5);
    localIntent.putExtra("key_register_password", paramString6);
    localIntent.putExtra("key_register_phonenum_bindnewqq", paramBoolean3);
    localIntent.putExtra("key_register_from_friend_verify", paramBoolean4);
    if ((paramContext instanceof RegisterSendUpSms)) {
      localIntent.putExtra("key_register_from_send_sms", true);
    }
    paramContext.startActivity(localIntent);
  }
  
  private boolean hasSpace(String paramString)
  {
    return paramString.indexOf(" ") != -1;
  }
  
  private void initViews()
  {
    if (getIntent().getBooleanExtra("key_reg_from_phone_protect_h5", false)) {
      RegisterLimitHelperImpl.a().a(getIntent());
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.mHasPwd = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.isQuickRegister = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    this.isPhoneNumBindNewQQ = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    this.mFromFriendVerify = getIntent().getBooleanExtra("key_register_from_friend_verify", false);
    String str1 = getIntent().getStringExtra("key_register_nick");
    String str2 = getIntent().getStringExtra("key_register_password");
    setTitleText(HardCodeUtil.a(2131713293));
    setBackListener();
    setBarProgress(100);
    this.rule1Root = findViewById(2131373730);
    this.rule2Root = findViewById(2131373733);
    this.rule1Img = ((ImageView)findViewById(2131373729));
    this.rule2Img = ((ImageView)findViewById(2131373732));
    this.editPassword = ((ClearableEditText)findViewById(2131372769));
    this.editPassword.addTextChangedListener(this);
    this.editNickname = ((ClearableEditText)findViewById(2131372292));
    this.editNickname.addTextChangedListener(this);
    this.btnRegister = ((Button)findViewById(2131364110));
    this.btnRegister.setOnClickListener(this);
    this.btnLogin = ((Button)findViewById(2131370817));
    this.btnLogin.setOnClickListener(this);
    this.vipQQView = findViewById(2131381711);
    if (!TextUtils.isEmpty(str1)) {
      this.editNickname.setText(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      this.editPassword.setText(str2);
    }
    this.passwordEye = ((ImageView)findViewById(2131372770));
    this.passwordEye.setOnClickListener(this);
    if (this.mPassInvisible)
    {
      this.editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.passwordEye.setImageResource(2130847341);
      this.passwordEye.setContentDescription(HardCodeUtil.a(2131713313));
    }
    for (;;)
    {
      this.passwordEye.setVisibility(8);
      this.editPassword.setOnFocusChangeListener(new RegisterByNicknameAndPwdActivity.1(this));
      if (AccessibilityUtil.a(this))
      {
        this.editNickname.setHint(2131694494);
        this.editPassword.setHint(2131694722);
      }
      if (this.lhAssistant == null) {
        break;
      }
      this.lhAssistant.a();
      return;
      this.editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      this.passwordEye.setImageResource(2130847342);
      this.passwordEye.setContentDescription(HardCodeUtil.a(2131713296));
    }
    this.lhAssistant = new RegisterLHAssistant(this, findViewById(2131370058), 1);
  }
  
  private boolean isPwdValid(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.length() <= 0))
    {
      bool1 = false;
      return bool1;
    }
    int i3 = paramString.length();
    int i = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    label36:
    if (i < i3)
    {
      int n = paramString.charAt(i);
      int i1;
      int i2;
      if ((n >= 48) && (n <= 57))
      {
        n = m;
        i1 = k;
        i2 = j;
        if (j == 0)
        {
          i2 = 1;
          i1 = k;
          n = m;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i2 + i1 + n >= 2) {
          break;
        }
        i += 1;
        m = n;
        k = i1;
        j = i2;
        break label36;
        if (((n >= 97) && (n <= 122)) || ((n >= 65) && (n <= 90)))
        {
          n = m;
          i1 = k;
          i2 = j;
          if (k == 0)
          {
            i1 = 1;
            n = m;
            i2 = j;
          }
        }
        else
        {
          n = m;
          i1 = k;
          i2 = j;
          if (m == 0)
          {
            n = 1;
            i1 = k;
            i2 = j;
          }
        }
      }
    }
    return false;
  }
  
  private void setSoftInputMode()
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if ((this.editNickname != null) && (!this.editNickname.isEnabled()) && (this.editPassword != null) && (!this.editPassword.isEnabled())) {
      getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFB | 0x2);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterByNicknameAndPwdActivity", 2, "setSoftInputMode, isHideInput=" + bool + ",mode=" + localLayoutParams.softInputMode);
      }
      return;
      getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFD | 0x4);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    Object localObject1;
    do
    {
      return;
      localObject2 = this.editNickname.getText();
      localObject1 = this.editPassword.getText();
    } while ((paramEditable != localObject2) && (paramEditable != localObject1));
    String str = localObject2.toString();
    Object localObject2 = localObject1.toString();
    int i;
    if (this.rule1Img != null) {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() >= 8))
      {
        this.rule1Img.setBackgroundResource(2130840700);
        i = 1;
      }
    }
    for (;;)
    {
      label86:
      int j;
      if (this.rule2Img != null) {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (isPwdValid((String)localObject2)))
        {
          this.rule2Img.setBackgroundResource(2130840700);
          j = 1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          label122:
          if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
            this.btnRegister.setEnabled(true);
          }
          for (;;)
          {
            if (this.lhAssistant != null) {
              this.lhAssistant.b(this.btnRegister.isEnabled());
            }
            if (paramEditable != localObject1) {
              break;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label231;
            }
            this.editPassword.setClearButtonVisible(false);
            return;
            this.rule1Img.setBackgroundResource(2130840697);
            i = 0;
            break label86;
            this.rule2Img.setBackgroundResource(2130840697);
            j = 0;
            break label122;
            this.btnRegister.setEnabled(false);
          }
          label231:
          this.editPassword.setClearButtonVisible(true);
          localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 1, ((String)localObject2).length());
          try
          {
            if (((String)localObject1).length() >= ((String)localObject1).getBytes("utf-8").length) {
              break;
            }
            paramEditable.delete(((String)localObject2).length() - 1, ((String)localObject2).length());
            return;
          }
          catch (UnsupportedEncodingException paramEditable)
          {
            paramEditable.printStackTrace();
            return;
          }
        }
        j = 0;
      }
      i = 0;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void changeViewToLogin()
  {
    this.btnRegister.setVisibility(4);
    this.btnLogin.setVisibility(0);
    this.btnLogin.setEnabled(true);
    this.vipQQView.setVisibility(8);
    this.editNickname.setEnabled(false);
    this.editPassword.setEnabled(false);
    this.passwordEye.setEnabled(false);
  }
  
  public boolean checkNickAndPwd()
  {
    if ((this.editNickname == null) || (this.editPassword == null)) {
      return false;
    }
    String str1 = String.valueOf(this.editPassword.getText());
    String str2 = this.editNickname.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      notifyToast(2131694827, 1);
      return false;
    }
    if (hasSpace(str1))
    {
      notifyToast(2131716975, 1);
      return false;
    }
    if (!isPwdValid(str1))
    {
      notifyToast(2131716974, 1);
      return false;
    }
    if ((TextUtils.isEmpty(str2)) || (str2.trim().length() == 0))
    {
      notifyToast(2131716928, 1);
      return false;
    }
    try
    {
      if (getMixStringLength(str2) > 24L)
      {
        notifyToast(2131716929, 1);
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.lhAssistant != null) && (this.lhAssistant.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount != null)) {
      this.lhAssistant.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a("RegisterByNicknameAndPwdActivity -- doOnNewIntent", getIntent());
    }
    initViews();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.registerWithNickAndPwd != null) {
      this.registerWithNickAndPwd.c();
    }
    setSoftInputMode();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    RegisterManager.a().a(6);
    if (this.registerWithNickAndPwd != null) {
      this.registerWithNickAndPwd.b();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.registerWithNickAndPwd != null) {
      this.registerWithNickAndPwd.d();
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i = paramView.getId();
    if (i == 2131364110) {
      if ((this.lhAssistant != null) && (this.lhAssistant.jdField_a_of_type_Boolean)) {
        this.lhAssistant.a(this.isPhoneNumBindNewQQ);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006653", "0X8006653", 0, 0, "", "", "", "");
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        notifyToast(2131692257, 0);
      }
      else if (checkNickAndPwd())
      {
        String str1 = String.valueOf(this.editPassword.getText());
        String str2 = this.editNickname.getText().toString();
        if (this.registerWithNickAndPwd == null) {
          this.registerWithNickAndPwd = new RegisterWithNickAndPwd(this);
        }
        this.registerWithNickAndPwd.a(str2, str1, true, this.isPhoneNumBindNewQQ);
        ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "reg_clk", "", 1, "");
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B533", "0X800B533", 0, 0, "", "", this.phoneNum, "");
        continue;
        if (i == 2131372770)
        {
          str1 = this.editPassword.getText().toString();
          if (this.mPassInvisible)
          {
            if (this.isQuickRegister) {
              ReportController.a(this.mRuntime, "dc00898", "", "", "0X80072FA", "0X80072FA", 0, 0, "", "", "", "");
            }
            this.editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.passwordEye.setImageResource(2130847342);
            this.passwordEye.setContentDescription(HardCodeUtil.a(2131713303));
            label335:
            if (!TextUtils.isEmpty(str1)) {
              this.editPassword.setSelection(this.editPassword.length());
            }
            if (this.mPassInvisible) {
              break label408;
            }
          }
          for (;;)
          {
            this.mPassInvisible = bool;
            break;
            this.editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.passwordEye.setImageResource(2130847341);
            this.passwordEye.setContentDescription(HardCodeUtil.a(2131713310));
            break label335;
            label408:
            bool = false;
          }
        }
        if (i == 2131369487)
        {
          InputMethodUtil.a(this);
          new Handler().postDelayed(new RegisterByNicknameAndPwdActivity.2(this), 200L);
        }
        else if ((i == 2131370817) && (this.registerWithNickAndPwd != null))
        {
          this.registerWithNickAndPwd.f();
        }
      }
    }
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
    setContentView(2131562021);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    initViews();
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006652", "0X8006652", 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 0, 0, "", "", "", "");
    if (this.isQuickRegister) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 1, 0, "", "", "", "");
    }
    label298:
    int i;
    if (!this.mIsPhoneNumRegistered)
    {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 2, 0, "", "", "", "");
      if (getIntent().getBooleanExtra("key_register_from_send_sms", false)) {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 5, 0, "", "", "", "");
      }
      if (this.mFrom != 4) {
        break label430;
      }
      ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "3", 1, "", "1", "", "", "", "", "", "", "");
      i = 0;
      if (!this.mFromFriendVerify) {
        break label654;
      }
      i = 2;
    }
    for (;;)
    {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B532", "0X800B532", i, 0, "", "", this.phoneNum, "");
      return;
      if (!this.mHasPwd)
      {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 3, 0, "", "", "", "");
        break;
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 4, 0, "", "", "", "");
      break;
      label430:
      if (this.mFrom == 5)
      {
        ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "1", 1, "", "2", "", "", "", "", "", "", "");
        break label298;
      }
      if (this.mFrom == 6)
      {
        ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "2", 1, "", "3", "", "", "", "", "", "", "");
        break label298;
      }
      if (this.isQuickRegister)
      {
        ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "4", 1, "", "3", "", "", "", "", "", "", "");
        break label298;
      }
      ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "5", 1, "", "4", "", "", "", "", "", "", "");
      break label298;
      label654:
      if (this.mFrom == 5) {
        i = 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    closeDialog();
    if (this.lhAssistant != null) {
      this.lhAssistant.b();
    }
    if (this.registerWithNickAndPwd != null) {
      this.registerWithNickAndPwd.a();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity
 * JD-Core Version:    0.7.0.1
 */