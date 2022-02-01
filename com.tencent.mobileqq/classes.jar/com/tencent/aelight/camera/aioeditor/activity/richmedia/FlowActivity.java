package com.tencent.aelight.camera.aioeditor.activity.richmedia;

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
  protected ViewGroup a;
  protected int b;
  protected boolean c = true;
  
  protected void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.b = paramBundle.getInt("flow_camera_height", (int)getResources().getDimension(2131297474));
  }
  
  protected abstract void a(ViewGroup paramViewGroup);
  
  public View b()
  {
    return this.a;
  }
  
  public void finish()
  {
    super.finish();
    if (this.c)
    {
      overridePendingTransition(0, 2130772018);
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(256);
    getWindow().addFlags(512);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {
      this.b = ((int)getResources().getDimension(2131297474));
    }
    a(paramBundle);
    setContentView(2131624023);
    this.a = ((ViewGroup)findViewById(2131433486));
    paramBundle = this.a;
    if (paramBundle != null) {
      a(paramBundle);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return super.onTouchEvent(paramMotionEvent);
    }
    View localView = b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.FlowActivity
 * JD-Core Version:    0.7.0.1
 */