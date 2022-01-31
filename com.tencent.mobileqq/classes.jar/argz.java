import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ProgressBar;

class argz
  extends Handler
{
  argz(argq paramargq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (argq.a(this.a).getVisibility() != 0) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
    } while ((i < argq.b(this.a)) || (i > 100));
    argq.b(this.a, i);
    argq.a(this.a).setProgress(argq.b(this.a));
    paramMessage = Message.obtain();
    if (argq.b(this.a) >= 90) {
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
 * Qualified Name:     argz
 * JD-Core Version:    0.7.0.1
 */