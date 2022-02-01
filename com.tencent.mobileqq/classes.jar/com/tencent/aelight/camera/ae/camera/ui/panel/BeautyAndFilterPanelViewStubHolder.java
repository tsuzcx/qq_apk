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
{
  private AEProviderContainerView a;
  
  public BeautyAndFilterPanelViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.a = ((AEProviderContainerView)paramView.findViewById(2064121976));
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
    if (!a()) {
      return;
    }
    this.a.setCaptureMode(paramAECaptureMode);
  }
  
  public void b()
  {
    a();
    this.a.setVisibility(0);
    this.a.b();
  }
  
  public boolean b()
  {
    if (!a()) {
      return false;
    }
    return this.a.c();
  }
  
  public void c()
  {
    if (!a()) {
      return;
    }
    this.a.a();
  }
  
  public void d()
  {
    if (!a()) {
      return;
    }
    this.a.d();
  }
  
  public void e()
  {
    if (!a()) {
      return;
    }
    this.a.f();
  }
  
  public void f()
  {
    if (!a()) {
      return;
    }
    this.a.c();
  }
  
  public void g()
  {
    if (!a()) {
      return;
    }
    this.a.g();
  }
  
  public void h()
  {
    if (!a()) {
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder
 * JD-Core Version:    0.7.0.1
 */