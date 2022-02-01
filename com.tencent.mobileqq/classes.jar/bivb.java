import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;

class bivb
  extends Handler
{
  bivb(biva parambiva, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(0.0F, 0 - biva.a(this.a).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivb
 * JD-Core Version:    0.7.0.1
 */