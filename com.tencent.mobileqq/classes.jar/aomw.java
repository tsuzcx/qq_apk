import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class aomw
  extends Handler
{
  public aomw(QIMCameraCaptureButtonLayout paramQIMCameraCaptureButtonLayout, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomw
 * JD-Core Version:    0.7.0.1
 */