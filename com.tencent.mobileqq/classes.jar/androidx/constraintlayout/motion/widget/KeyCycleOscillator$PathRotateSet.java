package androidx.constraintlayout.motion.widget;

import android.view.View;

class KeyCycleOscillator$PathRotateSet
  extends KeyCycleOscillator
{
  public void setPathRotate(View paramView, float paramFloat, double paramDouble1, double paramDouble2)
  {
    paramView.setRotation(get(paramFloat) + (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1)));
  }
  
  public void setProperty(View paramView, float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet
 * JD-Core Version:    0.7.0.1
 */