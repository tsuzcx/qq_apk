package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;

class AEEditorClipMaskView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorClipMaskView$1(AEEditorClipMaskView paramAEEditorClipMaskView, Rect paramRect1, Rect paramRect2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a == null)
    {
      AEEditorClipMaskView.a(this.c, this.b);
    }
    else
    {
      paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
      if (AEEditorClipMaskView.a(this.c) == null) {
        AEEditorClipMaskView.a(this.c, new Rect());
      }
      AEEditorClipMaskView.a(this.c).left = (this.a.left + (int)((this.b.left - this.a.left) * paramValueAnimator.intValue() * 1.0F / 20.0F));
      AEEditorClipMaskView.a(this.c).top = (this.a.top + (int)((this.b.top - this.a.top) * paramValueAnimator.intValue() * 1.0F / 20.0F));
      AEEditorClipMaskView.a(this.c).right = (this.a.right + (int)((this.b.right - this.a.right) * paramValueAnimator.intValue() * 1.0F / 20.0F));
      AEEditorClipMaskView.a(this.c).bottom = (this.a.bottom + (int)((this.b.bottom - this.a.bottom) * paramValueAnimator.intValue() * 1.0F / 20.0F));
    }
    this.c.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipMaskView.1
 * JD-Core Version:    0.7.0.1
 */