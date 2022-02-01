package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.util.Property;

class PickerContainer$1
  extends Property<PickerContainer, Float>
{
  PickerContainer$1(PickerContainer paramPickerContainer, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(PickerContainer paramPickerContainer)
  {
    if (paramPickerContainer != null) {
      return PickerContainer.a(paramPickerContainer);
    }
    return Float.valueOf(1.0F);
  }
  
  public void a(PickerContainer paramPickerContainer, Float paramFloat)
  {
    if (paramPickerContainer != null) {
      PickerContainer.a(paramPickerContainer, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.1
 * JD-Core Version:    0.7.0.1
 */