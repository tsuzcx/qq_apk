package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.util.Property;

class GroundDrawable$3
  extends Property<GroundDrawable, Integer>
{
  GroundDrawable$3(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(GroundDrawable paramGroundDrawable)
  {
    if (paramGroundDrawable != null) {
      return Integer.valueOf(GroundDrawable.c(paramGroundDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(GroundDrawable paramGroundDrawable, Integer paramInteger)
  {
    if (paramGroundDrawable != null) {
      GroundDrawable.b(paramGroundDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.GroundDrawable.3
 * JD-Core Version:    0.7.0.1
 */