package com.tencent.aelight.camera.ae.flashshow;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class AEFlashShowCameraUnit$2$1
  extends ViewOutlineProvider
{
  AEFlashShowCameraUnit$2$1(AEFlashShowCameraUnit.2 param2) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), 40.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.2.1
 * JD-Core Version:    0.7.0.1
 */