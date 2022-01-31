package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToastNotifier;
import tud;
import tue;
import tug;
import tuh;
import tui;

public class RegisterNewBaseActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  public Dialog a;
  public Handler a;
  protected View.OnClickListener a;
  public String a;
  public String b = "86";
  public boolean b;
  public boolean c = true;
  
  public RegisterNewBaseActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new tud(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new tui(this);
  }
  
  protected void a(int paramInt)
  {
    ((ProgressBar)findViewById(2131372226)).setProgress(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 1, paramInt2);
  }
  
  protected void a(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131372228);
    localTextView.setText(paramString);
    if (AppSetting.b) {
      localTextView.setContentDescription(paramString);
    }
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
    new QQToastNotifier(this).a(str, getTitleBarHeight(), 0, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new tue(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131372226);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  public void b()
  {
    TextView localTextView = (TextView)findViewById(2131372227);
    localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.b) {
      localTextView.setContentDescription(getResources().getString(2131433712));
    }
  }
  
  protected void b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new tuh(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tug(this));
  }
  
  public void c(int paramInt)
  {
    TextView localTextView = (TextView)findViewById(2131372228);
    String str = getResources().getString(paramInt);
    localTextView.setText(str);
    if (AppSetting.b) {
      localTextView.setContentDescription(str);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(1024);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */