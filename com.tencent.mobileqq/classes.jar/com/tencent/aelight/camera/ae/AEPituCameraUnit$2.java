package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.AEMaterialPanelListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$2
  implements AEMaterialPanel.AEMaterialPanelListener
{
  AEPituCameraUnit$2(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a(null);
    this.a.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(851970, new Object[] { AEMaterialMetaData.a });
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (this.a.b == AECaptureMode.NORMAL)
    {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a(paramAEMaterialMetaData);
      this.a.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(851970, new Object[] { paramAEMaterialMetaData });
      return;
    }
    AEQLog.d(this.a.jdField_a_of_type_JavaLangString, "onMaterialSelected---but current capture mode is not normal");
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */