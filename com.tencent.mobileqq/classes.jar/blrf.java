import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.ExtractFrameRequest;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9.1;

public class blrf
  implements AECameraGLSurfaceView.ExtractFrameRequest
{
  blrf(blqw paramblqw) {}
  
  public void onExtract(Bitmap paramBitmap)
  {
    ThreadManager.excute(new VideoStoryCapturePart.9.1(this, paramBitmap), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrf
 * JD-Core Version:    0.7.0.1
 */