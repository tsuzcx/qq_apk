package com.tencent.aelight.camera.aeeditor.module.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;

class AEEditorFilterControlPanel$7
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorFilterControlPanel$7(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$MaterialStatusCallback.a(ApplyMaterialTask.Status.ONGOING, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FilterMetaMaterialKt.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, true);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$MaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$MaterialStatusCallback.a(ApplyMaterialTask.Status.FAILED, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.7
 * JD-Core Version:    0.7.0.1
 */