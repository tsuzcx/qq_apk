import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.AEPituCameraUnit.27.1;
import dov.com.qq.im.ae.AEPituCameraUnit.27.2;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import mqq.os.MqqHandler;

public class bofo
  implements boiz
{
  bofo(bofh parambofh) {}
  
  public void a()
  {
    if (bofh.a(this.a) != null) {
      bofh.a(this.a).i();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bpam.b("AEPituCameraUnit", "onCameraPreviewSizeChanged---width=" + paramInt1 + ", height=" + paramInt2);
    if (bofh.a(this.a) != null) {
      bofh.a(this.a).a(paramInt1, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    bpam.b("AEPituCameraUnit", "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (paramBoolean) {
      bowp.a().a("onCameraStart");
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.27.1(this));
    }
    for (;;)
    {
      int i = AEBeautyProviderView.a();
      int j = AEBeautyProviderView.b();
      bofh.a(this.a).a(i);
      bofh.a(this.a).b(j);
      bofh.a(this.a).a(458753, new Object[0]);
      return;
      if (bofh.a(this.a) != null) {
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.27.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofo
 * JD-Core Version:    0.7.0.1
 */