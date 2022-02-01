import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bftb
  extends Handler
{
  bftb(Looper paramLooper)
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
      bfta.a();
      return;
    }
    bfta.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftb
 * JD-Core Version:    0.7.0.1
 */