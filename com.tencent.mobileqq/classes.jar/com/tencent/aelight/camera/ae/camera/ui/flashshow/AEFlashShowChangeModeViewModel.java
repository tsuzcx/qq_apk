package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AEFlashShowChangeModeViewModel
  extends ViewModel
{
  public final MutableLiveData<AEFlashCameraCaptureButtonLayout.Style> a = new MutableLiveData();
  public final MutableLiveData<AEFlashCameraCaptureButtonLayout.Style> b = new MutableLiveData();
  
  public MutableLiveData<AEFlashCameraCaptureButtonLayout.Style> a()
  {
    return this.a;
  }
  
  public MutableLiveData<AEFlashCameraCaptureButtonLayout.Style> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowChangeModeViewModel
 * JD-Core Version:    0.7.0.1
 */