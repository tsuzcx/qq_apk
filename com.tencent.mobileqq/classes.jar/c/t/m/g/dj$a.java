package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class dj$a
  extends Handler
{
  public dj$a(dj paramdj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    try
    {
      this.a.a(paramMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!co.e()) {}
      this.a.c();
      co.a("handleInnerMessage[" + paramMessage.what + "] error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.dj.a
 * JD-Core Version:    0.7.0.1
 */