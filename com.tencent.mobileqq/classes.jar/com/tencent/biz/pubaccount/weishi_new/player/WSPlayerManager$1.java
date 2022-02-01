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
    if (WSPlayerManager.a(this.this$0) != null)
    {
      localObject = WSPlayerManager.a(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WSPlayerStatusListener)((Iterator)localObject).next()).f(this.a);
      }
    }
    if (this.a.a != null)
    {
      this.a.a.c(this.a);
      if (this.this$0.b())
      {
        this.a.a.e(this.a);
        return;
      }
      if (this.this$0.g())
      {
        this.a.a.h(this.a);
        return;
      }
      if (this.this$0.d()) {
        this.a.a.j(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */