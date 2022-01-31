package com.tencent.mobileqq.activity.aio.helper;

import acvp;
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(acvp paramacvp) {}
  
  public void run()
  {
    synchronized (acvp.a(this.this$0))
    {
      if ((acvp.a(this.this$0).get() == 1) && (acvp.a(this.this$0) != null) && (acvp.a(this.this$0).a != null) && (acvp.a(this.this$0) != null))
      {
        acvp.a(this.this$0).set(0);
        acvp.a(this.this$0).a.unregisterReceiver(acvp.a(this.this$0));
        acvp.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */