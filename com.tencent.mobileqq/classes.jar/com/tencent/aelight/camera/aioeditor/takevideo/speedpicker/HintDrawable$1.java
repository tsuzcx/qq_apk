package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.util.Property;

class HintDrawable$1
  extends Property<HintDrawable, Float>
{
  HintDrawable$1(HintDrawable paramHintDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(HintDrawable paramHintDrawable)
  {
    if (paramHintDrawable != null) {
      return Float.valueOf(HintDrawable.a(paramHintDrawable));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(HintDrawable paramHintDrawable, Float paramFloat)
  {
    if (paramHintDrawable != null) {
      HintDrawable.a(paramHintDrawable, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.HintDrawable.1
 * JD-Core Version:    0.7.0.1
 */