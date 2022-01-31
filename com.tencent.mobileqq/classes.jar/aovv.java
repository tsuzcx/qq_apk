import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aovv
  extends Handler
{
  aovv(aovt paramaovt, Looper paramLooper)
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
      aovt.a(this.a);
      return;
    }
    aovt.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovv
 * JD-Core Version:    0.7.0.1
 */