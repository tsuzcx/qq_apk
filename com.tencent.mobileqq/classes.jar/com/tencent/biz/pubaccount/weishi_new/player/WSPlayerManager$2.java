package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;
import thl;
import tho;
import tlo;

class WSPlayerManager$2
  implements Runnable
{
  WSPlayerManager$2(WSPlayerManager paramWSPlayerManager, thl paramthl, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Thl.jdField_a_of_type_Tho = WSPlayerManager.b(this.this$0);
    if ((this.jdField_a_of_type_Thl.jdField_a_of_type_Tho != null) && (WSPlayerManager.a(this.this$0) != null))
    {
      this.jdField_a_of_type_Thl.jdField_a_of_type_Tho.a(this.jdField_a_of_type_Thl.jdField_a_of_type_Thp);
      WSPlayerManager.a(this.this$0).put(this.jdField_a_of_type_Thl.jdField_a_of_type_Tho, WSPlayerManager.a(this.this$0));
      WSPlayerManager.a(this.this$0).post(new WSPlayerManager.2.1(this));
      return;
    }
    tlo.d("WS_VIDEO_PLAYER", 2, "[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:" + this.jdField_a_of_type_Thl.jdField_a_of_type_Tho + ", mUIHandler:" + WSPlayerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */