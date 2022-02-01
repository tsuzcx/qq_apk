package androidx.core.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ViewPropertyAnimatorCompat$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ViewPropertyAnimatorCompat$2(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$listener.onAnimationUpdate(this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ViewPropertyAnimatorCompat.2
 * JD-Core Version:    0.7.0.1
 */