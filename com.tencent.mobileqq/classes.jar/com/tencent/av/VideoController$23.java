package com.tencent.av;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.app.SessionInfo;

class VideoController$23
  implements Runnable
{
  VideoController$23(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.this$0.k().aG) {
      ((AudioManager)this.this$0.f.getSystemService("audio")).setSpeakerphoneOn(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.23
 * JD-Core Version:    0.7.0.1
 */