package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView;
import com.tencent.aelight.camera.aeeditor.view.timeline.ScaleScrollLayout;

class AEEditorMultiCutEditFragment$1$1
  extends AnimatorListenerAdapter
{
  AEEditorMultiCutEditFragment$1$1(AEEditorMultiCutEditFragment.1 param1, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$1.a).a()) {
      return;
    }
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$1.a).setVisibility(0);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$1.a).a(this.jdField_a_of_type_Int);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$1.a).setVisibility(4);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$1.a).setHandleView(AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$1.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.1.1
 * JD-Core Version:    0.7.0.1
 */