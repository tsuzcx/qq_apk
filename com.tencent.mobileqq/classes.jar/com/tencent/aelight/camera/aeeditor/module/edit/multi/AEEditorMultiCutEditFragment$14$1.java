package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.action.ActionFactory;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;

class AEEditorMultiCutEditFragment$14$1
  implements DialogInterface.OnClickListener
{
  AEEditorMultiCutEditFragment$14$1(AEEditorMultiCutEditFragment.14 param14, CutModelKt paramCutModelKt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a, this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getPath());
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a, 0L);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a).a.postValue(ActionFactory.a(this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getUuid(), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a).getMediaModel()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.14.1
 * JD-Core Version:    0.7.0.1
 */