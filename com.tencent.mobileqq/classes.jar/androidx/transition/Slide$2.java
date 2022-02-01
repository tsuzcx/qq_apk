package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

final class Slide$2
  extends Slide.CalculateSlideHorizontal
{
  Slide$2()
  {
    super(null);
  }
  
  public float getGoneX(ViewGroup paramViewGroup, View paramView)
  {
    int j = ViewCompat.getLayoutDirection(paramViewGroup);
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0) {
      return paramView.getTranslationX() + paramViewGroup.getWidth();
    }
    return paramView.getTranslationX() - paramViewGroup.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Slide.2
 * JD-Core Version:    0.7.0.1
 */