import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class avxc
  extends Handler
{
  avxc(avxb paramavxb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxc
 * JD-Core Version:    0.7.0.1
 */