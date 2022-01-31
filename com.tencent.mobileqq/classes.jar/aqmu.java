import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ProgressBar;

class aqmu
  extends Handler
{
  aqmu(aqml paramaqml, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (aqml.a(this.a).getVisibility() != 0) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
    } while ((i < aqml.b(this.a)) || (i > 100));
    aqml.b(this.a, i);
    aqml.a(this.a).setProgress(aqml.b(this.a));
    paramMessage = Message.obtain();
    if (aqml.b(this.a) >= 90) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmu
 * JD-Core Version:    0.7.0.1
 */