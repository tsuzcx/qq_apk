import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class awcn
  extends Handler
{
  public awcn(Looper paramLooper)
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
        awcm.a(System.currentTimeMillis());
        awcm.a.removeMessages(1);
        awcm.a.sendEmptyMessageDelayed(1, 300000L);
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
      awcm.b(System.currentTimeMillis());
      awcm.a.removeMessages(2);
      awcm.a.sendEmptyMessageDelayed(2, 300000L);
      return;
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcn
 * JD-Core Version:    0.7.0.1
 */