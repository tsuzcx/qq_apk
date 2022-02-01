package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;

class MaterialContentAdapter$2
  implements ApplyMaterialTask.MaterialStatusCallback
{
  MaterialContentAdapter$2(MaterialContentAdapter paramMaterialContentAdapter, MetaMaterial paramMetaMaterial, int paramInt) {}
  
  public void a(@NonNull ApplyMaterialTask.Status paramStatus, int paramInt)
  {
    ApplyMaterialTaskHelper.a("onPreExecute", this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, String.format("callback: %s-%s", new Object[] { paramStatus, Integer.valueOf(paramInt) }));
    if (paramStatus == ApplyMaterialTask.Status.SUCCEEDED)
    {
      boolean bool = MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      ApplyMaterialTaskHelper.a("isApplyMaterialLocal", this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, String.valueOf(bool));
      if (bool)
      {
        bool = MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter).b(this.jdField_a_of_type_Int, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
        ApplyMaterialTaskHelper.a("isMaterialReady", this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, String.valueOf(bool));
        if ((!bool) && (MetaMaterialKt.c(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial) != 100))
        {
          if (MetaMaterialKt.c(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial) < 0)
          {
            MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter).b(this.jdField_a_of_type_Int, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
            ApplyMaterialTaskHelper.a("onDownloadMaterial", this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, "start");
            ApplyMaterialTaskHelper.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, new MaterialContentAdapter.2.1(this));
            return;
          }
          ApplyMaterialTaskHelper.a("executeApplyMaterialTask", this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, String.format("run into wrong branch: isMaterialReady=%s, downloadProgress=%s", new Object[] { Boolean.valueOf(MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter).b(this.jdField_a_of_type_Int, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial)), Integer.valueOf(MetaMaterialKt.c(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial)) }));
          return;
        }
        MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, ApplyMaterialTask.Status.SUCCEEDED, this.jdField_a_of_type_Int, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
        return;
      }
      ApplyMaterialTaskHelper.a("onApplyMaterialOnline", this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, "start");
      MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.2
 * JD-Core Version:    0.7.0.1
 */