package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import bacu;
import bdgm;
import bdin;
import bdjz;
import bety;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  private bdjz jdField_a_of_type_Bdjz;
  private bety jdField_a_of_type_Bety;
  public String b;
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
      this.jdField_a_of_type_Bety.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bety.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bety != null) && (!this.jdField_a_of_type_Bety.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bety.show();
      }
      return;
      this.jdField_a_of_type_Bety.c(2131695090);
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    f();
    this.jdField_a_of_type_Bdjz = bdgm.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bdjz.setPositiveButton(2131691089, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bdjz.setNegativeButton(2131690648, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bdjz.setCancelable(false);
    this.jdField_a_of_type_Bdjz.show();
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
    this.jdField_a_of_type_Bdjz = bdgm.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bdjz.setPositiveButton(2131691089, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bdjz.setCancelable(false);
    this.jdField_a_of_type_Bdjz.show();
  }
  
  public boolean b()
  {
    return bdin.d(BaseApplication.getContext());
  }
  
  public void c(String paramString)
  {
    QQToast.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
  
  public boolean c()
  {
    boolean bool = b();
    if (!bool) {
      b(getString(2131692398));
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
    bacu localbacu = (bacu)this.app.getManager(62);
    if (localbacu != null) {
      localbacu.a(this);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      label24:
      this.jdField_a_of_type_Bdjz = null;
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