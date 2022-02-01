package com.tencent.magicbrush.handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.gk.e;
import java.util.concurrent.Callable;

public class c
  implements a
{
  private a a;
  
  public c(long paramLong, a parama)
  {
    this.a = parama;
  }
  
  public <T> T a(@NonNull Callable<T> paramCallable)
  {
    paramCallable = new e(paramCallable);
    b(paramCallable);
    return paramCallable.c();
  }
  
  public void a(@NonNull Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void a(@NonNull Runnable paramRunnable, boolean paramBoolean)
  {
    this.a.a(paramRunnable, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  @Nullable
  public String b()
  {
    return this.a.b();
  }
  
  public void b(@NonNull Runnable paramRunnable)
  {
    if (this.a.a())
    {
      paramRunnable.run();
      return;
    }
    this.a.a(paramRunnable, false);
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public boolean d()
  {
    return this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.c
 * JD-Core Version:    0.7.0.1
 */