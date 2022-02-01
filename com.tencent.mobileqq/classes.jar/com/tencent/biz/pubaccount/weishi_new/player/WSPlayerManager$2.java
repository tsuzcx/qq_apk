package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import vgb;
import vgh;
import vmp;

class WSPlayerManager$2
  implements Runnable
{
  WSPlayerManager$2(WSPlayerManager paramWSPlayerManager, WeakReference paramWeakReference, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    vgb localvgb = (vgb)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localvgb == null) {
      return;
    }
    vgh localvgh = WSPlayerManager.b(this.this$0);
    localvgb.jdField_a_of_type_Vgh = localvgh;
    if ((localvgh != null) && (WSPlayerManager.a(this.this$0) != null))
    {
      localvgh.a(localvgb.jdField_a_of_type_Vgi);
      WSPlayerManager.a(this.this$0).put(localvgh, WSPlayerManager.a());
      WSPlayerManager.a(this.this$0).post(new WSPlayerManager.2.1(this));
      return;
    }
    vmp.d("WS_VIDEO_PLAYER", 2, "[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:" + localvgb.jdField_a_of_type_Vgh + ", mUIHandler:" + WSPlayerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */