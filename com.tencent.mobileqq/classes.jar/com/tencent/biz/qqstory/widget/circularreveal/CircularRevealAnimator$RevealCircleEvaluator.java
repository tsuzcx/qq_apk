package com.tencent.biz.qqstory.widget.circularreveal;

import android.animation.TypeEvaluator;

final class CircularRevealAnimator$RevealCircleEvaluator
  implements TypeEvaluator<CircularRevealAnimator.RevealCircle>
{
  private CircularRevealAnimator.RevealCircle a;
  
  public CircularRevealAnimator.RevealCircle a(float paramFloat, CircularRevealAnimator.RevealCircle paramRevealCircle1, CircularRevealAnimator.RevealCircle paramRevealCircle2)
  {
    float f1 = paramRevealCircle1.a + (paramRevealCircle2.a - paramRevealCircle1.a) * paramFloat;
    float f2 = paramRevealCircle1.b + (paramRevealCircle2.b - paramRevealCircle1.b) * paramFloat;
    paramFloat = paramRevealCircle1.c + (paramRevealCircle2.c - paramRevealCircle1.c) * paramFloat;
    if (this.a == null) {
      this.a = new CircularRevealAnimator.RevealCircle(f1, f2, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a = f1;
      this.a.b = f2;
      this.a.c = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.CircularRevealAnimator.RevealCircleEvaluator
 * JD-Core Version:    0.7.0.1
 */