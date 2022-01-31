package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ec$a
  extends Handler
{
  private ec$a(ec paramec, Looper paramLooper)
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
    paramMessage = fg.a(ec.a(this.a));
    ec.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ec.a
 * JD-Core Version:    0.7.0.1
 */