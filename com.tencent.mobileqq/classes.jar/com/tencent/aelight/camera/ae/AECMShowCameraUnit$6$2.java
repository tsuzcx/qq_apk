package com.tencent.aelight.camera.ae;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView;

class AECMShowCameraUnit$6$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AECMShowCameraUnit$6$2(AECMShowCameraUnit.6 param6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(paramValueAnimator.floatValue());
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(paramValueAnimator.floatValue() * 255.0F);
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(1.0F - paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.6.2
 * JD-Core Version:    0.7.0.1
 */