package com.tencent.biz.troopgift;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import bdaq;
import yvb;
import yvc;
import yvj;

public class GridListAdapter$2
  implements Runnable
{
  public GridListAdapter$2(yvb paramyvb, yvc paramyvc, yvj paramyvj, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Yvc.a.getWidth();
    int j = this.jdField_a_of_type_Yvc.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k = bdaq.a(this.this$0.a, 5.0F);
    Paint localPaint = new Paint();
    localPaint.setTextSize(bdaq.a(this.this$0.a, 11.0F));
    float f1 = localPaint.measureText(this.jdField_a_of_type_Yvj.d);
    float f2 = bdaq.a(this.this$0.a, 2.0F);
    int m = bdaq.a(this.this$0.a, 1.0F);
    this.jdField_a_of_type_Yvc.a.setBackgroundDrawable(new BitmapDrawable(this.this$0.a.getResources(), yvb.a(i, j, k, f1 + f2, m, this.jdField_a_of_type_Int)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.2
 * JD-Core Version:    0.7.0.1
 */