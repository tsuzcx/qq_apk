package com.tencent.biz.qqcircle.polylike;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class QCirclePolyLikeAniView$PointFTypeEvaluator
  implements TypeEvaluator<PointF>
{
  PointF a;
  PointF b = new PointF();
  
  public QCirclePolyLikeAniView$PointFTypeEvaluator(PointF paramPointF)
  {
    this.a = paramPointF;
  }
  
  private PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, float paramFloat)
  {
    PointF localPointF = this.b;
    float f3 = 1.0F - paramFloat;
    float f1 = f3 * f3;
    float f2 = paramPointF1.x;
    f3 = 2.0F * paramFloat * f3;
    float f4 = paramPointF3.x;
    paramFloat *= paramFloat;
    localPointF.x = (f2 * f1 + f4 * f3 + paramPointF2.x * paramFloat);
    this.b.y = (f1 * paramPointF1.y + f3 * paramPointF3.y + paramFloat * paramPointF2.y);
    return this.b;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    return a(paramPointF1, paramPointF2, this.a, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView.PointFTypeEvaluator
 * JD-Core Version:    0.7.0.1
 */