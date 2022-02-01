package com.tencent.luggage.wxa.ap;

import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.j.d;

public final class g$a
{
  private final Handler a;
  private final g b;
  
  public g$a(Handler paramHandler, g paramg)
  {
    if (paramg != null) {
      paramHandler = (Handler)a.a(paramHandler);
    } else {
      paramHandler = null;
    }
    this.a = paramHandler;
    this.b = paramg;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if (this.b != null) {
      this.a.post(new g.a.5(this, paramInt1, paramInt2, paramInt3, paramFloat));
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.b != null) {
      this.a.post(new g.a.4(this, paramInt, paramLong));
    }
  }
  
  public void a(Surface paramSurface)
  {
    if (this.b != null) {
      this.a.post(new g.a.6(this, paramSurface));
    }
  }
  
  public void a(k paramk)
  {
    if (this.b != null) {
      this.a.post(new g.a.3(this, paramk));
    }
  }
  
  public void a(d paramd)
  {
    if (this.b != null) {
      this.a.post(new g.a.1(this, paramd));
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.b != null) {
      this.a.post(new g.a.2(this, paramString, paramLong1, paramLong2));
    }
  }
  
  public void b(d paramd)
  {
    if (this.b != null) {
      this.a.post(new g.a.7(this, paramd));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.g.a
 * JD-Core Version:    0.7.0.1
 */