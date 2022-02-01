package com.tencent.luggage.wxa.rz;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.sj.d;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  implements b, g
{
  public static g a;
  public static b b;
  private AtomicBoolean c = new AtomicBoolean(false);
  private a d;
  private final com.tencent.luggage.wxa.si.e e;
  
  private f(@NonNull a parama)
  {
    this.d = parama;
    this.e = new com.tencent.luggage.wxa.si.e(parama);
  }
  
  private d<?> a(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return (d)com.tencent.luggage.wxa.se.e.a(paramRunnable).a(new f.5(this, paramLong1, paramLong2, paramBoolean)).a(new f.4(this)).b();
  }
  
  private d<?> a(Runnable paramRunnable, long paramLong, String paramString, boolean paramBoolean)
  {
    return (d)com.tencent.luggage.wxa.se.e.a(paramRunnable).a(new f.3(this, paramLong, paramString)).a(new f.2(this, paramBoolean)).b();
  }
  
  private d<?> a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    return (d)com.tencent.luggage.wxa.se.e.a(paramRunnable).a(new f.7(this, paramLong)).a(new f.6(this, paramBoolean)).b();
  }
  
  static void a(Context paramContext, a parama)
  {
    try
    {
      paramContext = new f(parama);
      a = paramContext;
      b = paramContext;
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private d<?> c(Runnable paramRunnable, long paramLong, String paramString)
  {
    return (d)com.tencent.luggage.wxa.se.e.a(paramRunnable).a(new f.9(this, paramLong, paramString)).a(new f.8(this)).b();
  }
  
  private d<?> d(Runnable paramRunnable, long paramLong, String paramString)
  {
    return (d)com.tencent.luggage.wxa.se.e.a(paramRunnable).a(new f.11(this, paramLong, paramString)).a(new f.10(this)).b();
  }
  
  private d<?> e(Runnable paramRunnable, long paramLong)
  {
    return (d)com.tencent.luggage.wxa.se.e.a(paramRunnable).a(new f.1(this, paramLong)).a(new f.12(this)).b();
  }
  
  public d<?> a(@NonNull Runnable paramRunnable)
  {
    paramRunnable.getClass();
    return a(paramRunnable, 0L, false);
  }
  
  public d<?> a(@NonNull Runnable paramRunnable, long paramLong)
  {
    paramRunnable.getClass();
    return a(paramRunnable, paramLong, false);
  }
  
  public d<?> a(@NonNull Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    paramRunnable.getClass();
    return a(paramRunnable, paramLong1, paramLong2, false);
  }
  
  public d<?> a(@NonNull Runnable paramRunnable, long paramLong, String paramString)
  {
    paramRunnable.getClass();
    return a(paramRunnable, paramLong, paramString, false);
  }
  
  public d<?> a(@NonNull Runnable paramRunnable, String paramString)
  {
    paramRunnable.getClass();
    return a(paramRunnable, 0L, paramString);
  }
  
  public boolean a()
  {
    return this.c.get();
  }
  
  public d<?> b(@NonNull Runnable paramRunnable)
  {
    paramRunnable.getClass();
    return a(paramRunnable, 0L, true);
  }
  
  public d<?> b(@NonNull Runnable paramRunnable, long paramLong)
  {
    paramRunnable.getClass();
    return e(paramRunnable, paramLong);
  }
  
  public d<?> b(@NonNull Runnable paramRunnable, long paramLong, String paramString)
  {
    paramRunnable.getClass();
    return d(paramRunnable, paramLong, paramString);
  }
  
  public d<?> b(@NonNull Runnable paramRunnable, String paramString)
  {
    paramRunnable.getClass();
    return a(paramRunnable, 0L, paramString, true);
  }
  
  public d<?> c(@NonNull Runnable paramRunnable)
  {
    paramRunnable.getClass();
    return b(paramRunnable, 0L);
  }
  
  public d<?> c(@NonNull Runnable paramRunnable, long paramLong)
  {
    paramRunnable.getClass();
    return c(paramRunnable, paramLong, null);
  }
  
  public d<?> c(@NonNull Runnable paramRunnable, String paramString)
  {
    paramRunnable.getClass();
    return b(paramRunnable, 0L, paramString);
  }
  
  public d<?> d(@NonNull Runnable paramRunnable)
  {
    paramRunnable.getClass();
    return c(paramRunnable, 0L);
  }
  
  public d<?> d(@NonNull Runnable paramRunnable, long paramLong)
  {
    paramRunnable.getClass();
    return d(paramRunnable, paramLong, null);
  }
  
  public d<?> e(@NonNull Runnable paramRunnable)
  {
    paramRunnable.getClass();
    return d(paramRunnable, 0L);
  }
  
  public d<?> f(@NonNull Runnable paramRunnable)
  {
    return d(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rz.f
 * JD-Core Version:    0.7.0.1
 */