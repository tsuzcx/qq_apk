package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "openState", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DaoJuPanelOpenState;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class AEBottomPanelPart$initViewModel$1<T>
  implements Observer<DaoJuPanelOpenState>
{
  AEBottomPanelPart$initViewModel$1(AEBottomPanelPart paramAEBottomPanelPart) {}
  
  public final void a(DaoJuPanelOpenState paramDaoJuPanelOpenState)
  {
    if (paramDaoJuPanelOpenState.a())
    {
      AENewMaterialPanel localAENewMaterialPanel = AEBottomPanelPart.c(this.a);
      if (localAENewMaterialPanel != null)
      {
        Object localObject = paramDaoJuPanelOpenState.b();
        if (localObject != null) {
          localObject = ((AEMaterialMetaData)localObject).o;
        } else {
          localObject = null;
        }
        paramDaoJuPanelOpenState = paramDaoJuPanelOpenState.b();
        if (paramDaoJuPanelOpenState != null) {
          paramDaoJuPanelOpenState = paramDaoJuPanelOpenState.m;
        } else {
          paramDaoJuPanelOpenState = null;
        }
        localAENewMaterialPanel.a((String)localObject, paramDaoJuPanelOpenState, null);
      }
    }
    else
    {
      paramDaoJuPanelOpenState = AEBottomPanelPart.c(this.a);
      if (paramDaoJuPanelOpenState != null) {
        paramDaoJuPanelOpenState.a((Runnable)new AEBottomPanelPart.initViewModel.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelPart.initViewModel.1
 * JD-Core Version:    0.7.0.1
 */