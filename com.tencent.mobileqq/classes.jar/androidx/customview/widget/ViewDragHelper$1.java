package androidx.customview.widget;

import android.view.animation.Interpolator;

final class ViewDragHelper$1
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.customview.widget.ViewDragHelper.1
 * JD-Core Version:    0.7.0.1
 */