import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class apjo
  extends Handler
{
  apjo(apjm paramapjm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (apjm.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    apjm.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjo
 * JD-Core Version:    0.7.0.1
 */