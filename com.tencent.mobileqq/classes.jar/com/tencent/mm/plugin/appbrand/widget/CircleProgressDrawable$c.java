package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

class CircleProgressDrawable$c
{
  public static final Interpolator a = PathInterpolatorCompat.create(b);
  private static final Path b = new Path();
  
  static
  {
    b.lineTo(0.5F, 0.0F);
    b.cubicTo(0.7F, 0.0F, 0.6F, 1.0F, 1.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.c
 * JD-Core Version:    0.7.0.1
 */