package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

final class ChangeBounds$6
  extends Property<View, PointF>
{
  ChangeBounds$6(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF get(View paramView)
  {
    return null;
  }
  
  public void set(View paramView, PointF paramPointF)
  {
    int i = Math.round(paramPointF.x);
    int j = Math.round(paramPointF.y);
    ViewUtils.setLeftTopRightBottom(paramView, i, j, paramView.getWidth() + i, paramView.getHeight() + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeBounds.6
 * JD-Core Version:    0.7.0.1
 */