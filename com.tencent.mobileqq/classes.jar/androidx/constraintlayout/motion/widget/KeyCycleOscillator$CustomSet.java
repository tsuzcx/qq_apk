package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;

class KeyCycleOscillator$CustomSet
  extends KeyCycleOscillator
{
  float[] value = new float[1];
  
  public void setProperty(View paramView, float paramFloat)
  {
    this.value[0] = get(paramFloat);
    this.mCustom.setInterpolatedValue(paramView, this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCycleOscillator.CustomSet
 * JD-Core Version:    0.7.0.1
 */