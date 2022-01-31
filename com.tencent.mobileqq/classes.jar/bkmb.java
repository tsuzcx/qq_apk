import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bkmb
  extends Handler
{
  bkmb(bkma parambkma, Looper paramLooper)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmb
 * JD-Core Version:    0.7.0.1
 */