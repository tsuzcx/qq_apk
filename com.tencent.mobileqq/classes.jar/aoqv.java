import dov.com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class aoqv
  implements Runnable
{
  public aoqv(CameraGLSurfaceView paramCameraGLSurfaceView) {}
  
  public void run()
  {
    CameraGLSurfaceView.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoqv
 * JD-Core Version:    0.7.0.1
 */