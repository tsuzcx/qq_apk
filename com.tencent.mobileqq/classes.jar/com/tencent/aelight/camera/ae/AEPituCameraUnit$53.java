package com.tencent.aelight.camera.ae;

import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGenderTypeListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsTypeViewModel;
import com.tencent.ttpic.facedetect.GenderType;

class AEPituCameraUnit$53
  implements AECameraGLSurfaceView.AEGenderTypeListener
{
  AEPituCameraUnit$53(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onGenderTypeListener(int paramInt)
  {
    if (paramInt != GenderType.DEFAULT.value) {
      AEPituCameraUnit.r(this.a).a().postValue(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.53
 * JD-Core Version:    0.7.0.1
 */