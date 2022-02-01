package c.t.m.sapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class e$a
  extends Handler
{
  public StringBuilder a = new StringBuilder(1024);
  
  public e$a(e parame, Looper paramLooper)
  {
    super(paramLooper);
    this.a.setLength(0);
  }
  
  public void a(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 10008: 
        q.a(e.a(this.b));
        return;
      }
    }
    catch (Throwable paramMessage)
    {
      return;
    }
    g.a(e.a(this.b));
    return;
    return;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.e.a
 * JD-Core Version:    0.7.0.1
 */