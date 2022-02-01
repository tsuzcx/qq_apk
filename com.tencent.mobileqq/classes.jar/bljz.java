import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.AEPituCameraUnit.1.1;
import dov.com.qq.im.ae.AEPituCameraUnit.1.2;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraManagerListener;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import mqq.os.MqqHandler;

public class bljz
  implements AECameraManager.CameraManagerListener
{
  bljz(bljy parambljy) {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    bmbx.b(this.a.jdField_a_of_type_JavaLangString, "onCameraPreviewSizeChanged---width=" + paramInt1 + ", height=" + paramInt2);
    if (this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onCameraPreviewSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onCameraPreviewStarted()
  {
    if (this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onCameraPreviewStarted();
    }
  }
  
  public void onCameraStarted(boolean paramBoolean, String paramString)
  {
    bmbx.b(this.a.jdField_a_of_type_JavaLangString, "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (paramBoolean) {
      bmau.a().a("onCameraStart");
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.1(this));
    }
    for (;;)
    {
      int i = AEBeautyProviderView.a();
      int j = AEBeautyProviderView.b();
      this.a.jdField_a_of_type_Blnv.a(i);
      this.a.jdField_a_of_type_Blnv.b(j);
      this.a.jdField_a_of_type_Bmas.a(458753, new Object[0]);
      return;
      if (this.a.jdField_a_of_type_Bmcb != null) {
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljz
 * JD-Core Version:    0.7.0.1
 */