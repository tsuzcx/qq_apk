package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bdaq;
import xms;
import xmv;
import yvb;

public class SlideShowAdapter$3
  implements Runnable
{
  public SlideShowAdapter$3(xms paramxms, xmv paramxmv) {}
  
  public void run()
  {
    int i = this.a.a.getWidth();
    int j = this.a.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (xms.a(this.this$0) == null)
    {
      int k = bdaq.a(xms.a(this.this$0), 1.0F);
      new Paint().setTextSize(bdaq.a(xms.a(this.this$0), 11.0F));
      int m = bdaq.a(xms.a(this.this$0), 2.0F);
      xms.a(this.this$0, yvb.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.a.a.setBackgroundDrawable(new BitmapDrawable(xms.a(this.this$0).getResources(), xms.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3
 * JD-Core Version:    0.7.0.1
 */