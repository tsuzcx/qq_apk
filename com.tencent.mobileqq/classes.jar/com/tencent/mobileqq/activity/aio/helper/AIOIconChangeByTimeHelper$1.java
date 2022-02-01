package com.tencent.mobileqq.activity.aio.helper;

import agsp;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$1
  implements Runnable
{
  public AIOIconChangeByTimeHelper$1(agsp paramagsp) {}
  
  public void run()
  {
    synchronized (agsp.a(this.this$0))
    {
      if (agsp.a(this.this$0) != null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.TIME_TICK");
        localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        localIntentFilter.addAction("android.intent.action.TIME_SET");
        agsp.a(this.this$0).a.registerReceiver(agsp.a(this.this$0), localIntentFilter);
        agsp.a(this.this$0).set(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.1
 * JD-Core Version:    0.7.0.1
 */