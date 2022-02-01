package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.loginregister.AuthDevVerifyProxy;
import com.tencent.mobileqq.loginregister.ICommonSmsView;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.QuickLoginReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.mobileqq.widget.VerifyCodeView.OnVerifyCodeCompleteListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

@RoutePage(desc="输入短信验证码页面", path="/base/login/authDevVerifyCode")
public class AuthDevVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, SMSBodyObserver, ICommonSmsView, VerifyCodeView.OnVerifyCodeCompleteListener
{
  public static final int SECOND = 1000;
  private static final String TAG = "Q.devlock.AuthDevVerifyCodeActivity";
  public static int mSecond = 1;
  private TextView btnLeftBack;
  private boolean hasUserClickStay;
  private boolean isSmsChecked;
  protected Handler mHandler = new Handler();
  private QQProgressDialog mProDialog;
  private TextView mResendBtn;
  private AuthDevVerifyProxy mVerifyProxy;
  private Runnable runnableCountdown = new AuthDevVerifyCodeActivity.1(this);
  private SmsContent smsContent;
  private VerifyCodeView verifyCodeView;
  
  private boolean checkNetworkAvailable()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, getString(2131692183), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  private void commitSmsCode()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, getString(2131692183), 0).b(getTitleBarHeight());
      return;
    }
    String str2 = this.verifyCodeView.a();
    String str1 = str2;
    if (str2 != null) {
      str1 = str2.toString().trim();
    }
    this.mVerifyProxy.a(this, this, str1);
    this.isSmsChecked = true;
  }
  
  private void hideProgerssDialog()
  {
    this.mHandler.post(new AuthDevVerifyCodeActivity.5(this));
  }
  
  private void initViews()
  {
    setTitleText(2131716657);
    setTitleHint();
    setProgressBarVisible(false);
    this.mResendBtn = ((TextView)findViewById(2131364036));
    this.mResendBtn.setOnClickListener(this);
    long l = System.currentTimeMillis() - LoginStaticField.a;
    if (l >= 59000L) {
      mSecond = 1;
    } else {
      mSecond = (int)((60000L - l) / 1000L);
    }
    if (mSecond > 1)
    {
      this.mResendBtn.setEnabled(false);
      this.mResendBtn.setClickable(false);
      TextView localTextView = this.mResendBtn;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131716626));
      localStringBuilder.append(" (");
      localStringBuilder.append(mSecond);
      localStringBuilder.append("s)");
      localTextView.setText(localStringBuilder.toString());
      this.mResendBtn.setTextColor(-7894119);
      this.mHandler.postDelayed(this.runnableCountdown, 1000L);
    }
    else
    {
      this.mResendBtn.setText(getString(2131716626));
      this.mResendBtn.setTextColor(-11692801);
    }
    this.btnLeftBack = ((TextView)findViewById(2131364182));
    this.btnLeftBack.setOnClickListener(this);
    this.verifyCodeView = ((VerifyCodeView)findViewById(2131380407));
    this.verifyCodeView.a(this);
  }
  
  private void restartTimer(int paramInt)
  {
    this.mResendBtn.setEnabled(false);
    this.mResendBtn.setClickable(false);
    mSecond = paramInt;
    LoginStaticField.a = System.currentTimeMillis();
    TextView localTextView = this.mResendBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131716626));
    localStringBuilder.append(" (");
    localStringBuilder.append(mSecond);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.mResendBtn.setTextColor(-7894119);
    this.mHandler.postDelayed(this.runnableCountdown, 1000L);
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevVerifyCodeActivity.4(this));
  }
  
  public void clearWrongCode()
  {
    this.verifyCodeView.a();
  }
  
  public void dismissDialog()
  {
    hideProgerssDialog();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.mVerifyProxy.a(this, paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563018);
    setTitleText(2131716657);
    AppRuntime localAppRuntime = this.mRuntime;
    paramBundle = localAppRuntime;
    if (localAppRuntime == null) {
      paramBundle = getAppRuntime();
    }
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.mVerifyProxy = new AuthDevVerifyProxy();
    paramBundle = getIntent();
    this.phoneNum = paramBundle.getExtras().getString("phone_num");
    paramBundle = paramBundle.getExtras().getString("country_code");
    if (!TextUtils.isEmpty(paramBundle)) {
      this.countryCode = paramBundle;
    }
    initViews();
    this.isSmsChecked = false;
    this.hasUserClickStay = false;
    if (AppSetting.d) {
      this.mResendBtn.setContentDescription(getString(2131716626));
    }
    try
    {
      this.smsContent = new SmsContent(null);
      this.smsContent.a(this, this);
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    this.mVerifyProxy.a(this, this);
    if ((mSecond <= 1) && (checkNetworkAvailable())) {
      this.mVerifyProxy.a(this, this);
    }
    getWindow().setSoftInputMode(5);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AuthDevVerifyProxy localAuthDevVerifyProxy = this.mVerifyProxy;
    if (localAuthDevVerifyProxy != null) {
      localAuthDevVerifyProxy.a();
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new AuthDevVerifyCodeActivity.6(this, paramString1, paramString2));
  }
  
  public void loginSuccessCallBack()
  {
    if (this.hasUserClickStay) {
      report898("0X800BB54");
    }
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("from_phone_num_login", false)))
    {
      QuickLoginReporter.b(0, "SUCCESS");
      NewAuthDevUgFragment.a(3);
    }
  }
  
  public boolean onBackEvent()
  {
    if (!this.isSmsChecked)
    {
      DialogUtil.a(this, 230, getString(2131700861), getString(2131700452, new Object[] { getMaskedPhoneNum() }), getString(2131711171), getString(2131702762), new AuthDevVerifyCodeActivity.2(this), new AuthDevVerifyCodeActivity.3(this)).show();
      report898("0X800BB51");
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364036)
    {
      if ((mSecond <= 1) && (checkNetworkAvailable())) {
        this.mVerifyProxy.b(this, this);
      }
    }
    else if (paramView.getId() == 2131364182)
    {
      onBackEvent();
      report898("0X800BB50");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    SmsContent localSmsContent = this.smsContent;
    if (localSmsContent != null) {
      try
      {
        localSmsContent.a();
        this.smsContent = null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    this.handler.removeCallbacksAndMessages(null);
    this.mHandler.removeCallbacksAndMessages(null);
    hideProgerssDialog();
    AuthDevVerifyProxy localAuthDevVerifyProxy = this.mVerifyProxy;
    if (localAuthDevVerifyProxy != null) {
      localAuthDevVerifyProxy.b();
    }
  }
  
  public void onVerifyCodeComplete()
  {
    commitSmsCode();
  }
  
  public void report898(String paramString)
  {
    ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public void showLoadingDialog()
  {
    showProgressDialog();
  }
  
  public void startTimer(int paramInt)
  {
    restartTimer(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */