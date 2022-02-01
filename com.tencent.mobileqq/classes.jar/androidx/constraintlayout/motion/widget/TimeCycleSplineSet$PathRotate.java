package androidx.constraintlayout.motion.widget;

import android.view.View;

class TimeCycleSplineSet$PathRotate
  extends TimeCycleSplineSet
{
  public boolean setPathRotate(View paramView, KeyCache paramKeyCache, float paramFloat, long paramLong, double paramDouble1, double paramDouble2)
  {
    paramView.setRotation(get(paramFloat, paramLong, paramView, paramKeyCache) + (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1)));
    return this.mContinue;
  }
  
  public boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    return this.mContinue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate
 * JD-Core Version:    0.7.0.1
 */