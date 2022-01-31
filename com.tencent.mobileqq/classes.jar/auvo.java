import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView.1.1;

public class auvo
  implements SurfaceTexture.OnFrameAvailableListener
{
  public auvo(FollowCaptureView paramFollowCaptureView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    FollowCaptureView.a(this.a, paramSurfaceTexture);
    this.a.queueEvent(new FollowCaptureView.1.1(this, paramSurfaceTexture));
    if (!FollowCaptureView.a(this.a)) {
      FollowCaptureView.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auvo
 * JD-Core Version:    0.7.0.1
 */