package com.tencent.biz;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private String a;
  private String b = "";
  private JoinGroupHandler c;
  private long d;
  private JoinGroupTransitActivity.UIHandler e;
  private int f;
  
  private void a()
  {
    try
    {
      this.a = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.a)) {
        finish();
      }
      this.e = new JoinGroupTransitActivity.UIHandler(this);
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.a);
      this.b = localJumpAction.b("activity_titile_name");
      this.d = Long.valueOf(localJumpAction.b("group_code")).longValue();
      this.f = Integer.valueOf(localJumpAction.b("subsource_id")).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
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
    super.doOnCreate(paramBundle);
    a();
    this.c = new JoinGroupHandler(this, this.app, this.f, this.b, new JoinGroupTransitActivity.1(this));
    this.c.a();
    this.e.sendEmptyMessage(0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.c.b();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */