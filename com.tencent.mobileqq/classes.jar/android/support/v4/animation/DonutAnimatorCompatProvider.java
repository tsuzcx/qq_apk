package android.support.v4.animation;

import android.view.View;

class DonutAnimatorCompatProvider
  implements AnimatorProvider
{
  public void clearInterpolator(View paramView) {}
  
  public ValueAnimatorCompat emptyValueAnimator()
  {
    return new DonutAnimatorCompatProvider.DonutFloatValueAnimator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.animation.DonutAnimatorCompatProvider
 * JD-Core Version:    0.7.0.1
 */