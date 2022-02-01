package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;

class AEEditorImageTemplatePanel$3$1
  implements DialogInterface.OnClickListener
{
  AEEditorImageTemplatePanel$3$1(AEEditorImageTemplatePanel.3 param3, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(ApplyMaterialTask.Status.FAILED, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.3.1
 * JD-Core Version:    0.7.0.1
 */