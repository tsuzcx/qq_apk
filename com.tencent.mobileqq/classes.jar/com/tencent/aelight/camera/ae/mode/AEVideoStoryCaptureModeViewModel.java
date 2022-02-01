package com.tencent.aelight.camera.ae.mode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AEVideoStoryCaptureModeViewModel
  extends ViewModel
{
  public final MutableLiveData<AECaptureModeChangingEvent> a = new MutableLiveData();
  public final MutableLiveData<AECaptureMode[]> b = new MutableLiveData();
  public final MutableLiveData<Boolean> c = new MutableLiveData();
  private boolean d;
  
  public boolean a()
  {
    return (this.a.getValue() != null) && (((AECaptureModeChangingEvent)this.a.getValue()).b == AECaptureMode.GIF);
  }
  
  public boolean b()
  {
    return (this.a.getValue() != null) && (((AECaptureModeChangingEvent)this.a.getValue()).b == AECaptureMode.NORMAL);
  }
  
  public boolean c()
  {
    return (this.a.getValue() != null) && (((AECaptureModeChangingEvent)this.a.getValue()).b == AECaptureMode.PLAY);
  }
  
  public boolean d()
  {
    return (this.a.getValue() != null) && (((AECaptureModeChangingEvent)this.a.getValue()).b == AECaptureMode.ARCAKE);
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel
 * JD-Core Version:    0.7.0.1
 */