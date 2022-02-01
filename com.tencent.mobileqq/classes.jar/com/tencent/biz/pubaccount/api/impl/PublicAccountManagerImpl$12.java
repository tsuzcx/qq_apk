package com.tencent.biz.pubaccount.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PublicAccountManagerImpl$12
  extends BroadcastReceiver
{
  PublicAccountManagerImpl$12(PublicAccountManagerImpl paramPublicAccountManagerImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.mPicSource == 2)
    {
      int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.picResultData", -1);
      paramIntent = paramIntent.getStringArrayListExtra("com.tencent.biz.pubaccount.picResult_md5s");
      this.a.reportEventTypeMenuEvent(null, 0, 14, i, paramIntent);
    }
    try
    {
      paramContext.unregisterReceiver(this.a.picResultReceiver);
      label50:
      paramContext = this.a;
      paramContext.picResultReceiver = null;
      paramContext.mPicSource = 0;
      return;
    }
    catch (Exception paramContext)
    {
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.12
 * JD-Core Version:    0.7.0.1
 */