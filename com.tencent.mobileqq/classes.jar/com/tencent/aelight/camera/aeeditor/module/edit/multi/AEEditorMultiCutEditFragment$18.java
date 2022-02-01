package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.view.View;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragDropScrollListener;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;

class AEEditorMultiCutEditFragment$18
  implements IDragDropScrollListener
{
  AEEditorMultiCutEditFragment$18(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AEEditorMultiCutEditFragment.a(this.a).setScrollX(paramView.getScrollX());
    AEEditorMultiCutEditFragment.a(this.a).postInvalidate();
    if (AEEditorMultiCutEditFragment.a(this.a).a()) {
      AEEditorMultiCutEditFragment.a(this.a).b();
    }
    AEEditorMultiCutEditFragment localAEEditorMultiCutEditFragment = this.a;
    AEEditorMultiCutEditFragment.c(localAEEditorMultiCutEditFragment, AEEditorMultiCutEditFragment.a(localAEEditorMultiCutEditFragment).b(paramView.getScrollX()));
    this.a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.18
 * JD-Core Version:    0.7.0.1
 */