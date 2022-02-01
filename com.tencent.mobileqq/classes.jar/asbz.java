import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class asbz
  extends Handler
{
  asbz(asbx paramasbx, Looper paramLooper)
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
    } while (asbx.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    asbx.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbz
 * JD-Core Version:    0.7.0.1
 */