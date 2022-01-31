package com.tencent.mobileqq.activity.aio.helper;

import adgk;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$1
  implements Runnable
{
  public AIOIconChangeByTimeHelper$1(adgk paramadgk) {}
  
  public void run()
  {
    synchronized (adgk.a(this.this$0))
    {
      if (adgk.a(this.this$0) != null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.TIME_TICK");
        localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        localIntentFilter.addAction("android.intent.action.TIME_SET");
        adgk.a(this.this$0).a.registerReceiver(adgk.a(this.this$0), localIntentFilter);
        adgk.a(this.this$0).set(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.1
 * JD-Core Version:    0.7.0.1
 */