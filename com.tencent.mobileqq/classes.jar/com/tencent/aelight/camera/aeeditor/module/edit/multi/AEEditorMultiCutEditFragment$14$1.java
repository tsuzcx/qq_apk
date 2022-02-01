package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.action.ActionFactory;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;

class AEEditorMultiCutEditFragment$14$1
  implements DialogInterface.OnClickListener
{
  AEEditorMultiCutEditFragment$14$1(AEEditorMultiCutEditFragment.14 param14, CutModelKt paramCutModelKt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEEditorMultiCutEditFragment.a(this.b.a, this.a.getResource().getPath());
    AEEditorMultiCutEditFragment.a(this.b.a, 0L);
    AEEditorMultiCutEditFragment.e(this.b.a).a.postValue(ActionFactory.a(this.a.getUuid(), AEEditorMultiCutEditFragment.f(this.b.a), AEEditorMultiCutEditFragment.g(this.b.a).getMediaModel()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.14.1
 * JD-Core Version:    0.7.0.1
 */