package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import urk;
import urt;
import uru;
import uya;

public class WSPlayerManager$1
  implements Runnable
{
  WSPlayerManager$1(WSPlayerManager paramWSPlayerManager, urt paramurt) {}
  
  public void run()
  {
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] endTime:" + System.currentTimeMillis());
    if (WSPlayerManager.a(this.this$0) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((uru)localIterator.next()).f(this.a);
      }
    }
    if (this.a.a != null)
    {
      this.a.a.c(this.a);
      if (!this.this$0.b()) {
        break label130;
      }
      this.a.a.e(this.a);
    }
    label130:
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