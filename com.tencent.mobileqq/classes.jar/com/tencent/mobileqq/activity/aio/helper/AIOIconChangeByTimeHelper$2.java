package com.tencent.mobileqq.activity.aio.helper;

import agjo;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(agjo paramagjo) {}
  
  public void run()
  {
    synchronized (agjo.a(this.this$0))
    {
      if ((agjo.a(this.this$0).get() == 1) && (agjo.a(this.this$0) != null) && (agjo.a(this.this$0).a != null) && (agjo.a(this.this$0) != null))
      {
        agjo.a(this.this$0).set(0);
        agjo.a(this.this$0).a.unregisterReceiver(agjo.a(this.this$0));
        agjo.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */