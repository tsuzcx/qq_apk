import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class apou
  extends Handler
{
  public apou(apot paramapot, Looper paramLooper)
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
      apot.a(this.a);
      return;
      if (apot.a(this.a))
      {
        apot.a(this.a, false);
        apno.a();
      }
      try
      {
        apot.b(this.a);
        return;
      }
      catch (Throwable paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.i("QRSession", 2, paramMessage.getMessage(), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apou
 * JD-Core Version:    0.7.0.1
 */