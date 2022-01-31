import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class beae
  extends Handler
{
  public beae(bdzw parambdzw, Looper paramLooper)
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
      bdzw.a(this.a, bdzw.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bdzw.a(this.a, true);
      bdzw.a(this.a);
      bdzw.a(this.a, false);
      return;
    case 3: 
      bdzw.a(this.a, paramMessage.obj);
      return;
    }
    bdzw.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beae
 * JD-Core Version:    0.7.0.1
 */