package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import vfz;
import vgc;
import vgh;
import vmp;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$3
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$3(vfz paramvfz) {}
  
  public void run()
  {
    this.a.a.b(WSPlayerManager.b(this.a.a), false);
    Object localObject = WSPlayerManager.a(this.a.a);
    if (localObject != null)
    {
      WSPlayerManager.b(this.a.a);
      ((vgh)localObject).i();
      ((vgh)localObject).j();
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][checkPlayerLoop] mReplayCount:" + WSPlayerManager.c(this.a.a));
    }
    if (WSPlayerManager.a(this.a.a) != null)
    {
      localObject = WSPlayerManager.a(this.a.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((vgc)((Iterator)localObject).next()).a(WSPlayerManager.b(this.a.a), WSPlayerManager.c(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3
 * JD-Core Version:    0.7.0.1
 */