import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

public class bkoa
  extends bkve
{
  public bkoa(AECameraGLSurfaceView paramAECameraGLSurfaceView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (AECameraGLSurfaceView.a(this.a) != null) {
      AECameraGLSurfaceView.a(this.a).a(paramFloat3);
    }
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    AECameraGLSurfaceView.a(this.a, paramInt);
    bkoi.a().b(paramInt);
    if (paramInt == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("AECameraGLSurfaceView", 2, "OrientationEventListener unknown");
      }
    }
    for (int j = 90;; j = 0)
    {
      if ((paramInt > 315) || (paramInt < 45)) {
        i = 90;
      }
      for (;;)
      {
        AECameraGLSurfaceView.b(this.a, i);
        return;
        if ((paramInt > 45) && (paramInt < 135)) {
          i = 180;
        } else if ((paramInt > 135) && (paramInt < 225)) {
          i = 270;
        } else if ((paramInt <= 225) || (paramInt >= 315)) {
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkoa
 * JD-Core Version:    0.7.0.1
 */