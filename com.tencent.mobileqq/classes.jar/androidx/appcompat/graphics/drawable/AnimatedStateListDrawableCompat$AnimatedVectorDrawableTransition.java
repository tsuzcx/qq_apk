package androidx.appcompat.graphics.drawable;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

class AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition
  extends AnimatedStateListDrawableCompat.Transition
{
  private final AnimatedVectorDrawableCompat mAvd;
  
  AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat paramAnimatedVectorDrawableCompat)
  {
    super(null);
    this.mAvd = paramAnimatedVectorDrawableCompat;
  }
  
  public void start()
  {
    this.mAvd.start();
  }
  
  public void stop()
  {
    this.mAvd.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.AnimatedVectorDrawableTransition
 * JD-Core Version:    0.7.0.1
 */