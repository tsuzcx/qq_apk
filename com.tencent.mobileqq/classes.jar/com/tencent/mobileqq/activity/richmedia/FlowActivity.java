package com.tencent.mobileqq.activity.richmedia;

import ahhm;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;

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
  
  protected ahhm a()
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
    this.jdField_a_of_type_Int = paramBundle.getInt("flow_camera_height", (int)getResources().getDimension(2131165878));
  }
  
  protected abstract void a(ViewGroup paramViewGroup);
  
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(256);
    getWindow().addFlags(512);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {
      this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131165878));
    }
    a(paramBundle);
    setContentView(2131492907);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131300883));
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    paramBundle = a();
    if (paramBundle != null) {
      paramBundle.a((ViewGroup)a(2131300863));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowActivity
 * JD-Core Version:    0.7.0.1
 */