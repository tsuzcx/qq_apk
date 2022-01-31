import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bbbo
  extends Handler
{
  bbbo(Looper paramLooper)
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
      bbbn.a();
      return;
    }
    bbbn.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbbo
 * JD-Core Version:    0.7.0.1
 */