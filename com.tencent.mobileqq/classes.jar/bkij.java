import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bkij
  extends Handler
{
  public bkij(Looper paramLooper)
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
      bkif.c((Activity)paramMessage.obj, paramMessage.arg1);
      return;
    }
    bkif.a(null);
    bkif.a(SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkij
 * JD-Core Version:    0.7.0.1
 */