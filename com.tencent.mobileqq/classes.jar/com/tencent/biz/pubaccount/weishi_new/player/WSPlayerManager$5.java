package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$5
  implements Runnable
{
  WSPlayerManager$5(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if ((WSPlayerManager.l(this.this$0) != null) && ((WSPlayerManager.l(this.this$0).E() == 5) || (WSPlayerManager.l(this.this$0).E() == 2)))
    {
      WSPlayerManager.l(this.this$0).f();
      if (WSPlayerManager.d(this.this$0).k != null) {
        WSPlayerManager.d(this.this$0).k.f(WSPlayerManager.d(this.this$0));
      }
      if (WSPlayerManager.j(this.this$0) != null)
      {
        Iterator localIterator = WSPlayerManager.j(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((WSPlayerStatusListener)localIterator.next()).e(WSPlayerManager.d(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.5
 * JD-Core Version:    0.7.0.1
 */