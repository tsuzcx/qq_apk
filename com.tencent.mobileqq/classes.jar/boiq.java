import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.ttpic.util.SensorUtil2;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.4.1;

public class boiq
  implements SurfaceTexture.OnFrameAvailableListener
{
  public boiq(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AECameraGLSurfaceView.a(this.a, true);
    if (!AECameraGLSurfaceView.a(this.a))
    {
      AECameraGLSurfaceView.b(this.a, true);
      bowp.a().a("onFrameAvailable");
    }
    if (AECameraGLSurfaceView.a(this.a) != null) {
      AECameraGLSurfaceView.a(this.a).getRotation(AECameraGLSurfaceView.a(this.a));
    }
    this.a.queueEvent(new AECameraGLSurfaceView.4.1(this));
    this.a.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boiq
 * JD-Core Version:    0.7.0.1
 */