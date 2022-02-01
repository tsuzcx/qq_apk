package androidx.constraintlayout.motion.widget;

import android.os.Build.VERSION;
import android.view.View;

class SplineSet$TranslationZset
  extends SplineSet
{
  public void setProperty(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTranslationZ(get(paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.SplineSet.TranslationZset
 * JD-Core Version:    0.7.0.1
 */