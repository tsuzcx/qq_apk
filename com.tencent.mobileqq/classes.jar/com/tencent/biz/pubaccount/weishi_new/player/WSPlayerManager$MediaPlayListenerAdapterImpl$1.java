package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSPlayerManager$MediaPlayListenerAdapterImpl$1
  implements Runnable
{
  WSPlayerManager$MediaPlayListenerAdapterImpl$1(WSPlayerManager.MediaPlayListenerAdapterImpl paramMediaPlayListenerAdapterImpl) {}
  
  public void run()
  {
    IWSPlayerUIDelegate localIWSPlayerUIDelegate;
    WSPlayerParam localWSPlayerParam;
    boolean bool2;
    if ((WSPlayerManager.a(this.a.a) != null) && (WSPlayerManager.a(this.a.a).a != null))
    {
      localIWSPlayerUIDelegate = WSPlayerManager.a(this.a.a).a;
      localWSPlayerParam = WSPlayerManager.a(this.a.a);
      bool2 = WSPlayerManager.b(this.a.a);
      if (WSPlayerManager.c(this.a.a)) {
        break label135;
      }
    }
    label135:
    for (boolean bool1 = true;; bool1 = false)
    {
      localIWSPlayerUIDelegate.a(localWSPlayerParam, bool2, bool1);
      WSLog.g("WS_VIDEO_PRE_PLAY", "<=============================== [WSPlayerManager.java][onPrePlayFinished] title:" + WSPlayerManager.a(this.a.a, WSPlayerManager.a(this.a.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */