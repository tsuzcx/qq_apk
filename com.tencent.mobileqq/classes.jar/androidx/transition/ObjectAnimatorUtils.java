package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class ObjectAnimatorUtils
{
  static <T> ObjectAnimator ofPointF(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ObjectAnimator.ofObject(paramT, paramProperty, null, paramPath);
    }
    return ObjectAnimator.ofFloat(paramT, new PathProperty(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ObjectAnimatorUtils
 * JD-Core Version:    0.7.0.1
 */