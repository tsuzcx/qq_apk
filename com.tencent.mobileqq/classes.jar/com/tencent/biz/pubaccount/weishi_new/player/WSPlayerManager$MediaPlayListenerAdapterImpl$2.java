package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import ukp;
import ukx;
import ukz;
import ula;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$2
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$2(ukx paramukx) {}
  
  public void run()
  {
    if ((WSPlayerManager.b(this.a.a) != null) && (WSPlayerManager.b(this.a.a).a != null)) {
      WSPlayerManager.b(this.a.a).a.j(WSPlayerManager.b(this.a.a));
    }
    if (WSPlayerManager.a(this.a.a) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((ula)localIterator.next()).c(WSPlayerManager.b(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2
 * JD-Core Version:    0.7.0.1
 */