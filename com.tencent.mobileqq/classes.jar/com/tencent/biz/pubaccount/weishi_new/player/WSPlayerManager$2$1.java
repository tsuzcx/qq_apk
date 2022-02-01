package com.tencent.biz.pubaccount.weishi_new.player;

import mqq.util.WeakReference;
import vgb;
import vmp;

class WSPlayerManager$2$1
  implements Runnable
{
  WSPlayerManager$2$1(WSPlayerManager.2 param2) {}
  
  public void run()
  {
    vgb localvgb = (vgb)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localvgb == null) {
      return;
    }
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] innerPlayVideo miss cache.");
    if ((this.a.jdField_a_of_type_Boolean) && (localvgb.a != null))
    {
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] set videoView null !!!");
      localvgb.a = null;
    }
    WSPlayerManager.b(this.a.this$0, localvgb, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2.1
 * JD-Core Version:    0.7.0.1
 */