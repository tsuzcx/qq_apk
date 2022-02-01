package com.tencent.gdtad.views.video;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.superplayer.api.ISuperPlayer;

class GdtVideoCommonView$7
  implements Runnable
{
  GdtVideoCommonView$7(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    if (this.this$0.a())
    {
      long l2 = GdtVideoCommonView.a(this.this$0).getCurrentPositionMs();
      if (l2 != 0L)
      {
        int i;
        if (GdtVideoCommonView.a(this.this$0) > 0L)
        {
          double d = GdtVideoCommonView.a(this.this$0) * l2 / GdtVideoCommonView.a(this.this$0);
          Double.isNaN(d);
          i = (int)(d + 0.5D);
        }
        else
        {
          i = 0;
        }
        long l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        if (!GdtVideoCommonView.b(this.this$0))
        {
          GdtVideoCommonView.a(this.this$0).setProgress(i);
          GdtVideoCommonView.b(this.this$0).setProgress(i);
          GdtVideoCommonView.c(this.this$0).setText(GdtUIUtils.a(l1));
        }
      }
      GdtVideoCommonView.a(this.this$0).postDelayed(this, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.7
 * JD-Core Version:    0.7.0.1
 */