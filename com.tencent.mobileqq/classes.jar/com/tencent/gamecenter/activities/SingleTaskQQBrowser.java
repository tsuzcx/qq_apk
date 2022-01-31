package com.tencent.gamecenter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class SingleTaskQQBrowser
  extends QQBrowserActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("from_single_task", true);
    QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnNewIntent");
    if (paramIntent.getBooleanExtra("force_no_reload", false)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (i != 0)
      {
        String str = paramIntent.getStringExtra("url");
        Object localObject = a();
        if (localObject == null) {
          break label92;
        }
        localObject = ((WebView)localObject).getUrl();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          j = i;
          if (((String)localObject).equals(str)) {
            break label74;
          }
        }
      }
      label74:
      label92:
      for (j = 0;; j = 0)
      {
        if (j == 0)
        {
          paramIntent.putExtra("from_single_task", true);
          super.doOnNewIntent(paramIntent);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.SingleTaskQQBrowser
 * JD-Core Version:    0.7.0.1
 */