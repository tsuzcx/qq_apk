package com.tencent.luggage.wxa.ij;

import android.view.animation.Interpolator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/interpolator/EaseInOut;", "Landroid/view/animation/Interpolator;", "()V", "getInterpolation", "", "input", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.5F)
    {
      paramFloat *= 2.0F;
      return 0.5F * paramFloat * paramFloat * paramFloat * paramFloat * paramFloat;
    }
    float f2 = 2;
    float f1 = 1;
    paramFloat = (paramFloat - 0.5F) * f2 - f1;
    return 0.5F * paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ij.a
 * JD-Core Version:    0.7.0.1
 */