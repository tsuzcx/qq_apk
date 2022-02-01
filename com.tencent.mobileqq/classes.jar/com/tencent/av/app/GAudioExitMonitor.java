package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GAudioExitMonitor
{
  private VideoAppInterface a;
  private BroadcastReceiver b;
  private boolean c;
  
  public GAudioExitMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
    this.b = new GAudioExitMonitor.AudioExitReceiver(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioExitMonitor", 2, "regist QQ Process Exit Receiver1");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.EXIT_VIDEO_PROCESS");
    if (this.a.getApplication().registerReceiver(this.b, localIntentFilter) != null) {
      this.c = true;
    }
  }
  
  public void b()
  {
    if (this.c)
    {
      this.a.getApplication().unregisterReceiver(this.b);
      this.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAudioExitMonitor
 * JD-Core Version:    0.7.0.1
 */