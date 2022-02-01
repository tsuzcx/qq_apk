package com.tencent.mobileqq.activity.aio.helper;

import agfn;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(agfn paramagfn) {}
  
  public void run()
  {
    synchronized (agfn.a(this.this$0))
    {
      if ((agfn.a(this.this$0).get() == 1) && (agfn.a(this.this$0) != null) && (agfn.a(this.this$0).mContext != null) && (agfn.a(this.this$0) != null))
      {
        agfn.a(this.this$0).set(0);
        agfn.a(this.this$0).mContext.unregisterReceiver(agfn.a(this.this$0));
        agfn.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */