package androidx.constraintlayout.motion.widget;

import android.view.View;

class SplineSet$PathRotate
  extends SplineSet
{
  public void setPathRotate(View paramView, float paramFloat, double paramDouble1, double paramDouble2)
  {
    paramView.setRotation(get(paramFloat) + (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1)));
  }
  
  public void setProperty(View paramView, float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.SplineSet.PathRotate
 * JD-Core Version:    0.7.0.1
 */