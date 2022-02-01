package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class OverloadTipsActivity
  extends BaseActivity
{
  private QQCustomDialog a = null;
  
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
    super.setContentView(2131559505);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {
      paramBundle = getIntent().getExtras().getString("msg");
    } else {
      paramBundle = null;
    }
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    QQCustomDialog localQQCustomDialog = this.a;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    this.a = DialogUtil.a(this, 230);
    this.a.setContentView(2131558954);
    this.a.setTitle(null).setMessage(paramBundle).setPositiveButton(2131694674, new OverloadTipsActivity.1(this));
    this.a.setTextContentDescription(paramBundle);
    this.a.setOnKeyListener(new OverloadTipsActivity.2(this));
    this.a.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.OverloadTipsActivity
 * JD-Core Version:    0.7.0.1
 */