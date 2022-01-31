package com.tencent.av;

import android.content.Context;
import android.media.AudioManager;
import kvq;

class VideoController$19
  implements Runnable
{
  VideoController$19(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.this$0.a().N) {
      ((AudioManager)this.this$0.a.getSystemService("audio")).setSpeakerphoneOn(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.19
 * JD-Core Version:    0.7.0.1
 */