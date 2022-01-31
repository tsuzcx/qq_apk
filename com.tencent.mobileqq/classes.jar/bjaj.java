import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bjaj
  extends Handler
{
  bjaj(bjah parambjah, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      bjah.b(this.a);
      bjah.a(this.a).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjaj
 * JD-Core Version:    0.7.0.1
 */