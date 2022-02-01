package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper
  implements Animator.AnimatorListener
{
  final ValueAnimatorCompat mValueAnimatorCompat;
  final AnimatorListenerCompat mWrapped;
  
  public HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper(AnimatorListenerCompat paramAnimatorListenerCompat, ValueAnimatorCompat paramValueAnimatorCompat)
  {
    this.mWrapped = paramAnimatorListenerCompat;
    this.mValueAnimatorCompat = paramValueAnimatorCompat;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.animation.HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper
 * JD-Core Version:    0.7.0.1
 */