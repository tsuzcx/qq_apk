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
    AEEditorMultiCutEditFragment.u(this.a).setScrollX(paramView.getScrollX());
    AEEditorMultiCutEditFragment.u(this.a).postInvalidate();
    if (AEEditorMultiCutEditFragment.e(this.a).a()) {
      AEEditorMultiCutEditFragment.e(this.a).c();
    }
    AEEditorMultiCutEditFragment localAEEditorMultiCutEditFragment = this.a;
    AEEditorMultiCutEditFragment.c(localAEEditorMultiCutEditFragment, AEEditorMultiCutEditFragment.k(localAEEditorMultiCutEditFragment).c(paramView.getScrollX()));
    this.a.h.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.18
 * JD-Core Version:    0.7.0.1
 */