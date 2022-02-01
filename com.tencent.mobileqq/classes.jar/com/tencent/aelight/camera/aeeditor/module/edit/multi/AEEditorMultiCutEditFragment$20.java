package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.view.View;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.aeeditor.view.videotrack.TrackSelectedStateChangeListener;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;

class AEEditorMultiCutEditFragment$20
  implements TrackSelectedStateChangeListener
{
  AEEditorMultiCutEditFragment$20(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(IDragView paramIDragView, boolean paramBoolean, int paramInt)
  {
    this.a.a.b();
    if (paramBoolean)
    {
      ((View)paramIDragView).post(new AEEditorMultiCutEditFragment.20.1(this, paramIDragView));
      if (AEEditorMultiCutEditFragment.a(this.a).a()) {
        AEEditorMultiCutEditFragment.a(this.a).b();
      }
    }
    else
    {
      ((View)paramIDragView).post(new AEEditorMultiCutEditFragment.20.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.20
 * JD-Core Version:    0.7.0.1
 */