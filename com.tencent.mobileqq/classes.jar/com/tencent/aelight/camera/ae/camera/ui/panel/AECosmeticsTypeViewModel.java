package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.ttpic.facedetect.GenderType;

public class AECosmeticsTypeViewModel
  extends ViewModel
{
  private final MutableLiveData<Integer> a = new MutableLiveData(Integer.valueOf(GenderType.DEFAULT.value));
  
  public MutableLiveData<Integer> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsTypeViewModel
 * JD-Core Version:    0.7.0.1
 */