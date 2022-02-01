package com.tencent.aelight.camera.ae.biz.circle.helper;

import android.util.Property;
import android.view.View;

public class PicDragHelperCallback$ScaleProperty
  extends Property<View, Float>
{
  public PicDragHelperCallback$ScaleProperty(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public Float a(View paramView)
  {
    return Float.valueOf(paramView.getScaleX());
  }
  
  public void a(View paramView, Float paramFloat)
  {
    paramView.setScaleX(paramFloat.floatValue());
    paramView.setScaleY(paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.helper.PicDragHelperCallback.ScaleProperty
 * JD-Core Version:    0.7.0.1
 */