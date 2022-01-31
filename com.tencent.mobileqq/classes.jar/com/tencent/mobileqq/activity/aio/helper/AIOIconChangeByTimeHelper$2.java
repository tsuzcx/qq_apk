package com.tencent.mobileqq.activity.aio.helper;

import adgn;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(adgn paramadgn) {}
  
  public void run()
  {
    synchronized (adgn.a(this.this$0))
    {
      if ((adgn.a(this.this$0).get() == 1) && (adgn.a(this.this$0) != null) && (adgn.a(this.this$0).a != null) && (adgn.a(this.this$0) != null))
      {
        adgn.a(this.this$0).set(0);
        adgn.a(this.this$0).a.unregisterReceiver(adgn.a(this.this$0));
        adgn.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */