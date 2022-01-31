package com.tencent.mobileqq.activity.aio.helper;

import afdd;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(afdd paramafdd) {}
  
  public void run()
  {
    synchronized (afdd.a(this.this$0))
    {
      if ((afdd.a(this.this$0).get() == 1) && (afdd.a(this.this$0) != null) && (afdd.a(this.this$0).a != null) && (afdd.a(this.this$0) != null))
      {
        afdd.a(this.this$0).set(0);
        afdd.a(this.this$0).a.unregisterReceiver(afdd.a(this.this$0));
        afdd.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */