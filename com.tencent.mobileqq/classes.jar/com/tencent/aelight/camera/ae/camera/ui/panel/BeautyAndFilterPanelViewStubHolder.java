package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder;
import com.tencent.aelight.camera.ae.gesture.CameraProviderViewGesture;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

public class BeautyAndFilterPanelViewStubHolder
  extends BaseViewStubHolder
  implements BeautyAndFilterPanel
{
  private AEProviderContainerView a;
  private AECaptureMode b;
  
  public BeautyAndFilterPanelViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.a = ((AEProviderContainerView)paramView.findViewById(2063990904));
  }
  
  public void a(AECaptureController paramAECaptureController, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    a(new BeautyAndFilterPanelViewStubHolder.2(this, paramAECaptureController, paramVideoStoryCapturePartManager));
  }
  
  public void a(CameraProviderViewGesture paramCameraProviderViewGesture)
  {
    a(new BeautyAndFilterPanelViewStubHolder.1(this, paramCameraProviderViewGesture));
  }
  
  public void a(AECaptureMode paramAECaptureMode)
  {
    this.b = paramAECaptureMode;
    if (!ap_()) {
      return;
    }
    this.a.setCaptureMode(paramAECaptureMode);
  }
  
  public void an_()
  {
    c();
    this.a.setVisibility(0);
    this.a.b();
  }
  
  public boolean ao_()
  {
    if (!ap_()) {
      return false;
    }
    return this.a.l();
  }
  
  public void b()
  {
    if (!ap_()) {
      return;
    }
    this.a.h();
  }
  
  public void d()
  {
    if (!ap_()) {
      return;
    }
    this.a.i();
  }
  
  public void e()
  {
    if (!ap_()) {
      return;
    }
    this.a.c();
  }
  
  public void f()
  {
    if (!ap_()) {
      return;
    }
    this.a.f();
  }
  
  public void g()
  {
    if (!ap_()) {
      return;
    }
    this.a.g();
  }
  
  public void h()
  {
    if (!ap_()) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder
 * JD-Core Version:    0.7.0.1
 */