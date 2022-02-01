package com.tencent.mobileqq.activity.richmedia;

import Override;
import alpv;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class FlowActivity
  extends PeakActivity
{
  protected int a;
  protected ViewGroup a;
  protected boolean a;
  
  public FlowActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected alpv a()
  {
    return null;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramBundle.getInt("flow_camera_height", (int)getResources().getDimension(2131297090));
  }
  
  protected abstract void a(ViewGroup paramViewGroup);
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean)
    {
      overridePendingTransition(0, 2130772001);
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(256);
    getWindow().addFlags(512);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {
      this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131297090));
    }
    a(paramBundle);
    setContentView(2131558451);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131367062));
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    paramBundle = a();
    if (paramBundle != null) {
      paramBundle.a((ViewGroup)findViewById(2131367042));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return super.onTouchEvent(paramMotionEvent);
    }
    View localView = a();
    if (localView == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = localView.getTop();
    if (paramMotionEvent.getY() < i) {
      onBackPressed();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowActivity
 * JD-Core Version:    0.7.0.1
 */