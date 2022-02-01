package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.util.Property;

class GroundDrawable$8
  extends Property<GroundDrawable, Integer>
{
  GroundDrawable$8(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(GroundDrawable paramGroundDrawable)
  {
    if (paramGroundDrawable != null) {
      return Integer.valueOf(GroundDrawable.h(paramGroundDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(GroundDrawable paramGroundDrawable, Integer paramInteger)
  {
    if (paramGroundDrawable != null) {
      GroundDrawable.d(paramGroundDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.GroundDrawable.8
 * JD-Core Version:    0.7.0.1
 */