package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import com.tencent.biz.troopgift.GridListAdapter;
import com.tencent.mobileqq.util.DisplayUtil;

class SlideShowAdapter$3
  implements Runnable
{
  SlideShowAdapter$3(SlideShowAdapter paramSlideShowAdapter, SlideShowAdapter.SlideShowViewHolder paramSlideShowViewHolder) {}
  
  public void run()
  {
    int i = this.a.a.getWidth();
    int j = this.a.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    if (SlideShowAdapter.a(this.this$0) == null)
    {
      int k = DisplayUtil.a(SlideShowAdapter.a(this.this$0), 1.0F);
      new Paint().setTextSize(DisplayUtil.a(SlideShowAdapter.a(this.this$0), 11.0F));
      int m = DisplayUtil.a(SlideShowAdapter.a(this.this$0), 2.0F);
      SlideShowAdapter.a(this.this$0, GridListAdapter.a(i, j, k, 0.0F, m, Color.parseColor("#12B7F5")));
    }
    this.a.a.setBackgroundDrawable(new BitmapDrawable(SlideShowAdapter.a(this.this$0).getResources(), SlideShowAdapter.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3
 * JD-Core Version:    0.7.0.1
 */