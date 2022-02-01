package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class AEBeautyProviderView$3
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  AEBeautyProviderView$3(AEBeautyProviderView paramAEBeautyProviderView, AEProviderContainerView paramAEProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramFloat = paramFloat1.floatValue();
    paramValueAnimation = this.a;
    if (paramValueAnimation != null) {
      paramValueAnimation.setBackGroundAlpha(paramFloat);
    }
    paramValueAnimation = this.b;
    if (paramValueAnimation != null) {
      paramValueAnimation.setAlpha(paramFloat);
    }
    AEBeautyProviderView.a(this.c, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView.3
 * JD-Core Version:    0.7.0.1
 */