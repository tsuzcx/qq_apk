package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private QQCustomDialog a = null;
  private String b;
  
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
    super.doOnCreate(paramBundle);
    super.setContentView(2131625527);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {
      this.b = getIntent().getExtras().getString("uin");
    } else {
      this.b = null;
    }
    if (TextUtils.isEmpty(this.b))
    {
      finish();
      return false;
    }
    paramBundle = this.a;
    if ((paramBundle != null) && (paramBundle.isShowing())) {
      this.a.dismiss();
    }
    paramBundle = HardCodeUtil.a(2131905732);
    this.a = null;
    this.a = DialogUtil.a(this, 230);
    this.a.setContentView(2131624587);
    this.a.setTitle(null).setMessage(getString(2131892408)).setPositiveButton(2131892407, new PCActiveNoticeActiviy.1(this));
    this.a.setTextContentDescription(paramBundle);
    this.a.setOnKeyListener(new PCActiveNoticeActiviy.2(this));
    this.a.show();
    ReportController.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    QQCustomDialog localQQCustomDialog = this.a;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.finish();
  }
  
  public void onBackPressed() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */