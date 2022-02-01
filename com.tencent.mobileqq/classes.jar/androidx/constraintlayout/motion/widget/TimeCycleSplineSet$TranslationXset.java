package androidx.constraintlayout.motion.widget;

import android.view.View;

class TimeCycleSplineSet$TranslationXset
  extends TimeCycleSplineSet
{
  public boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    paramView.setTranslationX(get(paramFloat, paramLong, paramView, paramKeyCache));
    return this.mContinue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet.TranslationXset
 * JD-Core Version:    0.7.0.1
 */