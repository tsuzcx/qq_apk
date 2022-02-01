package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class c
{
  public final StringBuilder a = new StringBuilder();
  public String b = null;
  public String c = "HMS";
  public int d = 0;
  public long e = 0L;
  public long f = 0L;
  public String g;
  public int h;
  public int i;
  public int j = 0;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.j = paramInt1;
    this.b = paramString1;
    this.d = paramInt2;
    if (paramString2 != null) {
      this.c = paramString2;
    }
    b();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return String.valueOf(paramInt);
          }
          return "E";
        }
        return "W";
      }
      return "I";
    }
    return "D";
  }
  
  public <T> c a(T paramT)
  {
    this.a.append(paramT);
    return this;
  }
  
  public c a(Throwable paramThrowable)
  {
    a(Character.valueOf('\n')).a(Log.getStackTraceString(paramThrowable));
    return this;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.a.toString());
    return paramStringBuilder;
  }
  
  public final c b()
  {
    this.e = System.currentTimeMillis();
    Object localObject = Thread.currentThread();
    this.f = ((Thread)localObject).getId();
    this.h = Process.myPid();
    localObject = ((Thread)localObject).getStackTrace();
    int k = localObject.length;
    int m = this.j;
    if (k > m)
    {
      localObject = localObject[m];
      this.g = ((StackTraceElement)localObject).getFileName();
      this.i = ((StackTraceElement)localObject).getLineNumber();
    }
    return this;
  }
  
  public final StringBuilder b(StringBuilder paramStringBuilder)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    paramStringBuilder.append('[');
    paramStringBuilder.append(((SimpleDateFormat)localObject).format(Long.valueOf(this.e)));
    localObject = a(this.d);
    paramStringBuilder.append(' ');
    paramStringBuilder.append((String)localObject);
    paramStringBuilder.append('/');
    paramStringBuilder.append(this.c);
    paramStringBuilder.append('/');
    paramStringBuilder.append(this.b);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.h);
    paramStringBuilder.append(':');
    paramStringBuilder.append(this.f);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.g);
    paramStringBuilder.append(':');
    paramStringBuilder.append(this.i);
    paramStringBuilder.append(']');
    return paramStringBuilder;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.base.log.c
 * JD-Core Version:    0.7.0.1
 */