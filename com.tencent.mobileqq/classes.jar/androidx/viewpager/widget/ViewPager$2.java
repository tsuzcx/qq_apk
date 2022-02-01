package androidx.viewpager.widget;

import android.view.animation.Interpolator;

final class ViewPager$2
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager.widget.ViewPager.2
 * JD-Core Version:    0.7.0.1
 */