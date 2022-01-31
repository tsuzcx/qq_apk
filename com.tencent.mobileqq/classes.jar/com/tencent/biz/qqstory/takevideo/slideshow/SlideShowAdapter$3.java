package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bawz;
import vtu;
import vtx;
import xbw;

public class SlideShowAdapter$3
  implements Runnable
{
  public SlideShowAdapter$3(vtu paramvtu, vtx paramvtx) {}
  
  public void run()
  {
    int i = this.a.a.getWidth();
    int j = this.a.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (vtu.a(this.this$0) == null)
    {
      int k = bawz.a(vtu.a(this.this$0), 1.0F);
      new Paint().setTextSize(bawz.a(vtu.a(this.this$0), 11.0F));
      int m = bawz.a(vtu.a(this.this$0), 2.0F);
      vtu.a(this.this$0, xbw.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.a.a.setBackgroundDrawable(new BitmapDrawable(vtu.a(this.this$0).getResources(), vtu.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3
 * JD-Core Version:    0.7.0.1
 */