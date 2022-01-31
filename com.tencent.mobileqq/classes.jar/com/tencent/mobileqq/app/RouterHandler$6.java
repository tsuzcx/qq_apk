package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.Session;
import java.util.HashMap;

class RouterHandler$6
  implements Runnable
{
  RouterHandler$6(RouterHandler paramRouterHandler, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    Session localSession = (Session)this.this$0.e.get(Long.valueOf(this.a));
    this.this$0.a(1, localSession, (float)((float)this.b * 1.0D / (float)this.c), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.6
 * JD-Core Version:    0.7.0.1
 */