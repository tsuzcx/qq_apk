import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bfhu
  extends Handler
{
  public bfhu(bfhm parambfhm, Looper paramLooper)
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
      bfhm.a(this.a, bfhm.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bfhm.a(this.a, true);
      bfhm.a(this.a);
      bfhm.a(this.a, false);
      return;
    case 3: 
      bfhm.a(this.a, paramMessage.obj);
      return;
    }
    bfhm.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfhu
 * JD-Core Version:    0.7.0.1
 */