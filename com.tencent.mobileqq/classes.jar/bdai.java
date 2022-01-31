import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bdai
  extends Handler
{
  bdai(Looper paramLooper)
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
      bdah.a();
      return;
    }
    bdah.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdai
 * JD-Core Version:    0.7.0.1
 */