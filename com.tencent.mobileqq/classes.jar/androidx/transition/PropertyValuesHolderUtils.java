package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class PropertyValuesHolderUtils
{
  static PropertyValuesHolder ofPointF(Property<?, PointF> paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return PropertyValuesHolder.ofObject(paramProperty, null, paramPath);
    }
    return PropertyValuesHolder.ofFloat(new PathProperty(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.PropertyValuesHolderUtils
 * JD-Core Version:    0.7.0.1
 */