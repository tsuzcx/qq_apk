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
    int i = DisplayUtil.a(this.this$0.b, 5.0F);
    new Paint().setTextSize(DisplayUtil.a(this.this$0.b, 11.0F));
    int j = this.a.j.getWidth();
    int k = this.a.j.getHeight();
    if (j != 0)
    {
      if (k == 0) {
        return;
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      float f = i;
      localGradientDrawable.setCornerRadii(new float[] { f, f, f, f, f, f, f, f });
      localGradientDrawable.setColor(Color.argb(35, 0, 0, 0));
      this.a.j.setBackgroundDrawable(localGradientDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.1
 * JD-Core Version:    0.7.0.1
 */