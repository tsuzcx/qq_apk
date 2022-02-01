package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import java.util.HashMap;
import java.util.Map;

final class WebAccelerator$1
  implements Runnable
{
  WebAccelerator$1(String paramString, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    Object localObject2 = WebAccelerator.a();
    int i;
    if (BaseOpenWebMonitor.a(this.a))
    {
      localObject1 = ((WebAccelerator)localObject2).a(this.a);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.b.putExtra("url", (String)localObject1);
        i = 1;
      }
      else
      {
        localObject1 = this.a;
      }
    }
    else
    {
      i = 0;
    }
    int j;
    if ((!WebAccelerator.a(this.c)) && (((WebAccelerator)localObject2).c((String)localObject1)))
    {
      this.b.putExtra("key_isReadModeEnabled", false);
      j = 1;
    }
    else
    {
      j = 0;
    }
    localObject1 = (Long)WebAccelerator.a((WebAccelerator)localObject2).remove(this.a);
    if ((localObject1 != null) && (SystemClock.uptimeMillis() - ((Long)localObject1).longValue() < 180000L))
    {
      ((WebAccelerator)localObject2).e("bank_download_key");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("count", "1");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOWebPreDownloadHit", false, 0L, 0L, (HashMap)localObject1, "", false);
    }
    if ((j != 0) || (i != 0))
    {
      ((WebAccelerator)localObject2).e("bankSize");
      localObject1 = WebAccelerator.a().b();
      localObject2 = ((SharedPreferences)localObject1).edit();
      if (i != 0) {
        ((SharedPreferences.Editor)localObject2).putInt("hit_shortLink", ((SharedPreferences)localObject1).getInt("hit_shortLink", 0) + 1);
      }
      if (j != 0) {
        ((SharedPreferences.Editor)localObject2).putInt("hit_safeCheck", ((SharedPreferences)localObject1).getInt("hit_safeCheck", 0) + 1);
      }
      ((SharedPreferences.Editor)localObject2).commit();
    }
    if (!WebAccelerator.b(this.c, this.a, this.b))
    {
      if (this.b.getBooleanExtra("is_public_account", false))
      {
        localObject1 = new ActivityURIRequest(this.c, "/pubaccount/browser");
        ((ActivityURIRequest)localObject1).extra().putAll(this.b.getExtras());
        QRoute.startUri((URIRequest)localObject1, null);
        return;
      }
      this.c.startActivity(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.WebAccelerator.1
 * JD-Core Version:    0.7.0.1
 */