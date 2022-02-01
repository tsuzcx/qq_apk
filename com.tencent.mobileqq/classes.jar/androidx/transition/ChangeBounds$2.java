package androidx.transition;

import android.graphics.PointF;
import android.util.Property;

final class ChangeBounds$2
  extends Property<ChangeBounds.ViewBounds, PointF>
{
  ChangeBounds$2(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF get(ChangeBounds.ViewBounds paramViewBounds)
  {
    return null;
  }
  
  public void set(ChangeBounds.ViewBounds paramViewBounds, PointF paramPointF)
  {
    paramViewBounds.setTopLeft(paramPointF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeBounds.2
 * JD-Core Version:    0.7.0.1
 */