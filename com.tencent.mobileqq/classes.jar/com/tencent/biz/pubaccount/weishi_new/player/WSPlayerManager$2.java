package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import urt;
import urw;
import uya;

class WSPlayerManager$2
  implements Runnable
{
  WSPlayerManager$2(WSPlayerManager paramWSPlayerManager, WeakReference paramWeakReference, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    urt localurt = (urt)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localurt == null) {
      return;
    }
    urw localurw = WSPlayerManager.b(this.this$0);
    localurt.jdField_a_of_type_Urw = localurw;
    if ((localurw != null) && (WSPlayerManager.a(this.this$0) != null))
    {
      localurw.a(localurt.jdField_a_of_type_Urx);
      WSPlayerManager.a(this.this$0).put(localurw, WSPlayerManager.a());
      WSPlayerManager.a(this.this$0).post(new WSPlayerManager.2.1(this));
      return;
    }
    uya.d("WS_VIDEO_PLAYER", 2, "[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:" + localurt.jdField_a_of_type_Urw + ", mUIHandler:" + WSPlayerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */