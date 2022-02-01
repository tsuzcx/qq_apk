package com.tencent.mobileqq.activity;

import Override;
import aenv;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import antf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ForceLogoutActivity
  extends BaseActivity
  implements antf
{
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
    super.setContentView(2131559175);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("msg");
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      ((TextView)findViewById(2131379628)).setText(paramBundle);
    }
    if ((str != null) && (str.length() > 0)) {
      ((TextView)findViewById(2131379629)).setText(str);
    }
    ((Button)findViewById(2131363693)).setOnClickListener(new aenv(this));
    return true;
  }
  
  public boolean onBackEvent()
  {
    finish();
    startActivity(new Intent(this, LoginActivity.class).addFlags(67108864));
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForceLogoutActivity
 * JD-Core Version:    0.7.0.1
 */