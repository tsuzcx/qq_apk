package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;

class AEFlashShowBottomPart$9
  implements Observer<AEMaterialMetaData>
{
  AEFlashShowBottomPart$9(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (!paramAEMaterialMetaData.d())) {
      AEFlashShowBottomPart.r(this.a).setVisibility(0);
    } else {
      AEFlashShowBottomPart.r(this.a).setVisibility(8);
    }
    AEFlashShowBottomPart.f(this.a).g();
    AEFlashShowBottomPart.r(this.a).setFavorite(AEFlashShowBottomPart.f(this.a).a(paramAEMaterialMetaData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.9
 * JD-Core Version:    0.7.0.1
 */