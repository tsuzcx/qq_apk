package com.tencent.biz.troopgift;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

class GridListAdapter$2
  implements Runnable
{
  GridListAdapter$2(GridListAdapter paramGridListAdapter, GridListAdapter.Holder paramHolder, TroopGiftAioItemData paramTroopGiftAioItemData, int paramInt) {}
  
  public void run()
  {
    int i = this.a.h.getWidth();
    int j = this.a.h.getHeight();
    if (i != 0)
    {
      if (j == 0) {
        return;
      }
      int k = DisplayUtil.a(this.this$0.b, 5.0F);
      Paint localPaint = new Paint();
      localPaint.setTextSize(DisplayUtil.a(this.this$0.b, 11.0F));
      float f1 = localPaint.measureText(this.b.h);
      float f2 = DisplayUtil.a(this.this$0.b, 2.0F);
      int m = DisplayUtil.a(this.this$0.b, 1.0F);
      this.a.h.setBackgroundDrawable(new BitmapDrawable(this.this$0.b.getResources(), GridListAdapter.a(i, j, k, f2 + f1, m, this.c)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter.2
 * JD-Core Version:    0.7.0.1
 */