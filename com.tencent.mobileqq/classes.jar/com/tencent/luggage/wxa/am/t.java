package com.tencent.luggage.wxa.am;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class t
{
  private final ExecutorService a;
  private t.b<? extends t.c> b;
  private IOException c;
  
  public t(String paramString)
  {
    this.a = x.a(paramString);
  }
  
  public <T extends t.c> long a(T paramT, t.a<T> parama, int paramInt)
  {
    Looper localLooper = Looper.myLooper();
    boolean bool;
    if (localLooper != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    long l = SystemClock.elapsedRealtime();
    new t.b(this, localLooper, paramT, parama, paramInt, l).a(0L);
    return l;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = this.b;
      if (localObject != null)
      {
        int i = paramInt;
        if (paramInt == -2147483648) {
          i = ((t.b)localObject).a;
        }
        ((t.b)localObject).a(i);
      }
      return;
    }
    throw ((Throwable)localObject);
  }
  
  public boolean a()
  {
    return this.b != null;
  }
  
  public boolean a(t.d paramd)
  {
    t.b localb = this.b;
    boolean bool = true;
    if (localb != null)
    {
      localb.a(true);
      if (paramd != null) {
        this.a.execute(new t.e(paramd));
      }
    }
    else if (paramd != null)
    {
      paramd.g();
      break label55;
    }
    bool = false;
    label55:
    this.a.shutdown();
    return bool;
  }
  
  public void b()
  {
    this.b.a(false);
  }
  
  public void c()
  {
    a(null);
  }
  
  public void d()
  {
    a(-2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.t
 * JD-Core Version:    0.7.0.1
 */