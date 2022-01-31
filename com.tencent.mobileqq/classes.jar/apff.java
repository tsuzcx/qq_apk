import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class apff
  extends Handler
{
  apff(apfd paramapfd, Looper paramLooper)
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
    } while (apfd.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    apfd.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apff
 * JD-Core Version:    0.7.0.1
 */