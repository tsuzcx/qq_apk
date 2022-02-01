package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

final class ChangeBounds$4
  extends Property<View, PointF>
{
  ChangeBounds$4(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF get(View paramView)
  {
    return null;
  }
  
  public void set(View paramView, PointF paramPointF)
  {
    ViewUtils.setLeftTopRightBottom(paramView, paramView.getLeft(), paramView.getTop(), Math.round(paramPointF.x), Math.round(paramPointF.y));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeBounds.4
 * JD-Core Version:    0.7.0.1
 */