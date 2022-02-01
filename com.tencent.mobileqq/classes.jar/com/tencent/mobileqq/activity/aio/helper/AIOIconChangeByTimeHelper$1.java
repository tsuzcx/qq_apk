package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

class AIOIconChangeByTimeHelper$1
  implements Runnable
{
  AIOIconChangeByTimeHelper$1(AIOIconChangeByTimeHelper paramAIOIconChangeByTimeHelper) {}
  
  public void run()
  {
    synchronized (AIOIconChangeByTimeHelper.a(this.this$0))
    {
      if (AIOIconChangeByTimeHelper.a(this.this$0) != null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.TIME_TICK");
        localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        localIntentFilter.addAction("android.intent.action.TIME_SET");
        AIOIconChangeByTimeHelper.a(this.this$0).a.registerReceiver(AIOIconChangeByTimeHelper.a(this.this$0), localIntentFilter);
        AIOIconChangeByTimeHelper.a(this.this$0).set(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.1
 * JD-Core Version:    0.7.0.1
 */