package com.tencent.mobileqq.activity;

import android.content.Intent;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  private ConfigClearableEditText editText;
  private String fromWhere;
  private String mEntrance;
  private boolean mFromAccountChange = false;
  MqqHandler mHandler = new LoginPhoneNumActivity.1(this);
  private boolean mIsOpeningBrowser;
  private boolean mIsSubaccount = false;
  private LoginUserPrivateHelper mLoginUserPrivateHelper;
  private byte[] mReqData;
  private String mTitle;
  WtloginObserver mWtloginObserver = new LoginPhoneNumActivity.7(this);
  private TextView txtCountryCode;
  private TextView txtCountryName;
  
  private int getEntranceType()
  {
    if (this.mEntrance == null) {}
    do
    {
      return 0;
      if ("fromLogin".equals(this.mEntrance)) {
        return 4;
      }
      if (LoginView.class.getName().equals(this.mEntrance)) {
        return 1;
      }
      if ("fromAddAccount".equals(this.mEntrance)) {
        return 3;
      }
    } while (!"fromSubLogin".equals(this.mEntrance));
    return 2;
  }
  
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
  
  private void handleMaskUinLogin(WUserSigInfo paramWUserSigInfo)
  {
    if (!PhoneNumQuickLoginManager.a(paramWUserSigInfo, this, new LoginPhoneNumActivity.5(this), new LoginPhoneNumActivity.6(this))) {
      QQToast.a(this, 2131698909, 0).a();
    }
  }
  
  private void initViews()
  {
    String str;
    if (TextUtils.isEmpty(this.mTitle))
    {
      str = getResources().getString(2131720470);
      setTitleText(str);
      setBackListener();
      setProgressBarVisible(false);
      this.txtCountryName = ((TextView)findViewById(2131380754));
      this.txtCountryName.setOnClickListener(this);
      this.arrowCountry = ((ImageView)findViewById(2131363032));
      this.arrowCountry.setOnClickListener(this);
      this.txtCountryCode = ((TextView)findViewById(2131380753));
      this.countryCode = PhoneCodeUtils.b(this);
      this.txtCountryCode.setText("+" + this.countryCode);
      if ("86".equals(this.countryCode)) {
        this.txtCountryName.setText(getString(2131716898));
      }
      this.editText = ((ConfigClearableEditText)findViewById(2131372461));
      this.editText.addTextChangedListener(this);
      if (Build.VERSION.SDK_INT < 11) {
        break label229;
      }
      this.editText.setCustomSelectionActionModeCallback(new LoginPhoneNumActivity.3(this));
    }
    for (;;)
    {
      this.btnNextStep = ((Button)findViewById(2131364061));
      this.btnNextStep.setOnClickListener(this);
      return;
      str = this.mTitle;
      break;
      label229:
      this.editText.setOnCreateContextMenuListener(new LoginPhoneNumActivity.4(this));
    }
  }
  
  private String isValidMobileNum(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.countryCode)) {
          break label176;
        }
        if ("853".equals(this.countryCode))
        {
          break label176;
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
          if ("86".equals(this.countryCode)) {
            i = 0;
          }
        }
        if (!"86".equals(this.countryCode)) {
          break label168;
        }
        j = paramString.length();
        if (j == 11) {
          break label168;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label151;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.countryCode);
      if (bool)
      {
        i = 9;
        continue;
        label151:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label168:
        continue;
        label176:
        i = 6;
      }
    }
  }
  
  private void startQueryAccount()
  {
    if (!validNum()) {}
    do
    {
      return;
      if (this.mReqData == null)
      {
        QLog.d("LoginPhoneNumActivity", 1, "startQueryAccount, but mReqData is null");
        return;
      }
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        notifyToast(2131692257, 0);
        return;
      }
      createWaitingDialog(2131699695);
    } while (PhoneNumLoginImpl.a().a(this.mRuntime, this.phoneNum, this.countryCode, this.mReqData, this.mWtloginObserver) == 0);
    closeDialog();
    notifyToast(getString(2131716956), 1);
  }
  
  private boolean validNum()
  {
    boolean bool = true;
    this.phoneNum = isValidMobileNum(this.editText.getText().toString());
    if (this.phoneNum == null)
    {
      notifyToast(2131716940, 1);
      bool = false;
    }
    return bool;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (isValidMobileNum(paramEditable.toString()) != null)
    {
      this.btnNextStep.setEnabled(true);
      return;
    }
    this.btnNextStep.setEnabled(false);
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
    setContentView(2131561319);
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
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B104", "0X800B104", getEntranceType(), 0, "", "", "", "");
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mIsOpeningBrowser)
    {
      this.btnNextStep.setEnabled(true);
      this.mIsOpeningBrowser = false;
    }
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
    startActivityForResult(localIntent, 20140319);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("k_name");
      this.txtCountryName.setText((CharSequence)localObject);
      this.countryCode = paramIntent.getStringExtra("k_code");
      this.txtCountryCode.setText("+" + this.countryCode);
      try
      {
        if (isValidMobileNum(this.editText.getText().toString()) != null)
        {
          this.btnNextStep.setEnabled(true);
          return;
        }
        this.btnNextStep.setEnabled(false);
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
      if (paramIntent != null)
      {
        localObject = (WUserSigInfo)paramIntent.getParcelableExtra("key_mask_users");
        if (localObject != null)
        {
          handleMaskUinLogin((WUserSigInfo)localObject);
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
    if ((i == 2131380754) || (i == 2131363032))
    {
      startActivityForResult(new Intent(this, NewStyleCountryActivity.class), 1);
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B105", "0X800B105", getEntranceType(), 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131364061) {
        if (!this.mLoginUserPrivateHelper.a(this))
        {
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        }
        else
        {
          QLog.d("LoginPhoneNumActivity", 1, "click next step");
          Intent localIntent = new Intent();
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
      LoginUtils.a(this.mRuntime, getClass());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */