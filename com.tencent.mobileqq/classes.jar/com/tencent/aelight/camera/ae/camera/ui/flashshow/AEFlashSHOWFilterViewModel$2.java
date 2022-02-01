package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

class AEFlashSHOWFilterViewModel$2
  implements Observer<MetaMaterial>
{
  AEFlashSHOWFilterViewModel$2(AEFlashSHOWFilterViewModel paramAEFlashSHOWFilterViewModel) {}
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    AEFlashSHOWFilterViewModel.a(this.a).postValue(new AEFlashSHOWFilterViewModel.FilterSeekBarData(this.a, paramMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashSHOWFilterViewModel.2
 * JD-Core Version:    0.7.0.1
 */