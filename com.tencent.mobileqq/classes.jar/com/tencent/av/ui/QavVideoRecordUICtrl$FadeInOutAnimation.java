package com.tencent.av.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class QavVideoRecordUICtrl$FadeInOutAnimation
  extends Animation
{
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f;
    if (paramFloat < 0.5F) {
      f = 0.5F - paramFloat;
    } else {
      f = paramFloat - 0.5F;
    }
    paramTransformation.setAlpha(f / 0.5F);
    super.applyTransformation(paramFloat, paramTransformation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.FadeInOutAnimation
 * JD-Core Version:    0.7.0.1
 */