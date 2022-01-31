package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import thf;
import thl;
import thm;
import tho;

class WSPlayerManager$5
  implements Runnable
{
  WSPlayerManager$5(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if ((WSPlayerManager.a(this.this$0) != null) && ((WSPlayerManager.a(this.this$0).e() == 5) || (WSPlayerManager.a(this.this$0).e() == 2)))
    {
      WSPlayerManager.a(this.this$0).b();
      if (WSPlayerManager.b(this.this$0).a != null) {
        WSPlayerManager.b(this.this$0).a.f(WSPlayerManager.b(this.this$0));
      }
      if (WSPlayerManager.a(this.this$0) != null)
      {
        Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((thm)localIterator.next()).e(WSPlayerManager.b(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.5
 * JD-Core Version:    0.7.0.1
 */