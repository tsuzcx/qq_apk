package com.tencent.aelight.camera.ae;

import android.animation.ValueAnimator;

class AECMShowCameraUnit$6
  implements Runnable
{
  AECMShowCameraUnit$6(AECMShowCameraUnit paramAECMShowCameraUnit) {}
  
  public void run()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addListener(new AECMShowCameraUnit.6.1(this));
    localValueAnimator.addUpdateListener(new AECMShowCameraUnit.6.2(this));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.6
 * JD-Core Version:    0.7.0.1
 */