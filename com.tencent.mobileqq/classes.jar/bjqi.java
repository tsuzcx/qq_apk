import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class bjqi
  extends Handler
{
  public bjqi(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout, Looper paramLooper)
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
 * Qualified Name:     bjqi
 * JD-Core Version:    0.7.0.1
 */