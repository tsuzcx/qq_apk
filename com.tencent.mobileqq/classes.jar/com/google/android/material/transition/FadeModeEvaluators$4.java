package com.google.android.material.transition;

final class FadeModeEvaluators$4
  implements FadeModeEvaluator
{
  public FadeModeResult a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = (paramFloat3 - paramFloat2) * 0.35F + paramFloat2;
    return FadeModeResult.a(TransitionUtils.a(255, 0, paramFloat2, f, paramFloat1), TransitionUtils.a(0, 255, f, paramFloat3, paramFloat1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.FadeModeEvaluators.4
 * JD-Core Version:    0.7.0.1
 */