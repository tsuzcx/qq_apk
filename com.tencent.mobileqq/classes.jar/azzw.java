import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class azzw
  extends Handler
{
  azzw(Looper paramLooper)
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
      azzv.a();
      return;
    }
    azzv.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azzw
 * JD-Core Version:    0.7.0.1
 */