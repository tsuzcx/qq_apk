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
      if (co.e())
      {
        this.a.c();
        StringBuilder localStringBuilder = new StringBuilder("handleInnerMessage[");
        localStringBuilder.append(paramMessage.what);
        localStringBuilder.append("] error.");
        co.a(localStringBuilder.toString(), localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dj.a
 * JD-Core Version:    0.7.0.1
 */