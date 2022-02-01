package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MaterialContentAdapter$2$1
  implements ApplyMaterialTask.MaterialStatusCallback
{
  MaterialContentAdapter$2$1(MaterialContentAdapter.2 param2) {}
  
  public void a(@NonNull ApplyMaterialTask.Status paramStatus, int paramInt)
  {
    ApplyMaterialTaskHelper.a("onDownloadMaterial", this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, String.format("callback: %s-%s", new Object[] { paramStatus, Integer.valueOf(paramInt) }));
    int i = MaterialContentAdapter.5.a[paramStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        MaterialContentAdapter.b(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
        MaterialContentAdapter.a(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, ApplyMaterialTask.Status.FAILED, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
        MaterialContentAdapter.a(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, "-90000000");
        return;
      }
      MetaMaterialKt.a(this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, 100);
      MaterialContentAdapter.a(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, ApplyMaterialTask.Status.SUCCEEDED, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      MaterialContentAdapter.a(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, "0");
      return;
    }
    MetaMaterialKt.a(this.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, paramInt);
    ThreadManager.getUIHandler().post(new MaterialContentAdapter.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */