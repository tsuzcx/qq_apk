package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSPlayerManager$3
  implements Runnable
{
  WSPlayerManager$3(WSPlayerManager paramWSPlayerManager) {}
  
  public void run()
  {
    if (WSPlayerManager.l(this.this$0) != null)
    {
      WSPlayerManager.l(this.this$0).f();
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] subThread videoPlayer.start!");
      if ((!WSPlayerManager.i(this.this$0)) && (WSPlayerManager.l(this.this$0) != null))
      {
        WSPlayerManager.l(this.this$0).g();
        WSPlayerManager.h(this.this$0, true);
        WSPlayerManager.a(this.this$0, false);
        WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] activity become onPause after videoPlayer.start(), so we need to pause it!");
      }
      WSPlayerManager.y(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.3
 * JD-Core Version:    0.7.0.1
 */