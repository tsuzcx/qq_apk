package com.tencent.biz.subscribe.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

class TransitionAnimHelper$MatrixEvaluator
  implements TypeEvaluator<Matrix>
{
  public static TypeEvaluator<Matrix> a = new TransitionAnimHelper.MatrixEvaluator.1();
  float[] b = new float[9];
  float[] c = new float[9];
  Matrix d = new Matrix();
  
  public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    paramMatrix1.getValues(this.b);
    paramMatrix2.getValues(this.c);
    int i = 0;
    while (i < 9)
    {
      paramMatrix1 = this.c;
      float f1 = paramMatrix1[i];
      paramMatrix2 = this.b;
      float f2 = paramMatrix2[i];
      paramMatrix2[i] += (f1 - f2) * paramFloat;
      i += 1;
    }
    this.d.setValues(this.c);
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.MatrixEvaluator
 * JD-Core Version:    0.7.0.1
 */