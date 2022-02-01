package com.tencent.gdtad.views.video;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

class GdtVideoCommonView$8
  implements Runnable
{
  GdtVideoCommonView$8(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    if (GdtVideoCommonView.b(this.this$0) == 5)
    {
      GdtVideoCommonView.b(this.this$0).setVisibility(0);
      GdtVideoCommonView.a(this.this$0).setVisibility(8);
      GdtVideoCommonView.b(this.this$0).setVisibility(8);
    }
    GdtVideoCommonView.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.8
 * JD-Core Version:    0.7.0.1
 */