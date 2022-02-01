package com.tencent.ilive.uicomponent.luxurygiftcomponent.anim;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class PointEvaluator
  implements TypeEvaluator
{
  private float mA = 0.0F;
  private float mB = 0.0F;
  private float mC = 0.0F;
  
  private void calculateABC(float[][] paramArrayOfFloat)
  {
    float f1 = paramArrayOfFloat[0][0];
    float f2 = paramArrayOfFloat[0][1];
    float f3 = paramArrayOfFloat[1][0];
    float f4 = paramArrayOfFloat[1][1];
    float f5 = paramArrayOfFloat[2][0];
    float f6 = paramArrayOfFloat[2][1];
    if ((f1 == f3) && (f1 == f5)) {
      return;
    }
    this.mA = ((f6 * (f1 - f3) + ((f3 - f5) * f2 + (f5 - f1) * f4)) / (f5 * f5 * (f1 - f3) + (f1 * f1 * (f3 - f5) + f3 * f3 * (f5 - f1))));
    this.mB = ((f2 - f4) / (f1 - f3) - (f3 + f1) * this.mA);
    this.mC = (f2 - f1 * f1 * this.mA - f1 * this.mB);
  }
  
  private float getY(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat2 * paramFloat1 * paramFloat1 + paramFloat3 * paramFloat1 + paramFloat4;
  }
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (PointF)paramObject1;
    paramObject2 = (PointF)paramObject2;
    paramFloat = paramObject1.x + (paramObject2.x - paramObject1.x) * paramFloat;
    float f = getY(paramFloat, this.mA, this.mB, this.mC);
    paramObject1 = new PointF(0.0F, 0.0F);
    paramObject1.x = (paramFloat - paramObject2.x);
    paramObject1.y = (f - paramObject2.y);
    return paramObject1;
  }
  
  public void init(PointF paramPointF1, PointF paramPointF2)
  {
    float[] arrayOfFloat = { paramPointF1.x, paramPointF1.y };
    float f1 = paramPointF1.x;
    float f2 = (paramPointF2.x - paramPointF1.x) / 2.0F;
    float f3 = paramPointF2.y;
    paramPointF1 = new float[] { paramPointF2.x, paramPointF2.y };
    calculateABC(new float[][] { arrayOfFloat, { f1 + f2, f3 - 50.0F }, paramPointF1 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.anim.PointEvaluator
 * JD-Core Version:    0.7.0.1
 */