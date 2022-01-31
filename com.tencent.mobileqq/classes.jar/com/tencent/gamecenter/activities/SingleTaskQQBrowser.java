package com.tencent.gamecenter.activities;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class SingleTaskQQBrowser
  extends QQBrowserActivity
{
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("from_single_task", true);
    QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnNewIntent");
    if (!paramIntent.getBooleanExtra("back_from_aio", false))
    {
      paramIntent.putExtra("from_single_task", true);
      super.doOnNewIntent(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.SingleTaskQQBrowser
 * JD-Core Version:    0.7.0.1
 */