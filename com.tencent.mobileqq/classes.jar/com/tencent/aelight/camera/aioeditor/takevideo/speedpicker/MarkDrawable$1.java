package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.util.Property;

class MarkDrawable$1
  extends Property<MarkDrawable, Integer>
{
  MarkDrawable$1(MarkDrawable paramMarkDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(MarkDrawable paramMarkDrawable)
  {
    if (paramMarkDrawable != null) {
      return Integer.valueOf(MarkDrawable.a(paramMarkDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(MarkDrawable paramMarkDrawable, Integer paramInteger)
  {
    if (paramMarkDrawable != null) {
      MarkDrawable.a(paramMarkDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.MarkDrawable.1
 * JD-Core Version:    0.7.0.1
 */