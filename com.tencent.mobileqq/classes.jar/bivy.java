import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.ClickableToastView;

public class bivy
  extends Handler
{
  public bivy(ClickableToastView paramClickableToastView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivy
 * JD-Core Version:    0.7.0.1
 */