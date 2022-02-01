package c.t.m.sapp.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e
{
  public static final byte[] a = new byte[0];
  public static e b;
  public final String c = "DexAsynchHandler";
  public HandlerThread d;
  public e.a e;
  public boolean f;
  public Context g;
  public k h;
  public SimpleDateFormat i = new SimpleDateFormat("HHmmss");
  public SimpleDateFormat j = new SimpleDateFormat("yyyyMMdd-HHmmss");
  
  public e(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    this.h = new k(this.g);
  }
  
  public static e a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new e(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public static e b()
  {
    return b;
  }
  
  public void a()
  {
    if (this.g == null) {
      return;
    }
    a(10005, null);
  }
  
  public final void a(int paramInt, String paramString)
  {
    e.a locala = this.e;
    if (locala != null)
    {
      Message localMessage = locala.obtainMessage();
      localMessage.obj = paramString;
      localMessage.what = paramInt;
      o.a(locala, localMessage);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if ((this.g != null) && (this.e != null) && (paramString != null))
      {
        if (paramString.length() == 0) {
          return;
        }
        p.a = 3000;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LOC_CORE");
        localStringBuilder.append(',');
        localStringBuilder.append(this.j.format(new Date()));
        localStringBuilder.append(',');
        localStringBuilder.append(q.h(this.g));
        localStringBuilder.append(',');
        localStringBuilder.append(q.l(this.g));
        localStringBuilder.append(',');
        localStringBuilder.append(q.e());
        localStringBuilder.append(',');
        localStringBuilder.append(q.f());
        localStringBuilder.append(',');
        localStringBuilder.append(q.b());
        localStringBuilder.append(',');
        localStringBuilder.append("COMP");
        localStringBuilder.append(paramString);
        localStringBuilder.append("$");
        a(localStringBuilder.toString().getBytes());
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      int k = paramArrayOfByte.length;
      if (k == 0) {
        return true;
      }
      paramArrayOfByte = a(paramArrayOfByte, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
      if (paramArrayOfByte != null)
      {
        k = paramArrayOfByte.length;
        if (k == 0) {
          return true;
        }
        if (p.a("https://analytics.map.qq.com/tr?mllc", paramArrayOfByte) != null) {
          return false;
        }
        this.h.a(paramArrayOfByte);
        return false;
      }
      return true;
    }
    catch (Throwable paramArrayOfByte) {}
    return true;
    return false;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      paramArrayOfByte = m.b(q.b(paramArrayOfByte), paramString);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        paramString = new byte[paramArrayOfByte.length + 2];
        System.arraycopy(q.a(paramArrayOfByte.length), 0, paramString, 0, 2);
        System.arraycopy(paramArrayOfByte, 0, paramString, 2, paramArrayOfByte.length);
        return paramString;
      }
      return a;
    }
    return a;
  }
  
  public void c()
  {
    if (this.f) {
      return;
    }
    this.d = new HandlerThread("d_thread");
    this.d.start();
    this.e = new e.a(this, this.d.getLooper());
    this.f = true;
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.e
 * JD-Core Version:    0.7.0.1
 */