package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build.VERSION;

class AnimatedStateListDrawableCompat$AnimationDrawableTransition
  extends AnimatedStateListDrawableCompat.Transition
{
  private final ObjectAnimator mAnim;
  private final boolean mHasReversibleFlag;
  
  AnimatedStateListDrawableCompat$AnimationDrawableTransition(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(null);
    int j = paramAnimationDrawable.getNumberOfFrames();
    int i;
    if (paramBoolean1) {
      i = j - 1;
    } else {
      i = 0;
    }
    if (paramBoolean1) {
      j = 0;
    } else {
      j -= 1;
    }
    AnimatedStateListDrawableCompat.FrameInterpolator localFrameInterpolator = new AnimatedStateListDrawableCompat.FrameInterpolator(paramAnimationDrawable, paramBoolean1);
    paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { i, j });
    if (Build.VERSION.SDK_INT >= 18) {
      paramAnimationDrawable.setAutoCancel(true);
    }
    paramAnimationDrawable.setDuration(localFrameInterpolator.getTotalDuration());
    paramAnimationDrawable.setInterpolator(localFrameInterpolator);
    this.mHasReversibleFlag = paramBoolean2;
    this.mAnim = paramAnimationDrawable;
  }
  
  public boolean canReverse()
  {
    return this.mHasReversibleFlag;
  }
  
  public void reverse()
  {
    this.mAnim.reverse();
  }
  
  public void start()
  {
    this.mAnim.start();
  }
  
  public void stop()
  {
    this.mAnim.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.AnimationDrawableTransition
 * JD-Core Version:    0.7.0.1
 */