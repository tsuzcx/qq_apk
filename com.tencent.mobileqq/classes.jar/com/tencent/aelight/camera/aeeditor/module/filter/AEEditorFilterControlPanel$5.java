package com.tencent.aelight.camera.aeeditor.module.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class AEEditorFilterControlPanel$5
  implements Runnable
{
  AEEditorFilterControlPanel$5(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void run()
  {
    File localFile = new File(AEEditorResourceManager.a().c(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial));
    if (localFile.exists())
    {
      if (AEEditorFilterControlPanel.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, FileUtils.readFileContent(localFile)))
      {
        AEEditorFilterControlPanel.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$MaterialStatusCallback);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$MaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$MaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.5
 * JD-Core Version:    0.7.0.1
 */