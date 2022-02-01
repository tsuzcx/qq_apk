package com.tencent.aelight.camera.ae;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.DaoJuPanelOpenState;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;

class AEPituCameraUnit$29
  implements Observer<DaoJuPanelOpenState>
{
  AEPituCameraUnit$29(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(DaoJuPanelOpenState paramDaoJuPanelOpenState)
  {
    if (paramDaoJuPanelOpenState.a())
    {
      AEPituCameraUnit.o(this.a).b().postValue(Boolean.valueOf(true));
      return;
    }
    AEPituCameraUnit.o(this.a).b().postValue(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.29
 * JD-Core Version:    0.7.0.1
 */