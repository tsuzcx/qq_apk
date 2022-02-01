package com.tencent.biz.pubaccount.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PublicAccountManagerImpl$13
  extends BroadcastReceiver
{
  PublicAccountManagerImpl$13(PublicAccountManagerImpl paramPublicAccountManagerImpl, String paramString, boolean paramBoolean) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    double d1 = Double.parseDouble(paramIntent.getStringExtra("latitude"));
    double d2 = Double.parseDouble(paramIntent.getStringExtra("longitude"));
    paramIntent = paramIntent.getStringExtra("name");
    this.c.reportEventTypeMenuEventLocation(d1, d2, paramIntent, this.a, this.b);
    try
    {
      paramContext.unregisterReceiver(this.c.locationResultReceiver);
      label58:
      this.c.locationResultReceiver = null;
      return;
    }
    catch (Exception paramContext)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.13
 * JD-Core Version:    0.7.0.1
 */