package com.tencent.mobileqq.activity;

import Override;
import afav;
import afax;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import bibh;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class RegisterNewBaseActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  protected Dialog a;
  public Handler a;
  protected View.OnClickListener a;
  public String a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public boolean c = true;
  
  public RegisterNewBaseActivity()
  {
    this.jdField_b_of_type_JavaLangString = "86";
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new afav(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afax(this);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a(int paramInt)
  {
    ((ProgressBar)findViewById(2131376347)).setProgress(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bibh(this).a(paramInt1, getTitleBarHeight(), 1, paramInt2);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    new bibh(this).a(str, getTitleBarHeight(), 0, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new RegisterNewBaseActivity.2(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131376347);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  protected void b()
  {
    TextView localTextView = (TextView)findViewById(2131364039);
    localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.c) {
      localTextView.setContentDescription(getResources().getString(2131690563));
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new RegisterNewBaseActivity.4(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void b(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131380079);
    localTextView.setText(paramString);
    if (AppSetting.c) {
      localTextView.setContentDescription(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    MqqHandler localMqqHandler = this.app.getHandler(RegisterChooseLoginActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(105);
    }
    localMqqHandler = this.app.getHandler(RegisterSendUpSms.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(107);
    }
    localMqqHandler = this.app.getHandler(RegisterVerifyCodeActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(106);
    }
    localMqqHandler = this.app.getHandler(RegisterPhoneNumActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(103);
    }
    if (paramBoolean)
    {
      localMqqHandler = this.app.getHandler(RegisterPersonalInfoActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(109);
      }
      localMqqHandler = this.app.getHandler(RegisterByNicknameAndPwdActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(109);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RegisterNewBaseActivity.3(this));
  }
  
  protected void c(int paramInt)
  {
    TextView localTextView = (TextView)findViewById(2131380079);
    String str = getResources().getString(paramInt);
    localTextView.setText(str);
    if (AppSetting.c) {
      localTextView.setContentDescription(str);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(1024);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("key_register_from", -1);
    return true;
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */