import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;

class bcje
  extends Handler
{
  bcje(bcjd parambcjd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(0.0F, 0 - bcjd.a(this.a).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcje
 * JD-Core Version:    0.7.0.1
 */