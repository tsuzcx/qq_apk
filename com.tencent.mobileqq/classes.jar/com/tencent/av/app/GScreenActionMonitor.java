package com.tencent.av.app;

import android.content.Context;
import android.content.IntentFilter;
import mqq.app.MobileQQ;

public class GScreenActionMonitor
{
  private VideoAppInterface a;
  private GScreenActionMonitor.ScreenActionReceiver b;
  
  public GScreenActionMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  public void a()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.b = new GScreenActionMonitor.ScreenActionReceiver();
      if (this.a != null)
      {
        this.a.getApplication().getApplicationContext().registerReceiver(this.b, localIntentFilter);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      if ((this.a != null) && (this.b != null))
      {
        this.a.getApplication().getApplicationContext().unregisterReceiver(this.b);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GScreenActionMonitor
 * JD-Core Version:    0.7.0.1
 */