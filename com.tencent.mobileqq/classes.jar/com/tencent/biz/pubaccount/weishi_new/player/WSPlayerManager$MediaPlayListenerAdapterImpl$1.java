package com.tencent.biz.pubaccount.weishi_new.player;

import ukp;
import ukx;
import ukz;
import uqf;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$1
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$1(ukx paramukx) {}
  
  public void run()
  {
    ukp localukp;
    ukz localukz;
    boolean bool2;
    if ((WSPlayerManager.a(this.a.a) != null) && (WSPlayerManager.a(this.a.a).a != null))
    {
      localukp = WSPlayerManager.a(this.a.a).a;
      localukz = WSPlayerManager.a(this.a.a);
      bool2 = WSPlayerManager.b(this.a.a);
      if (WSPlayerManager.c(this.a.a)) {
        break label135;
      }
    }
    label135:
    for (boolean bool1 = true;; bool1 = false)
    {
      localukp.a(localukz, bool2, bool1);
      uqf.g("WS_VIDEO_PRE_PLAY", "<=============================== [WSPlayerManager.java][onPrePlayFinished] title:" + WSPlayerManager.a(this.a.a, WSPlayerManager.a(this.a.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */