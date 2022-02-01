package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.mm.ui.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class OpenSDKBridgedActivity
  extends Activity
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  private void a()
  {
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    if (i >= 23) {
      i = 1;
    } else {
      i = 0;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      j = 1;
    }
    if ((i == 0) && (j == 0)) {
      return;
    }
    if (getWindow() == null) {
      return;
    }
    if (i != 0)
    {
      a.a(getWindow());
      a.c(getWindow(), true);
    }
    if (j != 0)
    {
      a.b(getWindow());
      a.d(getWindow(), true);
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973840);
    super.onCreate(paramBundle);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    setResult(-1);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.OpenSDKBridgedActivity
 * JD-Core Version:    0.7.0.1
 */