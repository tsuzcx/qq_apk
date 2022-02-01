package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView;
import com.tencent.aelight.camera.aeeditor.view.timeline.ScaleScrollLayout;

class AEEditorMultiCutEditFragment$1$1
  extends AnimatorListenerAdapter
{
  AEEditorMultiCutEditFragment$1$1(AEEditorMultiCutEditFragment.1 param1, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEEditorMultiCutEditFragment.d(this.b.a).b())
    {
      if (AEEditorMultiCutEditFragment.a(this.b.a) != null) {
        AEEditorMultiCutEditFragment.a(this.b.a).setVisibility(0);
      }
      if (AEEditorMultiCutEditFragment.b(this.b.a) != null) {
        AEEditorMultiCutEditFragment.b(this.b.a).setVisibility(0);
      }
      return;
    }
    AEEditorMultiCutEditFragment.c(this.b.a).setVisibility(0);
    AEEditorMultiCutEditFragment.c(this.b.a).a(this.a);
    AEEditorMultiCutEditFragment.d(this.b.a).setVisibility(4);
    AEEditorMultiCutEditFragment.d(this.b.a).setHandleView(AEEditorMultiCutEditFragment.c(this.b.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.1.1
 * JD-Core Version:    0.7.0.1
 */