package com.tencent.mobileqq.activity;

import aayb;
import aayc;
import aayd;
import aaye;
import aayf;
import aayg;
import aayh;
import aayi;
import akse;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import axqy;
import ayfo;
import bbdj;
import bbgu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class DialogActivity
  extends BaseActivity
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  Dialog a;
  private int e;
  private int f;
  
  private void a()
  {
    bbgu localbbgu = bbdj.a(this, 230).setMessage(getString(this.e)).setPositiveButton(getString(2131719554), new aayc(this)).setNegativeButton(getString(2131719555), new aayb(this));
    localbbgu.setOnCancelListener(new aayd(this));
    a(localbbgu);
  }
  
  private void a(Dialog paramDialog)
  {
    QLog.d("qqBaseActivity", 1, "DialogActivity showDialog dialogType=" + this.f + " dialog=" + paramDialog);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "showDialog dialogType=" + this.f);
      }
      paramDialog.show();
      if (this.f == c) {
        axqy.b(null, "dc00898", "", "", "0X8009AC7", "0X8009AC7", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("raw_photo", 2, "showDialog ", localBadTokenException);
      }
      getWindow().getDecorView().post(new DialogActivity.1(this, paramDialog));
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidAppDialog = bbdj.a(this, 230, null, getString(2131698601), getString(2131690596), getString(2131698602), new aaye(this), new aayf(this));
    a(this.jdField_a_of_type_AndroidAppDialog);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidAppDialog = new akse(this);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aayg(this));
    a(this.jdField_a_of_type_AndroidAppDialog);
  }
  
  private void d()
  {
    if (getIntent() == null) {
      return;
    }
    new ayfo(this, getIntent().getStringExtra("key_dialog_title"), getIntent().getStringExtra("key_dialog_content"), new aayh(this), new aayi(this)).show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.f = localIntent.getIntExtra("key_dialog_type", jdField_a_of_type_Int);
      this.e = localIntent.getIntExtra("key_dialog_msg_id", 2131691243);
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.f == b)
    {
      QLog.d("qqBaseActivity", 1, "DialogActivity dimissDialog dialogType=" + this.f + " dialog=" + this.jdField_a_of_type_AndroidAppDialog);
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        finish();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    if (this.f == b)
    {
      b();
      return;
    }
    if (this.f == c)
    {
      c();
      return;
    }
    if (this.f == d)
    {
      d();
      return;
    }
    a();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(null);
    }
    overridePendingTransition(0, 2130772028);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity
 * JD-Core Version:    0.7.0.1
 */