package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager.AccountInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.WUserSigInfo;

@RoutePage(desc="登录短信页", path="/base/safe/loginPhoneNumActivity")
public class LoginPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final int REQUEST_CODE_MASK_UIN_LOGIN = 2020;
  public static final int REQUEST_LOCATION = 1;
  private static final String TAG = "LoginPhoneNumActivity";
  private static final String WATERPROOF_URL = "https://ti.qq.com/safe/tools/captcha/sms-verify-login";
  private ImageView arrowCountry;
  private Button btnNextStep;
  private String countryName = HardCodeUtil.a(2131914014);
  private ConfigClearableEditText editText;
  private String fromWhere;
  protected String mEntrance;
  private boolean mFromAccountChange = false;
  MqqHandler mHandler = new LoginPhoneNumActivity.1(this);
  private boolean mIsOpeningBrowser;
  private boolean mIsSubaccount = false;
  private boolean mIsValidPhoneNum = false;
  private LoginUserPrivateHelper mLoginUserPrivateHelper;
  private byte[] mReqData;
  private String mTitle;
  private WUserSigInfo mUserSigInfo = null;
  WtloginObserver mWtloginObserver = new LoginPhoneNumActivity.7(this);
  private TextView txtCountryCode;
  private LoginPhoneNumActivity.UnbindAccountReceiver unbindAccountReceiver = null;
  
  private String getFUIN()
  {
    if (this.mRuntime == null) {
      return "";
    }
    if (this.mRuntime.isLogin()) {
      return "";
    }
    return this.editText.getText().toString();
  }
  
  private void handleLoginSuccess(Intent paramIntent)
  {
    if (((this.mFromAccountChange) || ("fromLogin".equals(this.mEntrance))) && (paramIntent != null)) {
      paramIntent.putExtra("fromLoginPhoneNum", true);
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  private void initViews()
  {
    if (TextUtils.isEmpty(this.mTitle)) {
      localObject = getResources().getString(2131891425);
    } else {
      localObject = this.mTitle;
    }
    setTitleText((String)localObject);
    setBackListener();
    setProgressBarVisible(false);
    this.arrowCountry = ((ImageView)findViewById(2131428781));
    this.arrowCountry.setOnClickListener(this);
    this.txtCountryCode = ((TextView)findViewById(2131448926));
    this.txtCountryCode.setOnClickListener(this);
    this.countryCode = PhoneCodeUtils.b(this);
    Object localObject = this.txtCountryCode;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(this.countryCode);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.editText = ((ConfigClearableEditText)findViewById(2131439507));
    this.editText.addTextChangedListener(this);
    if (Build.VERSION.SDK_INT >= 11) {
      this.editText.setCustomSelectionActionModeCallback(new LoginPhoneNumActivity.3(this));
    } else {
      this.editText.setOnCreateContextMenuListener(new LoginPhoneNumActivity.4(this));
    }
    this.btnNextStep = ((Button)findViewById(2131429943));
    this.btnNextStep.setOnClickListener(this);
  }
  
  private void registerUnbindAccountReceiver()
  {
    if (this.unbindAccountReceiver == null)
    {
      this.unbindAccountReceiver = new LoginPhoneNumActivity.UnbindAccountReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.unbindAccount");
      registerReceiver(this.unbindAccountReceiver, localIntentFilter);
    }
  }
  
  private void startQueryAccount()
  {
    if (this.mReqData == null)
    {
      QLog.d("LoginPhoneNumActivity", 1, "startQueryAccount, but mReqData is null");
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      notifyToast(2131889169, 0);
      return;
    }
    createWaitingDialog(2131897873);
    if (PhoneNumLoginImpl.a().a(this.mRuntime, this.phoneNum, this.countryCode, this.mReqData, this.mWtloginObserver) != 0)
    {
      closeDialog();
      notifyToast(getString(2131914072), 1);
    }
  }
  
  private void unRegisterUnbindAccountReceiver()
  {
    LoginPhoneNumActivity.UnbindAccountReceiver localUnbindAccountReceiver = this.unbindAccountReceiver;
    if (localUnbindAccountReceiver != null)
    {
      unregisterReceiver(localUnbindAccountReceiver);
      this.unbindAccountReceiver = null;
    }
  }
  
  private void updateNextStepButton()
  {
    if (this.btnNextStep == null) {
      return;
    }
    Object localObject = this.editText;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ConfigClearableEditText)localObject).getText();
    }
    this.mIsValidPhoneNum = checkPhoneNumLength((Editable)localObject);
    if (this.mIsValidPhoneNum)
    {
      this.btnNextStep.setBackgroundResource(2130842283);
      this.btnNextStep.setEnabled(true);
      return;
    }
    this.btnNextStep.setBackgroundResource(2130842284);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.phoneNum = this.editText.getText().toString();
    updateNextStepButton();
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
    setContentView(2131624753);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.mIsSubaccount = paramBundle.getBooleanExtra("isSubaccount", false);
      this.mEntrance = paramBundle.getStringExtra("entrance");
      this.mTitle = paramBundle.getStringExtra("title");
      this.mFromAccountChange = paramBundle.getBooleanExtra("login_from_account_change", false);
    }
    if (this.mRuntime != null) {
      LoginUtils.a(this.mRuntime, getClass(), this.mHandler);
    }
    initViews();
    this.mLoginUserPrivateHelper = new LoginUserPrivateHelper();
    paramBundle = new LoginPhoneNumActivity.2(this);
    this.mLoginUserPrivateHelper.a(paramBundle);
    registerUnbindAccountReceiver();
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B104", "0X800B104", getEntranceType(), 0, "", "", "", "");
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mIsOpeningBrowser)
    {
      this.btnNextStep.setEnabled(true);
      this.mIsOpeningBrowser = false;
    }
  }
  
  public void doReceive(Intent paramIntent, WUserSigInfo paramWUserSigInfo)
  {
    if (paramIntent != null)
    {
      if (paramWUserSigInfo == null) {
        return;
      }
      paramIntent = paramIntent.getStringExtra("key_login_unbind_phone_account_data");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UnbindAccountReceiver accountDataStr:");
        localStringBuilder.append(paramIntent);
        QLog.d("LoginPhoneNumActivity", 2, localStringBuilder.toString());
      }
      handleMaskUinLogin(paramWUserSigInfo, true, PhoneNumQuickLoginManager.c(paramIntent));
    }
  }
  
  public void finish()
  {
    super.finish();
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  protected int getEntranceType()
  {
    String str = this.mEntrance;
    if (str == null) {
      return 0;
    }
    if ("fromLogin".equals(str)) {
      return 4;
    }
    if (LoginView.class.getName().equals(this.mEntrance)) {
      return 1;
    }
    if ("fromAddAccount".equals(this.mEntrance)) {
      return 3;
    }
    if ("fromSubLogin".equals(this.mEntrance)) {
      return 2;
    }
    return 0;
  }
  
  public void go2next()
  {
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.phoneNum);
    localIntent.putExtra("key", this.countryCode);
    localIntent.putExtra("isSubaccount", this.mIsSubaccount);
    localIntent.putExtra("fromWhere", this.fromWhere);
    localIntent.putExtra("login_from_account_change", this.mFromAccountChange);
    localIntent.putExtra("entrance", this.mEntrance);
    localIntent.putExtra("verify_code_start_time", System.currentTimeMillis());
    startActivityForResult(localIntent, 2003);
  }
  
  public void handleMaskUinLogin(WUserSigInfo paramWUserSigInfo, boolean paramBoolean, List<PhoneNumQuickLoginManager.AccountInfo> paramList)
  {
    LoginPhoneNumActivity.5 local5 = new LoginPhoneNumActivity.5(this);
    LoginPhoneNumActivity.6 local6 = new LoginPhoneNumActivity.6(this);
    if (!paramBoolean) {
      paramBoolean = PhoneNumQuickLoginManager.a(paramWUserSigInfo, this, local5, local6);
    } else if (paramList != null) {
      paramBoolean = PhoneNumQuickLoginManager.a(paramWUserSigInfo, this, local5, local6, paramList);
    } else {
      paramBoolean = false;
    }
    if (!paramBoolean) {
      QQToast.makeText(this, 2131896992, 0).show();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.countryCode = paramIntent.getStringExtra("k_code");
      this.countryName = paramIntent.getStringExtra("k_name");
      paramIntent = this.txtCountryCode;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("+");
      ((StringBuilder)localObject).append(this.countryCode);
      paramIntent.setText(((StringBuilder)localObject).toString());
      try
      {
        updateNextStepButton();
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if ((paramInt1 == 2003) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        this.mUserSigInfo = ((WUserSigInfo)paramIntent.getParcelableExtra("key_mask_users"));
        localObject = this.mUserSigInfo;
        if (localObject != null)
        {
          handleMaskUinLogin((WUserSigInfo)localObject, false, null);
          return;
        }
      }
      handleLoginSuccess(paramIntent);
      return;
    }
    if ((paramInt1 == 2020) && (paramInt2 == -1)) {
      handleLoginSuccess(paramIntent);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Intent localIntent;
    if ((i != 2131448926) && (i != 2131428781))
    {
      if (i == 2131429943) {
        if (!this.mIsValidPhoneNum)
        {
          QQToast.makeText(this, 1, 2131892521, 0).show();
        }
        else
        {
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
          if (this.mLoginUserPrivateHelper.a(this))
          {
            QLog.d("LoginPhoneNumActivity", 1, "click next step");
            localIntent = new Intent();
            localIntent.putExtra("keyFrom", "LoginPhoneNumActivity");
            localIntent.putExtra("url", "https://ti.qq.com/safe/tools/captcha/sms-verify-login");
            LoginUtils.a(this, localIntent, "/base/browser");
            this.btnNextStep.setEnabled(false);
            this.mIsOpeningBrowser = true;
            ReportController.a(this.mRuntime, "dc00898", "", getFUIN(), "0X800B106", "0X800B106", getEntranceType(), 0, "", "", "", "");
            ReportController.a(this.mRuntime, "dc00898", "", getFUIN(), "0X800B108", "0X800B108", getEntranceType(), 0, "", "", "", "");
          }
        }
      }
    }
    else
    {
      localIntent = new Intent(this, NewStyleCountryActivity.class);
      localIntent.putExtra("k_code", this.countryCode);
      localIntent.putExtra("k_name", this.countryName);
      startActivityForResult(localIntent, 1);
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B105", "0X800B105", getEntranceType(), 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    if (this.mRuntime != null) {
      LoginUtils.b(this.mRuntime, getClass());
    }
    unRegisterUnbindAccountReceiver();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */