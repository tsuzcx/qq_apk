import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.AEPituCameraUnit.28.1;
import dov.com.qq.im.ae.AEPituCameraUnit.28.2;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import mqq.os.MqqHandler;

public class bneg
  implements bnhr
{
  bneg(bndy parambndy) {}
  
  public void a()
  {
    if (bndy.a(this.a) != null) {
      bndy.a(this.a).i();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bnzb.b("AEPituCameraUnit", "onCameraPreviewSizeChanged---width=" + paramInt1 + ", height=" + paramInt2);
    if (bndy.a(this.a) != null) {
      bndy.a(this.a).a(paramInt1, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    bnzb.b("AEPituCameraUnit", "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (paramBoolean) {
      bnvd.a().a("onCameraStart");
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.28.1(this));
    }
    for (;;)
    {
      int i = AEBeautyProviderView.a();
      int j = AEBeautyProviderView.b();
      bndy.a(this.a).a(i);
      bndy.a(this.a).b(j);
      bndy.a(this.a).a(458753, new Object[0]);
      return;
      if (bndy.a(this.a) != null) {
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.28.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneg
 * JD-Core Version:    0.7.0.1
 */