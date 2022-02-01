package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GBatteryMonitor
{
  private static String b = "GBatteryMonitor";
  BroadcastReceiver a = new GBatteryMonitor.1(this);
  private VideoAppInterface c;
  private boolean d;
  
  public GBatteryMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.c = paramVideoAppInterface;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    if (this.c.getApplication().registerReceiver(this.a, localIntentFilter) != null) {
      this.d = true;
    }
  }
  
  public void b()
  {
    try
    {
      if (this.d)
      {
        this.c.getApplication().unregisterReceiver(this.a);
        this.d = false;
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.d(b, 1, "video exit IllegalArgumentException ", localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GBatteryMonitor
 * JD-Core Version:    0.7.0.1
 */