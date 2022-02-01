package com.tencent.luggage.wxa.i;

import android.os.Handler;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.j.d;

public final class e$a
{
  private final Handler a;
  private final e b;
  
  public e$a(Handler paramHandler, e parame)
  {
    if (parame != null) {
      paramHandler = (Handler)a.a(paramHandler);
    } else {
      paramHandler = null;
    }
    this.a = paramHandler;
    this.b = parame;
  }
  
  public void a(int paramInt)
  {
    if (this.b != null) {
      this.a.post(new e.a.6(this, paramInt));
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.b != null) {
      this.a.post(new e.a.4(this, paramInt, paramLong1, paramLong2));
    }
  }
  
  public void a(k paramk)
  {
    if (this.b != null) {
      this.a.post(new e.a.3(this, paramk));
    }
  }
  
  public void a(d paramd)
  {
    if (this.b != null) {
      this.a.post(new e.a.1(this, paramd));
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.b != null) {
      this.a.post(new e.a.2(this, paramString, paramLong1, paramLong2));
    }
  }
  
  public void b(d paramd)
  {
    if (this.b != null) {
      this.a.post(new e.a.5(this, paramd));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.e.a
 * JD-Core Version:    0.7.0.1
 */