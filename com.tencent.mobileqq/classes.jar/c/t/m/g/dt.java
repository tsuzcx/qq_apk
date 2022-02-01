package c.t.m.g;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.io.Closeable;
import java.util.Timer;

public final class dt
{
  public String a;
  public String b;
  public String c;
  
  public dt(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString2;
    this.b = paramString1;
    this.c = paramString3;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  static void a(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      try
      {
        if (Build.VERSION.SDK_INT >= 18)
        {
          paramHandlerThread.quitSafely();
          return;
        }
        paramHandlerThread.quit();
        return;
      }
      catch (Throwable paramHandlerThread)
      {
        if (co.e()) {
          co.a("quit error.", paramHandlerThread);
        }
      }
    }
  }
  
  public static void a(HandlerThread paramHandlerThread, Handler paramHandler, long paramLong)
  {
    if ((paramHandlerThread == null) && (paramHandler == null)) {
      return;
    }
    if (paramLong <= 0L)
    {
      a(paramHandlerThread);
      return;
    }
    Handler localHandler = paramHandler;
    if (paramHandler == null)
    {
      localHandler = paramHandler;
      if (Looper.myLooper() != null) {
        localHandler = new Handler(Looper.myLooper());
      }
    }
    if (localHandler == null) {}
    for (paramHandler = new Timer("th_loc_tmp");; paramHandler = null)
    {
      paramHandlerThread = new dt.1(paramHandlerThread, localHandler, paramHandler);
      if (localHandler == null) {
        break;
      }
      localHandler.postDelayed(paramHandlerThread, paramLong);
      return;
    }
    paramHandler.schedule(paramHandlerThread, paramLong);
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.dt
 * JD-Core Version:    0.7.0.1
 */