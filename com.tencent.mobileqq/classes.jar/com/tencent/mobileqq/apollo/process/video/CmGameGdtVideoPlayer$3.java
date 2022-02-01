package com.tencent.mobileqq.apollo.process.video;

import amtk;
import com.tencent.superplayer.api.ISuperPlayer;

public class CmGameGdtVideoPlayer$3
  implements Runnable
{
  public CmGameGdtVideoPlayer$3(amtk paramamtk) {}
  
  public void run()
  {
    if (amtk.a(this.this$0) != null)
    {
      amtk.a(this.this$0).stop();
      amtk.a(this.this$0).release();
      amtk.a(this.this$0, null);
      amtk.a(this.this$0, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */