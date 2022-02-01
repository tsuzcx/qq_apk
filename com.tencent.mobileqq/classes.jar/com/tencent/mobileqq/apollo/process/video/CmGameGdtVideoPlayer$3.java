package com.tencent.mobileqq.apollo.process.video;

import alzy;
import com.tencent.superplayer.api.ISuperPlayer;

public class CmGameGdtVideoPlayer$3
  implements Runnable
{
  public CmGameGdtVideoPlayer$3(alzy paramalzy) {}
  
  public void run()
  {
    if (alzy.a(this.this$0) != null)
    {
      alzy.a(this.this$0).stop();
      alzy.a(this.this$0).release();
      alzy.a(this.this$0, null);
      alzy.a(this.this$0, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */