import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.2;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.3;

public class aoge
  extends Handler
{
  public aoge(aogc paramaogc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      aoln.a().a(new ARCamera.ARCameraHandler.1(this));
      removeMessages(100);
      sendEmptyMessageDelayed(100, 3000L);
      return;
    case 101: 
      aoln.a().a(new ARCamera.ARCameraHandler.2(this));
      return;
    }
    aoln.a().a(new ARCamera.ARCameraHandler.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoge
 * JD-Core Version:    0.7.0.1
 */