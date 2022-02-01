package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;

class AEFlashShowBottomPart$11
  implements Observer<MaterialPanelOpenState>
{
  AEFlashShowBottomPart$11(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(MaterialPanelOpenState paramMaterialPanelOpenState)
  {
    boolean bool2 = paramMaterialPanelOpenState.a();
    boolean bool1 = true;
    if (bool2)
    {
      AEMaterialMetaData localAEMaterialMetaData = paramMaterialPanelOpenState.b();
      AEFlashShowBottomPart.f(this.a).setVisibility(0);
      AEFlashShowMaterialPanel localAEFlashShowMaterialPanel = AEFlashShowBottomPart.f(this.a);
      if (localAEMaterialMetaData != null) {
        paramMaterialPanelOpenState = localAEMaterialMetaData.m;
      } else {
        paramMaterialPanelOpenState = null;
      }
      if (localAEMaterialMetaData == null) {
        bool1 = false;
      }
      localAEFlashShowMaterialPanel.a(null, paramMaterialPanelOpenState, bool1, new -..Lambda.AEFlashShowBottomPart.11.Az58FvoJC512g6dklGYyUKrCX8A(this));
      return;
    }
    if (AEFlashShowBottomPart.s(this.a) != null) {
      AEFlashShowBottomPart.s(this.a).setVisibility(0);
    }
    AEFlashShowBottomPart.f(this.a).a(true);
    AEFlashShowBottomPart.r(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.11
 * JD-Core Version:    0.7.0.1
 */