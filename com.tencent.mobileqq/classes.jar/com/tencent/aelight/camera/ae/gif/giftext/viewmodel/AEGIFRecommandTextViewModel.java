package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.aebase.lifecycle.GlobalViewModel;

public class AEGIFRecommandTextViewModel
  extends GlobalViewModel
{
  private MutableLiveData<RecognizedEmotionBean> a = new MutableLiveData();
  
  public MutableLiveData<RecognizedEmotionBean> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel
 * JD-Core Version:    0.7.0.1
 */