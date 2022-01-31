package com.tencent.biz.pubaccount.weishi_new.player;

import thl;
import tlo;

class WSPlayerManager$2$1
  implements Runnable
{
  WSPlayerManager$2$1(WSPlayerManager.2 param2) {}
  
  public void run()
  {
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] innerPlayVideo miss cache.");
    if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Thl.a != null))
    {
      tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] set videoView null !!!");
      this.a.jdField_a_of_type_Thl.a = null;
    }
    WSPlayerManager.b(this.a.this$0, this.a.jdField_a_of_type_Thl, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2.1
 * JD-Core Version:    0.7.0.1
 */