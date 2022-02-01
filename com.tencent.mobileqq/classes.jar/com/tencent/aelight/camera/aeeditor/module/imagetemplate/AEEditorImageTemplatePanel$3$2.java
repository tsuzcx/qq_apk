package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;

class AEEditorImageTemplatePanel$3$2
  implements DialogInterface.OnClickListener
{
  AEEditorImageTemplatePanel$3$2(AEEditorImageTemplatePanel.3 param3, MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEEditorImageTemplatePanel.a(this.c.a, this.a);
    this.b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.3.2
 * JD-Core Version:    0.7.0.1
 */