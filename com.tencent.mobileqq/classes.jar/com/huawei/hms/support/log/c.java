package com.huawei.hms.support.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class c
{
  private final StringBuilder a = new StringBuilder();
  private String b = null;
  private String c = "HMS";
  private int d = 0;
  private long e = 0L;
  private long f = 0L;
  private String g;
  private int h;
  private int i;
  private int j = 0;
  
  c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.j = paramInt1;
    this.b = paramString1;
    this.d = paramInt2;
    if (paramString2 != null) {
      this.c = paramString2;
    }
    c();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 3: 
      return "D";
    case 4: 
      return "I";
    case 5: 
      return "W";
    }
    return "E";
  }
  
  private StringBuilder a(StringBuilder paramStringBuilder)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    paramStringBuilder.append('[');
    paramStringBuilder.append(((SimpleDateFormat)localObject).format(Long.valueOf(this.e)));
    localObject = a(this.d);
    paramStringBuilder.append(' ').append((String)localObject).append('/').append(this.c).append('/').append(this.b);
    paramStringBuilder.append(' ').append(this.h).append(':').append(this.f);
    paramStringBuilder.append(' ').append(this.g).append(':').append(this.i);
    paramStringBuilder.append(']');
    return paramStringBuilder;
  }
  
  private StringBuilder b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(' ').append(this.a.toString());
    return paramStringBuilder;
  }
  
  private c c()
  {
    this.e = System.currentTimeMillis();
    Object localObject = Thread.currentThread();
    this.f = ((Thread)localObject).getId();
    this.h = Process.myPid();
    localObject = ((Thread)localObject).getStackTrace();
    if (localObject.length > this.j)
    {
      localObject = localObject[this.j];
      this.g = ((StackTraceElement)localObject).getFileName();
      this.i = ((StackTraceElement)localObject).getLineNumber();
    }
    return this;
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
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder);
    b(localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.log.c
 * JD-Core Version:    0.7.0.1
 */