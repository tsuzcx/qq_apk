package com.tencent.biz.pubaccount.weishi_new.player;

import vfs;
import vfz;
import vgb;
import vmp;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$1
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$1(vfz paramvfz) {}
  
  public void run()
  {
    vfs localvfs;
    vgb localvgb;
    boolean bool2;
    if ((WSPlayerManager.a(this.a.a) != null) && (WSPlayerManager.a(this.a.a).a != null))
    {
      localvfs = WSPlayerManager.a(this.a.a).a;
      localvgb = WSPlayerManager.a(this.a.a);
      bool2 = WSPlayerManager.b(this.a.a);
      if (WSPlayerManager.c(this.a.a)) {
        break label135;
      }
    }
    label135:
    for (boolean bool1 = true;; bool1 = false)
    {
      localvfs.a(localvgb, bool2, bool1);
      vmp.g("WS_VIDEO_PRE_PLAY", "<=============================== [WSPlayerManager.java][onPrePlayFinished] title:" + WSPlayerManager.a(this.a.a, WSPlayerManager.a(this.a.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */