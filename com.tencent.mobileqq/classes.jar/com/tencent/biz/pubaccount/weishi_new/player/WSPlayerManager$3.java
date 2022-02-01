package com.tencent.biz.pubaccount.weishi_new.player;

import uke;
import upe;

class WSPlayerManager$3
  implements Runnable
{
  WSPlayerManager$3(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if (WSPlayerManager.a(this.this$0) != null)
    {
      WSPlayerManager.a(this.this$0).b();
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] subThread videoPlayer.start!");
      if ((!WSPlayerManager.d(this.this$0)) && (WSPlayerManager.a(this.this$0) != null))
      {
        WSPlayerManager.a(this.this$0).c();
        upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] activity become onPause after videoPlayer.start(), so we need to pause it!");
      }
      WSPlayerManager.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.3
 * JD-Core Version:    0.7.0.1
 */