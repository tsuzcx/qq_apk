import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;

class awop
  extends Handler
{
  public awop(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      try
      {
        awon.a(System.currentTimeMillis());
        awon.a.removeMessages(1);
        awon.a.sendEmptyMessageDelayed(1, 300000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      try
      {
        if (BaseApplicationImpl.sProcessId == 1)
        {
          awon.b(System.currentTimeMillis());
          awon.a.removeMessages(2);
          awon.a.sendEmptyMessageDelayed(2, 300000L);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awop
 * JD-Core Version:    0.7.0.1
 */