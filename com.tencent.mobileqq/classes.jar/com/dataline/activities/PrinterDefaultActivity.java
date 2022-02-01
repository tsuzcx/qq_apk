package com.dataline.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PrinterDefaultActivity
  extends IphoneTitleBarActivity
{
  private void a()
  {
    ((TextView)findViewById(2131436180)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131436211);
    localTextView.setVisibility(0);
    localTextView.setText(HardCodeUtil.a(2131906200));
    localTextView.setOnClickListener(new PrinterDefaultActivity.1(this));
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
    super.getWindow().setBackgroundDrawableResource(2131165716);
    setContentView(2131624654);
    setTitle(2131888306);
    super.getWindow().setBackgroundDrawable(null);
    a();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */