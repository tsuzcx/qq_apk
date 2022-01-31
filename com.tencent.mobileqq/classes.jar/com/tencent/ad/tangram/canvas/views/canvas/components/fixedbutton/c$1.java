package com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton;

import android.widget.TextView;

class c$1
  implements Runnable
{
  c$1(c paramc, TextView paramTextView1, TextView paramTextView2, float paramFloat) {}
  
  public void run()
  {
    int i = this.val$appSize.getWidth();
    int j = this.val$appName.getMeasuredWidth();
    if ((i > 0) && (this.val$sizeTextWidth > i))
    {
      this.val$appSize.setWidth((int)this.val$sizeTextWidth);
      this.val$appName.setWidth((int)(j - (this.val$sizeTextWidth - i)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.c.1
 * JD-Core Version:    0.7.0.1
 */