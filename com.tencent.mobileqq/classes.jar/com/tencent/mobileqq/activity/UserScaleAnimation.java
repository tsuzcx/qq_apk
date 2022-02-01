package com.tencent.mobileqq.activity;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class UserScaleAnimation
  extends Animation
{
  private float a;
  private float b;
  private float c;
  private int d;
  private int e;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f2 = 1.0F;
    float f1;
    if (paramFloat < 0.1666667F)
    {
      f1 = (this.a - 0.2F) * paramFloat / 0.1666667F + 0.2F;
    }
    else
    {
      f1 = 0.3333333F;
      float f3;
      if (paramFloat < 0.3333333F)
      {
        f1 = this.a;
        f3 = 1.0F - f1;
        f2 = paramFloat - 0.1666667F;
        paramFloat = f3;
      }
      for (;;)
      {
        f1 = paramFloat * f2 / 0.1666667F + f1;
        break;
        if (paramFloat < 0.5F) {}
        for (f2 = this.b;; f2 = this.c)
        {
          f1 = 1.0F + (f2 - 1.0F) * (paramFloat - f1) / 0.1666667F;
          break label180;
          f1 = 0.6666667F;
          if (paramFloat < 0.6666667F)
          {
            f1 = this.b;
            f3 = 1.0F - f1;
            f2 = paramFloat - 0.5F;
            paramFloat = f3;
            break;
          }
          if (paramFloat >= 0.8333334F) {
            break label149;
          }
        }
        label149:
        f1 = f2;
        if (paramFloat >= 1.0F) {
          break;
        }
        f1 = this.c;
        f3 = 1.0F - f1;
        f2 = paramFloat - 0.8333334F;
        paramFloat = f3;
      }
    }
    label180:
    paramTransformation.getMatrix().setScale(f1, f1, this.d * 0.5F, this.e * 0.5F);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = paramInt1;
    this.e = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserScaleAnimation
 * JD-Core Version:    0.7.0.1
 */