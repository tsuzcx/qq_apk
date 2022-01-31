package com.tencent.biz.pubaccount.weishi_new.player;

import thf;
import thl;

public class WSPlayerManager$1
  implements Runnable
{
  WSPlayerManager$1(WSPlayerManager paramWSPlayerManager, thl paramthl) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.c(this.a);
      if (!this.this$0.b()) {
        break label53;
      }
      this.a.a.e(this.a);
    }
    label53:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */