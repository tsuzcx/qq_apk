package c.t.m.g;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Timer;

public final class dr
{
  private String A = "5.6.0.4";
  private String B = "191221";
  private String C = "5.6.0.4";
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public String j;
  public long k;
  public boolean l = true;
  public boolean m = true;
  public boolean n = true;
  public int o = -2;
  private final dx p;
  private String q;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private long y = 20000L;
  private long z = 30000L;
  
  public dr(dx paramdx)
  {
    this.p = paramdx;
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
    for (paramHandler = new Timer("th_quit_delay");; paramHandler = null)
    {
      paramHandlerThread = new dr.1(paramHandlerThread, localHandler, paramHandler);
      if (localHandler == null) {
        break;
      }
      localHandler.postDelayed(paramHandlerThread, paramLong);
      return;
    }
    paramHandler.schedule(paramHandlerThread, paramLong);
  }
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "0123456789ABCDEF";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.e)) || (this.e.contains("0000"))) {
      return "0123456789ABCDEF";
    }
    return this.e;
  }
  
  public final String d()
  {
    if (this.A == null) {
      return "None";
    }
    return this.A;
  }
  
  public final String e()
  {
    if (this.B == null) {
      return "None";
    }
    return this.B;
  }
  
  public final String f()
  {
    if (this.q == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(a()).append("_").append(b()).append("_").append(c()).append("_QQGeoLocation");
      this.q = co.c(localStringBuilder.toString());
    }
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dr
 * JD-Core Version:    0.7.0.1
 */