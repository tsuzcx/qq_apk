import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bnbx
  extends Handler
{
  bnbx(bnbw parambnbw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      paramMessage = (String)paramMessage.obj;
      this.a.a(paramMessage);
    }
    while ((paramMessage.what != 1002) || (this.a.a == null)) {
      return;
    }
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbx
 * JD-Core Version:    0.7.0.1
 */