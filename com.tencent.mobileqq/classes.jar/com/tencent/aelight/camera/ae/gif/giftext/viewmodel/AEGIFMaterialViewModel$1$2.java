package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;

class AEGIFMaterialViewModel$1$2
  implements Runnable
{
  AEGIFMaterialViewModel$1$2(AEGIFMaterialViewModel.1 param1, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    AEGIFMaterialViewModel.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFMaterialViewModel$1.a).setValue(new AEDownloadStateWrapper(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1.2
 * JD-Core Version:    0.7.0.1
 */