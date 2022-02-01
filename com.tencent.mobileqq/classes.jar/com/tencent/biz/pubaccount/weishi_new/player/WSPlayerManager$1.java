package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import ukp;
import ukz;
import ula;

public class WSPlayerManager$1
  implements Runnable
{
  WSPlayerManager$1(WSPlayerManager paramWSPlayerManager, ukz paramukz) {}
  
  public void run()
  {
    if (WSPlayerManager.a(this.this$0) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((ula)localIterator.next()).f(this.a);
      }
    }
    if (this.a.a != null)
    {
      this.a.a.c(this.a);
      if (!this.this$0.b()) {
        break label104;
      }
      this.a.a.e(this.a);
    }
    label104:
    do
    {
      return;
      if (this.this$0.g())
      {
        this.a.a.h(this.a);
        return;
      }
    } while (!this.this$0.d());
    this.a.a.j(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */