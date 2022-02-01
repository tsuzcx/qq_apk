package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;

class FixedSizeVideoView$1
  implements MediaPlayer.OnCompletionListener
{
  FixedSizeVideoView$1(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.a != null)
    {
      if (FixedSizeVideoView.a(this.a) != null) {
        FixedSizeVideoView.a(this.a).removeMessages(0);
      }
      this.a.a.a(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.1
 * JD-Core Version:    0.7.0.1
 */