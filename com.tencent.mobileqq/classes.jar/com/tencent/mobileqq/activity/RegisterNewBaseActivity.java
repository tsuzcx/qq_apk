package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class RegisterNewBaseActivity
  extends QBaseActivity
  implements DialogInterface.OnClickListener
{
  public static final int FROM_ADD_ACCOUNT = 1;
  public static final int FROM_CHOOSE_LOGIN = 6;
  public static final int FROM_LOGIN_BIND_PHONE_NUM = 9;
  public static final int FROM_LOGIN_GUIDE = 2;
  public static final int FROM_LOGIN_VIEW = 3;
  public static final int FROM_NICKANDPWD = 8;
  public static final int FROM_PHOME_NUM = 7;
  public static final int FROM_UP_SMS = 4;
  public static final int FROM_VERIFY_CODE = 5;
  private static final String TAG = "RegisterNewBaseActivity";
  public String countryCode = "86";
  protected Dialog dialog;
  public Handler handler = new RegisterNewBaseActivity.1(this);
  public String inviteCode;
  protected ViewGroup mContextView;
  public String mCountryEnglishName = "CN";
  private QQCustomDialog mDialog;
  public int mFrom = -1;
  public boolean mHasPwd = true;
  public boolean mIsPhoneNumRegistered = false;
  public ILoginApi mLoginApi;
  protected View.OnClickListener onBackListeger = new RegisterNewBaseActivity.5(this);
  public String phoneNum = "";
  
  protected boolean checkPhoneNumLength(Editable paramEditable)
  {
    boolean bool2 = TextUtils.isEmpty(paramEditable);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    String str = this.countryCode;
    if ((str != null) && (!str.equals("86"))) {
      return true;
    }
    if (paramEditable.length() == 11) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void closeAllActs(boolean paramBoolean)
  {
    MqqHandler localMqqHandler = LoginUtils.a(getAppRuntime(), RegisterSendUpSms.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(107);
    }
    localMqqHandler = LoginUtils.a(getAppRuntime(), RegisterVerifyCodeActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(106);
    }
    localMqqHandler = LoginUtils.a(getAppRuntime(), RegisterPhoneNumActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(103);
    }
    if (paramBoolean)
    {
      localMqqHandler = LoginUtils.a(getAppRuntime(), RegisterPersonalInfoActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(109);
      }
      localMqqHandler = LoginUtils.a(getAppRuntime(), RegisterByNicknameAndPwdActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(109);
      }
    }
  }
  
  public void closeDialog()
  {
    this.handler.post(new RegisterNewBaseActivity.3(this));
  }
  
  public void createWaitingDialog(int paramInt)
  {
    try
    {
      this.handler.post(new RegisterNewBaseActivity.4(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RegisterNewBaseActivity", 1, "createWaitingDialog exception", localException);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(1024);
    this.mFrom = getIntent().getIntExtra("key_register_from", -1);
    this.mLoginApi = ((ILoginApi)QRoute.api(ILoginApi.class));
    return true;
  }
  
  public String getEditPhoneNum()
  {
    return this.phoneNum;
  }
  
  protected String getMaskedPhoneNum()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.phoneNum.substring(0, 3));
    localStringBuilder.append("******");
    String str = this.phoneNum;
    localStringBuilder.append(str.substring(str.length() - 2));
    return localStringBuilder.toString();
  }
  
  protected String getMaskedPhoneNumWithCountryCode()
  {
    String str = getMaskedPhoneNum();
    StringBuilder localStringBuilder = new StringBuilder(" +");
    localStringBuilder.append(this.countryCode);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  public void notifyToast(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 1, paramInt2);
  }
  
  public void notifyToast(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      new QQToastNotifier(this).a(str, getTitleBarHeight(), 0, paramInt);
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface.dismiss();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void setBackListener()
  {
    TextView localTextView = (TextView)findViewById(2131364182);
    localTextView.setOnClickListener(this.onBackListeger);
    if (AppSetting.d) {
      localTextView.setContentDescription(getResources().getString(2131690706));
    }
  }
  
  protected void setBarProgress(int paramInt)
  {
    ((ProgressBar)findViewById(2131376378)).setProgress(paramInt);
  }
  
  protected void setProgressBarVisible(boolean paramBoolean)
  {
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131376378);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localProgressBar.setVisibility(i);
  }
  
  protected void setTitleHint()
  {
    if (TextUtils.isEmpty(this.phoneNum))
    {
      QLog.e("RegisterNewBaseActivity", 1, "setTitleHint error: phoneNum is empty, set phone number before calling this method!");
      return;
    }
    TextView localTextView = (TextView)findViewById(2131380055);
    String str1 = getMaskedPhoneNumWithCountryCode();
    String str2 = getString(2131716653, new Object[] { str1 });
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new ForegroundColorSpan(-31933), str2.indexOf(str1), str2.indexOf(str1) + str1.length(), 33);
    localTextView.setText(localSpannableString);
  }
  
  protected void setTitleText(int paramInt)
  {
    TextView localTextView = (TextView)findViewById(2131380038);
    String str = getResources().getString(paramInt);
    localTextView.setText(str);
    if (AppSetting.d) {
      localTextView.setContentDescription(str);
    }
  }
  
  protected void setTitleText(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131380038);
    localTextView.setText(paramString);
    if (AppSetting.d) {
      localTextView.setContentDescription(paramString);
    }
  }
  
  public void showDialog(String paramString1, String paramString2)
  {
    try
    {
      this.handler.post(new RegisterNewBaseActivity.2(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */