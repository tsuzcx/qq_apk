package com.tencent.aelight.camera.ae.mode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AEVideoStoryCaptureModeViewModel
  extends ViewModel
{
  public final MutableLiveData<AECaptureModeChangingEvent> a;
  private boolean a;
  public final MutableLiveData<AECaptureMode[]> b = new MutableLiveData();
  public final MutableLiveData<Boolean> c = new MutableLiveData();
  
  public AEVideoStoryCaptureModeViewModel()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue() != null) && (((AECaptureModeChangingEvent)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).b == AECaptureMode.GIF);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue() != null) && (((AECaptureModeChangingEvent)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).b == AECaptureMode.NORMAL);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue() != null) && (((AECaptureModeChangingEvent)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).b == AECaptureMode.PLAY);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue() != null) && (((AECaptureModeChangingEvent)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).b == AECaptureMode.ARCAKE);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel
 * JD-Core Version:    0.7.0.1
 */