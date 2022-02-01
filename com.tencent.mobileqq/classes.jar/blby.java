import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class blby
  extends Handler
{
  public blby(blbq paramblbq, Looper paramLooper)
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
      blbq.a(this.a, blbq.a(this.a, paramMessage.obj));
      return;
    case 2: 
      blbq.a(this.a, true);
      blbq.a(this.a);
      blbq.a(this.a, false);
      return;
    case 3: 
      blbq.a(this.a, paramMessage.obj);
      return;
    }
    blbq.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blby
 * JD-Core Version:    0.7.0.1
 */