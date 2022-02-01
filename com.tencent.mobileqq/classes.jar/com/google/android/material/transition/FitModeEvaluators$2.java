package com.google.android.material.transition;

import android.graphics.RectF;

final class FitModeEvaluators$2
  implements FitModeEvaluator
{
  public FitModeResult a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    paramFloat1 = TransitionUtils.a(paramFloat5, paramFloat7, paramFloat2, paramFloat3, paramFloat1, true);
    paramFloat2 = paramFloat1 / paramFloat5;
    paramFloat3 = paramFloat1 / paramFloat7;
    return new FitModeResult(paramFloat2, paramFloat3, paramFloat4 * paramFloat2, paramFloat1, paramFloat6 * paramFloat3, paramFloat1);
  }
  
  public void a(RectF paramRectF, float paramFloat, FitModeResult paramFitModeResult)
  {
    float f2 = Math.abs(paramFitModeResult.e - paramFitModeResult.c);
    float f1 = paramRectF.left;
    paramFloat = f2 / 2.0F * paramFloat;
    paramRectF.left = (f1 + paramFloat);
    paramRectF.right -= paramFloat;
  }
  
  public boolean a(FitModeResult paramFitModeResult)
  {
    return paramFitModeResult.c > paramFitModeResult.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.FitModeEvaluators.2
 * JD-Core Version:    0.7.0.1
 */