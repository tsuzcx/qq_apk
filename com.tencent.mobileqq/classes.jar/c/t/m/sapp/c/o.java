package c.t.m.sapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class o
{
  public static boolean a(Handler paramHandler)
  {
    if (paramHandler == null) {
      paramHandler = null;
    } else {
      paramHandler = paramHandler.getLooper();
    }
    return a(paramHandler);
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage)
  {
    return a(paramHandler, paramMessage, 0L);
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    if ((paramMessage != null) && (a(paramHandler))) {
      return paramHandler.sendMessageDelayed(paramMessage, paramLong);
    }
    return false;
  }
  
  public static boolean a(Looper paramLooper)
  {
    return (paramLooper != null) && (paramLooper.getThread().isAlive());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.o
 * JD-Core Version:    0.7.0.1
 */