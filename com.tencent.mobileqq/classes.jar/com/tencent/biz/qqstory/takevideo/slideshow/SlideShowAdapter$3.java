package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import baxn;
import vtr;
import vtu;
import xbt;

public class SlideShowAdapter$3
  implements Runnable
{
  public SlideShowAdapter$3(vtr paramvtr, vtu paramvtu) {}
  
  public void run()
  {
    int i = this.a.a.getWidth();
    int j = this.a.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (vtr.a(this.this$0) == null)
    {
      int k = baxn.a(vtr.a(this.this$0), 1.0F);
      new Paint().setTextSize(baxn.a(vtr.a(this.this$0), 11.0F));
      int m = baxn.a(vtr.a(this.this$0), 2.0F);
      vtr.a(this.this$0, xbt.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.a.a.setBackgroundDrawable(new BitmapDrawable(vtr.a(this.this$0).getResources(), vtr.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3
 * JD-Core Version:    0.7.0.1
 */