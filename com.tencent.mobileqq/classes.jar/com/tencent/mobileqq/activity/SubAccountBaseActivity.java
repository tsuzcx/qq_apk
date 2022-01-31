package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import azyl;
import bdcd;
import bdee;
import bdfq;
import bepp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  private bdfq jdField_a_of_type_Bdfq;
  private bepp jdField_a_of_type_Bepp;
  public String b;
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this, getTitleBarHeight());
      this.jdField_a_of_type_Bepp.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bepp.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bepp != null) && (!this.jdField_a_of_type_Bepp.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bepp.show();
      }
      return;
      this.jdField_a_of_type_Bepp.c(2131695088);
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    f();
    this.jdField_a_of_type_Bdfq = bdcd.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bdfq.setPositiveButton(2131691088, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bdfq.setCancelable(false);
    this.jdField_a_of_type_Bdfq.show();
  }
  
  public void b(String paramString)
  {
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  public void b(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    f();
    this.jdField_a_of_type_Bdfq = bdcd.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bdfq.setPositiveButton(2131691088, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bdfq.setCancelable(false);
    this.jdField_a_of_type_Bdfq.show();
  }
  
  public boolean b()
  {
    return bdee.d(BaseApplication.getContext());
  }
  
  public void c(String paramString)
  {
    QQToast.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
  
  public boolean c()
  {
    boolean bool = b();
    if (!bool) {
      b(getString(2131692397));
    }
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = getIntent().getStringExtra("fromWhere");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    azyl localazyl = (azyl)this.app.getManager(62);
    if (localazyl != null) {
      localazyl.a(this);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bepp.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      label24:
      this.jdField_a_of_type_Bdfq = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void finish()
  {
    e();
    f();
    super.finish();
  }
  
  protected void g() {}
  
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
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBaseActivity
 * JD-Core Version:    0.7.0.1
 */