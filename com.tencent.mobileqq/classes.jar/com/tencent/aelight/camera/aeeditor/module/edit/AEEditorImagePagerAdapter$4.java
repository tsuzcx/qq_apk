package com.tencent.aelight.camera.aeeditor.module.edit;

import android.view.MotionEvent;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.view.ext.OnActiveBasePicListener;

class AEEditorImagePagerAdapter$4
  implements OnActiveBasePicListener
{
  AEEditorImagePagerAdapter$4(AEEditorImagePagerAdapter paramAEEditorImagePagerAdapter, int paramInt) {}
  
  public void OnActiveBasePic(boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    AEEditorImagePagerAdapter.b(this.b).activeBasePicCallback(this.a, paramBoolean, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter.4
 * JD-Core Version:    0.7.0.1
 */