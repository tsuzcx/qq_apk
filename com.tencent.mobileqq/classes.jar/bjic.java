import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bjic
  extends Handler
{
  public bjic(bjhu parambjhu, Looper paramLooper)
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
      bjhu.a(this.a, bjhu.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bjhu.a(this.a, true);
      bjhu.a(this.a);
      bjhu.a(this.a, false);
      return;
    case 3: 
      bjhu.a(this.a, paramMessage.obj);
      return;
    }
    bjhu.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjic
 * JD-Core Version:    0.7.0.1
 */