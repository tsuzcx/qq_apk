package com.tencent.gdtad.views.video;

import android.media.AudioManager;
import com.tencent.superplayer.api.ISuperPlayer;

class GdtVideoCommonView$10
  implements Runnable
{
  GdtVideoCommonView$10(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    int i = GdtVideoCommonView.a(this.this$0).getStreamVolume(3);
    boolean bool1;
    if (GdtVideoCommonView.a(this.this$0) != null)
    {
      boolean bool2 = false;
      if (i <= 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = GdtVideoCommonView.a(this.this$0);
      if (i <= 0) {
        bool2 = true;
      }
      ((ISuperPlayer)localObject).setOutputMute(bool2);
    }
    else
    {
      bool1 = true;
    }
    Object localObject = this.this$0;
    GdtVideoCommonView.a((GdtVideoCommonView)localObject, i, ((GdtVideoCommonView)localObject).a, true, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.10
 * JD-Core Version:    0.7.0.1
 */