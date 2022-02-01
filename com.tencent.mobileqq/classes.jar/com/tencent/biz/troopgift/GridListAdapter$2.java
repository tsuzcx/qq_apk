package com.tencent.biz.troopgift;

import aasa;
import aasb;
import aasi;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import bggq;

public class GridListAdapter$2
  implements Runnable
{
  public GridListAdapter$2(aasa paramaasa, aasb paramaasb, aasi paramaasi, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Aasb.a.getWidth();
    int j = this.jdField_a_of_type_Aasb.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k = bggq.a(this.this$0.a, 5.0F);
    Paint localPaint = new Paint();
    localPaint.setTextSize(bggq.a(this.this$0.a, 11.0F));
    float f1 = localPaint.measureText(this.jdField_a_of_type_Aasi.d);
    float f2 = bggq.a(this.this$0.a, 2.0F);
    int m = bggq.a(this.this$0.a, 1.0F);
    this.jdField_a_of_type_Aasb.a.setBackgroundDrawable(new BitmapDrawable(this.this$0.a.getResources(), aasa.a(i, j, k, f1 + f2, m, this.jdField_a_of_type_Int)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.2
 * JD-Core Version:    0.7.0.1
 */