import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class anej
  extends Handler
{
  anej(aneh paramaneh, Looper paramLooper)
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
      aneh.a(this.a);
      return;
    }
    aneh.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anej
 * JD-Core Version:    0.7.0.1
 */