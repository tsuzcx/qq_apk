package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import com.tencent.mobileqq.util.DisplayUtil;

class GridListAdapter$1
  implements Runnable
{
  GridListAdapter$1(GridListAdapter paramGridListAdapter, GridListAdapter.Holder paramHolder) {}
  
  public void run()
  {
    int i = DisplayUtil.a(this.this$0.a, 5.0F);
    new Paint().setTextSize(DisplayUtil.a(this.this$0.a, 11.0F));
    int j = this.a.a.getWidth();
    int k = this.a.a.getHeight();
    if ((j == 0) || (k == 0)) {
      return;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(new float[] { i, i, i, i, i, i, i, i });
    localGradientDrawable.setColor(Color.argb(35, 0, 0, 0));
    this.a.a.setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.1
 * JD-Core Version:    0.7.0.1
 */