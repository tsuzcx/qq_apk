import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ProgressBar;

class arhb
  extends Handler
{
  arhb(args paramargs, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (args.a(this.a).getVisibility() != 0) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
    } while ((i < args.b(this.a)) || (i > 100));
    args.b(this.a, i);
    args.a(this.a).setProgress(args.b(this.a));
    paramMessage = Message.obtain();
    if (args.b(this.a) >= 90) {
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
 * Qualified Name:     arhb
 * JD-Core Version:    0.7.0.1
 */