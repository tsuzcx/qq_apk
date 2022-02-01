package com.tencent.biz.richframework.part.block.base;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class QCirclePagerSnapHelper$OnLayoutSizeChangedListener
  implements View.OnLayoutChangeListener
{
  private int b = 0;
  private int c = 0;
  
  private QCirclePagerSnapHelper$OnLayoutSizeChangedListener(QCirclePagerSnapHelper paramQCirclePagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.b > 0) && (this.c > 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (!QCirclePagerSnapHelper.m(this.a)) && ((this.b != paramView.getHeight()) || (this.c != paramView.getWidth())))
    {
      QCirclePagerSnapHelper localQCirclePagerSnapHelper = this.a;
      localQCirclePagerSnapHelper.b(QCirclePagerSnapHelper.h(localQCirclePagerSnapHelper));
    }
    this.b = paramView.getHeight();
    this.c = paramView.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.OnLayoutSizeChangedListener
 * JD-Core Version:    0.7.0.1
 */