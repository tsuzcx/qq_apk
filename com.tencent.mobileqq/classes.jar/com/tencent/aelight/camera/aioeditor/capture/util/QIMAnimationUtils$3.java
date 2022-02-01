package com.tencent.aelight.camera.aioeditor.capture.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.qphone.base.util.QLog;

final class QIMAnimationUtils$3
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  QIMAnimationUtils$3(View paramView) {}
  
  @TargetApi(11)
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (QLog.isColorLevel())
    {
      paramValueAnimation = new StringBuilder();
      paramValueAnimation.append("alphaAnimation value = ");
      paramValueAnimation.append(paramFloat1);
      QLog.e("QIMAnimationUtils", 2, paramValueAnimation.toString());
    }
    paramFloat = paramFloat1.floatValue();
    paramValueAnimation = this.a;
    if (paramValueAnimation != null)
    {
      paramValueAnimation.setAlpha(paramFloat);
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils.3
 * JD-Core Version:    0.7.0.1
 */