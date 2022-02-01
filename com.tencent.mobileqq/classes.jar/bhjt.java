import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bhjt
  extends Handler
{
  bhjt(Looper paramLooper)
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
      bhjs.a();
      return;
    }
    bhjs.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjt
 * JD-Core Version:    0.7.0.1
 */