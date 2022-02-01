package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;

class AEGIFMaterialViewModel$1$1
  implements Runnable
{
  AEGIFMaterialViewModel$1$1(AEGIFMaterialViewModel.1 param1, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    AEGIFMaterialViewModel.a(this.b.a).setValue(new AEDownloadStateWrapper(this.a, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1.1
 * JD-Core Version:    0.7.0.1
 */