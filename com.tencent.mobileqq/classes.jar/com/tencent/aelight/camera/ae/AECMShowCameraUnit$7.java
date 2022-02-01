package com.tencent.aelight.camera.ae;

import android.animation.ValueAnimator;

class AECMShowCameraUnit$7
  implements Runnable
{
  AECMShowCameraUnit$7(AECMShowCameraUnit paramAECMShowCameraUnit, int paramInt) {}
  
  public void run()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addListener(new AECMShowCameraUnit.7.1(this));
    localValueAnimator.addUpdateListener(new AECMShowCameraUnit.7.2(this));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.7
 * JD-Core Version:    0.7.0.1
 */