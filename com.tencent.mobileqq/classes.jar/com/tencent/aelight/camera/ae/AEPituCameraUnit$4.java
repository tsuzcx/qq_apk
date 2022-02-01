package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.AEARCakePanelListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$4
  implements AEARCakePanel.AEARCakePanelListener
{
  AEPituCameraUnit$4(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    String str = this.a.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake onMaterialSelected");
    localStringBuilder.append(paramAEMaterialMetaData);
    AEQLog.a(str, localStringBuilder.toString());
    this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a(paramAEMaterialMetaData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.4
 * JD-Core Version:    0.7.0.1
 */