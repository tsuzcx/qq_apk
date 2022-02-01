package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
abstract interface FitModeEvaluator
{
  public abstract FitModeResult a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
  
  public abstract void a(RectF paramRectF, float paramFloat, FitModeResult paramFitModeResult);
  
  public abstract boolean a(FitModeResult paramFitModeResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.FitModeEvaluator
 * JD-Core Version:    0.7.0.1
 */