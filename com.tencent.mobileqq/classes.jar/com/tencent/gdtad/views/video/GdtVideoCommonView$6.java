package com.tencent.gdtad.views.video;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bace;
import yny;

class GdtVideoCommonView$6
  implements Runnable
{
  GdtVideoCommonView$6(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    yny.a("GdtVideoCommonView", "showTisJob " + GdtVideoCommonView.a(this.this$0));
    if (GdtVideoCommonView.a(this.this$0)) {
      return;
    }
    GdtVideoCommonView.a(this.this$0, true);
    GdtVideoCommonView.a(this.this$0).setVisibility(8);
    GdtVideoCommonView.b(this.this$0).setVisibility(8);
    GdtVideoCommonView.a(this.this$0).setVisibility(0);
    GdtVideoCommonView.c(this.this$0).setVisibility(0);
    if (GdtVideoCommonView.b(this.this$0) > 0L)
    {
      String str = bace.a(GdtVideoCommonView.b(this.this$0));
      str = String.format(GdtVideoCommonView.a(this.this$0).getString(2131624086), new Object[] { str });
      GdtVideoCommonView.b(this.this$0).setText(str);
      GdtVideoCommonView.b(this.this$0).setVisibility(0);
      GdtVideoCommonView.b(this.this$0).setVisibility(8);
      return;
    }
    GdtVideoCommonView.b(this.this$0).setVisibility(8);
    GdtVideoCommonView.b(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.6
 * JD-Core Version:    0.7.0.1
 */