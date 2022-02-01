package androidx.transition;

import android.util.Property;
import android.view.View;

final class ViewUtils$1
  extends Property<View, Float>
{
  ViewUtils$1(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float get(View paramView)
  {
    return Float.valueOf(ViewUtils.getTransitionAlpha(paramView));
  }
  
  public void set(View paramView, Float paramFloat)
  {
    ViewUtils.setTransitionAlpha(paramView, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewUtils.1
 * JD-Core Version:    0.7.0.1
 */