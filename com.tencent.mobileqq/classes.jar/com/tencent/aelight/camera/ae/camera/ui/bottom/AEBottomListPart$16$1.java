package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;

class AEBottomListPart$16$1
  implements Runnable
{
  AEBottomListPart$16$1(AEBottomListPart.16 param16, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" material usable id: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
    AEQLog.b("AEBottomListPart", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListPart$16.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListPart$16.this$0.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.b(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.16.1
 * JD-Core Version:    0.7.0.1
 */