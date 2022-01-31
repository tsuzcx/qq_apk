import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class apae
  extends Handler
{
  apae(apac paramapac, Looper paramLooper)
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
      apac.a(this.a);
      return;
    }
    apac.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apae
 * JD-Core Version:    0.7.0.1
 */