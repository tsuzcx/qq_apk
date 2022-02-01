package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;
import ukb;
import uke;
import upe;

class WSPlayerManager$2
  implements Runnable
{
  WSPlayerManager$2(WSPlayerManager paramWSPlayerManager, ukb paramukb, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke = WSPlayerManager.b(this.this$0);
    if ((this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke != null) && (WSPlayerManager.a(this.this$0) != null))
    {
      this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke.a(this.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf);
      WSPlayerManager.a(this.this$0).put(this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke, WSPlayerManager.a());
      WSPlayerManager.a(this.this$0).post(new WSPlayerManager.2.1(this));
      return;
    }
    upe.d("WS_VIDEO_PLAYER", 2, "[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:" + this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke + ", mUIHandler:" + WSPlayerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */