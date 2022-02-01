package com.tencent.ad.tangram.views.canvas.components.fixedbutton;

import android.widget.TextView;

class c$1
  implements Runnable
{
  c$1(c paramc, TextView paramTextView1, TextView paramTextView2, float paramFloat) {}
  
  public void run()
  {
    int i = this.val$appSize.getWidth();
    int j = this.val$appName.getMeasuredWidth();
    if (i > 0)
    {
      float f1 = this.val$sizeTextWidth;
      float f2 = i;
      if (f1 > f2)
      {
        this.val$appSize.setWidth((int)f1);
        this.val$appName.setWidth((int)(j - (this.val$sizeTextWidth - f2)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.fixedbutton.c.1
 * JD-Core Version:    0.7.0.1
 */