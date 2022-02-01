package com.tencent.biz.pubaccount.weishi_new.player;

import urk;
import urr;
import urt;
import uya;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$1
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$1(urr paramurr) {}
  
  public void run()
  {
    urk localurk;
    urt localurt;
    boolean bool2;
    if ((WSPlayerManager.a(this.a.a) != null) && (WSPlayerManager.a(this.a.a).a != null))
    {
      localurk = WSPlayerManager.a(this.a.a).a;
      localurt = WSPlayerManager.a(this.a.a);
      bool2 = WSPlayerManager.b(this.a.a);
      if (WSPlayerManager.c(this.a.a)) {
        break label135;
      }
    }
    label135:
    for (boolean bool1 = true;; bool1 = false)
    {
      localurk.a(localurt, bool2, bool1);
      uya.g("WS_VIDEO_PRE_PLAY", "<=============================== [WSPlayerManager.java][onPrePlayFinished] title:" + WSPlayerManager.a(this.a.a, WSPlayerManager.a(this.a.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */