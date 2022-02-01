import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bmpw
  extends Handler
{
  bmpw(bmpu parambmpu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      bmpu.b(this.a);
      bmpu.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpw
 * JD-Core Version:    0.7.0.1
 */