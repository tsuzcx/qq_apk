package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;

class WSPlayerManager$MediaPlayListenerAdapterImpl$2
  implements Runnable
{
  WSPlayerManager$MediaPlayListenerAdapterImpl$2(WSPlayerManager.MediaPlayListenerAdapterImpl paramMediaPlayListenerAdapterImpl) {}
  
  public void run()
  {
    if ((WSPlayerManager.d(this.a.a) != null) && (WSPlayerManager.d(this.a.a).k != null)) {
      WSPlayerManager.d(this.a.a).k.j(WSPlayerManager.d(this.a.a));
    }
    if (WSPlayerManager.j(this.a.a) != null)
    {
      Iterator localIterator = WSPlayerManager.j(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((WSPlayerStatusListener)localIterator.next()).c(WSPlayerManager.d(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2
 * JD-Core Version:    0.7.0.1
 */