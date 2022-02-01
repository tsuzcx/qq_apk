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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][switchPlayerVideoViewLayout] endTime:");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    if (WSPlayerManager.j(this.this$0) != null)
    {
      localObject = WSPlayerManager.j(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WSPlayerStatusListener)((Iterator)localObject).next()).f(this.a);
      }
    }
    if (this.a.k != null)
    {
      this.a.k.c(this.a);
      if (this.this$0.f())
      {
        this.a.k.e(this.a);
        return;
      }
      if (this.this$0.k())
      {
        this.a.k.h(this.a);
        return;
      }
      if (this.this$0.h()) {
        this.a.k.j(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */