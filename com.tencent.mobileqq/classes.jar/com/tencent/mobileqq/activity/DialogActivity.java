package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkSaveDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DialogActivity
  extends BaseActivity
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  Dialog e;
  private int f;
  private int g;
  
  private void a()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage(getString(this.f)).setPositiveButton(getString(2131916604), new DialogActivity.3(this)).setNegativeButton(getString(2131916605), new DialogActivity.2(this));
    localQQCustomDialog.setOnCancelListener(new DialogActivity.4(this));
    a(localQQCustomDialog);
  }
  
  private void a(Dialog paramDialog)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DialogActivity showDialog dialogType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" dialog=");
    localStringBuilder.append(paramDialog);
    QLog.d("qqBaseActivity", 1, localStringBuilder.toString());
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showDialog dialogType=");
        localStringBuilder.append(this.g);
        QLog.d("raw_photo", 2, localStringBuilder.toString());
      }
      paramDialog.show();
      if (this.g == c)
      {
        ReportController.b(null, "dc00898", "", "", "0X8009AC7", "0X8009AC7", 0, 0, "", "", "", "");
        return;
      }
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
    this.e = DialogUtil.a(this, 230, null, getString(2131896600), getString(2131887648), getString(2131896601), new DialogActivity.5(this), new DialogActivity.6(this));
    a(this.e);
  }
  
  private void c()
  {
    this.e = new MsgNotifyPushDialog(this);
    this.e.setOnDismissListener(new DialogActivity.7(this));
    a(this.e);
  }
  
  private void d()
  {
    if (getIntent() == null) {
      return;
    }
    new TeamWorkSaveDialog(this, getIntent().getStringExtra("key_dialog_title"), getIntent().getStringExtra("key_dialog_content"), new DialogActivity.8(this), new DialogActivity.9(this)).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.g = localIntent.getIntExtra("key_dialog_type", a);
      this.f = localIntent.getIntExtra("key_dialog_msg_id", 2131888197);
    }
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.g == b)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DialogActivity dimissDialog dialogType=");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(" dialog=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("qqBaseActivity", 1, ((StringBuilder)localObject).toString());
      localObject = this.e;
      if (localObject != null)
      {
        ((Dialog)localObject).dismiss();
        finish();
        this.e = null;
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Dialog localDialog = this.e;
    if ((localDialog != null) && (localDialog.isShowing())) {
      return;
    }
    int i = this.g;
    if (i == b)
    {
      b();
      return;
    }
    if (i == c)
    {
      c();
      return;
    }
    if (i == d)
    {
      d();
      return;
    }
    a();
  }
  
  public void finish()
  {
    super.finish();
    Dialog localDialog = this.e;
    if (localDialog != null) {
      localDialog.setOnDismissListener(null);
    }
    overridePendingTransition(0, 2130772081);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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