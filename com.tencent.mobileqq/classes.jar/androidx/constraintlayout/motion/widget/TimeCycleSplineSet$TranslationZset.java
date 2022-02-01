package androidx.constraintlayout.motion.widget;

import android.os.Build.VERSION;
import android.view.View;

class TimeCycleSplineSet$TranslationZset
  extends TimeCycleSplineSet
{
  public boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTranslationZ(get(paramFloat, paramLong, paramView, paramKeyCache));
    }
    return this.mContinue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet.TranslationZset
 * JD-Core Version:    0.7.0.1
 */