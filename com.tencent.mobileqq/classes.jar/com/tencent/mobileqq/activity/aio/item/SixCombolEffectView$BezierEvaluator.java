package com.tencent.mobileqq.activity.aio.item;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.tencent.mobileqq.app.HardCodeUtil;

public class SixCombolEffectView$BezierEvaluator
  implements TypeEvaluator<PointF>
{
  private PointF[] jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
  
  public SixCombolEffectView$BezierEvaluator(SixCombolEffectView paramSixCombolEffectView) {}
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    paramPointF1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
    paramPointF2 = paramPointF1[0];
    Object localObject1 = paramPointF1[1];
    Object localObject2 = paramPointF1[2];
    if (paramFloat <= 1.0F)
    {
      float f1 = 1.0F - paramFloat;
      double d3 = paramPointF2.x;
      double d2 = f1;
      double d4 = Math.pow(d2, 2.0D);
      Double.isNaN(d3);
      double d5 = localObject1.x * 2.0F * paramFloat * f1;
      Double.isNaN(d5);
      double d6 = localObject2.x;
      double d1 = paramFloat;
      double d7 = Math.pow(d1, 2.0D);
      Double.isNaN(d6);
      float f2 = (float)(d3 * d4 + d5 + d6 * d7);
      d3 = paramPointF2.y;
      d2 = Math.pow(d2, 2.0D);
      Double.isNaN(d3);
      d4 = localObject1.y * 2.0F * paramFloat * f1;
      Double.isNaN(d4);
      d5 = localObject2.y;
      d1 = Math.pow(d1, 2.0D);
      Double.isNaN(d5);
      return new PointF(f2, (float)(d3 * d2 + d4 + d5 * d1));
    }
    return paramPointF1[2];
  }
  
  public void a(PointF... paramVarArgs)
  {
    if (paramVarArgs.length == 3)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = paramVarArgs;
      return;
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131714061));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.BezierEvaluator
 * JD-Core Version:    0.7.0.1
 */