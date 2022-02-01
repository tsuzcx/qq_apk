package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AEEditorClipImageView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorClipImageView$3(AEEditorClipImageView paramAEEditorClipImageView, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.f.getImageMatrix();
    float f2 = AEEditorClipImageView.a(this.f, this.a, 2);
    float f3 = AEEditorClipImageView.a(this.f, this.a, 5);
    paramValueAnimator.postTranslate(this.b * f1 - (f2 - this.c), this.d * f1 - (f3 - this.e));
    this.f.setImageMatrix(paramValueAnimator);
    this.f.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipImageView.3
 * JD-Core Version:    0.7.0.1
 */