package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;

class AEEditorVideoEditFragment$33
  implements DialogInterface.OnClickListener
{
  AEEditorVideoEditFragment$33(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEBaseDataReporter.a().x();
    this.a.getArguments().putSerializable("resource_model", null);
    this.a.getArguments().putSerializable("resource_model", this.a.z);
    AEEditorVideoEditFragment.x(this.a);
    this.a.b().a(this.a.getActivity());
    this.a.G();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.33
 * JD-Core Version:    0.7.0.1
 */