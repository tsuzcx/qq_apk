package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

class AEEditorClipImageView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.b.getImageMatrix();
    if (AEEditorClipImageView.a(this.b, paramValueAnimator) <= AEEditorClipImageView.d(this.b)) {
      return;
    }
    float f = (float)Math.pow(AEEditorClipImageView.d(this.b) / this.a, 0.0500000007450581D);
    paramValueAnimator.postScale(f, f, AEEditorClipImageView.e(this.b), AEEditorClipImageView.f(this.b));
    this.b.setImageMatrix(paramValueAnimator);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipImageView.5
 * JD-Core Version:    0.7.0.1
 */