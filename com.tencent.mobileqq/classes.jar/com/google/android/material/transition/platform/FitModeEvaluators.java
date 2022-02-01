package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FitModeEvaluators
{
  private static final FitModeEvaluator a = new FitModeEvaluators.1();
  private static final FitModeEvaluator b = new FitModeEvaluators.2();
  
  static FitModeEvaluator a(int paramInt, boolean paramBoolean, RectF paramRectF1, RectF paramRectF2)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return b;
        }
        paramRectF1 = new StringBuilder();
        paramRectF1.append("Invalid fit mode: ");
        paramRectF1.append(paramInt);
        throw new IllegalArgumentException(paramRectF1.toString());
      }
      return a;
    }
    if (a(paramBoolean, paramRectF1, paramRectF2)) {
      return a;
    }
    return b;
  }
  
  private static boolean a(boolean paramBoolean, RectF paramRectF1, RectF paramRectF2)
  {
    float f4 = paramRectF1.width();
    float f1 = paramRectF1.height();
    float f5 = paramRectF2.width();
    float f2 = paramRectF2.height();
    float f3 = f2 * f4 / f5;
    f4 = f5 * f1 / f4;
    if (paramBoolean)
    {
      if (f3 >= f1) {
        return true;
      }
    }
    else if (f4 >= f2) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.FitModeEvaluators
 * JD-Core Version:    0.7.0.1
 */