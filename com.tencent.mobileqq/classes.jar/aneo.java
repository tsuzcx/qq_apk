import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aneo
  extends Handler
{
  aneo(anem paramanem, Looper paramLooper)
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
      anem.a(this.a);
      return;
    }
    anem.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aneo
 * JD-Core Version:    0.7.0.1
 */