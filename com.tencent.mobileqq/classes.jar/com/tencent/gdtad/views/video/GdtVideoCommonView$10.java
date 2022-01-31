package com.tencent.gdtad.views.video;

import android.media.AudioManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class GdtVideoCommonView$10
  implements Runnable
{
  GdtVideoCommonView$10(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    int i = GdtVideoCommonView.a(this.this$0).getStreamVolume(3);
    TVK_IMediaPlayer localTVK_IMediaPlayer;
    if (GdtVideoCommonView.a(this.this$0) != null)
    {
      localTVK_IMediaPlayer = GdtVideoCommonView.a(this.this$0);
      if (i > 0) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      localTVK_IMediaPlayer.setOutputMute(bool);
      GdtVideoCommonView.a(this.this$0, i, this.this$0.a, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.10
 * JD-Core Version:    0.7.0.1
 */