package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;

class AEEditorVideoEditFragment$31
  implements DialogInterface.OnClickListener
{
  AEEditorVideoEditFragment$31(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEBaseDataReporter.a().w();
    this.a.getArguments().putSerializable("resource_model", null);
    this.a.getArguments().putSerializable("resource_model", this.a.a);
    AEEditorVideoEditFragment.e(this.a);
    this.a.a().a(this.a.getActivity());
    this.a.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.31
 * JD-Core Version:    0.7.0.1
 */