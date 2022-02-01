package com.google.android.material.progressindicator;

import androidx.dynamicanimation.animation.FloatPropertyCompat;

final class DeterminateDrawable$1
  extends FloatPropertyCompat<DeterminateDrawable>
{
  DeterminateDrawable$1(String paramString)
  {
    super(paramString);
  }
  
  public float a(DeterminateDrawable paramDeterminateDrawable)
  {
    return DeterminateDrawable.a(paramDeterminateDrawable) * 10000.0F;
  }
  
  public void a(DeterminateDrawable paramDeterminateDrawable, float paramFloat)
  {
    DeterminateDrawable.a(paramDeterminateDrawable, paramFloat / 10000.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.DeterminateDrawable.1
 * JD-Core Version:    0.7.0.1
 */