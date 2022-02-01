import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class awvf
  extends Handler
{
  public awvf(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      try
      {
        awve.a(System.currentTimeMillis());
        awve.a.removeMessages(1);
        awve.a.sendEmptyMessageDelayed(1, 300000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
    try
    {
      awve.b(System.currentTimeMillis());
      awve.a.removeMessages(2);
      awve.a.sendEmptyMessageDelayed(2, 300000L);
      return;
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awvf
 * JD-Core Version:    0.7.0.1
 */