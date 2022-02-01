package com.dataline.activities;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import anzj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cv;

public class PrinterDefaultActivity
  extends IphoneTitleBarActivity
{
  private void a()
  {
    ((TextView)findViewById(2131369042)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131369073);
    localTextView.setVisibility(0);
    localTextView.setText(anzj.a(2131707302));
    localTextView.setOnClickListener(new cv(this));
  }
  
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
    super.getWindow().setBackgroundDrawableResource(2131165429);
    setContentView(2131559048);
    setTitle(2131691195);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */