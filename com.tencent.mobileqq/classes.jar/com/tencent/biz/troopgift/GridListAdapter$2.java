package com.tencent.biz.troopgift;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import azvv;
import wmt;
import wmu;
import wnb;

public class GridListAdapter$2
  implements Runnable
{
  public GridListAdapter$2(wmt paramwmt, wmu paramwmu, wnb paramwnb, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Wmu.a.getWidth();
    int j = this.jdField_a_of_type_Wmu.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k = azvv.a(this.this$0.a, 5.0F);
    Paint localPaint = new Paint();
    localPaint.setTextSize(azvv.a(this.this$0.a, 11.0F));
    float f1 = localPaint.measureText(this.jdField_a_of_type_Wnb.d);
    float f2 = azvv.a(this.this$0.a, 2.0F);
    int m = azvv.a(this.this$0.a, 1.0F);
    this.jdField_a_of_type_Wmu.a.setBackgroundDrawable(new BitmapDrawable(this.this$0.a.getResources(), wmt.a(i, j, k, f1 + f2, m, this.jdField_a_of_type_Int)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.2
 * JD-Core Version:    0.7.0.1
 */