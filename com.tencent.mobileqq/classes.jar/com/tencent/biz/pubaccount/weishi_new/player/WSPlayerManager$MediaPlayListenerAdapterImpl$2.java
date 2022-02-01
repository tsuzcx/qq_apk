package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$MediaPlayListenerAdapterImpl$2
  implements Runnable
{
  WSPlayerManager$MediaPlayListenerAdapterImpl$2(WSPlayerManager.MediaPlayListenerAdapterImpl paramMediaPlayListenerAdapterImpl) {}
  
  public void run()
  {
    if ((WSPlayerManager.b(this.a.a) != null) && (WSPlayerManager.b(this.a.a).a != null)) {
      WSPlayerManager.b(this.a.a).a.j(WSPlayerManager.b(this.a.a));
    }
    if (WSPlayerManager.a(this.a.a) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((WSPlayerStatusListener)localIterator.next()).c(WSPlayerManager.b(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2
 * JD-Core Version:    0.7.0.1
 */