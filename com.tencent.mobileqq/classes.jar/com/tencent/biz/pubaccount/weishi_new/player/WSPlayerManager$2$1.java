package com.tencent.biz.pubaccount.weishi_new.player;

import mqq.util.WeakReference;
import urt;
import uya;

class WSPlayerManager$2$1
  implements Runnable
{
  WSPlayerManager$2$1(WSPlayerManager.2 param2) {}
  
  public void run()
  {
    urt localurt = (urt)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localurt == null) {
      return;
    }
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] innerPlayVideo miss cache.");
    if ((this.a.jdField_a_of_type_Boolean) && (localurt.a != null))
    {
      uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] set videoView null !!!");
      localurt.a = null;
    }
    WSPlayerManager.b(this.a.this$0, localurt, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2.1
 * JD-Core Version:    0.7.0.1
 */