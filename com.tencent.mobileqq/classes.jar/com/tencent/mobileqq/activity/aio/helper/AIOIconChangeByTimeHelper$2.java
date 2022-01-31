package com.tencent.mobileqq.activity.aio.helper;

import aeyo;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(aeyo paramaeyo) {}
  
  public void run()
  {
    synchronized (aeyo.a(this.this$0))
    {
      if ((aeyo.a(this.this$0).get() == 1) && (aeyo.a(this.this$0) != null) && (aeyo.a(this.this$0).a != null) && (aeyo.a(this.this$0) != null))
      {
        aeyo.a(this.this$0).set(0);
        aeyo.a(this.this$0).a.unregisterReceiver(aeyo.a(this.this$0));
        aeyo.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */