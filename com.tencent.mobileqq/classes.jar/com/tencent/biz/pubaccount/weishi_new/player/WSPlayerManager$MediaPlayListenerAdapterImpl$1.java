package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSPlayerManager$MediaPlayListenerAdapterImpl$1
  implements Runnable
{
  WSPlayerManager$MediaPlayListenerAdapterImpl$1(WSPlayerManager.MediaPlayListenerAdapterImpl paramMediaPlayListenerAdapterImpl) {}
  
  public void run()
  {
    if ((WSPlayerManager.a(this.a.a) != null) && (WSPlayerManager.a(this.a.a).a != null)) {
      WSPlayerManager.a(this.a.a).a.a(WSPlayerManager.a(this.a.a), WSPlayerManager.b(this.a.a), WSPlayerManager.c(this.a.a) ^ true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<=============================== [WSPlayerManager.java][onPrePlayFinished] title:");
    localStringBuilder.append(WSPlayerManager.a(this.a.a, WSPlayerManager.a(this.a.a)));
    WSLog.g("WS_VIDEO_PRE_PLAY", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */