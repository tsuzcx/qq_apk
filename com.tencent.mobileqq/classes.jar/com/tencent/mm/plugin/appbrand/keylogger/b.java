package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class b
  extends Activity
{
  private TextView b;
  
  protected abstract int a();
  
  protected void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  protected void b()
  {
    setContentView(2131624029);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131431322);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    int i = a();
    if ((!a) && (i == 0)) {
      throw new AssertionError();
    }
    localLayoutInflater.inflate(i, localFrameLayout);
    this.b = ((TextView)findViewById(2131427582));
    findViewById(2131427584).setOnClickListener(new b.1(this));
  }
  
  protected void c()
  {
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.b
 * JD-Core Version:    0.7.0.1
 */