package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class di$a
  extends Handler
{
  public di$a(di paramdi, Looper paramLooper)
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
    catch (Throwable paramMessage)
    {
      while (!co.e()) {}
      this.a.c();
      co.a("handleInnerMessage error.", paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.di.a
 * JD-Core Version:    0.7.0.1
 */