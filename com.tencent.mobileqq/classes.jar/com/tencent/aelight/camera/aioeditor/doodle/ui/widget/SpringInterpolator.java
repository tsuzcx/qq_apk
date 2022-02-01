package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.animation.TimeInterpolator;

public class SpringInterpolator
  implements TimeInterpolator
{
  public float getInterpolation(float paramFloat)
  {
    double d1 = Math.pow(2.0D, -10.0F * paramFloat);
    double d2 = paramFloat - 0.175F;
    Double.isNaN(d2);
    double d3 = 0.7F;
    Double.isNaN(d3);
    return (float)(d1 * Math.sin(d2 * 6.283185307179586D / d3) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.SpringInterpolator
 * JD-Core Version:    0.7.0.1
 */