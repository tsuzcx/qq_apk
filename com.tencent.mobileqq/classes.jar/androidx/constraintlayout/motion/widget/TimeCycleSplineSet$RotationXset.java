package androidx.constraintlayout.motion.widget;

import android.view.View;

class TimeCycleSplineSet$RotationXset
  extends TimeCycleSplineSet
{
  public boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    paramView.setRotationX(get(paramFloat, paramLong, paramView, paramKeyCache));
    return this.mContinue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet.RotationXset
 * JD-Core Version:    0.7.0.1
 */