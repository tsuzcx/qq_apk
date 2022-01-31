package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.teamwork.TeamWorkSaveDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import sgq;
import sgr;
import sgs;
import sgt;
import sgu;
import sgv;
import sgw;
import sgx;
import sgy;

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
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage(getString(this.e)).setPositiveButton(getString(2131432997), new sgs(this)).setNegativeButton(getString(2131432996), new sgr(this));
    localQQCustomDialog.setOnCancelListener(new sgt(this));
    a(localQQCustomDialog);
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
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("raw_photo", 2, "showDialog ", localBadTokenException);
      }
      getWindow().getDecorView().post(new sgq(this, paramDialog));
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, null, getString(2131438661), getString(2131432998), getString(2131438660), new sgu(this), new sgv(this));
    a(this.jdField_a_of_type_AndroidAppDialog);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidAppDialog = new MsgNotifyPushDialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new sgw(this));
    a(this.jdField_a_of_type_AndroidAppDialog);
  }
  
  private void d()
  {
    if (getIntent() == null) {
      return;
    }
    new TeamWorkSaveDialog(this, getIntent().getStringExtra("key_dialog_title"), getIntent().getStringExtra("key_dialog_content"), new sgx(this), new sgy(this)).show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.f = localIntent.getIntExtra("key_dialog_type", jdField_a_of_type_Int);
      this.e = localIntent.getIntExtra("key_dialog_msg_id", 2131436096);
    }
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnPause()
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
  
  protected void doOnResume()
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
    overridePendingTransition(0, 2131034158);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity
 * JD-Core Version:    0.7.0.1
 */