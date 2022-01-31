package android.support.v4.animation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

class HoneycombMr1AnimatorCompatProvider
  implements AnimatorProvider
{
  private TimeInterpolator mDefaultInterpolator;
  
  public void clearInterpolator(View paramView)
  {
    if (this.mDefaultInterpolator == null) {
      this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(this.mDefaultInterpolator);
  }
  
  public ValueAnimatorCompat emptyValueAnimator()
  {
    return new HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.animation.HoneycombMr1AnimatorCompatProvider
 * JD-Core Version:    0.7.0.1
 */