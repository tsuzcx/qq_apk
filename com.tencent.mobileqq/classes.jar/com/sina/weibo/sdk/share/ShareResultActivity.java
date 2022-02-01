package com.sina.weibo.sdk.share;

import Override;
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      if (paramBundle.getIntExtra("start_flag", -1) != 0) {
        break label44;
      }
      finish();
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    finish();
    return;
    label44:
    String str = paramBundle.getAction();
    if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(str)) {
      paramBundle.setClass(this, ShareTransActivity.class);
    }
    for (;;)
    {
      startActivity(paramBundle);
      break;
      if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY".equals(str)) {
        paramBundle.setClass(this, ShareStoryActivity.class);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareResultActivity
 * JD-Core Version:    0.7.0.1
 */