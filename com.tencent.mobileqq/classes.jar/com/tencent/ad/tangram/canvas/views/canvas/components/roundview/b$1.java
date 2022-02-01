package com.tencent.ad.tangram.canvas.views.canvas.components.roundview;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class b$1
  extends ViewOutlineProvider
{
  b$1(b paramb, int paramInt1, int paramInt2) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, this.val$width, this.val$height, b.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b.1
 * JD-Core Version:    0.7.0.1
 */