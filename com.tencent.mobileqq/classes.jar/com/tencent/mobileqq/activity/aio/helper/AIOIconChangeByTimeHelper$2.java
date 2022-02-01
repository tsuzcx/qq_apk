package com.tencent.mobileqq.activity.aio.helper;

import agsp;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(agsp paramagsp) {}
  
  public void run()
  {
    synchronized (agsp.a(this.this$0))
    {
      if ((agsp.a(this.this$0).get() == 1) && (agsp.a(this.this$0) != null) && (agsp.a(this.this$0).a != null) && (agsp.a(this.this$0) != null))
      {
        agsp.a(this.this$0).set(0);
        agsp.a(this.this$0).a.unregisterReceiver(agsp.a(this.this$0));
        agsp.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */