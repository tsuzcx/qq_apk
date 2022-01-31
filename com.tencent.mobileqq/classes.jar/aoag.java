import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface;

public class aoag
  implements Runnable
{
  public aoag(OffScreenGLSurface paramOffScreenGLSurface) {}
  
  public void run()
  {
    OffScreenGLSurface.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoag
 * JD-Core Version:    0.7.0.1
 */