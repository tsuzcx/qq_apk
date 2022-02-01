package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.AEARCakePanelListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$4
  implements AEARCakePanel.AEARCakePanelListener
{
  AEPituCameraUnit$4(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake onMaterialSelected");
    localStringBuilder.append(paramAEMaterialMetaData);
    AEQLog.a(str, localStringBuilder.toString());
    if (this.a.ag != null) {
      this.a.ag.a(3, paramAEMaterialMetaData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.4
 * JD-Core Version:    0.7.0.1
 */