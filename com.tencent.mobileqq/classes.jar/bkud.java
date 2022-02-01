import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bkud
  extends Handler
{
  bkud(bkub parambkub, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      bkub.b(this.a);
      bkub.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkud
 * JD-Core Version:    0.7.0.1
 */