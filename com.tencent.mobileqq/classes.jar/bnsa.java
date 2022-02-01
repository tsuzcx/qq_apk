import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;

public class bnsa
  extends Handler
{
  public bnsa(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsa
 * JD-Core Version:    0.7.0.1
 */