package android.support.v4.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

class HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat
  implements ValueAnimatorCompat
{
  final Animator mWrapped;
  
  public HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat(Animator paramAnimator)
  {
    this.mWrapped = paramAnimator;
  }
  
  public void addListener(AnimatorListenerCompat paramAnimatorListenerCompat)
  {
    this.mWrapped.addListener(new HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper(paramAnimatorListenerCompat, this));
  }
  
  public void addUpdateListener(AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat)
  {
    Animator localAnimator = this.mWrapped;
    if ((localAnimator instanceof ValueAnimator)) {
      ((ValueAnimator)localAnimator).addUpdateListener(new HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.1(this, paramAnimatorUpdateListenerCompat));
    }
  }
  
  public void cancel()
  {
    this.mWrapped.cancel();
  }
  
  public float getAnimatedFraction()
  {
    return ((ValueAnimator)this.mWrapped).getAnimatedFraction();
  }
  
  public void setDuration(long paramLong)
  {
    this.mWrapped.setDuration(paramLong);
  }
  
  public void setTarget(View paramView)
  {
    this.mWrapped.setTarget(paramView);
  }
  
  public void start()
  {
    this.mWrapped.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.animation.HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat
 * JD-Core Version:    0.7.0.1
 */