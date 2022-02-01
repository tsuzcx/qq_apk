package com.tencent.biz.qqstory.takevideo.slideshow;

import aawd;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import bhgr;
import zjy;
import zkb;

public class SlideShowAdapter$3
  implements Runnable
{
  public SlideShowAdapter$3(zjy paramzjy, zkb paramzkb) {}
  
  public void run()
  {
    int i = this.a.a.getWidth();
    int j = this.a.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (zjy.a(this.this$0) == null)
    {
      int k = bhgr.a(zjy.a(this.this$0), 1.0F);
      new Paint().setTextSize(bhgr.a(zjy.a(this.this$0), 11.0F));
      int m = bhgr.a(zjy.a(this.this$0), 2.0F);
      zjy.a(this.this$0, aawd.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.a.a.setBackgroundDrawable(new BitmapDrawable(zjy.a(this.this$0).getResources(), zjy.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3
 * JD-Core Version:    0.7.0.1
 */