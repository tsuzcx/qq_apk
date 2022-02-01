package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.Session;
import java.util.HashMap;

class RouterHandler$7
  implements Runnable
{
  RouterHandler$7(RouterHandler paramRouterHandler, long paramLong, int paramInt) {}
  
  public void run()
  {
    Session localSession = (Session)this.this$0.o.get(Long.valueOf(this.a));
    if ((this.b == 2) && (localSession != null)) {
      this.this$0.o.remove(Long.valueOf(this.a));
    }
    this.this$0.a(2, localSession, 0.0D, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.7
 * JD-Core Version:    0.7.0.1
 */