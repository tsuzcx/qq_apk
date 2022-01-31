import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bign
  extends Handler
{
  public bign(Looper paramLooper)
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
      bigj.c((Activity)paramMessage.obj, paramMessage.arg1);
      return;
    }
    bigj.a(null);
    bigj.a(SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bign
 * JD-Core Version:    0.7.0.1
 */