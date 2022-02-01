package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

class BaseActivity2$MyScreenReceiver
  extends BroadcastReceiver
{
  private BaseActivity2$MyScreenReceiver(BaseActivity2 paramBaseActivity2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      BaseActivity2.v = false;
      GesturePWDUtils.setAppForground(paramContext, BaseActivity2.v);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
    {
      BaseActivity2.v = GesturePWDUtils.isAppOnForegroundByTasks(paramContext, 0);
      GesturePWDUtils.setAppForground(paramContext, BaseActivity2.v);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2.MyScreenReceiver
 * JD-Core Version:    0.7.0.1
 */