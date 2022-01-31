import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bgum
  extends Handler
{
  bgum(bguk parambguk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      bguk.b(this.a);
      bguk.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgum
 * JD-Core Version:    0.7.0.1
 */