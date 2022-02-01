import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bmuj
  extends Handler
{
  public bmuj(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3000: 
      bmuf.c((Activity)paramMessage.obj, paramMessage.arg1);
      return;
    }
    bmuf.a(null);
    bmuf.a(SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuj
 * JD-Core Version:    0.7.0.1
 */