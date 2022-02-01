package com.tencent.luggage.wxa.z;

import android.os.Handler;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.h.b;
import com.tencent.luggage.wxa.h.k;
import java.io.IOException;

public final class a$a
{
  private final Handler a;
  private final a b;
  private final long c;
  
  public a$a(Handler paramHandler, a parama)
  {
    this(paramHandler, parama, 0L);
  }
  
  public a$a(Handler paramHandler, a parama, long paramLong)
  {
    if (parama != null) {
      paramHandler = (Handler)com.tencent.luggage.wxa.ao.a.a(paramHandler);
    } else {
      paramHandler = null;
    }
    this.a = paramHandler;
    this.b = parama;
    this.c = paramLong;
  }
  
  private long a(long paramLong)
  {
    paramLong = b.a(paramLong);
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    return this.c + paramLong;
  }
  
  public void a()
  {
    this.a.post(new a.a.6(this));
  }
  
  public void a(int paramInt1, k paramk, int paramInt2, Object paramObject, long paramLong)
  {
    if (this.b != null) {
      this.a.post(new a.a.5(this, paramInt1, paramk, paramInt2, paramObject, paramLong));
    }
  }
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.b != null) {
      this.a.post(new a.a.1(this, paramj, paramInt1, paramInt2, paramk, paramInt3, paramObject, paramLong1, paramLong2, paramLong3));
    }
  }
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if (this.b != null) {
      this.a.post(new a.a.2(this, paramj, paramInt1, paramInt2, paramk, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
  }
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    if (this.b != null) {
      this.a.post(new a.a.4(this, paramj, paramInt1, paramInt2, paramk, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramIOException, paramBoolean));
    }
  }
  
  public void a(j paramj, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramj, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
  }
  
  public void a(j paramj, int paramInt, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
  {
    a(paramj, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
  }
  
  public void b(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if (this.b != null) {
      this.a.post(new a.a.3(this, paramj, paramInt1, paramInt2, paramk, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
  }
  
  public void b(j paramj, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    b(paramj, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.a.a
 * JD-Core Version:    0.7.0.1
 */