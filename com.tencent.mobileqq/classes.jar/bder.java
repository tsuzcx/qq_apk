import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bder
  extends Handler
{
  bder(Looper paramLooper)
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
      bdeq.a();
      return;
    }
    bdeq.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bder
 * JD-Core Version:    0.7.0.1
 */