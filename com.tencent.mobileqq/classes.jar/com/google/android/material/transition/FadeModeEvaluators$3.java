package com.google.android.material.transition;

final class FadeModeEvaluators$3
  implements FadeModeEvaluator
{
  public FadeModeResult a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return FadeModeResult.a(TransitionUtils.a(255, 0, paramFloat2, paramFloat3, paramFloat1), TransitionUtils.a(0, 255, paramFloat2, paramFloat3, paramFloat1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.FadeModeEvaluators.3
 * JD-Core Version:    0.7.0.1
 */