package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

public abstract class MotionInterpolator
  implements Interpolator
{
  public abstract float getInterpolation(float paramFloat);
  
  public abstract float getVelocity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionInterpolator
 * JD-Core Version:    0.7.0.1
 */