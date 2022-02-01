package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEEditorClipImageView$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private AEEditorClipImageView$ScaleListener(AEEditorClipImageView paramAEEditorClipImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (!AEEditorClipImageView.a(this.a)) {
      return false;
    }
    if (AEEditorClipImageView.c(this.a) == 0) {
      return false;
    }
    if (AEEditorClipImageView.b(this.a))
    {
      AEQLog.d(AEEditorClipImageView.d(), "Cropping current bitmap. Can't perform this action right now.");
      return false;
    }
    Matrix localMatrix = this.a.getImageMatrix();
    AEEditorClipImageView.a(this.a, paramScaleGestureDetector.getFocusX());
    AEEditorClipImageView.b(this.a, paramScaleGestureDetector.getFocusY());
    localMatrix.postScale(paramScaleGestureDetector.getScaleFactor() + (paramScaleGestureDetector.getScaleFactor() - 1.0F) * 1.2F, paramScaleGestureDetector.getScaleFactor() + (paramScaleGestureDetector.getScaleFactor() - 1.0F) * 1.2F, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    String str = AEEditorClipImageView.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("detector.getScaleFactor()：");
    localStringBuilder.append(paramScaleGestureDetector.getScaleFactor());
    localStringBuilder.append(" detector.getFocusX() :");
    localStringBuilder.append(paramScaleGestureDetector.getFocusX());
    localStringBuilder.append(" detector.getFocusY():");
    localStringBuilder.append(paramScaleGestureDetector.getFocusY());
    AEQLog.d(str, localStringBuilder.toString());
    this.a.setImageMatrix(localMatrix);
    this.a.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipImageView.ScaleListener
 * JD-Core Version:    0.7.0.1
 */