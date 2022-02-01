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
    float f5 = paramArrayOfFloat[1][1];
    float f6 = paramArrayOfFloat[2][0];
    float f7 = paramArrayOfFloat[2][1];
    if ((f1 == f3) && (f1 == f6)) {
      return;
    }
    float f8 = f3 - f6;
    float f9 = f6 - f1;
    float f10 = f1 - f3;
    float f4 = f1 * f1;
    this.mA = ((f2 * f8 + f5 * f9 + f7 * f10) / (f8 * f4 + f3 * f3 * f9 + f6 * f6 * f10));
    f5 = (f2 - f5) / f10;
    f6 = this.mA;
    this.mB = (f5 - (f3 + f1) * f6);
    this.mC = (f2 - f4 * f6 - f1 * this.mB);
  }
  
  private float getY(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat2 * paramFloat1 * paramFloat1 + paramFloat3 * paramFloat1 + paramFloat4;
  }
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (PointF)paramObject1;
    paramObject2 = (PointF)paramObject2;
    paramFloat = paramObject1.x + paramFloat * (paramObject2.x - paramObject1.x);
    float f = getY(paramFloat, this.mA, this.mB, this.mC);
    paramObject1 = new PointF(0.0F, 0.0F);
    paramObject1.x = (paramFloat - paramObject2.x);
    paramObject1.y = (f - paramObject2.y);
    return paramObject1;
  }
  
  public void init(PointF paramPointF1, PointF paramPointF2)
  {
    calculateABC(new float[][] { { paramPointF1.x, paramPointF1.y }, { paramPointF1.x + (paramPointF2.x - paramPointF1.x) / 2.0F, paramPointF2.y - 50.0F }, { paramPointF2.x, paramPointF2.y } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.anim.PointEvaluator
 * JD-Core Version:    0.7.0.1
 */