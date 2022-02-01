import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;

class avim
  extends Handler
{
  public avim(Looper paramLooper)
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
        avik.a(System.currentTimeMillis());
        avik.a.removeMessages(1);
        avik.a.sendEmptyMessageDelayed(1, 300000L);
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
          avik.b(System.currentTimeMillis());
          avik.a.removeMessages(2);
          avik.a.sendEmptyMessageDelayed(2, 300000L);
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
 * Qualified Name:     avim
 * JD-Core Version:    0.7.0.1
 */