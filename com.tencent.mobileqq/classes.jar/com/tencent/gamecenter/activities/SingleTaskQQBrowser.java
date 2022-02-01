package com.tencent.gamecenter.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

public class SingleTaskQQBrowser
  extends QQBrowserActivity
{
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
    getIntent().putExtra("from_single_task", true);
    QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnNewIntent");
    int j = 0;
    boolean bool = paramIntent.getBooleanExtra("force_no_reload", false);
    if (bool)
    {
      String str = paramIntent.getStringExtra("url");
      Object localObject = getHostWebView();
      i = j;
      if (localObject == null) {
        break label80;
      }
      localObject = ((WebView)localObject).getUrl();
      i = j;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label80;
      }
      if (!((String)localObject).equals(str))
      {
        i = j;
        break label80;
      }
    }
    int i = bool;
    label80:
    if (i == 0)
    {
      paramIntent.putExtra("from_single_task", true);
      super.doOnNewIntent(paramIntent);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.SingleTaskQQBrowser
 * JD-Core Version:    0.7.0.1
 */