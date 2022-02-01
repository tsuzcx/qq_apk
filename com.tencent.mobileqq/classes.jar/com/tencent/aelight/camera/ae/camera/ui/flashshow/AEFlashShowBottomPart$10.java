package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;

class AEFlashShowBottomPart$10
  implements Observer<AEMaterialMetaData>
{
  AEFlashShowBottomPart$10(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEFlashShowBottomPart.r(this.a).setFavorite(AEFlashShowBottomPart.f(this.a).a((AEMaterialMetaData)AEFlashShowBottomPanelViewModel.k().getValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.10
 * JD-Core Version:    0.7.0.1
 */