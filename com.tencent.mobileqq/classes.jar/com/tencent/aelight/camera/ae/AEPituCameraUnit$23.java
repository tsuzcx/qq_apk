package com.tencent.aelight.camera.ae;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAELocalMaterialItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEMaterialItem;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.qqlive.module.videoreport.VideoReport;

class AEPituCameraUnit$23
  implements Observer<DYAEEffectItem>
{
  AEPituCameraUnit$23(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(DYAEEffectItem paramDYAEEffectItem)
  {
    if (!this.a.Y()) {
      return;
    }
    if (!paramDYAEEffectItem.f()) {
      return;
    }
    if ((paramDYAEEffectItem instanceof DYAELocalMaterialItem))
    {
      this.a.h.setMaterial(((DYAELocalMaterialItem)paramDYAEEffectItem).g());
      return;
    }
    if ((paramDYAEEffectItem instanceof DYAEMaterialItem))
    {
      paramDYAEEffectItem = ((DYAEMaterialItem)paramDYAEEffectItem).g();
      this.a.h.setLastForceMaterialPath(paramDYAEEffectItem.e());
      if (this.a.ag != null) {
        this.a.ag.a(1, paramDYAEEffectItem);
      }
      VideoReport.setPageParams(this.a.s(), "ae_cosmetic_id", paramDYAEEffectItem.m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.23
 * JD-Core Version:    0.7.0.1
 */