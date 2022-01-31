package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class eg$a
  extends Handler
{
  private eg$a(eg parameg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (!this.a.a) {
      return;
    }
    sendEmptyMessageDelayed(0, 30000L);
    paramMessage = fj.a(eg.a(this.a));
    eg.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.eg.a
 * JD-Core Version:    0.7.0.1
 */