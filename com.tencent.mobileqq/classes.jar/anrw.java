import dov.com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class anrw
  implements Runnable
{
  public anrw(CameraGLSurfaceView paramCameraGLSurfaceView) {}
  
  public void run()
  {
    CameraGLSurfaceView.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrw
 * JD-Core Version:    0.7.0.1
 */