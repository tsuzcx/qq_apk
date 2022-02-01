package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import ulc;

public class WSPlayerWrapper$3
  implements Runnable
{
  public WSPlayerWrapper$3(ulc paramulc, boolean paramBoolean) {}
  
  public void run()
  {
    if ((ulc.a(this.this$0) != null) && (ulc.a(this.this$0).get() != 6) && (ulc.a(this.this$0).get() != 8)) {
      ulc.a(this.this$0).setLoopback(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */