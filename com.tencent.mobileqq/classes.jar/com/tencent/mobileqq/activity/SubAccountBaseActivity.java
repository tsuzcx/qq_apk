package com.tencent.mobileqq.activity;

import Override;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bdxj;
import bhdj;
import bisl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  private bisl jdField_a_of_type_Bisl;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public String b;
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      this.jdField_a_of_type_Bisl.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bisl.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bisl != null) && (!this.jdField_a_of_type_Bisl.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bisl.show();
      }
      return;
      this.jdField_a_of_type_Bisl.c(2131694477);
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131691037, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690697, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131691037, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public boolean b()
  {
    return NetworkUtil.isNetSupport(BaseApplication.getContext());
  }
  
  public void c(String paramString)
  {
    QQToast.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
  
  public boolean c()
  {
    boolean bool = b();
    if (!bool) {
      b(getString(2131692125));
    }
    return bool;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
    bdxj localbdxj = (bdxj)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
    if (localbdxj != null) {
      localbdxj.a(this);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
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