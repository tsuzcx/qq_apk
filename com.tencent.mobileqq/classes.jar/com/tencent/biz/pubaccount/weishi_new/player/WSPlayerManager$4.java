package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$4
  implements Runnable
{
  WSPlayerManager$4(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if ((WSPlayerManager.l(this.this$0) != null) && (WSPlayerManager.d(this.this$0).b != null))
    {
      if (WSPlayerManager.d(this.this$0).k != null) {
        WSPlayerManager.d(this.this$0).k.d(WSPlayerManager.d(this.this$0));
      }
      if (WSPlayerManager.j(this.this$0) != null)
      {
        Iterator localIterator = WSPlayerManager.j(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((WSPlayerStatusListener)localIterator.next()).b(WSPlayerManager.d(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.4
 * JD-Core Version:    0.7.0.1
 */