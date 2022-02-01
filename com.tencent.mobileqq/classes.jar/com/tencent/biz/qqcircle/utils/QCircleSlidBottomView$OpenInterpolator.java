package com.tencent.biz.qqcircle.utils;

import android.view.animation.Interpolator;

public class QCircleSlidBottomView$OpenInterpolator
  implements Interpolator
{
  private double b;
  
  public QCircleSlidBottomView$OpenInterpolator(QCircleSlidBottomView paramQCircleSlidBottomView, double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public float getInterpolation(float paramFloat)
  {
    double d1 = paramFloat;
    Double.isNaN(d1);
    double d2 = Math.pow(2.0D, -24.0D * d1);
    double d3 = this.b;
    double d4 = d3 / 10.0D;
    Double.isNaN(d1);
    return (float)(d2 * Math.sin((d1 - d4) * 6.283185307179586D / d3) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.OpenInterpolator
 * JD-Core Version:    0.7.0.1
 */