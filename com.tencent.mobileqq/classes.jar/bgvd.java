import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bgvd
  extends Handler
{
  bgvd(bgvb parambgvb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      bgvb.b(this.a);
      bgvb.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvd
 * JD-Core Version:    0.7.0.1
 */