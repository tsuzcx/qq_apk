package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;

class GBatteryMonitor$1
  extends BroadcastReceiver
{
  GBatteryMonitor$1(GBatteryMonitor paramGBatteryMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((GBatteryMonitor.a(this.a) != null) && (GBatteryMonitor.a(this.a).e != null))
    {
      ((VideoNodeReporter)GBatteryMonitor.a(this.a).c(4)).a(i);
      VideoNodeManager.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GBatteryMonitor.1
 * JD-Core Version:    0.7.0.1
 */