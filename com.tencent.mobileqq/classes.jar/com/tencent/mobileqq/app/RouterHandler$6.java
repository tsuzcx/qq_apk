package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.Session;
import java.util.HashMap;

class RouterHandler$6
  implements Runnable
{
  RouterHandler$6(RouterHandler paramRouterHandler, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    Session localSession = (Session)this.this$0.o.get(Long.valueOf(this.a));
    RouterHandler localRouterHandler = this.this$0;
    double d1 = (float)this.b;
    Double.isNaN(d1);
    double d2 = (float)this.c;
    Double.isNaN(d2);
    localRouterHandler.a(1, localSession, (float)(d1 * 1.0D / d2), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.6
 * JD-Core Version:    0.7.0.1
 */