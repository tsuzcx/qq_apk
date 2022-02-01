import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bktn
  extends Handler
{
  public bktn(bktf parambktf, Looper paramLooper)
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
      bktf.a(this.a, bktf.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bktf.a(this.a, true);
      bktf.a(this.a);
      bktf.a(this.a, false);
      return;
    case 3: 
      bktf.a(this.a, paramMessage.obj);
      return;
    }
    bktf.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktn
 * JD-Core Version:    0.7.0.1
 */