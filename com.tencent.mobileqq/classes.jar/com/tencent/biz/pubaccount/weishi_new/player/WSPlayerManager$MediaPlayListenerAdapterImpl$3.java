package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import urr;
import uru;
import urw;
import uya;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$3
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$3(urr paramurr) {}
  
  public void run()
  {
    this.a.a.b(WSPlayerManager.b(this.a.a), false);
    Object localObject = WSPlayerManager.a(this.a.a);
    if (localObject != null)
    {
      WSPlayerManager.b(this.a.a);
      ((urw)localObject).i();
      ((urw)localObject).j();
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][checkPlayerLoop] mReplayCount:" + WSPlayerManager.c(this.a.a));
    }
    if (WSPlayerManager.a(this.a.a) != null)
    {
      localObject = WSPlayerManager.a(this.a.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((uru)((Iterator)localObject).next()).a(WSPlayerManager.b(this.a.a), WSPlayerManager.c(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3
 * JD-Core Version:    0.7.0.1
 */