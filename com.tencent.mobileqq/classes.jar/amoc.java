import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class amoc
  extends Handler
{
  amoc(amoa paramamoa, Looper paramLooper)
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
      amoa.a(this.a);
      return;
    }
    amoa.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amoc
 * JD-Core Version:    0.7.0.1
 */