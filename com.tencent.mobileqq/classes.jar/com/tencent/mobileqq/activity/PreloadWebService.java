package com.tencent.mobileqq.activity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.io.File;
import mqq.app.MobileQQ;
import tlc;

public class PreloadWebService
  extends Service
{
  private CustomWebView a;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      return paramInt1;
    }
    String str3 = paramIntent.getStringExtra("url");
    if (this.a == null)
    {
      this.a = new CustomWebView(getBaseContext());
      this.a.setWebViewClient(new tlc(this));
      WebSettings localWebSettings = this.a.getSettings();
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setCacheMode(-1);
      localWebSettings.setDatabaseEnabled(true);
      String str4 = MobileQQ.getMobileQQ().getProcessName();
      String str2 = "";
      String str1 = str2;
      if (str4 != null)
      {
        int i = str4.lastIndexOf(':');
        str1 = str2;
        if (i > -1) {
          str1 = "_" + str4.substring(i + 1);
        }
      }
      localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + str1, 0).getPath());
      localWebSettings.setAppCachePath(getApplicationContext().getDir("appcache" + str1, 0).getPath());
      localWebSettings.setAppCacheEnabled(true);
    }
    this.a.loadUrl(str3);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadWebService", 2, "preload url:" + str3);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PreloadWebService
 * JD-Core Version:    0.7.0.1
 */