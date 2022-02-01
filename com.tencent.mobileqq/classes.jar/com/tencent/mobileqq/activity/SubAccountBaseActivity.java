package com.tencent.mobileqq.activity;

import Override;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bdwt;
import bhlq;
import bhnv;
import bhpc;
import bjbs;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  private bhpc jdField_a_of_type_Bhpc;
  private bjbs jdField_a_of_type_Bjbs;
  public String b;
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
      this.jdField_a_of_type_Bjbs.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bjbs.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bjbs != null) && (!this.jdField_a_of_type_Bjbs.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bjbs.show();
      }
      return;
      this.jdField_a_of_type_Bjbs.c(2131694176);
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    f();
    this.jdField_a_of_type_Bhpc = bhlq.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bhpc.setPositiveButton(2131690912, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bhpc.setNegativeButton(2131690580, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bhpc.setCancelable(false);
    this.jdField_a_of_type_Bhpc.show();
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
    this.jdField_a_of_type_Bhpc = bhlq.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bhpc.setPositiveButton(2131690912, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bhpc.setCancelable(false);
    this.jdField_a_of_type_Bhpc.show();
  }
  
  public boolean b()
  {
    return bhnv.d(BaseApplication.getContext());
  }
  
  public void c(String paramString)
  {
    QQToast.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
  
  public boolean c()
  {
    boolean bool = b();
    if (!bool) {
      b(getString(2131691989));
    }
    return bool;
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
    super.doOnCreate(paramBundle);
    this.b = getIntent().getStringExtra("fromWhere");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bdwt localbdwt = (bdwt)this.app.getManager(62);
    if (localbdwt != null) {
      localbdwt.a(this);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bjbs.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      label24:
      this.jdField_a_of_type_Bhpc = null;
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBaseActivity
 * JD-Core Version:    0.7.0.1
 */