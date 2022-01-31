import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bkmq
  extends Handler
{
  public bkmq(Looper paramLooper)
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
      bkmm.c((Activity)paramMessage.obj, paramMessage.arg1);
      return;
    }
    bkmm.a(null);
    bkmm.a(SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmq
 * JD-Core Version:    0.7.0.1
 */