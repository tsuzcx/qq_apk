package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;

class MotionScene$1
  implements Interpolator
{
  MotionScene$1(MotionScene paramMotionScene, Easing paramEasing) {}
  
  public float getInterpolation(float paramFloat)
  {
    return (float)this.val$easing.get(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionScene.1
 * JD-Core Version:    0.7.0.1
 */