package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import ukz;
import ulc;
import uqf;

class WSPlayerManager$2
  implements Runnable
{
  WSPlayerManager$2(WSPlayerManager paramWSPlayerManager, WeakReference paramWeakReference, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ukz localukz = (ukz)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localukz == null) {
      return;
    }
    ulc localulc = WSPlayerManager.b(this.this$0);
    localukz.jdField_a_of_type_Ulc = localulc;
    if ((localulc != null) && (WSPlayerManager.a(this.this$0) != null))
    {
      localulc.a(localukz.jdField_a_of_type_Uld);
      WSPlayerManager.a(this.this$0).put(localulc, WSPlayerManager.a());
      WSPlayerManager.a(this.this$0).post(new WSPlayerManager.2.1(this));
      return;
    }
    uqf.d("WS_VIDEO_PLAYER", 2, "[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:" + localukz.jdField_a_of_type_Ulc + ", mUIHandler:" + WSPlayerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */