import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.1;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.2;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class bkya
  extends bktk
{
  private AEProviderContainerView a;
  
  public bkya(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.a = ((AEProviderContainerView)paramView.findViewById(2131363158));
  }
  
  public void a(axpa paramaxpa)
  {
    a(new BeautyAndFilterPanelViewStubHolder.1(this, paramaxpa));
  }
  
  public void a(bkth parambkth, blft paramblft)
  {
    a(new BeautyAndFilterPanelViewStubHolder.2(this, parambkth, paramblft));
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
    return this.a.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkya
 * JD-Core Version:    0.7.0.1
 */