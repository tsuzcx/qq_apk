package com.tencent.aelight.camera.aeeditor.view.classifier;

class MaterialContentAdapter$3$1
  implements Runnable
{
  MaterialContentAdapter$3$1(MaterialContentAdapter.3 param3, ApplyMaterialTask.Status paramStatus) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$Status == ApplyMaterialTask.Status.FAILED)
    {
      MaterialContentAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      return;
    }
    int i = MaterialContentAdapter.5.a[this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$Status.ordinal()];
    if (i != 2)
    {
      if (i != 3) {
        return;
      }
      MaterialContentAdapter.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      return;
    }
    if (MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter) == this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_Int)
    {
      ApplyMaterialTaskHelper.a("onApplyMaterialLocal", this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, "start");
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_Int, true);
      MaterialContentAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter).c(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter$3.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */