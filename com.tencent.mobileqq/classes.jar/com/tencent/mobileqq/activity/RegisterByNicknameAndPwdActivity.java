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
    while (j < paramString.length())
    {
      int k = j + 1;
      if (paramString.substring(j, k).matches("[Α-￥]")) {
        i += 2;
      } else {
        i += 1;
      }
      j = k;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMixStringLength, str :");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",length :");
      localStringBuilder.append(i);
      QLog.d("RegisterByNicknameAndPwdActivity", 2, localStringBuilder.toString());
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
    Object localObject = getIntent().getStringExtra("key_register_nick");
    String str = getIntent().getStringExtra("key_register_password");
    setTitleText(HardCodeUtil.a(2131713261));
    setBackListener();
    setBarProgress(100);
    this.rule1Root = findViewById(2131373302);
    this.rule2Root = findViewById(2131373305);
    this.rule1Img = ((ImageView)findViewById(2131373301));
    this.rule2Img = ((ImageView)findViewById(2131373304));
    this.editPassword = ((ClearableEditText)findViewById(2131372346));
    this.editPassword.addTextChangedListener(this);
    this.editNickname = ((ClearableEditText)findViewById(2131371880));
    this.editNickname.addTextChangedListener(this);
    this.btnRegister = ((Button)findViewById(2131364032));
    this.btnRegister.setOnClickListener(this);
    this.btnLogin = ((Button)findViewById(2131370448));
    this.btnLogin.setOnClickListener(this);
    this.vipQQView = findViewById(2131380944);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.editNickname.setText((CharSequence)localObject);
    }
    if (!TextUtils.isEmpty(str)) {
      this.editPassword.setText(str);
    }
    this.passwordEye = ((ImageView)findViewById(2131372347));
    this.passwordEye.setOnClickListener(this);
    if (this.mPassInvisible)
    {
      this.editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.passwordEye.setImageResource(2130847210);
      this.passwordEye.setContentDescription(HardCodeUtil.a(2131713281));
    }
    else
    {
      this.editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      this.passwordEye.setImageResource(2130847211);
      this.passwordEye.setContentDescription(HardCodeUtil.a(2131713264));
    }
    this.passwordEye.setVisibility(8);
    this.editPassword.setOnFocusChangeListener(new RegisterByNicknameAndPwdActivity.1(this));
    if (AccessibilityUtil.a(this))
    {
      this.editNickname.setHint(2131694459);
      this.editPassword.setHint(2131694700);
    }
    localObject = this.lhAssistant;
    if (localObject != null)
    {
      ((RegisterLHAssistant)localObject).a();
      return;
    }
    this.lhAssistant = new RegisterLHAssistant(this, findViewById(2131369737), 1);
  }
  
  private boolean isPwdValid(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      int i3 = paramString.length();
      int k = 0;
      int m = 0;
      int j = 0;
      int i2;
      for (int i = 0; k < i3; i = i2)
      {
        int n = paramString.charAt(k);
        int i1;
        if ((n >= 48) && (n <= 57))
        {
          n = m;
          i1 = j;
          i2 = i;
          if (m == 0)
          {
            n = 1;
            i1 = j;
            i2 = i;
          }
        }
        else if (((n >= 97) && (n <= 122)) || ((n >= 65) && (n <= 90)))
        {
          n = m;
          i1 = j;
          i2 = i;
          if (i == 0)
          {
            i2 = 1;
            n = m;
            i1 = j;
          }
        }
        else
        {
          n = m;
          i1 = j;
          i2 = i;
          if (j == 0)
          {
            i1 = 1;
            i2 = i;
            n = m;
          }
        }
        if (n + i2 + i1 >= 2) {
          return true;
        }
        k += 1;
        m = n;
        j = i1;
      }
    }
    return false;
  }
  
  private void setSoftInputMode()
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    Object localObject = this.editNickname;
    if ((localObject != null) && (!((ClearableEditText)localObject).isEnabled()))
    {
      localObject = this.editPassword;
      if ((localObject != null) && (!((ClearableEditText)localObject).isEnabled()))
      {
        getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFB | 0x2);
        bool = true;
        break label79;
      }
    }
    getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFD | 0x4);
    boolean bool = false;
    label79:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSoftInputMode, isHideInput=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",mode=");
      ((StringBuilder)localObject).append(localLayoutParams.softInputMode);
      QLog.i("RegisterByNicknameAndPwdActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    Object localObject2 = this.editNickname.getText();
    Object localObject1 = this.editPassword.getText();
    if ((paramEditable != localObject2) && (paramEditable != localObject1)) {
      return;
    }
    Object localObject3 = localObject2.toString();
    localObject2 = localObject1.toString();
    int i;
    if (this.rule1Img != null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() >= 8))
      {
        this.rule1Img.setBackgroundResource(2130840575);
        i = 1;
      }
      else
      {
        this.rule1Img.setBackgroundResource(2130840572);
      }
    }
    else {
      i = 0;
    }
    int j;
    if (this.rule2Img != null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (isPwdValid((String)localObject2)))
      {
        this.rule2Img.setBackgroundResource(2130840575);
        j = 1;
      }
      else
      {
        this.rule2Img.setBackgroundResource(2130840572);
      }
    }
    else {
      j = 0;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i != 0) && (j != 0)) {
      this.btnRegister.setEnabled(true);
    } else {
      this.btnRegister.setEnabled(false);
    }
    localObject3 = this.lhAssistant;
    if (localObject3 != null) {
      ((RegisterLHAssistant)localObject3).b(this.btnRegister.isEnabled());
    }
    if (paramEditable == localObject1)
    {
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.editPassword.setClearButtonVisible(false);
        return;
      }
      this.editPassword.setClearButtonVisible(true);
      localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 1, ((String)localObject2).length());
      try
      {
        if (((String)localObject1).length() < ((String)localObject1).getBytes("utf-8").length)
        {
          paramEditable.delete(((String)localObject2).length() - 1, ((String)localObject2).length());
          return;
        }
      }
      catch (UnsupportedEncodingException paramEditable)
      {
        paramEditable.printStackTrace();
      }
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
    if (this.editNickname != null)
    {
      Object localObject = this.editPassword;
      if (localObject == null) {
        return false;
      }
      localObject = String.valueOf(((ClearableEditText)localObject).getText());
      String str = this.editNickname.getText().toString();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        notifyToast(2131694813, 1);
        return false;
      }
      if (hasSpace((String)localObject))
      {
        notifyToast(2131716628, 1);
        return false;
      }
      if (!isPwdValid((String)localObject))
      {
        notifyToast(2131716627, 1);
        return false;
      }
      if ((!TextUtils.isEmpty(str)) && (str.trim().length() != 0))
      {
        try
        {
          if (getMixStringLength(str) > 24L)
          {
            notifyToast(2131716582, 1);
            return false;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        return true;
      }
      notifyToast(2131716581, 1);
    }
    return false;
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
    RegisterLHAssistant localRegisterLHAssistant = this.lhAssistant;
    if ((localRegisterLHAssistant != null) && (localRegisterLHAssistant.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount != null)) {
      this.lhAssistant.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a("RegisterByNicknameAndPwdActivity -- doOnNewIntent", getIntent());
    }
    initViews();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.registerWithNickAndPwd;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.c();
    }
    setSoftInputMode();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RegisterManager.a().a(6);
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.registerWithNickAndPwd;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.b();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    RegisterWithNickAndPwd localRegisterWithNickAndPwd = this.registerWithNickAndPwd;
    if (localRegisterWithNickAndPwd != null) {
      localRegisterWithNickAndPwd.d();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131364032)
    {
      localObject = this.lhAssistant;
      if ((localObject != null) && (((RegisterLHAssistant)localObject).jdField_a_of_type_Boolean))
      {
        this.lhAssistant.a(this.isPhoneNumBindNewQQ);
      }
      else
      {
        ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006653", "0X8006653", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          notifyToast(2131692183, 0);
        }
        else if (checkNickAndPwd())
        {
          localObject = String.valueOf(this.editPassword.getText());
          String str = this.editNickname.getText().toString();
          if (this.registerWithNickAndPwd == null) {
            this.registerWithNickAndPwd = new RegisterWithNickAndPwd(this);
          }
          this.registerWithNickAndPwd.a(str, (String)localObject, true, this.isPhoneNumBindNewQQ);
          ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "reg_clk", "", 1, "");
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B533", "0X800B533", 0, 0, "", "", this.phoneNum, "");
        }
      }
    }
    else if (i == 2131372347)
    {
      localObject = this.editPassword.getText().toString();
      if (this.mPassInvisible)
      {
        if (this.isQuickRegister) {
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X80072FA", "0X80072FA", 0, 0, "", "", "", "");
        }
        this.editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.passwordEye.setImageResource(2130847211);
        this.passwordEye.setContentDescription(HardCodeUtil.a(2131713271));
      }
      else
      {
        this.editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.passwordEye.setImageResource(2130847210);
        this.passwordEye.setContentDescription(HardCodeUtil.a(2131713278));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = this.editPassword;
        ((ClearableEditText)localObject).setSelection(((ClearableEditText)localObject).length());
      }
      this.mPassInvisible ^= true;
    }
    else if (i == 2131369202)
    {
      InputMethodUtil.a(this);
      new Handler().postDelayed(new RegisterByNicknameAndPwdActivity.2(this), 200L);
    }
    else if (i == 2131370448)
    {
      localObject = this.registerWithNickAndPwd;
      if (localObject != null) {
        ((RegisterWithNickAndPwd)localObject).f();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    setContentView(2131561854);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    initViews();
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006652", "0X8006652", 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 0, 0, "", "", "", "");
    if (this.isQuickRegister) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 1, 0, "", "", "", "");
    }
    if (!this.mIsPhoneNumRegistered) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 2, 0, "", "", "", "");
    } else if (!this.mHasPwd) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 3, 0, "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 4, 0, "", "", "", "");
    }
    if (getIntent().getBooleanExtra("key_register_from_send_sms", false)) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800735E", "0X800735E", 5, 0, "", "", "", "");
    }
    if (this.mFrom == 4) {
      ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "3", 1, "", "1", "", "", "", "", "", "", "");
    } else if (this.mFrom == 5) {
      ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "1", 1, "", "2", "", "", "", "", "", "", "");
    } else if (this.mFrom == 6) {
      ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "2", 1, "", "3", "", "", "", "", "", "", "");
    } else if (this.isQuickRegister) {
      ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "4", 1, "", "3", "", "", "", "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "new_reg_805", "setting_page", "page_exp", "5", 1, "", "4", "", "", "", "", "", "", "");
    }
    int i;
    if (this.mFromFriendVerify) {
      i = 2;
    } else if (this.mFrom == 5) {
      i = 1;
    } else {
      i = 0;
    }
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B532", "0X800B532", i, 0, "", "", this.phoneNum, "");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    closeDialog();
    Object localObject = this.lhAssistant;
    if (localObject != null) {
      ((RegisterLHAssistant)localObject).b();
    }
    localObject = this.registerWithNickAndPwd;
    if (localObject != null) {
      ((RegisterWithNickAndPwd)localObject).a();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity
 * JD-Core Version:    0.7.0.1
 */