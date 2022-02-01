package com.tencent.biz.qqcircle.manager;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class QCircleFuelAnimationManager$BezierEvaluator
  implements TypeEvaluator<PointF>
{
  private PointF b;
  private PointF c;
  
  public QCircleFuelAnimationManager$BezierEvaluator(QCircleFuelAnimationManager paramQCircleFuelAnimationManager, PointF paramPointF1, PointF paramPointF2)
  {
    this.b = paramPointF1;
    this.c = paramPointF2;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    PointF localPointF = new PointF();
    float f1 = paramPointF1.x;
    float f2 = 1.0F - paramFloat;
    localPointF.x = (f1 * f2 * f2 * f2 + this.b.x * 3.0F * paramFloat * f2 * f2 + this.c.x * 3.0F * paramFloat * paramFloat * f2 + paramPointF2.x * paramFloat * paramFloat * paramFloat);
    localPointF.y = (paramPointF1.y * f2 * f2 * f2 + this.b.y * 3.0F * paramFloat * f2 * f2 + this.c.y * 3.0F * paramFloat * paramFloat * f2 + paramPointF2.y * paramFloat * paramFloat * paramFloat);
    return localPointF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.BezierEvaluator
 * JD-Core Version:    0.7.0.1
 */