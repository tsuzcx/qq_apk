package com.google.android.material.transition.platform;

import android.graphics.RectF;

final class FitModeEvaluators$1
  implements FitModeEvaluator
{
  public FitModeResult a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    paramFloat1 = TransitionUtils.a(paramFloat4, paramFloat6, paramFloat2, paramFloat3, paramFloat1, true);
    paramFloat2 = paramFloat1 / paramFloat4;
    paramFloat3 = paramFloat1 / paramFloat6;
    return new FitModeResult(paramFloat2, paramFloat3, paramFloat1, paramFloat5 * paramFloat2, paramFloat1, paramFloat7 * paramFloat3);
  }
  
  public void a(RectF paramRectF, float paramFloat, FitModeResult paramFitModeResult)
  {
    float f = Math.abs(paramFitModeResult.f - paramFitModeResult.d);
    paramRectF.bottom -= f * paramFloat;
  }
  
  public boolean a(FitModeResult paramFitModeResult)
  {
    return paramFitModeResult.d > paramFitModeResult.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.FitModeEvaluators.1
 * JD-Core Version:    0.7.0.1
 */