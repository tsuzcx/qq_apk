package com.tencent.mobileqq.apollo.store.openbox;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class QuadBezierAnimation
  extends Animation
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  
  public QuadBezierAnimation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.d = paramInt5;
    this.c = paramInt6;
    this.a = paramInt3;
    this.b = paramInt4;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f3 = 1.0F - paramFloat;
    float f1 = f3 * f3;
    float f2 = this.e;
    f3 = 2.0F * paramFloat * f3;
    float f4 = this.a;
    paramFloat *= paramFloat;
    float f5 = this.d;
    float f6 = this.f;
    float f7 = this.b;
    float f8 = this.c;
    paramTransformation.getMatrix().preTranslate(f2 * f1 + f4 * f3 + f5 * paramFloat, f1 * f6 + f3 * f7 + paramFloat * f8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.QuadBezierAnimation
 * JD-Core Version:    0.7.0.1
 */