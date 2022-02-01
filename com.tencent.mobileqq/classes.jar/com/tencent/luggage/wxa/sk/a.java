package com.tencent.luggage.wxa.sk;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  private static final ThreadLocal<a> a = new ThreadLocal();
  private static a b = null;
  private static final ConcurrentHashMap<String, a> c = new ConcurrentHashMap();
  private static final AtomicLong d = new AtomicLong(0L);
  private final String e;
  private final d f;
  private int g = 0;
  
  private a(String paramString)
  {
    this.e = paramString;
    this.f = new d(new b(new a.1(this)));
    c.put(this.e, this);
  }
  
  public static a a()
  {
    if (b == null) {
      b = a(Looper.getMainLooper());
    }
    return b;
  }
  
  public static a a(Looper paramLooper)
  {
    String str = b(paramLooper);
    a locala = (a)c.get(str);
    paramLooper = locala;
    if (locala == null) {
      paramLooper = new a(str);
    }
    return paramLooper;
  }
  
  public static a a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("@");
    localStringBuilder.append(d.getAndIncrement());
    return new a(localStringBuilder.toString());
  }
  
  static void a(a parama)
  {
    a.set(parama);
  }
  
  public static a b()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      return a();
    }
    return (a)a.get();
  }
  
  static a b(String paramString)
  {
    try
    {
      a locala2 = (a)c.get(paramString);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(paramString);
      }
      return locala1;
    }
    finally {}
  }
  
  public static String b(Looper paramLooper)
  {
    if (paramLooper == null) {
      return null;
    }
    paramLooper = paramLooper.getThread();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLooper.getName());
    localStringBuilder.append("@");
    localStringBuilder.append(paramLooper.getId());
    return localStringBuilder.toString();
  }
  
  public static String c()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      return a().e();
    }
    a locala = (a)a.get();
    if (locala == null) {
      return null;
    }
    return locala.e();
  }
  
  public d d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return ((a)paramObject).e().equals(e());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.e.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.a
 * JD-Core Version:    0.7.0.1
 */