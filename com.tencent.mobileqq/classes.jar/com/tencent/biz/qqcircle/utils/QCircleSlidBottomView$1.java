package com.tencent.biz.qqcircle.utils;

import android.view.animation.Interpolator;

class QCircleSlidBottomView$1
  implements Interpolator
{
  QCircleSlidBottomView$1(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.1
 * JD-Core Version:    0.7.0.1
 */