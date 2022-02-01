package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

class CircleProgressDrawable$b
{
  public static final Interpolator a = PathInterpolatorCompat.create(b);
  private static final Path b = new Path();
  
  static
  {
    b.cubicTo(0.2F, 0.0F, 0.1F, 1.0F, 0.5F, 1.0F);
    b.lineTo(1.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.b
 * JD-Core Version:    0.7.0.1
 */