package com.tencent.mobileqq.activity;

import Override;
import aets;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewGroup;
import bisy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RegisterBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  protected Dialog a;
  protected ViewGroup a;
  protected String a;
  protected boolean a = true;
  protected Handler b;
  public String b;
  
  public RegisterBaseActivity()
  {
    this.jdField_b_of_type_JavaLangString = "86";
    this.jdField_b_of_type_AndroidOsHandler = new aets(this);
  }
  
  protected void a(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new RegisterBaseActivity.4(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bisy(this).a(paramInt1, getTitleBarHeight(), 1, paramInt2);
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
    new bisy(this).a(str, getTitleBarHeight(), 0, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new RegisterBaseActivity.2(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new RegisterBaseActivity.3(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity
 * JD-Core Version:    0.7.0.1
 */