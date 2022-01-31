import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bfil
  extends Handler
{
  public bfil(bfid parambfid, Looper paramLooper)
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
      bfid.a(this.a, bfid.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bfid.a(this.a, true);
      bfid.a(this.a);
      bfid.a(this.a, false);
      return;
    case 3: 
      bfid.a(this.a, paramMessage.obj);
      return;
    }
    bfid.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfil
 * JD-Core Version:    0.7.0.1
 */