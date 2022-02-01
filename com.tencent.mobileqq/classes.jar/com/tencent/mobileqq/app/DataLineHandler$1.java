package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class DataLineHandler$1
  extends BroadcastReceiver
{
  DataLineHandler$1(DataLineHandler paramDataLineHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTABLE")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_EJECT")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED"))) {
      this.a.k(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.1
 * JD-Core Version:    0.7.0.1
 */