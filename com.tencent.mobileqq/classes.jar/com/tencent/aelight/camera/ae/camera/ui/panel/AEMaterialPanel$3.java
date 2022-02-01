package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

class AEMaterialPanel$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AEMaterialPanel$3(AEMaterialPanel paramAEMaterialPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (AEMaterialPanel.a(this.a) != null) {
      AEMaterialPanel.a(this.a).a(851969, new Object[] { paramValueAnimator });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.3
 * JD-Core Version:    0.7.0.1
 */