import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class biwc
  extends Handler
{
  biwc(biwa parambiwa, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      biwa.b(this.a);
      biwa.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwc
 * JD-Core Version:    0.7.0.1
 */