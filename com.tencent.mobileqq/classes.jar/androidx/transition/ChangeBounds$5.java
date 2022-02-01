package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

final class ChangeBounds$5
  extends Property<View, PointF>
{
  ChangeBounds$5(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF get(View paramView)
  {
    return null;
  }
  
  public void set(View paramView, PointF paramPointF)
  {
    ViewUtils.setLeftTopRightBottom(paramView, Math.round(paramPointF.x), Math.round(paramPointF.y), paramView.getRight(), paramView.getBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeBounds.5
 * JD-Core Version:    0.7.0.1
 */