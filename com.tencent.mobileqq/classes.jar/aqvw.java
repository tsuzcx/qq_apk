import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aqvw
  extends Handler
{
  aqvw(aqvu paramaqvu, Looper paramLooper)
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
    } while (aqvu.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    aqvu.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvw
 * JD-Core Version:    0.7.0.1
 */