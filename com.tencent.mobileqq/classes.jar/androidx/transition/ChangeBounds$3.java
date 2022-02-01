package androidx.transition;

import android.graphics.PointF;
import android.util.Property;

final class ChangeBounds$3
  extends Property<ChangeBounds.ViewBounds, PointF>
{
  ChangeBounds$3(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF get(ChangeBounds.ViewBounds paramViewBounds)
  {
    return null;
  }
  
  public void set(ChangeBounds.ViewBounds paramViewBounds, PointF paramPointF)
  {
    paramViewBounds.setBottomRight(paramPointF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeBounds.3
 * JD-Core Version:    0.7.0.1
 */