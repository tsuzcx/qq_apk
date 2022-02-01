package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ef$a
  extends Handler
{
  private ef$a(ef paramef, Looper paramLooper)
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
    paramMessage = fj.a(ef.a(this.a));
    ef.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ef.a
 * JD-Core Version:    0.7.0.1
 */