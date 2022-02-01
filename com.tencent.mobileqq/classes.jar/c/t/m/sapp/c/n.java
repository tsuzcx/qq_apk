package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class n
  implements Thread.UncaughtExceptionHandler
{
  public static final String a = TencentLocation.class.getPackage().getName();
  public static n b = null;
  public Context c;
  public Thread.UncaughtExceptionHandler d;
  public volatile boolean e = false;
  public CountDownLatch f;
  
  public n(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static n a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new n(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a()
  {
    if (!this.e)
    {
      this.d = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(b);
      this.e = true;
    }
  }
  
  public final boolean a(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    if (paramThrowable == null) {
      return false;
    }
    while (localThrowable != null)
    {
      paramThrowable = localThrowable.getStackTrace();
      int j = paramThrowable.length;
      int i = 0;
      while (i < j)
      {
        if ("TLSAPP".equals(paramThrowable[i].getFileName())) {
          return true;
        }
        i += 1;
      }
      localThrowable = localThrowable.getCause();
    }
    return false;
  }
  
  public final String b(Throwable paramThrowable)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
        paramThrowable.printStackTrace(localPrintWriter);
      }
      localPrintWriter.close();
      localStringBuffer.append(localStringWriter.toString());
    }
    catch (Throwable paramThrowable)
    {
      label69:
      break label69;
    }
    return localStringBuffer.toString();
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject;
    if ((a(paramThrowable)) && (this.c != null))
    {
      localObject = b(paramThrowable);
      if ((!((String)localObject).contains("onLocationChanged")) && (!((String)localObject).contains("onStatusUpdate")))
      {
        q.b(this.c, "__bad_dex_info___sapp", q.d);
        q.b(this.c, "__loc_sdk_run_duration___sapp", Long.valueOf(System.currentTimeMillis() - q.e));
        paramThread = new StringBuilder();
        paramThread.append("EXP:");
        paramThread.append(q.d);
        paramThread.append(",");
        paramThread.append((String)localObject);
        paramThrowable = paramThread.toString();
        paramThread = paramThrowable;
        if (paramThrowable.contains("\n")) {
          paramThread = paramThrowable.replaceAll("\n", "$");
        }
        this.f = new CountDownLatch(1);
        new n.a(this, paramThread).start();
      }
    }
    try
    {
      this.f.await(3000L, TimeUnit.MILLISECONDS);
      label174:
      TencentLocationManager.getInstance(this.c).removeUpdates(null);
      return;
      localObject = this.d;
      if (localObject != null) {
        ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
    catch (InterruptedException paramThread)
    {
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.n
 * JD-Core Version:    0.7.0.1
 */