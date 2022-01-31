import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class amxl
  extends Handler
{
  amxl(amxj paramamxj, Looper paramLooper)
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
    } while (amxj.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    amxj.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amxl
 * JD-Core Version:    0.7.0.1
 */