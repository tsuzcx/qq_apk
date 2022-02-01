package com.tencent.aelight.camera.ae;

import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.gif.AEExpressionRecognizer.RecommendTextCallback;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;

class AEPituCameraUnit$51
  implements AEExpressionRecognizer.RecommendTextCallback
{
  AEPituCameraUnit$51(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    AEGIFRecommandTextViewModel.a().postValue(paramRecognizedEmotionBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.51
 * JD-Core Version:    0.7.0.1
 */