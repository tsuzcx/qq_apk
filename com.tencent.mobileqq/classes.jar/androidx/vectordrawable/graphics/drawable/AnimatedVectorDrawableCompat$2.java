package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

class AnimatedVectorDrawableCompat$2
  extends AnimatorListenerAdapter
{
  AnimatedVectorDrawableCompat$2(AnimatedVectorDrawableCompat paramAnimatedVectorDrawableCompat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new ArrayList(this.this$0.mAnimationCallbacks);
    int j = paramAnimator.size();
    int i = 0;
    while (i < j)
    {
      ((Animatable2Compat.AnimationCallback)paramAnimator.get(i)).onAnimationEnd(this.this$0);
      i += 1;
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = new ArrayList(this.this$0.mAnimationCallbacks);
    int j = paramAnimator.size();
    int i = 0;
    while (i < j)
    {
      ((Animatable2Compat.AnimationCallback)paramAnimator.get(i)).onAnimationStart(this.this$0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.2
 * JD-Core Version:    0.7.0.1
 */