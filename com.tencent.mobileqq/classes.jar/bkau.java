import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bkau
  extends Handler
{
  public bkau(bkam parambkam, Looper paramLooper)
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
      bkam.a(this.a, bkam.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bkam.a(this.a, true);
      bkam.a(this.a);
      bkam.a(this.a, false);
      return;
    case 3: 
      bkam.a(this.a, paramMessage.obj);
      return;
    }
    bkam.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkau
 * JD-Core Version:    0.7.0.1
 */