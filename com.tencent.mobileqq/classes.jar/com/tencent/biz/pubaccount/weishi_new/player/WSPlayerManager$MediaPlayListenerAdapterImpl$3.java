package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$MediaPlayListenerAdapterImpl$3
  implements Runnable
{
  WSPlayerManager$MediaPlayListenerAdapterImpl$3(WSPlayerManager.MediaPlayListenerAdapterImpl paramMediaPlayListenerAdapterImpl) {}
  
  public void run()
  {
    this.a.a.b(WSPlayerManager.d(this.a.a), false);
    Object localObject = WSPlayerManager.l(this.a.a);
    if (localObject != null)
    {
      WSPlayerManager.m(this.a.a);
      ((WSPlayerWrapper)localObject).C();
      ((WSPlayerWrapper)localObject).D();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSPlayerManager.java][checkPlayerLoop] mReplayCount:");
      ((StringBuilder)localObject).append(WSPlayerManager.n(this.a.a));
      WSLog.d("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    }
    if (WSPlayerManager.j(this.a.a) != null)
    {
      localObject = WSPlayerManager.j(this.a.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WSPlayerStatusListener)((Iterator)localObject).next()).a(WSPlayerManager.d(this.a.a), WSPlayerManager.n(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3
 * JD-Core Version:    0.7.0.1
 */