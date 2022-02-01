package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

final class ItemTouchHelper$Callback$2
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.Callback.2
 * JD-Core Version:    0.7.0.1
 */