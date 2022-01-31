import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.1;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.2;

public class bioi
  extends bijx
{
  private AEProviderContainerView a;
  
  public bioi(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.a = ((AEProviderContainerView)paramView.findViewById(2131363123));
  }
  
  public void a(avsr paramavsr)
  {
    a(new BeautyAndFilterPanelViewStubHolder.1(this, paramavsr));
  }
  
  public void a(biju parambiju, biwb parambiwb)
  {
    a(new BeautyAndFilterPanelViewStubHolder.2(this, parambiju, parambiwb));
  }
  
  public void a(bivx parambivx)
  {
    if (!a()) {
      return;
    }
    this.a.setCaptureMode(parambivx);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bioi
 * JD-Core Version:    0.7.0.1
 */