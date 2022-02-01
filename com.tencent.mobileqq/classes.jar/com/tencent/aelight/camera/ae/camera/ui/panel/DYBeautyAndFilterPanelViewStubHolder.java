package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder;
import com.tencent.aelight.camera.ae.gesture.CameraProviderViewGesture;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

public class DYBeautyAndFilterPanelViewStubHolder
  extends BaseViewStubHolder
  implements BeautyAndFilterPanel
{
  private DYAEProviderContainerView a;
  private final boolean b;
  
  public DYBeautyAndFilterPanelViewStubHolder(ViewStub paramViewStub)
  {
    this(paramViewStub, true);
  }
  
  public DYBeautyAndFilterPanelViewStubHolder(ViewStub paramViewStub, boolean paramBoolean)
  {
    super(paramViewStub);
    this.b = paramBoolean;
  }
  
  protected void a(View paramView)
  {
    this.a = ((DYAEProviderContainerView)paramView.findViewById(2063990904));
    this.a.a(paramView.getContext(), this.b);
  }
  
  public void a(AECaptureController paramAECaptureController, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    a(new DYBeautyAndFilterPanelViewStubHolder.2(this, paramAECaptureController, paramVideoStoryCapturePartManager));
  }
  
  public void a(CameraProviderViewGesture paramCameraProviderViewGesture)
  {
    a(new DYBeautyAndFilterPanelViewStubHolder.1(this, paramCameraProviderViewGesture));
  }
  
  public void a(AECaptureMode paramAECaptureMode)
  {
    if (!ap_()) {
      return;
    }
    this.a.setCaptureMode(paramAECaptureMode);
  }
  
  public void an_()
  {
    c();
    this.a.setVisibility(0);
    this.a.d();
  }
  
  public boolean ao_()
  {
    if (!ap_()) {
      return false;
    }
    return this.a.j();
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
    this.a.g();
  }
  
  public void e()
  {
    if (!ap_()) {
      return;
    }
    this.a.f();
  }
  
  public void f()
  {
    if (!ap_()) {
      return;
    }
    this.a.a();
  }
  
  public void g()
  {
    if (!ap_()) {
      return;
    }
    this.a.b();
  }
  
  public void h()
  {
    if (!ap_()) {
      return;
    }
    this.a.c();
  }
  
  public void i()
  {
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder
 * JD-Core Version:    0.7.0.1
 */