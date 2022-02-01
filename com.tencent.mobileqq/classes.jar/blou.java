import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class blou
  extends Handler
{
  blou(blos paramblos, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      blos.b(this.a);
      blos.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blou
 * JD-Core Version:    0.7.0.1
 */