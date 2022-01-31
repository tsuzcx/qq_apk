import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class anbq
  extends Handler
{
  public anbq(anbp paramanbp, Looper paramLooper)
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
      anbp.a(this.a);
      return;
      if (anbp.a(this.a))
      {
        anbp.a(this.a, false);
        anak.a();
      }
      try
      {
        anbp.b(this.a);
        return;
      }
      catch (Throwable paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.i("QRSession", 2, paramMessage.getMessage(), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbq
 * JD-Core Version:    0.7.0.1
 */