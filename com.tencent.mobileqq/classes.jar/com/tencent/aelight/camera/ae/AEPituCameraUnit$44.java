package com.tencent.aelight.camera.ae;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.gif.AEExpressionRecognizer.RecommendTextCallback;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import com.tencent.aelight.camera.aebase.lifecycle.GlobalViewModelFactory;

class AEPituCameraUnit$44
  implements AEExpressionRecognizer.RecommendTextCallback
{
  AEPituCameraUnit$44(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    ((AEGIFRecommandTextViewModel)AEViewModelProviders.a(this.a, GlobalViewModelFactory.a()).get(AEGIFRecommandTextViewModel.class)).a().postValue(paramRecognizedEmotionBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.44
 * JD-Core Version:    0.7.0.1
 */