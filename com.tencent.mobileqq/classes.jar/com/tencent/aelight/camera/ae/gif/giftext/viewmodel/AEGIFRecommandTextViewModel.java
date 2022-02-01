package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;

public class AEGIFRecommandTextViewModel
  extends ViewModel
{
  private static MutableLiveData<RecognizedEmotionBean> a = new MutableLiveData();
  
  public static MutableLiveData<RecognizedEmotionBean> a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel
 * JD-Core Version:    0.7.0.1
 */