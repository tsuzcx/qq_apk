package com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ReadInJoyAdHomeWatcher$InnerRecevier
  extends BroadcastReceiver
{
  ReadInJoyAdHomeWatcher$InnerRecevier(ReadInJoyAdHomeWatcher paramReadInJoyAdHomeWatcher) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (ReadInJoyAdHomeWatcher.a(this.a) != null))
      {
        if (!paramContext.equals("homekey")) {
          break label55;
        }
        ReadInJoyAdHomeWatcher.a(this.a).a();
      }
    }
    label55:
    while (!paramContext.equals("recentapps")) {
      return;
    }
    ReadInJoyAdHomeWatcher.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher.ReadInJoyAdHomeWatcher.InnerRecevier
 * JD-Core Version:    0.7.0.1
 */