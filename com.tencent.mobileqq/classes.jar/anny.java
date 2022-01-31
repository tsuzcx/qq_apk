import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class anny
  extends Handler
{
  anny(annw paramannw, Looper paramLooper)
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
    } while (annw.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    annw.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anny
 * JD-Core Version:    0.7.0.1
 */