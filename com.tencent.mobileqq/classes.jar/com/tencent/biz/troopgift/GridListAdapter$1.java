package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import bcwh;
import yqm;
import yqn;

public class GridListAdapter$1
  implements Runnable
{
  public GridListAdapter$1(yqm paramyqm, yqn paramyqn) {}
  
  public void run()
  {
    int i = bcwh.a(this.this$0.a, 5.0F);
    new Paint().setTextSize(bcwh.a(this.this$0.a, 11.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.1
 * JD-Core Version:    0.7.0.1
 */