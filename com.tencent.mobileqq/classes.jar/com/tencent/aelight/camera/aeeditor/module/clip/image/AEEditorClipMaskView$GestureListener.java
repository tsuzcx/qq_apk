package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;

class AEEditorClipMaskView$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private AEEditorClipMaskView$GestureListener(AEEditorClipMaskView paramAEEditorClipMaskView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!AEEditorClipMaskView.b(this.a)) {
      return false;
    }
    if (AEEditorClipMaskView.c(this.a))
    {
      AEQLog.d(AEEditorClipMaskView.c(), "Cropping current bitmap. Can't perform this action right now.");
      return false;
    }
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      if ((paramMotionEvent1.getPointerCount() <= 1) && (paramMotionEvent2.getPointerCount() <= 1))
      {
        boolean bool = AEEditorClipMaskView.a(this.a, paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        paramMotionEvent1 = AEEditorClipMaskView.c();
        paramMotionEvent2 = new StringBuilder();
        paramMotionEvent2.append("GestureListener onScroll result:");
        paramMotionEvent2.append(bool);
        AEQLog.d(paramMotionEvent1, paramMotionEvent2.toString());
        return bool;
      }
      AEQLog.d(AEEditorClipMaskView.c(), "Double finger scaling. Can't perform this action right now.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipMaskView.GestureListener
 * JD-Core Version:    0.7.0.1
 */