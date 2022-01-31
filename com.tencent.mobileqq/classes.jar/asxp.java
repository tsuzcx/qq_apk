import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ProgressBar;

class asxp
  extends Handler
{
  asxp(asxg paramasxg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (asxg.a(this.a).getVisibility() != 0) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
    } while ((i < asxg.b(this.a)) || (i > 100));
    asxg.b(this.a, i);
    asxg.a(this.a).setProgress(asxg.b(this.a));
    paramMessage = Message.obtain();
    if (asxg.b(this.a) >= 90) {
      i += 1;
    }
    for (;;)
    {
      paramMessage.arg1 = i;
      sendMessageDelayed(paramMessage, 500L);
      return;
      i += 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxp
 * JD-Core Version:    0.7.0.1
 */