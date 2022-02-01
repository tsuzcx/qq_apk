package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.AEMaterialPanelListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$2
  implements AEMaterialPanel.AEMaterialPanelListener
{
  AEPituCameraUnit$2(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a()
  {
    if (this.a.ag != null) {
      this.a.ag.b();
    }
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (this.a.x == AECaptureMode.NORMAL)
    {
      if (this.a.ag != null) {
        this.a.ag.a(0, paramAEMaterialMetaData);
      }
    }
    else {
      AEQLog.d(this.a.a, "onMaterialSelected---but current capture mode is not normal");
    }
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */