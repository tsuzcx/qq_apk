import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bmfm
  extends Handler
{
  bmfm(bmfk parambmfk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      bmfk.b(this.a);
      bmfk.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfm
 * JD-Core Version:    0.7.0.1
 */