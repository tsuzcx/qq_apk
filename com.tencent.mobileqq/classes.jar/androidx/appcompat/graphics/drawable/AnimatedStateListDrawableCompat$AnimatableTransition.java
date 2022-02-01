package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Animatable;

class AnimatedStateListDrawableCompat$AnimatableTransition
  extends AnimatedStateListDrawableCompat.Transition
{
  private final Animatable mA;
  
  AnimatedStateListDrawableCompat$AnimatableTransition(Animatable paramAnimatable)
  {
    super(null);
    this.mA = paramAnimatable;
  }
  
  public void start()
  {
    this.mA.start();
  }
  
  public void stop()
  {
    this.mA.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.AnimatableTransition
 * JD-Core Version:    0.7.0.1
 */