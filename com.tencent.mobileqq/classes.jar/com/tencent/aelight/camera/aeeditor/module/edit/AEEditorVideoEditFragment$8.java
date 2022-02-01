package com.tencent.aelight.camera.aeeditor.module.edit;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;

class AEEditorVideoEditFragment$8
  implements View.OnTouchListener
{
  AEEditorVideoEditFragment$8(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, GestureDetector paramGestureDetector) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      this.b.B.toggleAEKit(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.8
 * JD-Core Version:    0.7.0.1
 */