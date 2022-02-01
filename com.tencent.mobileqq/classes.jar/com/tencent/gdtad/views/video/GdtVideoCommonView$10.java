package com.tencent.gdtad.views.video;

import android.media.AudioManager;
import com.tencent.superplayer.api.ISuperPlayer;

class GdtVideoCommonView$10
  implements Runnable
{
  GdtVideoCommonView$10(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    boolean bool2 = false;
    int i = GdtVideoCommonView.a(this.this$0).getStreamVolume(3);
    boolean bool1;
    if (GdtVideoCommonView.a(this.this$0) != null) {
      if (i <= 0)
      {
        bool1 = true;
        ISuperPlayer localISuperPlayer = GdtVideoCommonView.a(this.this$0);
        if (i <= 0) {
          bool2 = true;
        }
        localISuperPlayer.setOutputMute(bool2);
      }
    }
    for (;;)
    {
      GdtVideoCommonView.a(this.this$0, i, this.this$0.a, true, bool1);
      return;
      bool1 = false;
      break;
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.10
 * JD-Core Version:    0.7.0.1
 */