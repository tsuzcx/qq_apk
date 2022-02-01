package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel.AEWaterMarkPanelListener;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;

class AEPituCameraUnit$3
  implements AEWaterMarkPanel.AEWaterMarkPanelListener
{
  AEPituCameraUnit$3(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a()
  {
    AECameraPrefsUtil.a().a("sp_key_ae_user_selected_watermark", "sp_val_ae_user_selected_watermark_none", 0);
    if (this.a.ag != null) {
      this.a.ag.b();
    }
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AECameraPrefsUtil.a().a("sp_key_ae_user_selected_watermark", paramAEMaterialMetaData.m, 0);
    if (this.a.ag != null) {
      this.a.ag.a(2, paramAEMaterialMetaData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.3
 * JD-Core Version:    0.7.0.1
 */