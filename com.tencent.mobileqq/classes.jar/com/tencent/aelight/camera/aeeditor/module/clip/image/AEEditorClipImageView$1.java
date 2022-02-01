package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AEEditorClipImageView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorClipImageView$1(AEEditorClipImageView paramAEEditorClipImageView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Matrix localMatrix = this.g.getImageMatrix();
    localMatrix.reset();
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    float f1 = (this.a - this.b) * paramValueAnimator.intValue() / 20.0F + this.b;
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate((this.c - this.d) * paramValueAnimator.intValue() / 20.0F + this.d, (this.e - this.f) * paramValueAnimator.intValue() / 20.0F + this.f);
    this.g.setImageMatrix(localMatrix);
    this.g.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipImageView.1
 * JD-Core Version:    0.7.0.1
 */