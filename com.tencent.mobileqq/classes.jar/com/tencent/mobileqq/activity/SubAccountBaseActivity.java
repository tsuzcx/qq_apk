package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import ayaq;
import bbdj;
import bbfj;
import bbgu;
import bcqf;
import bcql;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  private bbgu jdField_a_of_type_Bbgu;
  private bcqf jdField_a_of_type_Bcqf;
  public String b;
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
      this.jdField_a_of_type_Bcqf.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bcqf.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bcqf != null) && (!this.jdField_a_of_type_Bcqf.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bcqf.show();
      }
      return;
      this.jdField_a_of_type_Bcqf.c(2131694931);
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    d();
    this.jdField_a_of_type_Bbgu = bbdj.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bbgu.setPositiveButton(2131691035, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bbgu.setNegativeButton(2131690596, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bbgu.setCancelable(false);
    this.jdField_a_of_type_Bbgu.show();
  }
  
  public boolean a()
  {
    return bbfj.d(BaseApplication.getContext());
  }
  
  public void b(String paramString)
  {
    bcql.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  public void b(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    d();
    this.jdField_a_of_type_Bbgu = bbdj.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bbgu.setPositiveButton(2131691035, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bbgu.setCancelable(false);
    this.jdField_a_of_type_Bbgu.show();
  }
  
  public boolean b()
  {
    boolean bool = a();
    if (!bool) {
      b(getString(2131692321));
    }
    return bool;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(String paramString)
  {
    bcql.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      label24:
      this.jdField_a_of_type_Bbgu = null;
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
    ayaq localayaq = (ayaq)this.app.getManager(62);
    if (localayaq != null) {
      localayaq.a(this);
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