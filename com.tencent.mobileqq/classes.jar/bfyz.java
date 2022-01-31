import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.qzone.panorama.widget.PanoramaLoadingBall;

public class bfyz
  extends Handler
{
  public bfyz(PanoramaLoadingBall paramPanoramaLoadingBall, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == 291) && (Build.VERSION.SDK_INT >= 11))
    {
      if (PanoramaLoadingBall.a(this.a)) {
        PanoramaLoadingBall.a(this.a, 60.0F);
      }
      if (PanoramaLoadingBall.a(this.a) == 0) {
        this.a.setRotationX(PanoramaLoadingBall.a(this.a));
      }
    }
    else
    {
      return;
    }
    this.a.setRotationY(PanoramaLoadingBall.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfyz
 * JD-Core Version:    0.7.0.1
 */