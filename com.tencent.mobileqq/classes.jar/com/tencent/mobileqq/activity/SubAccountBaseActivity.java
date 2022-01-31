package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import ayao;
import bbcv;
import bbev;
import bbgg;
import bcpq;
import bcpw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  private bbgg jdField_a_of_type_Bbgg;
  private bcpq jdField_a_of_type_Bcpq;
  public String b;
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
      this.jdField_a_of_type_Bcpq.c(true);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Bcpq.c(paramInt);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bcpq != null) && (!this.jdField_a_of_type_Bcpq.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_Bcpq.show();
      }
      return;
      this.jdField_a_of_type_Bcpq.c(2131694930);
    }
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    d();
    this.jdField_a_of_type_Bbgg = bbcv.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bbgg.setPositiveButton(2131691035, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bbgg.setNegativeButton(2131690596, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bbgg.setCancelable(false);
    this.jdField_a_of_type_Bbgg.show();
  }
  
  public boolean a()
  {
    return bbev.d(BaseApplication.getContext());
  }
  
  public void b(String paramString)
  {
    bcpw.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  public void b(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    d();
    this.jdField_a_of_type_Bbgg = bbcv.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bbgg.setPositiveButton(2131691035, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_Bbgg.setCancelable(false);
    this.jdField_a_of_type_Bbgg.show();
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
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(String paramString)
  {
    bcpw.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      label24:
      this.jdField_a_of_type_Bbgg = null;
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
    ayao localayao = (ayao)this.app.getManager(62);
    if (localayao != null) {
      localayao.a(this);
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