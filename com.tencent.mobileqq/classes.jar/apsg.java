import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class apsg
  extends Handler
{
  public apsg(apsf paramapsf, Looper paramLooper)
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
      apsf.a(this.a);
      return;
      if (apsf.a(this.a))
      {
        apsf.a(this.a, false);
        apra.a();
      }
      try
      {
        apsf.b(this.a);
        return;
      }
      catch (Throwable paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.i("QRSession", 2, paramMessage.getMessage(), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsg
 * JD-Core Version:    0.7.0.1
 */