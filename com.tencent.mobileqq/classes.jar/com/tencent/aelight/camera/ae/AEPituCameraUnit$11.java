package com.tencent.aelight.camera.ae;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.IARCakeDownloadListener;
import com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;

class AEPituCameraUnit$11
  implements AEARCakeMaterialManager.IARCakeDownloadListener
{
  AEPituCameraUnit$11(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (AEPituCameraUnit.f(this.a) != null) {
      AEPituCameraUnit.f(this.a).i();
    }
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (AEPituCameraUnit.f(this.a) != null)
    {
      AEARCakeMaterial localAEARCakeMaterial = AEARCakeMaterialManager.a().f();
      boolean bool = AEARCakeMaterialManager.a().d();
      if ((localAEARCakeMaterial != null) && (!bool))
      {
        if (TextUtils.equals(paramAEMaterialMetaData.V, localAEARCakeMaterial.V)) {
          AEPituCameraUnit.f(this.a).a(paramInt);
        }
      }
      else {
        AEPituCameraUnit.f(this.a).i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.11
 * JD-Core Version:    0.7.0.1
 */