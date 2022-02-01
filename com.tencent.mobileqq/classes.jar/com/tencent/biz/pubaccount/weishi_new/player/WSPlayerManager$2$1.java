package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import mqq.util.WeakReference;

class WSPlayerManager$2$1
  implements Runnable
{
  WSPlayerManager$2$1(WSPlayerManager.2 param2) {}
  
  public void run()
  {
    WSPlayerParam localWSPlayerParam = (WSPlayerParam)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localWSPlayerParam == null) {
      return;
    }
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] innerPlayVideo miss cache.");
    if ((this.a.jdField_a_of_type_Boolean) && (localWSPlayerParam.a != null))
    {
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] set videoView null !!!");
      localWSPlayerParam.a = null;
    }
    WSPlayerManager.b(this.a.this$0, localWSPlayerParam, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2.1
 * JD-Core Version:    0.7.0.1
 */