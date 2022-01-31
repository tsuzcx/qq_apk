package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import axam;
import babr;
import badq;
import bafb;
import bbms;
import bbmy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  private bafb jdField_a_of_type_Bafb;
  private bbms jdField_a_of_type_Bbms;
  public String b;
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbms == null)
    {
      this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
      this.jdField_a_of_type_Bbms.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bbms.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bbms != null) && (!this.jdField_a_of_type_Bbms.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bbms.show();
      }
      return;
      this.jdField_a_of_type_Bbms.c(2131629253);
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    d();
    this.jdField_a_of_type_Bafb = babr.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bafb.setPositiveButton(2131625463, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bafb.setNegativeButton(2131625035, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bafb.setCancelable(false);
    this.jdField_a_of_type_Bafb.show();
  }
  
  public boolean a()
  {
    return badq.d(BaseApplication.getContext());
  }
  
  public void b(String paramString)
  {
    bbmy.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  public void b(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    d();
    this.jdField_a_of_type_Bafb = babr.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bafb.setPositiveButton(2131625463, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bafb.setCancelable(false);
    this.jdField_a_of_type_Bafb.show();
  }
  
  public boolean b()
  {
    boolean bool = a();
    if (!bool) {
      b(getString(2131626719));
    }
    return bool;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bbms.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(String paramString)
  {
    bbmy.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bafb.dismiss();
      label24:
      this.jdField_a_of_type_Bafb = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
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
    axam localaxam = (axam)this.app.getManager(62);
    if (localaxam != null) {
      localaxam.a(this);
    }
  }
  
  protected void e() {}
  
  public void finish()
  {
    c();
    d();
    super.finish();
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
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBaseActivity
 * JD-Core Version:    0.7.0.1
 */