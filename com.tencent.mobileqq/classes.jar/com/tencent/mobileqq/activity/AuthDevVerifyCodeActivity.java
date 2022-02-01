package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.loginregister.AuthDevVerifyProxy;
import com.tencent.mobileqq.loginregister.ICommonSmsView;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

@RoutePage(desc="输入短信验证码页面", path="/base/login/authDevVerifyCode")
public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver, ICommonSmsView
{
  public static final int SECOND = 1000;
  private static final String TAG = "Q.devlock.AuthDevVerifyCodeActivity";
  public static int mSecond = 1;
  private Button mConfirmBtn;
  protected Handler mHandler = new Handler();
  private ClearableEditText mInput;
  private QQProgressDialog mProDialog;
  private TextView mResendBtn;
  private TextView mTipTv;
  private AuthDevVerifyProxy mVerifyProxy;
  private Runnable runnableCountdown = new AuthDevVerifyCodeActivity.1(this);
  private SmsContent smsContent;
  
  private boolean checkNetworkAvailable()
  {
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  private void commitSmsCode()
  {
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
      return;
    }
    String str = "";
    Editable localEditable = this.mInput.getText();
    if (localEditable != null) {
      str = localEditable.toString().trim();
    }
    if (str.length() > 0)
    {
      this.mVerifyProxy.a(this, this, str);
      return;
    }
    notifyToast(2131716917, 0);
  }
  
  private void hideProgerssDialog()
  {
    this.mHandler.post(new AuthDevVerifyCodeActivity.3(this));
  }
  
  private void restartTimer(int paramInt)
  {
    this.mResendBtn.setEnabled(false);
    this.mResendBtn.setClickable(false);
    mSecond = paramInt;
    LoginStaticField.a = System.currentTimeMillis();
    this.mResendBtn.setText(getString(2131716973) + "(" + mSecond + ")");
    this.mHandler.postDelayed(this.runnableCountdown, 1000L);
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevVerifyCodeActivity.2(this));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.mConfirmBtn.setEnabled(true);
      return;
    }
    this.mConfirmBtn.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.mVerifyProxy.a(this, paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mConfirmBtn.setClickable(true);
    if (this.mVerifyProxy != null) {
      this.mVerifyProxy.a();
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new AuthDevVerifyCodeActivity.4(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131365207) {
      commitSmsCode();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131364115) && (mSecond <= 1) && (checkNetworkAvailable())) {
        this.mVerifyProxy.b(this, this);
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
    super.setContentView(2131561193);
    super.setTitle(2131717004);
    AppRuntime localAppRuntime = this.mRuntime;
    paramBundle = localAppRuntime;
    if (localAppRuntime == null) {
      paramBundle = getAppRuntime();
    }
    if (paramBundle == null) {
      super.finish();
    }
    for (;;)
    {
      return;
      this.mVerifyProxy = new AuthDevVerifyProxy();
      paramBundle = super.getIntent();
      this.phoneNum = paramBundle.getExtras().getString("phone_num");
      this.countryCode = paramBundle.getExtras().getString("country_code");
      this.mTipTv = ((TextView)super.findViewById(2131380792));
      this.mInput = ((ClearableEditText)super.findViewById(2131372461));
      this.mInput.addTextChangedListener(this);
      this.mConfirmBtn = ((Button)super.findViewById(2131365207));
      this.mConfirmBtn.setOnClickListener(this);
      this.mTipTv.setText(getString(2131716999, new Object[] { this.phoneNum }));
      this.mResendBtn = ((TextView)super.findViewById(2131364115));
      this.mResendBtn.setOnClickListener(this);
      this.mResendBtn.setText(getString(2131716973));
      if (AppSetting.d)
      {
        this.mConfirmBtn.setContentDescription(getString(2131694615));
        this.mResendBtn.setContentDescription(getString(2131716973));
      }
      try
      {
        this.smsContent = new SmsContent(null);
        this.smsContent.a(this, this);
        l = System.currentTimeMillis() - LoginStaticField.a;
        if (l >= 59000L)
        {
          mSecond = 1;
          if (mSecond > 1)
          {
            this.mResendBtn.setEnabled(false);
            this.mResendBtn.setClickable(false);
            this.mResendBtn.setText(getString(2131716973) + "(" + mSecond + ")");
            this.mHandler.postDelayed(this.runnableCountdown, 1000L);
          }
          this.mVerifyProxy.a(this, this);
          if ((mSecond > 1) || (!checkNetworkAvailable())) {
            continue;
          }
          this.mVerifyProxy.a(this, this);
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          long l;
          paramBundle.printStackTrace();
          continue;
          mSecond = (int)((60000L - l) / 1000L);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.smsContent != null) {}
    try
    {
      this.smsContent.a();
      this.smsContent = null;
      this.handler.removeCallbacksAndMessages(null);
      this.mHandler.removeCallbacksAndMessages(null);
      hideProgerssDialog();
      if (this.mVerifyProxy != null) {
        this.mVerifyProxy.b();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setConfirmBtnEnable(boolean paramBoolean)
  {
    this.mConfirmBtn.setClickable(paramBoolean);
  }
  
  public void setTipsVisibility(int paramInt)
  {
    this.mTipTv.setVisibility(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */