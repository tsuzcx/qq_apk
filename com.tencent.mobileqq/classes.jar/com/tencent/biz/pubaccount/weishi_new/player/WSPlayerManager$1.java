package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$1
  implements Runnable
{
  WSPlayerManager$1(WSPlayerManager paramWSPlayerManager, WSPlayerParam paramWSPlayerParam) {}
  
  public void run()
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] endTime:" + System.currentTimeMillis());
    if (WSPlayerManager.a(this.this$0) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((WSPlayerStatusListener)localIterator.next()).f(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */