package com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship;

import android.animation.TypeEvaluator;
import com.tencent.qphone.base.util.QLog;

class AdditionalAnimController$AlphaEvaluator
  implements TypeEvaluator
{
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel())
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("AlphaEvaluator value: ");
      paramObject1.append(paramFloat);
      QLog.d("AdditionalAnimController", 2, paramObject1.toString());
    }
    if (paramFloat >= 0.0F)
    {
      d = paramFloat;
      if (d <= 0.02985074626865672D)
      {
        Double.isNaN(d);
        return Double.valueOf(d * 0.5D / 0.02985074626865672D);
      }
    }
    double d = paramFloat;
    if ((d > 0.02985074626865672D) && (d <= 0.9253731343283582D)) {
      return Double.valueOf(0.5D);
    }
    if ((d > 0.9253731343283582D) && (paramFloat <= 1.0F))
    {
      d = 1.0F - paramFloat;
      Double.isNaN(d);
      return Double.valueOf(d * 0.5D / 0.07462686567164178D);
    }
    return Double.valueOf(0.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship.AdditionalAnimController.AlphaEvaluator
 * JD-Core Version:    0.7.0.1
 */