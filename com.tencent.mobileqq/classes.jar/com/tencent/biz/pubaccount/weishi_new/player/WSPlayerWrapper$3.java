package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import uke;

public class WSPlayerWrapper$3
  implements Runnable
{
  public WSPlayerWrapper$3(uke paramuke, boolean paramBoolean) {}
  
  public void run()
  {
    if ((uke.a(this.this$0) != null) && (uke.a(this.this$0).get() != 6) && (uke.a(this.this$0).get() != 8)) {
      uke.a(this.this$0).setLoopback(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */