package com.tencent.mobileqq.activity.aio.helper;

import adgk;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(adgk paramadgk) {}
  
  public void run()
  {
    synchronized (adgk.a(this.this$0))
    {
      if ((adgk.a(this.this$0).get() == 1) && (adgk.a(this.this$0) != null) && (adgk.a(this.this$0).a != null) && (adgk.a(this.this$0) != null))
      {
        adgk.a(this.this$0).set(0);
        adgk.a(this.this$0).a.unregisterReceiver(adgk.a(this.this$0));
        adgk.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */