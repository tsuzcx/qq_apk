package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ShareResultActivity
  extends Activity
{
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
    try
    {
      paramBundle = getIntent();
      if (paramBundle == null)
      {
        finish();
        return;
      }
      if (paramBundle.getIntExtra("start_flag", -1) == 0)
      {
        finish();
        return;
      }
      String str = paramBundle.getAction();
      if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(str)) {
        paramBundle.setClass(this, ShareTransActivity.class);
      } else if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY".equals(str)) {
        paramBundle.setClass(this, ShareStoryActivity.class);
      }
      startActivity(paramBundle);
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareResultActivity
 * JD-Core Version:    0.7.0.1
 */