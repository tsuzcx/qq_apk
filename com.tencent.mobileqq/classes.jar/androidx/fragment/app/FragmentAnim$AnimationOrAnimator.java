package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

class FragmentAnim$AnimationOrAnimator
{
  public final Animation animation;
  public final Animator animator;
  
  FragmentAnim$AnimationOrAnimator(Animator paramAnimator)
  {
    this.animation = null;
    this.animator = paramAnimator;
    if (paramAnimator != null) {
      return;
    }
    throw new IllegalStateException("Animator cannot be null");
  }
  
  FragmentAnim$AnimationOrAnimator(Animation paramAnimation)
  {
    this.animation = paramAnimation;
    this.animator = null;
    if (paramAnimation != null) {
      return;
    }
    throw new IllegalStateException("Animation cannot be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim.AnimationOrAnimator
 * JD-Core Version:    0.7.0.1
 */