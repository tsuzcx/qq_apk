package androidx.constraintlayout.motion.widget;

import android.view.View;

class TimeCycleSplineSet$RotationSet
  extends TimeCycleSplineSet
{
  public boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    paramView.setRotation(get(paramFloat, paramLong, paramView, paramKeyCache));
    return this.mContinue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet.RotationSet
 * JD-Core Version:    0.7.0.1
 */