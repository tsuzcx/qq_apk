package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  AIOIconChangeByTimeHelper$2(AIOIconChangeByTimeHelper paramAIOIconChangeByTimeHelper) {}
  
  public void run()
  {
    synchronized (AIOIconChangeByTimeHelper.a(this.this$0))
    {
      if ((AIOIconChangeByTimeHelper.d(this.this$0).get() == 1) && (AIOIconChangeByTimeHelper.b(this.this$0) != null) && (AIOIconChangeByTimeHelper.b(this.this$0).e != null) && (AIOIconChangeByTimeHelper.c(this.this$0) != null))
      {
        AIOIconChangeByTimeHelper.d(this.this$0).set(0);
        AIOIconChangeByTimeHelper.b(this.this$0).e.unregisterReceiver(AIOIconChangeByTimeHelper.c(this.this$0));
        AIOIconChangeByTimeHelper.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */