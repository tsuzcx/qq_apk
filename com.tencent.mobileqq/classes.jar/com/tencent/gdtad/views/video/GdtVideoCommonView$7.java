package com.tencent.gdtad.views.video;

import absw;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.superplayer.api.ISuperPlayer;

class GdtVideoCommonView$7
  implements Runnable
{
  GdtVideoCommonView$7(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    long l1 = 0L;
    long l2;
    int i;
    if (this.this$0.a())
    {
      l2 = GdtVideoCommonView.a(this.this$0).getCurrentPositionMs();
      if (l2 != 0L)
      {
        if (GdtVideoCommonView.a(this.this$0) <= 0L) {
          break label140;
        }
        i = (int)(GdtVideoCommonView.a(this.this$0) * l2 / GdtVideoCommonView.a(this.this$0) + 0.5D);
        if (l2 >= 0L) {
          break label145;
        }
      }
    }
    for (;;)
    {
      if (!GdtVideoCommonView.b(this.this$0))
      {
        GdtVideoCommonView.a(this.this$0).setProgress(i);
        GdtVideoCommonView.b(this.this$0).setProgress(i);
        GdtVideoCommonView.c(this.this$0).setText(absw.a(l1));
      }
      GdtVideoCommonView.a(this.this$0).postDelayed(this, 50L);
      return;
      label140:
      i = 0;
      break;
      label145:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.7
 * JD-Core Version:    0.7.0.1
 */