package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToastNotifier;
import tlz;
import tma;
import tmc;
import tmd;

public class RegisterBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  public Dialog a;
  protected ViewGroup a;
  protected String a;
  protected boolean a = true;
  public Handler b;
  protected String b;
  
  public RegisterBaseActivity()
  {
    this.jdField_b_of_type_JavaLangString = "86";
    this.jdField_b_of_type_AndroidOsHandler = new tlz(this);
  }
  
  protected void a(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new tmd(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 1, paramInt2);
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
      this.jdField_b_of_type_AndroidOsHandler.post(new tma(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new tmc(this));
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
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity
 * JD-Core Version:    0.7.0.1
 */