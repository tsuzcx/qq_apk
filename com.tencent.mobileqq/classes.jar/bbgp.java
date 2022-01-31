import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.CircleProgressBar;

public class bbgp
  extends Handler
{
  public bbgp(CircleProgressBar paramCircleProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = this.a;
      paramMessage.i += 3;
      this.a.postInvalidate();
    } while (!this.a.a);
    sendEmptyMessageDelayed(10000, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbgp
 * JD-Core Version:    0.7.0.1
 */