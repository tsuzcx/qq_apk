package com.tencent.aelight.camera.ae.gif;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;

class AEVideoStoryGIFTplViewModel$1$2
  implements Runnable
{
  AEVideoStoryGIFTplViewModel$1$2(AEVideoStoryGIFTplViewModel.1 param1, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    AEVideoStoryGIFTplViewModel.a(this.b.a).setValue(new AEDownloadStateWrapper(this.a, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel.1.2
 * JD-Core Version:    0.7.0.1
 */