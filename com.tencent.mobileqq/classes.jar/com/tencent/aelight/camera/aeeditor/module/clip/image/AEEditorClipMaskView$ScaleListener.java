package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEEditorClipMaskView$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private AEEditorClipMaskView$ScaleListener(AEEditorClipMaskView paramAEEditorClipMaskView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (!AEEditorClipMaskView.b(this.a)) {
      return false;
    }
    if (this.a.a == 0) {
      return false;
    }
    if (AEEditorClipMaskView.d(this.a))
    {
      AEQLog.d(AEEditorClipMaskView.c(), "Cropping current bitmap. Can't perform this action right now.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipMaskView.ScaleListener
 * JD-Core Version:    0.7.0.1
 */